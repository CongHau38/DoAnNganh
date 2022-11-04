
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:if test="${pageContext.request.userPrincipal.name == null}">
    <nav class="navbar navbar-expand-md bg-dark navbar-dark">
        <ul class="navbar-nav">
            <li class="nav-item active" >
                <a class="nav-link" href="<c:url value="/" />">HomE</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value="/dangnhap" />">Đăng nhập</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value="/dangki" />">Đăng kí</a>
            </li>
        </ul>
    </nav>
</c:if>
<c:if test="${pageContext.request.userPrincipal.name != null}">
        <nav class="navbar navbar-expand-md bg-dark navbar-dark">
            <ul class="navbar-nav">
                <li class ="nav-item active">
                    <a href="<c:url value="/info/${cur.maND}" />" class="nav-link text-white">
                        <c:if test="${currentUser.anh != null}">
                            <img style="width:30px;" src="${currentUser.anh}" class="rounded-circle"/>
                        </c:if>
                        <c:if test="${currentUser.anh == null}">
                            <i class="fa fa-user" aria-hidden="true"/></i>
                        </c:if>
                        ${cur.ten}</a>
                </li>
                <li class="nav-item active" >
                    <a class="nav-link" href="<c:url value="/home" />">HomE</a>
                </li>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="/admin/them" />">Thêm bánh</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="/admin/thongke" />">Thống kê</a>
                </li>
                </sec:authorize>
                <c:if test="${currentUser.phanQuyen == 'ROLE_KHACHHANG'}">
                <li class="nav-item active">
                    <a class="nav-link active" href="<c:url value="/cart" />"> 
                        <div class="badge badge-danger" id="cart-counter">Giỏ ${cartC}</div>
                    </a>
                </li>
                </c:if>
                <li class ="nav-item active">
                    <a class="nav-link text-danger" href="<c:url value="/logout" />">Đăng xuất</a>
                </li>
            </ul>
        </nav>
                
</c:if>