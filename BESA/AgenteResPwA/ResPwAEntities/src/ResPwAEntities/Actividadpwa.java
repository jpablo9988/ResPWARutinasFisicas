/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResPwAEntities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 57305
 */
@Entity
@Table(catalog = "Res-pwaDB", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividadpwa.findAll", query = "SELECT a FROM Actividadpwa a")
    , @NamedQuery(name = "Actividadpwa.findById", query = "SELECT a FROM Actividadpwa a WHERE a.id = :id")
    , @NamedQuery(name = "Actividadpwa.findByNombre", query = "SELECT a FROM Actividadpwa a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Actividadpwa.findByTipo", query = "SELECT a FROM Actividadpwa a WHERE a.tipo = :tipo")
    , @NamedQuery(name = "Actividadpwa.findByDuracion", query = "SELECT a FROM Actividadpwa a WHERE a.duracion = :duracion")})
public class Actividadpwa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 2147483647)
    private String nombre;
    @Column(length = 2147483647)
    private String tipo;
    private BigInteger duracion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadpwaId2")
    private List<Actxpreferencia> actxpreferenciaList;

    public Actividadpwa() {
    }

    public Actividadpwa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigInteger getDuracion() {
        return duracion;
    }

    public void setDuracion(BigInteger duracion) {
        this.duracion = duracion;
    }

    @XmlTransient
    public List<Actxpreferencia> getActxpreferenciaList() {
        return actxpreferenciaList;
    }

    public void setActxpreferenciaList(List<Actxpreferencia> actxpreferenciaList) {
        this.actxpreferenciaList = actxpreferenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividadpwa)) {
            return false;
        }
        Actividadpwa other = (Actividadpwa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ResPwAEntities.Actividadpwa[ id=" + id + " ]";
    }

    public Object getRegistroactividadList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
