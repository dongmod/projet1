/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.JPA.Catcompta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author TONLIO
 */
@Stateless
public class CatcomptaFacade extends AbstractFacade<Catcompta> implements CatcomptaFacadeLocal {

    @PersistenceContext(unitName = "GescomFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatcomptaFacade() {
        super(Catcompta.class);
    }
    
}
