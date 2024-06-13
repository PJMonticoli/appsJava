
package com.example.modelo;

public class Servicio {
    private int id;
    private String concepto;
    private Habitacion habitacion;
    private float importe;

    public Servicio() {
    }

    public Servicio(int id, String concepto, Habitacion IdHabitacion, float importe) {
        this.id = id;
        this.concepto = concepto;
        this.habitacion = IdHabitacion;
        this.importe = importe;
    }


    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }



    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "servicio{" + "id=" + id + ", concepto=" + concepto + ", IdHabitacion=" + habitacion + ", importe=" + importe + '}';
    }
    
    public Object [] toArray(){
        return new Object[]{id,concepto,habitacion,importe};
    }
}
