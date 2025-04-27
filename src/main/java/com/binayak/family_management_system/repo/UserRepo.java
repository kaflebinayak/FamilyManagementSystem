package com.binayak.family_management_system.repo;

import com.binayak.family_management_system.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer>{
    Users findByEmail(String username);

}
