package ajedrezjava;

import connection.Register;
import java.io.Serializable;

public class AjedrezJava implements Serializable{
    public static void main(String[] args) {
        /*mainFrame rgt = new mainFrame();
        rgt.setVisible(true);
        rgt.setLocationRelativeTo(null);
        */
        Register rg = new Register();
        rg.setVisible(true);
        rg.setLocationRelativeTo(null);
    }
}