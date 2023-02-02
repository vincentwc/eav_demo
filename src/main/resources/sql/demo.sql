DROP TABLE IF EXISTS user_demo;

CREATE TABLE user_demo
(
    id         BIGINT(20)  NOT NULL COMMENT '主键ID',
    name       VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age        INT(11)     NULL DEFAULT NULL COMMENT '年龄',
    email      VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    extra_info JSON comment '扩展信息',
    PRIMARY KEY (id)
);