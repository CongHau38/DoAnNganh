
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/dangki" var="action"/>
    <c:url value="/dangnhap" var="login"/>
    <div class="login-form">
        <form:form action="${action}" modelAttribute="taikhoan" method="post" enctype="multipart/form-data">
            <h1 class="text-center">Đăng ký</h1>
            <div class="form-group">
                <form:input autocomplete="off" type="text" class="form-control input-lg" path="soDienThoai" placeholder="Số điện thoại" required="required"/>
            </div>
            <div class="form-group">
                <form:input type="password" class="form-control input-lg" path="matKhau" placeholder="Mật khẩu" required="required"/>
            </div>
            <div class="form-group">
                <form:input type="password" class="form-control input-lg" path="xacNhanMK" placeholder="Xác nhận mật khẩu" required="required"/>
            </div>
            <div class="form-group">
                <label for="anh">Ảnh đại diện:</label>
                <form:input  type="file"  id="anh" path="file" class="form-control"/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-lg btn-block login-btn">Đăng ký</button>
            </div>
            <c:if test="${errMessage != null}">
                <div class="text-danger" style="text-align: center; font-size: 20px; padding: 10px;">
                    ${errMessage}
                </div>
            </c:if>
            <div class="text-center ">
                <p>Bạn đã có tài khoản? <a href="${login}">Đăng nhập ngay</a></p>
            </div>
        </form:form>
    </div>
