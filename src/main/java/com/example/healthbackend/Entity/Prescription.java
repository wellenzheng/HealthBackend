package com.example.healthbackend.Entity;

import java.util.Date;

public class Prescription {
    private Long id;

    private Date date;

    private String department;

    private String pat_username;

    private String doc_username;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getPat_username() {
        return pat_username;
    }

    public void setPat_username(String pat_username) {
        this.pat_username = pat_username == null ? null : pat_username.trim();
    }

    public String getDoc_username() {
        return doc_username;
    }

    public void setDoc_username(String doc_username) {
        this.doc_username = doc_username == null ? null : doc_username.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}