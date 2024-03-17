package com.ssg.todoservice.controller.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CheckboxFormatter implements Formatter<Boolean> {
    @Override
    public Boolean parse(String text, Locale locale) throws ParseException {
        return (text != null && text.equals("on"));
    }

    @Override
    public String print(Boolean object, Locale locale) {
        return object.toString();
    }
}
