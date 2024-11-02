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
public class Class {

    private int classID;
    private String className;
    private Date startDate;

    public Class() {
    }

    public Class(int classID, String className, Date startDate) {
        this.classID = classID;
        this.className = className;
        this.startDate = startDate;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Class{" + "classID=" + classID + ", className=" + className + ", startDate=" + startDate + '}';
    }

}
