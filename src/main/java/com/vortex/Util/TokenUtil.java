package com.vortex.Util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

public class TokenUtil {

    private static final String iss = "Vortex"; //签发人
    private static final int exp = 60 * 60 * 1000; //过期时间一小时 单位:毫秒(ms)
    private static final String key = "abcdefg"; //密钥

    //加密
    public static String getToken(String username, String userid) {
        String token = JWT.create()
                .withIssuer(iss)//设置签发人
                .withClaim("username", username)//设置负载信息1
                .withClaim("userid", userid)//设置负载信息2
                .withExpiresAt(new Date(System.currentTimeMillis() + exp))//设置到期时间
                .sign(Algorithm.HMAC256(key));//使用HMAC256算法加密
        return token;
    }

    //解密
    public static Map<String, Claim> checkToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256((key)))
                .withIssuer(iss)
                .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        return claims;
    }

}
