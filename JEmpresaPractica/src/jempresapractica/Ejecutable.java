/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jempresapractica;

import com.example.vista.JFPrincipal;

/**
 *
 * @author pablo
 */
public class Ejecutable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            new JFPrincipal().setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
}
