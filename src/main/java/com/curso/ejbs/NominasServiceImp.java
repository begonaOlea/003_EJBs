
package com.curso.ejbs;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class NominasServiceImp implements NominasService{

    //ID  segundo
    @EJB
    private SaludoSessionBean saludoService;
    
    //CONSTRUCTOS
 /// primero
    public NominasServiceImp() {
        System.out.println("....*** instanciando NominasServiceImp");
        // saludoService es null
        System.out.println("saludoService es " + saludoService);
        
    }
    
    //tercero
    @PostConstruct
    private void iniciar(){
        System.out.println(" .. postconstruct NominasServiceImp");
         System.out.println("saludoService dice hola " + saludoService.saluda());
         
    }
    
    
    
  
    public void generaNomina() {
        System.out.println(".........................");
        System.out.println(".... genera nominas .....");
         System.out.println(".........................");
    }
    
}
