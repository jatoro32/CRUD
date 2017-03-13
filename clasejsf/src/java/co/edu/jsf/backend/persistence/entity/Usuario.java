/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.jsf.backend.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Familia Toro
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByCedula", query = "SELECT u FROM Usuario u WHERE u.cedula = :cedula")
    , @NamedQuery(name = "Usuario.findByPrimernombre", query = "SELECT u FROM Usuario u WHERE u.primernombre = :primernombre")
    , @NamedQuery(name = "Usuario.findBySegundonombre", query = "SELECT u FROM Usuario u WHERE u.segundonombre = :segundonombre")
    , @NamedQuery(name = "Usuario.findByPrimerapellido", query = "SELECT u FROM Usuario u WHERE u.primerapellido = :primerapellido")
    , @NamedQuery(name = "Usuario.findBySegundoapellido", query = "SELECT u FROM Usuario u WHERE u.segundoapellido = :segundoapellido")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuario.findByCelular", query = "SELECT u FROM Usuario u WHERE u.celular = :celular")
    , @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private Integer cedula;
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
    @Size(min = 1, max = 25)
    @Column(name = "primerapellido")
    private String primerapellido;
    @Size(max = 25)
    @Column(name = "segundoapellido")
    private String segundoapellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private long telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "celular")
    private long celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "clave")
    private String clave;
    @OneToMany(mappedBy = "cedula")
    private Collection<Aprendiz> aprendizCollection;

    public Usuario() {
    }

    public Usuario(Integer cedula) {
        this.cedula = cedula;
    }

    public Usuario(Integer cedula, String primernombre, String primerapellido, String correo, long telefono, long celular, String clave) {
        this.cedula = cedula;
        this.primernombre = primernombre;
        this.primerapellido = primerapellido;
        this.correo = correo;
        this.telefono = telefono;
        this.celular = celular;
        this.clave = clave;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @XmlTransient
    public Collection<Aprendiz> getAprendizCollection() {
        return aprendizCollection;
    }

    public void setAprendizCollection(Collection<Aprendiz> aprendizCollection) {
        this.aprendizCollection = aprendizCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.jsf.backend.persistence.entity.Usuario[ cedula=" + cedula + " ]";
    }
    
    public String getNombreCompleto(){
        String nc = primernombre + " " + ((segundonombre == null || segundonombre.equals("")) ? "" : segundonombre+ " ");
        nc += primerapellido + " " + ((segundoapellido == null || segundoapellido.equals("")) ?"" : segundoapellido);
        return nc;
    }
    
}
