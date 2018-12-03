/*
 Navicat MySQL Data Transfer

 Source Server         : 本地连接
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : ShiYan

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 02/12/2018 19:23:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `username` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `psd` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES ('admin', 'admin');
COMMIT;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk1` FOREIGN KEY (`id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of score
-- ----------------------------
BEGIN;
INSERT INTO `score` VALUES ('201601', 30);
INSERT INTO `score` VALUES ('201602', 10);
INSERT INTO `score` VALUES ('201603', 20);
INSERT INTO `score` VALUES ('201604', 20);
INSERT INTO `score` VALUES ('201605', 30);
INSERT INTO `score` VALUES ('201613', 0);
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `psd` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('201601', '李浩楠', '123');
INSERT INTO `student` VALUES ('201602', '李浩楠', '123');
INSERT INTO `student` VALUES ('201603', '刘官山', '123');
INSERT INTO `student` VALUES ('201604', '李浩楠', '123');
INSERT INTO `student` VALUES ('201605', '严旭', '123456');
INSERT INTO `student` VALUES ('201613', '李浩楠', '123');
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES (1, '李浩楠', '123');
INSERT INTO `users` VALUES (2, 'sjq', '123');
INSERT INTO `users` VALUES (3, 'yy', 'yy');
INSERT INTO `users` VALUES (4, '唐浩诚', '123');
INSERT INTO `users` VALUES (5, '罗心如', '123');
INSERT INTO `users` VALUES (6, '罗心如', '123');
COMMIT;

-- ----------------------------
-- View structure for scorelist
-- ----------------------------
DROP VIEW IF EXISTS `scorelist`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `scorelist` AS select `student`.`id` AS `id`,`student`.`name` AS `name`,`score`.`score` AS `score` from (`student` join `score`) where (`student`.`id` = `score`.`id`);

SET FOREIGN_KEY_CHECKS = 1;
