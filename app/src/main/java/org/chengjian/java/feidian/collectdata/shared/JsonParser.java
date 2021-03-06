package org.chengjian.java.feidian.collectdata.shared;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * Created by Developer on 17-1-19.
 * Wang Cheng is a intelligent Android developer.
 */

public class JsonParser {
    private static JsonParser instance;

    private Gson gson;

    private JsonParser() {
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
    }

    public static JsonParser getInstance() {
        if (instance == null) {
            synchronized (JsonParser.class) {
                if (instance == null) {
                    instance = new JsonParser();
                }
            }
        }
        return instance;
    }

    public Gson getGson() {
        return gson;
    }

    public Object fromJson(String json, Class clazz) {
        return gson.fromJson(json, clazz);
    }

    public Object fromJson(String json, Type type) {
        return gson.fromJson(json, type);
    }

    public String toJson(Object model) {
        return gson.toJson(model);
    }
}
