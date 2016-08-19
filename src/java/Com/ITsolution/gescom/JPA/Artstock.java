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
@Table(name = "ARTSTOCK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artstock.findAll", query = "SELECT a FROM Artstock a"),
    @NamedQuery(name = "Artstock.findByAsId", query = "SELECT a FROM Artstock a WHERE a.asId = :asId"),
    @NamedQuery(name = "Artstock.findByASQteMin", query = "SELECT a FROM Artstock a WHERE a.aSQteMin = :aSQteMin"),
    @NamedQuery(name = "Artstock.findByASQteMax", query = "SELECT a FROM Artstock a WHERE a.aSQteMax = :aSQteMax"),
    @NamedQuery(name = "Artstock.findByASQteStock", query = "SELECT a FROM Artstock a WHERE a.aSQteStock = :aSQteStock"),
    @NamedQuery(name = "Artstock.findByCmup", query = "SELECT a FROM Artstock a WHERE a.cmup = :cmup"),
    @NamedQuery(name = "Artstock.findByASMonStock", query = "SELECT a FROM Artstock a WHERE a.aSMonStock = :aSMonStock"),
    @NamedQuery(name = "Artstock.findByAsMvt", query = "SELECT a FROM Artstock a WHERE a.asMvt = :asMvt"),
    @NamedQuery(name = "Artstock.findByUtilisateur", query = "SELECT a FROM Artstock a WHERE a.utilisateur = :utilisateur"),
    @NamedQuery(name = "Artstock.findByVue", query = "SELECT a FROM Artstock a WHERE a.vue = :vue")})
public class Artstock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer asId;
    @Column(name = "AS_QteMin")
    private Integer aSQteMin;
    @Column(name = "AS_QteMax")
    private Integer aSQteMax;
    @Column(name = "AS_QteStock")
    private Integer aSQteStock;
    @Column(name = "CMUP")
    private Integer cmup;
    @Column(name = "AS_MonStock")
    private Integer aSMonStock;
    @Column(name = "AS_MVT")
    private Integer asMvt;
    @Size(max = 50)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Column(name = "vue")
    private Integer vue;
    @JoinColumn(name = "AR_ID", referencedColumnName = "AR_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Article arId;
    @JoinColumn(name = "DP_ID", referencedColumnName = "DP_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Depot dpId;

    public Artstock() {
    }

    public Artstock(Integer asId) {
        this.asId = asId;
    }

    public Integer getAsId() {
        return asId;
    }

    public void setAsId(Integer asId) {
        this.asId = asId;
    }

    public Integer getASQteMin() {
        return aSQteMin;
    }

    public void setASQteMin(Integer aSQteMin) {
        this.aSQteMin = aSQteMin;
    }

    public Integer getASQteMax() {
        return aSQteMax;
    }

    public void setASQteMax(Integer aSQteMax) {
        this.aSQteMax = aSQteMax;
    }

    public Integer getASQteStock() {
        return aSQteStock;
    }

    public void setASQteStock(Integer aSQteStock) {
        this.aSQteStock = aSQteStock;
    }

    public Integer getCmup() {
        return cmup;
    }

    public void setCmup(Integer cmup) {
        this.cmup = cmup;
    }

    public Integer getASMonStock() {
        return aSMonStock;
    }

    public void setASMonStock(Integer aSMonStock) {
        this.aSMonStock = aSMonStock;
    }

    public Integer getAsMvt() {
        return asMvt;
    }

    public void setAsMvt(Integer asMvt) {
        this.asMvt = asMvt;
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

    public Article getArId() {
        return arId;
    }

    public void setArId(Article arId) {
        this.arId = arId;
    }

    public Depot getDpId() {
        return dpId;
    }

    public void setDpId(Depot dpId) {
        this.dpId = dpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asId != null ? asId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artstock)) {
            return false;
        }
        Artstock other = (Artstock) object;
        if ((this.asId == null && other.asId != null) || (this.asId != null && !this.asId.equals(other.asId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return aSQteStock.toString();
    }
    
}
