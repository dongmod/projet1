/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.JPA.Comptgeneral;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author TONLIO
 */
@Local
public interface ComptgeneralFacadeLocal {

    void create(Comptgeneral comptgeneral);

    void edit(Comptgeneral comptgeneral);

    void remove(Comptgeneral comptgeneral);

    Comptgeneral find(Object id);

    List<Comptgeneral> findAll();

    List<Comptgeneral> findRange(int[] range);
    public List<Comptgeneral> listcompteg(String login );
    public Comptgeneral trouver( String compte,String login );

    int count();
    
}
