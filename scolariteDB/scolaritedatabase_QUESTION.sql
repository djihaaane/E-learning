-- MySQL dump 10.13  Distrib 8.0.18, for Linux (x86_64)
--
-- Host: localhost    Database: scolaritedatabase
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `QUESTION`
--

DROP TABLE IF EXISTS `QUESTION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `QUESTION` (
  `NumQst` int(11) NOT NULL,
  `ContenuQst` varchar(100) DEFAULT NULL,
  `BaremeQst` int(11) DEFAULT NULL,
  `TestQst` int(11) NOT NULL,
  `CoursQst` int(11) NOT NULL,
  `ReponseQst` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`NumQst`,`TestQst`,`CoursQst`),
  KEY `FK_testqst_idx` (`TestQst`),
  KEY `fk_QUESTION_1_idx` (`CoursQst`),
  CONSTRAINT `FK_testqst` FOREIGN KEY (`TestQst`) REFERENCES `TEST` (`NumTest`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_QUESTION_1` FOREIGN KEY (`CoursQst`) REFERENCES `COURS` (`NumCours`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QUESTION`
--

LOCK TABLES `QUESTION` WRITE;
/*!40000 ALTER TABLE `QUESTION` DISABLE KEYS */;
INSERT INTO `QUESTION` VALUES (1,'quel?',2,1,3,'Vrai'),(2,'quoi?',2,1,3,'Faux'),(3,'comment?',2,1,3,'avec sql'),(4,'qui?',2,1,3,'administrateur');
/*!40000 ALTER TABLE `QUESTION` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-01 14:21:43
