package com.example.trialtask.repository;

import com.example.trialtask.model.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    boolean findByEmail(String email);

    User findByName(String username);
}
