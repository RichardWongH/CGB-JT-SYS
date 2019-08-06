-- MySQL dump 10.13  Distrib 5.7.15, for Win64 (x86_64)
--
-- Host: localhost    Database: jt_sys
-- ------------------------------------------------------
-- Server version	5.7.15
DROP DATABASE IF EXISTS jt_sys;
CREATE DATABASE jt_sys default character set utf8;
USE jt_sys;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_menus`
--


DROP TABLE IF EXISTS `sys_menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `type` int(11) DEFAULT NULL COMMENT '类型     1：菜单   2：按钮',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `parentId` int(11) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `permission` varchar(500) DEFAULT NULL COMMENT '授权(如：user:create)',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8 COMMENT='资源管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menus`
--

LOCK TABLES `sys_menus` WRITE;
/*!40000 ALTER TABLE `sys_menus` DISABLE KEYS */;
INSERT INTO `sys_menus` VALUES (3,'产品管理','请求路径',1,3,NULL,NULL,'product:list','2017-07-12 15:15:59','2017-07-21 11:16:10','admin','admin'),(4,'销售管理','请求路径',1,4,NULL,NULL,NULL,'2017-07-12 15:15:59','2017-07-12 15:15:59','admin','admin'),(7,'供销管理','请求路径',1,7,NULL,NULL,'dist:list','2017-07-12 15:15:59','2017-07-21 11:16:55','admin','admin'),(8,'系统管理','请求路径',1,8,NULL,NULL,'sys:list','2017-07-12 15:15:59','2017-07-21 11:16:00','admin','admin'),(11,'项目信息','project/listUI.do',1,11,NULL,3,'product:project:view','2017-07-12 15:15:59','2017-07-21 17:35:34','admin','admin'),(12,'团信息','team/listUI.do',1,12,NULL,3,NULL,'2017-07-12 15:15:59','2017-07-12 15:15:59','admin','admin'),(13,'产品信息','product/listUI.do',1,13,NULL,3,'','2017-07-12 15:15:59','2017-07-24 14:34:08','admin','admin'),(24,'系统配置','请求路径',1,24,NULL,8,NULL,'2017-07-12 15:15:59','2017-07-12 15:15:59','admin','admin'),(25,'日志管理','请求路径',1,25,NULL,8,NULL,'2017-07-12 15:15:59','2017-07-12 15:15:59','admin','admin'),(34,'分销商管理','请求路径',1,34,NULL,7,NULL,'2017-07-12 15:15:59','2017-07-12 15:15:59','admin','admin'),(35,'订单管理','请求路径',1,35,NULL,4,NULL,'2017-07-12 15:15:59','2017-07-12 15:15:59','admin','admin'),(41,'供应商管理','请求路径',1,41,NULL,7,NULL,'2017-07-12 15:15:59','2017-07-12 15:15:59','admin','admin'),(44,'渠道商管理','请求路径',1,44,NULL,7,NULL,'2017-07-12 15:15:59','2017-07-12 15:15:59','admin','admin'),(45,'用户管理','user/listUI.do',1,45,NULL,8,'sys:user:view','2017-07-12 15:15:59','2017-07-21 17:36:01','admin','admin'),(46,'菜单管理','menu/listUI.do',1,46,NULL,8,'sys:menu:view','2017-07-12 15:15:59','2017-07-21 17:36:16','admin','admin'),(47,'角色管理','role/listUI.do',1,47,NULL,8,'sys:role:view','2017-07-12 15:15:59','2017-07-21 17:38:03','admin','admin'),(48,'组织管理','请求路径',1,48,NULL,8,'sys:org:view','2017-07-12 15:15:59','2017-07-21 18:37:57','admin','admin'),(115,'查看','',2,1,NULL,46,'sys:menu:view','2017-07-13 16:33:41','2017-07-21 11:09:05',NULL,NULL),(116,'新增','',2,2,NULL,46,'sys:menu:add','2017-07-13 16:34:02','2017-07-21 11:09:22',NULL,NULL),(117,'修改','',2,3,NULL,46,'sys:menu:update','2017-07-13 16:34:25','2017-07-21 11:09:45',NULL,NULL),(118,'删除','',2,4,NULL,46,'sys:menu:delete','2017-07-13 16:34:46','2017-07-21 11:10:12',NULL,NULL),(119,'查看','',2,1,NULL,45,'sys:user:view','2017-07-13 16:35:05','2017-07-21 11:12:46',NULL,NULL),(120,'查看','',2,1,NULL,47,'sys:role:view','2017-07-13 16:35:26','2017-07-21 11:13:43',NULL,NULL),(126,'新增','',2,2,NULL,45,'sys:user:add','2017-07-21 11:11:34','2017-07-21 11:11:34',NULL,NULL),(127,'修改','',2,3,NULL,45,'sys:user:update','2017-07-21 11:11:56','2017-07-21 11:11:56',NULL,NULL),(128,'新增','',2,2,NULL,47,'sys:role:add','2017-07-21 11:14:24','2017-07-21 11:14:24',NULL,NULL),(129,'修改','',2,3,NULL,47,'sys:role:update','2017-07-21 11:14:48','2017-07-21 11:14:48',NULL,NULL),(130,'删除','',2,4,NULL,47,'sys:role:delete','2017-07-21 11:15:09','2017-07-21 11:15:09',NULL,NULL),(135,'查询','',2,1,NULL,11,'product:project:view','2017-07-21 17:21:40','2017-07-21 17:21:40',NULL,NULL),(136,'新增','',2,2,NULL,11,'product:project:add','2017-07-21 17:22:02','2017-07-21 17:22:02',NULL,NULL),(137,'启用','',2,3,NULL,11,'product:project:valid','2017-07-21 17:22:23','2017-07-21 17:22:23',NULL,NULL),(138,'禁用','',2,4,NULL,11,'product:project:invalid','2017-07-21 17:22:44','2017-07-21 17:22:44',NULL,NULL),(139,'修改','',2,5,NULL,11,'product:project:update','2017-07-21 17:25:20','2017-07-21 17:25:20',NULL,NULL),(140,'产品分类','type/listUI.do',1,30,NULL,3,'product:type:view','2017-08-29 14:19:34','2017-08-29 14:19:34',NULL,NULL);
/*!40000 ALTER TABLE `sys_menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menus`
--

DROP TABLE IF EXISTS `sys_role_menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) DEFAULT NULL COMMENT 'ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1190 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menus`
--

LOCK TABLES `sys_role_menus` WRITE;
/*!40000 ALTER TABLE `sys_role_menus` DISABLE KEYS */;
INSERT INTO `sys_role_menus` VALUES (1122,2,3),(1123,2,11),(1124,2,135),(1125,2,136),(1126,2,137),(1127,2,138),(1128,2,139),(1129,2,12),(1130,2,13),(1131,2,140),(1132,1,3),(1133,1,11),(1134,1,135),(1135,1,136),(1136,1,137),(1137,1,138),(1138,1,139),(1139,1,12),(1140,1,13),(1141,1,140),(1142,1,4),(1143,1,35),(1144,1,7),(1145,1,34),(1146,1,41),(1147,1,44),(1148,1,8),(1149,1,24),(1150,1,25),(1151,1,45),(1152,1,119),(1153,1,126),(1154,1,127),(1155,1,46),(1156,1,115),(1157,1,116),(1158,1,117),(1159,1,118),(1160,1,47),(1161,1,120),(1162,1,128),(1163,1,129),(1164,1,130),(1165,1,48),(1166,38,3),(1167,38,11),(1168,38,135),(1169,38,12),(1170,38,13),(1184,43,4),(1185,43,35),(1186,44,8),(1187,44,47),(1188,44,120),(1189,44,128);
/*!40000 ALTER TABLE `sys_role_menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_roles`
--

DROP TABLE IF EXISTS `sys_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_roles`
--

LOCK TABLES `sys_roles` WRITE;
/*!40000 ALTER TABLE `sys_roles` DISABLE KEYS */;
INSERT INTO `sys_roles` VALUES (1,'系统管理员','系统管理员','2017-07-13 17:44:11','2017-08-29 14:28:45','admin','admin'),(2,'产品经理','产品经理','2017-07-13 17:44:47','2017-08-29 14:21:32','admin','admin'),(44,'MIS','MIS..','2018-01-13 02:09:06','2018-01-13 02:09:06',NULL,NULL);
/*!40000 ALTER TABLE `sys_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_roles`
--

DROP TABLE IF EXISTS `sys_user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_roles`
--

LOCK TABLES `sys_user_roles` WRITE;
/*!40000 ALTER TABLE `sys_user_roles` DISABLE KEYS */;
INSERT INTO `sys_user_roles` VALUES (19,4,2),(20,5,1),(22,6,2),(25,3,2),(28,2,38),(29,12,1),(30,12,2),(34,15,1),(35,1,1),(36,7,44);
/*!40000 ALTER TABLE `sys_user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_users`
--

DROP TABLE IF EXISTS `sys_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '盐  密码加密时前缀，使加密后的值不同',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `valid` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常  默认值 ：1',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='系统用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_users`
--

LOCK TABLES `sys_users` WRITE;
/*!40000 ALTER TABLE `sys_users` DISABLE KEYS */;
INSERT INTO `sys_users` VALUES (1,'admin','4ebd394fbd25e495e0753a7dc9889a8e','7adb778c-e7d3-4dd3-a3c5-5f80a158006d','admin@tedu.cn','13624356789',1,NULL,'2018-01-13 02:06:45',NULL,'admin'),(2,'zhangli','bdcf69375bdb532e50279b91eb00940d','5e7cbd36-e897-4951-b42b-19809caf3caa','zhangli@tedu.cn','13678909876',0,'2017-07-18 10:01:51','2018-01-13 01:28:11',NULL,'admin'),(3,'wangke','c5dc32ec66041aeddf432b3146bd2257','5e3e1475-1ea9-4a6a-976e-b07545827139','wangke@tedu.cn','18678900987',1,'2017-07-18 11:40:53','2017-07-21 17:40:28',NULL,NULL),(4,'zhangql','+HBpqtPuj9KLBIpneR5X0A==','ed487fac-9952-45c9-acaa-21dab9c689cc','zhangql@tedu.cn','13678909876',1,'2017-07-18 12:17:30','2017-07-18 17:40:09',NULL,NULL),(5,'fanwei','1acab7425d6dfae670f26bd160518902','34fbedb2-e135-4f8d-b595-24360edc348d','fanwei@tedu.cn','13876545678',1,'2017-07-20 17:03:22','2017-07-20 17:03:22',NULL,NULL),(6,'wumei','431ebdcccf3404787a144f9ba669a8e2','8a14f46f-7a17-4dfe-85ab-08e63cb618ce','wumei@tedu.cn','13567898765',1,'2017-07-21 10:57:40','2017-07-21 10:58:21',NULL,NULL),(7,'tedu','689c673a0d8bda7ee795dd45a126ae96','3faa1d2b-a99f-4ffb-9d29-0e71563258af','t@t.com','123',1,'2018-01-12 23:19:58','2018-01-13 02:09:33',NULL,'admin'),(9,'tmooc','e10adc3949ba59abbe56e057f20f883e',NULL,'t@t.com','123',1,'2018-01-12 23:20:31','2018-01-12 23:20:31',NULL,NULL),(12,'tedu01','5bf6593afd106aa544000d559f0c2241','9528e727-2901-4746-8558-9010d9607da2','t@t.com','123',1,'2018-01-13 01:48:32','2018-01-13 01:48:32',NULL,NULL),(13,'tedu02','2630d8bd50c76abf001a9daceeae97e6','30fff766-e245-4a93-9f5e-6eb2c2cec494','t@t.com','123456',0,'2018-01-13 02:01:56','2018-01-13 02:07:31',NULL,'admin'),(15,'tedu03','2ce586af95c6431112092f653659c85f','eaedbaee-d760-40e4-b71e-ccecf01b6187','t@t.com','123456',1,'2018-01-13 02:02:06','2018-01-13 02:02:48',NULL,'admin');
/*!40000 ALTER TABLE `sys_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tms_attachements`
--


