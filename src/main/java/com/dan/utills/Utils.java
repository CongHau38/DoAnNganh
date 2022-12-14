/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dan.utills;

import com.dan.pojos.Cart;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Utils {
    public static int countCart(Map<Integer, Cart> cart){
        int count =0;
        if(cart!= null){
            for(Cart c: cart.values())
                count+= c.getDem();
        }
        return count;
    }
    public static Long sumAmount(Map<Integer, Cart> cart){
        Long s=0l;
        if(cart!= null){
            for(Cart c: cart.values())
                s+= c.getDem()* c.getGia();
        }
        
        return s;
    }
    public static Map<String, String> cartStats(Map<Integer, Cart> cart){
        Long s=0l;
        int q= 0 ;
        
        if(cart!= null)
            for(Cart c: cart.values()){
                q += c.getDem();
                s += c.getDem()*c.getGia();
        }
        Map<String, String> kq= new HashMap<>();
        kq.put("counter", String.valueOf(q));
        kq.put("amount", String.valueOf(s)); 
        return kq;
}
}
