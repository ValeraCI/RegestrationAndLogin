package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private Pattern pattern;
    public Regex(String regex){
        this.pattern = Pattern.compile(regex);
    }
    public boolean canBe(String string){
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
