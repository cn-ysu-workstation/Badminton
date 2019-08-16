/*
 Navicat Premium Data Transfer

 Source Server         : joker_tianjin
 Source Server Type    : MySQL
 Source Server Version : 60005
 Source Host           : localhost:3306
 Source Schema         : badminton

 Target Server Type    : MySQL
 Target Server Version : 60005
 File Encoding         : 65001

 Date: 16/08/2019 11:07:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `administrator_ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `phonenumber` varchar(100) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`administrator_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES (1, 'zhangsan', '123', '张三', '155555555');

-- ----------------------------
-- Table structure for appraisal
-- ----------------------------
DROP TABLE IF EXISTS `appraisal`;
CREATE TABLE `appraisal`  (
  `appraisal_ID` int(11) NOT NULL AUTO_INCREMENT,
  `user_ID` int(11) NULL DEFAULT NULL,
  `area_ID` int(11) NULL DEFAULT NULL,
  `info` text CHARACTER SET gbk COLLATE gbk_chinese_ci NULL,
  `app_status` int(2) NULL DEFAULT NULL,
  `app_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`appraisal_ID`) USING BTREE,
  INDEX `用户ID外键`(`user_ID`) USING BTREE,
  INDEX `场地ID外键`(`area_ID`) USING BTREE,
  CONSTRAINT `用户ID外键` FOREIGN KEY (`user_ID`) REFERENCES `user` (`user_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `场地ID外键` FOREIGN KEY (`area_ID`) REFERENCES `area` (`area_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for appraisalpic
-- ----------------------------
DROP TABLE IF EXISTS `appraisalpic`;
CREATE TABLE `appraisalpic`  (
  `apppic_ID` int(11) NOT NULL AUTO_INCREMENT,
  `appraisal_ID` int(11) NULL DEFAULT NULL,
  `pic` varchar(512) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`apppic_ID`) USING BTREE,
  INDEX `评价ID外键`(`appraisal_ID`) USING BTREE,
  CONSTRAINT `评价ID外键` FOREIGN KEY (`appraisal_ID`) REFERENCES `appraisal` (`appraisal_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (
  `area_ID` int(11) NOT NULL AUTO_INCREMENT,
  `areaname` varchar(50) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `price` decimal(10, 1) NULL DEFAULT NULL,
  `des` text CHARACTER SET gbk COLLATE gbk_chinese_ci NULL,
  `address` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `starttime` int(3) NULL DEFAULT NULL,
  `stoptime` int(3) NULL DEFAULT NULL,
  `profit` decimal(10, 1) NULL DEFAULT NULL,
  `good_num` int(10) NULL DEFAULT NULL,
  `bad_num` int(10) NULL DEFAULT NULL,
  `good_rate` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`area_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact STORAGE DISK;

-- ----------------------------
-- Table structure for areapic
-- ----------------------------
DROP TABLE IF EXISTS `areapic`;
CREATE TABLE `areapic`  (
  `areapic_ID` int(11) NOT NULL AUTO_INCREMENT,
  `area_ID` int(11) NULL DEFAULT NULL,
  `pic` varchar(512) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`areapic_ID`) USING BTREE,
  INDEX `场地ID外键1`(`area_ID`) USING BTREE,
  CONSTRAINT `场地ID外键1` FOREIGN KEY (`area_ID`) REFERENCES `area` (`area_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation`  (
  `reservation_ID` int(11) NOT NULL AUTO_INCREMENT,
  `area_ID` int(11) NULL DEFAULT NULL,
  `user_ID` int(11) NULL DEFAULT NULL,
  `pre_date` date NULL DEFAULT NULL,
  `starttime` int(3) NULL DEFAULT NULL,
  `stoptime` int(3) NULL DEFAULT NULL,
  `pre_status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`reservation_ID`) USING BTREE,
  INDEX `会员ID外键1`(`user_ID`) USING BTREE,
  INDEX `场地ID外键2`(`area_ID`) USING BTREE,
  CONSTRAINT `场地ID外键2` FOREIGN KEY (`area_ID`) REFERENCES `area` (`area_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `会员ID外键1` FOREIGN KEY (`user_ID`) REFERENCES `user` (`user_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_ID` int(11) NOT NULL,
  `username` varchar(32) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `sex` int(2) NULL DEFAULT NULL,
  `phonenumber` varchar(100) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `price_status` int(2) NULL DEFAULT NULL,
  `user_pic` varchar(512) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`user_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
