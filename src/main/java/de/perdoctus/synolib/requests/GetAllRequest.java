/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.perdoctus.synolib.requests;

import de.perdoctus.synolib.responses.LoginResponse;

/**
 *
 * @author Christoph Giesche <christoph.giesche@gmx.net>
 */
public class GetAllRequest extends DownloadRedirectorRequest {
    
    private static final String ACTION = "getall";
    
    public GetAllRequest(LoginResponse response) {
        super("GET");
        
        setParams(response.getId());
    }
    
    public GetAllRequest(String sessionId) {
        super("GET");
        
        setParams(sessionId);
    }
    
    private void setParams(String sessionId) {
        requestParams.add(new KeyValue("action", ACTION));
        requestParams.add(new KeyValue("id", sessionId));
    }
}
