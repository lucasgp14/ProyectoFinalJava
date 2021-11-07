/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DB;

/**
 *
 * @author Lucas
 */
public class ControladorOrdenes {
    public void ConexionCliOr(javax.swing.JTable tablaClientes, javax.swing.JTable tablaOrdenes){
       int fila = tablaClientes.getSelectedRow();
       String numero = tablaClientes.getValueAt(fila, 0).toString();
        
       tablaOrdenes.setModel(new DB().getOrders(numero));
    }
    
    public void ConexionOrDet(javax.swing.JTable tablaOrdenes, javax.swing.JTable tablaDetalle){
        int fila = tablaOrdenes.getSelectedRow();
        String numero = tablaOrdenes.getValueAt(fila, 0).toString();
        
        tablaDetalle.setModel(new DB().getOrdersDetails(numero));
    }
}
