package com.ms.common.regular.info;

import com.ms.common.regular.basic.StingUtils;
import com.ms.common.regular.regex.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 邮箱验证工具类
 *
 * @author 萌森 Ms
 * @Created 2022/5/20 22:59
 */
public class EmailCharm {
    /**
     * 正则表达式：验证邮箱
     *
     * @param str 待验证的邮箱
     * @return 是否为邮箱
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
