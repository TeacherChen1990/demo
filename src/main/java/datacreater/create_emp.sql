CREATE TABLE `emp` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `age` (`age`),
  KEY `status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=50003206 DEFAULT CHARSET=utf8mb4;