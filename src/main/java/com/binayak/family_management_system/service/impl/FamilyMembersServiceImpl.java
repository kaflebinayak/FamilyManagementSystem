package com.binayak.family_management_system.service.impl;


import com.binayak.family_management_system.dto.Response.FamilyMemberResponse;
import com.binayak.family_management_system.dto.request.FamilyMembersRequest;
import com.binayak.family_management_system.entity.FamilyMembers;
import com.binayak.family_management_system.entity.Users;
import com.binayak.family_management_system.repo.FamilyMembersRepo;
import com.binayak.family_management_system.repo.UserRepo;
import com.binayak.family_management_system.service.FamilyMemberService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service

public class FamilyMembersServiceImpl implements FamilyMemberService {
    private final FamilyMembersRepo familyMembersRepo;
    private final UserRepo userRepo;
//    @Override
    public FamilyMemberResponse saveFamilyMember(FamilyMembersRequest familyMembersRequest){
        Users user = userRepo.
                findById(familyMembersRequest.getUserId())
                        .orElseThrow(()->new EntityNotFoundException("User not found"));
        log.info("Saving FamilyMember{}", familyMembersRequest);
        FamilyMembers familyMembers= new FamilyMembers();
        familyMembers.setFristName(familyMembersRequest.getFristName());
        familyMembers.setLastName(familyMembersRequest.getLastName());
        familyMembers.setGender(familyMembersRequest.getGender());
        familyMembers.setPhone(familyMembersRequest.getPhone());
        familyMembers.setAddress(familyMembersRequest.getAddress());
        familyMembers.setAge(familyMembersRequest.getAge());
        FamilyMembers savedFamilyMembers=familyMembersRepo.save(familyMembers);

        user.getFamilies().add(savedFamilyMembers);
        userRepo.save(user);
        return new FamilyMemberResponse(savedFamilyMembers);
    }

    @Override
    public List<FamilyMemberResponse> getAllFamilyMembers(int userId){
        Users user = userRepo.findById(userId)
                .orElseThrow(()->new EntityNotFoundException("User not found"));
        List<FamilyMembers> familyMembers = user.getFamilies();
        if (familyMembers == null) {
            return null;
        }
        return familyMembers.stream().map(FamilyMemberResponse::new).toList();
    }

    @Override
    public FamilyMemberResponse getFamilyMemberById(Long familyMemberId) {
        FamilyMembers familyMembers = familyMembersRepo.findById(familyMemberId)
                .orElseThrow(()->new RuntimeException("Member not found"));
        return new FamilyMemberResponse(familyMembers);
    }

    @Override
    public String deleteFamilyMembersById(Long familyMemberId) {
        FamilyMembers familyMembers = familyMembersRepo.findById(familyMemberId)
                .orElseThrow(()->new RuntimeException("Member not found"));
        familyMembersRepo.delete(familyMembers);
        return "Deleted successfully";
    }

    @Override
    public FamilyMemberResponse updateFamilyMember(Long familyMemberId, FamilyMembersRequest familyMember) {
        FamilyMembers familyMembers = familyMembersRepo.findById(familyMemberId)
                .orElseThrow(()->new RuntimeException("Member not found"));
        familyMembers.setFristName(familyMember.getFristName());
        familyMembers.setLastName(familyMembers.getLastName());
        familyMembers.setGender(familyMember.getGender());
        familyMembers.setPhone(familyMember.getPhone());
        familyMembers.setAddress(familyMember.getAddress());
        familyMembers.setAge(familyMember.getAge());
        return new FamilyMemberResponse(familyMembersRepo.save(familyMembers));
    }


}
