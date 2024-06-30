/*
SQLyog Community v8.4 RC2
MySQL - 5.0.15-nt : Database - webboss
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`webboss` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `webboss`;

/*Table structure for table `business` */

DROP TABLE IF EXISTS `business`;

CREATE TABLE `business` (
  `c1DB` varchar(2000) default NULL,
  `c1DBsup` int(11) default NULL,
  `L1` varchar(2000) default NULL,
  `L1sup` int(11) default NULL,
  `PL1` varchar(2000) default NULL,
  `PL1sup` int(11) default NULL,
  `C2` varchar(2000) default NULL,
  `C2sup` int(11) default NULL,
  `L2` varchar(2000) default NULL,
  `L2sup` int(11) default NULL,
  `PL2` varchar(2000) default NULL,
  `PL2sup` int(11) default NULL,
  `C3` varchar(2000) default NULL,
  `C3sup` int(11) default NULL,
  `L3` varchar(2000) default NULL,
  `L3sup` int(11) default NULL,
  `PL3` varchar(2000) default NULL,
  `PL3sup` int(11) default NULL,
  `C4` varchar(2000) default NULL,
  `C4sup` int(11) default NULL,
  `L4` varchar(2000) default NULL,
  `L4sup` int(11) default NULL,
  `count` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `business` */

LOCK TABLES `business` WRITE;

UNLOCK TABLES;

/*Table structure for table `candidate` */

DROP TABLE IF EXISTS `candidate`;

CREATE TABLE `candidate` (
  `c1DB` varchar(2000) default NULL,
  `c1DBsup` int(4) default NULL,
  `c1newsup` int(4) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `candidate` */

LOCK TABLES `candidate` WRITE;

UNLOCK TABLES;

/*Table structure for table `cdetails` */

DROP TABLE IF EXISTS `cdetails`;

CREATE TABLE `cdetails` (
  `user_id` int(11) NOT NULL auto_increment,
  `user_name` varchar(50) default NULL,
  `password` varchar(40) default NULL,
  `date` varchar(2) default NULL,
  `month` varchar(2) default NULL,
  `year` varchar(4) default NULL,
  `category` varchar(40) default NULL,
  `email` varchar(50) default NULL,
  `amt` int(20) default NULL,
  `cunt` int(20) default NULL,
  `sckey` varchar(20) default NULL,
  `status` varchar(20) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cdetails` */

LOCK TABLES `cdetails` WRITE;

insert  into `cdetails`(`user_id`,`user_name`,`password`,`date`,`month`,`year`,`category`,`email`,`amt`,`cunt`,`sckey`,`status`) values (1,'admin','admin','01','02','1993','admin','alagujegan@gmail.com',0,0,NULL,'1');

UNLOCK TABLES;

/*Table structure for table `clickstore` */

DROP TABLE IF EXISTS `clickstore`;

CREATE TABLE `clickstore` (
  `itemlable` varchar(5) default NULL,
  `username` varchar(25) default NULL,
  `count` int(10) default NULL,
  `Price` int(10) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `clickstore` */

LOCK TABLES `clickstore` WRITE;

UNLOCK TABLES;

/*Table structure for table `clusteryam` */

DROP TABLE IF EXISTS `clusteryam`;

CREATE TABLE `clusteryam` (
  `cluster` int(3) default NULL,
  `item` varchar(40) default NULL,
  `count` int(3) unsigned NOT NULL auto_increment,
  PRIMARY KEY  (`count`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `clusteryam` */

LOCK TABLES `clusteryam` WRITE;

UNLOCK TABLES;

/*Table structure for table `items` */

DROP TABLE IF EXISTS `items`;

CREATE TABLE `items` (
  `item_id` varchar(10) default NULL,
  `NAME` varchar(30) default NULL,
  `manufacturer` varchar(50) default NULL,
  `price` int(30) default NULL,
  `image` varchar(100) default NULL,
  `description` varchar(1000) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `items` */

LOCK TABLES `items` WRITE;

insert  into `items`(`item_id`,`NAME`,`manufacturer`,`price`,`image`,`description`) values ('A','joystick','sony ',12000,'images/A.jpg',NULL),('B','joystick_new','sony',12500,'images/B.jpg',NULL),('C','ipod','apple',7000,'images/C.jpg',NULL),('D','printer','sony',6000,'images/D.jpg',NULL),('G','nfs','EA',5000,'images/G.jpg',NULL),('H','S-pen','macron',4000,'images/H.jpg',NULL),('K','cellphonecover','leather_mac',400,'images/K.jpg',NULL),('L','cellphone','panasonic',12000,'images/L.jpg',NULL),('M','laptop','Dell',35000,'images/M.jpg',NULL),('N','cellphone','motorla',7000,'images/N.jpg',NULL),('O','modem','bsnkmid',900,'images/O.jpg',NULL),('P','Bluetooth','Transcend',600,'images/P.jpg',NULL),('Q','cellphone','nokia',12000,'images/Q.jpg',NULL),('R','adapter','nokia',350,'images/R.jpg',NULL),('S','vaio','sony',35000,'images/S.jpg',NULL),('T','Wrist_cellphone','Telson',6700,'images/T.jpg',NULL),('W','dvd/cd Writer','Pioneer',3000,'images/W.jpg',NULL),('X','Notebook cleaner','Kingston',6000,'images/X.jpg',NULL),('Y','cellphone','nokia',6000,'images/Y.jpg',NULL),('Z','DataCable','Transcend',400,'images/Z.jpg',NULL),('E','System','Dell',25000,'images/E.jpg',NULL),('U','iskin','apple',8000,'images/U.jpg',NULL),('I','monitor','samsung',7000,'images/I.jpg',NULL),('F','cellphone','nokia',18000,'images/F.jpg',NULL),('J','ipod_new','apple',12000,'images/J.jpg',NULL),('V','Typewriter','Tvs',4000,'images/V.jpg',NULL),('a','digital_camera','Canon',12000,'images/aa.jpg',NULL),('b','fax_machine','Canon',5400,'images/bb.jpg',NULL),('c','digital_video','sony',7000,'images/cc.jpg',NULL),('d','camera','Canon',12000,'images/dd.jpg',NULL),('e','camera','digital_world',2000,'images/ee.jpg',NULL),('f','digital_camera','Canon',10100,'images/ff.jpg',NULL),('g','digital_camera','Canon',12000,'images/gg.jpg',NULL),('h','USB','sandisk',500,'images/hh.jpg',NULL),('i','bag','ThenorthFace',900,'images/ii.jpg',NULL),('j','cellphone','digitalworld',7000,'images/jj.jpg',NULL),('k','radio','digitalworld',1200,'images/kk.jpg',NULL),('l','wristwatch','titan',600,'images/ll.jpg',NULL),('m','wristwatch','ajantha',800,'images/mm.jpg',NULL),('n','shoes','adidas',5000,'images/nn.jpg',NULL),('o','sports_bag','adidas',1200,'images/oo.jpg',NULL),('p','helmet','kittu_sports',700,'images/pp.jpg',NULL),('q','t_shirt','levis',800,'images/qq.jpg',NULL),('r','sports_items','kahuna',12000,'images/rr.jpg',NULL),('s','tennis_bat','vicky',1200,'images/ss.jpg',NULL),('t','ball','collection',5000,'images/tt.jpg',NULL),('u','video_camera','aiptek',12000,'images/uu.jpg',NULL),('v','Volley Ball','volley ball',42000,'images/vv.jpg',NULL),('x','bag','ruffs',700,'images/xx.jpg',NULL),('y','gym_instruments','gym_prodsdasf',6000,'images/yy.jpg',NULL),('z','elbow_cap','valeo',500,'images/zz.jpg',NULL),('w','charger','EverFast',120,'images/ww.jpg',NULL);

UNLOCK TABLES;

/*Table structure for table `media` */

DROP TABLE IF EXISTS `media`;

CREATE TABLE `media` (
  `c1DB` varchar(2000) default NULL,
  `c1DBsup` int(11) default NULL,
  `L1` varchar(2000) default NULL,
  `L1sup` int(11) default NULL,
  `PL1` varchar(2000) default NULL,
  `PL1sup` int(11) default NULL,
  `C2` varchar(2000) default NULL,
  `C2sup` int(11) default NULL,
  `L2` varchar(2000) default NULL,
  `L2sup` int(11) default NULL,
  `PL2` varchar(2000) default NULL,
  `PL2sup` int(11) default NULL,
  `C3` varchar(2000) default NULL,
  `C3sup` int(11) default NULL,
  `L3` varchar(2000) default NULL,
  `L3sup` int(11) default NULL,
  `PL3` varchar(2000) default NULL,
  `PL3sup` int(11) default NULL,
  `C4` varchar(2000) default NULL,
  `C4sup` int(11) default NULL,
  `L4` varchar(2000) default NULL,
  `L4sup` int(11) default NULL,
  `count` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `media` */

LOCK TABLES `media` WRITE;

UNLOCK TABLES;

/*Table structure for table `promise_trans` */

DROP TABLE IF EXISTS `promise_trans`;

CREATE TABLE `promise_trans` (
  `trans_day` int(11) default NULL,
  `transaction_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `items` varchar(2000) default NULL,
  `cluster_no` int(11) default NULL,
  `SLR` float(7,4) default NULL,
  `category_id` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `promise_trans` */

LOCK TABLES `promise_trans` WRITE;

UNLOCK TABLES;

/*Table structure for table `sports` */

DROP TABLE IF EXISTS `sports`;

CREATE TABLE `sports` (
  `c1DB` varchar(2000) default NULL,
  `c1DBsup` int(11) default NULL,
  `L1` varchar(2000) default NULL,
  `L1sup` int(11) default NULL,
  `PL1` varchar(2000) default NULL,
  `PL1sup` int(11) default NULL,
  `C2` varchar(2000) default NULL,
  `C2sup` int(11) default NULL,
  `L2` varchar(2000) default NULL,
  `L2sup` int(11) default NULL,
  `PL2` varchar(2000) default NULL,
  `PL2sup` int(11) default NULL,
  `C3` varchar(2000) default NULL,
  `C3sup` int(11) default NULL,
  `L3` varchar(2000) default NULL,
  `L3sup` int(11) default NULL,
  `PL3` varchar(2000) default NULL,
  `PL3sup` int(11) default NULL,
  `C4` varchar(2000) default NULL,
  `C4sup` int(11) default NULL,
  `L4` varchar(2000) default NULL,
  `L4sup` int(11) default NULL,
  `count` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sports` */

LOCK TABLES `sports` WRITE;

UNLOCK TABLES;

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `c1DB` varchar(2000) default NULL,
  `c1DBsup` int(11) default NULL,
  `L1` varchar(2000) default NULL,
  `L1sup` int(11) default NULL,
  `PL1` varchar(2000) default NULL,
  `PL1sup` int(11) default NULL,
  `C2` varchar(2000) default NULL,
  `C2sup` int(11) default NULL,
  `L2` varchar(2000) default NULL,
  `L2sup` int(11) default NULL,
  `PL2` varchar(2000) default NULL,
  `PL2sup` int(11) default NULL,
  `C3` varchar(2000) default NULL,
  `C3sup` int(11) default NULL,
  `L3` varchar(2000) default NULL,
  `L3sup` int(11) default NULL,
  `PL3` varchar(2000) default NULL,
  `PL3sup` int(11) default NULL,
  `C4` varchar(2000) default NULL,
  `C4sup` int(11) default NULL,
  `L4` varchar(2000) default NULL,
  `L4sup` int(11) default NULL,
  `count` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student` */

LOCK TABLES `student` WRITE;

UNLOCK TABLES;

/*Table structure for table `wishlist` */

DROP TABLE IF EXISTS `wishlist`;

CREATE TABLE `wishlist` (
  `item` varchar(30) default NULL,
  `customer_name` varchar(60) default NULL,
  `mail_id` varchar(60) default NULL,
  `isValid` smallint(1) default '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `wishlist` */

LOCK TABLES `wishlist` WRITE;

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
