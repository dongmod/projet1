/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.JPA;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TAXE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taxe.findAll", query = "SELECT t FROM Taxe t"),
    @NamedQuery(name = "Taxe.findByTaId", query = "SELECT t FROM Taxe t WHERE t.taId = :taId"),
    @NamedQuery(name = "Taxe.findByTAlibelle", query = "SELECT t FROM Taxe t WHERE t.tAlibelle = :tAlibelle"),
    @NamedQuery(name = "Taxe.findByTAtype", query = "SELECT t FROM Taxe t WHERE t.tAtype = :tAtype"),
    @NamedQuery(name = "Taxe.findByTAtaux", query = "SELECT t FROM Taxe t WHERE t.tAtaux = :tAtaux"),
    @NamedQuery(name = "Taxe.findByUtilisateur", query = "SELECT t FROM Taxe t WHERE t.utilisateur = :utilisateur"),
    @NamedQuery(name = "Taxe.findByVue", query = "SELECT t FROM Taxe t WHERE t.vue = :vue")})
public class Taxe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taId;
    @Size(max = 50)
    @Column(name = "TA_libelle")
    private String tAlibelle;
    @Size(max = 50)
    @Column(name = "TA_type")
    private String tAtype;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TA_taux")
    private BigDecimal tAtaux;
    @Size(max = 50)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Size(max = 10)
    @Column(name = "vue")
    private String vue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taId", fetch = FetchType.EAGER)
    private List<TaxeCategorie> taxeCategorieList;

    public Taxe() {
    }

    public Taxe(Integer taId) {
        this.taId = taId;
    }

    public Integer getTaId() {
        return taId;
    }

    public void setTaId(Integer taId) {
        this.taId = taId;
    }

    public String getTAlibelle() {
        return tAlibelle;
    }

    public void setTAlibelle(String tAlibelle) {
        this.tAlibelle = tAlibelle;
    }

    public String getTAtype() {
        return tAtype;
    }

    public void setTAtype(String tAtype) {
        this.tAtype = tAtype;
    }

    public BigDecimal getTAtaux() {
        return tAtaux;
    }

    public void setTAtaux(BigDecimal tAtaux) {
        this.tAtaux = tAtaux;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getVue() {
        return vue;
    }

    public void setVue(String vue) {
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
        hash += (taId != null ? taId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxe)) {
            return false;
        }
        Taxe other = (Taxe) object;
        if ((this.taId == null && other.taId != null) || (this.taId != null && !this.taId.equals(other.taId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tAlibelle;
    }
    
}
