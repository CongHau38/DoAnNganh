
package com.dan.repository;

import com.dan.pojos.Banh;
import java.util.List;

public interface BanhRepository {
    boolean addBanh(Banh banh);
    boolean updBanh(Banh banhmoi);
    boolean delBanh(int id);
    long countBanh();
    List<Banh> getBanhByName(String kw, int page);
    Banh getBanhById(int id);
}
