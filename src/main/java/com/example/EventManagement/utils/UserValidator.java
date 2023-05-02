package com.example.EventManagement.utils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    public static boolean isValidAge(int d)
    {
        if(d>18 && d<25)
        {
            return true;
        }
        return false;
    }
    public static boolean isValidFirstName(String d)
    {
        if(d.charAt(0)>='A' && d.charAt(0)<='Z')
        {
            return true;
        }
        return false;
    }

    public static List<String> isValidUser(JSONObject user)
    {
        List<String> ls=new ArrayList<>();
        if(!user.has("first_name"))
        {
            ls.add("first_name");
        }
        if(!user.has("last_name"))
        {
            ls.add("last_name");
        }
        if(!isValidAge(user.getInt("age")) )
        {
            ls.add("age is not valid");
        }
        if(!isValidFirstName(user.getString("first_name")))
        {
            ls.add("First name is not valid");
        }
        if(!user.has("age"))
        {
            ls.add("age");
        }
        if(!user.has("department"))
        {
            ls.add("department");
        }
        return ls;

    }
}
