
package Com.ITsolution.gescom.Bean;

import Com.ITsolution.gescom.EJB.FamilleFacadeLocal;
import Com.ITsolution.gescom.JPA.Famille;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class FamilleBean  implements Serializable {

    @EJB
    private FamilleFacadeLocal familleFacade;
    private String code_f ;
    private String nom_f;
    private Famille famille;
    private int paramFamille;
    private List<Famille> listFamille = new ArrayList();
    public FamilleBean() {
        famille =new Famille();
    }
    public String getCode_f() {
        return code_f;
    }

    public void setCode_f(String code_f) {
        this.code_f = code_f;
    }
    public String getNom_f() {
        return nom_f;
    }
    public void setNom_f(String nom_f) {
        this.nom_f = nom_f;
    }
    public Famille getFamille() {
        return famille;
    }
    public void setFamille(Famille famille) {
        this.famille = famille;
    }
    public int getParamFamille() {
        return paramFamille;
    }

    public void setParamFamille(int paramFamille) {
        this.paramFamille = paramFamille;
    }

    public List<Famille> getListFamille() {
        return listFamille;
    }

    public void setListFamille(List<Famille> listFamille) {
        this.listFamille = listFamille;
    }
    
    public List<Famille> mesFamilles(){
        listFamille = familleFacade.listefamille(Session.renvoirSession().toString());
        return listFamille;
    
        }
    public void enregistrerFamille(){
        famille.setFaId(1);
        famille.setFACodeFamille(code_f);
        famille.setFADesignation(nom_f);
        famille.setVue(1);
        famille.setUtilisateur(Session.renvoirSession().toString());
        familleFacade.create(famille);
        FacesMessage message = new FacesMessage( "La famille a été crée avec succès !" );
        FacesContext.getCurrentInstance().addMessage( null, message);
        code_f="";
        nom_f="";
    }
    public String modifierFamille (){  
        famille.setFADesignation(nom_f);
        familleFacade.edit(famille);        
        FacesMessage message = new FacesMessage( "modification éffectuée!" );
        FacesContext.getCurrentInstance().addMessage( null, message);
        return "Famille";
    }
    
             
       public String supprimerFamille(int id) {
        Famille f = familleFacade.find(id);
        f.setVue(2);
        familleFacade.edit(f);
        return null;
    }
       public Famille  param_modif_famille(){
      famille = (Famille) familleFacade.find(paramFamille);
      this.nom_f= famille.getFADesignation();      
      return famille;
    }
       
       
       
    
       
}