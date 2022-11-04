/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dan.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Admin
 */
@Embeddable
public class ChitietHoadonPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "maHoaDon")
    private int maHoaDon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBanh")
    private int idBanh;

    public ChitietHoadonPK() {
    }

    public ChitietHoadonPK(int maHoaDon, int idBanh) {
        this.maHoaDon = maHoaDon;
        this.idBanh = idBanh;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getIdBanh() {
        return idBanh;
    }

    public void setIdBanh(int idBanh) {
        this.idBanh = idBanh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maHoaDon;
        hash += (int) idBanh;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChitietHoadonPK)) {
            return false;
        }
        ChitietHoadonPK other = (ChitietHoadonPK) object;
        if (this.maHoaDon != other.maHoaDon) {
            return false;
        }
        if (this.idBanh != other.idBanh) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dan.pojos.ChitietHoadonPK[ maHoaDon=" + maHoaDon + ", idBanh=" + idBanh + " ]";
    }
    
}
