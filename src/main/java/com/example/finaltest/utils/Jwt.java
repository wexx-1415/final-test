package com.example.finaltest.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Jwt {
    final static String key = "dfagfavcq3r252f@中";

    public static String sign(Object o) {
        String token = "";
        Map<String, Object> m = OtoM.objectToMap(o);
        try {
            Algorithm algorithm = Algorithm.HMAC256(key);
            token = JWT.create()
                    .withPayload(m).withExpiresAt(new Date(new Date().getTime() + 10000000))
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            // Invalid Signing configuration / Couldn't convert Claims.
        }
        return token;
    }


    public static boolean verify(String token) {
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256(key);
            JWTVerifier verifier = JWT.require(algorithm)
                    // specify an specific claim validations
                    // reusable verifier instance
                    .build();

             decodedJWT = verifier.verify(token);
            System.out.println(decodedJWT);
        } catch (JWTVerificationException exception) {
            // Invalid signature/claims
            System.err.println(exception);
            return false;
        }
        return true;
    }
}