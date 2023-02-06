package com.ticket.core.api.repositories;

import com.ticket.core.api.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
