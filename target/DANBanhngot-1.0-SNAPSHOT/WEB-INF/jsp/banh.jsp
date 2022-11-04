
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row bg-secondary">
    <div class="col-sm-3"></div>
    <div class="container col-sm-6">
        <div class="card-body bg-white">
            <div class="row">
                <div class="col-sm-6">
                    <img style="width:100%; height: 100% " src="${banh.anh}"/>
                </div>
                <div class="col-sm-6 my-date">
                    <h3>${banh.tenBanh}</h3>
                    <h4>Giá: ${banh.donGia} VND</h4>
                    <b>----------</b>
                    <h5>Mô tả:</h5>
                    <p>${banh.moTa}<p>
                    <c:if test="${banh.soLuong == 0}">
                    <p class="text-danger">đã hết hàng</p>
                    </c:if>
                    <c:if test="${currentUser.phanQuyen == 'ROLE_KHACHHANG' && banh.soLuong != 0}">
                        <div class="card-footer bg-muted" style="margin-top: 90px">
                            <a href="javascript:;" class="btn btn-dark" onclick="addToCart(${b.idBanh})">Thêm vào giỏ</a>
                            <a href="<c:url value="/cart"/>" class="btn btn-danger" onclick="addToCart(${b.idBanh})">Mua ngay</a>
                        </div>
                    </c:if>
                </div>
            </div>
            <br>
        </div>
        <br>
        <form>
            <div class="form-group">
                <textarea class="form-control" id="maBL" placeholder="Thêm bình luận..."></textarea>
                <input type="button" onclick="addBinhluan(${banh.idBanh})"
                    href="<c:url value="/hom"/>"
                    value="Gửi" class="btn btn-danger" />
            </div>    
        </form>
        <div id="binhluanAr">
            <c:forEach var="cm" items="${binhluan}">  
                <div class="card"> 
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-1">
                                <img style="width:55px;" src="${cm.maND.soDienThoai.anh}" class="rounded-circle"/></a>
                            </div>
                            <div class="col-sm-6 my-date">
                                <h4>${cm.maND.ten}</h4>
                            </div>
                            <p>${cm.noiDung}</p>
                        </div>
                    </div>
                </div>
                    <br>
            </c:forEach>
        </div>
        <div>
            <ul class="pagination">
                <c:forEach begin="1" end="${Math.ceil(blcounts/10)}" var="i">
                    <li class="page-item"><a class="page-link" href="<c:url value="/home/${baiviet.idBaiviet}" />?page=${i}">${i}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="col-sm-3"></div>
</div>
                      

