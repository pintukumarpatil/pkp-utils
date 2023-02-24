package org.galaxy.talkroom.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class GsonHelper {

    public static <T> T parseWithGsonFrom(String json, Class<T> type) {
        return new Gson().fromJson(json, type);
    }

    public static <T> String parseWithGsonTo(T object) {
        return new Gson().toJson(object);
    }

    public static <T> ArrayList<T> parseListFromJson(String json, Class<T> type) {
        return new Gson().fromJson(json, TypeToken.getParameterized(ArrayList.class, type).getType());
    }

    public static <T> String parseListToJson(ArrayList<T> list, Class<T> type) {
        return new Gson().toJson(list, TypeToken.getParameterized(ArrayList.class, type).getType());
    }

    public static <T> T getResponse(Type type, Object response) {
        Gson gson = new Gson();
        String s = gson.toJson(response);
        return gson.fromJson(s, type);
    }
}