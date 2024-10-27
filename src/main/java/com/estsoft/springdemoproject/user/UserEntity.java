package com.estsoft.springdemoproject.user;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private Integer age;

    public static UserEntity createOf(UserRequest userRequest) {
        return new UserEntity(null,userRequest.getLoginId(), userRequest.getPassword(), userRequest.getName(), userRequest.getAge());
    }

    public void update(String name) {
        this.name = name;
    }
}
