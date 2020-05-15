package com.imooc.demo.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账户信息表 前端控制器
 * </p>
 *
 * @author hellozw
 * @since 2020-05-15
 */
@RestController
@RequestMapping("/zdPerson")
public class ZdPersonController extends BaseController {

    @GetMapping("/listZdPerson")
    @ApiOperation(value = "测试接口",notes = "测试")
    public List<Map<String,Object>> listZdPerson(){
        listMap = zdPersonService.listZdPerson();
        return listMap;
    }

}

