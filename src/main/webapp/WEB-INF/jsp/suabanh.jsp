<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/admin/sua/${idBanh}" var="action"/>
    <div class="login-form">
        <form:form action="${action}" method="post" modelAttribute="suabanh" enctype="multipart/form-data">
            <h2 class="text-center">Cập nhật thông tin bánh</h2>
            <div class="form-group">
                <form:input autocomplete="off" type="text" class="form-control input-lg" path="tenBanh" placeholder="Có tên gì mới cho bánh?" required="required"/>
            </div>
            <div class="form-group">
                <form:input autocomplete="off" type="text" class="form-control input-lg" path="moTa" placeholder="Hãy mô tả nó xem!" required="required"/>
            </div>
            <div class="form-group">
                <form:input type="text" autocomplete="off" class="form-control input-lg" path="donGia" placeholder="Bạn muốn thay đổi giá bán?" required="required"/>
            </div>
            <div class="form-group">
                <form:input type="text" autocomplete="off" class="form-control input-lg" path="soLuong" placeholder="Cập nhật số lượng mới nào!" required="required"/>
            </div>
            <div class="form-group">
                <label for="anh">Chọn lại ảnh thôi:</label>
                <form:input  type="file"  id="anh" path="file" class="form-control"/>
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
