package com.binayak.family_management_system.service;

import com.binayak.family_management_system.dto.Response.FamilyResponse;
import com.binayak.family_management_system.dto.request.FamilyRequest;

import java.util.List;

public interface FamilyService {
    FamilyResponse saveFamily(FamilyRequest familyRequest);
    List <FamilyResponse> getAllFamily();
    FamilyResponse getById(Long familyId);

    String deleteFamilyById(Long familyId);

    List<FamilyResponse> getByName(String familyName);

    List<FamilyResponse> saveFamilies(List<FamilyRequest> families);
}
