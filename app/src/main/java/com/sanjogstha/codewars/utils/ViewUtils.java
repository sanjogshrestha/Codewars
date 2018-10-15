package com.sanjogstha.codewars.utils;

import java.util.List;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class ViewUtils {
    public static String join(List<String> list) {
        StringBuilder sb = new StringBuilder();
        String loopDelim = "";
        for(String s : list) {
            sb.append(loopDelim);
            sb.append(s);
            loopDelim = " | ";
        }
        return sb.toString();
    }
}
