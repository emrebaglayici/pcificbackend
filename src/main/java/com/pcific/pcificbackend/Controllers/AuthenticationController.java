package com.pcific.pcificbackend.Controllers;

import com.pcific.pcificbackend.Business.Abstracts.IAuthenticationService;
import com.pcific.pcificbackend.Business.Abstracts.IUserService;
import com.pcific.pcificbackend.Controllers.Dtos.UserSignInDto;
import com.pcific.pcificbackend.Controllers.Dtos.UserSignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authentication")//pre-path
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IUserService userService;

    @PostMapping("sign-up")
    public ResponseEntity<?> signUp(@RequestBody UserSignUpDto userDto){
        if(userService.findByUsername(userDto.toUser().getUsername()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(userDto),HttpStatus.CREATED);
    }

    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestBody UserSignInDto userSignInDto){
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(userSignInDto),HttpStatus.OK);
    }

}