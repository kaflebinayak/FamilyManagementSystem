package com.binayak.family_management_system.controller;


import com.binayak.family_management_system.dto.Response.FamilyResponse;
import com.binayak.family_management_system.dto.request.FamilyRequest;
import com.binayak.family_management_system.service.FamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/family")
@RestController
@RequiredArgsConstructor
public class FamilyController {

    private final FamilyService familyService;

    @PostMapping("/save")
    public ResponseEntity<FamilyResponse> save (@RequestBody FamilyRequest family){
        return new ResponseEntity<>(familyService.saveFamily(family), HttpStatus.OK);
    }

    @PostMapping("/save/list")
    public ResponseEntity<List<FamilyResponse>> saveAll (@RequestBody List<FamilyRequest> families){
        return new ResponseEntity<>(familyService.saveFamilies(families), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FamilyResponse>> getAll(){
        return new ResponseEntity<>(familyService.getAllFamily(), HttpStatus.OK);
    }

    @GetMapping("/get/{familyId}")
    public  ResponseEntity<FamilyResponse> getFamily(@PathVariable Long familyId){
        return new ResponseEntity<>(familyService.getById(familyId), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{familyId}")
    public ResponseEntity<String> deleteFamily(@PathVariable Long familyId) {
        return new ResponseEntity<>(familyService.deleteFamilyById(familyId), HttpStatus.OK);
    }
    @GetMapping("/getByName/{familyName}")
    public  ResponseEntity<List<FamilyResponse>> getFamilyByName(@PathVariable String familyName) {
        return new ResponseEntity<>(familyService.getByName(familyName), HttpStatus.OK);
    }
}
