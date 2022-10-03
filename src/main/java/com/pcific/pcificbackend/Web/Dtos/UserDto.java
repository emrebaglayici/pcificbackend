package com.pcific.pcificbackend.Web.Dtos;

import com.pcific.pcificbackend.Validation.PasswordMatches;
import com.pcific.pcificbackend.Validation.ValidEmail;
import com.pcific.pcificbackend.Validation.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordMatches @Getter @Setter
public class UserDto {
    @NotNull
    @Size(min = 1, message = "{Size.userDto.firstName}")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "{Size.userDto.lastName}")
    private String lastName;

    @ValidPassword
    private String password;

    @NotNull
    @Size(min = 1)
    private String matchingPassword;

    @ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
    private String email;

    private Integer role;

    @Override
    public String toString() {
        return "UserDto [firstName=" +
                firstName +
                ", lastName=" +
                lastName +
                ", email=" +
                email +
                ", role=" +
                role + "]";
    }

}
