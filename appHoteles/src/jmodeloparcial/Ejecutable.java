/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jmodeloparcial;

import modelo.example.vista.JFPrincipal;

public class Ejecutable {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //TODO: Crear y mostrar Pantalla Menú desde aquí:
            new JFPrincipal().setVisible(true);
        } catch (Exception ex) {
            // handle the error
        }

    }

}
