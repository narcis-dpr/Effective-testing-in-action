package com.example.structural.src.main.java;

class LeftPad {
    private static final String SPACE = " ";

    private static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }
    public static String leftPad(final String str, final int size, String padStr) {
        if (str == null) {
            return null;
        }

        if (padStr == null || padStr.isEmpty()) {
            padStr = SPACE;
        }
        final int padLen = padStr.length();
        final int strLen = str.length();
        final int pads = size - strLen;
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (pads == padLen) {
            return padStr.concat(str);
        } else if (pads < padLen){
            return padStr.substring(0, pads).concat(str);
        } else {
            final char[] padding = new char[pads];
            final char[] padChars = padStr.toCharArray();

            for (int i = 0; i< pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return new String(padding).concat(str);
        }
    }
}
