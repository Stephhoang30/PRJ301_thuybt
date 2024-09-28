/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author stephhoang
 */
public class Instructor {

    private String InstructorID;
    private String InstructorName;
    private Date BirthDate;
    private int Gender;
    private String SubjectID;

    public Instructor() {
    }

    public Instructor(String InstructorID, String InstructorName, Date BirthDate, int Gender, String SubjectID) {
        this.InstructorID = InstructorID;
        this.InstructorName = InstructorName;
        this.BirthDate = BirthDate;
        this.Gender = Gender;
        this.SubjectID = SubjectID;
    }

    public String getInstructorID() {
        return InstructorID;
    }

    public void setInstructorID(String InstructorID) {
        this.InstructorID = InstructorID;
    }

    public String getInstructorName() {
        return InstructorName;
    }

    public void setInstructorName(String InstructorName) {
        this.InstructorName = InstructorName;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int Gender) {
        this.Gender = Gender;
    }

    public String getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(String SubjectID) {
        this.SubjectID = SubjectID;
    }

}
