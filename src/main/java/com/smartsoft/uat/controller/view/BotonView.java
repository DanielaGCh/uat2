/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller.view;

import com.smartsoft.uat.entity.Botonpanico;
import java.util.List;

/**
 *
 * @author hp
 */
public class BotonView {
    
    private Botonpanico entity;
    private List<Botonpanico> listaEntity;
    


    public Botonpanico getEntity() {
        return entity;
    }

    public void setEntity(Botonpanico entity) {
        this.entity = entity;
    }

    public List<Botonpanico> getListaEntity() {
        return listaEntity;
    }

    public void setListaEntity(List<Botonpanico> listaEntity) {
        this.listaEntity = listaEntity;
    }
    
    
}
