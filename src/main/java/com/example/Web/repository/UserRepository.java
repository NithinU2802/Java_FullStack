package com.example.Web.repository;

import com.example.Web.models.Role;
import com.example.Web.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String mail);
    User findByUserName(String name);
}
