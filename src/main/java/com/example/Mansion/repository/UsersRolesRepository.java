package com.example.Mansion.repository;

import com.example.Mansion.entity.UserRoleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UsersRolesRepository extends MongoRepository<UserRoleEntity, String> {
}
