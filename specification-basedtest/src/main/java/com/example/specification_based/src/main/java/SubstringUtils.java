package com.example.specification_based.src.main.java;

import static android.text.TextUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;

public class SubstringUtils {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static String[] substringsBetween(final String str,
                                             final String open, final String close) {
        if (str == null || isEmpty(open) || isEmpty(close)) {
            return null;
        }
        int strLen = str.length();

        if (strLen == 0) {
            return EMPTY_STRING_ARRAY;
        }

        int closeLen = close.length();
        int openLen = open.length();
        List<String> list = new ArrayList<>();
        int pos = 0;

        while (pos < strLen - closeLen) {
            int start = str.indexOf(open, pos);

            if (start < 0) {
                break;
            }
            start += openLen;
            int end = str.indexOf(close, start);
            if (end < 0) {
                break;
            }

            list.add(str.substring(start, end));
            pos = end + closeLen;
        }
        if (list.isEmpty()) {
            return null;
        }
        return list.toArray(EMPTY_STRING_ARRAY);

    }
}
