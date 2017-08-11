package org.ncmao.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {
    private static ObjectMapper objectmapper = null;

    private ObjectMapperUtil() {
    }
    public static ObjectMapper getInstance(){
        if (objectmapper == null) {
            objectmapper = new ObjectMapper();
            return objectmapper;
        }
        return objectmapper;
    }
}
