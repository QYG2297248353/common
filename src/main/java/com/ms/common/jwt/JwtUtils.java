package com.ms.common.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

/**
 * Jwt工具
 *
 * @author 萌森 Ms
 * @Created 2022/5/15 15:55
 */
public class JwtUtils {
    private static final String subject = "Ms";

    /**
     * 默认构建
     *
     * @return jwt
     */
    public static String buildJwt() {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(subject)
                .signWith(JwConfig.getKey());
        return jwtBuilder.compact();
    }

    /**
     * 自定义对象-构建
     *
     * @param jwt jwt
     * @return jwt
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
     * @return jwt
     */
    public static String createJwt(BuildJwt buildJwt) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setSubject(subject);
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
