/*
 * Copyright 2014 Christoph Giesche
 *
 * This file is part of synolib.
 *
 * synolib is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * synolib is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with synolib.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.perdoctus.synolib;

import at.co.blogspot.javaskeleton.WebClientDevWrapper;
import de.perdoctus.synolib.exceptions.CommunicationException;
import de.perdoctus.synolib.exceptions.SynoException;
import de.perdoctus.synolib.requests.DownloadRedirectorRequest;
import de.perdoctus.synolib.requests.KeyValue;
import de.perdoctus.synolib.responses.DownloadRedirectorResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Christoph Giesche
 */
public class RequestExecutor {

    private HttpClient httpClient;
    private final URI targetURI;

    private static final Logger LOG = Logger.getLogger(RequestExecutor.class);

	public RequestExecutor(final URI targetURI) {
		this.targetURI = targetURI;
    }

	public <T extends DownloadRedirectorResponse> T executeRequest(final DownloadRedirectorRequest drRequest, final Class<T> clazz) throws SynoException {

		LOG.debug("Executing DR-Request: " + drRequest.getClass().getSimpleName());

        if (this.targetURI == null) {
            throw new SynoException("");
        }
        if (this.httpClient == null) {
            this.httpClient = new DefaultHttpClient();
            WebClientDevWrapper.wrapClient(httpClient);
        }

		final HttpUriRequest request;
		if (drRequest.getHttpMethod().equalsIgnoreCase("POST")) {
			final HttpPost postRequest = new HttpPost(targetURI);

			final List<NameValuePair> params = new ArrayList<NameValuePair>();
			for (final KeyValue param : drRequest.getRequestParams()) {
				params.add(new BasicNameValuePair(param.getKey(), param.getValue()));
            }

			final HttpEntity entity;
			try {
                entity = new UrlEncodedFormEntity(params, "UTF-8");
			} catch (final UnsupportedEncodingException ex) {
				throw new RuntimeException(ex);
            }

            postRequest.setEntity(entity);
            request = postRequest;
        } else if (drRequest.getHttpMethod().equalsIgnoreCase("GET")) {
			final String queryParams = StringUtils.join(drRequest.getRequestParams(), '&');
			request = new HttpGet(targetURI + "?" + queryParams);
        } else {
            throw new RuntimeException("Method " + drRequest.getHttpMethod() + " not supported yet!");
        }

		final HttpResponse response;
		try {
            response = httpClient.execute(request);
		} catch (final IOException ex) {
			throw new CommunicationException("Failed to execute http call.", ex);
        }

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new CommunicationException(response.getStatusLine().getReasonPhrase());
        }

		final ObjectMapper mapper = new ObjectMapper();
		final HttpEntity entity = response.getEntity();

		if (entity == null) {
            throw new CommunicationException("Got no response body!");
        }

		final T drResponse;
		try {
            drResponse = mapper.readValue(entity.getContent(), clazz);
		} catch (final UnrecognizedPropertyException ex) {
			throw new CommunicationException("Failed to parse JSON response!", ex);
		} catch (final IOException ex) {
			throw new CommunicationException("Could not read response body!", ex);
		} catch (final IllegalStateException ex) {
			throw new CommunicationException("Could not read response body stream!", ex);
        }

        return drResponse;
    }

}
