//package Com.ITsolution.gescom.validator;
//
//import Com.ITsolution.gescom.Bean.Session;
//import Com.ITsolution.gescom.EJB.ArticleFacadeLocal;
//import Com.ITsolution.gescom.EJB.ArtstockFacadeLocal;
//import Com.ITsolution.gescom.JPA.Article;
//import java.io.IOException;
//import java.io.Serializable;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.ejb.EJB;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
//
///**
// *
// * @author SERGE
// */
//@ManagedBean
//@ViewScoped
//public class GriserChamp {
//
//    @EJB
//    private ArtstockFacadeLocal artstockFacade;
//
//    @EJB
//    private ArticleFacadeLocal articleFacade;
//
//    private boolean disable;
//    private String tmp;
//    private String designation;
//    private int Prix_achat;
//    private Article article;
//
//    public String getDesignation() {
//        return designation;
//    }
//
//    public void setDesignation(String designation) {
//        this.designation = designation;
//    }
//
//    public int getPrix_achat() {
//        return Prix_achat;
//    }
//
//    public void setPrix_achat(int Prix_achat) {
//        this.Prix_achat = Prix_achat;
//    }
//
//    public Article getArticle() {
//        return article;
//    }
//
//    public void setArticle(Article article) {
//        this.article = article;
//    }
//    
//    public void GriseChamp(){
//        article= new Article();
//    }
//
//    
//    public boolean isDisable() {
//        return disable;
//    }
//
//    public void setDisable(boolean disable) {
//        this.disable = disable;
//    }
//
//    public String getTmp() {
//        return tmp;
//    }
//
//    public void setTmp(String tmp) {
//        this.tmp = tmp;
//    }
//    
//
//    
//   
//    
//    
//    public void  grise(){
//          String login = Session.renvoirSession().toString();
//            if (articleFacade.trouver( tmp,login ) != null ) {
//                Article a= new Article();
//                a=articleFacade.trouver(tmp, login);
//                this.designation=a.getARdesignation();
//                this.Prix_achat=a.getARprixAchat();
//                disable = true;
//       
//           }else
//            if (articleFacade.trouverbare(tmp,login ) != null ) {
//              
//                Article b= new Article();
//                b=articleFacade.trouverbare(tmp, login);
//                this.designation=b.getARdesignation();
//                this.Prix_achat=b.getARprixAchat();
//                disable = true;
////                Logger.getGlobal().info(designation);
////                Logger.getGlobal().info(Integer.toString(Prix_achat));
////                
//           
//          
//   
//            }else{
//               
//               FacesMessage message = new FacesMessage( "cet article n'existe pas" );
//                FacesContext.getCurrentInstance().addMessage( null, message);
//                
//              try {
//                  FacesContext.getCurrentInstance().getExternalContext().redirect("article.xhtml?faces-redirect=true");
//              } catch (IOException ex) {
//                  Logger.getLogger(GriserChamp.class.getName()).log(Level.SEVERE, null, ex);
//              }
//           
//                    }
//        }
//            
//            
//  
//    }
//
//
