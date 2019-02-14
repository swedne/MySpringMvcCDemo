/*
 Navicat Premium Data Transfer

 Source Server         : mytest
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : db_demo

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 14/02/2019 17:56:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_age` int(255) NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户密码',
  `token` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (33, NULL, NULL, '18850542631', '123456', 'd085d429-f11a-4572-b725-78347fe56185');
INSERT INTO `tb_user` VALUES (34, NULL, NULL, '18850542632', '123456', 'e99e5df4-808a-4cda-bbfc-ac0b82d72fa1');
INSERT INTO `tb_user` VALUES (35, NULL, NULL, '18850542633', '123456', '125f6c4a-3eab-47a5-90db-0337f733cbc4');
INSERT INTO `tb_user` VALUES (36, NULL, NULL, '18850542636', '123456', '6b4f8bea-beeb-4f00-a5d7-4acd9b3d19ab');
INSERT INTO `tb_user` VALUES (37, NULL, NULL, '18850542637', '123456', 'a74f074b-be5f-4b26-b20f-0bc961289a2b');
INSERT INTO `tb_user` VALUES (38, NULL, NULL, '18850542638', '123456', '95104658-d20e-416d-8e3d-e21145f78c2d');
INSERT INTO `tb_user` VALUES (39, NULL, NULL, '18850542639', '123456', '3af61f34-03c1-45d4-b93b-b143155d5bf3');
INSERT INTO `tb_user` VALUES (40, NULL, NULL, '18850542630', '123456', '3c73a1f6-9de0-4e1b-880b-d3f3373103d3');
INSERT INTO `tb_user` VALUES (41, NULL, NULL, '18850542640', '123456', 'e6714217-8bd6-4be8-8515-7cd54ca93080');
INSERT INTO `tb_user` VALUES (42, NULL, NULL, '18850542641', '123456', 'd1bc4831-9270-4de9-91ad-b632a58fa6b9');
INSERT INTO `tb_user` VALUES (43, NULL, NULL, '18850542642', '123456', '4698390d-3336-4d54-bc0d-a900339439b1');
INSERT INTO `tb_user` VALUES (44, NULL, NULL, '18850542643', '123456', '93642608-e224-4d45-9017-aee5bd4af345');

SET FOREIGN_KEY_CHECKS = 1;
