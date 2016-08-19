/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.ITsolution.gescom.JPA;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dongmo
 */
@Entity
@Table(name = "AGENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agence.findAll", query = "SELECT a FROM Agence a"),
    @NamedQuery(name = "Agence.findByAgId", query = "SELECT a FROM Agence a WHERE a.agId = :agId"),
    @NamedQuery(name = "Agence.findByAGcode", query = "SELECT a FROM Agence a WHERE a.aGcode = :aGcode"),
    @NamedQuery(name = "Agence.findByAGnom", query = "SELECT a FROM Agence a WHERE a.aGnom = :aGnom"),
    @NamedQuery(name = "Agence.findByAGdatecreation", query = "SELECT a FROM Agence a WHERE a.aGdatecreation = :aGdatecreation"),
    @NamedQuery(name = "Agence.findByUtilisateur", query = "SELECT a FROM Agence a WHERE a.utilisateur = :utilisateur"),
    @NamedQuery(name = "Agence.findByVue", query = "SELECT a FROM Agence a WHERE a.vue = :vue")})
public class Agence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AG_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer agId;
    @Size(max = 50)
    @Column(name = "AG_code")
    private String aGcode;
    @Size(max = 50)
    @Column(name = "AG_nom")
    private String aGnom;
    @Column(name = "AG_date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aGdatecreation;
    @Size(max = 50)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Column(name = "vue")
    private Integer vue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agId", fetch = FetchType.EAGER)
    private List<Depot> depotList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agId", fetch = FetchType.EAGER)
    private List<Collaborateur> collaborateurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agId", fetch = FetchType.EAGER)
    private List<Caisse> caisseList;
    @OneToMany(mappedBy = "agId", fetch = FetchType.EAGER)
    private List<Utilisateur> utilisateurList;

    public Agence() {
    }

    public Agence(Integer agId) {
        this.agId = agId;
    }

    public Integer getAgId() {
        return agId;
    }

    public void setAgId(Integer agId) {
        this.agId = agId;
    }

    public String getAGcode() {
        return aGcode;
    }

    public void setAGcode(String aGcode) {
        this.aGcode = aGcode;
    }

    public String getAGnom() {
        return aGnom;
    }

    public void setAGnom(String aGnom) {
        this.aGnom = aGnom;
    }

    public Date getAGdatecreation() {
        return aGdatecreation;
    }

    public void setAGdatecreation(Date aGdatecreation) {
        this.aGdatecreation = aGdatecreation;
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
    public List<Depot> getDepotList() {
        return depotList;
    }

    public void setDepotList(List<Depot> depotList) {
        this.depotList = depotList;
    }

    @XmlTransient
    public List<Collaborateur> getCollaborateurList() {
        return collaborateurList;
    }

    public void setCollaborateurList(List<Collaborateur> collaborateurList) {
        this.collaborateurList = collaborateurList;
    }

    @XmlTransient
    public List<Caisse> getCaisseList() {
        return caisseList;
    }

    public void setCaisseList(List<Caisse> caisseList) {
        this.caisseList = caisseList;
    }

    @XmlTransient
    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agId != null ? agId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agence)) {
            return false;
        }
        Agence other = (Agence) object;
        if ((this.agId == null && other.agId != null) || (this.agId != null && !this.agId.equals(other.agId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return aGnom;
    }
    
}
