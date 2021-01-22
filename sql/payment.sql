/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50645
 Source Host           : localhost:3306
 Source Schema         : springcloud-2020

 Target Server Type    : MySQL
 Target Server Version : 50645
 File Encoding         : 65001

 Date: 22/01/2021 15:58:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `id` bigint(20) NOT NULL,
  `serial` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES (1, 'zhangheng');
INSERT INTO `payment` VALUES (2, 'xiaozhang');
INSERT INTO `payment` VALUES (3, 'lisi');
INSERT INTO `payment` VALUES (4, 'wangwu');
INSERT INTO `payment` VALUES (5, 'xiaoli');
INSERT INTO `payment` VALUES (6, 'fengxiaogang');
INSERT INTO `payment` VALUES (10, 'xijinping');

SET FOREIGN_KEY_CHECKS = 1;
