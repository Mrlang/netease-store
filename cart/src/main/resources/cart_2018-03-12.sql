# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.20)
# Database: store
# Generation Time: 2018-03-12 11:43:34 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


drop table if exists cart;

CREATE TABLE `cart` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `pid` bigint(11) NOT NULL,
  `uid` bigint(11) NOT NULL DEFAULT '1',
  `count` int(11) NOT NULL DEFAULT '1',
  `cleared` tinyint(2) DEFAULT '0' COMMENT '是否已经清算',
  `buyedPrice` float(6,2) DEFAULT NULL COMMENT '结算时的价格',
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;

INSERT INTO `cart` (`id`, `pid`, `uid`, `count`, `cleared`, `buyedPrice`, `created`, `updated`)
VALUES
	(1,3,1,1,1,10.00,'2018-02-24 16:36:07','2018-02-24 18:21:24'),
	(3,2,1,3,1,20.00,'2018-02-24 16:39:37','2018-02-24 18:21:24'),
	(4,4,1,13,1,4444.00,'2018-02-27 17:20:00','2018-02-27 23:23:33');

/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
