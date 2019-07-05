/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "clase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c")
    , @NamedQuery(name = "Clase.findByNumero", query = "SELECT c FROM Clase c WHERE c.numero = :numero")
    , @NamedQuery(name = "Clase.findByFecha", query = "SELECT c FROM Clase c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Clase.findByAsignatura", query = "SELECT c FROM Clase c WHERE c.asignatura = :asignatura")
    , @NamedQuery(name = "Clase.findByTema", query = "SELECT c FROM Clase c WHERE c.tema = :tema")
    , @NamedQuery(name = "Clase.findByHoraIncio", query = "SELECT c FROM Clase c WHERE c.horaIncio = :horaIncio")
    , @NamedQuery(name = "Clase.findByHoraFin", query = "SELECT c FROM Clase c WHERE c.horaFin = :horaFin")
    , @NamedQuery(name = "Clase.findByProfesor", query = "SELECT c FROM Clase c WHERE c.profesor = :profesor")})
public class Clase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Numero")
    private Integer numero;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "Asignatura")
    private String asignatura;
    @Size(max = 45)
    @Column(name = "Tema")
    private String tema;
    @Size(max = 45)
    @Column(name = "HoraIncio")
    private String horaIncio;
    @Size(max = 45)
    @Column(name = "HoraFin")
    private String horaFin;
    @Size(max = 45)
    @Column(name = "Profesor")
    private String profesor;

    public Clase() {
    }

    public Clase(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getHoraIncio() {
        return horaIncio;
    }

    public void setHoraIncio(String horaIncio) {
        this.horaIncio = horaIncio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Clase[ numero=" + numero + " ]";
    }
    
}
