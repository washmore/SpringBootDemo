/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.146_3306
Source Server Version : 50556
Source Host           : 192.168.0.148:3306
Source Database       : solo_backup

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2017-07-07 22:18:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b3_solo_article
-- ----------------------------
DROP TABLE IF EXISTS `b3_solo_article`;
CREATE TABLE `b3_solo_article` (
  `oId` varchar(255) NOT NULL,
  `articleTitle` varchar(255) NOT NULL,
  `articleAbstract` text NOT NULL,
  `articleTags` text NOT NULL,
  `articleAuthorEmail` varchar(255) NOT NULL,
  `articleCommentCount` int(11) NOT NULL,
  `articleViewCount` int(11) NOT NULL,
  `articleContent` mediumtext NOT NULL,
  `articlePermalink` varchar(255) NOT NULL,
  `articleHadBeenPublished` char(1) NOT NULL,
  `articleIsPublished` char(1) NOT NULL,
  `articlePutTop` char(1) NOT NULL,
  `articleCreateDate` datetime NOT NULL,
  `articleUpdateDate` datetime NOT NULL,
  `articleRandomDouble` double NOT NULL,
  `articleSignId` varchar(255) NOT NULL,
  `articleCommentable` char(1) NOT NULL,
  `articleViewPwd` varchar(100) NOT NULL,
  `articleEditorType` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`oId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
