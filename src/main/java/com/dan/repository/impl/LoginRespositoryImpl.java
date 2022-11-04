
package com.dan.repository.impl;

import com.dan.pojos.Nguoidung;
import com.dan.pojos.Taikhoan;
import com.dan.repository.LoginRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class LoginRespositoryImpl implements LoginRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addTaikhoan(Taikhoan tk) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(tk);  
            return true;
        }catch (HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Taikhoan> getTaikhoan(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Taikhoan> query =builder.createQuery(Taikhoan.class);
        Root root = query.from(Taikhoan.class);
        query = query.select(root);

        if(!username.isEmpty()){
            Predicate p = builder.equal(root.get("soDienThoai").as(String.class), username.trim());
            query = query.where(p);
        }

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Nguoidung> getNguoidung(String string) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Nguoidung> query =builder.createQuery(Nguoidung.class);
        Root root = query.from(Nguoidung.class);
        query = query.select(root);

        if(!string.isEmpty()){
            Predicate p = builder.equal(root.get("soDienThoai").as(String.class), string.trim());
            query = query.where(p);
        }

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean addNguoidung(Nguoidung nd) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(nd);  
            return true;
        }catch (HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;
    }
}
