/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.Exception.DAOException;
import Com.ITsolution.gescom.JPA.Caisse;
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
public class CaisseFacade extends AbstractFacade<Caisse> implements CaisseFacadeLocal {

    @PersistenceContext(unitName = "GescomFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CaisseFacade() {
        super(Caisse.class);
    }
//    @Override
//    public List<Caisse> listecaisse(){
//        return this.em.createNamedQuery("SELECT c FROM Caisse c, Agence a, Utilisateur u WHERE c.agId = a AND u.agId=a AND u.nomUt=:nomUt and c.vue =1", Caisse.class).getResultList();
//    }
    
    private static final String JPQL_SELECT = "SELECT DISTINCT c FROM Caisse c, Agence a, Utilisateur u WHERE c.agId = a AND u.agId=a AND a.agId=(SELECT a.agId FROM Agence a, Utilisateur u where a=u.agId and u.login=:login ) and c.vue =1";
    private static final String PARAM_USER = "login";
    public List<Caisse> listecais(String login )
      throws DAOException {
        
    List<Caisse> mescaisses = null;
    Query requete = em.createQuery( JPQL_SELECT );
    requete.setParameter( PARAM_USER, login   );    
      try {
            mescaisses = (List<Caisse>)requete.getResultList();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return mescaisses;
   }   
    
      private static final String JPQL_SELECT_CAISSE = " SELECT c FROM Caisse c,Agence a WHERE c.agId = a AND c.agId=(SELECT a  FROM Agence a,Utilisateur u WHERE u.agId=a AND u.login=:userc) and c.vue =1  AND c.cAlibelle=:libelle";
        private static final String PARAM_USERC  = "userc";       
        private static final String PARAM_CAISSE  = "libelle";
       
      
    @Override 
   public Caisse trouver(String userc, String libelle) {
       {        
    Caisse caisse = null;
    Query requete = em.createQuery( JPQL_SELECT_CAISSE );  
    requete.setParameter( PARAM_USERC, userc );
    requete.setParameter( PARAM_CAISSE, libelle );
    
//         Logger.getGlobal().info(libelle);
//         Logger.getGlobal().info(userc);
//         Logger.getGlobal().info(nom_agence);
      try {
            caisse = (Caisse) requete.getSingleResult();    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
      
    return caisse;
    
   }
    
    }
 }
