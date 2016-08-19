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
@Table(name = "TIER_ARTICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TierArticle.findAll", query = "SELECT t FROM TierArticle t"),
    @NamedQuery(name = "TierArticle.findByTaId", query = "SELECT t FROM TierArticle t WHERE t.taId = :taId"),
    @NamedQuery(name = "TierArticle.findByUtilisateur", query = "SELECT t FROM TierArticle t WHERE t.utilisateur = :utilisateur"),
    @NamedQuery(name = "TierArticle.findByVue", query = "SELECT t FROM TierArticle t WHERE t.vue = :vue")})
public class TierArticle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taId;
    @Size(max = 50)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Column(name = "vue")
    private Integer vue;
    @JoinColumn(name = "AR_ID", referencedColumnName = "AR_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Article arId;
    @JoinColumn(name = "TR_ID", referencedColumnName = "TR_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tiers trId;

    public TierArticle() {
    }

    public TierArticle(Integer taId) {
        this.taId = taId;
    }

    public Integer getTaId() {
        return taId;
    }

    public void setTaId(Integer taId) {
        this.taId = taId;
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

    public Tiers getTrId() {
        return trId;
    }

    public void setTrId(Tiers trId) {
        this.trId = trId;
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
        if (!(object instanceof TierArticle)) {
            return false;
        }
        TierArticle other = (TierArticle) object;
        if ((this.taId == null && other.taId != null) || (this.taId != null && !this.taId.equals(other.taId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return arId.toString();
    }
    
}
