/*
 * Ms.萌森工作室 Copyright (c) 2022. Java基本工具开发由萌森工作室倾情打造，请勿恶意转载！
 */

package io.github.qyg2297248353.regular.info;

import io.github.qyg2297248353.regular.basic.StingUtils;
import io.github.qyg2297248353.regular.regex.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 邮箱验证工具类
 *
 * @author 萌森 Ms
 */
public class EmailCharm {
    /**
     * 正则表达式：验证邮箱
     *
     * @param str 待验证的邮箱
     * @return 是否为邮箱 boolean
     */
    public static boolean isEmail(String str) {
        str = StingUtils.replaceBlank(str);
        // 判断字符串是否存在字符@
        if (str.indexOf("@") == -1) {
            return false;
        }
        Pattern r = Pattern.compile(Regexp.REGEX_EMAIL);
        Matcher m = r.matcher(str);
        return m.matches();
    }
}
