/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.Exception.DAOException;
import Com.ITsolution.gescom.JPA.Collaborateur;
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
public class CollaborateurFacade extends AbstractFacade<Collaborateur> implements CollaborateurFacadeLocal {

    @PersistenceContext(unitName = "GescomFinalPU")
    private EntityManager em;
@Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CollaborateurFacade() {
        super(Collaborateur.class);
    }
    
  
    private static final String JPQL_SELECT = "SELECT DISTINCT c FROM Collaborateur c, Agence a, Utilisateur u WHERE c.agId = a AND u.agId=a AND a.agId=(SELECT a.agId FROM Agence a, Utilisateur u where a=u.agId and u.login=:login ) and c.vue =1";
    private static final String PARAM_USER = "login";
    
    
   public List<Collaborateur> listeCollaborateur(String login )
      throws DAOException {
        
    List<Collaborateur> mescolaborateurs = null;
    Query requete = em.createQuery( JPQL_SELECT );
    requete.setParameter( PARAM_USER, login   );    
      try {
            mescolaborateurs = (List<Collaborateur>)requete.getResultList();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return mescolaborateurs;
   }   
    
     // Recherche d'une agence à partir de son nom
    private static final String JPQL_SELECT_PAR_CODE = "SELECT c FROM Collaborateur c,Agence a WHERE c.agId=a and c.agId=(SELECT a.agId FROM Agence a, Utilisateur u where a=u.agId and u.login=:login ) and c.vue =1 and c.cOcode =:code_coll";
    private static final String PARAM_CODE  = "code_coll";
     private static final String PARAM_USERR  = "login";
    @Override 
    public Collaborateur trouver( String code_coll,String login ) 
      throws DAOException {
        
    Collaborateur collaborateur = null;
    Query requete = em.createQuery( JPQL_SELECT_PAR_CODE );
    requete.setParameter( PARAM_CODE, code_coll );
    requete.setParameter( PARAM_USERR, login );
      try {
            collaborateur = (Collaborateur) requete.getSingleResult();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return collaborateur;
   }
    
    private static final String JPQL_SELECTT = "SELECT DISTINCT c FROM Collaborateur c WHERE c.cOnom=:nom  and c.vue =1";
    private static final String PARAM_NOM = "nom";
    
    
   public Collaborateur monCollaborateur(String nom )
      throws DAOException {
        
    Collaborateur co = new Collaborateur();
    Query requete = em.createQuery( JPQL_SELECTT );
    requete.setParameter( PARAM_NOM, nom   );    
      try {
            co = (Collaborateur)requete.getResultList();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return co;
   }   
    
}
