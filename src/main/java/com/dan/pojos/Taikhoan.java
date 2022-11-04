
package com.dan.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "taikhoan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taikhoan.findAll", query = "SELECT t FROM Taikhoan t"),
    @NamedQuery(name = "Taikhoan.findBySoDienThoai", query = "SELECT t FROM Taikhoan t WHERE t.soDienThoai = :soDienThoai"),
    @NamedQuery(name = "Taikhoan.findByMatKhau", query = "SELECT t FROM Taikhoan t WHERE t.matKhau = :matKhau"),
    @NamedQuery(name = "Taikhoan.findByAnh", query = "SELECT t FROM Taikhoan t WHERE t.anh = :anh"),
    @NamedQuery(name = "Taikhoan.findByPhanQuyen", query = "SELECT t FROM Taikhoan t WHERE t.phanQuyen = :phanQuyen")})
public class Taikhoan implements Serializable {

    public static final String ADMIN="ROLE_ADMIN";
    public static final String USER="ROLE_USER";
    public static final String KHACHHANG="ROLE_KHACHHANG";
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "soDienThoai")
    private String soDienThoai;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "matKhau")
    private String matKhau;
    @Size(max = 255)
    @Column(name = "anh")
    private String anh;
    @Size(max = 45)
    @Column(name = "phanQuyen")
    private String phanQuyen;
    @Transient
    private String XacNhanMK;
    @Transient
    private MultipartFile file;
    
    @JsonIgnore
    @OneToOne(mappedBy = "soDienThoai")
    private Nguoidung nguoidung;
    
    public Taikhoan() {
    }

    public Taikhoan(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Taikhoan(String soDienThoai, String matKhau) {
        this.soDienThoai = soDienThoai;
        this.matKhau = matKhau;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getPhanQuyen() {
        return phanQuyen;
    }

    public void setPhanQuyen(String phanQuyen) {
        this.phanQuyen = phanQuyen;
    }
    
    public String getXacNhanMK() {
        return XacNhanMK;
    }

    public void setXacNhanMK(String XacNhanMK) {
        this.XacNhanMK = XacNhanMK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soDienThoai != null ? soDienThoai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taikhoan)) {
            return false;
        }
        Taikhoan other = (Taikhoan) object;
        if ((this.soDienThoai == null && other.soDienThoai != null) || (this.soDienThoai != null && !this.soDienThoai.equals(other.soDienThoai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dan.pojos.Taikhoan[ soDienThoai=" + soDienThoai + " ]";
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
    public Nguoidung getNguoidung() {
        return nguoidung;
    }

    public void setNguoidung(Nguoidung nguoidung) {
        this.nguoidung = nguoidung;
    }
    
}
