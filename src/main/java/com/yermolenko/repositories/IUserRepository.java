package com.yermolenko.repositories;

import java.util.UUID;

import com.yermolenko.models.impl.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

    User getByGuid(UUID guid);
}
