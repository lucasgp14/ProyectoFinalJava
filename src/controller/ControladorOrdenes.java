/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
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
    
    public void BuscarClientes(javax.swing.JTable tablaClientes, javax.swing.JTextField campoBuscarCliente){
        DB db = new DB();
        tablaClientes.setModel(db.buscarCliente(campoBuscarCliente.getText()));
    }
    
    public void BuscarOrdenes(javax.swing.JTable tablaOrdenes, javax.swing.JTextField campoBuscarOrden){
        DB db = new DB();
        tablaOrdenes.setModel(db.buscarOrden(campoBuscarOrden.getText()));
    }
    
    public void BuscarDetallesOrdenes(javax.swing.JTable tablaDetalle, javax.swing.JTextField campoBuscarDetalleP, javax.swing.JTextField campoBuscarDetalleNO){
        DB db = new DB();
        tablaDetalle.setModel(db.buscarDetalleOrden(campoBuscarDetalleP.getText(), campoBuscarDetalleNO.getText()));
    }
    
    public void LlenarComboStatus(ArrayList<String> lista, javax.swing.JComboBox boxEstado){
        DB combo = new DB();
        lista = combo.LlenarComboEstado();
        
        for(int i = 0; i<lista.size(); i++){
        boxEstado.addItem(lista.get(i));
        }
    }
    
    public void LlenarComboCustomerN(ArrayList<String> lista, javax.swing.JComboBox boxNroCl){
        DB combo = new DB();
        lista = combo.LlenarComboNroCl();
        
        for(int i = 0; i<lista.size(); i++){
        boxNroCl.addItem(lista.get(i));
        }
    }
}
