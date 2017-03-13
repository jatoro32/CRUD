/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.jsf.fronted.controller;

import co.edu.jsf.backend.persistence.entity.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author Familia Toro
 */
@Named(value = "seguridadController")
@SessionScoped
public class seguridadController implements Serializable {

    
   public void verificarSesion(){
       try {
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("instructor");
          if(user == null){
              FacesContext.getCurrentInstance().getExternalContext().redirect("./../permisos.xhtml");
              
          }         
       } catch (Exception e) {
           
       }
   }
   
   public void cerrarSesion(){
       FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
   }
    public seguridadController() {
    }
    
}
