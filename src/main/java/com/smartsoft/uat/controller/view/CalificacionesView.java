/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller.view;
import com.smartsoft.uat.entity.Calificaciones;
import com.smartsoft.uat.entity.Criteriosevaluacion;
import com.smartsoft.uat.entity.Enrolar;
import com.smartsoft.uat.entity.Horarios;
import com.smartsoft.uat.entity.Periodos;
import com.smartsoft.uat.entity.Unidadaprendizaje;
import java.util.List;
/**
 *
 * @author chave
 */
public class CalificacionesView {
    private Calificaciones entity;
    private List<Calificaciones> listaEntity;
    
    private Criteriosevaluacion entityCriterios;
    private List<Criteriosevaluacion> listaEntityCriterios; 
    
    private int calificacion;
    
    private Enrolar entityEnrolar;
    private List<Enrolar> listaEntityEnrolar;
    
    private Periodos periodo;
    private List<Periodos> listaPeriodos;
    
    private Unidadaprendizaje unidad;
    private List<Unidadaprendizaje> listaUnidad;
    
    private Horarios horario;
    private List<Horarios> listaHorarios;
    
    private String folio;
    private String grupo;
    private String parcial;
    
    public Enrolar getEntityEnrolar() {
        return entityEnrolar;
    }

    public void setEntity(Enrolar entityEnrolar) {
        this.entityEnrolar = entityEnrolar;
    }

    public List<Enrolar> getListaentityEnrolar() {
        return listaEntityEnrolar;
    }

    public void setListaentityEnrolar(List<Enrolar> listaEntityEnrolar) {
        this.listaEntityEnrolar = listaEntityEnrolar;
    }
    
    public Periodos getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodos  periodo ) {
        this.periodo  = periodo ;
    }

    public List<Periodos> getListaPeriodos () {
        return listaPeriodos ;
    }

    public void setListaPeriodos (List<Periodos > listaPeriodos ) {
        this.listaPeriodos  = listaPeriodos ;
    }

     public Horarios getHorario() {
        return horario;
    }

    public void setHorario(Horarios horario ) {
        this.horario  = horario ;
    }
    
    public List<Horarios> getListaHorarios () {
        return listaHorarios ;
    }

    public void setListaHorarios (List<Horarios> listaHorarios ) {
        this.listaHorarios  = listaHorarios ;
    }
    
    public Unidadaprendizaje getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidadaprendizaje unidad) {
        this.unidad = unidad;
    }
        
     public List<Unidadaprendizaje> getListaUnidad() {
        return listaUnidad;
    }
     
    public void setListaUnidad(List<Unidadaprendizaje> listaUnidad) {
        this.listaUnidad = listaUnidad;
    }
    
    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }
    
    public String getParcial() {
        return parcial;
    }

    public void setParcial(String parcial) {
        this.parcial = parcial;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    public Calificaciones getEntity() {
        return entity;
    }

    public void setEntity(Calificaciones entity) {
        this.entity = entity;
    }

    public List<Calificaciones> getListaEntity() {
        return listaEntity;
    }

    public void setListaEntity(List<Calificaciones> listaEntity) {
        this.listaEntity = listaEntity;
    }
    
    public Criteriosevaluacion getEntityCriterios() {
        return entityCriterios;
    }

    public void setEntityCriterios(Criteriosevaluacion entityCriterios) {
        this.entityCriterios = entityCriterios;
    }

    public List<Criteriosevaluacion> getListaEntityCriterios() {
        return listaEntityCriterios;
    }

    public void setListaEntityCriterios(List<Criteriosevaluacion> listaEntityCriterios) {
        this.listaEntityCriterios = listaEntityCriterios;
    }
    
    public int getCalificacion() {
        return calificacion;
    }

    public void setEntity(int calificacion) {
        this.calificacion = calificacion;
    }
}
