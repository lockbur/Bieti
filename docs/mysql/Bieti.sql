/*
Navicat MySQL Data Transfer

Source Server         : 123.57.240.11
Source Server Version : 50542
Source Host           : 123.57.240.11:3306
Source Database       : Bieti

Target Server Type    : MYSQL
Target Server Version : 50542
File Encoding         : 65001

Date: 2017-01-06 15:43:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for java_deploy
-- ----------------------------
DROP TABLE IF EXISTS `java_deploy`;
CREATE TABLE `java_deploy` (
  `uuid` varchar(36) NOT NULL COMMENT 'UUID',
  `name` varchar(255) NOT NULL COMMENT '项目名称',
  `profile` varchar(255) DEFAULT NULL COMMENT 'Maven profile',
  `module` varchar(255) NOT NULL COMMENT '模块名称',
  `type` tinyint(4) NOT NULL COMMENT '版本控制工具类型(1.SVN;2.GIT)',
  `url` varchar(255) NOT NULL COMMENT 'svn/git地址',
  `branch` varchar(255) DEFAULT NULL COMMENT 'git branch',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of java_deploy
-- ----------------------------
INSERT INTO `java_deploy` VALUES ('88bf850c-7241-44d0-b73e-aee190eed125', '测试项目', '', '', '2', 'https://github.com/lockbur/Bieti.git', '');

-- ----------------------------
-- Table structure for java_web_deploy
-- ----------------------------
DROP TABLE IF EXISTS `java_web_deploy`;
CREATE TABLE `java_web_deploy` (
  `uuid` varchar(36) NOT NULL COMMENT 'UUID',
  `name` varchar(255) NOT NULL COMMENT '项目名称',
  `profile` varchar(255) DEFAULT NULL COMMENT 'Maven profile',
  `module` varchar(255) NOT NULL COMMENT '模块名称',
  `type` tinyint(4) NOT NULL COMMENT '版本控制工具类型(1.SVN;2.GIT)',
  `url` varchar(255) NOT NULL COMMENT 'svn/git地址',
  `branch` varchar(255) DEFAULT NULL COMMENT 'git branch',
  `context_path` varchar(255) NOT NULL COMMENT 'Web项目contextPath',
  `port` int(11) NOT NULL COMMENT '端口号',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of java_web_deploy
-- ----------------------------

-- ----------------------------
-- Table structure for tb_project
-- ----------------------------
DROP TABLE IF EXISTS `tb_project`;
CREATE TABLE `tb_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(20) NOT NULL COMMENT '项目名称',
  `command` varchar(255) DEFAULT NULL COMMENT '描述信息',
  `created_by` varchar(32) NOT NULL COMMENT '操作者的账号',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '本记录最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='项目表';

-- ----------------------------
-- Records of tb_project
-- ----------------------------
INSERT INTO `tb_project` VALUES ('1', '测试', 'ipconfig', '1', '2017-01-06 15:42:22', '2017-01-06 15:42:22');


DROP TABLE IF EXISTS `tb_app_server`;
CREATE TABLE `tb_app_server` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `address` varchar(20) NOT NULL COMMENT '服务器地址',
  `hostname` varchar(50) DEFAULT NULL COMMENT '主机名称',
  `osName` varchar(32) NOT NULL COMMENT '操作系统名称',
  `created_by` varchar(32) NOT NULL COMMENT '操作者的账号',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '本记录最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='服务器信息';


CREATE TABLE `tb_application` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
   `project_id` bigint(20) NOT NULL COMMENT '所属项目ID',
  `name` varchar(20) NOT NULL COMMENT '项目名称',
  `server` varchar(20) NOT NULL COMMENT '服务器地址',
  `command` varchar(255) DEFAULT NULL COMMENT '执行指令',
  `created_by` varchar(32) NOT NULL COMMENT '操作者的账号',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '本记录最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='应用列表';


CREATE TABLE `tb_deploy_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(20) NOT NULL COMMENT '服务器地址',
  `app_id` bigint(20) DEFAULT NULL COMMENT '应用ID',
  `deployTime` datetime DEFAULT NULL COMMENT '部署时间',
  `created_by` varchar(32) NOT NULL COMMENT '操作者的账号',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '本记录最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='上线任务计划';


CREATE TABLE `tb_instance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `app_server_id` bigint(20) NOT NULL COMMENT '应用ID',
  `address` varchar(20) NOT NULL COMMENT '服务器地址',
  `hostname` varchar(50) DEFAULT NULL COMMENT '主机名称',
  `path` varchar(32) NOT NULL COMMENT '实例路径',
  `created_by` varchar(32) NOT NULL COMMENT '操作者的账号',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '本记录最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='应用实例';
