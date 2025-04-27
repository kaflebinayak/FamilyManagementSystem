package com.binayak.family_management_system.service.impl;


import com.binayak.family_management_system.repo.FamilyMembersRepo;
import com.binayak.family_management_system.service.FamilyMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class FamilyMembersImpl implements FamilyMemberService {
    private final FamilyMembersRepo familyMembersRepo;


}
