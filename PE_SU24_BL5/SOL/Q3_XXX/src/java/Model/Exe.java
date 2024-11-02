/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tra Pham
 */
public class Exe {
    private String InputString,Result,TypeName;
    private int ExecutionID,SubIndex;

    public Exe() {
    }

    public Exe(String InputString, String Result, String TypeName, int ExecutionID, int SubIndex) {
        this.InputString = InputString;
        this.Result = Result;
        this.TypeName = TypeName;
        this.ExecutionID = ExecutionID;
        this.SubIndex = SubIndex;
    }

    public String getInputString() {
        return InputString;
    }

    public void setInputString(String InputString) {
        this.InputString = InputString;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }

    public int getExecutionID() {
        return ExecutionID;
    }

    public void setExecutionID(int ExecutionID) {
        this.ExecutionID = ExecutionID;
    }

    public int getSubIndex() {
        return SubIndex;
    }

    public void setSubIndex(int SubIndex) {
        this.SubIndex = SubIndex;
    }

    @Override
    public String toString() {
        return "Exe{" + "InputString=" + InputString + ", Result=" + Result + ", TypeName=" + TypeName + ", ExecutionID=" + ExecutionID + ", SubIndex=" + SubIndex + '}';
    }
            
}

