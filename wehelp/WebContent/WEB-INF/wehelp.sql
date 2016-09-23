--创建用户表
DROP TABLE IF EXISTS `w_user`;  
CREATE TABLE `w_user` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `user_name` varchar(20) NOT NULL, 
  `password` varchar(20) NOT NULL,
  `nick_name` varchar(20),
  `sex` int(2) DEFAULT '0',  
  `age` int(3) DEFAULT '0', 
  `phone` int(11),
  `email`  varchar(30),  
  `address`  varchar(30),
  `register_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  

--创建信息类型表
DROP TABLE IF EXISTS `w_message_type`;  
CREATE TABLE `w_message_type` (  
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `type_name` varchar(20) NOT NULL, 
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  

--创建信息表
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

--插入实验数据
insert into w_user(user_name, password, nick_name, sex, age, phone, email, address)
values('rose', 'rose123', '玫瑰', 2, 18, 13888888888, 'meigui@qq.com', '华盛顿');
insert into w_user(user_name, password, nick_name, sex, age, phone, email, address)
values('jack', 'jack123', '杰哥', 1, 18, 13999999999, 'jiege@qq.com', '地狱');
insert into w_user(user_name, password, nick_name, sex, age, phone, email, address)
values('zhangsan', 'zhangsan123', '张三', 1, 20, 133333333333, 'zhangsan@qq.com', '北京');
insert into w_user(user_name, password, nick_name, sex, age, phone, email, address)
values('lisi', 'lisi123', '李四', 1, 19, 13666666666, 'lisi@qq.com', '天堂');

insert into w_message_type(type_name) values('人找车');
insert into w_message_type(type_name) values('车找人');
insert into w_message_type(type_name) values('招聘');
insert into w_message_type(type_name) values('求职');
insert into w_message_type(type_name) values('出售');
insert into w_message_type(type_name) values('购买');


insert into w_message(content, contacts, user_id, type_id) values ('本人要去兴义', '12333333333', 1, 1);
insert into w_message(content, contacts, user_id, type_id) values ('本人要去兴义', '16633339999', 2, 2);
