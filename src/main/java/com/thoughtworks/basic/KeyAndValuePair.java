package com.thoughtworks.basic;

import java.util.Objects;
/**
 * 
 * @author wqm
 *
 */
public class KeyAndValuePair {

    private final String key;
    private final String value;

    public KeyAndValuePair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
        	return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
        	return false;
        }
        KeyAndValuePair that = (KeyAndValuePair) obj;
        
        return Objects.equals(key, that.key) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
