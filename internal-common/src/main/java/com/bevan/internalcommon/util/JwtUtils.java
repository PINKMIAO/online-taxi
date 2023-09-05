package com.bevan.internalcommon.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bevan.internalcommon.responese.TokenResult;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zbf
 * 2023/7/9 23:39
 */
public class JwtUtils {

    /**
     * 盐
     */
    private static final String SIGN = "ZBF$$Bevan!";
    private static final String JWT_KEY_PHONE = "phone";

    /**
     * 假定，乘客是1， 司机是2
     */
    private static final String JWT_KEY_IDENTITY = "identity";
    private static final String JWT_TOKEN_TYPE = "tokenType";
    private static final String JWT_TOKEN_TIME = "tokenTime";

    /**
     * 生成Token
     */
    public static String generatorToken(String passengerPhone, String identity, String tokenType) {
        Map<String, String> map = new HashMap<>(16);
        map.put(JWT_KEY_PHONE, passengerPhone);
        map.put(JWT_KEY_IDENTITY, identity);
        map.put(JWT_TOKEN_TYPE, tokenType);
        map.put(JWT_TOKEN_TIME, Calendar.getInstance().getTime().toString());

        JWTCreator.Builder builder = JWT.create();
        // 整合map
        map.forEach(builder::withClaim);
        // 整合过期时间 -- 现在改为用redis去控制时间
        // builder.withExpiresAt(date);
        // 生成 token
        return builder.sign(Algorithm.HMAC256(SIGN));
    }

    /**
     * 解析token
     */
    public static TokenResult paresToken(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        // 通过.toString取出的值可能会存在将 双引号一起加进去了 例如： 原本是希望 131313的字符串 但是.toString却将变成 "131313"，
        // 所以改成 .asString 就能避免这个情况
        String phone = verify.getClaim(JWT_KEY_PHONE).asString();
        String identity = verify.getClaim(JWT_KEY_IDENTITY).asString();

        TokenResult tokenResult = new TokenResult();
        tokenResult.setIdentity(identity);
        tokenResult.setPhone(phone);
        return tokenResult;
    }

    public static TokenResult checkToken(String token) {
        TokenResult tokenResult = null;
        try {
            tokenResult = paresToken(token);
        } catch (Exception ignored) {

        }
        return tokenResult;
    }

    public static void main(String[] args) {
        // HashMap<String, String> map = new HashMap<>();
        // map.put("name", "bevan");
        // map.put("pwd", "12313");
        // map.put("age", "18");
        // String s = JwtUtils.generatorToken(map);
        String s = generatorToken("13134432222", "1", "access");
        System.out.println("生成的token：" + s);
        System.out.println("解析token：" + paresToken(s));
    }
}
