package com.pcific.pcificbackend.Security;

public interface ISecurityUserService {

    String validatePasswordResetToken(String token);

}
