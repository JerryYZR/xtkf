<<<<<<< HEAD
package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.Code;
import com.zjgsu.studyweb.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CodeController {
    @Autowired
    CodeService codeService;

    @RequestMapping(value = "/code/{path_id}",method = RequestMethod.GET)
    public List<Code> getContest(@PathVariable long path_id){
        return codeService.getCode(path_id);
    }

}
=======
package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.Code;
import com.zjgsu.studyweb.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CodeController {
    @Autowired
    CodeService codeService;

    @RequestMapping(value = "/code/{path_id}",method = RequestMethod.GET)
    public List<Code> getContest(@PathVariable long path_id){
        return codeService.getCode(path_id);
    }

}
>>>>>>> 195e200b7c322f410b1a9b0cce9ef24057377cd2
