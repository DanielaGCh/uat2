/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chave
 */
@Entity
@Table(name = "calificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificaciones.findAll", query = "SELECT c FROM Calificaciones c")
    , @NamedQuery(name = "Calificaciones.findById", query = "SELECT c FROM Calificaciones c WHERE c.id = :id")
    , @NamedQuery(name = "Calificaciones.findByActivo", query = "SELECT c FROM Calificaciones c WHERE c.activo = :activo")
    , @NamedQuery(name = "Calificaciones.findByNombreCriterio", query = "SELECT c FROM Calificaciones c WHERE c.nombreCriterio = :nombreCriterio")
    , @NamedQuery(name = "Calificaciones.findByCalificacion", query = "SELECT c FROM Calificaciones c WHERE c.calificacion = :calificacion")
    , @NamedQuery(name = "Calificaciones.findByParcial", query = "SELECT c FROM Calificaciones c WHERE c.parcial = :parcial")
    , @NamedQuery(name = "Calificaciones.findByPeriodo", query = "SELECT c FROM Calificaciones c WHERE c.periodo = :periodo")
    , @NamedQuery(name = "Calificaciones.findByAllActivos", query = "SELECT c FROM Calificaciones c WHERE c.periodo = :periodo and c.nombreCriterio = :nombreCriterio and c.parcial = :parcial and c.foliounidad = :foliounidad and c.activo = true")
    , @NamedQuery(name = "Calificaciones.existe", query = "SELECT c FROM Calificaciones c WHERE c.matriculaAlum = :matriculaAlum and c.periodo = :periodo and c.nombreCriterio = :nombreCriterio and c.parcial = :parcial and c.foliounidad = :foliounidad and c.activo = true")
    , @NamedQuery(name = "Calificaciones.findByFoliounidad", query = "SELECT c FROM Calificaciones c WHERE c.foliounidad = :foliounidad")
    , @NamedQuery(name = "Calificaciones.findByMatriculaAlum", query = "SELECT c FROM Calificaciones c WHERE c.matriculaAlum = :matriculaAlum")
    , @NamedQuery(name = "Calificaciones.findByNomAlumno", query = "SELECT c FROM Calificaciones c WHERE c.nomAlumno = :nomAlumno")
    , @NamedQuery(name = "Calificaciones.findByFechaRegistro", query = "SELECT c FROM Calificaciones c WHERE c.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Calificaciones.findByFechaElimino", query = "SELECT c FROM Calificaciones c WHERE c.fechaElimino = :fechaElimino")
    , @NamedQuery(name = "Calificaciones.findByIdRegistro", query = "SELECT c FROM Calificaciones c WHERE c.idRegistro = :idRegistro")
    , @NamedQuery(name = "Calificaciones.findByIdElimino", query = "SELECT c FROM Calificaciones c WHERE c.idElimino = :idElimino")})
public class Calificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 255)
    @Column(name = "nombreCriterio")
    private String nombreCriterio;
    @Column(name = "calificacion")
    private Integer calificacion;
    @Size(max = 255)
    @Column(name = "parcial")
    private String parcial;
    @Size(max = 255)
    @Column(name = "periodo")
    private String periodo;
    @Size(max = 255)
    @Column(name = "foliounidad")
    private String foliounidad;
    @Size(max = 255)
    @Column(name = "matriculaAlum")
    private String matriculaAlum;
    @Size(max = 255)
    @Column(name = "nomAlumno")
    private String nomAlumno;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_elimino")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaElimino;
    @Column(name = "id_registro")
    private Integer idRegistro;
    @Column(name = "id_elimino")
    private Integer idElimino;

    public Calificaciones() {
    }

    public Calificaciones(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getNombreCriterio() {
        return nombreCriterio;
    }

    public void setNombreCriterio(String nombreCriterio) {
        this.nombreCriterio = nombreCriterio;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getParcial() {
        return parcial;
    }

    public void setParcial(String parcial) {
        this.parcial = parcial;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getFoliounidad() {
        return foliounidad;
    }

    public void setFoliounidad(String foliounidad) {
        this.foliounidad = foliounidad;
    }

    public String getMatriculaAlum() {
        return matriculaAlum;
    }

    public void setMatriculaAlum(String matriculaAlum) {
        this.matriculaAlum = matriculaAlum;
    }

    public String getNomAlumno() {
        return nomAlumno;
    }

    public void setNomAlumno(String nomAlumno) {
        this.nomAlumno = nomAlumno;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaElimino() {
        return fechaElimino;
    }

    public void setFechaElimino(Date fechaElimino) {
        this.fechaElimino = fechaElimino;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdElimino() {
        return idElimino;
    }

    public void setIdElimino(Integer idElimino) {
        this.idElimino = idElimino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificaciones)) {
            return false;
        }
        Calificaciones other = (Calificaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smartsoft.uat.entity.Calificaciones[ id=" + id + " ]";
    }
    
}
