/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResPwAEntities;

import java.io.Serializable;
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
    @NamedQuery(name = "Cuidador.findAll", query = "SELECT c FROM Cuidador c")
    , @NamedQuery(name = "Cuidador.findByNombreusuario", query = "SELECT c FROM Cuidador c WHERE c.nombreusuario = :nombreusuario")
    , @NamedQuery(name = "Cuidador.findByContrase\u00f1a", query = "SELECT c FROM Cuidador c WHERE c.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "Cuidador.findByNombre", query = "SELECT c FROM Cuidador c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cuidador.findByCorreo", query = "SELECT c FROM Cuidador c WHERE c.correo = :correo")
    , @NamedQuery(name = "Cuidador.findByCelular", query = "SELECT c FROM Cuidador c WHERE c.celular = :celular")})
public class Cuidador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String nombreusuario;
    @Column(length = 2147483647)
    private String contrasena;
    @Column(length = 2147483647)
    private String nombre;
    @Column(length = 2147483647)
    private String correo;
    @Column(length = 2147483647)
    private String celular;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuidadorNombreusuario")
    private List<Perfilpwa> perfilpwaList;

    public Cuidador() {
    }

    public Cuidador(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @XmlTransient
    public List<Perfilpwa> getPerfilpwaList() {
        return perfilpwaList;
    }

    public void setPerfilpwaList(List<Perfilpwa> perfilpwaList) {
        this.perfilpwaList = perfilpwaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreusuario != null ? nombreusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuidador)) {
            return false;
        }
        Cuidador other = (Cuidador) object;
        if ((this.nombreusuario == null && other.nombreusuario != null) || (this.nombreusuario != null && !this.nombreusuario.equals(other.nombreusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ResPwAEntities.Cuidador[ nombreusuario=" + nombreusuario + " ]";
    }

}
