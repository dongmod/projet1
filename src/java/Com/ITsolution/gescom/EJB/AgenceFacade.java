/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.Exception.DAOException;
import Com.ITsolution.gescom.JPA.Agence;
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
public class AgenceFacade extends AbstractFacade<Agence> implements AgenceFacadeLocal {

    @PersistenceContext(unitName = "GescomFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgenceFacade() {
        super(Agence.class);
    }
//   public List<Agence> listeAgen(){
//        return this.em.createNamedQuery("Agence.findByVue", Agence.class).getResultList();
//    }
//    public void deleteAgence( int id){                
//         em.createNamedQuery("Agence.agenceupdate").setParameter( "agId", id).
//                 executeUpdate();        
//         
//    } 
    private static final String JPQL_SELECT = "SELECT a FROM Agence a WHERE   a.vue =1";    
    
    
    public List<Agence> listeAgen()
      throws DAOException {
        
    List<Agence> mesAgences = null;
    Query requete = em.createQuery( JPQL_SELECT );
       
      try {
            mesAgences = (List<Agence>)requete.getResultList();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return mesAgences;
   }   
    private static final String JPQL_SELECT_AGENCE = "SELECT a FROM Agence a WHERE a.vue =1";
   
    public List<Agence> listeAgence()
      throws DAOException {
        
    List<Agence> lesAgences = null;
    Query requete = em.createQuery( JPQL_SELECT_AGENCE );      
      try {
            lesAgences = (List<Agence>)requete.getResultList();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return lesAgences;
   }   


public Agence select_agence_nom( String nom_ag){    
   return (Agence) this.em.createNamedQuery("SELECT a FROM Agence a WHERE a.aGnom = :aGnom").getSingleResult();
}
        // Recherche d'une agence à partir de son nom
    private static final String JPQL_SELECT_PAR_NOM = "SELECT a FROM Agence a WHERE a.vue=1 AND  a.aGnom =:nom";
    private static final String PARAM_NOM  = "nom";
    @Override 
    public Agence trouver( String nom ) 
      throws DAOException {
        
    Agence agence = null;
    Query requete = em.createQuery( JPQL_SELECT_PAR_NOM );
    requete.setParameter( PARAM_NOM, nom );
      try {
            agence = (Agence) requete.getSingleResult();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return agence;
   }
    
    // Recherche d'une agence à partir de son code
    private static final String JPQL_SELECT_PAR_CODE = "SELECT a FROM Agence a WHERE a.vue=1 and  a.aGcode = :code";
    private static final String PARAM_CODE  = "code";
    @Override 
    public Agence trouvercode ( String code ) 
      throws DAOException {
        
    Agence agence = null;
    Query requete = em.createQuery( JPQL_SELECT_PAR_CODE );
    requete.setParameter( PARAM_CODE, code );
      try {
            agence = (Agence) requete.getSingleResult();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return agence;
   }
    
    @Override
    public void deleteAgence(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
     private static final String JPQL_SELEC = "SELECT a FROM Agence a,   Utilisateur u WHERE  u.agId=a AND u.login=:login and a.vue =1";
    private static final String PARAM_USE = "login";
    @Override
    public Agence agenceUser(String login) {
        
    
      Agence agence = null;
    Query requete = em.createQuery( JPQL_SELEC );
    requete.setParameter( PARAM_USE, login );
      try {
            agence = (Agence) requete.getSingleResult();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return agence;
  
}
    }



