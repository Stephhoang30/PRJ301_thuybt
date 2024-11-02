/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author stephhoang
 */
public class Coaches {

    private String coachID;
    private String coachName;
    private String position;
    private int salary;
    private int teamID;

    public Coaches() {
    }

    public Coaches(String coachID, String coachName, String position, int salary, int teamID) {
        this.coachID = coachID;
        this.coachName = coachName;
        this.position = position;
        this.salary = salary;
        this.teamID = teamID;
    }

    public String getCoachID() {
        return coachID;
    }

    public void setCoachID(String coachID) {
        this.coachID = coachID;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    @Override
    public String toString() {
        return "Coach{" + "coachID=" + coachID + ", coachName=" + coachName + ", position=" + position + ", salary=" + salary + ", teamID=" + teamID + '}';
    }

}
