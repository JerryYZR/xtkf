

function getDiscussByUserId() {
    var user= JSON.parse(sessionStorage.getItem("user"));
    var userId = user.id;
    var nav = [{"id":"nav_course", "name":"课程", "content_id":"courses"},
        {"id":"nav_path", "name":"路径", "content_id":"paths"},
        {"id":"nav_discuss", "name":"讨论", "content_id":"discusses"}]
    var nav_discusses = [{"id":"topic", "content_id":"discuss_topic_items"},
        {"id":"response", "content_id":"discuss_response_items"},
        {"id":"collection", "content_id":"discuss_collection_items"}]
    var formData_Discusses=new FormData();
    formData_Discusses.append("id" ,userId);
    var user = getResponse("/user",formData_Discusses,"multipart/form-data", "post");
    var discusses = getResponse("/user/discusses/userId",formData_Discusses,"multipart/form-data", "post");
    var tutorList = getResponse("/users/tutor/userId",formData_Discusses,"multipart/form-data", "post");
    var discusses_topic = getResponse("/user/discusses/createUserId",formData_Discusses,"multipart/form-data", "post");
    var questions = getResponse("/user/questions/userId",formData_Discusses,"multipart/form-data", "post");
    var questions2 = getResponse("/user/questions/createUserId",formData_Discusses,"multipart/form-data", "post");
    console.log(questions2)


    //userInfo
    $("#username").text(user.responseJSON.username);
    $("#user_image").attr({
        "title" : user.responseJSON.username,
        "src" : "image/" + user.responseJSON.image_url
    });

    console.log(1)
    console.log(tutorList)
    //tutors
    var tutors_html='';
    for(var i=1; i<=tutorList.responseJSON.length; i++){
        tutors_html += '<div id="tutor' + i +
            '" class="sidebox-body course-content side-list-body">' +
            '<ul style="list-style-type:none"><div class="media-left">' +
            '<div class="user-avatar"><a class="avatar" href="#sign-modal" data-toggle="modal" data-sign="signin">' +
            '<img src="image/image_user.jpg" class="circle"></a></div></div><div class="media-body">' +
            '<span class="media-heading username">' + tutorList.responseJSON[i-1].username +
            '</span></div></ul></div>'
    }
    document.getElementById("dalaolist").innerHTML=tutors_html;
    for (var i = 1; i <= tutorList.responseJSON.length; i++) {
        $("#tutor" + i).click(function () {
            var temp = this.id.split("r");
            location.href = "tutor.html?" + "userId=" + tutorList.responseJSON[temp[1]-1].id;
        });
    }

    //discusses
    var discuss_response_html='';
    console.log(1)
    for(var i=1; i<=questions.responseJSON.length; i++){
        discuss_response_html += '<li class="question-item" id="bigData"><div class="col-md-10">' +
            '<div class="col-sm-2 question-item-author"><div class="user-avatar ">' +
            '<a class="avatar" href="../user/13/study.html" target="_blank">' +
            '<img src="image/gravataradmin.png">' +
            '</a></div></div><div class="col-sm-10"><h4>' +
            '<a class="question-title" target="_blank" id="title' + i +
            '">' + questions.responseJSON[i-1].title +
            '</a></h4><div class="question-item-summary"><div class="user-username ">' +
            '</span><span>详情：</span><span id="content">' +
            questions.responseJSON[i-1].content + '</span></div></div></div></div></li>';
    }
    document.getElementById("discuss_response_items").innerHTML=discuss_response_html;

    for (var i = 1; i <= questions.responseJSON.length; i++) {
        $("#title" + i).click(function () {
            var temp = this.id.split("e");
            location.href = "show.html?" + "userId=" + userId + "&questionId=" + questions.responseJSON[temp[1]-1].id;
        });
    }


    var discuss_response_html2='';
    console.log(1)
    for(var i=1; i<=questions2.responseJSON.length; i++){
        discuss_response_html2 += '<li class="question-item" id="bigData"><div class="col-md-10">' +
            '<div class="col-sm-2 question-item-author"><div class="user-avatar ">' +
            '<a class="avatar" href="../user/13/study.html" target="_blank">' +
            '<img src="image/gravataradmin.png">' +
            '</a></div></div><div class="col-sm-10"><h4>' +
            '<a class="question-title" target="_blank" id="title' + i +
            '">' + questions2.responseJSON[i-1].title +
            '</a></h4><div class="question-item-summary"><div class="user-username ">' +
            '</span><span>详情：</span><span id="content">' +
            questions2.responseJSON[i-1].content + '</span></div></div></div></div></li>';
    }
    document.getElementById("discuss_topic_items").innerHTML=discuss_response_html2;

    for (var i = 1; i <= questions2.responseJSON.length; i++) {
        $("#title" + i).click(function () {
            var temp = this.id.split("e");
            location.href = "show.html?" + "userId=" + userId + "&questionId=" + questions.responseJSON[temp[1]-1].id;
        });
    }


    //选择点击事件初始化
    $("#"+ nav_discusses[0].id).addClass("label-success");
    $("#"+ nav_discusses[1].id).addClass("label-default");
    $("#"+ nav_discusses[2].id).addClass("label-default");
    for(var i=0; i<nav_discusses.length; i++){
        $("#"+ nav_discusses[i].content_id).hide();
    }

    $("#"+ nav_discusses[0].content_id).show();

    //选择点击事件
    for(var i=0; i<nav_discusses.length; i++){
        $("#"+ nav_discusses[i].id).click(function () {
            for(var j=0; j<nav_discusses.length; j++){
                $("#"+ nav_discusses[j].id).removeClass("label-success");
                $("#"+ nav_discusses[j].id).addClass("label-default");
                $("#"+ nav_discusses[j].content_id).hide();

                if (nav_discusses[j].id == this.id) {
                    $(this).removeClass("label-default");
                    $(this).addClass("label-success");
                    $("#"+ nav_discusses[j].content_id).show();
                }
            }
        })
    }



    //选择点击事件初始化
    $("#"+ nav[0].id).parent().addClass("active");
    for(var i=0; i<nav.length; i++){
        $("#"+ nav[i].content_id).hide();
    }
    $("#"+ nav[0].content_id).show();

    //选择点击事件
    for(var i=0; i<nav.length; i++){
        $("#"+ nav[i].id).click(function () {
            for(var j=0; j<nav.length; j++){
                $("#"+ nav[j].id).parent().removeClass("active");
                $("#"+ nav[j].content_id).hide();

                if (nav[j].id == this.id) {
                    $(this).parent().addClass("active");
                    $("#"+ nav[j].content_id).show();
                }
            }
        })
    }
    // console.log(discusses);

}

getDiscussByUserId();