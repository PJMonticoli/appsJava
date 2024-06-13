/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.modelo.dto;

/**
 *
 * @author pablo
 */
public class ConsumoDTO {
    private String nombrePaciente;   
    private int cantidad;

    public ConsumoDTO() {
    }

    public ConsumoDTO(String nombrePaciente, int cantidad) {

        this.nombrePaciente = nombrePaciente;
        this.cantidad = cantidad;
    }



    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ConsumoDTO{" + "nombrePaciente=" + nombrePaciente + ", cantidad=" + cantidad + '}';
    }


    
    
}
