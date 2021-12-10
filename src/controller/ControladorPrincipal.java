
package controller;

import view.VentanaAgregarCl;
import view.VentanaAgregarPed;
import view.VentanaModificarCl;
import view.VentanaOrder;

/**
 *
 * @author Lucas
 */
public class ControladorPrincipal {
    public static void VentanaOrdenes(){
        VentanaOrder vO = new VentanaOrder();
        vO.setVisible(true);
    }
    
    public static void VentanaAgregarCliente(){
        VentanaAgregarCl vCl = new VentanaAgregarCl();
        vCl.setVisible(true);
    }
    
    public static void VentanaModificarCliente(){
        VentanaModificarCl vMCl = new VentanaModificarCl();
        vMCl.setVisible(true);
    }
    
    public static void VentanaAgregarPedido(){
        VentanaAgregarPed vP = new VentanaAgregarPed();
        vP.setVisible(true);
    }
}
