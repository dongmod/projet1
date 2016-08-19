/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.JPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dongmo
 */
@Entity
@Table(name = "TAXE_CATEGORIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaxeCategorie.findAll", query = "SELECT t FROM TaxeCategorie t"),
    @NamedQuery(name = "TaxeCategorie.findByTcId", query = "SELECT t FROM TaxeCategorie t WHERE t.tcId = :tcId"),
    @NamedQuery(name = "TaxeCategorie.findByUtilisateur", query = "SELECT t FROM TaxeCategorie t WHERE t.utilisateur = :utilisateur"),
    @NamedQuery(name = "TaxeCategorie.findByVue", query = "SELECT t FROM TaxeCategorie t WHERE t.vue = :vue")})
public class TaxeCategorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TC_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tcId;
    @Size(max = 50)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Size(max = 10)
    @Column(name = "vue")
    private String vue;
    @JoinColumn(name = "CC_ID", referencedColumnName = "CC_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Catcompta ccId;
    @JoinColumn(name = "TA_ID", referencedColumnName = "TA_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Taxe taId;

    public TaxeCategorie() {
    }

    public TaxeCategorie(Integer tcId) {
        this.tcId = tcId;
    }

    public Integer getTcId() {
        return tcId;
    }

    public void setTcId(Integer tcId) {
        this.tcId = tcId;
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

    public Catcompta getCcId() {
        return ccId;
    }

    public void setCcId(Catcompta ccId) {
        this.ccId = ccId;
    }

    public Taxe getTaId() {
        return taId;
    }

    public void setTaId(Taxe taId) {
        this.taId = taId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcId != null ? tcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxeCategorie)) {
            return false;
        }
        TaxeCategorie other = (TaxeCategorie) object;
        if ((this.tcId == null && other.tcId != null) || (this.tcId != null && !this.tcId.equals(other.tcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return utilisateur;
    }
    
}
