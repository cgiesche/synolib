package de.perdoctus.synolib.exceptions;

/**
 * User: cgiesche
 * Date: 2/24/12
 * Time: 5:01 PM
 */
public class LoginException extends SynoException {
    public LoginException(String message) {
        super(message);
    }
    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
