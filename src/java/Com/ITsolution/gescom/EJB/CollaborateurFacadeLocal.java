/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.JPA.Collaborateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author TONLIO
 */
@Local
public interface CollaborateurFacadeLocal {

    void create(Collaborateur collaborateur);

    void edit(Collaborateur collaborateur);

    void remove(Collaborateur collaborateur);

    Collaborateur find(Object id);

    List<Collaborateur> findAll();

    List<Collaborateur> findRange(int[] range);
    public List<Collaborateur> listeCollaborateur(String login );
     public Collaborateur trouver( String code,String login );
    int count();
    public Collaborateur monCollaborateur(String nom );
    
}
