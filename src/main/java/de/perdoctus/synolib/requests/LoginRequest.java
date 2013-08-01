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

/**
 * @author Christoph Giesche
 */
public class LoginRequest extends DownloadRedirectorRequest {

    private final static String ACTION = "login";

    public LoginRequest(String username, String password) {
        super("POST");

        requestParams.add(new KeyValue("action", ACTION));
        requestParams.add(new KeyValue("username", username));
        requestParams.add(new KeyValue("passwd", password));
    }

}
