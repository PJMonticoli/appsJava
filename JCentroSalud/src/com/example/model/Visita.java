/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author pablo
 */
public class Visita {
    private int id;
    private Paciente paciente;
    private Empleado empleado;
    private String nombre;
    private int duracion;

    public Visita() {
    }

    public Visita(int id, Paciente paciente, Empleado empleado, String nombre, int duracion) {
        this.id = id;
        this.paciente = paciente;
        this.empleado = empleado;
        this.nombre = nombre;
        this.duracion = duracion;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Visita{" + "id=" + id + ", paciente=" + paciente + ", empleado=" + empleado + ", nombre=" + nombre + ", duracion=" + duracion + '}';
    }
    
    
    
}
