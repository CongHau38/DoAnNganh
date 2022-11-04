/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dan.pojos;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "binhluan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Binhluan.findAll", query = "SELECT b FROM Binhluan b"),
    @NamedQuery(name = "Binhluan.findByMaBL", query = "SELECT b FROM Binhluan b WHERE b.maBL = :maBL"),
    @NamedQuery(name = "Binhluan.findByNoiDung", query = "SELECT b FROM Binhluan b WHERE b.noiDung = :noiDung")})
public class Binhluan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maBL")
    private Integer maBL;
    @Size(max = 255)
    @Column(name = "noiDung")
    private String noiDung;
    @JoinColumn(name = "idBanh", referencedColumnName = "idBanh")
    @ManyToOne(optional = false)
    private Banh idBanh;
    @JoinColumn(name = "maND", referencedColumnName = "maND")
    @ManyToOne(optional = false)
    private Nguoidung maND;

    public Binhluan() {
    }

    public Binhluan(Integer maBL) {
        this.maBL = maBL;
    }

    public Integer getMaBL() {
        return maBL;
    }

    public void setMaBL(Integer maBL) {
        this.maBL = maBL;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Banh getIdBanh() {
        return idBanh;
    }

    public void setIdBanh(Banh idBanh) {
        this.idBanh = idBanh;
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
        hash += (maBL != null ? maBL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Binhluan)) {
            return false;
        }
        Binhluan other = (Binhluan) object;
        if ((this.maBL == null && other.maBL != null) || (this.maBL != null && !this.maBL.equals(other.maBL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dan.pojos.Binhluan[ maBL=" + maBL + " ]";
    }
    
}
