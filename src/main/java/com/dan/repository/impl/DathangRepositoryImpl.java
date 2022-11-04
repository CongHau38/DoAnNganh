/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dan.repository.impl;

import com.dan.pojos.Banh;
import com.dan.pojos.Cart;
import com.dan.pojos.ChitietHoadon;
import com.dan.pojos.ChitietHoadonPK;
import com.dan.pojos.Hoadon;
import com.dan.pojos.Nguoidung;
import com.dan.repository.BanhRepository;
import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.dan.repository.DathangRepository;
import com.dan.utills.Utils;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class DathangRepositoryImpl implements DathangRepository{
    @Autowired
    private BanhRepository banhRepository;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addDonhang(Map<Integer, Cart> cart, Nguoidung nd) {
        try{
            Session session = this.sessionFactory.getObject().getCurrentSession();
            Hoadon hd = new Hoadon();
            hd.setMaND(nd);
//            hd.setMaNV(1);
            hd.setNgaylap(new Date());
            Map<String, String> stats = Utils.cartStats(cart);
            hd.setTongTien(Long.parseLong(stats.get("amount")));
            hd.setTongSanpham(Integer.parseInt(stats.get("counter")));
            session.save(hd);
            for(Cart c: cart.values()){
                ChitietHoadonPK cthd = new ChitietHoadonPK(hd.getMaHoaDon(), c.getIdBanh());
                ChitietHoadon ct = new ChitietHoadon();
                Banh b = this.banhRepository.getBanhById(c.getIdBanh());
                b.setSoLuong(b.getSoLuong() - c.getDem());
                ct.setChitietHoadonPK(cthd);
                ct.setHoadon(hd);
                ct.setBanh(b);
                ct.setDonGia(c.getGia());
                ct.setSoluong(c.getDem());
                session.save(ct);
            }
            return true;
        } catch(HibernateException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Hoadon> getHoadon(int ma) {
        Session session =this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Hoadon> query = builder.createQuery(Hoadon.class);
        Root root = query.from(Hoadon.class);
      
        query = query.where(builder.equal(root.get("maND"), ma));
        query = query.orderBy(builder.desc(root.get("ngaylap")));
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public List<ChitietHoadon> getChitiet(int hd) {
        Session session =this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ChitietHoadon> query = builder.createQuery(ChitietHoadon.class);
        Root root = query.from(ChitietHoadon.class);
      
        query = query.where(builder.equal(root.get("hoadon"), hd));
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public List<Hoadon> getAllHoaDon(String kw) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Hoadon> query = builder.createQuery(Hoadon.class);
        Root root = query.from(Hoadon.class);
        query = query.select(root);
        
        Predicate p = builder.like(root.get("maHoaDon").as(String.class),String.format("%%%s%%",kw));
        query = query.where(p).orderBy(builder.desc(root.get("ngaylap")));
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public Hoadon getHoaDonById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Hoadon.class, id);
    }
    
}
