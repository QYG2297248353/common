/*
 * Ms.萌森工作室 Copyright (c) 2022. Java基本工具开发由萌森工作室倾情打造，请勿恶意转载！
 */

package io.github.qyg2297248353.regular.info;


import io.github.qyg2297248353.regular.basic.StingUtils;
import io.github.qyg2297248353.regular.regex.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 统一信用代码工具类
 *
 * @author 萌森 Ms
 */
public class UccCharm {
    /**
     * 正则表达式：验证统一信用代码
     *
     * @param str 待验证的信用代码
     * @return 是否为统一信用代码 boolean
     */
    public static boolean isUcc(String str) {
        str = StingUtils.replaceBlank(str);
        if (str.length() != 18) {
            return false;
        }
        Pattern r = Pattern.compile(Regexp.REGEX_UCC);
        Matcher m = r.matcher(str);
        return m.matches();
    }
}
