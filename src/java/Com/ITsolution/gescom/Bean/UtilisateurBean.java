/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.Bean;

import Com.ITsolution.gescom.EJB.AgenceFacadeLocal;
import Com.ITsolution.gescom.EJB.UtilisateurFacadeLocal;
import Com.ITsolution.gescom.JPA.Agence;
import Com.ITsolution.gescom.JPA.Utilisateur;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.mindrot.jbcrypt.BCrypt;


/**
 *
 * @author SERGE
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UtilisateurBean implements Serializable {

  
    @EJB
    private UtilisateurFacadeLocal utilisateurFacade1;

    @EJB
    private AgenceFacadeLocal agenceFacade;
    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;
    
    
    private String username;
    private String password;
    private String passwordConfirm;
    private Utilisateur utilisateur;
    private String nomAgence;
    private List<Utilisateur>listuUer;
    private  List<Agence>listAgence;
    private int parammodifuser;
    private boolean adm;
    private String privil;
    private String modifpw;
    private String verifancienpass;
    public String getVerifancienpass() {
        return verifancienpass;
    }

    public void setVerifancienpass(String verifancienpass) {
        this.verifancienpass = verifancienpass;
    }
    
    
    public String getModifpw() {
        return modifpw;
    }

    public void setModifpw(String modifpw) {
        this.modifpw = modifpw;
    }
   
    public List<Agence> getListAgence() {
       listAgence = agenceFacade.listeAgen();
    return listAgence ;
    
    }
    public void setListAgence(List<Agence> listAgence) {
        this.listAgence = listAgence;
    }

    public List<Utilisateur> getListuUer() {
       listuUer = utilisateurFacade.listuser(agenceFacade.agenceUser(Session.renvoirSession().toString()));
    return listuUer ;
    }

    public String getPrivil() {
        return privil;
    }

    public void setPrivil(String privil) {
        this.privil = privil;
    }
    
    public void setListuUer(List<Utilisateur> listuUer) {
        this.listuUer = listuUer;
    }

    public int getParammodifuser() {
        return parammodifuser;
    }

    public void setParammodifuser(int parammodifuser) {
        this.parammodifuser = parammodifuser;
    }

    public boolean isAdm() {
        if (Session.getPriv() == 0){
        adm = true;
        }else
            {
                adm = false;
            }        
        return adm;
    }
    public UtilisateurBean(){
        utilisateur= new Utilisateur();
    }
    public void creerUser(){
        if( !passwordConfirm.equals(password)){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERREUR NOM D'UTILISATEUR" , "les mots de passe ne correspondent pas!" );
            FacesContext.getCurrentInstance().addMessage( null, message);
            password=null;
            passwordConfirm=null;
        }else{
                utilisateur.setId(1);
                utilisateur.setLogin(username);
                utilisateur.setPassaword(password);
                utilisateur.setDateInscription(new Date());
                utilisateur.setAgId(agenceFacade.agenceUser(Session.renvoirSession().toString()));
                utilisateur.setVue(1);
                int i=Integer.parseInt(privil);
                utilisateur.setNiveauAcces(i);
                utilisateurFacade.create(utilisateur);
                FacesMessage message = new FacesMessage( "l'utilisateur a été crée avec succès!" );
                FacesContext.getCurrentInstance().addMessage( null, message);
                nomAgence=null;
                username=null;
                password=null;
                passwordConfirm=null;
    }
        }

         public String modifiermdp() {
            Utilisateur u= utilisateurFacade.rechercheModifPass(Session.renvoirSession().toString());
          if (!u.getPassaword().equals(verifancienpass)){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERREUR MOT DE PASSE" , "ancien mot de passe incorrect!" );
            FacesContext.getCurrentInstance().addMessage( null, message);
     
        } else 
             if( !passwordConfirm.equals(modifpw)){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERREUR DE CONFIRMATION" , "les mots de passe ne correspondent pas!" );
            FacesContext.getCurrentInstance().addMessage( null, message);
        
        }
        else{
                u.setPassaword(modifpw);
                utilisateurFacade.edit(u);
        FacesMessage message = new FacesMessage("modification éffectuée!");
        FacesContext.getCurrentInstance().addMessage(null, message);
        modifpw=null;
        passwordConfirm=null;
        verifancienpass=null;
         }
     return "ModifierMDP";
     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Utilisateur  param_modif_user(){
        utilisateur = (Utilisateur) utilisateurFacade.find(parammodifuser);  
             this.username =utilisateur.getLogin();
             this.password=utilisateur.getPassaword();
             
//                utilisateur.setAgId(agenceFacade.agenceUser(Session.renvoirSession().toString()));
      return utilisateur;
    }
    //methode de modification
    public String editUser() {
        
         if( !passwordConfirm.equals(password)){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERREUR NOM D'UTILISATEUR" , "les mots de passe ne correspondent pas!" );
            FacesContext.getCurrentInstance().addMessage( null, message);
            password=null;
            passwordConfirm=null;
        }else{
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        
                utilisateur.setLogin(username);
                utilisateur.setPassaword(hashed);
                utilisateurFacade.edit(utilisateur);
        FacesMessage message = new FacesMessage("modification éffectuée!");
        FacesContext.getCurrentInstance().addMessage(null, message);
        nomAgence=null;
                username=null;
                password=null;
                passwordConfirm=null;
       
         }
     return "GestionUser";
     }
    
    
    public String login() {
       Logger logger = Logger.getLogger(username);
        //Logger loggers = Logger.getLogger(password);
        
        Utilisateur utilisateur = utilisateurFacade.trouver(username, password);
        //FacesContext context = FacesContext.getCurrentInstance();           
        if (utilisateur == null) {
 
            FacesMessage message = new FacesMessage( "mot de passe ou nom d'utilisateur incorect!" );
            FacesContext.getCurrentInstance().addMessage( null, message);
            username = null;
            password = null;
            
            return null;
        } else {
            //context.getExternalContext().getSessionMap().put("user", username);
            Session.recupSession(username, utilisateurFacade.findUtilisateurConnect(username).getNiveauAcces());
            return "/page/barremenu?faces-redirect=true";
        }
    }
    
   public String supprimer(int id) {
        Utilisateur utilisateur = utilisateurFacade.find(id);
        utilisateur.setVue(2);
        utilisateurFacade.edit(utilisateur);
        return null;
    }
    
    // LOGIN AC=VEC CRIPTAGE
//    public String login() {
//       Utilisateur utilisateur = new Utilisateur();
//        utilisateur = utilisateurFacade.findUtilisateurConnect(username);
//         
//        
//        if(utilisateur == null)
//        {
//            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERREUR NOM D'UTILISATEUR" , "le nom d'utilisateur est incorect!" );
//            FacesContext.getCurrentInstance().addMessage( null, message);
//            username = null;
//            password = null;
//        }
//        else 
//        {
//            if(BCrypt.checkpw(this.password, utilisateur.getPassaword())){
//            Session.recupSession(username, utilisateurFacade.findUtilisateurConnect(username).getNiveauAcces(),Session.getPass());
//              username = null;
//              password = null;
//            return "/page/barremenuancien?faces-redirect=true";
//            }
//            else{
//                FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_WARN, "ERREUR MOT DE PASSE" , "le mot de passe ne correspond pas!"  );
//                FacesContext.getCurrentInstance().addMessage( null, message);
//                
//            }
//              
//        }
//         return null; 
//    }
    

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();        
        FacesMessage msg = new FacesMessage("vous venez de vous déconnecter!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "/connexion.xhtml?faces-redirect=true";
    }

    // ...

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }
}
    
    
    
    
    

