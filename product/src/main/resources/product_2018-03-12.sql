# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.20)
# Database: store
# Generation Time: 2018-03-12 12:34:27 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;



drop table if exists product;

CREATE TABLE `product` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(30) NOT NULL DEFAULT '' COMMENT '标题',
  `description` varchar(140) DEFAULT NULL COMMENT '摘要',
  `price` float(6,2) DEFAULT NULL,
  `saled` int(3) NOT NULL DEFAULT '0' COMMENT '已卖数量',
  `content` text COMMENT '全文',
  `img` varchar(60) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;

INSERT INTO `product` (`id`, `title`, `description`, `price`, `saled`, `content`, `img`, `created`)
VALUES
	(2,'222','222',12.00,0,'这是全文','/upload/1520065990739.jpg_430x430q90.jpg','2018-02-28 15:01:53'),
	(3,'333','333',23.00,0,'这是全文','/upload/1519921616507.jpg_430x430q90.jpg','2018-02-28 15:01:49'),
	(4,'4444','444',123.00,0,'这是全文','/upload/1519977062579.jpg_430x430q90.jpg','2018-02-28 15:01:56'),
	(6,'666','666',34.00,0,'这是全文','http://localhost/1.jpg','2018-02-28 00:39:47'),
	(7,'','1234',2134.00,0,'1234',NULL,'2018-03-01 23:02:03'),
	(8,'','1234',2134.00,0,'1234',NULL,'2018-03-01 23:05:02'),
	(9,'','1234',2134.00,0,'1234',NULL,'2018-03-01 23:06:48'),
	(10,'','1234',2134.00,0,NULL,NULL,'2018-03-01 23:06:56'),
	(11,'123234','1234',2134.00,0,'1234','/upload/1519919610653.jpg_430x430q90','2018-03-01 23:53:31'),
	(12,'123234','1234',2134.00,0,'1234','/upload/1519919856974.jpg_430x430q90','2018-03-01 23:57:37'),
	(13,'123234','1234',2134.00,0,'1234','/upload/1519920240723.jpg_430x430q90.jpg','2018-03-02 00:04:01'),
	(14,'123234','1234',2134.00,0,'1234','/upload/1519920432204.jpg_430x430q90.jpg','2018-03-02 00:07:44'),
	(15,'123234','1234',2134.00,0,'1234','/upload/1519920556457.jpg_430x430q90.jpg','2018-03-02 00:09:32'),
	(16,'123234','1234',2134.00,0,'1234','/upload/1519920646457.jpg_430x430q90.jpg','2018-03-02 00:11:18'),
	(17,'123234','1234',2134.00,0,'1234','/upload/null','2018-03-02 00:14:23'),
	(18,'','sadf',123.00,0,'234wer','/upload/1519921616507.jpg_430x430q90.jpg','2018-03-02 00:26:56'),
	(19,'','aesfd',2345.00,0,'asdfb','/upload/1519921895003.jpg','2018-03-02 00:31:35'),
	(20,'2134asdfa','asfddsa',1234.00,0,'asfdasf','/upload/1519923254673.jpg','2018-03-02 00:54:14'),
	(21,'oiuiyfgh','kjhk',87.00,0,'hgkj','/upload/1520066179688.jpg','2018-03-03 16:36:19');

/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
