package de.perdoctus.synolib.requests;

/**
 * User: cgiesche
 * Date: 2/24/12
 * Time: 4:06 PM
 */
public class KeyValue {
    private String key;
    private String value;
    
    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.key + "=" + this.value;
    }
}
