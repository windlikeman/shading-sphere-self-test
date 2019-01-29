/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : yue_life_1001

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-01-29 10:33:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id_device` bigint(18) NOT NULL COMMENT '设备id',
  `id_room` bigint(18) DEFAULT NULL COMMENT '房间id',
  `community_number` bigint(18) DEFAULT NULL COMMENT '小区编号',
  `device_name` varchar(45) DEFAULT NULL COMMENT '设备名',
  `device_number` varchar(45) DEFAULT NULL COMMENT '设备号',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `update_time` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id_device`),
  UNIQUE KEY `id_device_UNIQUE` (`id_device`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备';

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id_room` bigint(18) NOT NULL,
  `id_community` bigint(18) DEFAULT NULL,
  `community_number` int(4) DEFAULT NULL COMMENT '社区编号，用于分表',
  `id_user` bigint(18) DEFAULT NULL,
  `building_number` varchar(45) DEFAULT NULL,
  `building_floor` varchar(45) DEFAULT NULL,
  `room_number` varchar(45) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `modify_time` date DEFAULT NULL,
  PRIMARY KEY (`id_room`),
  UNIQUE KEY `id_UNIQUE` (`id_room`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房间';
