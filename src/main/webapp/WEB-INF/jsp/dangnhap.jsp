
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/dangnhap" var="action"/>
<c:url value="/dangki" var="dangki"/>
    <div class="login-form">
        <form:form action="${action}" method="post">
            <h1 class="text-center">Đăng nhập</h1>
            <div class="form-group">
                <input autocomplete="off" type="text" class="form-control input-lg" name="soDienThoai" placeholder="Nhập số điện thoại" required="required">
            </div>
            <div class="form-group">
                <input type="password" class="form-control input-lg" name="matKhau" placeholder="Mật khẩu" required="required">
            </div>        
            <div class="form-group">
                <input type="submit" class="btn btn-primary btn-lg btn-block login-btn" value="Đăng nhập"/>
            </div>
            <c:if test="${param.error != null}">
                <div class="text-danger" style="text-align: center; font-size: 20px; padding: 10px;">
                    Thông tin tài khoản hoặc mật khẩu không chính xác!!
                </div>
            </c:if>
            <c:if test="${param.accessDenied != null}">
                <div class="text-danger" style="text-align: center; font-size: 20px; padding: 10px;">
                     Bạn không có quyền truy cập!!!
                </div>
            </c:if>
            
            <div class="text-center">
                <p>Bạn chưa có tài khoản? <a href="${dangki}">Đăng ký ngay</a></p>
                <a href="#">Quên mật khẩu</a>
            </div>
        </form:form>
    </div>
