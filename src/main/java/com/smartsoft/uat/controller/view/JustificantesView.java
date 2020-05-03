/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller.view;

import com.smartsoft.uat.entity.Justificantes;
import java.util.List;

/**
 *
 * @author hp
 */
public class JustificantesView {
    
    private Justificantes entity;
    private List<Justificantes> listaEntity;
    private List<Justificantes> listaEntity2;

    public Justificantes getEntity() {
        return entity;
    }

    public void setEntity(Justificantes entity) {
        this.entity = entity;
    }

    public List<Justificantes> getListaEntity() {
        return listaEntity;
    }

    public void setListaEntity(List<Justificantes> listaEntity) {
        this.listaEntity = listaEntity;
    }
    
    public List<Justificantes> getListaMatricula() {
        return listaEntity2;
    }

    public void setListaMatricula(List<Justificantes> listaEntity2) {
        this.listaEntity2 = listaEntity2;
    }
    
}
