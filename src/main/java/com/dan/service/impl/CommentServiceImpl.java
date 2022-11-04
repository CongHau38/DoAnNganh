
package com.dan.service.impl;

import com.dan.pojos.Banh;
import com.dan.pojos.Binhluan;
import com.dan.pojos.Nguoidung;

import com.dan.repository.CommentRepository;
import com.dan.service.CommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    
    @Override
    public Binhluan addBinhluan(String noidung, Banh bv, Nguoidung u) {        
        Binhluan bl = new Binhluan();
        bl.setNoiDung(noidung);
        bl.setIdBanh(bv);
        bl.setMaND(u);
        
        return this.commentRepository.addBinhluan(bl);
    }

    @Override
    public List<Binhluan> getBinhLuanByB(int bv, int page) {
        return this.commentRepository.getBinhLuanByB(bv, page);
    }

    @Override
    public long countBinhluan(int idB) {
        return this.commentRepository.countBinhluan(idB);
    }
    
}
