/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.jsf.backend.persistence.entity.facode;

import co.edu.jsf.backend.persistence.entity.Aprendiz;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Familia Toro
 */
@Local
public interface AprendizFacadeLocal {

    void create(Aprendiz aprendiz);

    void edit(Aprendiz aprendiz);

    void remove(Aprendiz aprendiz);

    Aprendiz find(Object id);

    List<Aprendiz> findAll();

    List<Aprendiz> findRange(int[] range);

    int count();
    
}
