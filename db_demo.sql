/*
Navicat MySQL Data Transfer

Source Server         : mydemo
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : db_demo

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-14 20:16:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `user_age` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('2', '\"??\"', '23');
INSERT INTO `tb_user` VALUES ('3', '??', '26');
INSERT INTO `tb_user` VALUES ('4', '\"??\"', '23');
INSERT INTO `tb_user` VALUES ('5', '??', '23');
INSERT INTO `tb_user` VALUES ('6', 'swedne', '25');
