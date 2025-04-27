package com.binayak.family_management_system.repo;


import com.binayak.family_management_system.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FamilyRepo extends JpaRepository<Family,Long> {
    List<Family>findByFamilyName(String familyName);

}
