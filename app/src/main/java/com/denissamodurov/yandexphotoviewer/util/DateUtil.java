package com.denissamodurov.yandexphotoviewer.util;

import android.text.format.DateFormat;

import java.util.Date;

/**
 * Created by denissamodurov on 06/05/2018.
 */

public class DateUtil {
    public static String dateFormetterForMainScreen(Date date){
        return DateFormat.format("yyyy-MM-dd", date).toString();
    }
}
