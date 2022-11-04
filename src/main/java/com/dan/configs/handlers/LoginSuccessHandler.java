
package com.dan.configs.handlers;

import com.dan.pojos.Nguoidung;
import com.dan.pojos.Taikhoan;
import com.dan.service.LoginService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
/**
 *
 * @author Admin
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler{
    @Autowired
    private LoginService userDetailsService;
            
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication a) throws IOException, ServletException {
        Taikhoan u = this.userDetailsService.getTaikhoan(a.getName()).get(0);
        request.getSession().setAttribute("currentUser", u);
        
        request.getSession().setAttribute("cur", u.getNguoidung());
        response.sendRedirect("/DANBanhngot/home");
    }
}
