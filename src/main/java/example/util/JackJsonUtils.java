package example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.logging.Logger;

public class JackJsonUtils {
    static ObjectMapper objectMapper;

    /**
     * 解析Json
     *
     * @param content
     * @param valueType
     * @return
     */
    public static <T> T fromJson(String content, Class<T> valueType) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.readValue(content, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String toJson(Object value) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
