

function getDiscussByUserId() {
    var userId = 1;
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

    var discusses_topic = getResponse("/user/discusses/createUserId",formData_Discusses,"multipart/form-data", "post");


    //userInfo
    $("#username").text(user.responseJSON.username);
    $("#user_image").attr({
        "title" : user.responseJSON.username,
        "src" : "image/" + user.responseJSON.image_url
    });

    //discusses
    var discuss_response_html='';
    for(var i=0; i<discusses.responseJSON.length; i++){
        var formData_Discusses_User=new FormData();
        formData_Discusses_User.append("id" ,discusses.responseJSON[i].create_userId);
        var discuss_user = getResponse("/user",formData_Discusses_User,"multipart/form-data", "post");
        console.log(discuss_user)
        discuss_response_html += '<li class="question-item"><div class="col-md-10"><div class="col-sm-2 question-item-author">' +
            '<div class="user-avatar "><a class="avatar" href="/user/13/" target="_blank"><img src="image/' +
            user.responseJSON.image_url +
            '" title="石头山"></a>' +
            '<a class="member-icon" href="/vip" target="_blank"><img class="user-icon" src="image/premium-vip-icon.png" title="高级会员"></a>' +
            '</div></div><div class="col-sm-10"><h4><a class="question-item-title" href="/questions/1440" target="_blank">' +
            discusses.responseJSON[i].name +
            '</a></h4><div class="question-item-summary"><div class="user-username ">' +
            '<a class="username" href="/user/13/" target="_blank">'+
            discuss_user.responseJSON.username +
            '</a></div></div></span></div></div></div><div class="col-md-2 question-item-rank">' +
            '<div class="question-item-answered"><div>' +
            discusses.responseJSON[i].heat +
            '</div><div>回复</div></div>' +
            '<div class="question-item-views"><div>33814</div><div>查看</div></div></div></li>';
    }
    document.getElementById("discuss_response_items").innerHTML=discuss_response_html;


    var discuss_topic_html='';
    for(var i=0; i<discusses_topic.responseJSON.length; i++){
        discuss_topic_html += '<li class="question-item"><div class="col-md-10"><div class="col-sm-2 question-item-author">' +
            '<div class="user-avatar "><a class="avatar" href="/user/13/" target="_blank"><img src="image/image_user.jpg" title="石头山"></a>' +
            '<a class="member-icon" href="/vip" target="_blank"><img class="user-icon" src="image/premium-vip-icon.png" title="高级会员"></a>' +
            '</div></div><div class="col-sm-10"><h4><a class="question-item-title" href="/questions/1440" target="_blank">' +
            discusses_topic.responseJSON[i].name +
            '</a></h4><div class="question-item-summary"><div class="user-username ">' +
            '<a class="username" href="/user/13/" target="_blank">'+
            user.responseJSON.username +
            '</a></div></div></span></div></div></div><div class="col-md-2 question-item-rank">' +
            '<div class="question-item-answered"><div>' +
            discusses_topic.responseJSON[i].heat +
            '</div><div>回复</div></div>' +
            '<div class="question-item-views"><div>33814</div><div>查看</div></div></div></li>';
    }
    document.getElementById("discuss_topic_items").innerHTML=discuss_topic_html;


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