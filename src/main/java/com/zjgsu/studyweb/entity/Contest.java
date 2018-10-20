<<<<<<< HEAD
package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Contest")
public class Contest {
    private Long id;
    private String name;
    private String url;
    private String answer_url;
    private Integer degree;
    private Long path_id;
}
=======
package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Contest")
public class Contest {
    private Long id;
    private String name;
    private String url;
    private String answer_url;
    private Integer degree;
    private Long path_id;
}
>>>>>>> 195e200b7c322f410b1a9b0cce9ef24057377cd2
