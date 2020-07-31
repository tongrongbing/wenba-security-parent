package com.wenba.web.controller;

import com.wenba.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: tongrongbing
 * @date: 2020-07-23 10:39
 **/
@RestController
@Slf4j
@Api(tags = "测试接口")
public class MainController {

    @GetMapping({"/index","/"})
    @ApiOperation(value = "demoTest",notes = "demo测试接口")
    public String index(){
        log.info("StringUtil.get()=============="+StringUtil.get());
        return "index";
    }
}
