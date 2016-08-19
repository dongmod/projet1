/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.Bean;
import Com.ITsolution.gescom.JPA.Agence;
import javax.faces.context.FacesContext;


/**
 *
 * @author SERGE
 */
public class Session {
    
    private static int priv;
    private static String pass;
    
//    private static String nom_utilisateur;   
//    public  String getNom_utilisateur() {
//        return nom_utilisateur;
//    }
//
//    public  void setNom_utilisateur(String aNom_utilisateur) {
//        nom_utilisateur = aNom_utilisateur;
//        FacesContext context = FacesContext.getCurrentInstance(); 
//        context.getExternalContext().getSessionMap().put("user", nom_utilisateur);
//    }

    public static int getPriv() {
        return priv;
    }

    public static void setPriv(int priv) {
        Session.priv = priv;
    }    

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        Session.pass = pass;
    }
    
    
   public static void  recupSession(String nom_user, int priv){
       Session.priv = priv;
      
       FacesContext context = FacesContext.getCurrentInstance(); 
        context.getExternalContext().getSessionMap().put("user", nom_user);
        context.getExternalContext().getSessionMap().put("priv", priv);
       
        
   }
   public static Object renvoirSession(){
        Object sess=null;
      FacesContext context = FacesContext.getCurrentInstance(); 
    sess =context.getExternalContext().getSessionMap().get("user");
       
        return sess;
   }
    
}
