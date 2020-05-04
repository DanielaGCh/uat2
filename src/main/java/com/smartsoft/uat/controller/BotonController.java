/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller;

import com.smartsoft.uat.business.BotonBusiness;
import com.smartsoft.uat.controller.view.BotonView;
import com.smartsoft.uat.entity.Botonpanico;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author hp
 */
@Named(value = "botonController")
@ViewScoped
public class BotonController implements Serializable{
    
    @Inject
    private SesionController sesion;
    @Inject
    private BotonBusiness business;
    
    private BotonView view;
    
    @PostConstruct
    public void init() {
        view = new BotonView();
        mostrarLista();
        nuevo();
    }
    
    public void mostrarLista(){
        view.setListaEntity(business.obtenerListaActivos());
    }
    
    public void nuevo() {
        view.setEntity(new Botonpanico());
        view.getEntity().setId(0);
        view.getEntity().setActivo(true);
    }
    

    public void editar(Botonpanico entity) {
        view.setEntity(entity);
        view.setListaEntity(null);
    }

    public void eliminar(Botonpanico entity) {
        entity.setActivo(false);
        business.eliminar(entity, null);
        sesion.MessageInfo("Registro eliminado");
        mostrarLista();
    }

    public void guardar() {

        if(view.getEntity().getMotivo().isEmpty()){
                sesion.MessageError("Introduce los datos correctamente");
        }else{
            view.getEntity().setActivo(Boolean.TRUE);
            view.getEntity().setFecha(new Date());
            view.getEntity().setMatriculaRegistro(sesion.getView().getUsuario().getMatricula());
            view.getEntity().setNombreRegistro(sesion.getView().getUsuario().getNombreCompleto());
            business.guardar(view.getEntity());
            sesion.MessageInfo("Registro exitoso");
         
            
        }
            
        
        //mostrarLista();
    }

    
    public BotonView getView() {
        return view;
    }
    
}
