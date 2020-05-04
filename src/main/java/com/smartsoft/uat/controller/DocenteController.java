/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.controller;

import com.smartsoft.uat.business.EnrolarBusiness;
import com.smartsoft.uat.business.HorariosBusiness;
import com.smartsoft.uat.business.PeriodosBusiness;
import com.smartsoft.uat.business.UnidadaprendizajeBusiness;
import com.smartsoft.uat.controller.view.DesenrolarView;
import com.smartsoft.uat.entity.Enrolar;
import com.smartsoft.uat.entity.Horarios;
import com.smartsoft.uat.entity.Unidadaprendizaje;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author carlo
 */
public class DocenteController {
    @Inject
    private SesionController sesion;
    @Inject
    private EnrolarBusiness business;
    @Inject
    private PeriodosBusiness periodosBusiness;
    @Inject
    private HorariosBusiness businesshorarios;
    @Inject
    private UnidadaprendizajeBusiness unidadBusiness; 
    
    private DesenrolarView view;
      public  DocenteController(){
          
      }

     
    public String  obtenerListaUnidades( UnidadaprendizajeBusiness unidadBusiness , String matricula){
        List<Unidadaprendizaje> lista = unidadBusiness.obtenerUnidadesPorDoc(matricula);
         String cadena="";
         
         if(lista.size() == 0){
             return "No hay materias";
         }
         for(int i =0;i<lista.size();i++){
             cadena+=lista.get(i).getDescripcion()+",";
         }
         return cadena;
    }
       
   public void obtenerFolioMateria(){
       view.setHorario(new Horarios());
        view.setHorario(businesshorarios.obtenerFolioMateria(view.getPeriodo().getNombreperiodo(),view.getUnidad().getDescripcion(), view.getGrupo()));
        String folio =view.getHorario().getFolio();
        view.setListaEntity(business.obtenerListaDeEnrolados(folio));
    }
   
    public void desenrolarAlumno(Enrolar entity){
    entity.setAutorizacion(false);
    sesion.MessageInfo("Alumno desenrolado");
    }
    
   public String obtenerAultaUnidadAprendizaje(String unidadAprendizaje,HorariosBusiness business ){
        List<Horarios> lista = business.obtenerAulaUnidadAprendizaje(unidadAprendizaje);
        String cadena="";
        ArrayList<String> aux= new ArrayList();
        
        if(lista !=null){
            for(int i=0;i<lista.size();i++ ){
                if( !seRepite(lista.get(i).getAula(),aux)){
                     cadena+=lista.get(i).getAula()+",";
                      aux.add(lista.get(i).getAula());     
                }
                
               
              
            } 
        
        }else{
            return "No hay Aula";
        }
        return cadena;
       
   }
   public boolean seRepite(String aula,ArrayList array){
       boolean bandera=false;
       for(int i =0;i<array.size();i++){
           if(aula.equals(array.get(i))){
               bandera = true;
           }
       }
       return bandera;
   }
       public DesenrolarView getView() {
        return view;
    }
}


