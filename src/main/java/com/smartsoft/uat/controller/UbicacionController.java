/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller;


import com.smartsoft.uat.business.UbicacionBusiness;
import com.smartsoft.uat.controller.view.UbicacionView;
import com.smartsoft.uat.entity.Ubicacion;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author carlo
 */

@Named(value = "ubicacionController")
@ViewScoped
public class UbicacionController implements Serializable{
    
      @Inject
    private UbicacionBusiness business;
      @Inject
    private SesionController sesion;
      
      private UbicacionView view;
    
    private MapModel simpleModel;
    private final List<Ubicacion> ubi=null;
    
       @PostConstruct
    public void init() {
        view = new UbicacionView();
      mostrarListahijos();
     
       
    }
    
    public MapModel getSimpleModel() {
        return simpleModel;
    }
      
  
    
    public void nuevo( Ubicacion ubicacion) {
        view.setEntity(ubicacion);
        view.setListaEntity(null);
        view.getEntity().setIdUbicacion(0);
        view.getEntity().setFecha(new Date());
        view.getEntity().setHora(new Date());
        view.getEntity().setNombreAlumn(sesion.getView().getUsuario().getNombreCompleto());
       
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

 public void mostrarListahijos(){
     view.setListaEntity2(business.obtenerListahijos(sesion.getView().getUsuario().getMatricula()));
     view.setEntity(null);
     
 }
 
 public void visualizar(double lati,double longi,String matricula) {
        view.setEntity(new Ubicacion());
        view.setListaEntity2(null);
        obtenerCoordenadas( lati, longi, matricula);
    }
 public UbicacionView getView() {
        return view;
    }
 
 public void obtenerCoordenadas(double lati,double longi,String matricula){
      
      
      simpleModel = new DefaultMapModel();
          
        //Shared coordinates
        LatLng coord1 = new LatLng(lati,longi);     
        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, matricula));
        
 }
 
 public String obtenerUbicacionAlumno(String matricula ,UbicacionBusiness business ){
     String coordenadas="";
     List<Ubicacion> list = business.obtenerUbicacionAlumno(matricula);
     
     if (list != null){
         coordenadas = list.get(list.size()-1).getLatitud()+","+list.get(list.size()-1).getLongitud();
     }
     else{
         coordenadas = "No hay registro";
     }
     
     return coordenadas;
     
 }
    
}