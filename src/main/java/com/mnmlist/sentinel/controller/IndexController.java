package com.mnmlist.sentinel.controller;

import com.mnmlist.sentinel.service.IndexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: zhangtengfei01
 * @date: 2021/10/30 5:20 PM
 * @desc: 测试
 */
@RestController
public class IndexController {

    @Resource
    private IndexService indexService;

    @GetMapping("/status")
    @ResponseBody
    public Object index() {
        return indexService.doStatus();
    }

    @GetMapping("/")
    @ResponseBody
    public String success() {
        return "success";
    }
}
