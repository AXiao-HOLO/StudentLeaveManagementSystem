package com.student.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {
    private static String signKey = "SVRIRUlNQQ=="; // 签名密钥, 用于对JWT令牌进行签名
    private static Long expire = 43200000L;         // 过期时间, 12小时

    // claims: 声明, 用于存储用户信息
    /**
     * 生成JWT令牌
     * @return
     */
    public static String generateJwt(Map<String,Object> claims){
        String jwt = Jwts.builder()     // 构建JWT令牌
                .addClaims(claims)      // 添加自定义声明
                .signWith(SignatureAlgorithm.HS256, signKey)      // 签名算法和密钥
                .setExpiration(new Date(System.currentTimeMillis() + expire))      // 过期时间
                .compact();      // 生成JWT令牌
        return jwt;
    }

    /**
     * 解析JWT令牌
     * @param jwt JWT令牌
     * @return JWT第二部分负载 payload 中存储的内容
     */
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser()     // 解析JWT令牌
                .setSigningKey(signKey)      // 设置签名密钥
                .parseClaimsJws(jwt)        // 解析JWT令牌
                .getBody();                 // 获取JWT第二部分负载 payload 中存储的内容
        return claims;
    }
}
