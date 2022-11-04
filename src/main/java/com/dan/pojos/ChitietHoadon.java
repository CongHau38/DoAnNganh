/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dan.pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "chitiet_hoadon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChitietHoadon.findAll", query = "SELECT c FROM ChitietHoadon c"),
    @NamedQuery(name = "ChitietHoadon.findByMaHoaDon", query = "SELECT c FROM ChitietHoadon c WHERE c.chitietHoadonPK.maHoaDon = :maHoaDon"),
    @NamedQuery(name = "ChitietHoadon.findByIdBanh", query = "SELECT c FROM ChitietHoadon c WHERE c.chitietHoadonPK.idBanh = :idBanh"),
    @NamedQuery(name = "ChitietHoadon.findBySoluong", query = "SELECT c FROM ChitietHoadon c WHERE c.soluong = :soluong")})
public class ChitietHoadon implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChitietHoadonPK chitietHoadonPK;
    @Column(name = "donGia")
    private Long donGia;
    @Column(name = "soluong")
    private Integer soluong;
    @JoinColumn(name = "idBanh", referencedColumnName = "idBanh", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Banh banh;
    @JoinColumn(name = "maHoaDon", referencedColumnName = "maHoaDon", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hoadon hoadon;

    public ChitietHoadon() {
    }

    public ChitietHoadon(ChitietHoadonPK chitietHoadonPK) {
        this.chitietHoadonPK = chitietHoadonPK;
    }

    public ChitietHoadon(int maHoaDon, int idBanh) {
        this.chitietHoadonPK = new ChitietHoadonPK(maHoaDon, idBanh);
    }

    public ChitietHoadonPK getChitietHoadonPK() {
        return chitietHoadonPK;
    }

    public void setChitietHoadonPK(ChitietHoadonPK chitietHoadonPK) {
        this.chitietHoadonPK = chitietHoadonPK;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Banh getBanh() {
        return banh;
    }

    public void setBanh(Banh banh) {
        this.banh = banh;
    }

    public Hoadon getHoadon() {
        return hoadon;
    }

    public void setHoadon(Hoadon hoadon) {
        this.hoadon = hoadon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chitietHoadonPK != null ? chitietHoadonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChitietHoadon)) {
            return false;
        }
        ChitietHoadon other = (ChitietHoadon) object;
        if ((this.chitietHoadonPK == null && other.chitietHoadonPK != null) || (this.chitietHoadonPK != null && !this.chitietHoadonPK.equals(other.chitietHoadonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dan.pojos.ChitietHoadon[ chitietHoadonPK=" + chitietHoadonPK + " ]";
    }


    public Long getDonGia() {
        return donGia;
    }

    public void setDonGia(Long donGia) {
        this.donGia = donGia;
    }
    
}
