package com.sanjogstha.codewars.database;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjogstha on 5/8/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class Converters {
    @TypeConverter
    public static List<String> fromString(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(List<String> list) {
        return new Gson().toJson(list);
    }

    @TypeConverter
    public static List<Integer> fromInteger(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(String.valueOf(value), listType);
    }

    @TypeConverter
    public static String fromArrayListToInteger(List<Integer> list) {
        return new Gson().toJson(list);
    }
}
