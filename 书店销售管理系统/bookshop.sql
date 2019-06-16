/*
MySQL Data Transfer
Source Host: localhost
Source Database: bookshop
Target Host: localhost
Target Database: bookshop
Date: 2018/12/24 18:33:44
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for returnbook
-- ----------------------------
DROP TABLE IF EXISTS `returnbook`;
CREATE TABLE `returnbook` (
  `bookID` int(11) default NULL,
  `bookNum` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `bookID` int(11) default NULL,
  `bookNum` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `bookID` int(11) default NULL,
  `bookSupplier` varchar(32) default NULL,
  `bookNum` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `bookID` int(11) NOT NULL,
  `bookName` varchar(32) default NULL,
  `bookPrice` varchar(32) default NULL,
  `bookLeft` int(11) default NULL,
  `bookSale` int(11) default NULL,
  PRIMARY KEY  (`bookID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sum
-- ----------------------------
DROP TABLE IF EXISTS `sum`;
CREATE TABLE `sum` (
  `bookID` int(11) NOT NULL,
  `bookName` varchar(32) default NULL,
  `bookPrice` varchar(32) default NULL,
  `bookSum` int(11) default NULL,
  PRIMARY KEY  (`bookID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `returnbook` VALUES ('1', '2');
INSERT INTO `returnbook` VALUES ('1', '1');
INSERT INTO `returnbook` VALUES ('1', '2');
INSERT INTO `returnbook` VALUES ('1', '1');
INSERT INTO `returnbook` VALUES ('2', '2');
INSERT INTO `returnbook` VALUES ('1', '1');
INSERT INTO `returnbook` VALUES ('1', '2');
INSERT INTO `returnbook` VALUES ('1', '2');
INSERT INTO `returnbook` VALUES ('1', '1');
INSERT INTO `returnbook` VALUES ('1', '2');
INSERT INTO `returnbook` VALUES ('1', '1');
INSERT INTO `sale` VALUES ('1', '2');
INSERT INTO `sale` VALUES ('1', '2');
INSERT INTO `sale` VALUES ('1', '2');
INSERT INTO `sale` VALUES ('1', '2');
INSERT INTO `sale` VALUES ('2', '2');
INSERT INTO `sale` VALUES ('1', '2');
INSERT INTO `sale` VALUES ('1', '2');
INSERT INTO `sale` VALUES ('1', '2');
INSERT INTO `sale` VALUES ('1', '2');
INSERT INTO `sale` VALUES ('1', '3');
INSERT INTO `sale` VALUES ('1', '2');
INSERT INTO `sale` VALUES ('1', '3');
INSERT INTO `sale` VALUES ('1', '2');
INSERT INTO `stock` VALUES ('1', '省批发中心', '2');
INSERT INTO `stock` VALUES ('2', '省批发中心', '4');
INSERT INTO `stock` VALUES ('3', '省批发中心', '5');
INSERT INTO `stock` VALUES ('2', '省批发中心', '2');
INSERT INTO `stock` VALUES ('2', '省批发中心', '2');
INSERT INTO `stock` VALUES ('1', '省批发中心', '4');
INSERT INTO `stock` VALUES ('1', '省批发中心', '2');
INSERT INTO `stock` VALUES ('1', '省批发中心', '2');
INSERT INTO `stock` VALUES ('1', '省批发中心', '2');
INSERT INTO `stock` VALUES ('1', '省批发中心', '1');
INSERT INTO `stock` VALUES ('1', '省批发中心', '2');
INSERT INTO `stock` VALUES ('1', '省批发中心', '2');
INSERT INTO `stock` VALUES ('1', '省批发中心', '1');
INSERT INTO `stock` VALUES ('1', '省批发中心', '2');
INSERT INTO `stock` VALUES ('1', '省批发中心', '1');
INSERT INTO `stock` VALUES ('1', '省批发中心', '1');
INSERT INTO `store` VALUES ('1', '三体', '21.99', '23', '6');
INSERT INTO `store` VALUES ('2', '撒哈拉的故事', '29.99', '13', '2');
INSERT INTO `sum` VALUES ('1', '三体', '21.99', '2');
INSERT INTO `sum` VALUES ('2', '撒哈拉的故事', '29.99', '3');
