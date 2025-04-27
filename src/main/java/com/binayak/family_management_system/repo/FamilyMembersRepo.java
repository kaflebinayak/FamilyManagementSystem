package com.binayak.family_management_system.repo;

//import com.example.demo.entity.FamilyMembers;
import com.binayak.family_management_system.entity.FamilyMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FamilyMembersRepo extends JpaRepository<FamilyMembers, Long> {

}
