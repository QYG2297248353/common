package com.ms.common.regular.info;

import com.ms.common.regular.basic.StingUtils;
import com.ms.common.regular.regex.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ip效验工具类
 *
 * @author 萌森 Ms
 * @Created 2022/5/20 22:59
 */
public class IpCharm {
    /**
     * 判断是否是IP地址
     */
    public static boolean isIp(String str) {
        str = StingUtils.replaceBlank(str);
        Pattern r = Pattern.compile(Regexp.REGEX_IP_ADDR);
        Matcher m = r.matcher(str);
        return m.matches();
    }

    /**
     * 判断是否是IPv4地址【排除局域网】
     */
    public static boolean isIPv4(String str) {
        str = StingUtils.replaceBlank(str);
        if (isIp(str)) {
            Pattern r = Pattern.compile(Regexp.REGEX_LAN_IP_ADDR);
            Matcher m = r.matcher(str);
            return !m.matches();
        }
        return false;
    }
}
