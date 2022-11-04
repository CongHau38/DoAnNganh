/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dan.controllers;

import com.dan.pojos.Cart;
import com.dan.utills.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Admin
 */
@Controller
public class CartController {
    @GetMapping("/cart")
    public String cart(Model model, HttpSession session){
        Map<Integer, Cart> cart=(Map<Integer, Cart>) session.getAttribute("cart");
        if(cart != null)
            model.addAttribute("cart",cart.values());
        else if(Utils.countCart(cart) == 0)
            model.addAttribute("cart", null);
//        model.addAttribute("amount", Utils.sumAmount(cart));
        model.addAttribute("cartS", Utils.cartStats(cart));
        return "cart";
    }
}
