package com.ms.common.request.ip;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ms.common.exception.MsUtilsException;
import com.ms.common.regular.info.IpCharm;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Ip解析工具类
 *
 * @author 萌森 Ms
 * @Created 2022/5/21 0:12
 */
public class IpUtils {
    // ip解析地址
    public static final String URI = "http://ip-api.com/json/{}?lang=zh-CN&fields=status,message,continent,continentCode,country,countryCode,region,regionName,city,district,zip,lat,lon,timezone,offset,currency,isp,org,as,asname,reverse,mobile,proxy,hosting,query";

    public static AddressIpVo getIPV4(HttpServletRequest request) throws MsUtilsException {
        String ip = request.getRemoteAddr();
        return getIPV4(ip);
    }

    public static AddressIpVo getIPV4(String ip) throws MsUtilsException {
        if (ip == null || !IpCharm.isIp(ip)) {
            throw new MsUtilsException("获取IP地址失败，原因：该IP地址不是IPV4地址");
        }
        if (!ip.isEmpty()) {
            String uri = URI.replace("{}", ip);
            Request requestHttp = new Request.Builder().url(uri).build();
            Response response;
            try {
                response = new OkHttpClient().newCall(requestHttp).execute();
                if (!response.isSuccessful()) {
                    throw new MsUtilsException("获取IP地址失败，原因：请求失败");
                }
            } catch (IOException e) {
                throw new MsUtilsException("获取IP地址失败，原因：请求超时");
            }
            try {
                String json = response.body().string();
                System.err.println(json);
                JSONObject jsonObject = JSON.parseObject(json);
                AddressIpVo addressIpVo = new AddressIpVo().parseResponse(jsonObject);
                return addressIpVo;
            } catch (IOException e) {
                throw new MsUtilsException("获取IP地址失败，原因：解析失败");
            }
        }
        throw new MsUtilsException("获取IP地址失败，原因：IP地址为空");
    }

    /**
     * 获取当前公网IP地址
     */
    public static Map getPublicIp() {
        Map map = new HashMap<>();
        String ip = "";
        String area = "";
        String address = "";
        try {
            Request requestHttp = new Request.Builder().url("http://pv.sohu.com/cityjson?ie=utf-8").build();
            Response response = new OkHttpClient().newCall(requestHttp).execute();
            String json = response.body().string();
            ip = json.substring(json.indexOf("{"), json.lastIndexOf("}") + 1);
            JSONObject jsonObject = JSON.parseObject(ip);
            ip = jsonObject.getString("cip");
            area = jsonObject.getString("cid");
            address = jsonObject.getString("cname");
            map.put("ip", ip);
            map.put("area", area);
            map.put("address", address);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取IP所在城市
     *
     * @param ip IP地址
     * @return IP所在城市
     */
    public static String getCity(String ip) {
        String city = "";
        try {
            AddressIpVo ipv4 = getIPV4(ip);
            city = ipv4.getCity();
            return city;
        } catch (MsUtilsException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getProvince(String ip) {
        String province = "";
        try {
            AddressIpVo ipv4 = getIPV4(ip);
            province = ipv4.getRegion();
            return province;
        } catch (MsUtilsException e) {
            e.printStackTrace();
        }
        return null;
    }
}
