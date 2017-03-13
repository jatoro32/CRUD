/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.jsf.fronted.controller;

import co.edu.jsf.backend.persistence.entity.Usuario;
import co.edu.jsf.backend.persistence.entity.facode.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Familia Toro
 */
@Named(value = "usuarioController")
@SessionScoped
public class usuarioController implements Serializable {

    private Usuario user;
    
    @EJB
    private UsuarioFacadeLocal uFacade;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public UsuarioFacadeLocal getuFacade() {
        return uFacade;
    }

    public void setuFacade(UsuarioFacadeLocal uFacade) {
        this.uFacade = uFacade;
    }
    
     public List<Usuario> listarUsuario(){
        return uFacade.findAll();
    }
    
    
    @PostConstruct
    public void init(){
        user = new Usuario();
    }
    
     public String loginControl(){
        try{
            if (uFacade.iniciarsesion(user) != null){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("instructor", user);
                return "pages/home.xhtml?faces-redirect=true";
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario y/o Contraseña Incorrectos"));
                return "";
            }
        }catch(Exception e){
            return "";
        }
    }
    
    
}
