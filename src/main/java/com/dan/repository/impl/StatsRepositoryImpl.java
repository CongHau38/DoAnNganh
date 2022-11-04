
package com.dan.repository.impl;

import com.dan.pojos.Banh;
import com.dan.pojos.ChitietHoadon;
import com.dan.pojos.Hoadon;
import com.dan.repository.StatsReposirtry;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class StatsRepositoryImpl implements StatsReposirtry{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Object[]> banhStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootB = q.from(Banh.class);
        Root rootH = q.from(Hoadon.class);
        Root rootC = q.from(ChitietHoadon.class);
        
        List<Predicate> predicate = new ArrayList<>();
        predicate.add(b.equal(rootC.get("banh"), rootB.get("idBanh")));
        predicate.add(b.equal(rootC.get("hoadon"), rootH.get("maHoaDon")));
        
        q.multiselect(rootB.get("idBanh"), rootB.get("tenBanh"), 
                b.sum(b.prod(rootC.get("donGia"), rootC.get("soluong"))));
        
        if(kw != null && !kw.isEmpty())
            predicate.add(b.like(rootB.get("tenBanh"), String.format("%%%s%%", kw)));
        
        if(fromDate != null)
            predicate.add(b.greaterThanOrEqualTo(rootH.get("ngaylap"), fromDate));
        if(toDate != null)
            predicate.add(b.lessThanOrEqualTo(rootH.get("ngaylap"), toDate));
        
        q.where(predicate.toArray(new Predicate[] {}));
        q.groupBy(rootB.get("idBanh"));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }   
}
