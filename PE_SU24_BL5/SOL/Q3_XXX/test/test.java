
import Model.Exe;
import dal.ExeDAO;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Tra Pham
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExeDAO dao  = new ExeDAO();
        ArrayList<Exe> list = dao.getExe("","");
        for (Exe exe : list) {
            System.out.println(exe);
        }
    }
    
}
