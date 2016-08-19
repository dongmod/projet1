/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.Exception.DAOException;
import Com.ITsolution.gescom.JPA.Depot;
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
public class DepotFacade extends AbstractFacade<Depot> implements DepotFacadeLocal {

    @PersistenceContext(unitName = "GescomFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepotFacade() {
        super(Depot.class);
    }
    
    @Override
    public void deleteDepot( int id){                
         em.createNamedQuery("Depot.depotupdate").setParameter( "dpId", id).
                 executeUpdate();        
         
    } 
    
    
    private static final String JPQL_SELECT = "SELECT DISTINCT d FROM Depot d, Agence a, Utilisateur u  WHERE d.agId = a AND  d.agId=(SELECT a FROM Agence a, Utilisateur u where a=u.agId and u.login=:user ) and d.vue =1";
    private static final String PARAM_USER = "user";
    
    
    public List<Depot> listedepot(String user )
      throws DAOException {
        
    List<Depot> mesDepot = null;
    Query requete = em.createQuery( JPQL_SELECT );
    requete.setParameter( PARAM_USER, user   );    
      try {
            mesDepot = (List<Depot>)requete.getResultList();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return mesDepot;
   }   
    
    // Recherche d'une agence à partir de son nom
    private static final String JPQL_SELECT_PAR_NOM = "SELECT  d FROM Depot d, Agence a WHERE d.agId = a AND  d.agId=(SELECT a FROM Agence a, Utilisateur u where a=u.agId and u.login=:login) and d.vue =1 AND  d.dpNom =:nom_dp";
    private static final String PARAM_NOM  = "nom_dp";
    private static final String PARAM_NOM_USER  = "login";
    @Override 
    public Depot trouver( String nom_dp, String login) 
      throws DAOException {
        
    Depot depot = null;
    Query requete = em.createQuery( JPQL_SELECT_PAR_NOM );
    requete.setParameter( PARAM_NOM, nom_dp );
    requete.setParameter(PARAM_NOM_USER, login);
      try {
            depot = (Depot) requete.getSingleResult();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return depot;
   }
    
 }
    
    
    

