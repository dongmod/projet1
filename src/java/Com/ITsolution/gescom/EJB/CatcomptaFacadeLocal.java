/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.JPA.Catcompta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author TONLIO
 */
@Local
public interface CatcomptaFacadeLocal {

    void create(Catcompta catcompta);

    void edit(Catcompta catcompta);

    void remove(Catcompta catcompta);

    Catcompta find(Object id);

    List<Catcompta> findAll();

    List<Catcompta> findRange(int[] range);

    int count();
    
}
