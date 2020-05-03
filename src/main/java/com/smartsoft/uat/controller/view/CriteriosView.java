/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller.view;

import com.smartsoft.uat.entity.Criteriosevaluacion;
import com.smartsoft.uat.controller.view.SesionView;
import java.util.List;

/**
 *
 * @author andre
 */
public class CriteriosView {
       private Criteriosevaluacion entity;
       private SesionView view;
    private List<Criteriosevaluacion> listaEntity;
    private List<Criteriosevaluacion> listaporMatricula;

    public Criteriosevaluacion getEntity() {
        return entity;
    }

    public void setEntity(Criteriosevaluacion entity) {
        this.entity = entity;
    }

    public List<Criteriosevaluacion> getListaEntity() {
        return listaEntity;
    }

    public void setListaEntity(List<Criteriosevaluacion> listaEntity) {
        this.listaEntity = listaEntity;
    }
    
    
     public List<Criteriosevaluacion> getListaporMatricula() {
        return listaporMatricula;
    }

    public void setListaporMatricula(List<Criteriosevaluacion> listaporMatricula) {
        this.listaporMatricula = listaporMatricula;
    }
    
}
