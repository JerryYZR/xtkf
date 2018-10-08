function getResponse(url,data,contentType, type){
    var processData=true;
    if(url==null)
        return;
    if(contentType==null){
        contentType='application/json;charset=utf-8';
    }else if(contentType=="multipart/form-data"){
        contentType=false;
        processData=false;
    }

    if(data==null)
        data={};
    var result=$.ajax({
        type: type,
        url: url,
        data: data,
        contentType:contentType,
        processData: processData,
        async: false
    });
    return result;
}


function getData(url,data,contentType){
    var response=getResponse(url,data,contentType);
    return response.data;
}

function parseSrc(src) {
    switch (src){
        case 'A':
            return '结合教师科研';
            break;
        case 'B':
            return '结合生产实际';
            break;
        case 'C':
            return '结合实验';
            break;
        case 'D':
            return '结合实际背景的专题研究';
            break;
        case 'E':
            return '无实际背景的专题研究';
            break;
        case 'F':
            return '其他';
            break;
    }
}


function parseType(type) {
    switch (type){
        case 'A':
            return '学术论文';
            break;
        case 'B':
            return '调查报告';
            break;
        case 'C':
            return '工程设计';
            break;
        case 'D':
            return '实验';
            break;
        case 'E':
            return '理论计算';
            break;
        case 'F':
            return '其他';
            break;
    }
}

function parseMarkedDel(flag) {
    if(flag==false)
        return '通过';
    else
        return '未通过';
}