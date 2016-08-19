/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.Bean;

import Com.ITsolution.gescom.EJB.TiersFacadeLocal;
import Com.ITsolution.gescom.JPA.Tiers;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author SERGE
 */
@ManagedBean
@ViewScoped
public class TiersBean  implements Serializable {

    @EJB
    private TiersFacadeLocal tiersFacade;
    
    public Tiers tiers = new Tiers(); 
        ////variables de verification pendant l'insertion
        private String nom;
        private String ville;
        private String adresse;
        private String tel;
        private String nomdecompte;
        private String type;
        ///
        private int modiftiers;
    public Tiers getTiers() {
        return tiers;
    }

    public void setTiers(Tiers tiers) {
        this.tiers = tiers;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNomdecompte() {
        return nomdecompte;
    }

    public void setNomdecompte(String nomdecompte) {
        this.nomdecompte = nomdecompte;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getModiftiers() {
        return modiftiers;
    }

    public void setModiftiers(int modiftiers) {
        this.modiftiers = modiftiers;
    }

    
        
    public void enregistrertiers(){
        tiers.setTrId(1);
        tiers.setTRNcompteprincipale(nomdecompte);
        tiers.setTRadresse(adresse);
        tiers.setTRnom(nom);
        tiers.setTRtel(tel);
        tiers.setTRtype(type);
        tiers.setTRville(ville);
        tiers.setUtilisateur(Session.renvoirSession().toString());
        tiers.setVue(1);
        tiersFacade.create(tiers);
        nomdecompte=null;
        adresse=null;
        nom=null;
        tel=null;
        type=null;
        ville=null;
        FacesMessage message = new FacesMessage("le tiers a été crée avec succès");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
    }
    public String suppression(int id) {
        Tiers co = tiersFacade.find(id);
        co.setVue(2);
        tiersFacade.edit(co);
        return null;
    }
    
    //fait la recherche en fonction de l'id
    public Tiers chercherid() {   
        tiers = (Tiers) tiersFacade.find(modiftiers);  
        this.adresse = tiers.getTRadresse();
        this.nom = tiers.getTRnom();
        this.nomdecompte = tiers.getTRNcompteprincipale();
        this.tel = tiers.getTRtel();
        this.ville = tiers.getTRville();
        this.type = tiers.getTRtype();      
       
        return tiers;
    }
    //methode de modification
    public String editTier() {
        tiers.setTrId(modiftiers);
        tiers.setTRadresse(adresse);
        tiers.setTRnom(nom);
        tiers.setTRtel(tel);
        tiers.setTRtype(type);
        tiers.setTRville(ville);
        tiers.setTRNcompteprincipale(nomdecompte);
        tiersFacade.edit(tiers);
        
        FacesMessage message = new FacesMessage("modification reussie");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return "Tiers";
    }
    
    //fait la recherche en fonction de la valeur de la vue
    public List<Tiers> getRetrievalbyvue() {
        return tiersFacade.listeTier(Session.renvoirSession().toString());
    }
}
