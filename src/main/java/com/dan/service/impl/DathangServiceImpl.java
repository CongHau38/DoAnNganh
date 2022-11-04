/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dan.service.impl;

import com.dan.pojos.Cart;
import com.dan.pojos.ChitietHoadon;
import com.dan.pojos.Hoadon;
import com.dan.pojos.Nguoidung;
import com.dan.repository.DathangRepository;
import com.dan.service.DathangService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class DathangServiceImpl implements DathangService{
    @Autowired
    private DathangRepository dathangRepository;
            
    @Override
    public boolean addDonhang(Map<Integer, Cart> cart, Nguoidung nd) {
        if(cart != null)
            return this.dathangRepository.addDonhang(cart, nd);
    
        return false;
    }

    @Override
    public List<Hoadon> getHoadon(int ma) {
        return this.dathangRepository.getHoadon(ma);
    }

    @Override
    public List<ChitietHoadon> getChitiet(int hd) {
        return this.dathangRepository.getChitiet(hd);
    }

    @Override
    public List<Hoadon> getAllHoadon(String kw) {
        return this.dathangRepository.getAllHoaDon(kw);
    }

    @Override
    public Hoadon getHoaDonById(int i) {
        return this.dathangRepository.getHoaDonById(i);
    }

}
