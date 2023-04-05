package org.example.DAO;

import org.example.DAO.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.example.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("mysql")
@Component
public class UserDaoAccessService implements UserDao {
    private final JdbcTemplate jdbcTemplate;
    public UserDaoAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Optional<User> selectUser(String userName, String password) {
        User user_in = new User(userName, userName, password);
        final String sql = """
               select * from user where userName = ? and password = ?;
                """;
                List<User> user = jdbcTemplate.query(sql,(resultSet, i) -> {
             return new User(
                     resultSet.getString("userId"),
                    resultSet.getString("userName"),
                    resultSet.getString("password")
            );
        }, userName, password);
        System.out.println(user);
        return user.stream().findFirst();
    }
    @Override
    public Optional<User> selectUserName(String UserName) {
        final String sql = """
               select * from user where userName = ?;
                """;
        List<User> personList = jdbcTemplate.query(sql,(resultSet, i) -> {
            return new User(
                    resultSet.getString("userId"),
                    resultSet.getString("username"),
                    resultSet.getString("password")
            );
        }, UserName);
        return personList.stream().findFirst();
    }
    @Override
    public boolean insertUser(String UserName, String password){
        final String sql = """
                insert into user value(?,?,?);
                """;
        int result = jdbcTemplate.update(sql, UserName, UserName, password);
        if(result > 0) {
            System.out.println("A new row has been inserted");
            return true;
        }
        else {
            System.out.println("Insert failed");
            return false;
        }
    }
    @Override
    public User selectUserName2(String UserName) {
        final String sql = """
           select * from user where userName = ?;
            """;
        Optional<User> userOptional = jdbcTemplate.query(sql,(resultSet, i) -> {
            return new User(
                    resultSet.getString("userId"),
                    resultSet.getString("username"),
                    resultSet.getString("password")
            );
        }, UserName).stream().findFirst();
        return userOptional.orElse(null);
    }
    @Override
    public UserDetails findUser(String UserName) {
        User users = selectUserName2(UserName);
        if(users == null) {
            throw new UsernameNotFoundException("User not found with email: " + UserName);
        }
        return new org.springframework.security.core.userdetails.User(users.getUserName(), users.getPassword(), new ArrayList<>());
    }
}
