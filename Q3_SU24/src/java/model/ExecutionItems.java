/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class ExecutionItems{
    private int ExecutionItemID;
    private int ArrayItem;
    private int ExecutionID;

    public ExecutionItems() {
    }

    public ExecutionItems(int ExecutionItemID, int ArrayItem, int ExecutionID) {
        this.ExecutionItemID = ExecutionItemID;
        this.ArrayItem = ArrayItem;
        this.ExecutionID = ExecutionID;
    }

    public int getExecutionItemID() {
        return ExecutionItemID;
    }

    public void setExecutionItemID(int ExecutionItemID) {
        this.ExecutionItemID = ExecutionItemID;
    }

    public int getArrayItem() {
        return ArrayItem;
    }

    public void setArrayItem(int ArrayItem) {
        this.ArrayItem = ArrayItem;
    }

    public int getExecutionID() {
        return ExecutionID;
    }

    public void setExecutionID(int ExecutionID) {
        this.ExecutionID = ExecutionID;
    }
    
    
}
