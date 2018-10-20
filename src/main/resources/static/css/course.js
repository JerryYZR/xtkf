<<<<<<< HEAD
$(function() {

    //加载全部课程
    $.ajax({
        url: "/courses",
        type: "get",
        // data: { userid: id }
        success: function(res){
            // $('.num1').html(res.num);
            // $('.num2').html(res.courseNum);
            // $('.num3').html(res.practiceNum);
            console.log(res)
            var list='';
            $.each(res,function(index,item){
            	list+='<div class="col-md-4">'+
             '<a href="./definite_path.html?id='+item.id+'"><div class="card mb-4 box-shadow">'+              
                    '<img class="card-img-top" src=""> '+       
               '<div class="card-body"><p class="card-text course-name">'+item.name+'</p><div class="">'+
                '<p class="course-name"><small class="text-muted">31门课程</small></p></div></div></div></a></div>'
            })
            $('.row').html(list)
        },
        error: function() {}
    });
=======
$(function() {

    //加载全部课程
    $.ajax({
        url: "/path",
        type: "get",
        // data: { userid: id }
        success: function(res){
            // $('.num1').html(res.num);
            // $('.num2').html(res.courseNum);
            // $('.num3').html(res.practiceNum);
            console.log(res)
            var list='';
            $.each(res,function(index,item){
            	list+='<div class="col-md-4">'+
             '<a href="./definite_path.html?id='+item.id+'"><div class="card mb-4 box-shadow">'+              
                    '<img class="card-img-top" src=""> '+       
               '<div class="card-body"><p class="card-text course-name">'+item.name+'</p><div class="">'+
                '<p class="course-name"><small class="text-muted">31门课程</small></p></div></div></div></a></div>'
            })
            $('.row').html(list)
        },
        error: function() {}
    });
>>>>>>> 195e200b7c322f410b1a9b0cce9ef24057377cd2
})