/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.jsf.fronted.controller;

import co.edu.jsf.backend.persistence.entity.Aprendiz;
import co.edu.jsf.backend.persistence.entity.facode.AprendizFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Familia Toro
 */
@Named(value = "aprendizController")
@SessionScoped
public class aprendizController implements Serializable {

    private Aprendiz apre;
    @EJB
    private AprendizFacadeLocal aFacade;

    public Aprendiz getApre() {
        return apre;
    }

    public void setApre(Aprendiz apre) {
        this.apre = apre;
    }

    public AprendizFacadeLocal getaFacade() {
        return aFacade;
    }

    public void setaFacade(AprendizFacadeLocal aFacade) {
        this.aFacade = aFacade;
    }
    
    @PostConstruct
    public void init(){
        apre = new Aprendiz();
    }
    
    public void registrarAprendiz() {
        try {
            aFacade.create(apre);
            mensajeExito("REGISTRAR");
        } catch (Exception e) {
            mensajeError(e);
        }
    }

    
    public String registrar() {
        return "";
    }
    
    public List<Aprendiz> getUsuarios() {
        try {
            return this.aFacade.findAll();
        } catch (Exception e) {
            mensajeError(e);
        }
        return null;
    }

    public void eliminarUsuario(Aprendiz apre) {
        try {
            aFacade.remove(apre);
            mensajeExito("eliminado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public void leer(Aprendiz leerAprendiz) {
        apre = leerAprendiz;
        
      
    }
    
     public void modificar() {
        
         try {
          aFacade.edit(apre);
            mensajeExito("Editado");
        } catch (Exception e) {
            mensajeError(e);
        }     
        
    }
    
   
    
     private void mensajeError(Exception e) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se ha Producido el siguiente Error: ", e.getMessage()));
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Insertar:", e.getMessage());
        RequestContext.getCurrentInstance().showMessageInDialog(msg);
    }

    private void mensajeExito(String operacion) {
        String msg = "Se ha realizado exitosamente la operacion de " + operacion;
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
        FacesMessage sal = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opereción con Exito : ", msg);
        RequestContext.getCurrentInstance().showMessageInDialog(sal);
    }
    public aprendizController() {
    }
    
}
