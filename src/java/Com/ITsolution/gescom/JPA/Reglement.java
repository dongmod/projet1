/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.JPA;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "REGLEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reglement.findAll", query = "SELECT r FROM Reglement r"),
    @NamedQuery(name = "Reglement.findByReId", query = "SELECT r FROM Reglement r WHERE r.reId = :reId"),
    @NamedQuery(name = "Reglement.findByREmode", query = "SELECT r FROM Reglement r WHERE r.rEmode = :rEmode"),
    @NamedQuery(name = "Reglement.findByREmontant", query = "SELECT r FROM Reglement r WHERE r.rEmontant = :rEmontant"),
    @NamedQuery(name = "Reglement.findByREdateRegl", query = "SELECT r FROM Reglement r WHERE r.rEdateRegl = :rEdateRegl"),
    @NamedQuery(name = "Reglement.findByCodejournal", query = "SELECT r FROM Reglement r WHERE r.codejournal = :codejournal"),
    @NamedQuery(name = "Reglement.findByUtilisateur", query = "SELECT r FROM Reglement r WHERE r.utilisateur = :utilisateur"),
    @NamedQuery(name = "Reglement.findByVue", query = "SELECT r FROM Reglement r WHERE r.vue = :vue")})
public class Reglement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reId;
    @Size(max = 50)
    @Column(name = "RE_mode")
    private String rEmode;
    @Column(name = "RE_montant")
    private Integer rEmontant;
    @Column(name = "RE_dateRegl")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rEdateRegl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Code_journal")
    private String codejournal;
    @Size(max = 50)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Column(name = "vue")
    private Integer vue;
    @JoinColumn(name = "CA_ID", referencedColumnName = "CA_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Caisse caId;
    @JoinColumn(name = "CG_ID", referencedColumnName = "CG_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Comptgeneral cgId;
    @JoinColumn(name = "DE_ID", referencedColumnName = "DE_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Docentete deId;
    @JoinColumn(name = "TR_ID", referencedColumnName = "TR_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tiers trId;

    public Reglement() {
    }

    public Reglement(Integer reId) {
        this.reId = reId;
    }

    public Reglement(Integer reId, String codejournal) {
        this.reId = reId;
        this.codejournal = codejournal;
    }

    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public String getREmode() {
        return rEmode;
    }

    public void setREmode(String rEmode) {
        this.rEmode = rEmode;
    }

    public Integer getREmontant() {
        return rEmontant;
    }

    public void setREmontant(Integer rEmontant) {
        this.rEmontant = rEmontant;
    }

    public Date getREdateRegl() {
        return rEdateRegl;
    }

    public void setREdateRegl(Date rEdateRegl) {
        this.rEdateRegl = rEdateRegl;
    }

    public String getCodejournal() {
        return codejournal;
    }

    public void setCodejournal(String codejournal) {
        this.codejournal = codejournal;
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

    public Caisse getCaId() {
        return caId;
    }

    public void setCaId(Caisse caId) {
        this.caId = caId;
    }

    public Comptgeneral getCgId() {
        return cgId;
    }

    public void setCgId(Comptgeneral cgId) {
        this.cgId = cgId;
    }

    public Docentete getDeId() {
        return deId;
    }

    public void setDeId(Docentete deId) {
        this.deId = deId;
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
        hash += (reId != null ? reId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reglement)) {
            return false;
        }
        Reglement other = (Reglement) object;
        if ((this.reId == null && other.reId != null) || (this.reId != null && !this.reId.equals(other.reId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Com.ITsolution.gescom.JPA.Reglement[ reId=" + reId + " ]";
    }
    
}
