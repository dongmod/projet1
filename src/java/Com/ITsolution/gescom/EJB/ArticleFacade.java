/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.Exception.DAOException;
import Com.ITsolution.gescom.JPA.Article;
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
public class ArticleFacade extends AbstractFacade<Article> implements ArticleFacadeLocal {

    @PersistenceContext(unitName = "GescomFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleFacade() {
        super(Article.class);
    }
    private static final String JPQL_SELECT = "SELECT  ar FROM Article ar, Famille f WHERE ar.faId=f and f.cleAg=(SELECT a.agId FROM Agence a, Utilisateur u where a=u.agId and u.login=:login ) and ar.vue =1";
    private static final String PARAM_USER = "login";
    
    
    public List<Article> listeArticle(String login )
      throws DAOException {
        
    List<Article> mesArticle = null;
    Query requete = em.createQuery( JPQL_SELECT );
    requete.setParameter( PARAM_USER, login   );    
      try {
            mesArticle = (List<Article>)requete.getResultList();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return mesArticle;
   }   
    
    // Recherche d'une agence à partir de son nom
    private static final String JPQL_SELECT_PAR_NOM = "SELECT a FROM Article a, Famille f WHERE a.faId=f and f.cleAg=(SELECT a.agId FROM Agence a, Utilisateur u where a=u.agId and u.login=:login ) and  a.vue=1 AND  a.arRef =:ref";
    private static final String PARAM_NOM  = "ref";
    private static final String PARAM_USERR  = "login";
    @Override 
    public Article trouver( String ref,String login ) 
      throws DAOException {
        
    Article article = null;
    Query requete = em.createQuery( JPQL_SELECT_PAR_NOM );
    requete.setParameter( PARAM_NOM, ref );
    requete.setParameter( PARAM_USERR, login );
      try {
            article = (Article) requete.getSingleResult();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return article;
   }
    
    
    // Recherche d'une agence à partir de son nom
    private static final String JPQL_SELECT_PAR_NO = "SELECT a FROM Article a, Famille f WHERE a.faId=f and f.cleAg=(SELECT a.agId FROM Agence a, Utilisateur u where a=u.agId and u.login=:login ) and  a.vue=1 AND  a.aRcodeBarre =:barre";
    private static final String PARAM_NO  = "barre";
    private static final String PARAM_USE  = "login";
    @Override 
    public Article trouverbare( String barre,String login ) 
      throws DAOException {
        
    Article article = null;
    Query requete = em.createQuery( JPQL_SELECT_PAR_NO );
    requete.setParameter( PARAM_NO, barre );
    requete.setParameter( PARAM_USE, login );
      try {
            article = (Article) requete.getSingleResult();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return article;
   }
}
