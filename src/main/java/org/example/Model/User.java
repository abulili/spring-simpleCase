package org.example.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
@Data
@Component
public class User {
    @NotBlank
    private String userId, userName, password;
    public User(@JsonProperty("userId") String userId, @JsonProperty("userName") String userName, @JsonProperty("password") String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }
    public User(){

    }
}
