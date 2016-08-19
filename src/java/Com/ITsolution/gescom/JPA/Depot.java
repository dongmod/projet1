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
@Table(name = "DEPOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Depot.findAll", query = "SELECT d FROM Depot d"),
    @NamedQuery(name = "Depot.findByDpId", query = "SELECT d FROM Depot d WHERE d.dpId = :dpId"),
    @NamedQuery(name = "Depot.findByDpNom", query = "SELECT d FROM Depot d WHERE d.dpNom = :dpNom"),
    @NamedQuery(name = "Depot.findByUtilisateur", query = "SELECT d FROM Depot d WHERE d.utilisateur = :utilisateur"),
    @NamedQuery(name = "Depot.findByVue", query = "SELECT d FROM Depot d WHERE d.vue = :vue")})
public class Depot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dpId;
    @Size(max = 50)
    @Column(name = "DP_NOM")
    private String dpNom;
    @Size(max = 50)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Column(name = "vue")
    private Integer vue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dpId", fetch = FetchType.EAGER)
    private List<Artstock> artstockList;
    @JoinColumn(name = "AG_ID", referencedColumnName = "AG_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Agence agId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dpId", fetch = FetchType.EAGER)
    private List<Docentete> docenteteList;

    public Depot() {
    }

    public Depot(Integer dpId) {
        this.dpId = dpId;
    }

    public Integer getDpId() {
        return dpId;
    }

    public void setDpId(Integer dpId) {
        this.dpId = dpId;
    }

    public String getDpNom() {
        return dpNom;
    }

    public void setDpNom(String dpNom) {
        this.dpNom = dpNom;
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
    public List<Artstock> getArtstockList() {
        return artstockList;
    }

    public void setArtstockList(List<Artstock> artstockList) {
        this.artstockList = artstockList;
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
        hash += (dpId != null ? dpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Depot)) {
            return false;
        }
        Depot other = (Depot) object;
        if ((this.dpId == null && other.dpId != null) || (this.dpId != null && !this.dpId.equals(other.dpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dpNom;
    }
    
}
