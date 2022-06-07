/*
 * Ms.萌森工作室 Copyright (c) 2022. Java基本工具开发由萌森工作室倾情打造，请勿恶意转载！
 */

package io.github.qyg2297248353.auth.jwt;

import io.github.qyg2297248353.exception.MsUtilsException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;

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
     * 自定义构建[内容]
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

    public interface BuildJwt {
        /**
         * 自定义构建jwt
         *
         * @param jwtBuilder jwtBuilder
         */
        void build(JwtBuilder jwtBuilder);
    }

    /**
     * 自定义构建
     *
     * @return jwt string
     */
    public static String createJwt(CreateJwt create) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setSubject(create.subject());
        return jwtBuilder.compact();
    }

    public interface CreateJwt {
        /**
         * 设置主题
         * @return 主题
         */
        String subject();
    }

    /**
     * 解析默认生成jwt
     *
     * @param jwt jwt
     * @return 解析jwt内容
     * @throws MsUtilsException 解析异常
     */
    public Jws<Claims> decodeRsa(String jwt) throws MsUtilsException {
        try {
            return Jwts.parserBuilder().setSigningKey(JwConfig.getKey()).build().parseClaimsJws(jwt);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException |
                 IllegalArgumentException e) {
            throw new MsUtilsException("jwt解析异常", e);
        }
    }

    /**
     * 解析主题jwt
     *
     * @param jwt     jwt
     * @param subject 效验主题
     * @return 解析jwt内容
     * @throws MsUtilsException 解析异常
     */
    public Jws<Claims> decodeRsa(String jwt, String subject) throws MsUtilsException {
        try {
            return Jwts.parserBuilder().requireSubject(subject).setSigningKey(JwConfig.getKey()).build().parseClaimsJws(jwt);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException |
                 IllegalArgumentException e) {
            throw new MsUtilsException("jwt解析异常", e);
        }
    }
}
