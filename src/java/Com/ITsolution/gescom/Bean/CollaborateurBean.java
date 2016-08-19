/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.Bean;

import Com.ITsolution.gescom.EJB.AgenceFacadeLocal;
import Com.ITsolution.gescom.EJB.CollaborateurFacadeLocal;
import Com.ITsolution.gescom.JPA.Agence;
import Com.ITsolution.gescom.JPA.Collaborateur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 *
 * @author SERGE
 */
@ManagedBean
 @ViewScoped
public class CollaborateurBean  implements Serializable{

    @EJB
    private AgenceFacadeLocal agenceFacade;

    @EJB
    private CollaborateurFacadeLocal collaborateurFacade;
    
    private Collaborateur collaborateur;
    private List<Agence> listAgence = new ArrayList();
    private String code_coll;    
    private String nom_coll;
    private String type_coll;
    private String mon_ag;
    private Agence agence;
    private int param_coll;
    private List<Agence> listAgen = new ArrayList();
   
    public CollaborateurBean(){
    collaborateur =new Collaborateur();
        
    }

    
    public Collaborateur getCollaborateur() {
        return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }
    
    public void enregistrer() {       
        collaborateur.setCoId(1); 
        collaborateur.setCOcode(code_coll);
        collaborateur.setCOnom(nom_coll);
        collaborateur.setCOtype(type_coll);
        collaborateur.setAgId(agenceFacade.agenceUser(Session.renvoirSession().toString()));
        collaborateur.setUtilisateur(Session.renvoirSession().toString());        
        collaborateur.setVue(1);        
        collaborateurFacade.create(collaborateur);
     FacesMessage message = new FacesMessage( "Le collaborateur a été crée avec succès !" );
        FacesContext.getCurrentInstance().addMessage( null, message); 
        code_coll=null;    
         nom_coll=null;
        type_coll=null;
        mon_ag=null;
        
    }
    public String modifierCollaborateur(){
        collaborateur.setCOnom(nom_coll);
            collaborateur.setCOtype(type_coll);
         collaborateurFacade.edit(collaborateur);
        FacesMessage message = new FacesMessage( "modification éffectuée!" );
        FacesContext.getCurrentInstance().addMessage( null, message);
        
        code_coll=null;
        mon_ag=null;
        return "collaborateur.xhtml?faces-redirect=true";
    }
    public String suppression(int id) {           
        Collaborateur co = collaborateurFacade.find(id);
        co.setVue(2);
        collaborateurFacade.edit(co);       
        return null;
    }
   
   public List<Collaborateur> mesCollaborateurs(){
       List<Collaborateur> maListe= collaborateurFacade.listeCollaborateur(Session.renvoirSession().toString());
       return maListe;
   }
   public Collaborateur  param_modif_collaborateur(){
      collaborateur = (Collaborateur) collaborateurFacade.find(param_coll);
      this.code_coll= collaborateur.getCOcode();
      this.nom_coll=collaborateur.getCOnom();
      this.type_coll=collaborateur.getCOtype();
      return collaborateur;
    }
   
//   public List<Agence> getListAgen() {
//        listAgen = agenceFacade.listeAgen(Session.renvoirSession().toString());
//        return listAgen;
//    }

    public String getCode_coll() {
        return code_coll;
    }

    public void setCode_coll(String code_coll) {
        this.code_coll = code_coll;
    }

    public String getNom_coll() {
        return nom_coll;
    }

    public void setNom_coll(String nom_coll) {
        this.nom_coll = nom_coll;
    }

    public String getType_coll() {
        return type_coll;
    }

    public void setType_coll(String type_coll) {
        this.type_coll = type_coll;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public String getMon_ag() {
        return mon_ag;
    }

    public void setMon_ag(String mon_ag) {
        this.mon_ag = mon_ag;
    }

//    public List<Agence> getListAgence() {
//        listAgence = agenceFacade.listeAgen(Session.renvoirSession().toString());
//        return listAgence;
//       
//    }

    public int getParam_coll() {
        return param_coll;
    }

    public void setParam_coll(int param_coll) {
        this.param_coll = param_coll;
    }
 
}
