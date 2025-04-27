package com.binayak.family_management_system.service.impl;


import com.binayak.family_management_system.dto.Response.FamilyResponse;
import com.binayak.family_management_system.dto.request.FamilyRequest;
import com.binayak.family_management_system.entity.Family;
import com.binayak.family_management_system.repo.FamilyRepo;
import com.binayak.family_management_system.service.FamilyService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FamilyServiceImpl implements FamilyService {

    private final FamilyRepo familyRepo ;

    @Override
    public FamilyResponse saveFamily(FamilyRequest familyRequest) {
        log.info("Saving Family{}", familyRequest);
        Family family= new Family();
        family.setFamilyName(familyRequest.getFamilyName());
        family.setColonyName(familyRequest.getColonyName());
        family.setNumberOfFamily(familyRequest.getNumberOfFamily());
        Family savedFamily=familyRepo.save(family);


        return new FamilyResponse(savedFamily);
    }

    @Override
    public List<FamilyResponse> getAllFamily() {
        List<Family> families = familyRepo.findAll();
        return families.stream().map(FamilyResponse::new).toList();
    }

    @Override
    public FamilyResponse getById(Long familyId) {
        Family family = familyRepo.findById(familyId)
                .orElseThrow(()-> new EntityNotFoundException("Family not exist with provided id"));
        return new FamilyResponse(family);
    }


    @Override
    public String deleteFamilyById(Long familyId) {
        Family family = familyRepo.findById(familyId)
                .orElseThrow(()-> new EntityNotFoundException("Family not exist with provided id"));
        familyRepo.delete(family);
        return "Deleted successfully";
    }

    @Override
    public List<FamilyResponse> getByName(String familyName) {
        List<Family> families = familyRepo.findByFamilyName(familyName);
        return families.stream().map(FamilyResponse::new).toList();
    }

    @Override
    public List<FamilyResponse> saveFamilies(List<FamilyRequest> families) {
        List<Family> savedFamily = families.stream().map(
                familyRequest -> {
                    return familyRepo.save(
                            Family.builder()
                                    .numberOfFamily(familyRequest.getNumberOfFamily())
                                    .familyName(familyRequest.getFamilyName())
                                    .colonyName(familyRequest.getColonyName())
                                    .build()
                    );
                }
        ).toList();
        return savedFamily.stream().map(FamilyResponse::new).toList();
    }
}
