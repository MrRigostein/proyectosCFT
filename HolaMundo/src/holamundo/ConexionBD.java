/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundo;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBD {

    Connection conectar = null;

    public Connection connect() 
    {
        try
        {
            Class.forName("org.gjt.mm.mysql.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatosyoyo", "root", "");
            System.out.println("Conexion Establecida");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return conectar;
    }

}
