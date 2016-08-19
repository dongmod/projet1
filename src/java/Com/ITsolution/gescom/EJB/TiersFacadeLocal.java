/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.JPA.Tiers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author TONLIO
 */
@Local
public interface TiersFacadeLocal {

    void create(Tiers tiers);

    void edit(Tiers tiers);

    void remove(Tiers tiers);

    Tiers find(Object id);

    List<Tiers> findAll();

    List<Tiers> findRange(int[] range);
    List<Tiers> listeTier(String user);
    int count();
    
    public Tiers trouver( String numero,String login );
    
}
