/*
 Navicat Premium Data Transfer

 Source Server         : 19ZRshixun
 Source Server Type    : MySQL
 Source Server Version : 60005
 Source Host           : localhost:3306
 Source Schema         : badminton

 Target Server Type    : MySQL
 Target Server Version : 60005
 File Encoding         : 65001

 Date: 14/03/2020 22:37:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `administrator_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员真实姓名',
  `phonenumber` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员手机号码',
  PRIMARY KEY (`administrator_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES (1, 'zhangsan', '123', '张三', '155555555');

-- ----------------------------
-- Table structure for appraisal
-- ----------------------------
DROP TABLE IF EXISTS `appraisal`;
CREATE TABLE `appraisal`  (
  `appraisal_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价ID',
  `user_ID` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `area_ID` int(11) NULL DEFAULT NULL COMMENT '场地ID',
  `info` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '具体评价',
  `app_status` int(2) NULL DEFAULT NULL COMMENT '评价是好评还是差评(0代表好评 1代表差评)',
  `app_time` date NULL DEFAULT NULL COMMENT '评价的时间',
  PRIMARY KEY (`appraisal_ID`) USING BTREE,
  INDEX `用户ID外键`(`user_ID`) USING BTREE,
  INDEX `场地外键`(`area_ID`) USING BTREE,
  CONSTRAINT `用户ID外键` FOREIGN KEY (`user_ID`) REFERENCES `user` (`user_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `场地外键` FOREIGN KEY (`area_ID`) REFERENCES `area` (`area_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of appraisal
-- ----------------------------
INSERT INTO `appraisal` VALUES (5, 2, 2, '这是一个好评模板，因为小哥哥比较懒，不想每个产品都一一评价，所以特意模仿其他淘友写下了这个评价模板。每次买东西我都会根据价格，质量和评价进行参考，最后选择我满意的一家，所以我购买的这一家在我所挑选范围内是性价比最高的。所以当你看见这个评价时证明这家商品很符合我的标准，我觉得很满意。我只是有些懒但是我很诚实，如果质量不好的话我是会直接退货或者长长的吐槽来发泄我的不满。来自一位慵懒的，只爱购物不爱评价，却还想得积分的小哥哥。 ', 1, '2019-08-21');
INSERT INTO `appraisal` VALUES (6, 2, 2, '场地特别好，我们玩得很尽兴~~~', 1, '2019-08-26');
INSERT INTO `appraisal` VALUES (7, 3, 2, '由于天气原因，场地不是很适合打羽毛球，算是自己倒霉吧，但是场馆也有错误，因该给我半价的！！！', 0, '2019-08-27');

-- ----------------------------
-- Table structure for appraisalpic
-- ----------------------------
DROP TABLE IF EXISTS `appraisalpic`;
CREATE TABLE `appraisalpic`  (
  `apppic_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `appraisal_ID` int(11) NULL DEFAULT NULL COMMENT '评价的ID',
  `pic` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应的图片信息',
  PRIMARY KEY (`apppic_ID`) USING BTREE,
  INDEX `评价ID外键`(`appraisal_ID`) USING BTREE,
  CONSTRAINT `评价ID外键` FOREIGN KEY (`appraisal_ID`) REFERENCES `appraisal` (`appraisal_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of appraisalpic
-- ----------------------------
INSERT INTO `appraisalpic` VALUES (1, 5, 'group1/M00/00/00/rBBUD11iJoGAR9veAAK_z8ND57k206.jpg');
INSERT INTO `appraisalpic` VALUES (2, 6, 'group1/M00/00/00/rBBUD11iJoGACBn_AAcNFXzV8PE771.jpg');
INSERT INTO `appraisalpic` VALUES (3, 6, 'group1/M00/00/00/rBBUD11iJoyAEakFAAROa8gelmI058.jpg');
INSERT INTO `appraisalpic` VALUES (4, 7, 'group1/M00/00/00/rBBUD11iJqSAZCmaAAYAzx_CsH8318.jpg');

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (
  `area_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '场地ID',
  `areaname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '场地名称',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `des` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '具体描述',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `starttime` int(3) NULL DEFAULT NULL COMMENT '营业的开始时间',
  `stoptime` int(11) NULL DEFAULT NULL COMMENT '营业的截止时间',
  `profit` decimal(10, 0) NULL DEFAULT NULL COMMENT '总盈利',
  `good_num` int(3) NULL DEFAULT NULL COMMENT '好评数',
  `bad_num` int(3) NULL DEFAULT NULL COMMENT '差评数',
  `good_rate` int(3) NULL DEFAULT NULL COMMENT '好评率',
  PRIMARY KEY (`area_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES (1, '一号场地123', 700.00, '塑胶场地123', '吨吨吨123', 9, 20, 0, 0, 0, 0);
INSERT INTO `area` VALUES (2, '二号场地123', 200.00, '塑胶场地', '天津市雨湖区', 8, 21, 0, 0, 0, 0);
INSERT INTO `area` VALUES (3, '三号场地', 300.00, '塑胶场地', '天津市雨湖区', 8, 21, 0, 0, 0, 0);
INSERT INTO `area` VALUES (4, '四号场地', 700.00, '塑胶场地', '天津市雨湖区', 8, 21, 0, 0, 0, 0);
INSERT INTO `area` VALUES (5, '五号场地', 100.00, '木地板', '天津市雨湖区', 8, 21, 0, 0, 0, 0);
INSERT INTO `area` VALUES (6, '六号场地', 100.00, '木地板', '天津市雨湖区', 8, 21, 0, 0, 0, 0);
INSERT INTO `area` VALUES (7, '七号场地', 100.00, '木地板', '天津市雨湖区', 8, 21, 0, 0, 0, 0);
INSERT INTO `area` VALUES (8, '八号场地', 20.00, '木地板', '燕山大学西校区', 8, 21, 0, 0, 0, 0);
INSERT INTO `area` VALUES (9, '九号场地', 100.00, '塑胶地板', '燕山大学西校区', 8, 20, 0, 0, 0, 0);
INSERT INTO `area` VALUES (10, '十号场地', 80.00, '木地板', '燕山大学西校区', 8, 21, 0, 0, 0, 0);
INSERT INTO `area` VALUES (11, '十一号场地', 100.00, '燕山大学', '燕山大学西校区', 8, 20, 0, 0, 0, 0);
INSERT INTO `area` VALUES (22, '十四号场地1', 123.00, '1233', '燕山大学西校区1', 7, 19, 0, 0, 0, 0);
INSERT INTO `area` VALUES (23, '十九号场地', 123.00, '萨达', '燕山大学西校区', 8, 20, 0, 0, 0, 0);
INSERT INTO `area` VALUES (33, '紫云山一号场地', 999.00, '有档次超好看', '看不见的紫云山', 3, 11, 0, 0, 0, 0);
INSERT INTO `area` VALUES (99, '99', 9.00, '9', '9', 9, 9, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for areapic
-- ----------------------------
DROP TABLE IF EXISTS `areapic`;
CREATE TABLE `areapic`  (
  `areapic_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `area_ID` int(11) NULL DEFAULT NULL COMMENT '场地的ID',
  `pic` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '场地对应的图片信息',
  PRIMARY KEY (`areapic_ID`) USING BTREE,
  INDEX `场地外键1`(`area_ID`) USING BTREE,
  CONSTRAINT `场地外键1` FOREIGN KEY (`area_ID`) REFERENCES `area` (`area_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of areapic
-- ----------------------------
INSERT INTO `areapic` VALUES (41, 2, 'group1/M00/00/00/rBBUD11iJoyAEakFAAROa8gelmI058.jpg');
INSERT INTO `areapic` VALUES (42, 2, 'group1/M00/00/00/rBBUD11iJoyAEFoPAAGmENfdcLU487.jpg');
INSERT INTO `areapic` VALUES (43, 3, 'group1/M00/00/00/rBBUD11iJpiAX3GvAABttY4WStU362.jpg');
INSERT INTO `areapic` VALUES (44, 3, 'group1/M00/00/00/rBBUD11iJpiACa9TAAYAzx_CsH8507.jpg');
INSERT INTO `areapic` VALUES (45, 4, 'group1/M00/00/00/rBBUD11iJqOAOKanAABttY4WStU565.jpg');
INSERT INTO `areapic` VALUES (46, 4, 'group1/M00/00/00/rBBUD11iJqSAZCmaAAYAzx_CsH8318.jpg');
INSERT INTO `areapic` VALUES (47, 5, 'group1/M00/00/00/rBBUD11iJq6AUqp6AACCOBk8v3U468.jpg');
INSERT INTO `areapic` VALUES (48, 5, 'group1/M00/00/00/rBBUD11iJq6ANxhbAACOHrANkwE892.jpg');
INSERT INTO `areapic` VALUES (49, 6, 'group1/M00/00/00/rBBUD11iJruAdQC7AACL30Me7g0791.jpg');
INSERT INTO `areapic` VALUES (50, 6, 'group1/M00/00/00/rBBUD11iJruAD40pAABxFfU4myA268.jpg');
INSERT INTO `areapic` VALUES (51, 6, 'group1/M00/00/00/rBBUD11iJruAOTdkAAK_z8ND57k071.jpg');
INSERT INTO `areapic` VALUES (52, 22, 'group1/M00/00/00/rBBUD11iJsWAUNbyAAGmENfdcLU939.jpg');
INSERT INTO `areapic` VALUES (53, 23, 'group1/M00/00/00/rBBUD11iJtKAPxTSAAYAzx_CsH8335.jpg');
INSERT INTO `areapic` VALUES (54, 23, 'group1/M00/00/00/rBBUD11iJtKAHP3JAAROa8gelmI728.jpg');
INSERT INTO `areapic` VALUES (55, 7, 'group1/M00/00/00/rBBUD11iJueATRtsAAROa8gelmI086.jpg');
INSERT INTO `areapic` VALUES (56, 8, 'group1/M00/00/00/rBBUD11iJvCAAFBoAABxFfU4myA767.jpg');
INSERT INTO `areapic` VALUES (57, 9, 'group1/M00/00/00/rBBUD11iJveAV75WAACCOBk8v3U150.jpg');
INSERT INTO `areapic` VALUES (58, 10, 'group1/M00/00/00/rBBUD11iJv6ADAfwAACL30Me7g0770.jpg');
INSERT INTO `areapic` VALUES (59, 10, 'group1/M00/00/00/rBBUD11iJv6AQ332AAYAzx_CsH8307.jpg');
INSERT INTO `areapic` VALUES (60, 11, 'group1/M00/00/00/rBBUD11iJwaAWs6yAACL30Me7g0292.jpg');
INSERT INTO `areapic` VALUES (61, 11, 'group1/M00/00/00/rBBUD11iJweAUlXOAAcNFXzV8PE954.jpg');
INSERT INTO `areapic` VALUES (62, 33, 'group1/M00/00/00/rBBUD11j7HiADGTYAACFLuMPecM158.jpg');
INSERT INTO `areapic` VALUES (63, 33, 'group1/M00/00/00/rBBUD11j7HiAeMotAABqvKsK3tg622.jpg');
INSERT INTO `areapic` VALUES (64, 1, 'group1/M00/00/00/rBBUD11j7LCAcs3rAABqvKsK3tg762.jpg');

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation`  (
  `reservation_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '预订ID',
  `area_ID` int(11) NULL DEFAULT NULL COMMENT '场地ID',
  `user_ID` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `pre_date` date NULL DEFAULT NULL COMMENT '预订的日期',
  `starttime` int(3) NULL DEFAULT NULL COMMENT '开始时间',
  `stoptime` int(3) NULL DEFAULT NULL COMMENT '截止时间',
  `pre_status` int(2) NULL DEFAULT NULL COMMENT '预订的状态(0表示待审核1表示审核成功)',
  `primarykry` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单实际的唯一标识',
  PRIMARY KEY (`reservation_ID`) USING BTREE,
  INDEX `会员ID外键1`(`user_ID`) USING BTREE,
  INDEX `场地外键2`(`area_ID`) USING BTREE,
  CONSTRAINT `场地外键2` FOREIGN KEY (`area_ID`) REFERENCES `area` (`area_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `会员ID外键1` FOREIGN KEY (`user_ID`) REFERENCES `user` (`user_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation` VALUES (1, 3, 2, '2019-08-21', 8, 11, 1, NULL);
INSERT INTO `reservation` VALUES (2, 3, 2, '2019-08-21', 13, 18, 1, NULL);
INSERT INTO `reservation` VALUES (5, 2, 1, '2019-08-24', 8, 9, -1, '2019-08-21 18:45:07');
INSERT INTO `reservation` VALUES (6, 2, 1, '2019-08-25', 8, 9, 1, '2019-08-22 18:45:07');
INSERT INTO `reservation` VALUES (7, 3, 2, '2019-08-22', 7, 8, -1, NULL);
INSERT INTO `reservation` VALUES (8, 3, 1, '2019-08-07', 8, 10, 1, NULL);
INSERT INTO `reservation` VALUES (9, 2, 4, '2019-08-29', 6, 11, 1, NULL);
INSERT INTO `reservation` VALUES (10, 4, 4, '2019-08-29', 6, 11, 1, NULL);
INSERT INTO `reservation` VALUES (11, 4, 1, '2019-08-22', 11, 12, 2, NULL);
INSERT INTO `reservation` VALUES (12, 4, 2, '2019-08-20', 8, 10, 1, NULL);
INSERT INTO `reservation` VALUES (13, 4, 1, '2019-08-20', 11, 12, 1, NULL);
INSERT INTO `reservation` VALUES (14, 3, 3, '2019-08-16', 14, 17, 1, NULL);
INSERT INTO `reservation` VALUES (15, 3, 1, '2019-08-16', 10, 12, -1, NULL);
INSERT INTO `reservation` VALUES (16, 3, 2, '2019-08-16', 10, 12, 1, NULL);
INSERT INTO `reservation` VALUES (17, 3, 1, '2019-08-16', 10, 12, 0, NULL);
INSERT INTO `reservation` VALUES (18, 2, 3, '2019-08-19', 8, 10, 1, NULL);
INSERT INTO `reservation` VALUES (19, 3, 1, '2019-08-19', 13, 15, 1, NULL);
INSERT INTO `reservation` VALUES (20, 2, 5, '2019-08-24', 7, 9, 1, NULL);
INSERT INTO `reservation` VALUES (21, 3, 2, '2019-08-21', 6, 7, 1, NULL);
INSERT INTO `reservation` VALUES (22, 5, 3, '2019-08-13', 7, 9, -1, NULL);
INSERT INTO `reservation` VALUES (24, 2, 2, '2019-08-02', 8, 12, -1, NULL);
INSERT INTO `reservation` VALUES (25, 2, 1, '2019-08-21', 16, 20, -1, NULL);
INSERT INTO `reservation` VALUES (26, 3, 3, '2019-08-21', 16, 20, 1, NULL);
INSERT INTO `reservation` VALUES (27, 4, 1, '2019-08-21', 16, 20, 2, NULL);
INSERT INTO `reservation` VALUES (28, 4, 2, '2019-08-22', 8, 10, 0, NULL);
INSERT INTO `reservation` VALUES (29, 3, 1, '2019-08-22', 8, 9, 1, NULL);
INSERT INTO `reservation` VALUES (30, 5, 3, '2019-08-25', 9, 10, 1, '2019-08-26 22:07:13');
INSERT INTO `reservation` VALUES (31, 5, 3, '2019-08-25', 10, 11, 1, '2019-08-26 22:07:13');
INSERT INTO `reservation` VALUES (32, 5, 3, '2019-08-25', 11, 12, 1, '2019-08-26 22:07:13');
INSERT INTO `reservation` VALUES (33, 3, 18, '2019-08-25', 10, 11, 1, '2019-08-26 22:19:56');
INSERT INTO `reservation` VALUES (34, 3, 18, '2019-08-25', 11, 12, 1, '2019-08-26 22:19:56');
INSERT INTO `reservation` VALUES (35, 3, 18, '2019-08-25', 12, 13, 1, '2019-08-26 22:19:56');
INSERT INTO `reservation` VALUES (36, 3, 18, '2019-08-25', 13, 14, 1, '2019-08-26 22:19:56');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员的真是姓名',
  `sex` int(2) NULL DEFAULT NULL COMMENT '性别',
  `phonenumber` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `price_status` int(2) NULL DEFAULT NULL COMMENT '会员的身份(0表示普通会员 1表示高级会员)',
  `user_pic` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员的头像信息(也可以没有)',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '逻辑删除字段判断',
  PRIMARY KEY (`user_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhangyiyi', 'test123', '张一一123', 1, '15930599712', 0, NULL, 1);
INSERT INTO `user` VALUES (2, 'zhanger', '321', '张二', 0, '122123', 0, NULL, 0);
INSERT INTO `user` VALUES (3, '123', '123', '王二狗', 0, '15930599703', 1, NULL, 0);
INSERT INTO `user` VALUES (4, 'wqdq', '1231314', '王呵呵', 0, '15930599674', 0, NULL, 1);
INSERT INTO `user` VALUES (5, 'hhhh', '9999', '张大大哦哦', 0, '15839461234', 0, NULL, 0);
INSERT INTO `user` VALUES (6, 'hahhah', '1234567', '李二二嗷嗷', 1, '15984755977', 1, NULL, 0);
INSERT INTO `user` VALUES (7, 'aafq', '123123', '李狗子', 1, '15849306653', 1, NULL, 1);
INSERT INTO `user` VALUES (8, '1234adsa', '123', '张全蛋', 1, '15930545673', 1, NULL, 0);
INSERT INTO `user` VALUES (9, 'duyanhui123', '12345', '王富贵', 0, '15930599807', 0, NULL, 0);
INSERT INTO `user` VALUES (10, '123', '123', '王二狗', 0, '15930599703', 1, NULL, 0);
INSERT INTO `user` VALUES (11, '123', '123', '王二狗狗', 0, '15930599703', 1, NULL, 0);
INSERT INTO `user` VALUES (12, 'hahahah123', '1231111', '王二狗狗狗er', 0, '15930599996', 1, NULL, 0);
INSERT INTO `user` VALUES (13, 'ads', '13', '123', 1, '1', 1, NULL, 1);
INSERT INTO `user` VALUES (14, 'lllaaa', 'lllaaa', '啦', NULL, '15837486925', NULL, NULL, NULL);
INSERT INTO `user` VALUES (15, 'lllaaa', 'lllaaa', '啦', NULL, '15837486925', NULL, NULL, NULL);
INSERT INTO `user` VALUES (16, '1234', '123', '123', NULL, '15837486925', NULL, NULL, NULL);
INSERT INTO `user` VALUES (17, '12', '12', '12', NULL, '15837486925', NULL, NULL, NULL);
INSERT INTO `user` VALUES (18, '123456', '123456', '张铁蛋', NULL, '15837486925', NULL, NULL, NULL);
INSERT INTO `user` VALUES (19, 'bonc', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
