/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.jsf.backend.persistence.entity.facode;

import co.edu.jsf.backend.persistence.entity.Aprendiz;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Familia Toro
 */
@Stateless
public class AprendizFacade extends AbstractFacade<Aprendiz> implements AprendizFacadeLocal {

    @PersistenceContext(unitName = "clasejsfPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AprendizFacade() {
        super(Aprendiz.class);
    }
    
}
