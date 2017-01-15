-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: food_service
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `client_adr`
--

DROP TABLE IF EXISTS `client_adr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_adr` (
  `id_adr` int(11) NOT NULL AUTO_INCREMENT,
  `id_client` int(11) NOT NULL,
  `city` varchar(45) NOT NULL,
  `street` varchar(45) NOT NULL,
  `house` varchar(45) NOT NULL,
  `apartment` varchar(45) DEFAULT NULL,
  `floor` int(11) DEFAULT NULL,
  `porch` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_adr`),
  KEY `client_adr_keys_idx` (`id_client`),
  CONSTRAINT `client_adr_keys` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id_clients`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_adr`
--

LOCK TABLES `client_adr` WRITE;
/*!40000 ALTER TABLE `client_adr` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_adr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clients` (
  `id_clients` int(11) NOT NULL AUTO_INCREMENT,
  `client_tel` varchar(45) NOT NULL,
  `client_name` varchar(45) NOT NULL,
  `client_regdate` date NOT NULL,
  `client_info` varchar(140) DEFAULT NULL,
  PRIMARY KEY (`id_clients`),
  UNIQUE KEY `id_clients_UNIQUE` (`id_clients`),
  UNIQUE KEY `client_tel_UNIQUE` (`client_tel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flags`
--

DROP TABLE IF EXISTS `flags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flags` (
  `id_flags` int(11) NOT NULL AUTO_INCREMENT,
  `flag_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_flags`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flags`
--

LOCK TABLES `flags` WRITE;
/*!40000 ALTER TABLE `flags` DISABLE KEYS */;
/*!40000 ALTER TABLE `flags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `good_category`
--

DROP TABLE IF EXISTS `good_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `good_category` (
  `id_good_category` int(11) NOT NULL AUTO_INCREMENT,
  `good_category_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_good_category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `good_category`
--

LOCK TABLES `good_category` WRITE;
/*!40000 ALTER TABLE `good_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `good_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `id_goods` int(11) NOT NULL AUTO_INCREMENT,
  `id_good_category` int(11) NOT NULL,
  `good_name` varchar(45) NOT NULL,
  `good_price` double NOT NULL,
  PRIMARY KEY (`id_goods`),
  KEY `id_good_key_idx` (`id_good_category`),
  CONSTRAINT `id_good_key` FOREIGN KEY (`id_good_category`) REFERENCES `good_category` (`id_good_category`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id_orders` int(11) NOT NULL AUTO_INCREMENT,
  `id_goods` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `order_flag` int(11) NOT NULL,
  `order_time` datetime NOT NULL,
  `order_time_complit` datetime NOT NULL,
  `order_time_change` datetime DEFAULT NULL,
  PRIMARY KEY (`id_orders`),
  KEY `flag_key_idx` (`order_flag`),
  KEY `goods_key_idx` (`id_goods`),
  KEY `client_key_idx` (`id_client`),
  KEY `user_ket_idx` (`id_user`),
  CONSTRAINT `client_key` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id_clients`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `flag_key` FOREIGN KEY (`order_flag`) REFERENCES `flags` (`id_flags`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `goods_key` FOREIGN KEY (`id_goods`) REFERENCES `goods` (`id_goods`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_ket` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_users`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id_users` int(11) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(45) NOT NULL,
  `user_psw` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_users`),
  UNIQUE KEY `id_users_UNIQUE` (`id_users`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-15 21:36:49
