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
    getPathCourse_1();
    getPathCourse_2();
    getPathCourse_3();
    getCodeResource();
    getComment();
    stageTest1_1();
    stageTest1_2();
    stageTest1_3()

})

//获取课程id
var str = location.href;
var id = str.split("?")[1].split("=")[1];


//获取路径详情
function getPathInfo() {
    $.ajax({
        url: "/path/" + id,
        type: "get",
        // data:{userid:id}
        success: function(res) {
            console.log(res[0])
            $('.num1').html(res[0].heat);        
            $('.num3').html(res[0].learn_time);
            $('.pathName').html(res[0].name);
            $('.classintroduce').html(res[0].introduce);
        },
        error: function() {}
    });
}


function getPathCourse_1() {
    $.ajax({
        url: "/getCourse/" + id,
        type: "get",
        // data:{userid:id}
        success: function(res) {
            //console.log(res)
            var list = '';
            $.each(res, function(index, item) {
                list += '<div class="col-md-4">' +
                    '<div class="card mb-4 box-shadow">' +
                    '<a href="' + item.url + '"><img class="card-img-top" src="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3780631991,570805979&fm=26&gp=0.jpg" alt="Card image cap">' +
                    '<div class="card-body">' +
                    '<p class="card-text course-name">' + item.name + '</p></a><div class=""><p class="course-name">' +
                    '<small class="text-muted">参与人数<span>' + item.heat + '</span></small></p></div></div></div></div>'
            })
            $('.stage1').html(list)
        },
        error: function() {}
    });
}


function getPathCourse_2() {
    $.ajax({
        url: "/getCourse/" + id,
        type: "get",
        // data:{userid:id}
        success: function(res) {
          //  console.log(res)
            var list = '';
            $.each(res, function(index, item) {
                list += '<div class="col-md-4">' +
                    '<div class="card mb-4 box-shadow">' +
                    '<a href="' + item.url + '"><img class="card-img-top" src="https://edu-image.nosdn.127.net/DDF16F24CB7546E2ADC1A6E7E5DA0961.jpg?imageView&thumbnail=426y240&quality=100&thumbnail=223x125&quality=100" alt="Card image cap">' +
                    '<div class="card-body">' +
                    '<p class="card-text course-name">' + item.name + '</p></a><div class=""><p class="course-name">' +
                    '<small class="text-muted">参与人数<span>' + item.heat + '</span></small></p></div></div></div></div>'
            })
            $('.stage2').html(list)
        },
        error: function() {}
    });
}

function getPathCourse_3() {
    $.ajax({
        url: "/getCourse/" + id,
        type: "get",
        // data:{userid:id}
        success: function(res) {
         //   console.log(res)
            var list = '';
            $.each(res, function(index, item) {
                list += '<div class="col-md-4">' +
                    '<div class="card mb-4 box-shadow">' +
                    '<a href="' + item.url + '"><img class="card-img-top" src="https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3119524125,2946556036&fm=26&gp=0.jpg" alt="Card image cap">' +
                    '<div class="card-body">' +
                    '<p class="card-text course-name">' + item.name + '</p></a><div class=""><p class="course-name">' +
                    '<small class="text-muted">参与人数<span>' + item.heat + '</span></small></p></div></div></div></div>'
            })
            $('.stage3').html(list)
        },
        error: function() {}
    });
}



function getComment() {
    $.ajax({
        url: "/commendations/path/" + id,
        type: "get",
        // data:{userid:id}
        success: function(res) {
            console.log(res)
            var list = '';
            $.each(res, function(index, item) {
                list += ' <div class="media text-muted pt-3">' +
                    '<img data-src="holder.js/32x32?theme=thumb&bg=6f42c1&fg=6f42c1&size=1" alt="" class="mr-2 rounded">' +
                    '<p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">' +
                    '<strong class="d-block text-gray-dark"><a href="#">' + item.username + '</a></strong>' +
                    '<small class="d-block ">' + item.content + '</small><span>' + item.create_time + '</span>' +
                    '<span style="float: right;cursor: pointer;" onclick="response(this,\''+item.username+'\','+item.id+')"><a href="#textarea">回复</a></span></p></div>'
            })
            $('.conmment').html(list);

        },
        error: function() {}
    });
}


//发表评论
var username='lvjinyu';
var userid='1';
var flag=0;//0表示评论 1表示回复

function remark() {

    var comment = $('#textarea').val();
    console.log(parseInt(id))
    var message = {
        //"id": userid, 这里不需要传userid的
        "content": comment,
        "username": username,
        "foreign_id":parseInt(id),
        "type": "path",
        "create_time": ""
    }
    if(flag==1){
        message = {
            // "id": userid,这里不需要穿userid的
            "content": comment,
            "foreign_id":parseInt(id),
            "username":username,
            "type": "path",
            "create_time": ""
        }
    }
    $.ajax({
        url: "/commendation",
        type: "post",
        contentType : "application/json",
        data: JSON.stringify(message),

        success: function(res) {
            console.log(res)
        },
        error: function() {}
    });
}


//回复评论时先获取的值
function response(dom,name,id){
    var text="回复"+name;
    $("#textarea").attr("placeholder",text)
    flag=1;
    username=name;
    userid=id;
}


//加入路径
function addPath(){
    var message={
        // "id": "",
        "pathid":parseInt(id),
        "userid": "1"
    }
    $.ajax({
        url: "/path",
        type: "post",
        contentType : "application/json",
        data: JSON.stringify(message),
        //data: { course: message },
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
         //   console.log(res)
            var list = '';
            $.each(res, function(index, item) {
                list += '<div class="media text-muted pt-3">'+
                    '<img src="https://csdnimg.cn/release/download/old_static/images/minetype/zip.svg" alt="" class="mr-2 rounded">'+
                    '<p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray"><strong class="d-block text-gray-dark" style="font-size: 20px">'+
                    '<a href="' + item.url + '">' + item.name +'</a></strong>'+
                    '<span>' + item.introduce + '</span></p></div>'
            })
            $('.source').html(list)
        },
        error: function() {}
    });
}

//阶段测试
function stageTest1_1(){
    $.ajax({
        url: "/contest/1/" + id ,
        type: "get",
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

function stageTest1_2(){
    $.ajax({
        url: "/contest/2/" + id ,
        type: "get",
        // data:{userid:id}
        success: function(res) {
            console.log(res)
            var list = '';
            $.each(res, function(index, item) {
                list += '<a href="' + item.url + '">'+
                    '<button type="button" style="float: right;margin-top: 10px;" class="btn btn-secondary">阶段测试</button></a>'
            })
            $('.stage1_2').html(list)
        },
        error: function() {}
    });
}

function stageTest1_3(){
    $.ajax({
        url: "/contest/3/" + id ,
        type: "get",
        // data:{userid:id}
        success: function(res) {
            console.log(res)
            var list = '';
            $.each(res, function(index, item) {
                list += '<a href="' + item.url + '">'+
                    '<button type="button" style="float: right;margin-top: 10px;" class="btn btn-secondary">阶段测试</button></a>'
            })
            $('.stage1_3').html(list)
        },
        error: function() {}
    });
}

