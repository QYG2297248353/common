package com.ms.common.request.parse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * JSON 请求解析
 * json/application
 *
 * @author 萌森 Ms
 * @Created 2022/5/15 15:56
 */
public class RequestUtils {
    /**
     * 描述:获取 request 中 json 的JSONObject的内容
     */
    public static JSONObject getRequestJsonObject(HttpServletRequest request) throws IOException {
        String json = getRequestJsonString(request);
        JSONObject data = JSON.parseObject(json);
        return data;
    }

    /**
     * 描述:获取 request 中 json 字符串的内容
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
