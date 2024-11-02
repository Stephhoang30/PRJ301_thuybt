/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author stephhoang
 */
public class DepartPlaces {

    private int departPlaceID;
    private String departPlaceName;

    public DepartPlaces() {
    }

    public DepartPlaces(int departPlaceID, String departPlaceName) {
        this.departPlaceID = departPlaceID;
        this.departPlaceName = departPlaceName;
    }

    public int getDepartPlaceID() {
        return departPlaceID;
    }

    public void setDepartPlaceID(int departPlaceID) {
        this.departPlaceID = departPlaceID;
    }

    public String getDepartPlaceName() {
        return departPlaceName;
    }

    public void setDepartPlaceName(String departPlaceName) {
        this.departPlaceName = departPlaceName;
    }

}
