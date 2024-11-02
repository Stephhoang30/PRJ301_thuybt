/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Executions {
    private int ExecutionID;
    private int Result;

    public Executions() {
    }

    public Executions(int ExecutionID, int Result) {
        this.ExecutionID = ExecutionID;
        this.Result = Result;
    }

    public int getExecutionID() {
        return ExecutionID;
    }

    public void setExecutionID(int ExecutionID) {
        this.ExecutionID = ExecutionID;
    }

    public int getResult() {
        return Result;
    }

    public void setResult(int Result) {
        this.Result = Result;
    }
    
    
}
