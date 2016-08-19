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
@Table(name = "CAISSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caisse.findAll", query = "SELECT c FROM Caisse c"),
    @NamedQuery(name = "Caisse.findByCaId", query = "SELECT c FROM Caisse c WHERE c.caId = :caId"),
    @NamedQuery(name = "Caisse.findByCAlibelle", query = "SELECT c FROM Caisse c WHERE c.cAlibelle = :cAlibelle"),
    @NamedQuery(name = "Caisse.findByUtilisateur", query = "SELECT c FROM Caisse c WHERE c.utilisateur = :utilisateur"),
    @NamedQuery(name = "Caisse.findByVue", query = "SELECT c FROM Caisse c WHERE c.vue = :vue")})
public class Caisse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer caId;
    @Size(max = 50)
    @Column(name = "CA_libelle")
    private String cAlibelle;
    @Size(max = 50)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Column(name = "vue")
    private Integer vue;
    @JoinColumn(name = "AG_ID", referencedColumnName = "AG_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Agence agId;
    @JoinColumn(name = "CJ_ID", referencedColumnName = "CJ_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Codejournal cjId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caId", fetch = FetchType.EAGER)
    private List<Reglement> reglementList;

    public Caisse() {
    }

    public Caisse(Integer caId) {
        this.caId = caId;
    }

    public Integer getCaId() {
        return caId;
    }

    public void setCaId(Integer caId) {
        this.caId = caId;
    }

    public String getCAlibelle() {
        return cAlibelle;
    }

    public void setCAlibelle(String cAlibelle) {
        this.cAlibelle = cAlibelle;
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

    public Agence getAgId() {
        return agId;
    }

    public void setAgId(Agence agId) {
        this.agId = agId;
    }

    public Codejournal getCjId() {
        return cjId;
    }

    public void setCjId(Codejournal cjId) {
        this.cjId = cjId;
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
        hash += (caId != null ? caId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caisse)) {
            return false;
        }
        Caisse other = (Caisse) object;
        if ((this.caId == null && other.caId != null) || (this.caId != null && !this.caId.equals(other.caId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cAlibelle;
    }
    
}
