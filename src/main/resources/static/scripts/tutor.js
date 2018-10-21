

function getDiscussByTutorId() {
    var userId = 1;
    var formData_Discusses=new FormData();
    formData_Discusses.append("id" ,userId);
    var user = getResponse("/user",formData_Discusses,"multipart/form-data", "post");
    var questions = getResponse("/user/questions/tutorId",formData_Discusses,"multipart/form-data", "post");

    //userInfo
    $("#username").text(user.responseJSON.username);
    $("#user_image").attr({
        "title" : user.responseJSON.username,
        "src" : "image/" + user.responseJSON.image_url
    });

    var discussformData = new FormData();
    discussformData.append("id", userId);
    var discuss_tutor = getResponse("/user/discusses/tutorId", discussformData, "multipart/form-data", "post");
    var coursetmp2 = '';
    for (var i = 1; i <= discuss_tutor.responseJSON.length; i++) {
        coursetmp2 += '<div id="discuss_tutor' + i +
            '" class="sidebox-body course-content side-list-body">' +
            '<ul id="dalaolist" style="list-style-type:none">' +
            '<div class="media-left"><div class="user-avatar">' +
            '<a class="avatar" href="#sign-modal" data-toggle="modal" data-sign="signin">' +
            '<img src="image/gravataradmin.png" class="circle"></a></div></div>' +
            '<div class="media-body"><span class="media-heading username">' + discuss_tutor.responseJSON[i-1].name +
            '</span></div></ul></div>';
    }
    document.getElementById("discuss_list").innerHTML = coursetmp2;
    for (var i = 1; i <= discuss_tutor.responseJSON.length; i++) {
        $("#discuss_tutor" + i).click(function () {
            var temp = this.id.split("r");
            location.href = "questions.html?" + "userId=" + userId + "&discussId=" + discuss_tutor.responseJSON[temp[1]-1].id;
        });
    }

    //discusses
    var discuss_response_html='';
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



    // console.log(discusses);

}

getDiscussByTutorId();