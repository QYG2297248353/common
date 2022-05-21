/*
 * Ms.萌森工作室 Copyright (c) 2022. Java基本工具开发由萌森工作室倾情打造，请勿恶意转载！
 */

package io.github.qyg2297248353.request.parse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * JSON 请求解析
 * json/application
 *
 * @author 萌森 Ms
 */
public class RequestUtils {
    /**
     * 描述:获取 request 中 json 的JSONObject的内容
     *
     * @param request the request
     * @return the request json object
     * @throws IOException the io exception
     */
    public static JSONObject getRequestJsonObject(HttpServletRequest request) throws IOException {
        String json = getRequestJsonString(request);
        JSONObject data = JSON.parseObject(json);
        return data;
    }

    /**
     * 描述:获取 request 中 json 字符串的内容
     *
     * @param request the request
     * @return the request json string
     * @throws IOException the io exception
     */
    public static String getRequestJsonString(HttpServletRequest request)
            throws IOException {
        String submitMethod = request.getMethod();
        // GET
        if ("GET".equals(submitMethod)) {
            return new String(request.getQueryString().getBytes("iso-8859-1"), "utf-8").replaceAll("%22", "\"");
            // POST
        } else {
            return getRequestPostStr(request);
        }
    }

    /**
     * 描述:获取 post 请求的 byte[] 数组
     *
     * @param request the request
     * @return the byte [ ]
     * @throws IOException the io exception
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException {
        int contentLength = request.getContentLength();
        if (contentLength < 0) {
            return new byte[0];
        }
        byte[] buffer = new byte[contentLength];
        for (int i = 0; i < contentLength; ) {
            int readable = request.getInputStream().read(buffer, i,
                    contentLength - i);
            if (readable == -1) {
                break;
            }
            i += readable;
        }
        return buffer;
    }

    /**
     * 描述:获取 post 请求内容
     *
     * @param request the request
     * @return the request post str
     * @throws IOException the io exception
     */
    public static String getRequestPostStr(HttpServletRequest request)
            throws IOException {
        byte[] buffer = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }
}
