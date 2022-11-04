
package com.dan.service.impl;

import com.dan.repository.StatsReposirtry;
import com.dan.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class StatsServiceImpl implements StatsService{
    @Autowired
    private StatsReposirtry statsReposirtry;
    @Override
    public List<Object[]> banhStats(String kw, Date fromDate, Date toDate) {
        return this.statsReposirtry.banhStats(kw, fromDate, toDate);
    }
    
}
