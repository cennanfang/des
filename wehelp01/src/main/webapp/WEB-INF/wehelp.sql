
DROP TABLE IF EXISTS `w_user`;  
CREATE TABLE `w_user` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `user_name` varchar(100) NOT NULL unique, 
  `password` varchar(64) NOT NULL,
  `salt` varchar(32) DEFAULT NULL COMMENT '盐',  
  `locked` char(1) DEFAULT NULL COMMENT '是否锁定0否，1是',  
  `nick_name` varchar(100) DEFAULT NULL, 
  `sex` int(2) DEFAULT '0',  
  `age` int(3) DEFAULT '0', 
  `phone` varchar(11) DEFAULT NULL,
  `email`  varchar(30) DEFAULT NULL,  
  `address`  varchar(200) DEFAULT NULL,
  `register_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  


DROP TABLE IF EXISTS `w_message_type`;  
CREATE TABLE `w_message_type` (  
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `name` varchar(20) NOT NULL, 
  `description` varchar(300) NOT NULL, 
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  


DROP TABLE IF EXISTS `w_message`;  
CREATE TABLE `w_message` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `content` varchar(600) NOT NULL, 
  `contacts` varchar(30) NOT NULL, 
  `creat_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
  `published_date` TIMESTAMP,
  foreign key(user_id) references w_user(id),
  foreign key(type_id) references w_message_type(id),
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  


DROP TABLE IF EXISTS `w_role`;  
CREATE TABLE `w_role` (  
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `name` varchar(20) NOT NULL, 
  `available` char(1) DEFAULT NULL COMMENT '是否可用0否1是',
  `description` varchar(300) DEFAULT NULL, 
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  


DROP TABLE IF EXISTS `w_permission`;  
CREATE TABLE `w_permission` (  
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `role_id` int(11), 
  `token` varchar(100) NOT NULL, 
  `url` varchar(100) NOT NULL, 
  `available` char(1) DEFAULT NULL COMMENT '是否可用0否1是',
  `description` varchar(300) DEFAULT NULL, 
  foreign key(role_id) references w_role(id),
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  

DROP TABLE IF EXISTS `w_user_role`;  
CREATE TABLE `w_user_role` (  
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `user_id` int(11), 
  `role_id` int(11), 
  foreign key(user_id) references w_user(id),
  foreign key(role_id) references w_role(id),
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  


insert into w_user(user_name, password, locked, nick_name, sex, age, phone, email, address)
values('rose', '000000', 0, '肉丝', 2, 18, '13888888888', 'meigui@qq.com', '华盛顿');
insert into w_user(user_name, password, locked, nick_name, sex, age, phone, email, address)
values('jack', '000000', 0, '杰克', 1, 20, '13999999999', 'jiege@qq.com', '伦敦');
insert into w_user(user_name, password, locked, nick_name, sex, age, phone, email, address)
values('zhangjie', '000000', 0, '张杰', 1, 20, '133333333333', 'zhangsan@qq.com', '北京');
insert into w_user(user_name, password, locked, nick_name, sex, age, phone, email, address)
values('huazai', '000000', 0, '华仔', 1, 19, '13666666666', 'lisi@qq.com', '香港');

update w_user set password='MDZhNTE0NThhNjQ4OTgwYjE1ZGM3NDZjODIyMDcwMzQ=', salt='7845233539713e375677264f30736133' where id = 1;
update w_user set password='MTI4NWQ0ZWU2YTk1MTRjMzVhNzI5NmE5MzliNTFjOTU=', salt='2830727a3857514f2f5e2c263a6a6d3d' where id = 2;
update w_user set password='MWVjYzc3YTM5ODk5MWJlNGI2OGUzNGE1NGNkNTEzZTM=', salt='2f556a247b317622796c6960253f6175' where id = 3;
update w_user set password='M2M0NmVmN2U4YWU4MTUwNDU1YmQ1YzM0YzhiNzljMWU=', salt='7923342e60554c3d7c3c7b79543f2b50' where id = 4;

insert into w_message_type(name) values('出行：人找车');
insert into w_message_type(name) values('出行：车找人');
insert into w_message_type(name) values('招聘求职');
insert into w_message_type(name) values('告示通告');
insert into w_message_type(name) values('求购出售');

insert into w_role(name, available, description) values('user', 1, '普通用户');
insert into w_role(name, available, description) values('admin', 1, '超级用户');

insert into w_permission(role_id, token, url, available, description) values(1, 'home', '/home', 1, '用户角色资源');
insert into w_permission(role_id, token, url, available, description) values(2, 'home', '/home', 1, '用户角色资源');
insert into w_permission(role_id, token, url, available, description) values(2, 'admin', '/admin', 1, '管理员资源');

insert into w_user_role(user_id, role_id) values(1, 1);
insert into w_user_role(user_id, role_id) values(1, 2);

insert into w_message(content, contacts, user_id, type_id) values ('本人今天要从册亨去兴义', '12333333333', 1, 1);
insert into w_message(content, contacts, user_id, type_id) values ('本人要从兴义到册亨', '16633339999', 2, 2);
