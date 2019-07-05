/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Clase;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author usuario
 */
@Stateless
public class ClaseFacade extends AbstractFacade<Clase> implements ClaseFacadeLocal {

    @PersistenceContext(unitName = "Taller3JavaWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClaseFacade() {
        super(Clase.class);
    }

    @Override
    public Clase findNum(int num) {
        String consulta = "SELECT c FROM Clase c WHERE c.numero=" + num;
        try {
            Query query = em.createQuery(consulta);
            return (Clase) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
}
