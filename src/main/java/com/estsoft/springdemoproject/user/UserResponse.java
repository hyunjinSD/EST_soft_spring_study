package com.estsoft.springdemoproject.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponse {
    private Long id;
    private String name;
    private String loginId;
    private Integer age;

    public static UserResponse fromEntity(UserEntity userEntity) {
        return new UserResponse(userEntity.getId(), userEntity.getLoginId(), userEntity.getName(), userEntity.getAge());

    }
}
