package de.perdoctus.synolib.exceptions;

/**
 * User: cgiesche
 * Date: 2/24/12
 * Time: 5:04 PM
 */
public class SynoException extends Exception {
    public SynoException(String message) {
        super(message);
    }
    public SynoException(String message, Throwable cause) {
        super(message, cause);
    }
}
