package com.vincent.util.service.impl;

import com.vincent.util.entity.UserDemo;
import com.vincent.util.mapper.UserDemoMapper;
import com.vincent.util.service.IUserDemoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author vincent
 */
@Service
public class UserDemoServiceImpl extends ServiceImpl<UserDemoMapper, UserDemo> implements IUserDemoService {

}
