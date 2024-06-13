/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controlador;

import com.example.modelo.Componente;
import com.example.modelo.OrdenProduccion;
import com.example.modelo.Responsable;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ControladorOrden {
    
    private String conexion;
    
    public ControladorOrden() {
        conexion = "jdbc:mysql://localhost/mydb?user=root&password=qweasd123";
    }
    
    public boolean registrarOrden(OrdenProduccion orden) {
        try ( Connection cnn = DriverManager.getConnection(conexion);  PreparedStatement ps = cnn.prepareStatement("INSERT INTO PRODUCCION (fecha, idResponsable, idComponente, cantidadProduccion) VALUES(?, ?, ?, ?)");) {
            ps.setString(1, orden.getFecha());
            ps.setInt(2, orden.getResponsable().getId());
            ps.setInt(3, orden.getComponente().getId());
            ps.setInt(4, orden.getCantidad());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public List<Responsable> obtenerResponsable() {
        List<Responsable> lst = new ArrayList<>();
        String query = "SELECT * FROM Responsable";
        try ( Connection cnn = DriverManager.getConnection(conexion);  Statement st = cnn.createStatement();  ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                Responsable responsable = new Responsable(id, nombre);
                lst.add(responsable);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return lst;
    }
    
    public List<Componente> obtenerComponente() {
        List<Componente> lst = new ArrayList<>();
        String query = "SELECT * FROM Componente";
        try ( Connection cnn = DriverManager.getConnection(conexion);  Statement st = cnn.createStatement();  ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                Componente componente = new Componente(id, descripcion);
                lst.add(componente);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return lst;
    }
    
    public List<OrdenProduccion> obtenerOrdenProduccion(int id) {
        List<OrdenProduccion> lst = new ArrayList<>();
        String query = "SELECT p.*,r.nombre n_Resp,c.descripcion r_Resp,p.cantidadProduccion cantidad "
                + " FROM Produccion p,Responsable r,Componente c"
                + " WHERE p.idResponsable=r.id"
                + " and p.idComponente=c.id"
                + " and r.id= " + id;
        try ( Connection cnn = DriverManager.getConnection(conexion);  Statement st = cnn.createStatement();  ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                int idOrden = rs.getInt("id");
                String fecha = rs.getString("fecha");
                int idResponsable = rs.getInt("idResponsable");
                int idComponente = rs.getInt("idComponente");
                int cantidad = rs.getInt("cantidad");
                String nombreResponsable = rs.getString("n_Resp");
                String descripcionComponente = rs.getString("r_Resp");
                Responsable responsable = new Responsable(idResponsable, nombreResponsable);
                Componente componente = new Componente(idComponente, descripcionComponente);
                lst.add(new OrdenProduccion(idOrden, fecha, responsable, componente, cantidad));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }

    public OrdenProduccion obtenerOrdenPorId(int id) {
        OrdenProduccion orden = new OrdenProduccion();
        String query = "SELECT p.*,r.nombre n_Resp,c.descripcion r_Resp,p.cantidadProduccion cantidad "
                + " FROM Produccion p,Responsable r,Componente c"
                + " WHERE p.idResponsable=r.id"
                + " and p.idComponente=c.id"
                + " and p.id = " + id;
        try ( Connection cnn = DriverManager.getConnection(conexion);  Statement st = cnn.createStatement();  ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                int idOrden = rs.getInt("id");
                String fecha = rs.getString("fecha");
                int idResponsable = rs.getInt("idResponsable");
                int idComponente = rs.getInt("idComponente");
                int cantidad = rs.getInt("cantidad");
                String nombreResponsable = rs.getString("n_Resp");
                String descripcionComponente = rs.getString("r_Resp");
                Responsable responsable = new Responsable(idResponsable, nombreResponsable);
                Componente componente = new Componente(idComponente, descripcionComponente);
                orden = new OrdenProduccion(idOrden, fecha, responsable, componente, cantidad);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return orden;
    }
    
    public boolean actualizarOrden(int id, OrdenProduccion editado) {
        try ( Connection cnn = DriverManager.getConnection(conexion);  
                PreparedStatement ps = cnn.prepareStatement("UPDATE produccion "
                + "set fecha = ?, "
                + "cantidadProduccion = ? "
                + "where id = ?;")) {
            ps.setString(1,editado.getFecha());
            ps.setInt(2, editado.getCantidad());
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
}
