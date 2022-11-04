
/* global fetch */

function addBinhluan(idBanh){
    fetch("/DANBanhngot/api/add-comment", {
        method: "post",
        body: JSON.stringify({
            "noiDung": document.getElementById("maBL").value,
            "idBanh": idBanh
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res){
       console.info(res)
       return res.json();
    }).then(function(data){
        console.info(data);
        let bl = document.getElementById("binhluanAr");
        bl.inerText = data;
        location.reload()
   });
}
function loadBinhLuan() {
    fetch().then(function (res) {
        return res.json();
    }).then(function (data) {
        let bl = document.getElementById("binhluanAr");
        let h = '';
        for (let d of data)
            h += `   
                <div class="card"> 
                    <div class="card-body">
                        <a href="<c:url value="/user/${data.maND.maND}" />">
                            <img style="width:40px;" src="${data.maND.soDienThoai.anh}" class="rounded-circle"/></a>
                            <b style="margin-left:20px">${data.maND.ten}</b>
                            <p>${data.noiDung}</p>
                    </div>
                </div>
            <br>`;
        bl.innerHTML = h;
    });
}

function addToCart(idBanh){
    fetch(`/DANBanhngot/api/cart/${idBanh}`).then(res => res.json()).then(data =>{
        var d = document.getElementById("cart-counter");
        if(d !== null)
            d.innerText = data;
    })
}

function deleteCart(idBanh){
    if(confirm("Bạn có chắc muốn xóa?")== true){
        fetch(`/DANBanhngot/api/cart/${idBanh}`,{
            method:"delete"
        }).then(function(res){
            console.info(res)
            return res.json();
        }).then(function(data){
            let counter = document.getElementById("cart-counter");
            counter.innerText = data
            location.reload()
        }) 
    }
}

function updCart(obj, idBanh){
    fetch(`/DANBanhngot/api/cart/${idBanh}`,{
            method:"put",
            body: JSON.stringify({
                "idBanh": idBanh,
                "tenBanh": "",
                "gia": 0,
                "dem": obj.value,
            }),
            headers: {
                "Content-Type": "application/json"
        }
        }).then(function(res){
            return res.json();
        }).then(function(data){
            let counter = document.getElementById("cart-counter");
            counter.innerText = data
            location.reload()
        }) 
}

function pay(){
    if(confirm("Bạn xác nhận đặt hàng chứ?")== true){
        fetch(`/DANBanhngot/api/pay`, {
            method:"post"
        }).then(function(res) {
            return res.json();
        }).then(function(code) {
            console.info(code);
            location.reload();
        })
    }
}
