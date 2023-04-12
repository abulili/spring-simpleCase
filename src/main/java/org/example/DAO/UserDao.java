package org.example.DAO;

import org.example.Model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserDao {
    Optional<User> selectUser(String UserName, String password);
    Optional<User> selectUserName(String UserName);
    boolean insertUser(String UserName, String password);
    //jwt
    User selectUserName2(String UserName);
    UserDetails findUser(String UserName);
}
