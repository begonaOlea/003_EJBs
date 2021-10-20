
package com.curso.ejbs;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Schedule;
import javax.ejb.Stateless;


@Stateless // ANOTACION DICE QUE ES UN EJB DE SESION SIN ESTADO
           // El cont del SA crear un pool de instancias del mismo ejb
public class SaludoSessionBean {
    
    private static Logger log = Logger.getLogger("Saludo EJB");
    

    public SaludoSessionBean() {
        System.out.println("... instanciando SaludoSessionBean****");
    }

    // metodo del ciclo de vida del EJB
    @PostConstruct
    private void inicia(){
        System.out.println("... postconstruct SaludoSessionBean");
    }
    
    @PreDestroy
    private void finalizar(){
        System.out.println("... predestroy SaludoSessionBean");
    }
    
    
    //MÉTODO DE NEGOCIO
    public String saluda(String nombre){
        return "Hola " + nombre;
    }
    
    public String saluda(){
        return "Hola amigo";
    }
    
   // @Schedule(second = "*/5", minute = "*" , hour = "*")
    public void saludarCadaMinuto(){
        log.info("..... hola " );
    }
    
    
}
