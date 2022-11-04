/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dan.controllers;


import com.dan.pojos.Banh;
import com.dan.pojos.Binhluan;
import com.dan.pojos.Nguoidung;
import com.dan.service.BanhService;
import com.dan.service.CommentService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiCommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private BanhService banhService;
    
    @PostMapping(path = "/api/add-comment", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Binhluan> addBinhluan(@RequestBody Map<String, String> params,
            HttpSession session){
        Nguoidung u = (Nguoidung) session.getAttribute("cur");
        if ( u != null)
            try {
                String noidung = params.get("noiDung");
                int idBanh = Integer.parseInt(params.get("idBanh"));
                Banh b = this.banhService.getBanhById(idBanh);
                Binhluan bl = this.commentService.addBinhluan(noidung, b, u);
                return new ResponseEntity<>(bl, HttpStatus.CREATED);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
