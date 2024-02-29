package com.SecurityLoginWithDatabase.repository;

import com.SecurityLoginWithDatabase.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
