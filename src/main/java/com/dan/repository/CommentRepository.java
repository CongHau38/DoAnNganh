/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dan.repository;

import com.dan.pojos.Binhluan;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CommentRepository {
    long countBinhluan(int bvId);
    Binhluan addBinhluan(Binhluan bl);
    List<Binhluan> getBinhLuanByB(int bv, int page);
}
