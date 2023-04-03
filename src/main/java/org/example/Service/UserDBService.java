package org.example.Service;

import org.example.DAO.UserDao;
import org.example.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
@Service
public class UserDBService {
    private final UserDao userDao;
    @Autowired
    public UserDBService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User selectUser(String UserName, String password) {
        Optional<User> optionalUser = userDao.selectUser(UserName, password);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return new User();
        }
//        return userDao.selectUser(UserName, password).orElseThrow(new User());
    }
    public User selectUserName(String UserName) {
        Optional<User> optionalUser = userDao.selectUserName(UserName);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return new User();
        }
    }
    public boolean insertUser(String UserName, String password) {
        return userDao.insertUser(UserName, password);
    }
}
