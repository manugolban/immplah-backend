package com.immplah.security.payload.response;

import java.util.List;
import java.util.UUID;

public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private UUID id;
    private String username;
    private String userType;

    public JwtResponse(String token, UUID id, String username, String userType) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.userType = userType;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}