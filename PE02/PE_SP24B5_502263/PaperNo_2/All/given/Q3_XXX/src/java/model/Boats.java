/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author stephhoang
 */
public class Boats {

    private String boatID;
    private String boatName;
    private String departPlaceName;
    private String ticketName;
    private int seat;
    private int booked;
    private int departPlaceID;
    private int ticketID;

    public Boats() {
    }

    public Boats(String boatID, String boatName, String departPlaceName, String ticketName, int seat, int booked) {
        this.boatID = boatID;
        this.boatName = boatName;
        this.departPlaceName = departPlaceName;
        this.ticketName = ticketName;
        this.seat = seat;
        this.booked = booked;
    }

    public String getBoatID() {
        return boatID;
    }

    public void setBoatID(String boatID) {
        this.boatID = boatID;
    }

    public String getBoatName() {
        return boatName;
    }

    public void setBoatName(String boatName) {
        this.boatName = boatName;
    }

    public String getDepartPlaceName() {
        return departPlaceName;
    }

    public void setDepartPlaceName(String departPlaceName) {
        this.departPlaceName = departPlaceName;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public int getDepartPlaceID() {
        return departPlaceID;
    }

    public void setDepartPlaceID(int departPlaceID) {
        this.departPlaceID = departPlaceID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    @Override
    public String toString() {
        return "Boats{" + "boatID=" + boatID + ", boatName=" + boatName + ", departPlaceName=" + departPlaceName + ", ticketName=" + ticketName + ", seat=" + seat + ", booked=" + booked + ", departPlaceID=" + departPlaceID + ", ticketID=" + ticketID + '}';
    }

}
