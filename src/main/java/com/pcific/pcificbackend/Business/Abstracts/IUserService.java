package com.pcific.pcificbackend.Business.Abstracts;

import com.pcific.pcificbackend.Entities.PasswordResetToken;
import com.pcific.pcificbackend.Entities.User;
import com.pcific.pcificbackend.Entities.VerificationToken;
import com.pcific.pcificbackend.Web.Dtos.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Page<User> listCustomers(Pageable pageable);
    User registerNewUserAccount(UserDto accountDto);

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void deleteUser(User user);

    void createVerificationTokenForUser(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    VerificationToken generateNewVerificationToken(String token);

    void createPasswordResetTokenForUser(User user, String token);

    User findUserByEmail(String email);

    PasswordResetToken getPasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    Optional<User> getUserByID(long id);

    void changeUserPassword(User user, String password);

    boolean checkIfValidOldPassword(User user, String password);

    String validateVerificationToken(String token);



    List<String> getUsersFromSessionRegistry();

}