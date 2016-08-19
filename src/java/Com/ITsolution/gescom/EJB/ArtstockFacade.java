/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.Exception.DAOException;
import Com.ITsolution.gescom.JPA.Article;
import Com.ITsolution.gescom.JPA.Artstock;
import Com.ITsolution.gescom.JPA.Depot;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author TONLIO
 */
@Stateless
public class ArtstockFacade extends AbstractFacade<Artstock> implements ArtstockFacadeLocal {

    @PersistenceContext(unitName = "GescomFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArtstockFacade() {
        super(Artstock.class);
    }
    @Override
    public Article recherByREfCode( String reference){
       Article article =new Article();
//        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("ARTICLE_SELECT_DOCACHAT");
//        // set parameters
//        
//        storedProcedure.registerStoredProcedureParameter("@Identifiant", String.class, ParameterMode.IN);
//        storedProcedure.registerStoredProcedureParameter("AR_designation", String.class, ParameterMode.OUT);
//         storedProcedure.registerStoredProcedureParameter("AR_prixAchat", String.class, ParameterMode.OUT);
//        storedProcedure.setParameter("@Identifiant",reference );
//        // execute SP
//        storedProcedure.execute();
//        // get result
//        article.setARdesignation((String) storedProcedure.getOutputParameterValue("AR_designation"));
//        article.setARprixAchat((Integer)storedProcedure.getOutputParameterValue("AR_prixAchat") );
//        
        return article;
    }
    
    private static final String JPQL_SELECT = "SELECT DISTINCT ars FROM Artstock ars,Article ar, Depot d, Agence a, Utilisateur u  WHERE d.agId = a and ars.dpId=d and ars.arId=ar  AND  d.agId=(SELECT a FROM Agence a, Utilisateur u where a=u.agId and u.login=:user ) and d.vue =1";
    private static final String PARAM_USER = "user";
    
    
    public List<Artstock> listArtstock(String user )
      throws DAOException {
        
    List<Artstock> mesArtstock = null;
    Query requete = em.createQuery( JPQL_SELECT );
    requete.setParameter( PARAM_USER, user   );    
      try {
            mesArtstock = (List<Artstock>)requete.getResultList();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return mesArtstock;
   }   
    
    }
    

