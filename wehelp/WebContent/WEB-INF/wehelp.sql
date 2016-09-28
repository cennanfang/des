
DROP TABLE IF EXISTS `w_user`;  
CREATE TABLE `w_user` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `user_name` varchar(20) NOT NULL unique, 
  `password` varchar(128) NOT NULL,
  `salt` varchar(64) DEFAULT NULL COMMENT '盐',  
  `locked` char(1) DEFAULT NULL COMMENT '账号是否锁定，1：锁定，0未锁定',  
  `nick_name` varchar(20) DEFAULT NULL, 
  `sex` int(2) DEFAULT '0',  
  `age` int(3) DEFAULT '0', 
  `phone` varchar(11) DEFAULT NULL,
  `email`  varchar(30) DEFAULT NULL,  
  `address`  varchar(30) DEFAULT NULL,
  `register_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  


DROP TABLE IF EXISTS `w_message_type`;  
CREATE TABLE `w_message_type` (  
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `name` varchar(20) NOT NULL, 
  `description` varchar(50) NOT NULL, 
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  


DROP TABLE IF EXISTS `w_message`;  
CREATE TABLE `w_message` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `content` varchar(20) NOT NULL, 
  `contacts` varchar(20) NOT NULL, 
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
  `available` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  `description` varchar(50) DEFAULT NULL, 
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  


DROP TABLE IF EXISTS `w_permission`;  
CREATE TABLE `w_permission` (  
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `role_id` int(11), 
  `token` varchar(20) NOT NULL, 
  `url` varchar(20) NOT NULL, 
  `available` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  `description` varchar(50) DEFAULT NULL, 
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
values('rose', '000000', 0, '玫瑰', 2, 18, '13888888888', 'meigui@qq.com', '华盛顿');
insert into w_user(user_name, password, locked, nick_name, sex, age, phone, email, address)
values('jack', '000000', 0, '杰哥', 1, 18, '13999999999', 'jiege@qq.com', '地狱');
insert into w_user(user_name, password, locked, nick_name, sex, age, phone, email, address)
values('zhangsan', '000000', 0, '张三', 1, 20, '133333333333', 'zhangsan@qq.com', '北京');
insert into w_user(user_name, password, locked, nick_name, sex, age, phone, email, address)
values('lisi', '000000', 0, '李四', 1, 19, '13666666666', 'lisi@qq.com', '天堂');

update w_user set password='483795953644107118hSWGVeDaY3DR3tqOmc0CjA==', salt='[B@6d06d69c' where id = 1;
update w_user set password='99624111433583888GA5w/JyJ+czpf9Ka1pe13g==', salt='[B@7852e922' where id = 2;
update w_user set password='464612057111437064qnLNXxHoB3Fs76NqSZTdoA==', salt='[B@4e25154f' where id = 3;
update w_user set password='6359703777827177Pz6aP2/Xz+KNpLyS8Z2yAg==', salt='[B@70dea4e' where id = 4;

insert into w_message_type(name) values('人找车');
insert into w_message_type(name) values('车找人');
insert into w_message_type(name) values('招聘');
insert into w_message_type(name) values('求职');
insert into w_message_type(name) values('出售');
insert into w_message_type(name) values('购买');
insert into w_message_type(name) values('其他');

insert into w_role(name, available, description) values('普通用户', 1, '普通使用用户所拥有的权限');
insert into w_role(name, available, description) values('管理员', 1, '管理系统用户所拥有的权限');

insert into w_permission(role_id, token, url, available, description) values(1, 'home', '/home', 1, '所有用户有登录的权限');
insert into w_permission(role_id, token, url, available, description) values(1, 'login', '/login', 1, '所有用户有登录的权限');
insert into w_permission(role_id, token, url, available, description) values(2, 'home', '/home', 1, '所有用户有登录的权限');
insert into w_permission(role_id, token, url, available, description) values(2, 'login', '/login', 1, '所有用户有登录的权限');
insert into w_permission(role_id, token, url, available, description) values(2, 'admin', '/admin', 1, '超级管理权限');

insert into w_user_role(user_id, role_id) values(1, 1);
insert into w_user_role(user_id, role_id) values(1, 2);

insert into w_message(content, contacts, user_id, type_id) values ('本人要去兴义', '12333333333', 1, 1);
insert into w_message(content, contacts, user_id, type_id) values ('本人要去兴义', '16633339999', 2, 2);
