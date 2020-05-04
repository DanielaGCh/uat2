/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.dao;

import com.smartsoft.uat.entity.Botonpanico;
import com.smartsoft.uat.entity.Usuarios;
import com.smartsoft.uat.seguridad.EntitiManager;
import com.smartsoft.uat.seguridad.Persistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author andre
 */
@Stateless
public class BotonDAO extends EntitiManager<Botonpanico>{
        @Inject
    private Persistence persistence;

    public BotonDAO() {
        super(Botonpanico.class);
    }
    @Override
    protected EntityManager getEntityManager() {
        return persistence.getMysql();
    }
    public List<Botonpanico> listaActivos(){
        return persistence.getMysql().createNamedQuery("Botonpanico.findAllActivos").getResultList();
    }
    
}
