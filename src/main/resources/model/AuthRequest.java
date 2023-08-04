package model;

import lombok.Data;

@Data
public class AuthRequest {
    private String loginId;
    private String password;
}
