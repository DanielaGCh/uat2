/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller;


import com.smartsoft.uat.business.UbicacionBusiness;
import com.smartsoft.uat.controller.view.UbicacionView;
import com.smartsoft.uat.entity.Ubicacion;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author carlo
 */


public class UbicacionController {
    
      @Inject
    private UbicacionBusiness business;
    
    private UbicacionView   view = new UbicacionView();;
    
    
       @PostConstruct
    public void init() {
      
  
        
    }
    
         public void nuevo( Ubicacion ubicacion) {
        view.setEntity(ubicacion);
        view.setListaEntity(null);
        view.getEntity().setIdUbicacion(0);
        view.getEntity().setFecha(new Date());
        view.getEntity().setHora(new Date());
       
    }
    
     public String guardarWS(UbicacionBusiness business){
        
            if(view.getEntity()==null){
                //sesion.MessageError("Introduce los datos correctamente");
                 return "No hay datos que guardar";
            }
        
        
        business.guardar(view.getEntity());
          //  sesion.MessageInfo("Registro exitoso");
          return "Registro exitoso";
     }

 
    
}