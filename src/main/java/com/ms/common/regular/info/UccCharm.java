package com.ms.common.regular.info;


import com.ms.common.regular.basic.StingUtils;
import com.ms.common.regular.regex.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 统一信用代码工具类
 *
 * @author 萌森 Ms
 * @Created 2022/5/20 23:02
 */
public class UccCharm {
    /**
     * 正则表达式：验证统一信用代码
     *
     * @param str 待验证的信用代码
     * @return 是否为统一信用代码
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
