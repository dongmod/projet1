/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.Exception.DAOException;
import Com.ITsolution.gescom.JPA.Docentete;
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
public class DocenteteFacade extends AbstractFacade<Docentete> implements DocenteteFacadeLocal {

    @PersistenceContext(unitName = "GescomFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocenteteFacade() {
        super(Docentete.class);
    }

    private static final String JPQL_SELECT_PAR_NOM = "SELECT d FROM Docentete d WHERE d.deRef =:ref";
    private static final String PARAM_NOM  = "ref";
    private static final String PARAM_USERR  = "login";
    @Override 
    //public Docentete trouver( String ref,String login ) 
        public Docentete trouver( String ref) 

      throws DAOException {
        
    Docentete docentete = null;
    Query requete = em.createQuery( JPQL_SELECT_PAR_NOM );
    requete.setParameter( PARAM_NOM, ref );
//    requete.setParameter( PARAM_USERR, login );
      try {
            docentete = (Docentete) requete.getSingleResult();
        return docentete;
        } catch ( Exception e ) {
        
            return null;
        } 

   }
    
    // Recherche d'une agence à partir de son nom
    private static final String JPQL_SELECT_PAR_REF = "SELECT d FROM  Docentete  WHERE d.deRef=:ref";
    private static final String PARAM_REF  = "ref";
    @Override 
    public Docentete monDocentete (String ref )
      throws DAOException {
        
    Docentete docentete = null;
    Query requete = em.createQuery( JPQL_SELECT_PAR_REF );
    requete.setParameter( PARAM_REF, ref   );
      
      try {
            docentete = (Docentete)requete.getResultList();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return docentete;
   }  
    private static final String JPQL_SELECT_DOC = "SELECT de FROM Docentete de, Depot dp,Agence a, Utilisateur u WHERE  de.dpId=dp and dp.agId=a and u.agId=a and u.agId=(SELECT a FROM Agence a, Utilisateur u where a=u.agId and u.login=:login )  and  de.vue=1 ";
    
    @Override
    public List<Docentete> listedoc(String user) throws DAOException {
        
    List<Docentete> docentete = null;
    Query requete = em.createQuery( JPQL_SELECT_DOC );
    requete.setParameter("login",user);
      
      try {
            docentete = (List<Docentete>)requete.getResultList();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return docentete;
   }
 
   }   
    
     
