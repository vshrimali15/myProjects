package com.shrimali.schoolonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shrimali.schoolonline.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
