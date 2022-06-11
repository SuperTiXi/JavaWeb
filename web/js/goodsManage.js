$(".form-control").keydown(function (event) {
    if(event.keyCode==13){
        const  temp =document.createElement("form");
        const val = $("#queryById").val();
        temp.action = "GoodsListServlet?model=query&queryById="+val;
        temp.method = "post";
        document.body.appendChild(temp);
        temp.submit();
    }
})

function modify(id,creator,picture,merchant) {
        document.getElementById("getId").value = id;
        document.getElementById("getBelong2").value = creator;
        document.getElementById("picture").value = picture;
}

