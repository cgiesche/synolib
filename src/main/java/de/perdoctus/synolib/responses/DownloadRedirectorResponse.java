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

package de.perdoctus.synolib.responses;

/**
 * @author Christoph Giesche
 */
public abstract class DownloadRedirectorResponse {
	private boolean success;
	private String errcode;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(final boolean success) {
		this.success = success;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(final String errcode) {
		this.errcode = errcode;
	}
}
