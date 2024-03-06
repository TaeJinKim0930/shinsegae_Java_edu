-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: emartdb
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `buytbl`
--

DROP TABLE IF EXISTS `buytbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buytbl` (
  `username` char(3) NOT NULL,
  `prodname` char(3) NOT NULL,
  `price` int NOT NULL,
  `amount` int NOT NULL,
  KEY `fk_username_idx` (`username`),
  CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `usertbl` (`username`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buytbl`
--

LOCK TABLES `buytbl` WRITE;
/*!40000 ALTER TABLE `buytbl` DISABLE KEYS */;
INSERT INTO `buytbl` VALUES ('KBS','노트북',1000,1),('JYP','모니터',200,1),('BBK','모니터',200,5),('KBS','청바지',50,3),('BBK','메모리',80,10),('SSK','책',15,5),('EJW','책',15,2),('EJW','청바지',50,1),('BBK','운동화',30,2),('EJW','책',15,1),('BBK','운동화',30,2);
/*!40000 ALTER TABLE `buytbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertbl`
--

DROP TABLE IF EXISTS `usertbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usertbl` (
  `username` char(3) NOT NULL,
  `birthYear` int NOT NULL,
  `addr` char(2) NOT NULL,
  `mobile` char(12) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertbl`
--

LOCK TABLES `usertbl` WRITE;
/*!40000 ALTER TABLE `usertbl` DISABLE KEYS */;
INSERT INTO `usertbl` VALUES ('BBK',1973,'서울','0100000000'),('EJW',1972,'경북','0118888888'),('JKW',1965,'경기','0189999999'),('JYP',1950,'경기','0114444444'),('KBS',1979,'경남','0112222222'),('KKH',1971,'전남','0193333333'),('LJB',1963,'서울','0166666666'),('LSG',1987,'서울','0111111111'),('ss',1990,'서울',NULL),('SSK',1979,'서울',NULL),('YJS',1969,'경남',NULL);
/*!40000 ALTER TABLE `usertbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'emartdb'
--

--
-- Dumping routines for database 'emartdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-25 14:41:31
