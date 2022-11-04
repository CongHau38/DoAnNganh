/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dan.service;

import com.dan.pojos.Banh;
import com.dan.pojos.Binhluan;
import com.dan.pojos.Nguoidung;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CommentService {
    long countBinhluan(int bvId);
    Binhluan addBinhluan(String noidung, Banh bv, Nguoidung u);
    List<Binhluan> getBinhLuanByB(int bv, int page);
}
