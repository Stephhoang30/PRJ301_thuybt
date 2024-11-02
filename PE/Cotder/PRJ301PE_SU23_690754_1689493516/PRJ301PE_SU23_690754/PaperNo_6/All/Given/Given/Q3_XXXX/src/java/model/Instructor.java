/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;

/**
 *
 * @author stephhoang
 */
public class Instructor {

    private String instructorID;
    private String instructorName;
    private Date birthDate;
    private boolean gender;
    private int classID;

    public Instructor() {
    }

    public Instructor(String instructorID, String instructorName, Date birthDate, boolean gender, int classID) {
        this.instructorID = instructorID;
        this.instructorName = instructorName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.classID = classID;
    }

    public String getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(String instructorID) {
        this.instructorID = instructorID;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    @Override
    public String toString() {
        return "Instructor{" + "instructorID=" + instructorID + ", instructorName=" + instructorName + ", birthDate=" + birthDate + ", gender=" + gender + ", classID=" + classID + '}';
    }

}
