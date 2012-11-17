package de.perdoctus.synolib.exceptions;

/**
 * User: cgiesche
 * Date: 2/24/12
 * Time: 5:03 PM
 */
public class CommunicationException extends SynoException {
    public CommunicationException(String message) {
        super(message);
    }
    public CommunicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
