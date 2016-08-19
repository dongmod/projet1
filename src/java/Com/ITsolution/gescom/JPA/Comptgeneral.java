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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "COMPTGENERAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comptgeneral.findAll", query = "SELECT c FROM Comptgeneral c"),
    @NamedQuery(name = "Comptgeneral.findByCgId", query = "SELECT c FROM Comptgeneral c WHERE c.cgId = :cgId"),
    @NamedQuery(name = "Comptgeneral.findByUtilisateur", query = "SELECT c FROM Comptgeneral c WHERE c.utilisateur = :utilisateur"),
    @NamedQuery(name = "Comptgeneral.findByVue", query = "SELECT c FROM Comptgeneral c WHERE c.vue = :vue"),
    @NamedQuery(name = "Comptgeneral.findByNumeroCPT", query = "SELECT c FROM Comptgeneral c WHERE c.numeroCPT = :numeroCPT"),
    @NamedQuery(name = "Comptgeneral.findByTierObligatoire", query = "SELECT c FROM Comptgeneral c WHERE c.tierObligatoire = :tierObligatoire"),
    @NamedQuery(name = "Comptgeneral.findByAnalytique", query = "SELECT c FROM Comptgeneral c WHERE c.analytique = :analytique"),
    @NamedQuery(name = "Comptgeneral.findByLettrageAutomatique", query = "SELECT c FROM Comptgeneral c WHERE c.lettrageAutomatique = :lettrageAutomatique"),
    @NamedQuery(name = "Comptgeneral.findByButget", query = "SELECT c FROM Comptgeneral c WHERE c.butget = :butget")})
public class Comptgeneral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CG_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cgId;
    @Size(max = 50)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Column(name = "vue")
    private Integer vue;
    @Size(max = 50)
    @Column(name = "NumeroCPT")
    private String numeroCPT;
    @Column(name = "tierObligatoire")
    private Boolean tierObligatoire;
    @Column(name = "analytique")
    private Boolean analytique;
    @Column(name = "lettrageAutomatique")
    private Boolean lettrageAutomatique;
    @Column(name = "butget")
    private Boolean butget;
    @JoinColumn(name = "CJ_ID", referencedColumnName = "CJ_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Codejournal cjId;
    @JoinColumn(name = "FA_ID", referencedColumnName = "FA_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Famille faId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cgId", fetch = FetchType.EAGER)
    private List<Reglement> reglementList;
    

    public Comptgeneral() {
    }

    public Comptgeneral(Integer cgId) {
        this.cgId = cgId;
    }

    public Integer getCgId() {
        return cgId;
    }

    public void setCgId(Integer cgId) {
        this.cgId = cgId;
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

    public String getNumeroCPT() {
        return numeroCPT;
    }

    public void setNumeroCPT(String numeroCPT) {
        this.numeroCPT = numeroCPT;
    }

    public Boolean getTierObligatoire() {
        return tierObligatoire;
    }

    public void setTierObligatoire(Boolean tierObligatoire) {
        this.tierObligatoire = tierObligatoire;
    }

    public Boolean getAnalytique() {
        return analytique;
    }

    public void setAnalytique(Boolean analytique) {
        this.analytique = analytique;
    }

    public Boolean getLettrageAutomatique() {
        return lettrageAutomatique;
    }

    public void setLettrageAutomatique(Boolean lettrageAutomatique) {
        this.lettrageAutomatique = lettrageAutomatique;
    }

    public Boolean getButget() {
        return butget;
    }

    public void setButget(Boolean butget) {
        this.butget = butget;
    }

    public Codejournal getCjId() {
        return cjId;
    }

    public void setCjId(Codejournal cjId) {
        this.cjId = cjId;
    }

    public Famille getFaId() {
        return faId;
    }

    public void setFaId(Famille faId) {
        this.faId = faId;
    }

    @XmlTransient
    public List<Reglement> getReglementList() {
        return reglementList;
    }

    public void setReglementList(List<Reglement> reglementList) {
        this.reglementList = reglementList;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cgId != null ? cgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comptgeneral)) {
            return false;
        }
        Comptgeneral other = (Comptgeneral) object;
        if ((this.cgId == null && other.cgId != null) || (this.cgId != null && !this.cgId.equals(other.cgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return utilisateur;
    }
    
}
