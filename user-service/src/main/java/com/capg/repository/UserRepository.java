package com.capg.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capg.entity.UserData;
@Repository
public interface UserRepository extends MongoRepository<UserData, Integer> {

    Optional<UserData> getUserDataByEmail(String email);

    Optional<UserData> getUserDataByUsername(String username);

}
