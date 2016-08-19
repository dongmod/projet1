/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.JPA.TierArticle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author TONLIO
 */
@Local
public interface TierArticleFacadeLocal {

    void create(TierArticle tierArticle);

    void edit(TierArticle tierArticle);

    void remove(TierArticle tierArticle);

    TierArticle find(Object id);

    List<TierArticle> findAll();

    List<TierArticle> findRange(int[] range);

    int count();
    
}
