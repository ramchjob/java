-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: javap
-- ------------------------------------------------------
-- Server version	5.6.24-log

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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `EMP_ID` varchar(10) NOT NULL,
  `EMP_FIRST_NAME` varchar(45) DEFAULT NULL,
  `EMP_LAST_NAME` varchar(45) DEFAULT NULL,
  `EMP_START_DT` date DEFAULT NULL,
  `EMP_END_DT` date DEFAULT NULL,
  `EMP_DOB` date DEFAULT NULL,
  `EMP_WORK_EMAILID` varchar(250) DEFAULT NULL,
  `STATUS_CODE` varchar(10) DEFAULT NULL,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_BY` varchar(45) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`EMP_ID`),
  UNIQUE KEY `EMP_WORK_EMAILID_UNIQUE` (`EMP_WORK_EMAILID`),
  KEY `fk_empstatus_emp_idx` (`STATUS_CODE`),
  CONSTRAINT `FK_EMP_STATUS_EMP` FOREIGN KEY (`STATUS_CODE`) REFERENCES `employee_status` (`STATUS_CODE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('100001','Rambabu ','Chimata','2015-02-16','2999-12-31','1980-01-01','rchimata@test.com','A','test','2015-07-30 13:08:36','test','2015-10-16 14:46:23');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_roles`
--

DROP TABLE IF EXISTS `employee_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_roles` (
  `EMP_ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_ID` varchar(10) NOT NULL,
  `EMPLOYEE_ROLE` varchar(20) NOT NULL,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_BY` varchar(45) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`EMP_ROLE_ID`),
  KEY `FK_EMP_ID_EMP_idx` (`EMPLOYEE_ID`),
  KEY `FK_EMP_ROLE_ID_ROLE_idx` (`EMPLOYEE_ROLE`),
  CONSTRAINT `FK_EMP_ID_EMP` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employee` (`EMP_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_EMP_ROLE_ID_ROLE` FOREIGN KEY (`EMPLOYEE_ROLE`) REFERENCES `role` (`ROLE_CD`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_roles`
--

LOCK TABLES `employee_roles` WRITE;
/*!40000 ALTER TABLE `employee_roles` DISABLE KEYS */;
INSERT INTO `employee_roles` VALUES (1,'100001','EMP','Test','2015-10-17 14:52:04','Test','2015-10-17 14:52:04'),(2,'100001','MGR','Test','2015-10-17 14:52:18','Test','2015-10-17 14:52:18');
/*!40000 ALTER TABLE `employee_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_status`
--

DROP TABLE IF EXISTS `employee_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_status` (
  `STATUS_CODE` varchar(10) NOT NULL,
  `STATUS_DESC` varchar(45) DEFAULT NULL,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_BY` varchar(45) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`STATUS_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_status`
--

LOCK TABLES `employee_status` WRITE;
/*!40000 ALTER TABLE `employee_status` DISABLE KEYS */;
INSERT INTO `employee_status` VALUES ('A','Active','test','2015-10-15 11:38:09','test','2015-10-15 11:38:09'),('I','In-Active','test','2015-10-15 11:38:19','test','2015-10-15 11:38:19'),('R','Resigned','test','2015-10-15 11:38:40','test','2015-10-15 11:38:40'),('T','Terminated','test','2015-10-15 11:38:31','test','2015-10-15 11:38:31');
/*!40000 ALTER TABLE `employee_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `ROLE_CD` varchar(20) NOT NULL,
  `ROLE_DESC` varchar(100) DEFAULT NULL,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_BY` varchar(45) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ROLE_CD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('EMP','Employee','Test','2015-10-17 14:48:52','Test','2015-10-17 14:48:52'),('MGR','MANAGER','Test','2015-10-17 14:49:07','Test','2015-10-17 14:49:07');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-17 15:58:30
