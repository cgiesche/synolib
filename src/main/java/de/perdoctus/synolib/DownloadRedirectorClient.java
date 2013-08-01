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

package de.perdoctus.synolib;

import de.perdoctus.synolib.exceptions.CommunicationException;
import de.perdoctus.synolib.exceptions.LoginException;
import de.perdoctus.synolib.exceptions.SynoException;
import de.perdoctus.synolib.requests.AddUrlRequest;
import de.perdoctus.synolib.requests.GetAllRequest;
import de.perdoctus.synolib.requests.LoginRequest;
import de.perdoctus.synolib.responses.AddUrlResponse;
import de.perdoctus.synolib.responses.GetAllResponse;
import de.perdoctus.synolib.responses.LoginResponse;
import org.apache.commons.lang3.StringUtils;

import java.net.URI;

/**
 * @author Christoph Giesche
 */
public class DownloadRedirectorClient {

    private String username = "";
    private String password = "";

    private RequestExecutor executor;
    private String sessionId;

    public DownloadRedirectorClient() {

    }

    public DownloadRedirectorClient(String username, String password, URI synoUri) {
        this.password = password;
        this.username = username;

        this.executor = new RequestExecutor(synoUri);
    }

    public AddUrlResponse addDownloadUrl(URI uri) throws SynoException {
        if (sessionId == null) {
            login();
        }

        final AddUrlRequest request = new AddUrlRequest(uri, sessionId);

        return executor.executeRequest(request, AddUrlResponse.class);
    }

    public GetAllResponse getAllDownloads() throws SynoException {
        if (sessionId == null) {
            login();
        }

        final GetAllRequest request = new GetAllRequest(sessionId);

        return executor.executeRequest(request, GetAllResponse.class);
    }

    public void forceReloginOnNextRequest() {
        this.sessionId = null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSynoUri(URI uri) {
        this.executor = new RequestExecutor(uri);
    }

    private void login() throws SynoException {
        LoginRequest request = new LoginRequest(username, password);
        LoginResponse response = executor.executeRequest(request, LoginResponse.class);

        if (response.isSuccess()) {
            if (response.isLoginSuccess()) {
                this.sessionId = response.getId();
            } else {
                throw new LoginException("Login failed.");
            }
        } else {
            throw new CommunicationException("LoginRequest failed.");
        }
    }

    @Override
    public String toString() {
        return "DownloadRedirectorClient [username=" + username + ", password="
                + StringUtils.repeat('*', password.length()) + ", sessionId="
                + sessionId + "]";
    }

}
