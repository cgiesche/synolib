/*
 * Copyright 2013 Christoph Giesche
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

package de.perdoctus.synolib.requests;

import de.perdoctus.synolib.responses.LoginResponse;

import java.net.URI;
import java.net.URL;

/**
 * @author Christoph Giesche
 */
public class AddUrlRequest extends DownloadRedirectorRequest {

    private final static String ACTION = "addurl";

    public AddUrlRequest(URI uri, String sessionId) {
        super("POST");

        setParams(uri.toString(), sessionId);
    }

    public AddUrlRequest(URI uri, LoginResponse loginResponse) {
        super("POST");

        setParams(uri.toString(), loginResponse.getId());
    }

    public AddUrlRequest(URL url, String sessionId) {
        super("POST");

        setParams(url.toString(), sessionId);
    }

    public AddUrlRequest(URL url, LoginResponse loginResponse) {
        super("POST");

        setParams(url.toString(), loginResponse.getId());
    }

    private void setParams(String url, String sessionId) {
        requestParams.add(new KeyValue("action", ACTION));
        requestParams.add(new KeyValue("id", sessionId));
        requestParams.add(new KeyValue("url", url));
    }
}
