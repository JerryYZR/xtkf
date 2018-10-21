$(function() {

    //加载全部课程
    $.ajax({
        //anync: false,
        url: "/path",
        type: "get",
        // data: { userid: id }
        success: function(res){
            console.log(res)
            var list='';
            var course_num;
            $.each(res,function(index,item){
                course_num = 0;
                $.ajax({
                    anync: false,
                    url: "/getCourse/" + item.id,
                    type: "get",
                    success: function(result) {
                        course_num=0;
                        $.each(result, function(index_c, item_c) {
                            course_num += 1;
                        })
                        console.log("test 1---" + course_num);
                        list+='<div class="col-md-4">'+
                            '<a href="./definite_path.html?id='+item.id+'"><div class="card mb-4 box-shadow">'+
                            '<img class="card-img-top" src="'+item.image_url+'"> '+
                            '<div class="card-body"><p class="card-text course-name">'+item.name+'</p><div class="">'+
                            //'<p class="course-name"><small class="text-muted"></small></p></div></div></div></a></div>'
                            '<p class="course-name"><small class="text-muted">共'+ course_num +'门课程</small></p></div></div></div></a></div>'
                        $('.row').html(list)
                        //$('.num2').html(course_num);
                    },
                    error: function() {}
                })
                console.log("test 2---" + course_num);
            	// list+='<div class="col-md-4">'+
                 //    '<a href="./definite_path.html?id='+item.id+'"><div class="card mb-4 box-shadow">'+
                 //    '<img class="card-img-top" src="'+item.image_url+'"> '+
                 //    '<div class="card-body"><p class="card-text course-name">'+item.name+'</p><div class="">'+
                 //    //'<p class="course-name"><small class="text-muted"></small></p></div></div></div></a></div>'
                 //    '<p class="course-name"><small class="text-muted">'+ course_num +'</small></p></div></div></div></a></div>'
            })
            //$('.row').html(list)
        },
        error: function() {}
    });

})