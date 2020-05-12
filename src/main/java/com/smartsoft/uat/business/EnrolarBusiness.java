/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.business;

import com.smartsoft.uat.dao.EnrolarDAO;
import com.smartsoft.uat.dao.UsuariosDAO;
import com.smartsoft.uat.entity.Enrolar;
//import com.smartsoft.uat.entity.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author hp
 */
@Stateless
public class EnrolarBusiness {
    
    @Inject
    private EnrolarDAO dao;
//    @Inject
//    private UsuariosDAO daousu;
    
    public Enrolar guardar(Enrolar entity) {
        return dao.saveOrEdit(entity, entity.getId());
    }

    public Enrolar consultar(Integer id) {
        return dao.search(id);
    }

    public void eliminar(Enrolar entity, Integer idJustificantes) {
        entity.setActivo(false);
        dao.deleteLogically(entity);
    }

    public List<Enrolar> obtenerListaActivos(String matricula, String periodo) {
        return dao.listaActivos(matricula, periodo);
    }
    
   public List<Enrolar> obtenerListaDeEnrolados(String folio, String periodo) {
        return dao.listaEnrolados(folio, periodo);
    }

    public Enrolar existe(String matriculaUsu, String folio, String periodo){
        return dao.existeEnrolamiento(matriculaUsu, folio, periodo);
    }
   
      public List<Enrolar> listaenrolado(String matricula) {
        return dao.listaenrolado(matricula);
    }

}
