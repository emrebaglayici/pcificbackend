package com.pcific.pcificbackend.Business.Abstracts;

import com.pcific.pcificbackend.Controllers.Dtos.UserSignInDto;
import com.pcific.pcificbackend.Entities.User;

public interface IAuthenticationService {
    User signInAndReturnJWT(UserSignInDto signInRequest);

}
