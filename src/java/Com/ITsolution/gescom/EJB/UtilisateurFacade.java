/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.Exception.DAOException;
import Com.ITsolution.gescom.JPA.Agence;
import Com.ITsolution.gescom.JPA.Utilisateur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> implements UtilisateurFacadeLocal {

    @PersistenceContext(unitName = "GescomFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }   
    private static final String JPQL_SELECT_LIST = "SELECT a FROM Utilisateur a WHERE   a.vue =1 and a.agId=:agence";    
    
    
    public List<Utilisateur> listuser(Agence agence )
      throws DAOException {
        
    List<Utilisateur> mesUser = null;
    Query requete = em.createQuery( JPQL_SELECT_LIST );
       requete.setParameter("agence",agence);
      try {
            mesUser = (List<Utilisateur>)requete.getResultList();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return mesUser;
   }   
    
    
    private static final String JPQL_SELECT = "SELECT a FROM Utilisateur a WHERE a.login=:username AND  a.passaword =:password and a.vue=1";
    private static final String PARAM_NOM = "username";
    private static final String PARAM_PASS = "password";
    @Override 
    public Utilisateur trouver(String username, String password)
      throws DAOException {
        
    Utilisateur utilisateur = null;
    Query requete = em.createQuery( JPQL_SELECT );
    requete.setParameter( PARAM_NOM, username   );
    requete.setParameter(  PARAM_PASS, password );
      try {
            utilisateur = (Utilisateur) requete.getSingleResult();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return utilisateur;
   }
    
    
    
     private static final String JPQL_SELECT_REQUET = "SELECT a FROM Utilisateur a WHERE a.login=:username AND a.vue=1";
    private static final String PARAM_NOM_USER = "username";
   
    @Override 
    public Utilisateur findUtilisateurConnect(String username)
      throws DAOException {
        
    Utilisateur utilisateur = null;
    Query requete = em.createQuery( JPQL_SELECT_REQUET );
    requete.setParameter( PARAM_NOM_USER, username);
      try {
            utilisateur = (Utilisateur) requete.getSingleResult();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return utilisateur;
   }
    
    private static final String JPQL_SELECT_PAR_NOM = "SELECT  u FROM Utilisateur u, Agence a WHERE u.agId = a AND  u.agId=(SELECT a FROM Agence a, Utilisateur u where a=u.agId and u.login=:login) and u.vue =1 AND  u.login =:user";
    private static final String PARAM_NOM_USE  = "user";
    private static final String PARAM_NOM_LOGIN  = "login";
    @Override 
    public Utilisateur userExiste( String user, String login) 
      throws DAOException {
        
    Utilisateur utilisateur = null;
    Query requete = em.createQuery( JPQL_SELECT_PAR_NOM );
    requete.setParameter( PARAM_NOM_USE, user );
    requete.setParameter(PARAM_NOM_LOGIN, login);
      try {
            utilisateur = (Utilisateur) requete.getSingleResult();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return utilisateur;
   }
    
    
    private static final String JPQL_SELECT_ONE_USER = "SELECT a FROM Utilisateur a WHERE a.login=:login AND   a.vue=1";
    private static final String PARAM_NOM_USER_ = "login";
  
    @Override 
    public Utilisateur rechercheModifPass(String login)
      throws DAOException {
        
    Utilisateur utilisateur = null;
    Query requete = em.createQuery( JPQL_SELECT_ONE_USER );
    requete.setParameter( PARAM_NOM_USER_, login   );
 
      try {
            utilisateur = (Utilisateur) requete.getSingleResult();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return utilisateur;
   }
    
    
}  
    
   
    

