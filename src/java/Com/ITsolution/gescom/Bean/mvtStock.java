
package Com.ITsolution.gescom.Bean;

import Com.ITsolution.gescom.EJB.AgenceFacadeLocal;
import Com.ITsolution.gescom.EJB.ArticleFacadeLocal;
import Com.ITsolution.gescom.EJB.ArtstockFacadeLocal;
import Com.ITsolution.gescom.EJB.CodejournalFacadeLocal;
import Com.ITsolution.gescom.EJB.CollaborateurFacadeLocal;
import Com.ITsolution.gescom.EJB.DepotFacadeLocal;
import Com.ITsolution.gescom.EJB.DocenteteFacadeLocal;
import Com.ITsolution.gescom.EJB.DocligneFacadeLocal;
import Com.ITsolution.gescom.EJB.TiersFacadeLocal;
import Com.ITsolution.gescom.JPA.Article;
import Com.ITsolution.gescom.JPA.Artstock;
import Com.ITsolution.gescom.JPA.Codejournal;
import Com.ITsolution.gescom.JPA.Collaborateur;
import Com.ITsolution.gescom.JPA.Depot;
import Com.ITsolution.gescom.JPA.Docentete;
import Com.ITsolution.gescom.JPA.Docligne;
import Com.ITsolution.gescom.JPA.Tiers;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;


@ManagedBean
@ViewScoped
public class mvtStock implements Serializable {

    @EJB
    private AgenceFacadeLocal agenceFacade;

    @EJB
    private DocligneFacadeLocal docligneFacade;

    @EJB
    private DocenteteFacadeLocal docenteteFacade;

    @EJB
    private TiersFacadeLocal tiersFacade;
    @EJB
    private CodejournalFacadeLocal codejournalFacade;

    @EJB
    private CollaborateurFacadeLocal collaborateurFacade;

    @EJB
    private ArticleFacadeLocal articleFacade;

    @EJB
    private DepotFacadeLocal depotFacade;

    @EJB
    private ArtstockFacadeLocal artstockFacade;
    
    //ici les parametres de modification du doc entete
    private Tiers modift_tiers;
    private int modit_id_docentete;
    private Codejournal modif_journal;
    private Depot modif_depot;
    private Collaborateur modif_collaborateur;
    private String modif_ref;
    
    //ici les parametre de modification du doc lignes
    private int modif_qte;
    private int modif_privente;
    
    private Date datedoc;
    private boolean disable;
    private boolean disable1;
    private String tmp;
    private String designation;
    private int prix_achat;
    private Article article;
    private Docligne docligne;
    private String nomDepot;
    private Depot depot;
    private Codejournal codejournal;
    private String codej;
    private String nomCpt;
    private String nomtier;
    private Tiers tiers;
    private String nomcol;
    private Collaborateur colaborateur;
    private Docentete docentete;
    private Docentete idDocentete;
    private int paramArtStock;
    private String reference;
    private String parammodifuser;
    private  List<Depot>listDepot;
    private  List<Artstock>listArtSock;
    private boolean griserChamp;
    private int param_docentete;
    private List<Docligne> listeDocligner= new ArrayList();
    private List<Docentete> listedocentete= new ArrayList();
    private List<Docligne> liste_des_doc_ligne= new ArrayList();
    public int qte;

    public int getModif_qte() {
        return modif_qte;
    }

    public void setModif_qte(int modif_qte) {
        this.modif_qte = modif_qte;
    }

    
    public String getModif_ref() {
        return modif_ref;
    }

    public void setModif_ref(String modif_ref) {
        this.modif_ref = modif_ref;
    }

//    public int getParam_modif_doc_ligne() {
//        return param_modif_doc_ligne;
//    }
//
//    public void setParam_modif_doc_ligne(int param_modif_doc_ligne) {
//        this.param_modif_doc_ligne = param_modif_doc_ligne;
//    }

    
    public Tiers getModift_tiers() {
        return modift_tiers;
    }

    public void setModift_tiers(Tiers modift_tiers) {
        this.modift_tiers = modift_tiers;
    }

    public int getModit_id_docentete() {
        return modit_id_docentete;
    }

    public void setModit_id_docentete(int modit_id_docentete) {
        this.modit_id_docentete = modit_id_docentete;
    }

    public Codejournal getModif_journal() {
        return modif_journal;
    }

    public void setModif_journal(Codejournal modif_journal) {
        this.modif_journal = modif_journal;
    }

    public Depot getModif_depot() {
        return modif_depot;
    }

    public void setModif_depot(Depot modif_depot) {
        this.modif_depot = modif_depot;
    }

    public Collaborateur getModif_collaborateur() {
        return modif_collaborateur;
    }

    public int getModif_privente() {
        return modif_privente;
    }

    public void setModif_privente(int modif_privente) {
        this.modif_privente = modif_privente;
    }
    
    
    public void setModif_collaborateur(Collaborateur modif_collaborateur) {
        this.modif_collaborateur = modif_collaborateur;
    }
    
    public int getQte() {
        return qte;
    }
    public Docentete getDocentete() {
        return docentete;
    }

    public void setDocentete(Docentete docentete) {
        this.docentete = docentete;
    }
    
    public int getParam_docentete() {
        return param_docentete;
    }
    

    public void setParam_docentete(int param_docentete) {
        this.param_docentete = param_docentete;
    }
    
    public void setQte(int qte) {
        this.qte = qte;
    }
    
    public Docligne getDocligne() {
        return docligne;
    }

    public void setDocligne(Docligne docligne) {
        this.docligne = docligne;
    }
    public boolean isGriserChamp() {
        return griserChamp;
    }

    public void setGriserChamp(boolean griserChamp) {
        this.griserChamp = griserChamp;
    }

    public boolean isDisable1() {
        return disable1;
    }
    public mvtStock(){
        docentete= new Docentete();
    }
    public Codejournal getCodejournal() {
        return codejournal;
    }

    public void setCodejournal(Codejournal codejournal) {
        this.codejournal = codejournal;
    }

    public String getCodej() {
        return codej;
    }

    public void setCodej(String codej) {
        this.codej = codej;
    }
      public List<Collaborateur> getlisteCollaborateur() {
        listeCollaborateur = collaborateurFacade.listeCollaborateur(Session.renvoirSession().toString());
        return listeCollaborateur;
    }
      // CETTE METHODE EST CELLE DONT LA LISTE EST RENVOIYEE PAR LA CLASSE ENTITE
    public List<Docligne> getListe_des_doc_ligne() {
        docentete = (Docentete) docenteteFacade.find(param_docentete);
        liste_des_doc_ligne = docentete.getDocligneList(); 
        String s = new String();
        s = Integer.toString(param_docentete);
        Logger.getGlobal().info(s);
        return liste_des_doc_ligne;
    }

    public void setListe_des_doc_ligne(List<Docligne> liste_des_doc_ligne) {
        this.liste_des_doc_ligne = liste_des_doc_ligne;
    }
   
    private List<Codejournal> listeCodejournal= new ArrayList();
    
    public List<Codejournal> getListCodejournal() {
        listeCodejournal = codejournalFacade.listecodej(Session.renvoirSession().toString());
        return listeCodejournal;
    }

    public List<Docentete> getListedocentete() {
        listedocentete = docenteteFacade.listedoc(Session.renvoirSession().toString());
        return listedocentete;
    }

    public void setListedocentete(List<Docentete> listedocentete) {
        this.listedocentete = listedocentete;
    }
   
    
    private List<Tiers> listetiers= new ArrayList();

    public List<Tiers> getListetiers() {
       listetiers = tiersFacade.listeTier(Session.renvoirSession().toString());
        return listetiers;
    }

    public void setListetiers(List<Tiers> listetiers) {
        this.listetiers = listetiers;
    }
    
    private List<Collaborateur> listeCollaborateur= new ArrayList();
    
  
    public Docentete recupDocentete( String ref){
       idDocentete=docenteteFacade.monDocentete(reference);
        return idDocentete;
    }

    public void setListeDocligner(List<Docligne> listeDocligner) {
        this.listeDocligner = listeDocligner;
    }
    
    public List<Docligne> getListeDocligner() {
         listeDocligner = docligneFacade.listedoclignes(Session.renvoirSession().toString());
        return listeDocligner;
        
    }

    
    
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    
   
    public DepotFacadeLocal getDepotFacade() {
        return depotFacade;
    }

    public void setDepotFacade(DepotFacadeLocal depotFacade) {
        this.depotFacade = depotFacade;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getPrix_achat() {
        return prix_achat;
    }

    public void setPrix_achat(int Prix_achat) {
        this.prix_achat = Prix_achat;
    }
    public int getParamArtStock() {
        return paramArtStock;
    }

    public void setParamArtStock(int paramArtStock) {
        this.paramArtStock = paramArtStock;
    }

    public List<Depot> getListDepot() {
   listDepot = depotFacade.listedepot( Session.renvoirSession().toString());
        return listDepot;
    }

    public List<Artstock> getListArtSock() {
        listArtSock=artstockFacade.listArtstock(Session.renvoirSession().toString());
        return listArtSock;
    }

    public void setListArtSock(List<Artstock> listArtSock) {
        this.listArtSock = listArtSock;
    }
    
     public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }
   
    public String getNomDepot() {
        return nomDepot;
    }

    public void setNomDepot(String nomDepot) {
        this.nomDepot = nomDepot;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

 public void  grise(){
          String login = Session.renvoirSession().toString();
          article = articleFacade.trouver( tmp,login ) != null ? 
                  articleFacade.trouver( tmp,login ) : articleFacade.trouverbare(tmp,login );
          if(article != null){
                this.designation=article.getARdesignation();
                this.prix_achat=article.getARprixAchat();
                disable = true;
          }
//            if (articleFacade.trouver( tmp,login ) != null ) {
//                article=articleFacade.trouver(tmp, login);
//                this.designation=article.getARdesignation();
//                this.prix_achat=article.getARprixAchat();
//                disable = true;
//       
//           }else
//            if (articleFacade.trouverbare(tmp,login ) != null ) {
//                article=articleFacade.trouverbare(tmp, login);
//                this.designation=article.getARdesignation();
//                this.prix_achat=article.getARprixAchat();
//                disable = true;
//              
//            }
            else{
               
              try {
                    FacesMessage message = new FacesMessage( "cet article n'existe pas" );
                    FacesContext.getCurrentInstance().addMessage( null, message);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("article.xhtml?faces-redirect=true");
              } catch (IOException ex) {
                  Logger.getLogger(mvtStock.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
     }
 
 public void enregistrerDocEntete(){
     griserChamp=true;
     docentete.setUtilisateur(Session.renvoirSession().toString());
     docentete.setVue(1);
     docentete.setDeId(1);
     docentete.setDEdate(datedoc);
     docentete.setDEdomaine(0);
     docentete.setDEtype(1);
      for(int i=0; i<listDepot.size();i++){
            if ((listDepot.get(i).getDpNom().equals(nomDepot))){
                docentete.setDpId(listDepot.get(i));
                break;
            }
        }
      for(int a=0; a<listeCodejournal.size();a++){
            if ((listeCodejournal.get(a).getCJlibelle().equals(codej))){
                docentete.setCjId(listeCodejournal.get(a)); 
                break;
            }
            
        }
     
      for(int c=0; c<listetiers.size();c++){
            if ((listetiers.get(c).getTRnom().equals(nomtier))){
                docentete.setTrId(listetiers.get(c)); 
                break;
            }
            
        }
      
      for(int d=0; d<listeCollaborateur.size();d++){
            if ((listeCollaborateur.get(d).getCOnom().equals(nomcol))){
                docentete.setCoId(listeCollaborateur.get(d)); 
                break;
            }
            
        }
       docentete.setDeRef(reference);
       docenteteFacade.create(docentete);
     FacesMessage message = new FacesMessage( " succès !" );
    FacesContext.getCurrentInstance().addMessage( null, message);
 }
 
 
 
 public String ajouterArticle(){
     Docentete de = docenteteFacade.trouver(reference);//comment choisir le document
     
     //Logger.getGlobal().info("depot: "+de.getDpId().getDpId());
     if (reference == null) {
         FacesMessage message = new FacesMessage( "Veuillez renseigner le document d'entête" );
         FacesContext.getCurrentInstance().addMessage( null, message);
        }else{
     Docligne doclignes  = new Docligne();
     doclignes.setDeId(de);
     doclignes.setArId(article);
     doclignes.setARdesignation(article.getARdesignation());
     doclignes.setDLQte(qte);
     doclignes.setDLPrixVenteTTC(44);
          
     doclignes.setDLTotalTTC(454);
     doclignes.setDLMargeUnitaire(454);
     doclignes.setDLMargeTotale(454);
     doclignes.setDLtauxtaxe(BigInteger.ZERO);
     doclignes.setDLtotaltaxe(2.5);
     doclignes.setDLDateModification(new Date());
     doclignes.setVue(1);
     doclignes.setUtilisateur(Session.renvoirSession().toString());
     doclignes.setDepot(de.getDpId().getDpId());
        try{
            docligneFacade.create(doclignes);
          FacesMessage message = new FacesMessage( "document crée" );
         FacesContext.getCurrentInstance().addMessage( null, message);
        }catch(Exception e){
       }
        disable=false;
        tmp=null;
        designation=null;
        prix_achat=0;
        qte=0;
     }
     return null;
     
 }
    public String getNomCpt() {
        return nomCpt;
    }

    public void setNomCpt(String nomCpt) {
        this.nomCpt = nomCpt;
    }

    public String getNomtier() {
        return nomtier;
    }

    public void setNomtier(String nomtier) {
        this.nomtier = nomtier;
    }

    public Tiers getTiers() {
        return tiers;
    }

    public void setTiers(Tiers tiers) {
        this.tiers = tiers;
    }

    public String getNomcol() {
        return nomcol;
    }

    public void setNomcol(String nomcol) {
        this.nomcol = nomcol;
    }

    public Collaborateur getColaborateur() {
        return colaborateur;
    }

    public void setColaborateur(Collaborateur colaborateur) {
        this.colaborateur = colaborateur;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
     public void  param_modif_docentete(){
      docentete = (Docentete) docenteteFacade.find(param_docentete);
      modif_collaborateur= docentete.getCoId();
      modif_depot = docentete.getDpId();
      modif_journal = docentete.getCjId();
      modift_tiers = docentete.getTrId();
      modif_ref = docentete.getDeRef();
      docentete.getDocligneList();
    }
//     public void  param_modif_docligne(){
//      docligne =  docligneFacade.find(param_modif_doc_ligne);
//      modif_qte= docligne.getDLQte();
//    }
     public String modifier_documents(){ 
        docentete.setVue(1);
        for(int a=0; a<listeCodejournal.size();a++){
            if ((listeCodejournal.get(a).getCJlibelle().equals(modif_journal))){
                docentete.setCjId(listeCodejournal.get(a));                
                break;
            }
        }
        
        for(int a=0; a<listDepot.size(); a++){
            if ((listDepot.get(a).getDpId().equals(modif_depot))){
                docentete.setDpId(listDepot.get(a));                
                break;
            }
        }
        
        for(int i=0; i<listeCollaborateur.size();i++){
            if ((listeCollaborateur.get(i).getCOcode().equals(modif_collaborateur))){
                docentete.setCoId(listeCollaborateur.get(i));                
                break;
            }
        }
        for(int i=0; i<listetiers.size();i++){
            if ((listetiers.get(i).getTrId().equals(modift_tiers))){
                docentete.setTrId(listetiers.get(i));                
                break;
            }
        }
        docentete.setDeRef(modif_ref);
        docenteteFacade.edit(docentete);
        return "caisse.xhtml?faces-redirect=true";
    }

     public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
     
     
    public Date getDatedoc() {
        return datedoc;
    }

    public void setDatedoc(Date datedoc) {
        this.datedoc = datedoc;
    }
    public Docligne  param_modif_docligne(int param){
//      String a = Integer.toString(param);
//      Logger logger = Logger.getLogger(a);
      docligne =  docligneFacade.find(param);
      modif_qte = docligne.getDLQte();
      modif_privente = docligne.getDLPrixVenteTTC();
      return docligne;
    }
    
     public void  modif_docligne(){
      docligne.setDLQte(modif_qte);
     docligne.setDLPrixVenteTTC(modif_privente);
     docligneFacade.edit(docligne);
     FacesMessage message = new FacesMessage( "modification effectuée" );
     FacesContext.getCurrentInstance().addMessage( null, message);
    }
     public String suppressiondocLigne(int id) { 
         Docentete de = docenteteFacade.find(id);
         de.setVue(2);
         docenteteFacade.edit(de);
         return null;
    }
     private String selectedClient;

    public String getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(String selectedClient) {
        this.selectedClient = selectedClient;
    }
     
     public List<String> complete(String query) {  
        List<String> results = new ArrayList<>();  
        for (int i = 0; i < 10; i++) {  
            results.add(query + i);  
        }  
        return results;  
    }
    
    }