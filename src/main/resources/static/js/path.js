//页面加载时就触发里面的函数和语句
$(function() {
    // res=[{
    // 	num:90,            //学习人数
    // 	courseNum:8,       //课程数
    // 	practiceNum:2999   //预计学习时长
    // }]
    // function demo(){
    // 	$('.num1').html(res[0].num);
    //     $('.num2').html(res.courseNum);
    //     $('.num3').html(res.practiceNum);
    //  }
    //  demo();
    getPathInfo();
    // getPathCourse();

})

//获取课程id
var str = location.href;
var id = str.split("?")[1].split("=")[1]
console.log(id)

//获取路径详情
function getPathInfo() {
    $.ajax({
        url: "/path/" + id,
        type: "get",
        // data:{userid:id}
        success: function(res) {
            console.log(res)
            $('.num1').html(res.heat);
            $('.num3').html(res.learn_time); 
            $('.pathName').html(res.name);
            $('.classintroduce').html(res.introduce);
        },
        error: function() {}
    });
}


function getPathCourse() {
    $.ajax({
        url: "/getCourse" + id,
        type: "get",
        // data:{userid:id}
        success: function(res) {
            console.log(res)
            var list = '';
            $.each(res, function(index, item) {
                list += '<div class="col-md-4">' +
                    '<div class="card mb-4 box-shadow">' +
                    '<a href="' + item.url + '"><img class="card-img-top" src="" alt="Card image cap">' +
                    '<div class="card-body">' +
                    '<p class="card-text course-name">' + item.name + '</p></a><div class=""><p class="course-name">' +
                    '<small class="text-muted">参与人数<span>' + item.heat + '</span></small></p></div></div></div></div>'
            })
            $('.stage1').html(list)
        },
        error: function() {}
    });
}



function getComment() {
    $.ajax({
        url: "/commendations/path" + id,
        type: "get",
        // data:{userid:id}
        success: function(res) {
            console.log(res)
            var list = '';
            $.each(res.data, function(index, item) {
                list += ' <div class="media text-muted pt-3">' +
                    '<img data-src="holder.js/32x32?theme=thumb&bg=6f42c1&fg=6f42c1&size=1" alt="" class="mr-2 rounded">' +
                    '<p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">' +
                    '<strong class="d-block text-gray-dark"><a href="#">' + item.username + '</a></strong>' +
                    '<small class="d-block ">' + item.content + '</small><span>' + item.create_time + '</span>' +
                    '<span style="float: right;cursor: pointer;" onclick="response(this,'+item.username+')"><a href="#textarea">回复</a></span></p></div>'
            })
            $('.conmment').html(list)
        },
        error: function() {}
    });
}


//发表评论
var username='';
var flag=0;//0表示评论 1表示回复 

function remark() {

    var comment = $('#textarea').val();
    var message = {
        "content": comment,
        "foreign_id":id,
    }
    if(flag==1){
    	message = {
	        "content": comment,
	        "foreign_id":id,
	        "username":username,
    	}
    }
    $.ajax({
        url: "commendation",
        type: "post",
        data: { commendation: message },
        success: function(res) {
            console.log(res)

        },
        error: function() {}
    });
}


//回复评论时先获取的值
 function response(dom,name){
    var text="回复"+$(dom).prev().prev().prev().text();
    $("#textarea").attr("placeholder",text)
    flag=1;
    username=name;
 }


 //加入路径(暂且理解朋友代码里的/addcourse接口为加入路径接口)
 function addPath(){
 	var message={
 		courseId:id
 	}
 	$.ajax({
        url: "/path",
        type: "post",
        data: { "userid": "10", "pathid": id },
        success: function(res) {
            console.log(res)
        },
        error: function() {}
    });
 }


//代码资源获取
 function getCodeResource(){
     $.ajax({
        url: "/code/" + id,
        type: "get",
        // data:{userid:id}
        success: function(res) {
            console.log(res)
            var list = '';
            $.each(res, function(index, item) {
                list += '<div class="media text-muted pt-3">'+
                        '<img src="https://csdnimg.cn/release/download/old_static/images/minetype/zip.svg" alt="" class="mr-2 rounded">'+
                        '<p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray"><strong class="d-block text-gray-dark" style="font-size: 20px">'+
                        '<a href="' + item.url + '">' + item.name +'</a></strong>'+
                        '<span>上传者:&nbsp;<span>' + item.uploader + '</span></span> &nbsp;&nbsp;&nbsp;<span>上传时间：</span><span>' + item.upload_time +'</span></p></div>'
            })
            $('.source').html(list)
        },
        error: function() {}
    });
 }


//阶段测试
function stageTest(){
    $.ajax({
        url: "/contest/" + id+"/1/",
        type: "post",
        // data:{userid:id}
        success: function(res) {
            console.log(res)
            var list = '';
            $.each(res, function(index, item) {
                list += '<a href="' + item.url + '">'+
                        '<button type="button" style="float: right;margin-top: 10px;" class="btn btn-secondary">阶段测试</button></a>'
            })
            $('.stage1_1').html(list)
        },
        error: function() {}
    });
}