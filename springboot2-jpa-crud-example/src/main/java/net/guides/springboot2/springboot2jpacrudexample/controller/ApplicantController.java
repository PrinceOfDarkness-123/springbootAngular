
package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.validation.Valid;
import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Applicant;
import net.guides.springboot2.springboot2jpacrudexample.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ApplicantController {
    @Autowired
    private ApplicantRepository applicantRepository;
    
    @GetMapping("applicants")
    public List<Applicant>  getAllApplicants(){
        return applicantRepository.findAll();
    }
    @GetMapping("/applicants/{id}")
    public ResponseEntity<Applicant> getApplicantById(@PathVariable(value = "id") Long applicantId)
    throws ResourceNotFoundException{
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + applicantId));
        return ResponseEntity.ok().body(applicant);
    }
    @PostMapping("applicants")
    public Applicant createApplicant(@Valid @RequestBody Applicant applicant){
        return applicantRepository.save(applicant);
    }
    @PutMapping("/applicant/{id}")
    public ResponseEntity<Applicant> updateApplicant(@PathVariable(value = "id") Long applicantId, 
            @Valid @RequestBody Applicant applicantDetails) throws ResourceNotFoundException{
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + applicantId));
        
        applicant.setFullName(applicantDetails.getFullName());
        applicant.setEmailAddress(applicantDetails.getEmailAddress());
        applicant.setPhoneNumber(applicantDetails.getPhoneNumber());
        applicant.setStreetAddress(applicantDetails.getStreetAddress());
        applicant.setDegree(applicantDetails.getDegree());
        applicant.setSchool(applicantDetails.getSchool());
        applicant.setAchievements(applicantDetails.getAchievements());
        
        final Applicant updatedApplicant = applicantRepository.save(applicant);
        return ResponseEntity.ok(updatedApplicant);
    }
    @DeleteMapping("/applicant/{id}")
    public Map<String, Boolean> deleteApplicant(@PathVariable(value = "id") Long applicantId)
            throws ResourceNotFoundException{
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + applicantId));
        applicantRepository.delete(applicant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
