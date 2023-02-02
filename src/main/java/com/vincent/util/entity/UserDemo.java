package com.vincent.util.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.google.gson.Gson;
import com.vincent.util.common.JsonObj;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author vincent
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserDemo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;


    /**
     * 扩展信息
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<JsonObj> extraInfo;


    public static void main(String[] args) {
        String str = "[{\"keyObj\": \"a\", \"valueObj\": \"ee\"}, {\"keyObj\": \"b\", \"valueObj\": \"bb\"}, " +
                "{\"keyObj\": \"c\", \"valueObj\": \"cc\"}, {\"keyObj\": \"d\", \"valueObj\": \"dd\"}]";
        Gson gson = new Gson();
        List<UserDemo> l1 = (List<UserDemo>) gson.fromJson(str, List.class);
        System.out.println(l1);


        String str2 = "[{\"key\": \"a\", \"valueObj\": \"ee\"}, {\"key\": \"b\", \"valueObj\": \"bb\"}, {\"key\": " +
                "\"c\", \"valueObj\": \"cc\"}, {\"key\": \"d\", \"valueObj\": \"dd\"}]";
        List<UserDemo> l2 = (List<UserDemo>) gson.fromJson(str2, List.class);

        for (UserDemo demo : l2) {
            System.out.println(demo);
        }

        System.out.println(l2);
    }

}
