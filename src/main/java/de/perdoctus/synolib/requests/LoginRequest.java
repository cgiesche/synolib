package de.perdoctus.synolib.requests;

/**
 * User: cgiesche
 * Date: 2/24/12
 * Time: 4:20 PM
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
