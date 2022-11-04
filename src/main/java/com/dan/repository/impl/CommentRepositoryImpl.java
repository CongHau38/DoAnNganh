/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dan.repository.impl;

import com.dan.pojos.Binhluan;
import com.dan.repository.CommentRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public Binhluan addBinhluan(Binhluan bl) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(bl);
            return bl;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Binhluan> getBinhLuanByB(int bv, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Binhluan> query = builder.createQuery(Binhluan.class);
        Root root = query.from(Binhluan.class);
      
        query = query.where(builder.equal(root.get("idBanh"), bv));

        query = query.orderBy(builder.desc(root.get("maBL")));
        Query q = session.createQuery(query);
        int max = 10;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        return q.getResultList();
    }

    @Override
    public long countBinhluan(int idB) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From Binhluan Where idBanh.idBanh=:id");
        q.setParameter("id", idB);
        
        return Long.parseLong(q.getSingleResult().toString());
    }
}
