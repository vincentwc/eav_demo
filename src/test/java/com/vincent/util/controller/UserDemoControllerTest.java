package com.vincent.util.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vincent.EavDemoApplication;
import com.vincent.util.common.JsonObj;
import com.vincent.util.entity.UserDemo;
import com.vincent.util.mapper.UserDemoMapper;
import com.vincent.util.service.IUserDemoService;
import net.minidev.json.writer.UpdaterMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author vincent
 * @date 2023/2/2 10:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EavDemoApplication.class)
public class UserDemoControllerTest {

    @Resource
    private IUserDemoService userDemoService;

    @Resource
    private UserDemoMapper userDemoMapper;

    /**
     * json数据入库
     */
    @Test
    public void test1() {
        List<JsonObj> objs = new ArrayList<>();

        JsonObj obj1 = new JsonObj("a", "ee");
        JsonObj obj2 = new JsonObj("b", "bb");
        JsonObj obj3 = new JsonObj("c", "cc");
        JsonObj obj4 = new JsonObj("d", "dd");
        objs.add(obj1);
        objs.add(obj2);
        objs.add(obj3);
        objs.add(obj4);

        UserDemo userDemo = new UserDemo();
        userDemo.setId(3L)
                .setAge(18)
                .setEmail("1234@gmail.com")
                .setName("vincent")
                .setExtraInfo(objs);

        userDemoService.save(userDemo);
    }

    /**
     * 条件查询
     * SELECT id,name,age,email,extra_info FROM user_demo WHERE (JSON_CONTAINS(extra_info, JSON_OBJECT('keyObj','a')))
     */
    @Test
    public void test2() {
        String str = "a";
        QueryWrapper<UserDemo> wrapper = new QueryWrapper<>();
        wrapper.apply(StrUtil.isNotEmpty(str),
                "JSON_CONTAINS(extra_info, JSON_OBJECT('keyObj','" + str + "'))");
        List<UserDemo> userDemos = userDemoMapper.selectList(wrapper);
        System.out.println(userDemos);
    }

    /**
     * 修改json的某个字段信息
     * 将id为1，keyObj为“aa”的值改为“aaa”
     */
    @Test
    public void test3() {
        /**
         * 暂时的处理方案：
         *  查询出所有的，然后再java对象中进行修改，update入库
         */
        QueryWrapper<UserDemo> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1L);
        UserDemo userDemo = userDemoMapper.selectOne(wrapper);
        List<JsonObj> extraInfo = userDemo.getExtraInfo();
        for (JsonObj obj : extraInfo) {
//            String keyObj = obj.getKeyObj();
//            if ("a".equals(keyObj)) {
//                obj.setValueObj("aaa");
//            }
        }
        boolean b = userDemoService.updateById(userDemo);
        System.out.println(b);
    }


}