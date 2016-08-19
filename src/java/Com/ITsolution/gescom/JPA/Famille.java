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
@Table(name = "FAMILLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Famille.findAll", query = "SELECT f FROM Famille f"),
    @NamedQuery(name = "Famille.findByFaId", query = "SELECT f FROM Famille f WHERE f.faId = :faId"),
    @NamedQuery(name = "Famille.findByFACodeFamille", query = "SELECT f FROM Famille f WHERE f.fACodeFamille = :fACodeFamille"),
    @NamedQuery(name = "Famille.findByFADesignation", query = "SELECT f FROM Famille f WHERE f.fADesignation = :fADesignation"),
    @NamedQuery(name = "Famille.findByUtilisateur", query = "SELECT f FROM Famille f WHERE f.utilisateur = :utilisateur"),
    @NamedQuery(name = "Famille.findByVue", query = "SELECT f FROM Famille f WHERE f.vue = :vue"),
    @NamedQuery(name = "Famille.findByCleAg", query = "SELECT f FROM Famille f WHERE f.cleAg = :cleAg")})
public class Famille implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer faId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FA_CodeFamille")
    private String fACodeFamille;
    @Size(max = 50)
    @Column(name = "FA_Designation")
    private String fADesignation;
    @Size(max = 50)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Column(name = "vue")
    private Integer vue;
    @Column(name = "cle_ag")
    private Integer cleAg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faId", fetch = FetchType.EAGER)
    private List<Comptgeneral> comptgeneralList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faId", fetch = FetchType.EAGER)
    private List<Article> articleList;

    public Famille() {
    }

    public Famille(Integer faId) {
        this.faId = faId;
    }

    public Famille(Integer faId, String fACodeFamille) {
        this.faId = faId;
        this.fACodeFamille = fACodeFamille;
    }

    public Integer getFaId() {
        return faId;
    }

    public void setFaId(Integer faId) {
        this.faId = faId;
    }

    public String getFACodeFamille() {
        return fACodeFamille;
    }

    public void setFACodeFamille(String fACodeFamille) {
        this.fACodeFamille = fACodeFamille;
    }

    public String getFADesignation() {
        return fADesignation;
    }

    public void setFADesignation(String fADesignation) {
        this.fADesignation = fADesignation;
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
    public List<Comptgeneral> getComptgeneralList() {
        return comptgeneralList;
    }

    public void setComptgeneralList(List<Comptgeneral> comptgeneralList) {
        this.comptgeneralList = comptgeneralList;
    }

    @XmlTransient
    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faId != null ? faId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Famille)) {
            return false;
        }
        Famille other = (Famille) object;
        if ((this.faId == null && other.faId != null) || (this.faId != null && !this.faId.equals(other.faId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fADesignation;
    }
    
}
