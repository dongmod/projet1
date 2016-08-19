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
@Table(name = "CODEJOURNAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Codejournal.findAll", query = "SELECT c FROM Codejournal c"),
    @NamedQuery(name = "Codejournal.findByCjId", query = "SELECT c FROM Codejournal c WHERE c.cjId = :cjId"),
    @NamedQuery(name = "Codejournal.findByCJlibelle", query = "SELECT c FROM Codejournal c WHERE c.cJlibelle = :cJlibelle"),
    @NamedQuery(name = "Codejournal.findByCJtype", query = "SELECT c FROM Codejournal c WHERE c.cJtype = :cJtype"),
    @NamedQuery(name = "Codejournal.findByCJcompteTR", query = "SELECT c FROM Codejournal c WHERE c.cJcompteTR = :cJcompteTR"),
    @NamedQuery(name = "Codejournal.findByUtilisateur", query = "SELECT c FROM Codejournal c WHERE c.utilisateur = :utilisateur"),
    @NamedQuery(name = "Codejournal.findByVue", query = "SELECT c FROM Codejournal c WHERE c.vue = :vue"),
    @NamedQuery(name = "Codejournal.findByCleAg", query = "SELECT c FROM Codejournal c WHERE c.cleAg = :cleAg")})
public class Codejournal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CJ_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cjId;
    @Size(max = 50)
    @Column(name = "CJ_libelle")
    private String cJlibelle;
    @Size(max = 50)
    @Column(name = "CJ_type")
    private String cJtype;
    @Size(max = 50)
    @Column(name = "CJ_compteTR")
    private String cJcompteTR;
    @Size(max = 50)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Column(name = "vue")
    private Integer vue;
    @Column(name = "cle_ag")
    private Integer cleAg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cjId", fetch = FetchType.EAGER)
    private List<Caisse> caisseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cjId", fetch = FetchType.EAGER)
    private List<Comptgeneral> comptgeneralList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cjId", fetch = FetchType.EAGER)
    private List<Docentete> docenteteList;

    public Codejournal() {
    }

    public Codejournal(Integer cjId) {
        this.cjId = cjId;
    }

    public Integer getCjId() {
        return cjId;
    }

    public void setCjId(Integer cjId) {
        this.cjId = cjId;
    }

    public String getCJlibelle() {
        return cJlibelle;
    }

    public void setCJlibelle(String cJlibelle) {
        this.cJlibelle = cJlibelle;
    }

    public String getCJtype() {
        return cJtype;
    }

    public void setCJtype(String cJtype) {
        this.cJtype = cJtype;
    }

    public String getCJcompteTR() {
        return cJcompteTR;
    }

    public void setCJcompteTR(String cJcompteTR) {
        this.cJcompteTR = cJcompteTR;
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

    public Integer getCleAg() {
        return cleAg;
    }

    public void setCleAg(Integer cleAg) {
        this.cleAg = cleAg;
    }

    @XmlTransient
    public List<Caisse> getCaisseList() {
        return caisseList;
    }

    public void setCaisseList(List<Caisse> caisseList) {
        this.caisseList = caisseList;
    }

    @XmlTransient
    public List<Comptgeneral> getComptgeneralList() {
        return comptgeneralList;
    }

    public void setComptgeneralList(List<Comptgeneral> comptgeneralList) {
        this.comptgeneralList = comptgeneralList;
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
        hash += (cjId != null ? cjId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codejournal)) {
            return false;
        }
        Codejournal other = (Codejournal) object;
        if ((this.cjId == null && other.cjId != null) || (this.cjId != null && !this.cjId.equals(other.cjId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cJlibelle;
    }
    
}
