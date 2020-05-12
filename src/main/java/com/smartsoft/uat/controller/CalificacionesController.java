/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller;

import com.smartsoft.uat.business.CalificacionesBusiness;
import com.smartsoft.uat.business.CriteriosBusiness;
import com.smartsoft.uat.business.EnrolarBusiness;
import com.smartsoft.uat.business.HorariosBusiness;
import com.smartsoft.uat.business.PeriodosBusiness;
import com.smartsoft.uat.business.UnidadaprendizajeBusiness;
import com.smartsoft.uat.controller.view.CalificacionesView;
import com.smartsoft.uat.entity.Calificaciones;
import com.smartsoft.uat.entity.Enrolar;
import com.smartsoft.uat.entity.Horarios;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author chave
 */
@Named(value = "calificacionesController")
@ViewScoped
public class CalificacionesController implements Serializable{
    @Inject
    private SesionController sesion;
    @Inject
    private CalificacionesBusiness business;
    @Inject
    private CriteriosBusiness businessCriterios;
    @Inject
    private EnrolarBusiness businessEnrolar;
    @Inject
    private PeriodosBusiness periodosBusiness;
    @Inject
    private HorariosBusiness businesshorarios;
    @Inject
    private UnidadaprendizajeBusiness unidadBusiness; 
    
    private CalificacionesView view;
    
       @PostConstruct
    public void init() {
        view = new CalificacionesView();
        obtenerListaPeriodos();
        obtenerListaUnidades();
        obtenerListaCriterios();
        //mostrarLista();
    }
    
    public void obtenerListaCriterios(){
    view.setListaEntityCriterios(businessCriterios.listaporMatricula(sesion.getView().getUsuario().getMatricula()));
    }
    
    public void obtenerListaPeriodos(){
        view.setListaPeriodos(periodosBusiness.obtenerListaActivos());
    }
     
    public void obtenerListaUnidades(){
        view.setListaUnidad(unidadBusiness.obtenerUnidadesPorDoc(sesion.getView().getUsuario().getMatricula()));
    }
       
//   public void obtenerFolioMateria(){
//       view.setHorario(new Horarios());
//       view.setHorario(businesshorarios.obtenerFolioMateria(view.getPeriodo().getNombreperiodo(),view.getUnidad().getDescripcion(), view.getGrupo()));
//       copiarlista();
//    }
   
   public void obtenerCalificacionespoCriterio(){
       view.setHorario(new Horarios());
       view.setHorario(businesshorarios.obtenerFolioMateria(view.getPeriodo().getNombreperiodo(),view.getUnidad().getDescripcion(), view.getGrupo()));
      mostrarCalificaciones();
   }
   
   public void mostrarCalificaciones(){        
        String folio =view.getHorario().getFolio();
        String periodo = view.getHorario().getPeriodo();
        view.setListaEntity(business.obtenerListaActivos(periodo, view.getEntityCriterios().getNombre(), view.getParcial(), folio));
    }
   
   public void copiarlista(){   
        view.setHorario(new Horarios());
        view.setHorario(businesshorarios.obtenerFolioMateria(view.getPeriodo().getNombreperiodo(),view.getUnidad().getDescripcion(), view.getGrupo()));        
        String folio =view.getHorario().getFolio();
        String periodo = view.getHorario().getPeriodo();
        String criterio= view.getEntityCriterios().getNombre();
        String parcial= view.getParcial();
        view.getPeriodo().setNombreperiodo(periodo);
        view.getUnidad().setDescripcion(view.getHorario().getUnidadAprendizaje());
        view.setGrupo(view.getHorario().getGrupo());
        view.setListaentityEnrolar(businessEnrolar.obtenerListaDeEnrolados(folio, periodo));
        
        if(view.getListaentityEnrolar() != null){    
            
            view.getListaentityEnrolar().forEach((c) -> {
                
            if (existe(folio, criterio, periodo, c.getMatriculaUsu(), parcial)== true) {
                obtenerCalificacionespoCriterio();
            return;
            }    
         
            view.setEntity(new Calificaciones());
            view.setListaEntity(null);
            view.getEntity().setId(0);
            view.getEntity().setActivo(true);
            view.getEntity().setIdRegistro(sesion.getView().getUsuario().getId());
            view.getEntity().setFechaRegistro(new Date());
            view.getEntity().setMatriculaAlum(c.getMatriculaUsu());
            view.getEntity().setNomAlumno(c.getNombreusu());
            view.getEntity().setFoliounidad(folio); 
            view.getEntity().setPeriodo(periodo);
            view.getEntity().setParcial(parcial);
            view.getEntity().setNombreCriterio(criterio);
            guardar();
            });
    }
        obtenerCalificacionespoCriterio();
   }
    
    public void editar(Calificaciones entity) {
        view.setEntity(entity);
        view.setListaEntity(null);
        guardar();
    }
   
    public void nuevo() {
        view.setPeriodo(null);
        view.setUnidad(null);
        view.setGrupo(null);
        view.setEntity(new Calificaciones());
        //view.setEntity(businesshorarios.obtenerFolioMateria(view.getPeriodo().getNombreperiodo(),view.getUnidad().getDescripcion(), view.getGrupo()));
        view.setListaEntity(null);
        view.getEntity().setId(0);
        view.getEntity().setActivo(true);
        view.getEntity().setIdRegistro(sesion.getView().getUsuario().getId());
        view.getEntity().setFechaRegistro(new Date());
        //String folio =view.getHorario().getFolio();
        //view.setListaentityEnrolar(businessEnrolar.obtenerListaDeEnrolados(folio));
        //List<Enrolar> lista = view.getListaentityEnrolar();
    }
    
    public void guardar() {
        business.guardar(view.getEntity());
        sesion.MessageInfo("Se registro exitosamente");
        //mostrarLista();
    }
    
    public boolean existe(String foliounidad, String nombreCriterio,String periodo,String matriculaAlum, String parcial) {
        if (business.existe(foliounidad, nombreCriterio,periodo, matriculaAlum, parcial)!=null) {
            return true;
        }
        return false;
    } 
        
    public CalificacionesView getView() {
        return view;
    }
}
