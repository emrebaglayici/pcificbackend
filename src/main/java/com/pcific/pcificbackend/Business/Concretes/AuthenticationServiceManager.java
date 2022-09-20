package com.pcific.pcificbackend.Business.Concretes;

import com.pcific.pcificbackend.Business.Abstracts.IAuthenticationService;
import com.pcific.pcificbackend.Controllers.Dtos.UserSignInDto;
import com.pcific.pcificbackend.Entities.User;
import com.pcific.pcificbackend.Security.Jwt.JwtProvider;
import com.pcific.pcificbackend.Security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceManager implements IAuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User signInAndReturnJWT(UserSignInDto signInRequest){
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),signInRequest.getPassword())
        );
        UserPrincipal userPrincipal=(UserPrincipal) authentication.getPrincipal();
        String jwt=jwtProvider.generateToken(userPrincipal);

        User signInUser=userPrincipal.getUser();
        signInUser.setToken(jwt);
        return signInUser;
    }
}
