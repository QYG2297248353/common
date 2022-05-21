/*
 * Ms.萌森工作室 Copyright (c) 2022. Java基本工具开发由萌森工作室倾情打造，请勿恶意转载！
 */

package io.github.qyg2297248353.config.request;

/**
 * 请求类型常量
 *
 * @author 萌森 Ms
 * @Created 2022/5/21 22:00
 */
public class HeaderConstant {
    public static String mediaType() {
        return ContentType.APPLICATION_JSON + ";charset=" + Charset.UTF_8;
    }

    public static String mediaType(ContentTypeEnum contentType) {
        return contentType.getContentType() + ";charset=" + Charset.UTF_8;
    }

    public static String mediaType(ContentTypeEnum contentType, CharsetEnum charset) {
        return contentType.getContentType() + ";charset=" + charset.getCharset();
    }

    public enum ContentTypeEnum {
        APPLICATION_JSON(ContentType.APPLICATION_JSON),
        APPLICATION_XML(ContentType.APPLICATION_XML),
        APPLICATION_FORM_URLENCODED(ContentType.APPLICATION_FORM_URLENCODED),
        MULTIPART_FORM_DATA(ContentType.MULTIPART_FORM_DATA),
        TEXT_PLAIN(ContentType.TEXT_PLAIN),
        TEXT_XML(ContentType.TEXT_XML),
        TEXT_HTML(ContentType.TEXT_HTML),
        TEXT_JSON(ContentType.TEXT_JSON),
        TEXT_JAVASCRIPT(ContentType.TEXT_JAVASCRIPT),
        APPLICATION_OCTET_STREAM(ContentType.APPLICATION_OCTET_STREAM);

        private String contentType;

        ContentTypeEnum(String contentType) {
            this.contentType = contentType;
        }

        public String getContentType() {
            return contentType;
        }
    }

    public enum CharsetEnum {
        UTF_8(Charset.UTF_8),
        GBK(Charset.GBK),
        GB2312(Charset.GB2312),
        ISO_8859_1(Charset.ISO_8859_1);

        private String charset;

        CharsetEnum(String charset) {
            this.charset = charset;
        }

        public String getCharset() {
            return charset;
        }
    }

    public enum ConfigEnum {
        CONNECTION_TIMEOUT(Config.CONNECTION_TIMEOUT),
        WRITE_TIMEOUT(Config.WRITE_TIMEOUT),
        READ_TIMEOUT(Config.READ_TIMEOUT);

        private Integer config;

        ConfigEnum(Integer config) {
            this.config = config;
        }

        public Integer getConfig() {
            return config;
        }
    }

    public static class ContentType {
        public static final String APPLICATION_JSON = "application/json";
        public static final String APPLICATION_XML = "application/xml";
        public static final String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";
        public static final String MULTIPART_FORM_DATA = "multipart/form-data";
        public static final String TEXT_PLAIN = "text/plain";
        public static final String TEXT_XML = "text/xml";
        public static final String TEXT_HTML = "text/html";
        public static final String TEXT_JSON = "text/json";
        public static final String TEXT_JAVASCRIPT = "text/javascript";
        public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    }

    public static class Charset {
        public static final String UTF_8 = "UTF-8";
        public static final String GBK = "GBK";
        public static final String GB2312 = "GB2312";
        public static final String ISO_8859_1 = "ISO-8859-1";
    }

    public static class Config {
        public static final Integer CONNECTION_TIMEOUT = 10;
        public static final Integer WRITE_TIMEOUT = 10;
        public static final Integer READ_TIMEOUT = 30;
    }
}
