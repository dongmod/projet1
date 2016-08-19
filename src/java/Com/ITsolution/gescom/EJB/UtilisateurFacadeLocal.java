/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.EJB;

import Com.ITsolution.gescom.JPA.Agence;
import Com.ITsolution.gescom.JPA.Utilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author TONLIO
 */
@Local
public interface UtilisateurFacadeLocal {

    
    void create(Utilisateur utilisateur);

    void edit(Utilisateur utilisateur);

    void remove(Utilisateur utilisateur);

    Utilisateur find(Object id);

    List<Utilisateur> findAll();

    List<Utilisateur> findRange(int[] range);

    int count();

    public Utilisateur trouver(String username, String password);
    public Utilisateur findUtilisateurConnect(String username);
    public List<Utilisateur> listuser(Agence agence );
    public Utilisateur userExiste( String user, String login) ;
    public Utilisateur rechercheModifPass(String login);
}
