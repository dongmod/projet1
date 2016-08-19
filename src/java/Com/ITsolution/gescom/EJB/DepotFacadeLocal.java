/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.JPA.Depot;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author TONLIO
 */
@Local
public interface DepotFacadeLocal {

    void create(Depot depot);

    void edit(Depot depot);

    void remove(Depot depot);

    Depot find(Object id);

    List<Depot> findAll();   

    List<Depot> findRange(int[] range);
     public Depot trouver( String nom_dp, String login) ;
    int count();
    public void deleteDepot( int id_dp);
    public List<Depot> listedepot( String user);
    
}
