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
    private List<Ubicacion> listaEntity2;
    private List<Ubicacion> coordenadas;
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
    
    
    public List<Ubicacion> getListaEntity2() {
        return listaEntity2;
    }
    
 
    public void setListaEntity2(List<Ubicacion> listaEntity2) {
        this.listaEntity2 = listaEntity2;
    }
    
    public List<Ubicacion> getCoordenadas() {
        return coordenadas;
    }
    
 
    public void setCoordenadas(List<Ubicacion> coordenadas) {
        this.coordenadas = coordenadas;
    }
}
