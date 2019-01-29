/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : yue_life_center

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-01-29 10:34:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for community
-- ----------------------------
DROP TABLE IF EXISTS `community`;
CREATE TABLE `community` (
  `id_community` bigint(18) NOT NULL,
  `community_number` int(4) DEFAULT NULL COMMENT '社区编号 用于分库',
  `name` varchar(45) DEFAULT NULL COMMENT '小区名字',
  `address` varchar(45) DEFAULT NULL COMMENT '小区地址',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `modify_time` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id_community`),
  UNIQUE KEY `id_UNIQUE` (`id_community`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='社区';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id_user` bigint(18) NOT NULL,
  `community_number` int(4) DEFAULT NULL COMMENT '社区编号，用于租户',
  `phone_number` bigint(11) DEFAULT NULL COMMENT '电话',
  `user_name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL COMMENT '用户密码',
  `status` varchar(1) DEFAULT NULL COMMENT '0，可用 1不可用',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `update_time` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `id_user_UNIQUE` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
