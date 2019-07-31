package com.example.healthbackend.Entity;

public class DoctorWithBLOBs extends Doctor {

    private String description;

    private String edu_background;

    private String award;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getEdu_background() {
        return edu_background;
    }

    public void setEdu_background(String edu_background) {
        this.edu_background = edu_background == null ? null : edu_background.trim();
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award == null ? null : award.trim();
    }
}