
package classicalmodel;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class DB {
    public DefaultTableModel getClientes(){
        DefaultTableModel datos = new DefaultTableModel();
        datos.addColumn("Numero");
        datos.addColumn("Nombre");
        datos.addColumn("Telefono");
        
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels", "root", "1234");
            Statement sql = con.createStatement();
            ResultSet res = sql.executeQuery("select * from customers");
            
            datos.setNumRows(0);
            
            while(res.next()){
                Object[] fila = new Object[4];
                fila[0] = res.getString("customerNumber");
                fila[1] = res.getString("customerName");
                fila[2] = res.getString("phone");
                
                
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
                fila[0] = res.getString("orderNumber");
                fila[1] = res.getString("orderDate");
                fila[2] = res.getString("requiredDate");
                fila[3] = res.getString("shippedDate");
                fila[4] = res.getString("status");
                fila[5] = res.getString("comments");
                fila[6] = res.getString("customerNumber");
                
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
                fila[0] = res.getString("productCode");
                fila[1] = res.getString("quantityOrdered");
                fila[2] = res.getString("priceEach");
                
                datos.addRow(fila);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return datos;
    }
}
