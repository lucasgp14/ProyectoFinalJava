
package model;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class DB {
    
    public DefaultTableModel getClientes(){
        DefaultTableModel datos = new DefaultTableModel();
        datos.addColumn("Numero");
        datos.addColumn("Nombre de Cliente");
        datos.addColumn("Apellido");
        datos.addColumn("Nombre");
        datos.addColumn("Telefono");
        datos.addColumn("Direccion");
        datos.addColumn("Direccion 2");
        datos.addColumn("Ciudad");
        datos.addColumn("Estado");
        datos.addColumn("Codigo Postal");
        datos.addColumn("País");
        datos.addColumn("Nro de Empleado de Venta");
        datos.addColumn("Limite de Credito");
        
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels", "root", "1234");
            Statement sql = con.createStatement();
            ResultSet res = sql.executeQuery("select * from customers");
            
            datos.setNumRows(0);
            
            while(res.next()){
                Object[] fila = new Object[13];
                fila[0] = res.getInt("customerNumber");
                fila[1] = res.getString("customerName");
                fila[2] = res.getString("contactLastName");
                fila[3] = res.getString("contactFirstName");
                fila[4] = res.getString("phone");
                fila[5] = res.getString("addressLine1");
                fila[6] = res.getString("addressLine2");
                fila[7] = res.getString("city");
                fila[8] = res.getString("state");
                fila[9] = res.getString("postalCode");
                fila[10] = res.getString("country");
                fila[11] = res.getInt("salesRepEmployeeNumber");
                fila[12] = res.getDouble("creditLimit");
                
                
                datos.addRow(fila);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return datos;
    }
    
    public DefaultTableModel getOrders(String cliente ){
        DefaultTableModel datos = new DefaultTableModel();
        datos.addColumn("Numero");
        datos.addColumn("Fecha de Orden");
        datos.addColumn("Fecha Requerida");
        datos.addColumn("Fecha de Envio");
        datos.addColumn("Estado");
        datos.addColumn("Comentarios");
        datos.addColumn("Numero de Cliente");
        
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels", "root", "1234");
            PreparedStatement sql = con.prepareStatement("select * from orders where customerNumber = ?");
            sql.setString(1, cliente);
            ResultSet res = sql.executeQuery();
         
            
            datos.setNumRows(0);
            
            while(res.next()){
                Object[] fila = new Object[7];
                fila[0] = res.getInt("orderNumber");
                fila[1] = res.getString("orderDate");
                fila[2] = res.getString("requiredDate");
                fila[3] = res.getString("shippedDate");
                fila[4] = res.getString("status");
                fila[5] = res.getString("comments");
                fila[6] = res.getInt("customerNumber");
                
                datos.addRow(fila);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return datos;
    }
    
     public DefaultTableModel getOrdersDetails(String numero){
        DefaultTableModel datos = new DefaultTableModel();
        datos.addColumn("Numero de Orden");
        datos.addColumn("Codigo");
        datos.addColumn("Cantidad");
        datos.addColumn("Precio Unitario");
        datos.addColumn("Numero de Pedido de Línea");
        
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels", "root", "1234");
            PreparedStatement sql = con.prepareStatement("select * from orderdetails where orderNumber = ?");
            
            sql.setString(1, numero);
            ResultSet res = sql.executeQuery();
            
            datos.setNumRows(0);
            
            while(res.next()){
                Object[] fila = new Object[5];
                fila[0] = res.getInt("orderNumber");
                fila[1] = res.getString("productCode");
                fila[2] = res.getInt("quantityOrdered");
                fila[3] = res.getDouble("priceEach");
                fila[4] = res.getInt("orderLineNumber");
                
                datos.addRow(fila);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return datos;
    }
}
