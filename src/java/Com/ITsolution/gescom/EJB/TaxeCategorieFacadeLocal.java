/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.JPA.TaxeCategorie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author TONLIO
 */
@Local
public interface TaxeCategorieFacadeLocal {

    void create(TaxeCategorie taxeCategorie);

    void edit(TaxeCategorie taxeCategorie);

    void remove(TaxeCategorie taxeCategorie);

    TaxeCategorie find(Object id);

    List<TaxeCategorie> findAll();

    List<TaxeCategorie> findRange(int[] range);

    int count();
    
}
