/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller.view;
import com.smartsoft.uat.entity.Ubicacion;
import java.util.List;


public class UbicacionView {
      private Ubicacion entity;
    private List<Ubicacion> listaEntity;
    private Ubicacion ubicacion;
    
        public Ubicacion getEntity() {
        return entity;
    }

    public void setEntity(Ubicacion entity) {
        this.entity = entity;
    }

    public List<Ubicacion> getListaEntity() {
        return listaEntity;
    }
    
 
    public void setListaEntity(List<Ubicacion> listaEntity) {
        this.listaEntity = listaEntity;
    }
  /*  public Ubicacion getUsuario() {
        return ubicacion;
    }

    public void setUsuario(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }*/
    
}
