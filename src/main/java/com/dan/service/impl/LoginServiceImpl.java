
package com.dan.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dan.pojos.Nguoidung;
import com.dan.pojos.Taikhoan;
import com.dan.repository.LoginRepository;
import com.dan.service.LoginService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class LoginServiceImpl  implements LoginService{
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public boolean addTaikhoan(Taikhoan tk) {
        try {
            String pass = tk.getMatKhau();
            tk.setMatKhau(this.passwordEncoder.encode(pass));
            tk.setPhanQuyen(Taikhoan.KHACHHANG);

            Map r =this.cloudinary.uploader().upload(tk.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
            tk.setAnh((String) r.get("secure_url"));
            return this.loginRepository.addTaikhoan(tk);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public List<Taikhoan> getTaikhoan(String username) {
        return this.loginRepository.getTaikhoan(username);
    }
    
    @Override
    public List<Nguoidung> getNguoidung(String username) {
        return this.loginRepository.getNguoidung(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       List<Taikhoan> tks= this.getTaikhoan(username);
       if(tks.isEmpty()){
           throw new UsernameNotFoundException("khong ton tai");
       }
       Taikhoan tk= tks.get(0);
       
        Set<GrantedAuthority> auth= new HashSet<>();
        auth.add(new SimpleGrantedAuthority(tk.getPhanQuyen()));
        
        return new org.springframework.security.core.
                userdetails.User(tk.getSoDienThoai(), tk.getMatKhau(), auth);
    }

    @Override
    public boolean addNguoidung(Nguoidung nd) {
        return this.loginRepository.addNguoidung(nd);
    }
}

