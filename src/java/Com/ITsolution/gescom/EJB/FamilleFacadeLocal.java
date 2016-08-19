/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.JPA.Famille;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author TONLIO
 */
@Local
public interface FamilleFacadeLocal {
 void create(Famille famille);

    void edit(Famille famille);

    void remove(Famille famille);

    Famille find(Object id);

    List<Famille> findAll();

    List<Famille> findRange(int[] range);
    public List<Famille> listefamille( String user);
    public void deleteFamille( int id);
    int count();
    public Famille trouver( String code, String login );
    
}
