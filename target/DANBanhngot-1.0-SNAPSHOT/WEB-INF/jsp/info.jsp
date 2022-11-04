
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="row bg-secondary" id="userup">
    <div class="col-sm-4">
        <div class="card" style="margin: 50px">
            <b style="text-align: center">THÔNG TIN CÁ NHÂN</b>
            <img class="card-img-top" src="${currentUser.anh}"/>
            <div class="card-body">
                <h4 class="card-title">${cur.ho} ${cur.ten}</h4>
                <p>Giới tính: ${cur.gioiTinh}
                <p>Số điện thoại: ${currentUser.soDienThoai}</p>
                <p>Email cá nhân: ${cur.email}</p>
            </div>
        </div>
    </div>
    <div class="col-sm-8">
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <h2 style="text-align: center">TẤT CẢ ĐƠN HÀNG ĐÃ GIAO DỊCH</h2>
            <c:forEach var="hd" items="${hoadonall}"> 
                <div class="card"> 
                    <div class="card-body">
                        <div class="row my-date">
                            <img style="width:70px;" src="${hd.maND.soDienThoai.anh}" class="rounded-circle"/>${hd.maND.ten}
                            <h4>Đơn hàng: ${hd.maHoaDon}</h4>
                            <p>Ngày lập: ${hd.ngaylap}</p>
                            <h5>TỔNG TIỀN: ${hd.tongTien}</h5>
                            <a href="<c:url value="/hoadon/${hd.maHoaDon}"/>" class="btn btn-danger" style="width: 200px">Chi tiết</a>
                        </div>
                    </div>
                </div>
                <br>
            </c:forEach>
        </sec:authorize>
        <c:if test="${currentUser.phanQuyen == 'ROLE_KHACHHANG'}">
            <h2 style="text-align: center">Lịch sử mua hàng</h2>
            <c:forEach var="hd" items="${hoadon}"> 
                <div class="card"> 
                    <div class="card-body">
                        <div class="row my-date">
                            <h4>Đơn hàng: ${hd.maHoaDon}</h4>
                            <p>Ngày lập: ${hd.ngaylap}</p>
                            <h5>TỔNG TIỀN: ${hd.tongTien}</h5>
                            <a href="<c:url value="/hoadon/${hd.maHoaDon}"/>" class="btn btn-danger" style="width: 200px">Chi tiết</a>
                        </div>
                    </div>
                </div>
                <br>
            </c:forEach>
        </c:if>
    </div>
</div>

<script>
    window.onload = function(){
        let dates = document.querySelectorAll(".my-date > i");
        for(let i = 0; i < dates.length; i++){
            let d = dates[i];
            d.innerText = moment(d.innerText).fromNow();
        }
    };
</script>
            

    


