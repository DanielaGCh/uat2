/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.business;

import com.smartsoft.uat.dao.BotonDAO;
import com.smartsoft.uat.entity.Botonpanico;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author hp
 */
@Stateless
public class BotonBusiness {
    
    @Inject
    private BotonDAO dao;
    
    public Botonpanico guardar(Botonpanico entity) {
        return dao.saveOrEdit(entity, entity.getId());
    }

    public Botonpanico consultar(Integer id) {
        return dao.search(id);
    }

    public void eliminar(Botonpanico entity, Integer idBoton) {
        entity.setActivo(false);
        dao.deleteLogically(entity);
    }


    public List<Botonpanico> obtenerListaActivos() {
        return dao.listaActivos();
    }
    
  
}