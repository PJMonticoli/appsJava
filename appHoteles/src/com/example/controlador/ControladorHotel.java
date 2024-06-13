package com.example.controlador;

import com.example.modelo.Habitacion;
import com.example.modelo.Servicio;
import com.example.modelo.dto.ConsumoDTO;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ControladorHotel {

    private String conexion;

    public ControladorHotel() {
        conexion = "jdbc:mysql://localhost/hotel?user=root&password=qweasd123";
    }
    //Registrar un servicio
    public boolean registrarServicio(Servicio ser) {
        try ( Connection cnn = DriverManager.getConnection(conexion)) {
            PreparedStatement ps = cnn.prepareStatement("INSERT INTO SERVICIOS (concepto,idHabitacion,importe) VALUES (? , ? ,?)");
            ps.setString(1, ser.getConcepto());
            ps.setInt(2, ser.getHabitacion().getId());
            ps.setFloat(3, ser.getImporte());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    //– Suma de todos los servicios contratados
    public float calcularImporte() {
        float importe = -1;

        try ( Connection cnn = DriverManager.getConnection(conexion)) {
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SUM(IMPORTE) as importe FROM SERVICIOS");
            while(rs.next()){
                importe = rs.getFloat("importe");
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return importe;
    }


// Id y denominación de habitación y suma de servicios contratados por todas aquellas habitaciones que registren más de 3 servicios.
    public List<ConsumoDTO> obtenerReporte2(){
        
         List<ConsumoDTO> lst = new ArrayList<>();
            String query= " SELECT h.IdHabitacion,h.Denominacion,count(s.IdServicio) as cantidad ,sum(s.Importe) as total"
                        +" FROM Habitaciones h join Servicios s on h.IdHabitacion=s.IdHabitacion"
                       + " GROUP BY h.IdHabitacion,h.Denominacion"
                        +" HAVING count(s.IdServicio)>3;";
        try(Connection cnn = DriverManager.getConnection(conexion);
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(query)){
            while(rs.next()){
                int id = rs.getInt("IdHabitacion");
                String denominacion = rs.getString("Denominacion");
                float total = rs.getFloat("total");
                int cantidad = rs.getInt("cantidad");
                lst.add(new ConsumoDTO(id,denominacion,total,cantidad));
            }
            
        }catch (Exception e){
            System.out.println(e);
        }
        return lst;
    }
    
    //Metodo para obtener habitaciones en el comboBox
    public List<Habitacion> obtenerHabitaciones() {
        List<Habitacion> lst = new ArrayList<>();

        try ( Connection cnn = DriverManager.getConnection(conexion);  
                Statement stmt = cnn.createStatement();  
                ResultSet rs = stmt.executeQuery("SELECT * FROM HABITACIONES")) {

            while (rs.next()) {
                int id = rs.getInt("idHabitacion");
                String nombre = rs.getString("Denominacion");
                lst.add(new Habitacion(id, nombre));
            }
        } catch (Exception e) {
        }

        return lst;
    }
     
    
// Concepto e importe de todos aquellos servicios contratados por una habitación en particular seleccionada por el usuario
    
    public List<Servicio> obtenerReporte3(int idHabitacion) {
        List<Servicio> lst = new ArrayList<>();
        String query = "SELECT * FROM Servicios t WHERE IdHabitacion = " + idHabitacion;
         try ( Connection cnn = DriverManager.getConnection(conexion);  
                 Statement stmt = cnn.createStatement();  
                 ResultSet rs = stmt.executeQuery(query)) {
            while(rs.next()) {
                int id = rs.getInt("IdServicio");
                String concepto = rs.getString("concepto");
                float importe = rs.getFloat("Importe");
                lst.add(new Servicio(id, concepto,null, importe)); //No necesitamos recuperar los datos de la habitación
            }
        } catch (Exception e) {
             System.out.println(e);
        }
        return lst;
    }
    
    
    
    
    
    
    
    
    
}
