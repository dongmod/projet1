/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.JPA.Agence;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author TONLIO
 */
@Local
public interface AgenceFacadeLocal {

    
    void create(Agence agence);

    void edit(Agence agence);

    void remove(Agence agence);

    Agence find(Object id);

    List<Agence> findAll();

    List<Agence> findRange(int[] range);
    public List<Agence> listeAgen();
    public List<Agence> listeAgence();
    public void deleteAgence( int id);
    public Agence select_agence_nom( String nom);
    public Agence trouver( String nom );
    public Agence trouvercode ( String code );
    public Agence agenceUser (String user);
    
    int count();
    
}
