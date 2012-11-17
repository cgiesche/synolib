package de.perdoctus.synolib.responses;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * User: cgiesche
 * Date: 2/24/12
 * Time: 4:02 PM
 */
public class LoginResponse extends DownloadRedirectorResponse {
    private String id;
    @JsonProperty("login_success")
    private boolean loginSuccess;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }
}