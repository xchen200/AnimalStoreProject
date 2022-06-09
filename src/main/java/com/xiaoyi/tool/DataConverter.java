package com.xiaoyi.tool;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class DataConverter {

    public static Map<String, String> convertFormData(String input) {
        String[] params = input.split("&");
        Map<String, String> paramMap = new HashMap<>();
        for (String param : params) {
            String key = param.split("=")[0];
            String value = param.split("=")[1];
            paramMap.put(key, value);
        }
        return paramMap;
    }
}
