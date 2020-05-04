/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartsoft.uat.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
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
 * @author andre
 */
@Entity
@Table(name = "botonpanico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Botonpanico.findAll", query = "SELECT b FROM Botonpanico b")
    ,@NamedQuery(name = "Botonpanico.findAllActivos", query = "SELECT b FROM Botonpanico b WHERE b.activo= true")
    , @NamedQuery(name = "Botonpanico.findById", query = "SELECT b FROM Botonpanico b WHERE b.id = :id")
    , @NamedQuery(name = "Botonpanico.findByMotivo", query = "SELECT b FROM Botonpanico b WHERE b.motivo = :motivo")
    , @NamedQuery(name = "Botonpanico.findByDescripcion", query = "SELECT b FROM Botonpanico b WHERE b.descripcion = :descripcion")
    , @NamedQuery(name = "Botonpanico.findByFecha", query = "SELECT b FROM Botonpanico b WHERE b.fecha = :fecha")
    , @NamedQuery(name = "Botonpanico.findByMatriculaRegistro", query = "SELECT b FROM Botonpanico b WHERE b.matriculaRegistro = :matriculaRegistro")
    , @NamedQuery(name = "Botonpanico.findByActivo", query = "SELECT b FROM Botonpanico b WHERE b.activo = :activo")
    , @NamedQuery(name = "Botonpanico.findByNombreRegistro", query = "SELECT b FROM Botonpanico b WHERE b.nombreRegistro = :nombreRegistro")})
public class Botonpanico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "motivo")
    private String motivo;
    @Size(max = 1050)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 255)
    @Column(name = "matriculaRegistro")
    private String matriculaRegistro;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 255)
    @Column(name = "nombreRegistro")
    private String nombreRegistro;

    public Botonpanico() {
    }

    public Botonpanico(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMatriculaRegistro() {
        return matriculaRegistro;
    }

    public void setMatriculaRegistro(String matriculaRegistro) {
        this.matriculaRegistro = matriculaRegistro;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getNombreRegistro() {
        return nombreRegistro;
    }

    public void setNombreRegistro(String nombreRegistro) {
        this.nombreRegistro = nombreRegistro;
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
        if (!(object instanceof Botonpanico)) {
            return false;
        }
        Botonpanico other = (Botonpanico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    public String fechaString(Date fecha) {
        SimpleDateFormat formatoFecha;
        formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));
        return fecha!=null ? formatoFecha.format(fecha): "Sin definir" ;
    }

    @Override
    public String toString() {
        return "com.smartsoft.uat.entity.Botonpanico[ id=" + id + " ]";
    }
    
}
