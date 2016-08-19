/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.JPA.Reglement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author TONLIO
 */
@Local
public interface ReglementFacadeLocal {

    void create(Reglement reglement);

    void edit(Reglement reglement);

    void remove(Reglement reglement);

    Reglement find(Object id);

    List<Reglement> findAll();

    List<Reglement> findRange(int[] range);

    int count();
    
}
