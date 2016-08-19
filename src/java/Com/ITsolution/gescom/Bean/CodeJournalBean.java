/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.Bean;

import Com.ITsolution.gescom.EJB.CodejournalFacadeLocal;
import Com.ITsolution.gescom.JPA.Codejournal;
import Com.ITsolution.gescom.JPA.Famille;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
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
public class CodeJournalBean implements Serializable{

    @EJB
    private CodejournalFacadeLocal codejournalFacade;
    private String libelle;
    private String type;
    private String compte;
    private int param_cj;
    private Codejournal codeJournal;
    
    
    public CodeJournalBean(){
        codeJournal=new Codejournal();
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }

    public int getParam_cj() {
        return param_cj;
    }

    public void setParam_cj(int param_cj) {
        this.param_cj = param_cj;
    }

    public Codejournal getCodeJournal() {
        return codeJournal;
    }

    public void setCodeJournal(Codejournal codeJournal) {
        this.codeJournal = codeJournal;
    }
    
    
   public void enregistrer(){
        codeJournal.setCjId(1);
        codeJournal.setCJlibelle(libelle);
        codeJournal.setCJtype(type);
        codeJournal.setVue(1);
        codeJournal.setCJcompteTR(compte);
        codeJournal.setUtilisateur(Session.renvoirSession().toString());
        codejournalFacade.create(codeJournal);
        FacesMessage message = new FacesMessage( "Le journal a été crée avec succès !" );
        FacesContext.getCurrentInstance().addMessage( null, message);
        libelle=null;
        type=null;
        compte=null;
    }
    public String modifiers (){  
        codeJournal.setCjId(param_cj);
        codeJournal.setCJlibelle(libelle);
        codeJournal.setCJtype(type);
        codeJournal.setCJcompteTR(compte);
        codejournalFacade.edit(codeJournal);        
        FacesMessage message = new FacesMessage( "modification éffectuée!" );
        FacesContext.getCurrentInstance().addMessage( null, message);        
        
        return "Codejournal.xhtml?faces-redirect=true";
    }
    
             
        
    
              
        public void  supprimerCJ(int id_cj){       
        Codejournal dep = codejournalFacade.find(id_cj);
        dep.setVue(2);
        codejournalFacade.edit(dep);   
 
    }
      
       public List<Codejournal> listecode(){
      List<Codejournal>  listCodej = codejournalFacade.listecodej(Session.renvoirSession().toString());
      Logger.getGlobal().info(Session.renvoirSession().toString());
        return listCodej;
    
        }
       
        public Codejournal  param_modif_codej(){
        codeJournal = (Codejournal) codejournalFacade.find(param_cj);      
        this.compte=codeJournal.getCJcompteTR();
        this.libelle=codeJournal.getCJlibelle();
        this.type=codeJournal.getCJtype();
      return codeJournal;
    }
       }
