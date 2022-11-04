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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "banh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banh.findAll", query = "SELECT b FROM Banh b"),
    @NamedQuery(name = "Banh.findByIdBanh", query = "SELECT b FROM Banh b WHERE b.idBanh = :idBanh"),
    @NamedQuery(name = "Banh.findByTenBanh", query = "SELECT b FROM Banh b WHERE b.tenBanh = :tenBanh"),
    @NamedQuery(name = "Banh.findByMoTa", query = "SELECT b FROM Banh b WHERE b.moTa = :moTa"),
    @NamedQuery(name = "Banh.findBySoLuong", query = "SELECT b FROM Banh b WHERE b.soLuong = :soLuong"),
    @NamedQuery(name = "Banh.findByDonGia", query = "SELECT b FROM Banh b WHERE b.donGia = :donGia"),
    @NamedQuery(name = "Banh.findByAnh", query = "SELECT b FROM Banh b WHERE b.anh = :anh")})
public class Banh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBanh")
    private Integer idBanh;
    @Size(max = 100)
    @Column(name = "tenBanh")
    private String tenBanh;
    @Size(max = 255)
    @Column(name = "moTa")
    private String moTa;
    @Column(name = "soLuong")
    private Integer soLuong;
    @Column(name = "donGia")
    private Long donGia;
    @Size(max = 255)
    @Column(name = "anh")
    private String anh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBanh", fetch=FetchType.EAGER)
    private Collection<Binhluan> binhluanCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "banh")
    private Collection<ChitietHoadon> chitietHoadonCollection;
    
    @Transient
    private MultipartFile file;

    public Banh() {
    }

    public Banh(Integer idBanh) {
        this.idBanh = idBanh;
    }

    public Integer getIdBanh() {
        return idBanh;
    }

    public void setIdBanh(Integer idBanh) {
        this.idBanh = idBanh;
    }

    public String getTenBanh() {
        return tenBanh;
    }

    public void setTenBanh(String tenBanh) {
        this.tenBanh = tenBanh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Long getDonGia() {
        return donGia;
    }

    public void setDonGia(Long donGia) {
        this.donGia = donGia;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    @XmlTransient
    public Collection<Binhluan> getBinhluanCollection() {
        return binhluanCollection;
    }

    public void setBinhluanCollection(Collection<Binhluan> binhluanCollection) {
        this.binhluanCollection = binhluanCollection;
    }

    @XmlTransient
    public Collection<ChitietHoadon> getChitietHoadonCollection() {
        return chitietHoadonCollection;
    }

    public void setChitietHoadonCollection(Collection<ChitietHoadon> chitietHoadonCollection) {
        this.chitietHoadonCollection = chitietHoadonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBanh != null ? idBanh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banh)) {
            return false;
        }
        Banh other = (Banh) object;
        if ((this.idBanh == null && other.idBanh != null) || (this.idBanh != null && !this.idBanh.equals(other.idBanh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dan.pojos.Banh[ idBanh=" + idBanh + " ]";
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
