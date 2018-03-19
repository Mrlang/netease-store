$(function() {
    $("#sub-nav-product").attr("class","active");
    $(".addCart").click(function () {
        $.ajax({
            url:ctx+"/cart/add/"+$(this).attr("productid")+"/1",
            success:function(result){
                if(result.code==200){
                    toastr.info("添加购物车成功.");
                }else{
                    toastr.info("添加成功.");
                }
            },
            error:function(){
                toastr.info("发生错误,稍后重试.");
            }
        })
    })
})