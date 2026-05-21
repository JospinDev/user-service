package com.jospin.user_service.user.repository;

import com.jospin.user_service.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailAndIdNot(String email, Long id);
}
