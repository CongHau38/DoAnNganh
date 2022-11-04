/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dan.pojos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "nguoidung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nguoidung.findAll", query = "SELECT n FROM Nguoidung n"),
    @NamedQuery(name = "Nguoidung.findByHo", query = "SELECT n FROM Nguoidung n WHERE n.ho = :ho"),
    @NamedQuery(name = "Nguoidung.findByTen", query = "SELECT n FROM Nguoidung n WHERE n.ten = :ten"),
    @NamedQuery(name = "Nguoidung.findByGioiTinh", query = "SELECT n FROM Nguoidung n WHERE n.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "Nguoidung.findByEmail", query = "SELECT n FROM Nguoidung n WHERE n.email = :email"),
    @NamedQuery(name = "Nguoidung.findByDiaChi", query = "SELECT n FROM Nguoidung n WHERE n.diaChi = :diaChi"),
    @NamedQuery(name = "Nguoidung.findByMaND", query = "SELECT n FROM Nguoidung n WHERE n.maND = :maND")})
public class Nguoidung implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "ho")
    private String ho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ten")
    private String ten;
    @Size(max = 3)
    @Column(name = "gioiTinh")
    private String gioiTinh;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "diaChi")
    private String diaChi;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maND")
    private Integer maND;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maND")
    private Collection<Binhluan> binhluanCollection;
    @OneToMany(mappedBy = "maND")
    private Collection<Hoadon> hoadonCollection;
    @JoinColumn(name = "soDienThoai", referencedColumnName = "soDienThoai")
    @OneToOne(optional = false)
    private Taikhoan soDienThoai;

    public Nguoidung() {
    }

    public Nguoidung(Integer maND) {
        this.maND = maND;
    }

    public Nguoidung(Integer maND, String ten) {
        this.maND = maND;
        this.ten = ten;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getMaND() {
        return maND;
    }

    public void setMaND(Integer maND) {
        this.maND = maND;
    }

    @XmlTransient
    public Collection<Binhluan> getBinhluanCollection() {
        return binhluanCollection;
    }

    public void setBinhluanCollection(Collection<Binhluan> binhluanCollection) {
        this.binhluanCollection = binhluanCollection;
    }

    @XmlTransient
    public Collection<Hoadon> getHoadonCollection() {
        return hoadonCollection;
    }

    public void setHoadonCollection(Collection<Hoadon> hoadonCollection) {
        this.hoadonCollection = hoadonCollection;
    }

    public Taikhoan getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(Taikhoan soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maND != null ? maND.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nguoidung)) {
            return false;
        }
        Nguoidung other = (Nguoidung) object;
        if ((this.maND == null && other.maND != null) || (this.maND != null && !this.maND.equals(other.maND))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dan.pojos.Nguoidung[ maND=" + maND + " ]";
    }
    
}
