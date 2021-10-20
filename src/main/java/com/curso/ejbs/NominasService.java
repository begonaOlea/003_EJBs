/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.curso.ejbs;

import javax.ejb.Local;
import javax.ejb.Remote;

//@Remote
@Local
public interface NominasService {
    
    public void generaNomina();
}
