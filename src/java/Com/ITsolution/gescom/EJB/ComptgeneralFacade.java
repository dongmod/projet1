/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.Exception.DAOException;
import Com.ITsolution.gescom.JPA.Comptgeneral;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author TONLIO
 */
@Stateless
public class ComptgeneralFacade extends AbstractFacade<Comptgeneral> implements ComptgeneralFacadeLocal {

    @PersistenceContext(unitName = "GescomFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComptgeneralFacade() {
        super(Comptgeneral.class);
    }
    
    private static final String JPQL_SELECT = "SELECT  cg FROM Comptgeneral cg, Famille f WHERE cg.faId=f and f.cleAg=(SELECT a.agId FROM Agence a, Utilisateur u where a=u.agId and u.login=:login ) and cg.vue =1";
    private static final String PARAM_USER = "login";
    
    
    @Override
    public List<Comptgeneral> listcompteg(String login )
      throws DAOException {
        
    List<Comptgeneral> mesComptg = null;
    Query requete = em.createQuery( JPQL_SELECT );
    requete.setParameter( PARAM_USER, login   );    
      try {
            mesComptg = (List<Comptgeneral>)requete.getResultList();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return mesComptg;
   }   
    
    
    private static final String JPQL_SELECT_PAR_NOM = "SELECT cg FROM Comptgeneral cg, Famille f WHERE cg.faId=f and f.cleAg=(SELECT a.agId FROM Agence a, Utilisateur u where a=u.agId and u.login=:login ) and  cg.vue=1 AND  cg.numeroCPT =:compte";
    private static final String PARAM_NOM  = "compte";
    private static final String PARAM_USERR  = "login";
    @Override 
    public Comptgeneral trouver( String compte,String login ) 
      throws DAOException {
        
    Comptgeneral comptgeneral = null;
    Query requete = em.createQuery( JPQL_SELECT_PAR_NOM );
    requete.setParameter( PARAM_NOM, compte );
    requete.setParameter( PARAM_USERR, login );
      try {
            comptgeneral = (Comptgeneral) requete.getSingleResult();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return comptgeneral;
   }
    
    
}
