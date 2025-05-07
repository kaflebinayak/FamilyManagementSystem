package com.binayak.family_management_system.controller;


import com.binayak.family_management_system.dto.Response.FamilyMemberResponse;
import com.binayak.family_management_system.dto.request.FamilyMembersRequest;
import com.binayak.family_management_system.service.FamilyMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/familyMember")
public class FamilyMembersController {
    private final FamilyMemberService familyMembersService;

    @PostMapping("/saveMembers")
    public ResponseEntity<FamilyMemberResponse> saveMembers(@RequestBody FamilyMembersRequest familyMember){
        return  new ResponseEntity<>(familyMembersService.saveFamilyMember(familyMember), HttpStatus.OK);

    }

    @PutMapping("/updateMembers")
    public ResponseEntity<FamilyMemberResponse> updateMembers(@RequestParam Long familyMemberId, @RequestBody FamilyMembersRequest familyMember) {
        return ResponseEntity.status(HttpStatus.OK).body(familyMembersService.updateFamilyMember(familyMemberId, familyMember));
    }

    @GetMapping("/allMembers/{userId}")
    public ResponseEntity<List<FamilyMemberResponse>> getAllMembers( @PathVariable int userId){
        return new ResponseEntity<>(familyMembersService.getAllFamilyMembers(userId),HttpStatus.OK);
    }

    @GetMapping("/getMember/{familyMemberId}")
    public ResponseEntity<FamilyMemberResponse> getMemberById(@PathVariable Long familyMemberId){
        return new ResponseEntity<>(familyMembersService.getFamilyMemberById(familyMemberId),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{familyMemberId}")
    public ResponseEntity<String> deleteFamilyMembersById(@PathVariable Long familyMemberId) {
        return new ResponseEntity<>(familyMembersService.deleteFamilyMembersById(familyMemberId), HttpStatus.OK);
    }

}
