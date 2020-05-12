/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.dao;

import com.smartsoft.uat.entity.Calificaciones;
import com.smartsoft.uat.seguridad.EntitiManager;
import com.smartsoft.uat.seguridad.Persistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author chave
 */
@Stateless
public class CalificacionesDAO extends EntitiManager<Calificaciones> {
    @Inject
    private Persistence persistence;

    public CalificacionesDAO() {
        super(Calificaciones.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return persistence.getMysql();
    }
    
    public List<Calificaciones> listaActivos(String periodo, String criterio, String parcial, String folio){
        return persistence.getMysql().createNamedQuery("Calificaciones.findByAllActivos")
              .setParameter("periodo", periodo)
              .setParameter("nombreCriterio", criterio)
              .setParameter("parcial", parcial)
              .setParameter("foliounidad", folio).getResultList();
    }
    
    public Calificaciones existe(String foliounidad, String nombreCriterio,String periodo,String matriculaAlum, String parcial){
        List<Calificaciones> lista = persistence.getMysql().createNamedQuery("Calificaciones.existe")
                .setParameter("periodo", periodo)
                .setParameter("parcial", parcial)
                .setParameter("matriculaAlum", matriculaAlum)
                .setParameter("nombreCriterio", nombreCriterio)
                .setParameter("foliounidad", foliounidad).getResultList();
        return lista.size()>0?lista.get(0):null;
    }
}
