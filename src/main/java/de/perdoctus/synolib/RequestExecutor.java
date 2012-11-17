/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.perdoctus.synolib;

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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christoph Giesche <christoph.giesche@gmx.net>
 */
public class RequestExecutor {
    
	private static Logger log = Logger.getLogger(RequestExecutor.class);
	
    private HttpClient httpClient;
    private URI targetURI;
    
    public RequestExecutor(URI targetURI) {
        this.targetURI = targetURI;
    }
    
    public <T extends DownloadRedirectorResponse> T executeRequest(DownloadRedirectorRequest drRequest, Class<T> clazz) throws SynoException {

    	log.debug("Executing DR-Request: " + drRequest.getClass().getSimpleName());
    	
        if (this.targetURI == null) {
            throw new SynoException("");
        }
        if (this.httpClient == null) {
            this.httpClient = new DefaultHttpClient();
        }
        
        HttpUriRequest request;
        if (drRequest.getHttpMethod().equalsIgnoreCase("POST")) {
            HttpPost postRequest = new HttpPost(targetURI);
            
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            for (KeyValue param : drRequest.getRequestParams()) {
                params.add(new BasicNameValuePair(param.getKey(), param.getValue()));
            }
            
            HttpEntity entity;
            try {
                entity = new UrlEncodedFormEntity(params, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                throw new RuntimeException(ex);
            }
            
            postRequest.setEntity(entity);
            request = postRequest;
        } else
        if (drRequest.getHttpMethod().equalsIgnoreCase("GET")) {
            String queryParams = StringUtils.join(drRequest.getRequestParams(), '&');
            request = new HttpGet(targetURI + "?" + queryParams);
        } else {
            throw new RuntimeException("Method " + drRequest.getHttpMethod() + " not supported yet!");
        }
        
        HttpResponse response;
        try {
            response = httpClient.execute(request);
        } catch (IOException ex) {
            throw new CommunicationException("Failed to execute http call.", ex);
        } 
        
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new CommunicationException(response.getStatusLine().getReasonPhrase());
        }
        
        ObjectMapper mapper = new ObjectMapper();
        HttpEntity entity = response.getEntity();
        
        if (entity == null) {
            throw new CommunicationException("Got no response body!");
        }
        
        T drResponse;
        try {
            drResponse = mapper.readValue(entity.getContent(), clazz);
        } catch (IOException ex) {
            throw new CommunicationException("Could not read response body!", ex);
        } catch (IllegalStateException ex) {
            throw new CommunicationException("Could not read response body stream!", ex);
        }
        
        return drResponse;
    }
    
}
