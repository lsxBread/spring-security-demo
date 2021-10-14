package com.security.demo.repositories;

import com.security.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u join fetch u.authorities a where u.username=:username")
    User findByUserName(@Param("username") String username);
}
