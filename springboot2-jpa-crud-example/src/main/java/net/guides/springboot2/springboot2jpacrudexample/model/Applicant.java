/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.guides.springboot2.springboot2jpacrudexample.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "applicants")
public class Applicant implements Serializable{
    private long id;
    private String fullName;
    private String emailAddress;
    private String phoneNumber;
    private String streetAddress;
    private String degree;
    private String school;
    private String achievements;
    private String startDate;
    private String endDate;
    
    
    public Applicant(){
        
    }
    public Applicant(
            String fullName, 
            String emailAddress, 
            String phoneNumber,
            String streetAddress,
            String degree, 
            String school,
            String achievements,
            String startDate,
            String endDate
            
    ){
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.degree = degree;
        this.school = school;
        this.achievements = achievements;
        this.startDate = startDate;
        this.endDate = endDate;
        
        
        
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
       public long getId(){
           return id;
       }
       public void setId(long id) {
        this.id = id;
    }
       
    @Column(name = "full_name", nullable = false)
       public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @Column(name = "email_address", nullable = false)
       public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    @Column(name = "phone_number", nullable = false)
       public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Column(name = "street_address", nullable = false)
       public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    @Column(name = "degree", nullable = false)
       public String getDegree() {
        return degree;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }
    @Column(name = "school", nullable = false)
       public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    @Column(name = "achievements", nullable = false)
       public String getAchievements() {
        return achievements;
    }
    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }
    @Column(name = "start_date", nullable = false)
       public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    @Column(name = "end_date", nullable = false)
       public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    
    @Override
    public String toString(){
        return "Applicant[id=" + id + ", fullName=" + fullName + ", email_address=" + emailAddress + ", phone_number=" + phoneNumber + ", street_address=" + streetAddress + ", degree=" + degree + ", school=" + school + ", achievements=" + achievements + "]";
    }
    
    
}
