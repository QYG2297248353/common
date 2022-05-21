/*
 * Ms.萌森工作室 Copyright (c) 2022. Java基本工具开发由萌森工作室倾情打造，请勿恶意转载！
 */

package io.github.qyg2297248353.regular.info;


import io.github.qyg2297248353.regular.basic.StingUtils;
import io.github.qyg2297248353.regular.regex.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 电话号码效验工具类
 *
 * @author 萌森 Ms
 */
public class TelCharm {
    /**
     * 正则表达式：验证手机号
     *
     * @param str 待验证的手机号
     * @return 是否为手机号 boolean
     */
    public static boolean isChinaPhone(String str) {
        str = StingUtils.replaceBlank(str);
        // 字符串长度必须大于等于11位
        if (str.length() >= 11 && str.startsWith("+")) {
            str = StingUtils.replaceBlank(str);
            str = str.substring(str.length() - 11, str.length());
        } else if (str.length() < 11) {
            return false;
        }
        // 移动号段: 134,135,136,137,138,139,147,150,151,152,157,158,159,170,178,182,183,184,187,188
        // 联通号段: 130,131,132,145,155,156,170,171,175,176,185,186
        // 电信号段: 133,149,153,170,173,177,180,181,189
        Pattern r = Pattern.compile(Regexp.REGEX_PHONE);
        Matcher m = r.matcher(str);
        return m.matches();
    }
}
