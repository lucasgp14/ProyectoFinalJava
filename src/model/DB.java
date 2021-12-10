
package model;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DB {
    
    Clientes o = new Clientes();
    
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
                fila[12] = res.getString("creditLimit");
                
                
                datos.addRow(fila);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return datos;
    }
        
        public boolean NumeroClRepetido(String customerNumber){
            boolean respuesta = false;
        
        try{
            Connection c = DriverManager.getConnection(
            "jdbc:mysql://localhost/classicmodels","root","1234");
            
            Statement s = c.createStatement();
            ResultSet sql= s.executeQuery("select * from customers");
            
            while(sql.next()){
            if(sql.getString("customerNumber").equals(customerNumber)){
                respuesta = true;
            }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        return respuesta;
        }
        
        public static ArrayList<String> LlenarCombo(){
            ArrayList<String> aux = new ArrayList<String>();
            ArrayList<String> lista = new ArrayList<String>();
        try{
            Connection c = DriverManager.getConnection(
            "jdbc:mysql://localhost/classicmodels","root","1234");
            
            Statement s = c.createStatement();
            ResultSet sql= s.executeQuery("select * from customers");
            
            while(sql.next()){
                lista.add(sql.getString("salesRepEmployeeNumber"));
            }
            
            for(String a: lista){
                if(!aux.contains(a)){
                    aux.add(a);
                }
            }
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
            return aux;
        }
    
        public void agregarCliente(Clientes cl){
        try{
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels","root","1234");
        
        PreparedStatement s = con.prepareStatement("insert into customers values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
        s.setString(1, cl.getCustomerNumber());
        s.setString(2, cl.getCustomerName());
        s.setString(3, cl.getContactLastName());
        s.setString(4, cl.getContactFirstName());
        s.setString(5, cl.getPhone());
        s.setString(6, cl.getAddressLine1());
        s.setString(7, cl.getAddressLine2());
        s.setString(8, cl.getCity());
        s.setString(9, cl.getState());
        s.setString(10, cl.getPostalCode());
        s.setString(11, cl.getCountry());
        s.setString(12, cl.getSalesRepEmployeeNumber());
        s.setString(13, cl.getCreditLimit());
                
        s.executeUpdate();
        
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
        
    public void modificarCliente(Clientes c1){
        try{
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels","root","1234");
        
        PreparedStatement s = con.prepareStatement("update customers set customerName = ?, contactLastName = ?, contactFirstName = ?, phone = ?, addressLine1 = ?, addressLine2 = ?, city = ?, state = ?, postalCode = ?, country = ?, creditLimit = ? where customerNumber = ?");
        
        s.setString(1, c1.getCustomerName());
        s.setString(2, c1.getContactLastName());
        s.setString(3, c1.getContactFirstName());
        s.setString(4, c1.getPhone());
        s.setString(5, c1.getAddressLine1());
        s.setString(6, c1.getAddressLine2());
        s.setString(7, c1.getCity());
        s.setString(8, c1.getState());
        s.setString(9, c1.getPostalCode());
        s.setString(10, c1.getCountry());
        s.setString(11, c1.getCreditLimit());
        s.setString(12, c1.getCustomerNumber());
        
        s.executeUpdate();
        
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public DefaultTableModel buscarCliente(String customerNumber){
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
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels","root","1234");
        PreparedStatement s = con.prepareStatement("select * from customers where customerNumber like ?");
        s.setString(1, "%" +customerNumber+ "%");
        ResultSet res = s.executeQuery();
        
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
        
        }catch (SQLException e){
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
    
    public DefaultTableModel getAllOrders(){
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
            PreparedStatement sql = con.prepareStatement("select * from orders");
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
    
    public boolean NumeroPedRepetido(String orderNumber){
            boolean respuesta = false;
        
        try{
            Connection c = DriverManager.getConnection(
            "jdbc:mysql://localhost/classicmodels","root","1234");
            
            Statement s = c.createStatement();
            ResultSet sql= s.executeQuery("select * from orders");
            
            while(sql.next()){
            if(sql.getString("orderNumber").equals(orderNumber)){
                respuesta = true;
            }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        return respuesta;
        }
        
        public static ArrayList<String> LlenarComboEstado(){
            ArrayList<String> lista = new ArrayList<String>();
            ArrayList<String> aux = new ArrayList<String>();
            
        try{
            Connection c = DriverManager.getConnection(
            "jdbc:mysql://localhost/classicmodels","root","1234");
            
            Statement s = c.createStatement();
            ResultSet sql= s.executeQuery("select * from orders");
            
            while(sql.next()){
                lista.add(sql.getString("status"));
            }
            
            for(String a: lista){
                if(!aux.contains(a)){
                    aux.add(a);
                }
            }
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
            return aux;
        }
        
        public static ArrayList<String> LlenarComboNroCl(){
            
            ArrayList<String> lista = new ArrayList<String>();
        try{
            Connection c = DriverManager.getConnection(
            "jdbc:mysql://localhost/classicmodels","root","1234");
            
            Statement s = c.createStatement();
            ResultSet sql= s.executeQuery("select * from orders");
            
            while(sql.next()){
                lista.add(sql.getString("customerNumber"));
            }
            
            
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
            return lista;
        }
    
        public void agregarOrden(Ordenes o){
        try{
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels","root","1234");
        
        PreparedStatement s = con.prepareStatement("insert into orders values (?,?,?,?,?,?,?)");
        
        s.setString(1, o.getOrderNumber());
        s.setString(2, o.getOrderDate());
        s.setString(3, o.getRequiredDate());
        s.setString(4, o.getShippedDate());
        s.setString(5, o.getStatus());
        s.setString(6, o.getComments());
        s.setString(7, o.getCustomerNumber());
        s.executeUpdate();
        
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
       public DefaultTableModel buscarOrden(String orderNumber){
        DefaultTableModel datos = new DefaultTableModel();
        
        datos.addColumn("Numero");
        datos.addColumn("Fecha de Orden");
        datos.addColumn("Fecha Requerida");
        datos.addColumn("Fecha de Envio");
        datos.addColumn("Estado");
        datos.addColumn("Comentarios");
        datos.addColumn("Numero de Cliente");
        
        try{
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels","root","1234");
        PreparedStatement s = con.prepareStatement("select * from orders where orderNumber like ?");
        
        s.setString(1, "%" +orderNumber+ "%");
        
        ResultSet res = s.executeQuery();
        
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
        
        }catch (SQLException e){
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
     
     public DefaultTableModel buscarDetalleOrden(String productCode, String orderNumber){
        DefaultTableModel datos = new DefaultTableModel();
        
        datos.addColumn("Numero de Orden");
        datos.addColumn("Codigo");
        datos.addColumn("Cantidad");
        datos.addColumn("Precio Unitario");
        datos.addColumn("Numero de Pedido de Línea");
        
        try{
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels","root","1234");
        PreparedStatement s = con.prepareStatement("select * from orderdetails where productCode like ? and orderNumber like ?");
        
        s.setString(1, "%" +productCode+ "%");
        s.setString(2, "%" +orderNumber+ "%");
        
        ResultSet res = s.executeQuery();
        
        while(res.next()){
            Object[] fila = new Object[5];
            fila[0] = res.getInt("orderNumber");
            fila[1] = res.getString("productCode");
            fila[2] = res.getInt("quantityOrdered");
            fila[3] = res.getDouble("priceEach");
            fila[4] = res.getInt("orderLineNumber");
                
            datos.addRow(fila);
        }
        
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return datos;
    }
     
}
