package com.shrimali.schoolonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shrimali.schoolonline.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
