
package Com.ITsolution.gescom.Bean;

import Com.ITsolution.gescom.EJB.AgenceFacadeLocal;
import Com.ITsolution.gescom.EJB.DepotFacadeLocal;
import Com.ITsolution.gescom.JPA.Agence;
import Com.ITsolution.gescom.JPA.Depot;
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
public class DepotBean implements Serializable {

    @EJB
    private DepotFacadeLocal depotFacade;

    @EJB
    private AgenceFacadeLocal agenceFacade;
    
    
    
    

    public DepotBean() {
        depot =new Depot();
    }

    public DepotFacadeLocal getDepotFacade() {
        return depotFacade;
    }

    public void setDepotFacade(DepotFacadeLocal depotFacade) {
        this.depotFacade = depotFacade;
    }

    private Depot depot;    
    private String nom_dp;
    private Agence agence;
    private String monagence;
    private int paramDepot;
    private List<Agence> listAgence = new ArrayList();
    private List<Depot> listDepot = new ArrayList();
     

    public Depot getDepot() {
        return depot;
    }

    public String getMonagence() {
        return monagence;
    }

    public void setMonagence(String monagence) {
        this.monagence = monagence;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }
  public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public String getNom_dp() {
        return nom_dp;
    }

    public void setNom_dp(String nom_dp) {
        this.nom_dp = nom_dp;
    }
    public void enregistrerDepot(){  
        depot.setDpId(1);
        depot.setDpNom(nom_dp); 
        depot.setAgId(agenceFacade.agenceUser(Session.renvoirSession().toString()));
        depot.setUtilisateur(Session.renvoirSession().toString());
        depot.setVue(1);        
        depotFacade.create(depot);
        FacesMessage message = new FacesMessage( "Le dépot a été crée avec succès !" );
        FacesContext.getCurrentInstance().addMessage( null, message); 
        nom_dp="";
        
    }
//
//    public List<Agence> getListAgence() {
//        listAgence = agenceFacade.listeAgen(Session.renvoirSession().toString());
//        return listAgence;
//    }
    
    public List<Depot> mesDepots(){
        listDepot = depotFacade.listedepot( Session.renvoirSession().toString());
        return listDepot;
    }
    public void  supprimerDept(int id_dp){       
        Depot dep = depotFacade.find(id_dp);
        dep.setVue(2);
        depotFacade.edit(dep);        
        
    }
    public void supprimerDepot(int id){        
        depotFacade.deleteDepot(id);
 
    }

    public int getParamDepot() {
        return paramDepot;
    }

    public void setParamDepot(int paramDepot) {
        this.paramDepot = paramDepot;
    }
    
        
    public Depot  param_modif_depot(){
      depot = (Depot) depotFacade.find(paramDepot);      
      this.nom_dp=depot.getDpNom();
      return depot;
    }
    public String modifierDepot(){  
        depot.setDpNom(nom_dp);
        depotFacade.edit(depot); 
        
        FacesMessage message = new FacesMessage( "modification éffectuée!" );
        FacesContext.getCurrentInstance().addMessage( null, message);
      return "Depot" ; 
    }
  }
   
    

