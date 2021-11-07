
package controller;

import view.VentanaPrincipal;
import java.sql.*;
import model.Inicio;

public class ControladorInicio {
    public boolean probarInicio(Inicio s){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels", s.usuario, s.contraseña);
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public void inicioSesion(String usuario, String contraseña, javax.swing.JLabel text){
        Inicio s = new Inicio(usuario, contraseña);
        boolean p = probarInicio(s);
        
        if(p){
            VentanaPrincipal v = new VentanaPrincipal();
            v.setVisible(true);
        } else {
            text.setVisible(true);
        }
    }
}
