

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








drop table if exists user;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `nickname` varchar(50) NOT NULL DEFAULT '' COMMENT '昵称',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `username`, `password`, `nickname`, `created`)
VALUES
  (1,'buyer','37254660e226ea65ce6f1efd54233424','王良','2018-02-18 16:20:17'),
  (2,'seller','981c57a5cfb0f868e064904b8745766f','卖家昵称','2018-02-18 16:20:43');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;




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
