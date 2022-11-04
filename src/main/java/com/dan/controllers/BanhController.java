/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dan.controllers;

import com.dan.service.BanhService;
import com.dan.service.CommentService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class BanhController {
    @Autowired
    private BanhService banhService;
    @Autowired
    private CommentService commentService;
    
    @RequestMapping("/home/{idBanh}")
    public String chitiet(Model model, @PathVariable(value = "idBanh") int idBanh,
        @RequestParam(required = false) Map<String, String> params){
    
        model.addAttribute("banh", this.banhService.getBanhById(idBanh));
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("binhluan", this.commentService.getBinhLuanByB(idBanh, page));
        model.addAttribute("blcounts", this.commentService.countBinhluan(idBanh));
        return "banh";
    }
}
