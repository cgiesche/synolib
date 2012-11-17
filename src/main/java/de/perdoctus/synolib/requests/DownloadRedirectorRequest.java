package de.perdoctus.synolib.requests;


import java.util.HashSet;
import java.util.Set;

/**
 * User: cgiesche
 * Date: 2/24/12
 * Time: 3:23 PM
 */
public abstract class DownloadRedirectorRequest {

    protected Set<KeyValue> requestParams = new HashSet<KeyValue>();
    private String httpMethod;
    
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
