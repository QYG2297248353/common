/*
 * Ms.萌森工作室 Copyright (c) 2022. Java基本工具开发由萌森工作室倾情打造，请勿恶意转载！
 */

package io.github.qyg2297248353.auth.jwt;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import lombok.Getter;
import lombok.Setter;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 加密数据
 *
 * @author 萌森 Ms
 */
@Getter
@Setter
public class JwtEncryptedInfo {
    /**
     * 头信息 声明
     */
    private Header header;
    private Map<String, Object> headerMap;
    /**
     * 加密密钥
     */
    private Key key;
    /**
     * 发行人 声明
     */
    private String iss;
    /**
     * 主题 声明
     */
    private String sub;
    /**
     * 受众 声明
     */
    private String aud;
    /**
     * 过期时间 声明
     */
    private Date exp;
    /**
     * 生效时间 声明
     */
    private Date nbf;
    /**
     * 颁发时间 声明
     */
    private Date iat;
    /**
     * JWT唯一ID 声明
     */
    private String jti;
    /**
     * meta 数据
     */
    private Map<String, Object> claim;

    /**
     * Instantiates a new Jwt encrypted info.
     */
    public JwtEncryptedInfo() {
        this.header = Jwts.header();
        this.headerMap = new HashMap<>();
    }

    /**
     * Sets claim.
     *
     * @param k the k
     * @param v the v
     */
    public void setClaim(String k, Object v) {
        this.claim.put(k, v);
    }

    /**
     * Sets claim.
     *
     * @param claim the claim
     */
    public void setClaim(Map<String, Object> claim) {
        this.claim = claim;
    }

    /**
     * Sets header map.
     *
     * @param headerMap the header map
     */
    public void setHeaderMap(Map<String, Object> headerMap) {
        this.headerMap = headerMap;
    }

    /**
     * Sets header.
     *
     * @param k the k
     * @param v the v
     */
    public void setHeader(String k, Object v) {
        this.headerMap.put(k, v);
    }

    /**
     * Sets header map.
     *
     * @param k the k
     * @param v the v
     */
    public void setHeaderMap(String k, Object v) {
        this.headerMap.put(k, v);
    }

    /**
     * Gets header.
     *
     * @return the header
     */
    public Map<String, Object> getHeader() {
        if (!this.headerMap.isEmpty()) {
            this.header.putAll(this.headerMap);
        }
        return this.header;
    }

    /**
     * Sets header.
     *
     * @param header the header
     */
    public void setHeader(Header header) {
        this.header = header;
    }

    /**
     * Build.
     *
     * @param jwtBuilder the jwt builder
     */
    protected void build(JwtBuilder jwtBuilder) {
        if (this.header != null) {
            jwtBuilder.setHeader(getHeader());
        }
        if (this.sub != null) {
            jwtBuilder.setSubject(this.sub);
        }
        if (this.iss != null) {
            jwtBuilder.setIssuer(this.iss);
        }
        if (this.aud != null) {
            jwtBuilder.setAudience(this.aud);
        }
        if (this.exp != null) {
            jwtBuilder.setExpiration(this.exp);
        }
        if (this.nbf != null) {
            jwtBuilder.setNotBefore(this.nbf);
        }
        if (this.iat != null) {
            jwtBuilder.setIssuedAt(this.iat);
        }
        if (this.jti != null) {
            jwtBuilder.setId(this.jti);
        }
        if (this.claim != null && !this.claim.isEmpty()) {
            this.claim.forEach((k, v) -> {
                jwtBuilder.claim(k, v);
            });
        }
    }
}
