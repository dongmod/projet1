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
@Table(name = "CATCOMPTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catcompta.findAll", query = "SELECT c FROM Catcompta c"),
    @NamedQuery(name = "Catcompta.findByCcId", query = "SELECT c FROM Catcompta c WHERE c.ccId = :ccId"),
    @NamedQuery(name = "Catcompta.findByCClibelle", query = "SELECT c FROM Catcompta c WHERE c.cClibelle = :cClibelle"),
    @NamedQuery(name = "Catcompta.findByUtilisateur", query = "SELECT c FROM Catcompta c WHERE c.utilisateur = :utilisateur"),
    @NamedQuery(name = "Catcompta.findByVue", query = "SELECT c FROM Catcompta c WHERE c.vue = :vue")})
public class Catcompta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CC_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ccId;
    @Size(max = 50)
    @Column(name = "CC_libelle")
    private String cClibelle;
    @Size(max = 50)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Column(name = "vue")
    private Integer vue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ccId", fetch = FetchType.EAGER)
    private List<TaxeCategorie> taxeCategorieList;

    public Catcompta() {
    }

    public Catcompta(Integer ccId) {
        this.ccId = ccId;
    }

    public Integer getCcId() {
        return ccId;
    }

    public void setCcId(Integer ccId) {
        this.ccId = ccId;
    }

    public String getCClibelle() {
        return cClibelle;
    }

    public void setCClibelle(String cClibelle) {
        this.cClibelle = cClibelle;
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

    @XmlTransient
    public List<TaxeCategorie> getTaxeCategorieList() {
        return taxeCategorieList;
    }

    public void setTaxeCategorieList(List<TaxeCategorie> taxeCategorieList) {
        this.taxeCategorieList = taxeCategorieList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccId != null ? ccId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catcompta)) {
            return false;
        }
        Catcompta other = (Catcompta) object;
        if ((this.ccId == null && other.ccId != null) || (this.ccId != null && !this.ccId.equals(other.ccId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cClibelle;
    }
    
}
