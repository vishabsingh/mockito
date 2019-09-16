package com.vs.mock.java8;

import org.mockito.internal.util.StringUtil;

import java.text.MessageFormat;
import java.util.function.BiFunction;

public class MessageFormatExample {

    public static final String CONFIG_ENTITY_URL_KEY = "config.{0}.url";
    public static final String CONFIG_ENTITY_URL_META_INSERT = "config.{0}.url.insert";
    public static final String CONFIG_ENTITY_MAPPER = "mapper";
    public static final String CONFIG_ENTITY_VALIDATION = "validation";

    public static void main(String[] args) {
        String result1 = getMessage().apply(CONFIG_ENTITY_URL_META_INSERT,CONFIG_ENTITY_MAPPER).toString();
        String result2 = getMessage().apply(CONFIG_ENTITY_URL_META_INSERT,CONFIG_ENTITY_VALIDATION).toString();

        String urlEntity = MessageFormat.format(CONFIG_ENTITY_URL_KEY,"mapper");
        String result3 = MessageFormat.format(urlEntity,"http://localhost:8090");
       System.out.println(result1 + " : "+result2 + " : "+result3);;


    }
    public  static BiFunction getMessage(){
        BiFunction<String ,String,String> biFunction = (s1,s2) -> MessageFormat.format(s1,s2);
        return biFunction;
    }
}
