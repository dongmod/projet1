/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.Bean;

import Com.ITsolution.gescom.EJB.AgenceFacadeLocal;
import Com.ITsolution.gescom.EJB.CaisseFacadeLocal;
import Com.ITsolution.gescom.EJB.CodejournalFacadeLocal;
import Com.ITsolution.gescom.JPA.Agence;
import Com.ITsolution.gescom.JPA.Caisse;
import Com.ITsolution.gescom.JPA.Codejournal;
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

    
    public class CaisseBean implements Serializable {

    @EJB
    private CodejournalFacadeLocal codejournalFacade;

    @EJB
    private AgenceFacadeLocal agenceFacade;

    @EJB
    private CaisseFacadeLocal caisseFacade;

    private Agence mon_agence;
    private String libelle;
    private String mon_code;
    private int param_caisse;
    private Caisse caisse;
  
    
    public CaisseBean (){
        caisse = new Caisse();
    }
    
    private List<Caisse> listeCaisse= new ArrayList();
   
       
    private List<Codejournal> listeCodejournal= new ArrayList();
    public List<Codejournal> getListCodejournal() {
        listeCodejournal = codejournalFacade.listecodej(Session.renvoirSession().toString());
        return listeCodejournal;
    }
    
    public List<Caisse> getListeCaiss() {
        listeCaisse = caisseFacade.listecais(Session.renvoirSession().toString());
        return listeCaisse;
    }

    public CaisseFacadeLocal getCaisseFacade() {
        return caisseFacade;
    }

    public void setCaisseFacade(CaisseFacadeLocal caisseFacade) {
        this.caisseFacade = caisseFacade;
    }

   
       
       
   
//    public Converter maConvertion(){
//        return new Converter() {
//            @Override
//            public Object getAsObject(FacesContext context, UIComponent component, String value) {
//               // Logger.getGlobal().info(value);
//                return listeAgence.get(0);
//                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public String getAsString(FacesContext context, UIComponent component, Object value) {
//                return null;
//                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        };
//    }
    
    

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getMon_code() {
        return mon_code;
    }

    public void setMon_code(String mon_code) {
        this.mon_code = mon_code;
    }

    public int getParam_caisse() {
        return param_caisse;
    }

    public void setParam_caisse(int param_caisse) {
        this.param_caisse = param_caisse;
    }

    public Caisse getCaisse() {
        return caisse;
    }

    public void setCaisse(Caisse caisse) {
        this.caisse = caisse;
    }

   

    public List<Codejournal> getListeCodejournal() {
        return listeCodejournal;
    }

    public void setListeCodejournal(List<Codejournal> listeCodejournal) {
        this.listeCodejournal = listeCodejournal;
    }
    
    
    public void enregistrer(){      
                 
        caisse.setCaId(1);
        caisse.setCAlibelle(libelle);
        caisse.setVue(1);
         caisse.setAgId(agenceFacade.agenceUser(Session.renvoirSession().toString()));
         caisse.setUtilisateur(Session.renvoirSession().toString());
          
        for(int a=0; a<listeCodejournal.size();a++){
            if ((listeCodejournal.get(a).getCJlibelle().equals(mon_code))){
                caisse.setCjId(listeCodejournal.get(a));                
                break;
            }
            
        }
                        
      caisseFacade.create(caisse);
     FacesMessage message = new FacesMessage( "La caisse a été créee avec succès !" );
    FacesContext.getCurrentInstance().addMessage( null, message); 
    
       libelle=null;
    }
    public Caisse  param_modif_caisse(){
      caisse = (Caisse) caisseFacade.find(param_caisse);
      this.libelle=caisse.getCAlibelle();
      return caisse;
    }
  public String modifiercaisse(){      
                 
        caisse.setCAlibelle(libelle);
        caisse.setVue(1);
        caisse.setAgId(agenceFacade.agenceUser(Session.renvoirSession().toString()));
                        
        for(int a=0; a<listeCodejournal.size();a++){
            if ((listeCodejournal.get(a).getCJlibelle().equals(mon_code))){
                caisse.setCjId(listeCodejournal.get(a));                
                break;
            }
        }
        caisseFacade.edit(caisse);
        return "caisse.xhtml?faces-redirect=true";
    } 
  public String suppressioncaisse(int id) {           
        Caisse ca = caisseFacade.find(id);
        ca.setVue(2);
        caisseFacade.edit(ca);       
        return null;
    }

    public Agence getMon_agence() {
        return mon_agence;
    }

    public void setMon_agence(Agence mon_agence) {
        Logger.getGlobal().info("Agence: "+mon_agence);
        this.mon_agence = mon_agence;
    }

    
    
}

    
   
    
    

