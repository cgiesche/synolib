package de.perdoctus.synolib.responses;

/**
 * User: cgiesche
 * Date: 2/24/12
 * Time: 3:35 PM
 */
public abstract class DownloadRedirectorResponse {
    private boolean success;
    private String errcode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public String getErrcode() {
		return errcode;
	}
    
    public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
}
