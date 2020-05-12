/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.dao;

import com.smartsoft.uat.entity.Enrolar;
import com.smartsoft.uat.seguridad.EntitiManager;
import com.smartsoft.uat.seguridad.Persistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author DaniGCh
 */
@Stateless
public class EnrolarDAO extends EntitiManager<Enrolar> {
    
    @Inject
    private Persistence persistence;

    public EnrolarDAO() {
        super(Enrolar.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return persistence.getMysql();
    }
    
    public List<Enrolar> listaActivos(String matriculaUsu, String periodo){
        return persistence.getMysql().createNamedQuery("Enrolar.findAllActivos").setParameter("matriculaUsu", matriculaUsu).setParameter("periodo", periodo).getResultList();
    }
    
    public List<Enrolar> listaEnrolados (String folio, String periodo){
        return persistence.getMysql().createNamedQuery("Enrolar.findEnrolados")
                .setParameter("periodo", periodo)
                .setParameter("folioHorario", folio).getResultList();
    }
    //Lista que obtiene las materias en las que estoy enrolado
     public List<Enrolar> listaenrolado(String matricula){
        return persistence.getMysql().createNamedQuery("Enrolar.findByMatriculaUsu").setParameter("matriculaUsu",matricula).getResultList();
    }
    
    public Enrolar existeEnrolamiento(String matrculausu, String folio, String periodo){
        List<Enrolar> lista = persistence.getMysql().createNamedQuery("Enrolar.existe")
                .setParameter("periodo", periodo).setParameter("matriculaUsu", matrculausu)
                .setParameter("folioHorario", folio).getResultList();
        return lista.size()>0?lista.get(0):null;
    }
}
