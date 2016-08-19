
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.JPA.Agence;
import Com.ITsolution.gescom.JPA.Docentete;
import Com.ITsolution.gescom.JPA.Docligne;
import java.util.List;
import javax.ejb.Local;
@Local
public interface DocligneFacadeLocal {
    void create(Docligne docligne);
    void edit(Docligne docligne);
    void remove(Docligne docligne);
    Docligne find(Object id);
    List<Docligne> findAll();
    List<Docligne> findRange(int[] range);
    public List<Docligne> listeDocligne(Docentete idDocentete, Agence agence);
    int count();
    public List<Docligne> listedoclignes( String user);
}
