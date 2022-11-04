  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dan.controllers;

import com.dan.utills.Utils;
import com.dan.pojos.Cart;
import com.dan.pojos.Banh;
import com.dan.pojos.Nguoidung;
import com.dan.service.BanhService;
import com.dan.service.DathangService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class ApiCartController {
    @Autowired
    private DathangService dathangService;
    @Autowired
    private BanhService banhService;
    
    @GetMapping("/api/banh")
    public ResponseEntity<List<Banh>> listBanh(){
        List<Banh> banh = this.banhService.getBanhByName("", 1);
        return new ResponseEntity<>(banh,HttpStatus.OK);
    }
    
    @GetMapping("/api/cart/{idBanh}")
    public ResponseEntity<Integer> cart(@PathVariable(value = "idBanh") Integer idBanh,
            HttpSession session){
        Map<Integer, Cart> cart= (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart == null)
            cart= new HashMap<>();
        
        if(cart.containsKey(idBanh) == true){
            Cart c = cart.get(idBanh);
            c.setDem(c.getDem() + 1);
        }else{
            Banh b= this.banhService.getBanhById(idBanh);
            Cart c= new Cart();
            c.setIdBanh(b.getIdBanh());
            c.setTenBanh(b.getTenBanh());
            c.setGia(b.getDonGia());
            c.setDem(1);
            
            cart.put(idBanh, c);
        }
        
        session.setAttribute("cart", cart);
        
        return new ResponseEntity<>(Utils.countCart(cart),HttpStatus.OK);
    }
    
    @PutMapping("/api/cart/{idBanh}")
    public ResponseEntity<Map<String, String>> updCart(@RequestBody Cart params,
            HttpSession session){
        Map<Integer, Cart> cart= (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart == null)
            cart= new HashMap<>();
        int idBanh = params.getIdBanh();
        if(cart.containsKey(idBanh) == true){
            Cart c = cart.get(idBanh);
            c.setDem(params.getDem());
        }   
        session.setAttribute("cart", cart);
        
        return new ResponseEntity<>(Utils.cartStats(cart), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/api/cart/{idBanh}")
    public ResponseEntity<Map<String, String>> deleteCartItem(@PathVariable(value = "idBanh") Integer idBanh,HttpSession session){
        Map<Integer, Cart> cart= (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart != null && cart.containsKey(idBanh)){
            cart.remove(idBanh);
            session.setAttribute("cart", cart);
        }
        if (Utils.countCart(cart) == 0)
            session.setAttribute("cart", null);
        return new ResponseEntity<>(Utils.cartStats(cart), HttpStatus.OK);
    }
    
    @PostMapping("/api/pay")
    public HttpStatus pay(HttpSession session){
        Nguoidung nd = (Nguoidung) session.getAttribute("cur");
        if(this.dathangService.addDonhang((Map<Integer, Cart>) session.getAttribute("cart"), nd)==true){
            session.removeAttribute("cart");
            return HttpStatus.OK;
        }
            
        return HttpStatus.BAD_REQUEST;
    }
}
    
