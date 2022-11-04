/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dan.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dan.pojos.Banh;
import com.dan.repository.BanhRepository;
import com.dan.service.BanhService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BanhServiceImpl implements BanhService{
    @Autowired
    private BanhRepository banhRepository;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public Banh getBanhById(int id) {
        return this.banhRepository.getBanhById(id);
    }
    
    @Override
    public List<Banh> getBanhByName(String kw, int page) {
        return this.banhRepository.getBanhByName(kw, page);
    }

    @Override
    public boolean addBanh(Banh banh) {
        try {
            Map r = this.cloudinary.uploader().upload(banh.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            banh.setAnh((String) r.get("secure_url"));
            return this.banhRepository.addBanh(banh);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBanh(Banh banhn) {
        try {
            Map r = this.cloudinary.uploader().upload(banhn.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            banhn.setAnh((String) r.get("secure_url"));
            return this.banhRepository.updBanh(banhn);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBanh(int id) {
        return this.banhRepository.delBanh(id);
    }

    @Override
    public long countBanh() {
        return this.banhRepository.countBanh();
    }
}
