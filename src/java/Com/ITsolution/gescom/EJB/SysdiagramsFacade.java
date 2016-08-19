/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.JPA.Sysdiagrams;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author TONLIO
 */
@Stateless
public class SysdiagramsFacade extends AbstractFacade<Sysdiagrams> implements SysdiagramsFacadeLocal {

    @PersistenceContext(unitName = "GescomFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SysdiagramsFacade() {
        super(Sysdiagrams.class);
    }
    
}
