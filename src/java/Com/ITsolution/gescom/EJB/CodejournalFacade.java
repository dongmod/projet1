/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.Exception.DAOException;
import Com.ITsolution.gescom.JPA.Codejournal;
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
public class CodejournalFacade extends AbstractFacade<Codejournal> implements CodejournalFacadeLocal {

    @PersistenceContext(unitName = "GescomFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CodejournalFacade() {
        super(Codejournal.class);
    }
    private static final String JPQL_SELECT = "SELECT cj FROM Codejournal cj  WHERE cj.cleAg =(SELECT a.agId  FROM Agence a,Utilisateur u WHERE u.agId=a AND u.login=:login) AND cj.vue=1";
      private static final String PARAM_USER = "login";
    
    public List<Codejournal> listecodej(String login) throws DAOException {
        
    List<Codejournal> mescj = null;
    Query requete = em.createQuery(JPQL_SELECT);
    requete.setParameter( PARAM_USER, login );  
       
      try {
            mescj = (List<Codejournal>) requete.getResultList();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return mescj;
   }   
    
     // Recherche d'une famille à partir de son code
    private static final String JPQL_SELECT_PAR_NOM = "SELECT c FROM Codejournal c WHERE c.cleAg=(SELECT a.agId  FROM Agence a,Utilisateur u WHERE u.agId=a AND u.login=:login) AND c.vue=1 AND c.cJlibelle = :libelle";
    private static final String PARAM_NOM  = "libelle";
     private static final String PARAM_USERR  = "login";
    @Override
    public Codejournal trouver( String libelle,String login) 
      throws DAOException {
        
    Codejournal codejournal = null;
    Query requete = em.createQuery( JPQL_SELECT_PAR_NOM );
    requete.setParameter( PARAM_NOM, libelle );
    requete.setParameter( PARAM_USERR, login );
      try {
            codejournal = (Codejournal) requete.getSingleResult();
    
        } catch ( NoResultException e ) {
        
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return codejournal;
   }
    
}
