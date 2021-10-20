/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package com.curso.ejbs;

import javax.ejb.Stateful;

/**
 *
 * @author begonaolea
 */
@Stateful  //EJB de sesión con ESTADO
public class ContadorSessionBean {

   private int contador;
   
   public void incrementar(){
       contador++;
   }
   
   public void inicializar(){
       contador =0;
   }

    public int getContador() {
        return contador;
    }
   
   
    
    
}
