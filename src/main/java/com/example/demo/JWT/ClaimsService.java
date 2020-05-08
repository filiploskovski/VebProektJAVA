package com.example.demo.JWT;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class ClaimsService {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private JwtUtil jwtUtil;

    public int GetUserIdFromToken(){

        final String authorizationHeader = request.getHeader("Authorization");
        String jwt = authorizationHeader.substring(7);
        Claims claims  = jwtUtil.extractAllClaims(jwt);
        int id = (int)claims.get("Id");
        return id;

    }
}
