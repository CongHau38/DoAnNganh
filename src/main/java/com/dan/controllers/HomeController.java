
package com.dan.controllers;

import com.dan.pojos.Cart;
import com.dan.pojos.Taikhoan;
import com.dan.pojos.Nguoidung;
import com.dan.service.BanhService;
import com.dan.service.DathangService;
import com.dan.service.LoginService;
import com.dan.utills.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private LoginService userDetailsService;
    @Autowired
    private BanhService banhService;
    @Autowired
    private DathangService dathangService;
    
    @ModelAttribute
    public void commonAttr(Model model, HttpSession session){
        model.addAttribute("cartC", Utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }
    
    @GetMapping("/dangnhap")
    public String login(){
        return "dangnhap";
    }
    
    @GetMapping("/dangki")
    public String registerView(Model model){
        model.addAttribute("taikhoan", new Taikhoan());
        return "dangki";
    }
    
    @PostMapping("/dangki")
    public String register(Model model,@ModelAttribute(value ="taikhoan" ) Taikhoan tk){
        String errMsg="";
        if (tk.getMatKhau().equals(tk.getXacNhanMK())){
            if(this.userDetailsService.addTaikhoan(tk) == true ){
                model.addAttribute("sdt", tk.getSoDienThoai());
                return "redirect:/dangkict";
            }
                else
                    errMsg ="Da co loi xay ra";
            }else
                errMsg="Mat khau khong khop!";
        model.addAttribute("errMsg", errMsg);
        return "dangki";
    }
    
    @GetMapping("/dangkict")
    public String ctView(Model model, @RequestParam(name = "sdt", required = false) String sdt) {
        model.addAttribute("nguoidung", new Nguoidung());
        model.addAttribute("tk", userDetailsService.getTaikhoan(sdt).get(0));
        return "dangkict";
    }

    @PostMapping("/dangkict")
    public String ct(Model model, 
            @ModelAttribute(value = "nguoidung") Nguoidung nd) {
//        nd.setSoDienThoai(userDetailsService.getTaikhoan(nd.getSoDienThoai)).get(0);
        if (this.userDetailsService.addNguoidung(nd) == true) {
            return "redirect:/dangnhap";
        }
        return "dangki";
    }

    
    @RequestMapping("/home")
    public String home(Model model,
            @RequestParam(required = false) Map<String, String> params){
            int page = Integer.parseInt(params.getOrDefault("page", "1"));
            model.addAttribute("banh", this.banhService.getBanhByName("", page));
            model.addAttribute("counts", this.banhService.countBanh());
            return "home";
    }
    
    @RequestMapping("/info/{maND}")
    public String info(Model model, @PathVariable(value = "maND") int ma){
        model.addAttribute("hoadon", this.dathangService.getHoadon(ma));
        model.addAttribute("hoadonall", this.dathangService.getAllHoadon(""));
        return "info";
    }
    
    @RequestMapping("/hoadon/{maHD}")
    public String chitiet(Model model, @PathVariable(value = "maHD") int hd){
        model.addAttribute("cthd", this.dathangService.getChitiet(hd));
        model.addAttribute("hd", this.dathangService.getHoaDonById(hd));
        return "cthoadon";
    }
}
