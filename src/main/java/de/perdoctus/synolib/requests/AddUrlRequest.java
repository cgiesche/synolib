package de.perdoctus.synolib.requests;

import de.perdoctus.synolib.responses.LoginResponse;

import java.net.URI;
import java.net.URL;

/**
 * User: cgiesche
 * Date: 2/24/12
 * Time: 4:40 PM
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
