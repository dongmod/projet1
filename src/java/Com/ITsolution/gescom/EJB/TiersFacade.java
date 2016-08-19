/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.Exception.DAOException;
import Com.ITsolution.gescom.JPA.Tiers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class TiersFacade extends AbstractFacade<Tiers> implements TiersFacadeLocal {

    @PersistenceContext(unitName = "GescomFinalPU")
    private EntityManager em;
@Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiersFacade() {
        super(Tiers.class);
    }
    
    
    
   private static final String JPQL_SELECT = "SELECT t FROM Tiers t  WHERE t.cleAg =(SELECT a.agId  FROM Agence a,Utilisateur u WHERE u.agId=a AND u.login=:login) AND t.vue=1";
      private static final String PARAM_USER = "login";
    public List<Tiers> listeTier(String login){
       List<Tiers> mestiers = null;
    Query requete = em.createQuery( JPQL_SELECT );
    requete.setParameter( PARAM_USER, login   );    
      try {
            mestiers = (List<Tiers>)requete.getResultList();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return mestiers;
   }   
    
    
    
    // Recherche d'une agence à partir de son nom
    private static final String JPQL_SELECT_PAR_NOM = "SELECT a FROM Tiers a WHERE a.cleAg =(SELECT a.agId  FROM Agence a,Utilisateur u WHERE u.agId=a AND u.login=:login) and a.vue=1 and  a.tRNcompteprincipale =:numero";
    private static final String PARAM_NOM  = "numero";
    private static final String PARAM_USERR  = "login";
     
    public Tiers trouver( String numero,String login ) 
      throws DAOException {
        
    Tiers tiers = null;
    Query requete = em.createQuery( JPQL_SELECT_PAR_NOM );
    requete.setParameter( PARAM_NOM, numero );
    requete.setParameter( PARAM_USERR, login );
      try {
            tiers = (Tiers) requete.getSingleResult();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return tiers;
   }
}
