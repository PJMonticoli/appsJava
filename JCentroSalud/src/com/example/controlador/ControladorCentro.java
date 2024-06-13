/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controlador;

import com.example.model.Visita;
import com.example.modelo.dto.ConsumoDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author pablo
 */
public class ControladorCentro {

    private String conexion;

    public ControladorCentro() {
        conexion = "jdbc:mysql://localhost/visitas?user=root&password=qweasd123";
    }

    public boolean registrarVisita(Visita vis){
        try (Connection cnn = DriverManager.getConnection(conexion)){
        PreparedStatement ps = cnn.prepareStatement("INSERT INTO Visitas(IdPaciente,LegajoRecepcionista ,Nombre ,Duracion ) Values(?, ?, ?, ?)");
        ps.setInt(1, vis.getPaciente().getId());
        ps.setInt(2, vis.getEmpleado().getLegajo());
        ps.setString(3, vis.getNombre());
        ps.setInt(4, vis.getDuracion());
        ps.execute();        
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    
    // Cantidad de visitantes por cada paciente. Debe mostrarse un listado con nombre del paciente 
    // y cantidad de visitas que recibió.
    public List<ConsumoDTO> obtenerReporte1(){
        List<ConsumoDTO> lst = new ArrayList<>();
        try (Connection cnn = DriverManager.getConnection(conexion);
             Statement st = cnn.createStatement();
             ResultSet rs = st.executeQuery("SELECT  p.Nombre NombrePaciente,count(IdVisita) cantidad" 
                                            + " FROM visitas v join pacientes p on v.IdPaciente=p.IdPaciente"
                                            + " GROUP BY p.Nombre")){
             while(rs.next()){
                 String nombre = rs.getString("NombrePaciente");
                 int cantidad = rs.getInt("cantidad");
                 lst.add(new ConsumoDTO(nombre,cantidad));
             }
            
        }catch (Exception e){
            System.out.println(e);
        }
        
        return lst;
    }
    
    
    //    - Promedio de duración de las visitas. Debe mostrarse un promedio simple de la duración de las visitas registradas, 
    //    pero solo incluyendo aquellas visitas que hayan durado más de 10 minutos
    public float obtenerReporte2(){
        float promedio = -1;
        try (Connection cnn = DriverManager.getConnection(conexion);
             Statement st = cnn.createStatement();
             ResultSet rs =st.executeQuery(" SELECT avg(Duracion) as promedio"
                                          +" FROM visitas"
                                          +" WHERE duracion>10")){
            while(rs.next()){
                promedio=rs.getFloat("promedio");
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return promedio;
    }
    
    
    
}
