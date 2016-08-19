
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.Exception.DAOException;
import Com.ITsolution.gescom.JPA.Docentete;
import Com.ITsolution.gescom.JPA.Agence;
import Com.ITsolution.gescom.JPA.Docligne;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class DocligneFacade extends AbstractFacade<Docligne> implements DocligneFacadeLocal {
    @EJB
    private AgenceFacadeLocal agenceFacade;

    @PersistenceContext(unitName = "GescomFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocligneFacade() {
        super(Docligne.class);
    }
   
  
    //ceci est la methode qui devrai rechercher les articles en fonction de la reference
    private static final String JPQL_SELECT_PAR_REF = "SELECT DISTINCT d FROM Docligne d, Docentete de WHERE de =d.deId and d.vue = 1 and de.deRef =:idDocentete and d.agId=:agence";

    @Override 
    public List<Docligne> listeDocligne(Docentete idDocentete, Agence agence)
      throws DAOException {
        
    List<Docligne> mesDocligne = null;
    Query requete = em.createQuery( JPQL_SELECT_PAR_REF );
    requete.setParameter("idDocentete",idDocentete);
    requete.setParameter("agence",agence);
      try {
            mesDocligne = (List<Docligne>)requete.getResultList();
    
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return mesDocligne;
   }   
    private static final String JPQL_SELECT_PAR_LOG = "SELECT DISTINCT d FROM Docligne d WHERE d.utilisateur=:login and d.vue=1 ";
    @Override
    public List<Docligne> listedoclignes(String user) throws DAOException {
    List<Docligne> mesDocligne = null;
    Query requete = em.createQuery( JPQL_SELECT_PAR_LOG );
    requete.setParameter("login",user);
      try {
            mesDocligne = (List<Docligne>)requete.getResultList();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
            }
    return mesDocligne;
   }   
    
}
