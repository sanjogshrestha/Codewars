package com.sanjogstha.codewars.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by sanjogstha on 1/8/18.
 * sanjogshrestha.nepal@gmail.com
 */

public class DateUtils {
    private final static String DISPLAY_DATE_YMD_SHORT = "dd MMM, yyyy";
    private final static String DISPLAY_DATE_YMD_T_HMA = "yyyy-MM-dd'T'HH:mm:ss";
    private final static String DISPLAY_TIME_HMA = "hh:mm a";

    public static String toDisplayDate(@NonNull String dateString) {
        SimpleDateFormat format = new SimpleDateFormat(DISPLAY_DATE_YMD_T_HMA, Locale.ENGLISH);
        SimpleDateFormat dateFormat = new SimpleDateFormat(DISPLAY_DATE_YMD_SHORT, Locale.ENGLISH);
        SimpleDateFormat timeFormat = new SimpleDateFormat(DISPLAY_TIME_HMA, Locale.ENGLISH);

        Date date = new Date();
        try {
            date = format.parse(dateString);
            format.setTimeZone(TimeZone.getDefault());
        } catch (ParseException e) {
            Log.e(e.getLocalizedMessage() , "date");
        }
        return timeFormat.format(date) + " "  + dateFormat.format(date);
    }
}
