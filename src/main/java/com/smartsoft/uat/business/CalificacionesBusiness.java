/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.business;

import com.smartsoft.uat.dao.CalificacionesDAO;
import com.smartsoft.uat.entity.Calificaciones;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;


/**
 *
 * @author chave
 */
@Stateless
public class CalificacionesBusiness {
    @Inject
    private CalificacionesDAO dao;
    
    public List<Calificaciones> obtenerListaActivos(String periodo, String criterio, String parcial, String folio) {
        return dao.listaActivos(periodo,criterio, parcial, folio);
    }
    
    public Calificaciones guardar(Calificaciones entity) {
        return dao.saveOrEdit(entity, entity.getId());
    }
    
   public  Calificaciones existe(String foliounidad, String nombreCriterio,String periodo,String matriculaAlum, String parcial){
        return dao.existe(foliounidad, nombreCriterio,periodo, matriculaAlum, parcial);
    }
}
