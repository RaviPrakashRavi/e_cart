package com.ravi.major.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static boolean isValidPassword(String password)
    {
        if(password==null)
            return false;

        String regex ="^(?=.*[0-9])"
                       +"^(?=.*[a-z])^(?=.*[A-Z])"
                        +"^(?=.*[@#$%^&*+=])"
                        +"(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher =pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isValidMoblieNumber(String number)
    {
        if(number==null)
        {
            return false;
        }
        String regex = "[6789]{1}\\d{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

}
