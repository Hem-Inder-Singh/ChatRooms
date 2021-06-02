CREATE DATABASE  IF NOT EXISTS `chat_room_java` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `chat_room_java`;
-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: chat_room_java
-- ------------------------------------------------------
-- Server version	5.5.13

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
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `mesgid` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(450) DEFAULT NULL,
  `postedby` varchar(45) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  `datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`mesgid`),
  KEY `fr32` (`postedby`),
  KEY `fr33` (`rid`),
  CONSTRAINT `fr32` FOREIGN KEY (`postedby`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fr33` FOREIGN KEY (`rid`) REFERENCES `rooms` (`rid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,'Hello Bro','Hem Inder Singh',6,'2020-09-07 13:50:09','text'),(6,'src/uploads/1599499095967.jpg','Hem Inder Singh',6,'2020-09-07 17:18:16','image'),(7,'src/uploads/1599499126754.docx','Hem Inder Singh',6,'2020-09-07 17:18:46','file'),(8,'src/uploads/1599580124140.jpg','Hem Inder Singh',6,'2020-09-08 15:48:44','image'),(13,':D','Hem Inder Singh',6,'2020-09-09 07:37:54','emojis'),(14,'N(','Hem Inder Singh',6,'2020-09-09 07:37:54','emojis'),(15,':(','Hem Inder Singh',6,'2020-09-09 07:37:54','emojis'),(16,':(','Lali',6,'2020-09-09 07:40:55','emojis'),(17,'N(','Hem Inder Singh',6,'2020-09-09 07:37:54','emojis'),(19,'hiii',NULL,6,'2020-09-09 07:48:20','text'),(20,'hello sir','Hem Inder Singh',6,'2020-09-09 07:53:42','text'),(21,'lkiniubhu','Hem Inder Singh',13,'2020-10-16 12:29:14','text'),(22,':D','Hem Inder Singh',13,'2020-10-16 12:29:32','emojis'),(23,'src/uploads/1602851401956.jpg','Hem Inder Singh',13,'2020-10-16 12:30:01','image'),(24,'src/uploads/1602851414703.jpg','Hem Inder Singh',13,'2020-10-16 12:30:14','image'),(25,'src/uploads/1602851452293.xlsx','Hem Inder Singh',13,'2020-10-16 12:30:52','file'),(26,'Hello ','Hem Inder Singh',6,'2020-11-11 06:39:37','text'),(27,':D','Hem Inder Singh',6,'2020-11-11 06:39:45','emojis'),(28,'src/uploads/1605077163832.jpg','Dharmanshu',6,'2020-11-11 06:46:03','image'),(29,'Hi','Hem Inder Singh',9,'2021-01-29 01:14:05','text'),(30,':D','Hem Inder Singh',9,'2021-01-29 01:14:13','emojis'),(31,'src/uploads/1611882875250.jpg','Hem Inder Singh',9,'2021-01-29 01:14:35','image'),(32,'Hello Everyone','Hem Inder Singh',9,'2021-01-29 01:20:17','text'),(33,':(','Hem Inder Singh',9,'2021-01-29 01:20:26','emojis'),(34,'src/uploads/1611883249589.jpg','Hem Inder Singh',9,'2021-01-29 01:20:49','image'),(35,'Hlo','Hem Inder Singh',6,'2021-02-12 06:08:59','text'),(36,':D','Hem Inder Singh',9,'2021-02-12 06:14:10','emojis'),(37,'Hi ','Hem Inder Singh',13,'2021-02-28 12:12:31','text'),(38,'src/uploads/1614514386752.jpg','Hem Inder Singh',13,'2021-02-28 12:13:06','image'),(39,':D','Hem Inder Singh',13,'2021-02-28 12:13:13','emojis'),(40,'Hi ','Hem Inder Singh',14,'2021-02-28 12:16:26','text'),(41,'This is new room','Hem Inder Singh',14,'2021-02-28 12:16:39','text'),(42,'N(','Hem Inder Singh',14,'2021-02-28 12:16:47','emojis'),(43,'Hi','H.I.Singh',13,'2021-02-28 12:19:14','text'),(44,'**','H.I.Singh',13,'2021-02-28 12:19:20','emojis');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-01 16:25:52
