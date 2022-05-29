/*
 * Ms.萌森工作室 Copyright (c) 2022. Java基本工具开发由萌森工作室倾情打造，请勿恶意转载！
 */

package io.github.qyg2297248353.auth.uuid;

/**
 * @author Ms
 */
public class UuidUtils {

    /**
     * 生成uuid 36位
     * 标准UUID：xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx
     *
     * @return uuid
     */
    public static String getUuid() {
        return java.util.UUID.randomUUID().toString();
    }

    /**
     * 生成uuid 32位
     * 字符串UUID：xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
     *
     * @return uuid
     */
    public static String getUuidStr() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成指定长度uuid 32位
     *
     * @param length 长度[1-32]
     * @return uuid
     */
    public static String getUuidStr(Integer length) {
        if (length == null || length < 1) {
            return getUuidStr();
        }
        String uuid = getUuidStr();
        if (uuid.length() > length) {
            return uuid.substring(0, length);
        }
        return uuid;
    }

    /**
     * 生成指定数量uuid 32位
     *
     * @param number 数量
     * @return uuid
     */
    public static String[] getUuidStrArray(Integer number) {
        if (number == null || number < 1) {
            return new String[]{getUuidStr()};
        }
        String[] uuid = new String[number];
        for (int i = 0; i < number; i++) {
            uuid[i] = getUuidStr();
        }
        return uuid;
    }
}
