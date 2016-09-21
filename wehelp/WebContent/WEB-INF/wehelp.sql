DROP TABLE IF EXISTS `w_user`;  
CREATE TABLE `w_user` (  
  `id` varchar(38) NOT NULL,  
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

INSERT INTO w_user(id, user_name, password, nick_name, sex, age, phone, email, address) 
VALUES('D57B0151B4B646D4A20B8316A8E0EBC8', '¹Â°Á²ÔÀÇ', 27);