package com.binayak.family_management_system.service;

import com.binayak.family_management_system.dto.Response.FamilyMemberResponse;
import com.binayak.family_management_system.dto.request.FamilyMembersRequest;

import java.util.List;

public interface FamilyMemberService {
    FamilyMemberResponse saveFamilyMember(FamilyMembersRequest request);

    List<FamilyMemberResponse> getAllFamilyMembers(int userId);

    FamilyMemberResponse getFamilyMemberById(Long familyMemberId);

    String deleteFamilyMembersById(Long familyMemberId);

    FamilyMemberResponse updateFamilyMember(Long familyMemberId, FamilyMembersRequest familyMember);
}
