/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.Bean;

import Com.ITsolution.gescom.EJB.CodejournalFacadeLocal;
import Com.ITsolution.gescom.EJB.ComptgeneralFacadeLocal;
import Com.ITsolution.gescom.EJB.FamilleFacadeLocal;
import Com.ITsolution.gescom.JPA.Codejournal;
import Com.ITsolution.gescom.JPA.Comptgeneral;
import Com.ITsolution.gescom.JPA.Famille;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author TONLIO
 */
@ManagedBean
@ViewScoped
public class CompteGeneralBean implements Serializable {

    @EJB
    private CodejournalFacadeLocal codejournalFacade;

    @EJB
    private FamilleFacadeLocal familleFacade;

    @EJB
    private ComptgeneralFacadeLocal comptgeneralFacade;
    
    private Famille famille;
    private Codejournal codejournal;
    private String codej;
    private String famille_nom;
    private boolean tierObligatoire;
    private boolean analytique;
    private boolean lettrageAutomatique;
    private boolean butget;
     private String compte;
    private Comptgeneral comptgeneral;
    private int param;

    public int getParam() {
        return param;
    }

    public void setParam(int param) {
        this.param = param;
    }
    
    private List<Codejournal> listeCodejournal= new ArrayList();
    public List<Codejournal> getListCodejournal() {
        listeCodejournal = codejournalFacade.listecodej(Session.renvoirSession().toString());
        return listeCodejournal;
    }
    
     private List<Famille> listFamille = new ArrayList();
     public List<Famille> getListFamille() {
        return listFamille= familleFacade.listefamille(Session.renvoirSession().toString());
    }
      public void setListFamille(List<Famille> listFamille) {
        this.listFamille = listFamille;
    }
    
    public CompteGeneralBean(){
        comptgeneral=new Comptgeneral();
    }
    public Famille getFamille() {
        return famille;
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
    }

    public Codejournal getCodejournal() {
        return codejournal;
    }

    public void setCodejournal(Codejournal codejournal) {
        this.codejournal = codejournal;
    }

    public boolean isTierObligatoire() {
        return tierObligatoire;
    }

    public void setTierObligatoire(boolean tierObligatoire) {
        this.tierObligatoire = tierObligatoire;
    }

    public boolean isAnalytique() {
        return analytique;
    }

    public void setAnalytique(boolean analytique) {
        this.analytique = analytique;
    }

    public boolean isLettrageAutomatique() {
        return lettrageAutomatique;
    }

    public void setLettrageAutomatique(boolean lettrageAutomatique) {
        this.lettrageAutomatique = lettrageAutomatique;
    }

    public boolean isButget() {
        return butget;
    }

    public void setButget(boolean butget) {
        this.butget = butget;
    }
    
    public void enregistrerCG(){
            
                 
        //comptgeneral.setCgId(1);
        comptgeneral.setVue(1);
        comptgeneral.setUtilisateur(Session.renvoirSession().toString());
        comptgeneral.setAnalytique(analytique);
        comptgeneral.setButget(butget);
        comptgeneral.setLettrageAutomatique(lettrageAutomatique);
        comptgeneral.setTierObligatoire(tierObligatoire);
        comptgeneral.setNumeroCPT(compte);
        comptgeneral.setUtilisateur(Session.renvoirSession().toString());
          
        for(int a=0; a<listeCodejournal.size();a++){
            if ((listeCodejournal.get(a).getCJlibelle().equals(codej))){
                comptgeneral.setCjId(listeCodejournal.get(a));                
                break;
            }
            
        }
        for(int i=0; i<listFamille.size();i++){
            if ((listFamille.get(i).getFADesignation().equals(famille_nom))){
                comptgeneral.setFaId(listFamille.get(i));                
                break;
            }
            
        }
                        
      comptgeneralFacade.create(comptgeneral);
     FacesMessage message = new FacesMessage( "Le compte a été créee avec succès !" );
    FacesContext.getCurrentInstance().addMessage( null, message); 
    
       
    }
    
     public String modifier(){
            
        comptgeneral.setCgId(param);
        comptgeneral.setCgId(1);
        comptgeneral.setVue(1);
        comptgeneral.setUtilisateur(Session.renvoirSession().toString());
        comptgeneral.setAnalytique(analytique);
        comptgeneral.setButget(butget);
        comptgeneral.setLettrageAutomatique(lettrageAutomatique);
        comptgeneral.setTierObligatoire(tierObligatoire);
        comptgeneral.setNumeroCPT(compte);
        comptgeneral.setUtilisateur(Session.renvoirSession().toString());
          
        for(int a=0; a<listeCodejournal.size();a++){
            if ((listeCodejournal.get(a).getCJlibelle().equals(codej))){
                comptgeneral.setCjId(listeCodejournal.get(a));                
                break;
            }
            
        }
        for(int i=0; i<listFamille.size();i++){
            if ((listFamille.get(i).getFADesignation().equals(famille_nom))){
                comptgeneral.setFaId(listFamille.get(i));                
                break;
            }
            
        }
                        
      comptgeneralFacade.edit(comptgeneral);
     FacesMessage message = new FacesMessage( "Modification éffectuée !" );
    FacesContext.getCurrentInstance().addMessage( null, message); 
    
       return "CompteGeneral.xthml?faces-redirect=true";
    }
     public String supprimerCg(int id) {
     Comptgeneral   comptgeneral  = comptgeneralFacade.find(id);
        comptgeneral.setVue(2);
        comptgeneralFacade.edit(comptgeneral);
        return null;
    }

    public String getCodej() {
        return codej;
    }

    public void setCodej(String codej) {
        this.codej = codej;
    }

    public String getFamille_nom() {
        return famille_nom;
    }

    public void setFamille_nom(String famille_nom) {
        this.famille_nom = famille_nom;
    }


private List<Comptgeneral> listComptegeneral = new ArrayList();
    
    public List<Comptgeneral> getListComptegeneral() {
        return listComptegeneral=comptgeneralFacade.listcompteg(Session.renvoirSession().toString());
    }
    
     public void setListComptegeneral(List<Comptgeneral> listComptegeneral) {
        this.listComptegeneral = listComptegeneral;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }
    public Comptgeneral param_value(){
        comptgeneral = (Comptgeneral) comptgeneralFacade.find(param);     
      this.compte=comptgeneral.getNumeroCPT();
      
      return comptgeneral;
    }
  }
     
 
    
    
    

