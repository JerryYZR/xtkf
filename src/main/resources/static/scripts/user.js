

function getDiscussByUserId() {
    var userId = 1;
    var formData_Discusses=new FormData();
    formData_Discusses.append("id" ,userId);
    var user = getResponse("/user",formData_Discusses,"multipart/form-data");
    var discusses = getResponse("/user/discusses",formData_Discusses,"multipart/form-data");


    console.log(user.responseJSON.username);
    $("#username").text(user.responseJSON.username);

    var coursetmp='';
    for(var i=0;i<discusses.responseJSON.length;i++){
        coursetmp+='<li class="question-item"><div class="col-md-10"><div class="col-sm-2 question-item-author">' +
            '<div class="user-avatar "><a class="avatar" href="/user/13/" target="_blank"><img src="image/image_user.jpg" title="石头山"></a>' +
            '<a class="member-icon" href="/vip" target="_blank"><img class="user-icon" src="image/premium-vip-icon.png" title="高级会员"></a>' +
            '</div></div><div class="col-sm-10"><h4><a class="question-item-title" href="/questions/1440" target="_blank">' +
            discusses.responseJSON[i].name +
            '</a></h4><div class="question-item-summary"><div class="user-username ">' +
            '<a class="username" href="/user/13/" target="_blank">石头山</a><span class="user-level">L358</span>' +
            '</div><span class="question-item-date">20秒前</span>最后回复 <span class="question-item-date">' +
            '<div class="user-username "><a class="username" href="/user/837745/" target="_blank">yezr</a>' +
            '<span class="user-level">L1</span></div></span></div></div></div><div class="col-md-2 question-item-rank">' +
            '<div class="question-item-answered"><div>' +
            discusses.responseJSON[i].heat +
            '</div><div>回复</div></div>' +
            '<div class="question-item-views"><div>33814</div><div>查看</div></div></div></li>';
    }
    document.getElementById("discusses").innerHTML=coursetmp;




    console.log(discusses);

}

getDiscussByUserId();