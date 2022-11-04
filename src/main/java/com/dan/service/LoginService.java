package com.dan.service;

import com.dan.pojos.Nguoidung;
import com.dan.pojos.Taikhoan;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Admin
 */
public interface LoginService extends UserDetailsService{
    boolean addTaikhoan(Taikhoan tk);
    boolean addNguoidung(Nguoidung nd);
    List<Taikhoan> getTaikhoan(String sdt);
    List<Nguoidung> getNguoidung(String sdt);
}