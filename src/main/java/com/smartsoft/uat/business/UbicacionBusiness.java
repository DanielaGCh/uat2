/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.business;

import com.smartsoft.uat.dao.UbicacionDAO;
import com.smartsoft.uat.entity.Ubicacion;
import com.smartsoft.uat.entity.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author carlo
 */
@Stateless
public class UbicacionBusiness {
    @Inject
    private UbicacionDAO dao;
    
      public Ubicacion guardar(Ubicacion entity) {
        return dao.saveOrEdit(entity, entity.getIdUbicacion());
    }
      
     public List<Ubicacion> obtenerListaUbicacion() {
        return dao.listaUbicacion();
    }
     
     public List<Ubicacion> obtenerListahijos(String matricula) {
        return dao.listaDeHijos(matricula);
    }
      public List<Ubicacion> obtenerUbicacionAlumno(String matricula) {
        return dao.getUbicacionAlumno(matricula);
    }
}
