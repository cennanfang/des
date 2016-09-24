
DROP TABLE IF EXISTS `w_user`;  
CREATE TABLE `w_user` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `user_name` varchar(20) NOT NULL unique, 
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


DROP TABLE IF EXISTS `w_message_type`;  
CREATE TABLE `w_message_type` (  
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `name` varchar(20) NOT NULL, 
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
  `description` varchar(50), 
  PRIMARY KEY (`id`)  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;  


DROP TABLE IF EXISTS `w_permission`;  
CREATE TABLE `w_permission` (  
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `role_id` int(11), 
  `token` varchar(20) NOT NULL, 
  `url` varchar(20) NOT NULL, 
  `description` varchar(50), 
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


insert into w_user(user_name, password, nick_name, sex, age, phone, email, address)
values('rose', 'rose123', 'õ��', 2, 18, 13888888888, 'meigui@qq.com', '��ʢ��');
insert into w_user(user_name, password, nick_name, sex, age, phone, email, address)
values('jack', 'jack123', '�ܸ�', 1, 18, 13999999999, 'jiege@qq.com', '����');
insert into w_user(user_name, password, nick_name, sex, age, phone, email, address)
values('zhangsan', 'zhangsan123', '����', 1, 20, 133333333333, 'zhangsan@qq.com', '����');
insert into w_user(user_name, password, nick_name, sex, age, phone, email, address)
values('lisi', 'lisi123', '����', 1, 19, 13666666666, 'lisi@qq.com', '����');

insert into w_message_type(name) values('���ҳ�');
insert into w_message_type(name) values('������');
insert into w_message_type(name) values('��Ƹ');
insert into w_message_type(name) values('��ְ');
insert into w_message_type(name) values('����');
insert into w_message_type(name) values('����');
insert into w_message_type(name) values('����');

insert into w_role(name, description) values('��ͨ�û�', '��ͨʹ���û���ӵ�е�Ȩ��');
insert into w_role(name, description) values('����Ա', '����ϵͳ�û���ӵ�е�Ȩ��');

insert into w_user_role(user_id, role_id) values(1, 1);
insert into w_user_role(user_id, role_id) values(1, 2);

insert into w_message(content, contacts, user_id, type_id) values ('����Ҫȥ����', '12333333333', 1, 1);
insert into w_message(content, contacts, user_id, type_id) values ('����Ҫȥ����', '16633339999', 2, 2);
