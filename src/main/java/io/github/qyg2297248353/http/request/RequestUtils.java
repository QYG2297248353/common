/*
 * Ms.萌森工作室 Copyright (c) 2022. Java基本工具开发由萌森工作室倾情打造，请勿恶意转载！
 */

package io.github.qyg2297248353.http.request;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONObject;
import io.github.qyg2297248353.config.request.HeaderConstant;
import io.github.qyg2297248353.exception.MsUtilsException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * OkHttp 请求工具类
 *
 * @author 萌森 Ms
 * @Created 2022 /5/21 21:45
 */
@Slf4j
public class RequestUtils {
    private static final OkHttpClient CLIENT;

    private static MediaType mediaType;

    static {
        CLIENT = new OkHttpClient.Builder()
                .connectTimeout(HeaderConstant.ConfigEnum.CONNECTION_TIMEOUT.getConfig(), TimeUnit.SECONDS)
                .writeTimeout(HeaderConstant.ConfigEnum.WRITE_TIMEOUT.getConfig(), TimeUnit.SECONDS)
                .readTimeout(HeaderConstant.ConfigEnum.READ_TIMEOUT.getConfig(), TimeUnit.SECONDS)
                .build();
        mediaType = MediaType.parse(HeaderConstant.mediaType(HeaderConstant.ContentTypeEnum.APPLICATION_JSON));
    }

    /**
     * Gets request.
     *
     * @param url the url
     * @return the request
     * @throws MsUtilsException the ms utils exception
     */
    public static Response getRequest(String url) throws MsUtilsException {
        return getRequest(url, null);
    }

    public static JSONObject getRequestJson(String url) throws MsUtilsException {
        return getRequestJson(url, null);
    }

    public static JSONObject getRequestJson(String url, Map<String, String> params) throws MsUtilsException {
        Response response = getRequest(url, params);
        if (response.isSuccessful()) {
            JSONObject jsonObject;
            ResponseBody responseBody = response.body();
            try {
                String text = responseBody.toString();
                jsonObject = JSON.parseObject(text);
                return jsonObject;
            } catch (JSONException e) {
                log.warn("OkHttp 请求返回数据解析失败！");
            }
            try {
                String readUtf8 = responseBody.source().readUtf8();
                jsonObject = JSON.parseObject(readUtf8);
            } catch (JSONException | IOException e) {
                throw new MsUtilsException("非标准接口无法读取", e);
            }
            return jsonObject;
        }
        throw new MsUtilsException("OkHttp 请求失败！");
    }

    public static Response getRequest(String url, Map<String, String> params) throws MsUtilsException {
        String uri = url;
        if (params != null && !params.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            uri = url + "?" + sb.substring(0, sb.length() - 1);
        }
        Request request = new Request.Builder()
                .url(uri)
                .get()
                .build();
        try {
            return CLIENT.newCall(request).execute();
        } catch (IOException e) {
            throw new MsUtilsException("OkHttp 请求失败！", e);
        }
    }
}
