CREATE DATABASE  IF NOT EXISTS `world`;
USE `world`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `countrycode` varchar(45) DEFAULT NULL,
  `district` varchar(45) DEFAULT NULL,
  `population` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `city` VALUES
	(1,'Toronto','CAN','Toronto', 1800000),