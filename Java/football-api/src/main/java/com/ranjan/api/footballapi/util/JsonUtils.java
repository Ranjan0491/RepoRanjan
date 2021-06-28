package com.ranjan.api.footballapi.util;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JsonUtils {

    public Map<String, Object> getMapFromJsonString(String jsonString) {
        GsonJsonParser gsonJsonParser = new GsonJsonParser();
        return gsonJsonParser.parseMap(jsonString);
    }
}
