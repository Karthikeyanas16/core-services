package com.lti.mod.services.coreservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lti.mod.services.coreservices.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);



}
