/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.modelo;

/**
 *
 * @author pablo
 */
public class Habitacion {
    private int id;
    private String denominacion;

    public Habitacion(int id, String denominacion) {
        this.id = id;
        this.denominacion = denominacion;
    }

    public Habitacion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Override
    public String toString() {
        return id + " | " + denominacion;
    }
    
    
}
