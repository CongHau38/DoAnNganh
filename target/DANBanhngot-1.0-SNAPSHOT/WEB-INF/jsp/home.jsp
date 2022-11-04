   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="row bg-secondary">
    <div class="col-sm-1"></div>
    <div class="container col-sm-10 ">
        <h1 class="text-center text-white">THÔNG TIN CÁC LOẠI BÁNH</h1>
            <div>
                <ul class="pagination">
                    <c:forEach begin="1" end="${Math.ceil(counts/12)}" var="i">
                        <li class="page-item"><a class="page-link" href="<c:url value="/home" />?page=${i}">${i}</a></li>
                    </c:forEach>
                </ul>
            </div>
        <div class="row">
            <c:forEach var="b" items="${banh}">  
                <div class="card col-sm-4" style="">
                    <div class="card-body ">
                        <a class="page-link" href="<c:url value="/home/${b.idBanh}"/>">
                            <img style="height: 240px; width: 100%" src="${b.anh}"/>
                            <h3 style="text-align:center">${b.tenBanh}</h3>
                            <h5 style="text-align:center">Giá: ${b.donGia} VND</h5>
                                <c:if test="${b.soLuong == 0}">
                                    <p style="text-align:center" class="text-danger" >đã hết hàng</p>
                                </c:if>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <p>Số lượng: ${b.soLuong}</p>
                                </sec:authorize> 
                                    
                        </a>
                        <c:if test="${currentUser.phanQuyen == 'ROLE_KHACHHANG'}">
                            <c:if test="${b.soLuong != 0}">
                                <div class="card-footer bg-muted">
                                    <a href="javascript:;" class="btn btn-dark" onclick="addToCart(${b.idBanh})">Thêm vào giỏ</a>
                                    <a class="btn btn-danger" onclick="addToCart(${b.idBanh})" href="<c:url value="/cart"/>">Mua ngay</a>
                                </div>
                            </c:if>
                        </c:if>
                    </div>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <a href="<c:url value="/admin/sua/${b.idBanh}" />" class="btn btn-dark">Chỉnh sửa</a>
                            <a href="<c:url value="/admin/xoa/${b.idBanh}" />" class="btn btn-danger">Xóa</a>
                        </sec:authorize>
                </div>
                <br>
            </c:forEach>
            </div>
        <div>
            <ul class="pagination">
                <c:forEach begin="1" end="${Math.ceil(counts/12)}" var="i">
                    <li class="page-item"><a class="page-link" href="<c:url value="/home" />?page=${i}">${i}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="col-sm-1"></div>
</div>


