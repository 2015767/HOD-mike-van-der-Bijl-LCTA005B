-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server versie:                5.5.23 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Versie:              8.1.0.4545
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Databasestructuur van web_oldskool_daowebdemo wordt geschreven
CREATE DATABASE IF NOT EXISTS `web_oldskool_daowebdemo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `web_oldskool_daowebdemo`;


-- Structuur van  tabel web_oldskool_daowebdemo.user wordt geschreven
CREATE TABLE IF NOT EXISTS `user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- Dumpen data van tabel web_oldskool_daowebdemo.user: ~8 rows (ongeveer)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`userId`, `email`, `firstName`, `lastName`) VALUES
	(4, 'User', 'My', 'second'),
	(5, 'User', 'My ', 'Second'),
	(6, 'xx', 'xx', 'xx'),
	(7, 'Avenue', 'My', 'Fifth'),
	(8, 'Lady', 'My', 'First'),
	(9, '4-2', 'ajax', 'milan'),
	(10, 'nnnn', 'ccc', 'vvv'),
	(11, '', '<script>alert(\'test\')</script>', '');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
