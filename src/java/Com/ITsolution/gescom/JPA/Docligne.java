/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.JPA;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dongmo
 */
@Entity
@Table(name = "DOCLIGNE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docligne.findAll", query = "SELECT d FROM Docligne d"),
    @NamedQuery(name = "Docligne.findByDlId", query = "SELECT d FROM Docligne d WHERE d.dlId = :dlId"),
    @NamedQuery(name = "Docligne.findByARdesignation", query = "SELECT d FROM Docligne d WHERE d.aRdesignation = :aRdesignation"),
    @NamedQuery(name = "Docligne.findByDLDateModification", query = "SELECT d FROM Docligne d WHERE d.dLDateModification = :dLDateModification"),
    @NamedQuery(name = "Docligne.findByDLMargeTotale", query = "SELECT d FROM Docligne d WHERE d.dLMargeTotale = :dLMargeTotale"),
    @NamedQuery(name = "Docligne.findByDLMargeUnitaire", query = "SELECT d FROM Docligne d WHERE d.dLMargeUnitaire = :dLMargeUnitaire"),
    @NamedQuery(name = "Docligne.findByDLPrixVenteTTC", query = "SELECT d FROM Docligne d WHERE d.dLPrixVenteTTC = :dLPrixVenteTTC"),
    @NamedQuery(name = "Docligne.findByDLQte", query = "SELECT d FROM Docligne d WHERE d.dLQte = :dLQte"),
    @NamedQuery(name = "Docligne.findByDLTotalTTC", query = "SELECT d FROM Docligne d WHERE d.dLTotalTTC = :dLTotalTTC"),
    @NamedQuery(name = "Docligne.findByDLtauxtaxe", query = "SELECT d FROM Docligne d WHERE d.dLtauxtaxe = :dLtauxtaxe"),
    @NamedQuery(name = "Docligne.findByDLtotaltaxe", query = "SELECT d FROM Docligne d WHERE d.dLtotaltaxe = :dLtotaltaxe"),
    @NamedQuery(name = "Docligne.findByDepot", query = "SELECT d FROM Docligne d WHERE d.depot = :depot"),
    @NamedQuery(name = "Docligne.findByUtilisateur", query = "SELECT d FROM Docligne d WHERE d.utilisateur = :utilisateur"),
    @NamedQuery(name = "Docligne.findByVue", query = "SELECT d FROM Docligne d WHERE d.vue = :vue")})
    public class Docligne implements Serializable {
    private static final AtomicInteger ai = new AtomicInteger(2);

    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dlId;
    @Size(max = 255)
    @Column(name = "AR_designation")
    private String aRdesignation;
    @Column(name = "DL_DateModification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dLDateModification;
    @Column(name = "DL_MargeTotale")
    private Integer dLMargeTotale;
    @Column(name = "DL_MargeUnitaire")
    private Integer dLMargeUnitaire;
    @Column(name = "DL_PrixVenteTTC")
    private Integer dLPrixVenteTTC;
    @Column(name = "DL_Qte")
    private Integer dLQte;
    @Column(name = "DL_TotalTTC")
    private Integer dLTotalTTC;
    @Column(name = "DL_taux_taxe")
    private BigInteger dLtauxtaxe;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DL_total_taxe")
    private Double dLtotaltaxe;
    @Column(name = "depot")
    private Integer depot;
    @Size(max = 255)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Column(name = "vue")
    private Integer vue;
    @JoinColumn(name = "AR_ID", referencedColumnName = "AR_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Article arId;
    @JoinColumn(name = "DE_ID", referencedColumnName = "DE_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Docentete deId;

    public Docligne() {
    }

    public Docligne(Integer dlId) {
        this.dlId = dlId;
    }

    public Integer getDlId() {
        return dlId;
    }

    public void setDlId(Integer dlId) {
        this.dlId = dlId;
    }

    public String getARdesignation() {
        return aRdesignation;
    }

    public void setARdesignation(String aRdesignation) {
        this.aRdesignation = aRdesignation;
    }

    public Date getDLDateModification() {
        return dLDateModification;
    }

    public void setDLDateModification(Date dLDateModification) {
        this.dLDateModification = dLDateModification;
    }

    public Integer getDLMargeTotale() {
        return dLMargeTotale;
    }

    public void setDLMargeTotale(Integer dLMargeTotale) {
        this.dLMargeTotale = dLMargeTotale;
    }

    public Integer getDLMargeUnitaire() {
        return dLMargeUnitaire;
    }

    public void setDLMargeUnitaire(Integer dLMargeUnitaire) {
        this.dLMargeUnitaire = dLMargeUnitaire;
    }

    public Integer getDLPrixVenteTTC() {
        return dLPrixVenteTTC;
    }

    public void setDLPrixVenteTTC(Integer dLPrixVenteTTC) {
        this.dLPrixVenteTTC = dLPrixVenteTTC;
    }

    public Integer getDLQte() {
        return dLQte;
    }

    public void setDLQte(Integer dLQte) {
        this.dLQte = dLQte;
    }

    public Integer getDLTotalTTC() {
        return dLTotalTTC;
    }

    public void setDLTotalTTC(Integer dLTotalTTC) {
        this.dLTotalTTC = dLTotalTTC;
    }

    public BigInteger getDLtauxtaxe() {
        return dLtauxtaxe;
    }

    public void setDLtauxtaxe(BigInteger dLtauxtaxe) {
        this.dLtauxtaxe = dLtauxtaxe;
    }

    public Double getDLtotaltaxe() {
        return dLtotaltaxe;
    }

    public void setDLtotaltaxe(Double dLtotaltaxe) {
        this.dLtotaltaxe = dLtotaltaxe;
    }

    public Integer getDepot() {
        return depot;
    }

    public void setDepot(Integer depot) {
        this.depot = depot;
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

    public Docentete getDeId() {
        return deId;
    }

    public void setDeId(Docentete deId) {
        this.deId = deId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dlId != null ? dlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docligne)) {
            return false;
        }
        Docligne other = (Docligne) object;
        if ((this.dlId == null && other.dlId != null) || (this.dlId != null && !this.dlId.equals(other.dlId))) {
            return false;
        }
        return true;
    }
@PrePersist
    public void setId(){
        
        this.dlId = ai.getAndIncrement();
    }
    @Override
    public String toString() {
        return "Com.ITsolution.gescom.JPA.Docligne[ dlId=" + dlId + " ]";
    }
    
}
