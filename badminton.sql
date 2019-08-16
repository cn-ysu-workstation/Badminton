/*
 Navicat Premium Data Transfer

 Source Server         : localhost_mysql6
 Source Server Type    : MySQL
 Source Server Version : 60005
 Source Host           : localhost:3306
 Source Schema         : badmintion

 Target Server Type    : MySQL
 Target Server Version : 60005
 File Encoding         : 65001

 Date: 16/08/2019 16:28:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `administrator_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员真实姓名',
  `phonenumber` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员手机号码',
  PRIMARY KEY (`administrator_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES (1, 'zhangsan', '123', '张三', '155555555');
INSERT INTO `administrator` VALUES (2, 'lisi', '3543', '李四', '13205642315');

-- ----------------------------
-- Table structure for appraisal
-- ----------------------------
DROP TABLE IF EXISTS `appraisal`;
CREATE TABLE `appraisal`  (
  `appraisal_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价ID',
  `user_ID` int(11) NOT NULL COMMENT '用户ID',
  `area_ID` int(11) NOT NULL COMMENT '场地ID',
  `info` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '具体评价',
  `app_status` int(2) NOT NULL DEFAULT 0 COMMENT '0代表好评 1代表差评',
  `app_time` date NOT NULL COMMENT '评价时间',
  PRIMARY KEY (`appraisal_ID`) USING BTREE,
  INDEX `用户ID外键`(`user_ID`) USING BTREE,
  INDEX `场地外键`(`area_ID`) USING BTREE,
  CONSTRAINT `用户ID外键` FOREIGN KEY (`user_ID`) REFERENCES `user` (`user_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `场地外键` FOREIGN KEY (`area_ID`) REFERENCES `area` (`area_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of appraisal
-- ----------------------------
INSERT INTO `appraisal` VALUES (1, 1, 1, '场地挺好的', 0, '2019-08-05');

-- ----------------------------
-- Table structure for appraisalpic
-- ----------------------------
DROP TABLE IF EXISTS `appraisalpic`;
CREATE TABLE `appraisalpic`  (
  `apppic_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价-图片ID',
  `appraisal_ID` int(11) NOT NULL COMMENT '评价ID',
  `pic` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '对应的图片信息',
  PRIMARY KEY (`apppic_ID`) USING BTREE,
  INDEX `评价ID外键`(`appraisal_ID`) USING BTREE,
  CONSTRAINT `评价ID外键` FOREIGN KEY (`appraisal_ID`) REFERENCES `appraisal` (`appraisal_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of appraisalpic
-- ----------------------------
INSERT INTO `appraisalpic` VALUES (1, 1, '');

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (
  `area_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '场地ID',
  `areaname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '场地名称',
  `price` decimal(10, 2) NOT NULL DEFAULT 20.00 COMMENT '价格',
  `des` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '具体描述',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '紫苑社区羽毛球馆' COMMENT '地址',
  `starttime` int(3) NOT NULL DEFAULT 8 COMMENT '营业开始时间',
  `stoptime` int(11) NOT NULL DEFAULT 22 COMMENT '营业截止时间',
  `profit` decimal(10, 0) NOT NULL COMMENT '总盈利',
  `good_num` int(11) NOT NULL DEFAULT 0 COMMENT '好评数',
  `bad_num` int(11) NOT NULL DEFAULT 0 COMMENT '差评数',
  `good_rate` decimal(5, 2) NOT NULL DEFAULT 0.00 COMMENT '好评率',
  PRIMARY KEY (`area_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES (1, '1场', 20.00, '老球场', '紫苑社区羽毛球馆', 8, 22, 0, 91, 9, 91.00);

-- ----------------------------
-- Table structure for areapic
-- ----------------------------
DROP TABLE IF EXISTS `areapic`;
CREATE TABLE `areapic`  (
  `areapic_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价-图片ID',
  `area_ID` int(11) NOT NULL COMMENT '评价ID',
  `pic` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片信息',
  PRIMARY KEY (`areapic_ID`) USING BTREE,
  INDEX `场地外键1`(`area_ID`) USING BTREE,
  CONSTRAINT `场地外键1` FOREIGN KEY (`area_ID`) REFERENCES `area` (`area_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of areapic
-- ----------------------------
INSERT INTO `areapic` VALUES (1, 1, '');

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation`  (
  `reservation_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '预订ID',
  `area_ID` int(11) NOT NULL COMMENT '场地ID',
  `user_ID` int(11) NOT NULL COMMENT '用户ID',
  `pre_date` date NOT NULL COMMENT '预订日期',
  `starttime` int(3) NOT NULL COMMENT '开始时间',
  `stoptime` int(3) NOT NULL COMMENT '截止时间',
  `pre_status` int(2) NOT NULL DEFAULT 0 COMMENT '预订状态(0表示待审核 1表示审核通过 2表示使用中 3表示已取消/过期)',
  PRIMARY KEY (`reservation_ID`) USING BTREE,
  INDEX `会员ID外键1`(`user_ID`) USING BTREE,
  INDEX `场地外键2`(`area_ID`) USING BTREE,
  CONSTRAINT `场地外键2` FOREIGN KEY (`area_ID`) REFERENCES `area` (`area_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `会员ID外键1` FOREIGN KEY (`user_ID`) REFERENCES `user` (`user_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation` VALUES (1, 1, 1, '2019-08-08', 14, 16, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_ID` int(11) NOT NULL COMMENT '用户ID',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '会员用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '会员密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '会员真实姓名',
  `sex` int(2) NOT NULL COMMENT '性别(0表示男性 1表示女性)',
  `phonenumber` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号码',
  `price_status` int(2) NOT NULL DEFAULT 0 COMMENT '会员的身份(0表示普通会员，1表示高级会员)',
  `user_pic` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '会员的头像信息(也可以没有)',
  `del_status` int(2) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段(0表示没有逻辑删除，1表示已逻辑删除)',
  PRIMARY KEY (`user_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'wangwu', '123', '王五', 1, '14326879468', 1, '', 0);

SET FOREIGN_KEY_CHECKS = 1;
