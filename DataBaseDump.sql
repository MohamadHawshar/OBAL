CREATE DATABASE  IF NOT EXISTS `obal` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `obal`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: obal
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `analyse`
--

DROP TABLE IF EXISTS `analyse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `analyse` (
  `idAnalyse` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_bin NOT NULL,
  `unite` varchar(45) COLLATE utf8_bin NOT NULL,
  `valeur` varchar(45) COLLATE utf8_bin NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`idAnalyse`),
  UNIQUE KEY `valeur_UNIQUE` (`valeur`),
  UNIQUE KEY `idAnalyse_UNIQUE` (`idAnalyse`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analyse`
--

LOCK TABLES `analyse` WRITE;
/*!40000 ALTER TABLE `analyse` DISABLE KEYS */;
INSERT INTO `analyse` VALUES (1,'sug','ml','12-70',30),(2,'milk','ml','120-150',20);
/*!40000 ALTER TABLE `analyse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `last_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `tel` int(11) NOT NULL,
  `localite` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idClient`),
  UNIQUE KEY `clientcol_UNIQUE` (`idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'mo','hawsh',1,'leb'),(2,'zik','mous',1,'leb'),(3,'alaa','shaf',1,'leb'),(5,'mhhh','h',2,'l'),(46,'o','hawsh',2121,'lob'),(47,'o','h',1123125123,'l'),(48,'mar','cus',152,'roma'),(49,'m1','m',345,'m'),(52,'m','m',89,'m'),(54,'tyurty','tryutry',989,'rtyurty'),(58,'mmo','mmo',231412,'asdasf'),(59,'mh','h',5676,'hgyjhgy'),(60,'m','h',43534,'ntyt'),(61,'mohamad ','hawchar',651684,'tripoli'),(63,'m12','m1',897,'efse'),(64,'hey','hey',48984,'hey'),(65,'hey','hey',48984,'hey'),(66,'hey','hey',48984,'hey'),(69,'tito','tito',4887749,'tito'),(71,'ali','sayedd',456189,'tripoli'),(72,'kha1','kha',15326,'kha');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facture`
--

DROP TABLE IF EXISTS `facture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facture` (
  `idfacture` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  PRIMARY KEY (`idfacture`),
  UNIQUE KEY `idfacture_UNIQUE` (`idfacture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facture`
--

LOCK TABLES `facture` WRITE;
/*!40000 ALTER TABLE `facture` DISABLE KEYS */;
/*!40000 ALTER TABLE `facture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medecin`
--

DROP TABLE IF EXISTS `medecin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medecin` (
  `idMedecin` varchar(45) COLLATE utf8_bin NOT NULL,
  `titre` varchar(45) COLLATE utf8_bin NOT NULL,
  `nom` varchar(45) COLLATE utf8_bin NOT NULL,
  `prenom` varchar(45) COLLATE utf8_bin NOT NULL,
  `localite` varchar(45) COLLATE utf8_bin NOT NULL,
  `phone` int(11) NOT NULL,
  PRIMARY KEY (`idMedecin`),
  UNIQUE KEY `code_UNIQUE` (`idMedecin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medecin`
--

LOCK TABLES `medecin` WRITE;
/*!40000 ALTER TABLE `medecin` DISABLE KEYS */;
INSERT INTO `medecin` VALUES ('CuaQ1M0Vfb','mooo','m','m','m',456),('KHAKHA','Ms.','kha','kha','kha',215163),('KWsGzsLmWO','m','m','m','m',345345345),('W6Xm2QaUyh','m','m','m','m',456),('asrew','m','m','m','m',5),('mmmmmm','m','mmmm','mmmmmm','bbbb',234),('mohhaw','Jr.','mohaaa','hawsh','trip',151684),('moomoo','mo','mooo','mooo','mo',487),('ns0CEd4Kag','m','m','m','m',345),('qgvwehwe','m','m','m','m',7);
/*!40000 ALTER TABLE `medecin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordonnance`
--

DROP TABLE IF EXISTS `ordonnance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordonnance` (
  `idordonnance` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `isPayed` tinyint(1) DEFAULT NULL,
  `idMedecin` varchar(45) COLLATE utf8_bin NOT NULL,
  `idClient` int(11) NOT NULL,
  PRIMARY KEY (`idordonnance`),
  UNIQUE KEY `idordonnance_UNIQUE` (`idordonnance`),
  KEY `fk_ordonnance_medecin1_idx` (`idMedecin`),
  KEY `fk_ordonnance_client1_idx` (`idClient`),
  CONSTRAINT `fk_ordonnance_client1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ordonnance_medecin1` FOREIGN KEY (`idMedecin`) REFERENCES `medecin` (`idMedecin`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordonnance`
--

LOCK TABLES `ordonnance` WRITE;
/*!40000 ALTER TABLE `ordonnance` DISABLE KEYS */;
INSERT INTO `ordonnance` VALUES (4,'2020-09-22',0,'mmmmmm',49),(5,'2020-09-22',0,'mmmmmm',49),(6,'2020-09-23',0,'mmmmmm',49),(7,'2020-09-23',0,'mmmmmm',49),(10,'2020-09-25',0,'mmmmmm',61),(16,'2020-09-26',0,'mmmmmm',1),(17,'2020-09-26',0,'mmmmmm',1),(18,'2020-09-26',1,'mmmmmm',61),(19,'2020-09-27',0,'mmmmmm',5),(20,'2020-09-27',0,'mmmmmm',63),(21,'2020-09-28',1,'moomoo',61),(22,'2020-10-01',0,'mohhaw',69),(23,'2020-10-04',1,'mmmmmm',1),(24,'2020-10-04',1,'mmmmmm',71),(25,'2020-10-07',1,'mohhaw',61),(26,'2020-10-08',1,'KHAKHA',72),(27,'2020-12-09',1,'mohhaw',61),(28,'2020-12-09',0,'mohhaw',61),(30,'2020-12-09',1,'mohhaw',2),(31,'2020-12-09',0,'mohhaw',2),(32,'2020-12-09',1,'mohhaw',3),(33,'2020-12-09',0,'mohhaw',3),(34,'2020-12-09',0,'mohhaw',71),(35,'2020-12-09',1,'mohhaw',69);
/*!40000 ALTER TABLE `ordonnance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `results`
--

DROP TABLE IF EXISTS `results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `results` (
  `results` double NOT NULL,
  `particip` double NOT NULL,
  `idordonnance` int(11) NOT NULL,
  `idAnalyse` int(11) NOT NULL,
  UNIQUE KEY `unique_index` (`idordonnance`,`idAnalyse`),
  KEY `fk_results_analyse1` (`idAnalyse`),
  CONSTRAINT `fk_results_analyse1` FOREIGN KEY (`idAnalyse`) REFERENCES `analyse` (`idAnalyse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_results_ordonnance1` FOREIGN KEY (`idordonnance`) REFERENCES `ordonnance` (`idordonnance`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `results`
--

LOCK TABLES `results` WRITE;
/*!40000 ALTER TABLE `results` DISABLE KEYS */;
INSERT INTO `results` VALUES (0,10,4,1),(0,10,5,1),(0,0,10,1),(0,0,16,1),(0,0,17,1),(0,0,17,2),(5.900000095367432,10,18,1),(12.800000190734863,10,18,2),(50,0,19,1),(20,0,19,2),(0,0,20,2),(50,70,21,1),(130,50,21,2),(50,10,22,1),(130.10000610351562,50,22,2),(15,50,23,1),(140,40,23,2),(15,50,24,1),(130,70,24,2),(7,8,25,1),(130.1999969482422,7,25,2),(13.199999809265137,50,26,1),(135.5,50,26,2),(0,70,27,1),(143,70,27,2),(15,0,28,1),(0,0,28,2),(15,70,30,1),(0,70,30,2),(0,0,31,1),(0,0,31,2),(50,70,32,1),(130,70,32,2),(0,0,33,1),(0,0,33,2),(0,0,34,1),(0,0,34,2),(50,70,35,1),(78,70,35,2);
/*!40000 ALTER TABLE `results` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-09  0:35:31
