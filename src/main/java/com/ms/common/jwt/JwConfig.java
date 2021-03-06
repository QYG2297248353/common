package com.ms.common.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Jwt配置
 *
 * @author 萌森 Ms
 * @Created 2022/5/15 20:35
 */
public class JwConfig {
    /**
     * 密钥-方式
     */
    private static Key key;

    /**
     * 密钥对-方式
     */
    private static KeyPair keyPair;
    /**
     * 公钥
     */
    private static String publicKey;
    /**
     * 私钥
     */
    private static String privateKey;
    /**
     * 共享密钥加密方式
     */
    private static SignatureAlgorithm signatureAlgorithm;
    /**
     * 密钥对加密方式
     */
    private static SignatureAlgorithm keyPairAlgorithm;

    static {
        // 初始化密钥
        signatureAlgorithm = SignatureAlgorithm.HS256;
        key = Keys.secretKeyFor(signatureAlgorithm);
        keyPairAlgorithm = SignatureAlgorithm.RS256;
        keyPair = Keys.keyPairFor(keyPairAlgorithm);
        publicKey = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
        privateKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
    }


    /**
     * 加载密钥对
     *
     * @param key 密钥
     * @return 密钥
     */
    public static Key createKey(String key) {
        byte[] decode = Base64.getDecoder().decode(key);
        SecretKey secretKey = Keys.hmacShaKeyFor(decode);
        return secretKey;
    }

    /**
     * 加载公钥
     *
     * @param publicKey 公钥
     * @return 密钥
     */
    public static KeyPair createPublicKey(String publicKey) {
        return new KeyPair(buildPublicKey(publicKey), null);
    }

    /**
     * 加载私钥
     *
     * @param privateKey 私钥
     * @return 密钥
     */
    public static KeyPair createPrivateKey(String privateKey) {
        return new KeyPair(null, buildPrivateKey(privateKey));
    }

    /**
     * 加载公钥
     *
     * @param publicKey 公钥
     * @return 密钥
     */
    private static PublicKey buildPublicKey(String publicKey) {
        byte[] decode = Base64.getDecoder().decode(publicKey);
        try {
            KeyFactory instance = KeyFactory.getInstance(keyPairAlgorithm.getJcaName());
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(decode);
            PublicKey key = instance.generatePublic(x509EncodedKeySpec);
            return key;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加载私钥
     *
     * @param privateKey 私钥
     * @return 密钥
     */
    private static PrivateKey buildPrivateKey(String privateKey) {
        byte[] decode = Base64.getDecoder().decode(privateKey);
        try {
            KeyFactory instance = KeyFactory.getInstance(keyPairAlgorithm.getJcaName());
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(decode);
            PrivateKey key = instance.generatePrivate(pkcs8EncodedKeySpec);
            return key;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加载密钥对
     *
     * @return 密钥
     */
    public static KeyPair createKeyPair(String publicKey, String privateKey) {
        return new KeyPair(buildPublicKey(publicKey), buildPrivateKey(privateKey));
    }

    public static Key getKey() {
        return key;
    }

    public static KeyPair getKeyPair() {
        return keyPair;
    }

    public static SignatureAlgorithm getSignatureAlgorithm() {
        return signatureAlgorithm;
    }

    public static SignatureAlgorithm getKeyPairAlgorithm() {
        return keyPairAlgorithm;
    }
}
