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
@Table(name = "COLLABORATEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collaborateur.findAll", query = "SELECT c FROM Collaborateur c"),
    @NamedQuery(name = "Collaborateur.findByCoId", query = "SELECT c FROM Collaborateur c WHERE c.coId = :coId"),
    @NamedQuery(name = "Collaborateur.findByCOcode", query = "SELECT c FROM Collaborateur c WHERE c.cOcode = :cOcode"),
    @NamedQuery(name = "Collaborateur.findByCOnom", query = "SELECT c FROM Collaborateur c WHERE c.cOnom = :cOnom"),
    @NamedQuery(name = "Collaborateur.findByCOtype", query = "SELECT c FROM Collaborateur c WHERE c.cOtype = :cOtype"),
    @NamedQuery(name = "Collaborateur.findByUtilisateur", query = "SELECT c FROM Collaborateur c WHERE c.utilisateur = :utilisateur"),
    @NamedQuery(name = "Collaborateur.findByVue", query = "SELECT c FROM Collaborateur c WHERE c.vue = :vue")})
public class Collaborateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer coId;
    @Size(max = 50)
    @Column(name = "CO_code")
    private String cOcode;
    @Size(max = 50)
    @Column(name = "CO_nom")
    private String cOnom;
    @Size(max = 50)
    @Column(name = "CO_type")
    private String cOtype;
    @Size(max = 50)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Column(name = "vue")
    private Integer vue;
    @JoinColumn(name = "AG_ID", referencedColumnName = "AG_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Agence agId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coId", fetch = FetchType.EAGER)
    private List<Docentete> docenteteList;

    public Collaborateur() {
    }

    public Collaborateur(Integer coId) {
        this.coId = coId;
    }

    public Integer getCoId() {
        return coId;
    }

    public void setCoId(Integer coId) {
        this.coId = coId;
    }

    public String getCOcode() {
        return cOcode;
    }

    public void setCOcode(String cOcode) {
        this.cOcode = cOcode;
    }

    public String getCOnom() {
        return cOnom;
    }

    public void setCOnom(String cOnom) {
        this.cOnom = cOnom;
    }

    public String getCOtype() {
        return cOtype;
    }

    public void setCOtype(String cOtype) {
        this.cOtype = cOtype;
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

    @XmlTransient
    public List<Docentete> getDocenteteList() {
        return docenteteList;
    }

    public void setDocenteteList(List<Docentete> docenteteList) {
        this.docenteteList = docenteteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coId != null ? coId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collaborateur)) {
            return false;
        }
        Collaborateur other = (Collaborateur) object;
        if ((this.coId == null && other.coId != null) || (this.coId != null && !this.coId.equals(other.coId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cOnom;
    }
    
}
