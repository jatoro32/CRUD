/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.jsf.backend.persistence.entity.facode;

import co.edu.jsf.backend.persistence.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Familia Toro
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "clasejsfPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
     @Override
    public Usuario iniciarsesion (Usuario us){
        TypedQuery<Usuario> q = em.createQuery("FROM Usuario us WHERE us.cedula = ?1 and us.clave = ?2", Usuario.class);
        q.setParameter(1, us.getCedula());
        q.setParameter(2, us.getClave());
        if(!q.getResultList().isEmpty()){
            return q.getResultList().get(0);
                   
        }else{
            return null;
        }
    }
            
            
}



