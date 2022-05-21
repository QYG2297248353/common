/*
 * Ms.萌森工作室 Copyright (c) 2022. Java基本工具开发由萌森工作室倾情打造，请勿恶意转载！
 */

package io.github.qyg2297248353.auth.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

/**
 * Jwt工具
 *
 * @author 萌森 Ms
 */
public class JwtUtils {
    private static final String SUBJECT = "Ms";

    /**
     * 默认构建
     *
     * @return jwt string
     */
    public static String buildJwt() {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(SUBJECT)
                .signWith(JwConfig.getKey());
        return jwtBuilder.compact();
    }

    /**
     * 自定义对象-构建
     *
     * @param jwt jwt
     * @return jwt string
     */
    public static String createJwt(JwtEncryptedInfo jwt) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwt.build(jwtBuilder);
        jwtBuilder.signWith(JwConfig.getKey());
        return jwtBuilder.compact();
    }

    /**
     * 自定义构建
     *
     * @param buildJwt buildJwt
     * @return jwt string
     */
    public static String createJwt(BuildJwt buildJwt) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setSubject(SUBJECT);
        jwtBuilder.signWith(JwConfig.getKey());
        buildJwt.build(jwtBuilder);
        return jwtBuilder.compact();
    }

    private interface BuildJwt {
        /**
         * 自定义构建jwt
         *
         * @param jwtBuilder jwtBuilder
         */
        void build(JwtBuilder jwtBuilder);
    }

}
