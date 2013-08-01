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


import java.util.HashSet;
import java.util.Set;

/**
 * @author Christoph Giesche
 */
public abstract class DownloadRedirectorRequest {

    protected final Set<KeyValue> requestParams = new HashSet<KeyValue>();

    private final String httpMethod;

    public DownloadRedirectorRequest(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public Set<KeyValue> getRequestParams() {
        return requestParams;
    }
}
