package com.estsoft.springdemoproject.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponse getUser(Long id) {
        UserEntity user = userRepository.findUserEntityById(id)
                .orElseThrow(()
                -> new IllegalArgumentException("User not found"));

        return UserResponse.fromEntity(user);
    }

    public void createUser(UserRequest userRequest) {
        UserEntity user = UserEntity.createOf(userRequest);
        userRepository.save(user);
    }

    public void updateUserName(Long id, String name) {
        UserEntity user = userRepository.findUserEntityById(id)
                .orElseThrow(()
                -> new IllegalArgumentException("User not found"));

        user.update(name);
    }

    public List<UserResponse> getAllUsers() {
        List<UserEntity> all = userRepository.findAll();

        return all
                .stream()
                .map(UserResponse::fromEntity)
                .toList();
    }
}
