
package controller;

import view.VentanaAgregarCl;
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
}
