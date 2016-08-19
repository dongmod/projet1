/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.JPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dongmo
 */
@Entity
@Table(name = "TIERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiers.findAll", query = "SELECT t FROM Tiers t"),
    @NamedQuery(name = "Tiers.findByTrId", query = "SELECT t FROM Tiers t WHERE t.trId = :trId"),
    @NamedQuery(name = "Tiers.findByTRnom", query = "SELECT t FROM Tiers t WHERE t.tRnom = :tRnom"),
    @NamedQuery(name = "Tiers.findByTRville", query = "SELECT t FROM Tiers t WHERE t.tRville = :tRville"),
    @NamedQuery(name = "Tiers.findByTRadresse", query = "SELECT t FROM Tiers t WHERE t.tRadresse = :tRadresse"),
    @NamedQuery(name = "Tiers.findByTRtel", query = "SELECT t FROM Tiers t WHERE t.tRtel = :tRtel"),
    @NamedQuery(name = "Tiers.findByTRNcompteprincipale", query = "SELECT t FROM Tiers t WHERE t.tRNcompteprincipale = :tRNcompteprincipale"),
    @NamedQuery(name = "Tiers.findByTRtype", query = "SELECT t FROM Tiers t WHERE t.tRtype = :tRtype"),
    @NamedQuery(name = "Tiers.findByUtilisateur", query = "SELECT t FROM Tiers t WHERE t.utilisateur = :utilisateur"),
    @NamedQuery(name = "Tiers.findByVue", query = "SELECT t FROM Tiers t WHERE t.vue = :vue"),
    @NamedQuery(name = "Tiers.findByCleAg", query = "SELECT t FROM Tiers t WHERE t.cleAg = :cleAg")})
public class Tiers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trId;
    @Size(max = 50)
    @Column(name = "TR_nom")
    private String tRnom;
    @Size(max = 50)
    @Column(name = "TR_ville")
    private String tRville;
    @Size(max = 50)
    @Column(name = "TR_adresse")
    private String tRadresse;
    @Size(max = 50)
    @Column(name = "TR_tel")
    private String tRtel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TR_Ncompte_principale")
    private String tRNcompteprincipale;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TR_type")
    private String tRtype;
    @Size(max = 50)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Column(name = "vue")
    private Integer vue;
    @Column(name = "cle_ag")
    private Integer cleAg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trId", fetch = FetchType.EAGER)
    private List<TierArticle> tierArticleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trId", fetch = FetchType.EAGER)
    private List<Reglement> reglementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trId", fetch = FetchType.EAGER)
    private List<Docentete> docenteteList;

    public Tiers() {
    }

    public Tiers(Integer trId) {
        this.trId = trId;
    }

    public Tiers(Integer trId, String tRNcompteprincipale, String tRtype) {
        this.trId = trId;
        this.tRNcompteprincipale = tRNcompteprincipale;
        this.tRtype = tRtype;
    }

    public Integer getTrId() {
        return trId;
    }

    public void setTrId(Integer trId) {
        this.trId = trId;
    }

    public String getTRnom() {
        return tRnom;
    }

    public void setTRnom(String tRnom) {
        this.tRnom = tRnom;
    }

    public String getTRville() {
        return tRville;
    }

    public void setTRville(String tRville) {
        this.tRville = tRville;
    }

    public String getTRadresse() {
        return tRadresse;
    }

    public void setTRadresse(String tRadresse) {
        this.tRadresse = tRadresse;
    }

    public String getTRtel() {
        return tRtel;
    }

    public void setTRtel(String tRtel) {
        this.tRtel = tRtel;
    }

    public String getTRNcompteprincipale() {
        return tRNcompteprincipale;
    }

    public void setTRNcompteprincipale(String tRNcompteprincipale) {
        this.tRNcompteprincipale = tRNcompteprincipale;
    }

    public String getTRtype() {
        return tRtype;
    }

    public void setTRtype(String tRtype) {
        this.tRtype = tRtype;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Integer getVue() {
        return vue;
    }

    public void setVue(Integer vue) {
        this.vue = vue;
    }

    public Integer getCleAg() {
        return cleAg;
    }

    public void setCleAg(Integer cleAg) {
        this.cleAg = cleAg;
    }

    @XmlTransient
    public List<TierArticle> getTierArticleList() {
        return tierArticleList;
    }

    public void setTierArticleList(List<TierArticle> tierArticleList) {
        this.tierArticleList = tierArticleList;
    }

    @XmlTransient
    public List<Reglement> getReglementList() {
        return reglementList;
    }

    public void setReglementList(List<Reglement> reglementList) {
        this.reglementList = reglementList;
    }

    @XmlTransient
    public List<Docentete> getDocenteteList() {
        return docenteteList;
    }

    public void setDocenteteList(List<Docentete> docenteteList) {
        this.docenteteList = docenteteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trId != null ? trId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiers)) {
            return false;
        }
        Tiers other = (Tiers) object;
        if ((this.trId == null && other.trId != null) || (this.trId != null && !this.trId.equals(other.trId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tRnom;
    }
    
}
