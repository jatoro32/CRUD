/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.jsf.backend.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Familia Toro
 */
@Entity
@Table(name = "aprendices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aprendiz.findAll", query = "SELECT a FROM Aprendiz a")
    , @NamedQuery(name = "Aprendiz.findByDocumento", query = "SELECT a FROM Aprendiz a WHERE a.documento = :documento")
    , @NamedQuery(name = "Aprendiz.findByPrimernombre", query = "SELECT a FROM Aprendiz a WHERE a.primernombre = :primernombre")
    , @NamedQuery(name = "Aprendiz.findBySegundonombre", query = "SELECT a FROM Aprendiz a WHERE a.segundonombre = :segundonombre")
    , @NamedQuery(name = "Aprendiz.findByPrimerapellido", query = "SELECT a FROM Aprendiz a WHERE a.primerapellido = :primerapellido")
    , @NamedQuery(name = "Aprendiz.findBySegundoapellido", query = "SELECT a FROM Aprendiz a WHERE a.segundoapellido = :segundoapellido")
    , @NamedQuery(name = "Aprendiz.findByPrograma", query = "SELECT a FROM Aprendiz a WHERE a.programa = :programa")
    , @NamedQuery(name = "Aprendiz.findByFicha", query = "SELECT a FROM Aprendiz a WHERE a.ficha = :ficha")
    , @NamedQuery(name = "Aprendiz.findByCorreopersonal", query = "SELECT a FROM Aprendiz a WHERE a.correopersonal = :correopersonal")
    , @NamedQuery(name = "Aprendiz.findByCorreomisena", query = "SELECT a FROM Aprendiz a WHERE a.correomisena = :correomisena")
    , @NamedQuery(name = "Aprendiz.findByNumerocontacto", query = "SELECT a FROM Aprendiz a WHERE a.numerocontacto = :numerocontacto")})
public class Aprendiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documento")
    private Long documento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "primernombre")
    private String primernombre;
    @Size(max = 25)
    @Column(name = "segundonombre")
    private String segundonombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "primerapellido")
    private String primerapellido;
    @Size(max = 25)
    @Column(name = "segundoapellido")
    private String segundoapellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "programa")
    private String programa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ficha")
    private String ficha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correopersonal")
    private String correopersonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correomisena")
    private String correomisena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numerocontacto")
    private String numerocontacto;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    @ManyToOne
    private Usuario cedula;

    public Aprendiz() {
    }

    public Aprendiz(Long documento) {
        this.documento = documento;
    }

    public Aprendiz(Long documento, String primernombre, String primerapellido, String programa, String ficha, String correopersonal, String correomisena, String numerocontacto) {
        this.documento = documento;
        this.primernombre = primernombre;
        this.primerapellido = primerapellido;
        this.programa = programa;
        this.ficha = ficha;
        this.correopersonal = correopersonal;
        this.correomisena = correomisena;
        this.numerocontacto = numerocontacto;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public String getCorreopersonal() {
        return correopersonal;
    }

    public void setCorreopersonal(String correopersonal) {
        this.correopersonal = correopersonal;
    }

    public String getCorreomisena() {
        return correomisena;
    }

    public void setCorreomisena(String correomisena) {
        this.correomisena = correomisena;
    }

    public String getNumerocontacto() {
        return numerocontacto;
    }

    public void setNumerocontacto(String numerocontacto) {
        this.numerocontacto = numerocontacto;
    }

    public Usuario getCedula() {
        return cedula;
    }

    public void setCedula(Usuario cedula) {
        this.cedula = cedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documento != null ? documento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aprendiz)) {
            return false;
        }
        Aprendiz other = (Aprendiz) object;
        if ((this.documento == null && other.documento != null) || (this.documento != null && !this.documento.equals(other.documento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.jsf.backend.persistence.entity.Aprendiz[ documento=" + documento + " ]";
    }
    
}
