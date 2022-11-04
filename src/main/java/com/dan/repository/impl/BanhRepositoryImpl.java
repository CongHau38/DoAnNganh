package com.dan.repository.impl;


import com.dan.pojos.Banh;
import com.dan.repository.BanhRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BanhRepositoryImpl implements BanhRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addBanh(Banh banh) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
           session.save(banh);
           return true;
        }catch (Exception ex){
               System.err.println("== Add banh err =="+ex.getMessage()) ;
               ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updBanh(Banh banhn) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Banh b = this.getBanhById(banhn.getIdBanh());
            b.setTenBanh(banhn.getTenBanh());
            b.setMoTa(banhn.getMoTa());
            b.setSoLuong(banhn.getSoLuong());
            b.setDonGia(banhn.getDonGia());
            session.update(b);
            
            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delBanh(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        String hql = "delete from Banh where idBanh.idBanh=:id";
        session.createQuery(hql).setParameter("id", id).executeUpdate();
        return true;
    }

    @Override
    public long countBanh() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From Banh");
        
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public List<Banh> getBanhByName(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Banh> query = builder.createQuery(Banh.class);
        Root root = query.from(Banh.class);
        query = query.select(root);
        
        if(kw!=null){
            Predicate p = builder.like(root.get("tenBanh").as(String.class),String.format("%%%s%%",kw));
            query = query.where(p).orderBy(builder.desc(root.get("soLuong")));
        }
        
        Query q = session.createQuery(query);
        
        int max = 12;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        return q.getResultList();
    }
    
    @Override
    public Banh getBanhById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Banh.class, id);
    }
    
}
