package br.org.mercardolivre.bootcamp.supermarket.utils;

import java.util.regex.Pattern;

public class ValidateUtils {

    public static boolean isNumber(String value) {
        Pattern pattern;
        pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (value == null) {
            return false;
        }
        return pattern.matcher(value).matches();
    }

}
