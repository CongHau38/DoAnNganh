
package com.dan.repository;

import com.dan.pojos.Nguoidung;
import com.dan.pojos.Taikhoan;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface LoginRepository {
    boolean addTaikhoan(Taikhoan tk);
    boolean addNguoidung(Nguoidung nd);
    List<Taikhoan> getTaikhoan(String username);
    List<Nguoidung> getNguoidung(String username);
}    
