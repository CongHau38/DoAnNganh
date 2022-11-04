
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 style="text-align: center">Thống kê doanh thu</h1>
<div class="row">
    <div class="col-md-4" style="margin-top: 100px">
        <form action="">
            <div  class="form-group">
                <input type="text" class="form-control input-lg" placeholder="Từ khóa tìm kiếm" name="kw">
        </div>
        <div  class="form-group">
            <label>Từ thời điểm</label>
            <input type="date" class="form-control input-lg" name="fromDate">
        </div>
        <div  class="form-group">
            <label>Đến thời điểm</label>
            <input type="date" class="form-control input-lg" name="toDate">
        </div>
            <input type="submit" value="Báo cáo" class="btn btn-success"/>
    </form>
    </div>
    <div class="col-md-8">
        <canvas id="myBanhStatsChart" ></canvas>
    </div>
</div>
<table class="table">
        <tr>
            <th>Mã bánh</th>
            <th>Tên bánh</th>
            <th>Doanh thu</th>
        </tr>
        <c:forEach var="v" items="${banhStats}">
            <tr>
                <td>${v[0]}</td>
                <td>${v[1]}</td>
                <td>${v[2]} VND</td>
            </tr>
        </c:forEach>
</table>

<script>
    let banhLabels=[], banhInfo=[]
    <c:forEach var="v" items="${banhStats}">
        banhLabels.push('${v[1]}')
        banhInfo.push(${v[2]})
    </c:forEach>
        
    window.onload = function(){
        banhChart("myBanhStatsChart", banhLabels, banhInfo)
    }
</script>
    