package com.vincent.util.controller;


import com.vincent.util.service.IUserDemoService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author vincent
 */
@RestController
@RequestMapping("/user-demo")
public class UserDemoController {

    @Resource
    private IUserDemoService userDemoService;
}
