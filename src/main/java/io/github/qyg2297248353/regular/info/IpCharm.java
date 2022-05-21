/*
 * Ms.萌森工作室 Copyright (c) 2022. Java基本工具开发由萌森工作室倾情打造，请勿恶意转载！
 */

package io.github.qyg2297248353.regular.info;

import io.github.qyg2297248353.regular.basic.StingUtils;
import io.github.qyg2297248353.regular.regex.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ip效验工具类
 *
 * @author 萌森 Ms
 */
public class IpCharm {
    /**
     * 判断是否是IP地址
     *
     * @param str the str
     * @return the boolean
     */
    public static boolean isIp(String str) {
        str = StingUtils.replaceBlank(str);
        Pattern r = Pattern.compile(Regexp.REGEX_IP_ADDR);
        Matcher m = r.matcher(str);
        return m.matches();
    }

    /**
     * 判断是否是IPv4地址【排除局域网】
     *
     * @param str the str
     * @return the boolean
     */
    public static boolean isIpv4(String str) {
        str = StingUtils.replaceBlank(str);
        if (isIp(str)) {
            Pattern r = Pattern.compile(Regexp.REGEX_LAN_IP_ADDR);
            Matcher m = r.matcher(str);
            return !m.matches();
        }
        return false;
    }
}
