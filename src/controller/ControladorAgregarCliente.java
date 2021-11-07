
package controller;

import java.util.ArrayList;
import model.DB;

public class ControladorAgregarCliente {
    public void LlenarComboDef(ArrayList<String> lista, javax.swing.JComboBox boxNroEmpleado){
        DB combo = new DB();
        lista = combo.LlenarCombo();
        
        for(int i = 0; i<lista.size(); i++){
        boxNroEmpleado.addItem(lista.get(i));
        }
    }
}
