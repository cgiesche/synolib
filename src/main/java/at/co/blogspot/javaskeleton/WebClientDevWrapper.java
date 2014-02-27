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

package at.co.blogspot.javaskeleton;

import de.perdoctus.synolib.RequestExecutor;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/*
 * http://javaskeleton.blogspot.co.at/2010/07/avoiding-peer-not-authenticated-with.html
 * This code is public domain: you are free to use, link and/or modify it in any way you want, for all purposes including commercial applications.
 */
public class WebClientDevWrapper {
	

    private static final Logger LOG = Logger.getLogger(RequestExecutor.class);


	public static HttpClient wrapClient(final HttpClient base) {
		return wrapClient(base, 443);
	}

	public static HttpClient wrapClient(final HttpClient base, final int port) {
		try {
			final SSLContext ctx = SSLContext.getInstance("TLS");
			final X509TrustManager tm = new X509TrustManager() {

				public void checkClientTrusted(final X509Certificate[] xcs, final String string) throws CertificateException {
				}

				public void checkServerTrusted(final X509Certificate[] xcs, final String string) throws CertificateException {
				}

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
			final X509HostnameVerifier verifier = new X509HostnameVerifier() {

				@Override
				public void verify(final String string, final SSLSocket ssls) throws IOException {
				}

                @Override
				public void verify(final String string, final X509Certificate xc) throws SSLException {
				}

                @Override
				public void verify(final String string, final String[] strings, final String[] strings1) throws SSLException {
				}

                @Override
				public boolean verify(final String string, final SSLSession ssls) {
					return true;
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
			final SSLSocketFactory ssf = new SSLSocketFactory(ctx);
			ssf.setHostnameVerifier(verifier);
			final ClientConnectionManager ccm = base.getConnectionManager();
			final SchemeRegistry sr = ccm.getSchemeRegistry();
			sr.register(new Scheme("https", ssf, port));
            return new DefaultHttpClient(ccm, base.getParams());
		} catch (final Exception ex) {
			LOG.error("Error enabling https-connections", ex);
        	return null;
        }
    }
}
