/*
 * Ms.萌森工作室 Copyright (c) 2022. Java基本工具开发由萌森工作室倾情打造，请勿恶意转载！
 */

package io.github.qyg2297248353.regular.basic;


import io.github.qyg2297248353.regular.regex.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 *
 * @author 萌森 Ms
 */
public class StingUtils {
    /**
     * 去除字符串中的空格、回车、换行符、制表符
     *
     * @param str the str
     * @return the string
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile(Regexp.REGEX_STRING);
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

}
