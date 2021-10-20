/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.curso.web;

import com.curso.ejbs.NominasService;
import com.curso.ejbs.SaludoSessionBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author begonaolea
 */
@Named(value = "variosBean")
@RequestScoped
public class VariosBean {
    
    private String mensaje = "el mensaje";
    
    @EJB
    private SaludoSessionBean saludoService;
    
    @EJB
    private NominasService nominasService;

    /**
     * Creates a new instance of VariosBean
     */
    public VariosBean() {
        //1
    }
    
    @PostConstruct
    private void iniciarMensaje (){
        
        //2
        this.mensaje = saludoService.saluda();
        nominasService.generaNomina();
    }

    public String getMensaje() {
        return mensaje;
    }
    
    
    
   
    
}
