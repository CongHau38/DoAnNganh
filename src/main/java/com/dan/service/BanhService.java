
package com.dan.service;

import com.dan.pojos.Banh;
import java.util.List;

public interface BanhService {
    Banh getBanhById(int id);
    List<Banh> getBanhByName(String kw, int page);
    boolean addBanh(Banh banh);
    boolean updateBanh(Banh banhmoi);
    boolean deleteBanh(int id);
    long countBanh();
}
