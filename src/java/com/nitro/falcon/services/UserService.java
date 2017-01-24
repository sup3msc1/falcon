package com.nitro.falcon.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.nitro.falcon.models.User;
import com.sun.istack.Nullable;
import java.io.UnsupportedEncodingException;

/**
 * UserService
 * @author leops
 */
public class UserService {
    public @Nullable String getToken(final User user) {
        try {
            return JWT.create()
                    .withSubject(user.username)
                    .sign(Algorithm.HMAC256("secret"));
        } catch(final JWTCreationException | UnsupportedEncodingException err) {
            err.printStackTrace();
            return null;
        }
    }
    
    public @Nullable User fromToken(final String token) {
        try {
            JWT.decode(token).getSubject();
            return null;
        } catch (final JWTDecodeException err){
            err.printStackTrace();
            return null;
        }
    }
}
