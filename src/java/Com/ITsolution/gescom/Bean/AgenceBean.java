/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.Bean;

import Com.ITsolution.gescom.EJB.AgenceFacadeLocal;
import Com.ITsolution.gescom.JPA.Agence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author SERGE
 */
 @ManagedBean
 @ViewScoped
public class AgenceBean  implements Serializable {

    @EJB
    private AgenceFacadeLocal agenceFacade;    
    private String nom;
    private String code;
    private String adresse;
    private String ville;
    private String tel;
    private Date date;
    private Integer vue;
    private Agence agence;
    private int paramAgence;
    
    

    public int getParamAgence() {
        return paramAgence;
    }

    public void setParamAgence(int paramAgence) {
        this.paramAgence = paramAgence;
    }
    
    
    public AgenceBean(){
        agence = new Agence();
    }

     

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
     
    public List<SelectItem> getMaList() {
             List<Agence> agences= agenceFacade.findAll();
             List<SelectItem> items=new ArrayList<>();
             SelectItem item;
             for (Agence a: agences ){
                 item = new SelectItem(a, a.getAGnom());
                     items.add(item);
                     
                     
                     }
             return    items; 
             
               
        
	}
    public List<Agence> listeAgence(){
        return agenceFacade.listeAgence();
    }
     
    public void enregistrerAgence(){
       
        agence.setAgId(1);
        agence.setVue(1);
        agence.setAGdatecreation( new Date());
        agence.setAGcode(code);
        agence.setAGnom(nom);
//        agence.setVille(ville);
//        agence.setAdresse(adresse);
//        agence.setTel(tel);
        agence.setUtilisateur(Session.renvoirSession().toString());
        agenceFacade.create(agence);
        //this.getAgence();
        
        code=null;
        nom=null;
        ville=null;
        adresse=null;
        tel=null;
        
        
        FacesMessage message = new FacesMessage( "L'agence a été crée avec succès !" );
        FacesContext.getCurrentInstance().addMessage( null, message);
        
    }
    public String modifierAgence(){  
        agence.setAGnom(nom);
//        agence.setVille(ville);
//        agence.setAdresse(adresse);
//        agence.setTel(tel);
        agenceFacade.edit(agence);        
        FacesMessage message = new FacesMessage( "modification éffectuée!" );
        FacesContext.getCurrentInstance().addMessage( null, message);
        
        code=null;
        nom=null;
        return "agence.xhtml?faces-redirect=true";
    }
    
    
    public String supprimerAgence(int id) {
        Agence a = agenceFacade.find(id);
        a.setVue(2);
        agenceFacade.edit(a);
        return null;
    }
//    public void supprimerAgence(){
//        agence.setAgId(paramAgence);
//        agence.setVue(2);
//        agenceFacade.edit(agence);        
//        FacesMessage message = new FacesMessage( "suppression éffectuée!" );
//        FacesContext.getCurrentInstance().addMessage( null, message);
//    }
    
    
    public Agence  param_modif_agence(){
      agence = (Agence) agenceFacade.find(paramAgence);
      this.code= agence.getAGcode();
      this.nom=agence.getAGnom();
//      this.adresse=agence.getAdresse();
//      this.tel=agence.getTel();
//      this.ville=agence.getVille();
      return agence;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getVue() {
        return vue;
    }

    public void setVue(Integer vue) {
        this.vue = vue;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
}
