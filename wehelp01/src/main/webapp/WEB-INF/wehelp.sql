--创建数据库
DROP database IF exists wehelp;
create database wehelp;
use wehelp;
--创建相关表格
--用户表
DROP TABLE IF EXISTS `t_user`;  
CREATE TABLE `t_user` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `user_name` varchar(255) NOT NULL unique, 
  `password` varchar(64) NOT NULL,
  `salt` varchar(32) DEFAULT NULL COMMENT '盐',  
  `locked` char(1) DEFAULT NULL COMMENT '是否锁定0否，1是',  
  `nick_name` varchar(255) DEFAULT NULL, 
  `sex` int(2) DEFAULT '0',  
  `age` int(3) DEFAULT '0', 
  `phone` varchar(11) DEFAULT NULL,
  `email`  varchar(255) DEFAULT NULL,  
  `address`  varchar(255) DEFAULT NULL,
  `register_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  

-- 信息类型表
DROP TABLE IF EXISTS `t_message_type`;  
CREATE TABLE `t_message_type` (  
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `name` varchar(20) NOT NULL, 
  `description` varchar(255) NOT NULL, 
  `available` char(1) DEFAULT NULL COMMENT '是否可用0否1是',
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  

--信息表 
DROP TABLE IF EXISTS `t_message`;  
CREATE TABLE `t_message` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `content` varchar(1200) NOT NULL, 
  `contacts` varchar(30) NOT NULL, 
  `create_date` TIMESTAMP(3) DEFAULT CURRENT_TIMESTAMP(3), 
  `published_date` TIMESTAMP(3),
  foreign key(user_id) references t_user(id),
  foreign key(type_id) references t_message_type(id),
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  

-- 角色表
DROP TABLE IF EXISTS `t_role`;  
CREATE TABLE `t_role` (  
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `name` varchar(20) NOT NULL, 
  `available` char(1) DEFAULT NULL COMMENT '是否可用0否1是',
  `description` varchar(255) DEFAULT NULL, 
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  

--权限表
DROP TABLE IF EXISTS `t_permission`;  
CREATE TABLE `t_permission` (  
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `role_id` int(11), 
  `token` varchar(100) NOT NULL, 
  `url` varchar(255) NOT NULL, 
  `available` char(1) DEFAULT NULL COMMENT '是否可用0否1是',
  `description` varchar(255) DEFAULT NULL, 
  foreign key(role_id) references t_role(id),
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  

--用户角色信息表
DROP TABLE IF EXISTS `t_user_role`;  
CREATE TABLE `t_user_role` (  
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `user_id` int(11), 
  `role_id` int(11), 
  `available` char(1) DEFAULT NULL COMMENT '是否可用0否1是',
  foreign key(user_id) references t_user(id),
  foreign key(role_id) references t_role(id),
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  

--建立索引
explain select * from t_message where published_date != 0 order by published_date desc limit 0,3;
--t_user user_name 
--t_message published_date
create index i_mesg_pu_date on t_message (published_date);
--插入测试数据
insert into t_user(user_name, password, locked, nick_name, sex, age, phone, email, address)
values('rose', '000000', 0, '肉丝', 2, 18, '13888888888', 'meigui@qq.com', '华盛顿');
insert into t_user(user_name, password, locked, nick_name, sex, age, phone, email, address)
values('jack', '000000', 0, '杰克', 1, 20, '13999999999', 'jiege@qq.com', '伦敦');
insert into t_user(user_name, password, locked, nick_name, sex, age, phone, email, address)
values('zhangjie', '000000', 0, '张杰', 1, 20, '13333333333', 'zhangsan@qq.com', '北京');
insert into t_user(user_name, password, locked, nick_name, sex, age, phone, email, address)
values('huazai', '000000', 0, '华仔', 1, 19, '13666666666', 'lisi@qq.com', '香港');

update t_user set password='MDZhNTE0NThhNjQ4OTgwYjE1ZGM3NDZjODIyMDcwMzQ=', salt='7845233539713e375677264f30736133' where id = 1;
update t_user set password='MTI4NWQ0ZWU2YTk1MTRjMzVhNzI5NmE5MzliNTFjOTU=', salt='2830727a3857514f2f5e2c263a6a6d3d' where id = 2;
update t_user set password='MWVjYzc3YTM5ODk5MWJlNGI2OGUzNGE1NGNkNTEzZTM=', salt='2f556a247b317622796c6960253f6175' where id = 3;
update t_user set password='M2M0NmVmN2U4YWU4MTUwNDU1YmQ1YzM0YzhiNzljMWU=', salt='7923342e60554c3d7c3c7b79543f2b50' where id = 4;

insert into t_message_type(name, description, available) values('出行：人找车', '描述', 1);
insert into t_message_type(name, description, available) values('出行：车找人', '描述', 1);
insert into t_message_type(name, description, available) values('招聘求职', '描述', 1);
insert into t_message_type(name, description, available) values('告示通告', '描述', 1);
insert into t_message_type(name, description, available) values('求购出售', '描述', 1);

insert into t_role(name, available, description) values('user', 1, '普通用户');
insert into t_role(name, available, description) values('admin', 1, '超级用户');

insert into t_permission(role_id, token, url, available, description) values(1, 'home', '/home', 1, '用户角色资源');
insert into t_permission(role_id, token, url, available, description) values(2, 'admin', '/admin', 1, '管理员资源');

insert into t_user_role(user_id, role_id, available) values(1, 1, 1);
insert into t_user_role(user_id, role_id, available) values(1, 2, 1);

insert into t_message(content, contacts, user_id, type_id) values ('本人今天要从册亨去兴义', '12333333333', 1, 1);
insert into t_message(content, contacts, user_id, type_id) values ('本人要从兴义到册亨', '16633339999', 2, 2);
insert into t_message(content, contacts, user_id, type_id) values ('本人要从兴义到贵阳', '16633339992', 2, 1);
insert into t_message(content, contacts, user_id, type_id) values ('本人要从册亨到贵阳', '16633339993', 1, 2);
insert into t_message(content, contacts, user_id, type_id) values ('本人要从贵阳到北京', '16633339994', 2, 2);
insert into t_message(content, contacts, user_id, type_id) values ('本人要从北京到纽约', '16633339995', 1, 2);
insert into t_message(content, contacts, user_id, type_id) values ('本人要从纽约到伦敦', '16633339996', 1, 2);
insert into t_message(content, contacts, user_id, type_id) values ('本人要从纽约到扒犁', '16633339997', 1, 2);

update t_message set published_date=now(3) where id = 1;
update t_message set published_date=now(3) where id = 3;
update t_message set published_date=now(3) where id = 5;
update t_message set published_date=now(3) where id = 7;
update t_message set published_date=now(3) where id = 8;
update t_message set published_date=now(3) where id = 6;


--查询信息
select * from t_message where id > 3 order by id desc limit 0,2;