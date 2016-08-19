/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.Exception.DAOException;
import Com.ITsolution.gescom.JPA.Famille;
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
public class FamilleFacade extends AbstractFacade<Famille> implements FamilleFacadeLocal {

    @PersistenceContext(unitName = "GescomFinalPU")
    private EntityManager em;
@Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FamilleFacade() {
        super(Famille.class);
    }
      private static final String JPQL_SELECT = "SELECT f FROM Famille f  WHERE f.cleAg =(SELECT a.agId  FROM Agence a,Utilisateur u WHERE u.agId=a AND u.login=:login) AND f.vue=1";
      private static final String PARAM_USER = "login";
    public List<Famille> listefamille(String login){
       List<Famille> mesfamille = null;
    Query requete = em.createQuery( JPQL_SELECT );
    requete.setParameter( PARAM_USER, login   );    
      try {
            mesfamille = (List<Famille>)requete.getResultList();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return mesfamille;
   }   
    
    public void deleteFamille( int id){                
         em.createNamedQuery("update  Famille f set f.vue=2 where f.faId=:faId").setParameter( "faId", id).
                 executeUpdate();        
         
    } 
    
         // Recherche d'une famille à partir de son code
    private static final String JPQL_SELECT_PAR_NOM = "SELECT a FROM Famille a WHERE a.cleAg =(SELECT a.agId  FROM Agence a,Utilisateur u WHERE u.agId=a AND u.login=:login) and  a.vue=1 AND  a.fACodeFamille =:code";
    private static final String PARAM_NOM  = "code";
    private static final String PARAM_USERR  = "login";
    @Override 
    public Famille trouver( String code,String login ) 
      throws DAOException {
        
    Famille famille = null;
    Query requete = em.createQuery( JPQL_SELECT_PAR_NOM );
    requete.setParameter( PARAM_NOM, code );
    requete.setParameter( PARAM_USERR, login );
      try {
            famille = (Famille) requete.getSingleResult();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return famille;
   }
    
    
}
