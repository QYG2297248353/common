/*
 * Ms.萌森工作室 Copyright (c) 2022. Java基本工具开发由萌森工作室倾情打造，请勿恶意转载！
 */

package io.github.qyg2297248353.request.ip;

import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Ip地址信息
 *
 * @author 萌森 Ms
 */
@ToString
@Getter
@Setter
public class AddressIpVo implements Serializable {
    private static final long serialVersionUID = -440442459217819851L;
    /**
     * IP
     */
    @JsonProperty("query")
    private String ip;
    /**
     * 大陆
     */
    private String continent;
    /**
     * 大陆代码
     */
    private String continentCode;
    /**
     * 国家
     */
    private String country;
    /**
     * 国家代码
     */
    private String countryCode;
    /**
     * 省份
     */
    private String region;
    /**
     * 省份代码
     */
    private String regionCode;
    /**
     * 城市
     */
    private String city;
    /**
     * 城市细分
     */
    private String district;
    /**
     * 邮编【zip】
     */
    @JsonProperty("zip")
    private String zipCode;
    /**
     * 经度【lat】
     */
    @JsonProperty("lat")
    private Float latitude;
    /**
     * 维度【lon】
     */
    @JsonProperty("lon")
    private Float longitude;
    /**
     * 时区
     */
    private String timezone;
    /**
     * Timezone UTC DST offset in seconds
     */
    private Integer offset;
    /**
     * 货币
     */
    private String currency;
    /**
     * 服务提供商
     */
    private String isp;
    /**
     * 服务提供商-机构名称
     */
    private String org;
    /**
     * AS编号
     */
    private String as;
    /**
     * AS名称
     */
    @JsonProperty("asname")
    private String asName;
    /**
     * 反向DNS解析
     */
    private String reverse;
    /**
     * 移动网络运营商
     */
    private Boolean mobile;
    /**
     * 代理
     */
    private Boolean proxy;
    /**
     * 托管
     */
    private Boolean hosting;

    /**
     * 转换为JSON
     *
     * @param json 解析json数据
     * @return the address ip vo
     */
    protected AddressIpVo parseResponse(JSONObject json) {
        this.ip = json.containsKey("query") ? json.getString("query") : null;
        this.continent = json.containsKey("continent") ? json.getString("continent") : null;
        this.continentCode = json.containsKey("continentCode") ? json.getString("continentCode") : null;
        this.country = json.containsKey("country") ? json.getString("country") : null;
        this.countryCode = json.containsKey("countryCode") ? json.getString("countryCode") : null;
        this.region = json.containsKey("regionName") ? json.getString("regionName") : null;
        this.regionCode = json.containsKey("region") ? json.getString("region") : null;
        this.city = json.containsKey("city") ? json.getString("city") : null;
        this.district = json.containsKey("district") ? json.getString("district") : null;
        this.zipCode = json.containsKey("zip") ? json.getString("zip") : null;
        this.latitude = json.containsKey("lat") ? json.getFloat("lat") : null;
        this.longitude = json.containsKey("lon") ? json.getFloat("lon") : null;
        this.timezone = json.containsKey("timezone") ? json.getString("timezone") : null;
        this.offset = json.containsKey("offset") ? json.getInteger("offset") : null;
        this.currency = json.containsKey("currency") ? json.getString("currency") : null;
        this.isp = json.containsKey("isp") ? json.getString("isp") : null;
        this.org = json.containsKey("org") ? json.getString("org") : null;
        this.as = json.containsKey("as") ? json.getString("as") : null;
        this.asName = json.containsKey("asname") ? json.getString("asname") : null;
        this.reverse = json.containsKey("reverse") ? json.getString("reverse") : null;
        this.mobile = json.containsKey("mobile") ? json.containsKey("mobile") : null;
        this.proxy = json.containsKey("proxy") ? json.containsKey("proxy") : null;
        this.hosting = json.containsKey("hosting") ? json.containsKey("hosting") : null;
        return this;
    }
}
