

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4 style="text-align: center"><b>Chi Tiết Đơn Hàng</b></h4>
<b>Tổng tiền hóa đơn:  ${hd.tongTien}VND</b>
<p>Số lượng bánh: ${hd.tongSanpham}</p>
<table class="table">
        <tr>
            <th>Mã bánh</th>
            <th>Tên bánh</th>
            <th>Đơn giá</th>
            <th>Số lượng</th>
            <th>Thành tiền</th>
        </tr>
        <c:forEach var="ct" items="${cthd}">
            <tr>
                <td>${ct.banh.idBanh}</td>
                <td>${ct.banh.tenBanh}</td>
                <td>${ct.donGia} VND</td>
                <td>${ct.soluong}</td>
                <td>
                    ${ct.donGia * ct.soluong}
                </td>
            </tr>
        </c:forEach>
</table>



