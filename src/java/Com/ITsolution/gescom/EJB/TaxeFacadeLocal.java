/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.JPA.Taxe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author TONLIO
 */
@Local
public interface TaxeFacadeLocal {

    void create(Taxe taxe);

    void edit(Taxe taxe);

    void remove(Taxe taxe);

    Taxe find(Object id);

    List<Taxe> findAll();

    List<Taxe> findRange(int[] range);

    int count();
    
}
