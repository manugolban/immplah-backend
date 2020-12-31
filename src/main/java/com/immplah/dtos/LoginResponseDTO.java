package com.immplah.dtos;

import java.io.Serializable;

public class LoginResponseDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String username;
    private String token;
    private String userType;

    public LoginResponseDTO(String id, String username, String token, String userType) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.userType = userType;
    }

    public LoginResponseDTO() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
