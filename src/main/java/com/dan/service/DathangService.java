/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dan.service;

import com.dan.pojos.Cart;
import com.dan.pojos.ChitietHoadon;
import com.dan.pojos.Hoadon;
import com.dan.pojos.Nguoidung;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface DathangService {
    boolean addDonhang(Map<Integer, Cart> cart, Nguoidung nd);
    List<Hoadon> getHoadon(int ma);
    List<Hoadon> getAllHoadon(String kw);
    List<ChitietHoadon> getChitiet(int hd);
    Hoadon getHoaDonById(int id);
}
