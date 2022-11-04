/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dan.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "hoadon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoadon.findAll", query = "SELECT h FROM Hoadon h"),
    @NamedQuery(name = "Hoadon.findByMaHoaDon", query = "SELECT h FROM Hoadon h WHERE h.maHoaDon = :maHoaDon"),
    @NamedQuery(name = "Hoadon.findByNgaylap", query = "SELECT h FROM Hoadon h WHERE h.ngaylap = :ngaylap"),
    @NamedQuery(name = "Hoadon.findByMaNV", query = "SELECT h FROM Hoadon h WHERE h.maNV = :maNV"),
    @NamedQuery(name = "Hoadon.findByTongTien", query = "SELECT h FROM Hoadon h WHERE h.tongTien = :tongTien"),
    @NamedQuery(name = "Hoadon.findByTongSanpham", query = "SELECT h FROM Hoadon h WHERE h.tongSanpham = :tongSanpham")})
public class Hoadon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maHoaDon")
    private Integer maHoaDon;
    @Column(name = "ngaylap")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaylap;
    @Column(name = "maNV")
    private Integer maNV;
    @Column(name = "tongTien")
    private Long tongTien;
    @Column(name = "tongSanpham")
    private Integer tongSanpham;
    @JoinColumn(name = "maND", referencedColumnName = "maND")
    @ManyToOne
    private Nguoidung maND;

    public Hoadon() {
    }

    public Hoadon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Integer getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }

    public Integer getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public Long getTongTien() {
        return tongTien;
    }

    public void setTongTien(Long tongTien) {
        this.tongTien = tongTien;
    }

    public Integer getTongSanpham() {
        return tongSanpham;
    }

    public void setTongSanpham(Integer tongSanpham) {
        this.tongSanpham = tongSanpham;
    }

    public Nguoidung getMaND() {
        return maND;
    }

    public void setMaND(Nguoidung maND) {
        this.maND = maND;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHoaDon != null ? maHoaDon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hoadon)) {
            return false;
        }
        Hoadon other = (Hoadon) object;
        if ((this.maHoaDon == null && other.maHoaDon != null) || (this.maHoaDon != null && !this.maHoaDon.equals(other.maHoaDon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dan.pojos.Hoadon[ maHoaDon=" + maHoaDon + " ]";
    }
    
}
