DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_username` varchar(20) NOT NULL,
  `t_password` varchar(8) NOT NULL,
  PRIMARY KEY (`t_id`)
)

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` (t_username,t_password) VALUES ( 'lisi', '123456');
INSERT INTO `t_user` (t_username,t_password) VALUES ( 'wanger', '654321');
INSERT INTO `t_user` (t_username,t_password) VALUES ( '李四', '123123');
INSERT INTO `t_user` (t_username,t_password) VALUES ( '王二', '321321');