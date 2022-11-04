<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-danger">GIỎ HÀNG</h1>
<c:if test="${cart == null}">
    <h4 class="text-danger" style="text-align: center">Không có sản phẩm nào trong giỏ!!</h4>
</c:if>
<c:if test="${cart != null}">
    <table class="table">
        <tr>
            <th>Mã bánh</th>
            <th>Tên bánh</th>
            <th>Đơn giá</th>
            <th>Số lượng</th>
            <th>Thành tiền</th>
        </tr>
        <c:forEach var="c" items="${cart}">
            <tr>
                <td>${c.idBanh}</td>
                <td>${c.tenBanh}</td>
                <td>${c.gia} VND</td>
                <td>
                    <div class="form-group">
                        <input type="number" min="1" onblur="updCart(this, ${c.idBanh})"
                               value="${c.dem}" class="form-control" style="width: 100px"/>
                    </div>
                </td>
                <td>
                    ${c.gia * c.dem} VND
                </td>
                <td>
                    <input type="button"
                           onclick="deleteCart(${c.idBanh})"
                           value="Xóa" 
                           class="btn btn-danger"/>
                </td>
            </tr>
        </c:forEach>
    
    </table>
    <div>
        <h5 class="text-info" style="text-align: right">Tổng tiền hóa đơn: <span>${cartS.amount}</span> VND</h5>
    </div>
        <input type="button" style="margin-left:1300px"onclick="pay()" value="Thanh toán" class="btn btn-danger"/>
</c:if>