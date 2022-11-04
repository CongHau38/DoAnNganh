
package com.dan.controllers;

import com.dan.pojos.Banh;
import com.dan.service.BanhService;
import com.dan.service.StatsService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private BanhService banhService;
    @Autowired
    private StatsService statsService;
    
    @GetMapping("/admin/them")
    public String banhView(Model model){
        model.addAttribute("banh", new Banh());
        return "thembanh";
    }
    
    @PostMapping("/admin/them")
    public String banh(Model model, @ModelAttribute(value ="banh") Banh banh){
        String errMsg="";
            if(this.banhService.addBanh(banh) == true )
                    return "redirect:/home";
            else
                errMsg ="Da co loi xay ra";
        model.addAttribute("errMsg", errMsg);
        return "thembanh";
    }
    
    @RequestMapping("/admin/sua/{idBanh}")
    public String update(Model model, @PathVariable(value = "idBanh") int idBanh){
        Banh b = this.banhService.getBanhById(idBanh);
        model.addAttribute("suabanh", b);
        return "suabanh";
    }
    @PostMapping("admin/sua/{idBanh}")
    public String updBaiviet(Model model,
            @ModelAttribute(value="suabanh") Banh banh) {
        if(this.banhService.updateBanh(banh)==true)
            return "redirect:/home"; 
        return "redirect:/home";
    }
    
    @RequestMapping("/admin/xoa/{idBanh}")
    public String delete(Model model, @PathVariable(value = "idBanh") int idBanh){
        if(this.banhService.deleteBanh(idBanh) == true)
            return "redirect:/home";
        return "redirect:/home";
    }
    
    @GetMapping("/admin/thongke")
    public String banhStats(Model model, @RequestParam(required = false) Map<String,String> params){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        Date fromDate = null, toDate = null;
        try{
            String fD = params.getOrDefault("fromDate", null);
            if(fD != null)
                fromDate = f.parse(fD);
 
            String tD = params.getOrDefault("toDate", null);
            if(fD != null)
                toDate = f.parse(tD);
        } catch (ParseException ex){
            ex.printStackTrace();
        }
        
        model.addAttribute("banhStats", this.statsService.banhStats(kw, fromDate, toDate));
        return "banhStats";
    }
}   
