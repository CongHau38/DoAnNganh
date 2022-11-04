
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/dangkict" var="action"/>
    <div class="login-form">
        <form:form action="${action}" method="post" modelAttribute="nguoidung" enctype="multipart/form-data">
            <h1 class="text-center">Nhập thông tin chi tiết</h1>
            ${sdt}
            <div class="form-group">
                <form:input autocomplete="off" type="text" class="form-control input-lg" path="ho" placeholder="Họ" required="required"/>
            </div>
            <div class="form-group">
                <form:input autocomplete="off" type="text" class="form-control input-lg" path="ten" placeholder="Tên" required="required"/>
            </div>
            <label for="role">Giới tính của bạn:</label>
            <form:select path="gioiTinh" >
                <form:option value="Nam" label="Nam"/>
                <form:option value="Nữ" label="Nữ"/>
            </form:select>
            <div>
                <form:input type="text" class="form-control input-lg" path="soDienThoai" value="${tk.soDienThoai}" readonly="true" required="required"/>
            </div>
            <div class="form-group">
                <form:input type="text" autocomplete="off" class="form-control input-lg" path="diaChi" placeholder="Địa chỉ" required="required"/>
            </div>
            <div class="form-group">
                <form:input type="email" autocomplete="off" class="form-control input-lg" path="email" placeholder="Email" required="required"/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-lg btn-block login-btn">Xong</button>
            </div>
            <c:if test="${errMessage != null}">
                <div class="text-danger" style="text-align: center; font-size: 20px; padding: 10px;">
                    ${errMessage}
                </div>
            </c:if>
        </form:form>
    </div>
