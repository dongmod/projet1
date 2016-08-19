/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.Bean;

import Com.ITsolution.gescom.EJB.ArticleFacadeLocal;
import Com.ITsolution.gescom.EJB.FamilleFacadeLocal;
import Com.ITsolution.gescom.JPA.Article;
import Com.ITsolution.gescom.JPA.Famille;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
//import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
/**
 *
 * @author SERGE
 */
@ManagedBean
@SessionScoped
public class ArticleBean implements Serializable {

    @EJB
    private FamilleFacadeLocal familleFacade;

    @EJB
    private ArticleFacadeLocal articleFacade;
    
    private  String ref;
    private String designation ;
    private String codeBare;
    private int prixAchat;
    private int prixVente;
    private int stockAlert;
    private String maFamille;
    private Famille famille;
    private Article article;   
    private int param_article;
    private String art;
    private List<Famille> listFamille = new ArrayList();
    private List<Article> listArticle = new ArrayList();       

    public ArticleBean(){
        article=new Article();        
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCodeBare() {
        return codeBare;
    }

    public void setCodeBare(String codeBare) {
        this.codeBare = codeBare;
    }

    public int getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    public int getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(int prixVente) {
        this.prixVente = prixVente;
    }

    public int getStockAlert() {
        return stockAlert;
    }

    public void setStockAlert(int stockAlert) {
        this.stockAlert = stockAlert;
    }

    public String getMaFamille() {
        return maFamille;
    }

    public void setMaFamille(String maFamille) {
        this.maFamille = maFamille;
    }

    public Famille getFamille() {
        return famille;
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

   

    public List<Famille> getListFamille() {
        return listFamille= familleFacade.listefamille(Session.renvoirSession().toString());
    }

    public void setListFamille(List<Famille> listFamille) {
        this.listFamille = listFamille;
    }

    public List<Article> getListArticle() {
        return listArticle = articleFacade.listeArticle(Session.renvoirSession().toString());
    }

    public void setListArticle(List<Article> listArticle) {
        this.listArticle = listArticle;
    }
    public Validator validerCol(){
        return new Validator() {

            @Override
            public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
                Pattern p = Pattern.compile("#[0-9]#");
                        Matcher m = p.matcher((String) value);
                if (!m.matches())
		throw new ValidatorException(new FacesMessage(
				FacesMessage.SEVERITY_ERROR, "Entrée non valide","Entrée non valide"));            }

            
        };
    }
    public void enregistrerArticle(){ 
        article.setArId(1);
        article.setArRef(ref);
        article.setARdesignation(designation);
        article.setARcodeBarre(codeBare);
        article.setARprixAchat(prixAchat);
        article.setARprixVente(prixVente);
        article.setARstockAlert(stockAlert);
        article.setUtilisateur(Session.renvoirSession().toString());
        article.setVue(1); 
        if(prixAchat < 1 || prixVente < 1 || stockAlert < 1 ){
      
     FacesMessage message = new FacesMessage( " le prix ou le stock minimal ne peut ètre inferieur à 1  " );
        FacesContext.getCurrentInstance().addMessage( null, message);
        
    }else 
        {
            if ("choisir une famille".equals(maFamille)){
            FacesMessage message = new FacesMessage( " veuillez choirsir une famille " );
        FacesContext.getCurrentInstance().addMessage( null, message);
        }else{
        
        for(int i=0; i<listFamille.size();i++){
            if ((listFamille.get(i).getFADesignation().equals(maFamille))){
                article.setFaId(listFamille.get(i));                
                break;
            }
            
        }
                article.setVue(1);        
                articleFacade.create(article);
    FacesMessage message = new FacesMessage( "L'article  a été crée avec succès !" );
        FacesContext.getCurrentInstance().addMessage( null, message);
       ref=null;
    designation =null;
     codeBare=null;
     prixAchat=0;
     prixVente=0;
    stockAlert=0;
        }
    
    }
        }
    public void suppression(int arId){      
         article = articleFacade.find(arId);
         article.setVue(2);
         articleFacade.edit(article);
    }
    
    public Article  param_modif_article(){       
      article = (Article)articleFacade.find(param_article);     
      this.codeBare=article.getARcodeBarre();
      this.designation=article.getARdesignation();
      this.prixAchat=article.getARprixAchat();
      this.prixVente=article.getARprixVente();
      this.stockAlert=article.getARstockAlert();
      return article;
    }
     Logger logger =  Logger.getGlobal();
    public String modifart() {
//        article.setArId(param_article);
        article.setARdesignation(designation);
        article.setARcodeBarre(codeBare);
        article.setVue(1);
        article.setUtilisateur("dongmo");
        article.setARprixAchat(prixAchat);
        article.setARprixVente(prixVente);
        article.setARstockAlert(stockAlert);
        for(int i=0; i<listFamille.size();i++){
            if ((listFamille.get(i).getFADesignation().equals(maFamille))){
                article.setFaId(listFamille.get(i)); 
                logger.info(maFamille);
                 break;
            }
        }
                articleFacade.edit(article);
     FacesMessage message = new FacesMessage( "Modification éffectuée !" );
        FacesContext.getCurrentInstance().addMessage( null, message); 
        //FacesContext.getCurrentInstance().getMaximumSeverity(null message);
       ref=null;
    designation =null;
     codeBare=null;
     prixAchat=0;
     prixVente=0;
    stockAlert=0;
        return "article";
    }
   

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public int getParam_article() {
        return param_article;
    }

    public void setParam_article(int param_article) {
        this.param_article = param_article;
    }
}
