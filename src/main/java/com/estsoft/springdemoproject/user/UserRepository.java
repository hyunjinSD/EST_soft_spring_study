package com.estsoft.springdemoproject.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityById(Long id);

     /*
 SELECT *
 FROM USER
 WHERE USER.ID = {id}
 AND USER.NAME = {name}
  */
}
