/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tra Pham
 */
public class StringQ2 {
    private String str,index,result;

    public StringQ2() {
    }

    public StringQ2(String str, String index, String result) {
        this.str = str;
        this.index = index;
        this.result = result;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "StringQ2{" + "str=" + str + ", index=" + index + ", result=" + result + '}';
    }
    
}
