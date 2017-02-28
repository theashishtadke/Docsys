-- MySQL dump 10.13  Distrib 5.5.41, for Win32 (x86)
--
-- Host: localhost    Database: pro
-- ------------------------------------------------------
-- Server version	5.5.41

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
-- Table structure for table `demo`
--

DROP TABLE IF EXISTS `demo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `demo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `pass` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demo`
--

LOCK TABLES `demo` WRITE;
/*!40000 ALTER TABLE `demo` DISABLE KEYS */;
INSERT INTO `demo` VALUES (50,'vinay','priya');
/*!40000 ALTER TABLE `demo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `demo1`
--

DROP TABLE IF EXISTS `demo1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `demo1` (
  `formid` varchar(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `enroll` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demo1`
--

LOCK TABLES `demo1` WRITE;
/*!40000 ALTER TABLE `demo1` DISABLE KEYS */;
INSERT INTO `demo1` VALUES ('10','vinay','50'),('11','ajay','55'),('13','raju','50'),('13','kaju','50'),('13','ramu','50'),('13','ramu','50'),('13','ramu','50'),('13','ramu','50'),('13','ramu','50'),('13','ramu','50'),('13','ramu','50'),('13','ramu','50'),('13','ramu','50');
/*!40000 ALTER TABLE `demo1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fycm`
--

DROP TABLE IF EXISTS `fycm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fycm` (
  `roll_no` int(11) DEFAULT NULL,
  `sub` varchar(10) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fycm`
--

LOCK TABLES `fycm` WRITE;
/*!40000 ALTER TABLE `fycm` DISABLE KEYS */;
/*!40000 ALTER TABLE `fycm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fyej`
--

DROP TABLE IF EXISTS `fyej`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fyej` (
  `roll_no` int(11) DEFAULT NULL,
  `sub` varchar(10) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fyej`
--

LOCK TABLES `fyej` WRITE;
/*!40000 ALTER TABLE `fyej` DISABLE KEYS */;
/*!40000 ALTER TABLE `fyej` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fyif`
--

DROP TABLE IF EXISTS `fyif`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fyif` (
  `roll_no` int(11) DEFAULT NULL,
  `sub` varchar(10) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fyif`
--

LOCK TABLES `fyif` WRITE;
/*!40000 ALTER TABLE `fyif` DISABLE KEYS */;
/*!40000 ALTER TABLE `fyif` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `name` varchar(20) DEFAULT NULL,
  `activity` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES ('vinay','Logged in at 28/02/2015 14:54:07'),('admin','Logged in at 28/02/2015 15:18:11'),('admin','Logged in at 28/02/2015 15:23:04'),('admin','Logged in at 28/02/2015 15:24:06'),('admin','Logged in at 28/02/2015 16:38:53'),('vinay','Logged in at 28/02/2015 16:39:24'),('vinay','Logged in at 28/02/2015 19:58:42'),('vinay','Logged in at 28/02/2015 22:42:40'),('vinay','Logged in at 28/02/2015 22:44:02'),('vinay','Logged in at 28/02/2015 22:50:23'),('vinay','Logged in at 28/02/2015 22:52:12'),('vinay','Logged in at 28/02/2015 23:07:36'),('vinay','Logged in at 28/02/2015 23:11:12'),('vinay','Logged in at 28/02/2015 23:33:53'),('vinay','Logged in at 28/02/2015 23:43:51'),('vinay','Logged in at 01/03/2015 19:20:46'),('vinay','Logged in at 01/03/2015 23:35:16'),('vinay','Logged in at 01/03/2015 23:36:38'),('vinay','Logged in at 01/03/2015 23:38:03'),('vinay','Logged in at 01/03/2015 23:38:31'),('vinay','Logged in at 01/03/2015 23:40:44'),('vinay','Logged in at 01/03/2015 23:44:23'),('vinay','Logged in at 01/03/2015 23:49:35'),('vinay','Logged in at 01/03/2015 23:52:17'),('vinay','Logged in at 01/03/2015 23:53:06'),('vinay','Logged in at 01/03/2015 23:58:05'),('vinay','Logged in at 02/03/2015 00:01:42'),('vinay','Logged in at 02/03/2015 00:02:37'),('vinay','Logged in at 02/03/2015 00:05:07'),('vinay','Logged in at 02/03/2015 17:27:31'),('admin','Logged in at 02/03/2015 17:34:02'),('vinay','Logged in at 02/03/2015 18:53:42'),('vinay','Logged in at 02/03/2015 21:10:34'),('admin','Logged in at 04/03/2015 16:37:34'),('admin','Tried logging in at 04/03/2015 18:49:20'),('admin','Logged in at 04/03/2015 18:49:24'),('admin','Logged in at 04/03/2015 18:52:01'),('admin','Logged in at 04/03/2015 18:56:46'),('admin','Logged in at 04/03/2015 18:59:37'),('admin','Logged in at 04/03/2015 19:01:07'),('admin','Logged in at 04/03/2015 19:06:46'),('admin','Logged in at 04/03/2015 19:10:28'),('admin','Logged in at 04/03/2015 19:13:59'),('admin','Logged in at 04/03/2015 19:18:25'),('admin','Logged in at 04/03/2015 19:21:18'),('admin','Logged in at 04/03/2015 19:22:21'),('admin','Logged in at 04/03/2015 19:29:09'),('admin','Logged in at 04/03/2015 19:32:05'),('admin','Logged in at 04/03/2015 19:33:49'),('admin','Logged in at 04/03/2015 19:35:07'),('admin','Logged in at 04/03/2015 19:37:32'),('vinay','Logged in at 05/03/2015 18:14:18'),('vinay','Logged in at 05/03/2015 21:28:41'),('vinay','Logged in at 05/03/2015 21:42:09'),('vinay','Logged in at 05/03/2015 21:43:27'),('vinay','Logged in at 05/03/2015 22:29:07'),('vinay','Logged in at 05/03/2015 22:30:25'),('vinay','Logged in at 06/03/2015 16:49:29'),('vinay','Logged in at 09/03/2015 15:43:35'),('vinay','Logged in at 09/03/2015 15:44:06'),('vinay','Logged in at 09/03/2015 15:45:15'),('vinay','Logged in at 09/03/2015 15:57:39'),('vinay','Logged in at 09/03/2015 19:43:01'),('admin','Logged in at 09/03/2015 20:09:52'),('admin','Logged in at 09/03/2015 20:10:22'),('admin','Logged in at 09/03/2015 20:11:56'),('admin','Logged in at 09/03/2015 20:16:30'),('admin','Logged in at 09/03/2015 20:18:12'),('admin','Logged in at 09/03/2015 20:23:23'),('vinay','Logged in at 09/03/2015 20:37:46'),('vinay','Logged in at 09/03/2015 20:44:47'),('vinay','Logged in at 09/03/2015 20:46:02'),('vinay','Logged in at 09/03/2015 20:46:38'),('vinay','Logged in at 09/03/2015 20:47:38'),('vinay','Logged in at 09/03/2015 20:47:59'),('vinay','Logged in at 09/03/2015 20:51:26'),('admin','Logged in at 09/03/2015 22:01:08'),('admin','Logged in at 09/03/2015 22:02:24'),('admin','Logged in at 09/03/2015 22:04:13'),('admin','Logged in at 09/03/2015 22:07:06'),('vinay','Logged in at 09/03/2015 22:08:46'),('admin','Logged in at 09/03/2015 22:09:02'),('vinay','Logged in at 09/03/2015 22:12:38'),('vinay','Logged in at 09/03/2015 22:16:13'),('vinay','Tried logging in at 09/03/2015 22:27:23'),('vinay','Tried logging in at 09/03/2015 22:27:29'),('vinay','Logged in at 09/03/2015 22:27:33'),('admin','Logged in at 10/03/2015 12:18:25'),('admin','Logged in at 10/03/2015 13:56:51'),('admin','Logged in at 11/03/2015 14:51:11'),('admin','Logged in at 11/03/2015 15:05:05'),('vinay','Logged in at 11/03/2015 15:09:46'),('vinay','Logged in at 11/03/2015 15:13:01'),('vinay','Logged in at 11/03/2015 15:15:02'),('vinay','Logged in at 11/03/2015 15:29:01'),('vinay','Logged in at 11/03/2015 15:32:04'),('vinay','Logged in at 11/03/2015 15:34:37'),('vinay','Logged in at 11/03/2015 15:38:21'),('vinay','Logged in at 11/03/2015 15:39:23'),('vinay','Logged in at 11/03/2015 15:44:12'),('vinay','Logged in at 11/03/2015 15:46:57'),('vinay','Logged in at 11/03/2015 15:50:15'),('vinay','Logged in at 11/03/2015 15:52:14'),('vinay','Logged in at 11/03/2015 15:54:54'),('vinay','Logged in at 11/03/2015 16:00:46'),('vinay','Logged in at 11/03/2015 16:01:41'),(' vinay','Tried logging in at 11/03/2015 16:09:24'),(' vinay','Tried logging in at 11/03/2015 16:09:30'),(' vinay','Tried logging in at 11/03/2015 16:09:33'),('vinay','Logged in at 11/03/2015 16:09:36'),('vinay','Logged in at 11/03/2015 16:12:14'),('vinay','Logged in at 11/03/2015 16:13:30'),('vinay','Logged in at 11/03/2015 16:23:49'),('vinay','Tried logging in at 11/03/2015 16:24:51'),('vinay','Logged in at 11/03/2015 16:24:56'),('vinay','Logged in at 11/03/2015 16:29:13'),('vinay','Logged in at 11/03/2015 16:38:36'),('vinay','Logged in at 11/03/2015 16:41:44'),('vinay','Logged in at 11/03/2015 16:46:01'),('vinay','Logged in at 11/03/2015 16:47:34'),('vinay','Logged in at 11/03/2015 16:50:19'),('vinay','Logged in at 11/03/2015 16:53:30'),('vinay','Logged in at 11/03/2015 16:59:19'),('vinay','Logged in at 11/03/2015 17:00:27'),('vinay','Logged in at 11/03/2015 17:08:43'),('vinay','Logged in at 11/03/2015 17:13:06'),('vinay','Logged in at 11/03/2015 17:15:07'),('vinay','Tried logging in at 12/03/2015 13:53:49'),('vinay','Tried logging in at 12/03/2015 13:53:52'),('vinay','Logged in at 12/03/2015 13:53:59'),('vinay','Logged in at 12/03/2015 14:11:31'),('vinay','Logged in at 12/03/2015 14:22:23'),(' vinay','Tried logging in at 12/03/2015 14:24:19'),(' vinay','Tried logging in at 12/03/2015 14:24:25'),('vinay','Logged in at 12/03/2015 14:24:31'),('vinay','Logged in at 12/03/2015 14:37:08'),('vinay','Logged in at 12/03/2015 14:39:05'),('vinay','Logged in at 12/03/2015 14:41:11'),('vinay','Logged in at 12/03/2015 15:35:02'),('vinay','Logged in at 12/03/2015 15:42:27'),('vinay','Logged in at 12/03/2015 15:44:29'),('vinay','Logged in at 12/03/2015 15:45:40'),('vinay','Logged in at 12/03/2015 15:49:42'),('vinay','Tried logging in at 12/03/2015 16:17:34'),('vinay','Logged in at 12/03/2015 16:17:40'),('vinay','Logged in at 12/03/2015 16:20:11'),('vinay','Logged in at 12/03/2015 16:21:48'),('admin','Logged in at 12/03/2015 19:03:35'),('vinay','Logged in at 12/03/2015 19:10:31'),('admin','Logged in at 12/03/2015 19:11:00'),('vinay','Logged in at 13/03/2015 13:38:52'),('vinay','Tried logging in at 13/03/2015 13:39:09'),('vinay','Logged in at 13/03/2015 13:39:12'),('admin','Logged in at 13/03/2015 13:39:29'),('vinay','Logged in at 13/03/2015 14:07:34'),('vinay','Logged in at 13/03/2015 14:12:30'),('vinay','Logged in at 13/03/2015 14:15:41'),('vinay','Logged in at 13/03/2015 14:17:15'),('vinay','Logged in at 13/03/2015 14:20:26'),('vinay','Printed Direct Second Year Form Page1 at 13/03/2015 14:20:38'),('vinay','Logged in at 13/03/2015 14:22:37'),('vinay','Logged in at 13/03/2015 14:24:02'),('vinay','Logged in at 13/03/2015 14:26:30'),('vinay','Logged in at 13/03/2015 14:29:43'),('admin','Logged in at 13/03/2015 14:35:09'),('vinay','Logged in at 13/03/2015 14:37:28'),('vinay','Logged in at 13/03/2015 16:00:39'),('vinay','Logged in at 13/03/2015 16:08:35'),('vinay','Tried logging in at 13/03/2015 16:11:43'),('vinay','Logged in at 13/03/2015 16:11:48'),('vinay','Logged in at 13/03/2015 16:14:24'),('vinay','Logged in at 13/03/2015 16:16:43');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `namer` varchar(10) DEFAULT NULL,
  `passr` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES ('vinay','pass'),('jayesh','pass'),('admin','pass'),('ashish','pass'),('ashish','pass'),('ankush','pass'),('abc','xyz'),('ajay','pass');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `rollno` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `class` varchar(20) DEFAULT NULL,
  `grade` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  PRIMARY KEY (`rollno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sycm`
--

DROP TABLE IF EXISTS `sycm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sycm` (
  `roll_no` int(11) DEFAULT NULL,
  `sub` varchar(10) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sycm`
--

LOCK TABLES `sycm` WRITE;
/*!40000 ALTER TABLE `sycm` DISABLE KEYS */;
INSERT INTO `sycm` VALUES (1,'swt',25),(1,'omd',25),(1,'man',25),(1,'ajp',22),(1,'total',97),(1,'per',97);
/*!40000 ALTER TABLE `sycm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syej`
--

DROP TABLE IF EXISTS `syej`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syej` (
  `roll_no` int(11) DEFAULT NULL,
  `sub` varchar(10) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syej`
--

LOCK TABLES `syej` WRITE;
/*!40000 ALTER TABLE `syej` DISABLE KEYS */;
/*!40000 ALTER TABLE `syej` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syif`
--

DROP TABLE IF EXISTS `syif`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syif` (
  `roll_no` int(11) DEFAULT NULL,
  `sub` varchar(10) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syif`
--

LOCK TABLES `syif` WRITE;
/*!40000 ALTER TABLE `syif` DISABLE KEYS */;
/*!40000 ALTER TABLE `syif` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syllabus`
--

DROP TABLE IF EXISTS `syllabus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syllabus` (
  `syl` varchar(20) DEFAULT NULL,
  `sub` varchar(10) DEFAULT NULL,
  `sem` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syllabus`
--

LOCK TABLES `syllabus` WRITE;
/*!40000 ALTER TABLE `syllabus` DISABLE KEYS */;
INSERT INTO `syllabus` VALUES ('TYCM','swt',6),('TYCM','omd',6),('TYCM','man',6),('TYCM','ajp',6),('TYIF','abc',6),('TYIF','xyz',6),('TYIF','efg',6),('TYIF','elp',6),('TYIF','swt',6),('TYIF','ajp',6),('TYIF','mco',6),('TYIF','aef',6);
/*!40000 ALTER TABLE `syllabus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tycm`
--

DROP TABLE IF EXISTS `tycm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tycm` (
  `roll_no` int(11) DEFAULT NULL,
  `sub` varchar(10) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tycm`
--

LOCK TABLES `tycm` WRITE;
/*!40000 ALTER TABLE `tycm` DISABLE KEYS */;
INSERT INTO `tycm` VALUES (1,'swt',15),(1,'omd',15),(1,'man',15),(1,'ajp',15),(1,'total',60),(1,'per',60),(2,'swt',25),(2,'omd',25),(2,'man',25),(2,'ajp',25),(2,'total',100),(2,'per',100),(3,'swt',10),(3,'omd',12),(3,'man',12),(3,'ajp',12),(3,'total',46),(3,'per',46),(4,'swt',20),(4,'omd',20),(4,'man',20),(4,'ajp',20),(4,'total',80),(4,'per',80),(5,'swt',17),(5,'omd',17),(5,'man',17),(5,'ajp',17),(5,'total',68),(5,'per',68),(6,'swt',21),(6,'omd',21),(6,'man',21),(6,'ajp',21),(6,'total',84),(6,'per',84),(7,'swt',2),(7,'omd',23),(7,'man',1),(7,'ajp',21),(7,'total',47),(7,'per',47),(8,'swt',8),(8,'omd',8),(8,'man',8),(8,'ajp',8),(8,'total',32),(8,'per',32),(9,'swt',24),(9,'omd',24),(9,'man',24),(9,'ajp',24),(9,'total',96),(9,'per',96),(10,'swt',10),(10,'omd',12),(10,'man',32),(10,'ajp',12),(10,'total',66),(10,'per',66),(11,'swt',21),(11,'omd',12),(11,'man',2),(11,'ajp',12),(11,'total',47),(11,'per',47);
/*!40000 ALTER TABLE `tycm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tyej`
--

DROP TABLE IF EXISTS `tyej`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tyej` (
  `roll_no` int(11) DEFAULT NULL,
  `sub` varchar(10) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tyej`
--

LOCK TABLES `tyej` WRITE;
/*!40000 ALTER TABLE `tyej` DISABLE KEYS */;
/*!40000 ALTER TABLE `tyej` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tyif`
--

DROP TABLE IF EXISTS `tyif`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tyif` (
  `roll_no` int(11) DEFAULT NULL,
  `sub` varchar(10) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tyif`
--

LOCK TABLES `tyif` WRITE;
/*!40000 ALTER TABLE `tyif` DISABLE KEYS */;
/*!40000 ALTER TABLE `tyif` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uni`
--

DROP TABLE IF EXISTS `uni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uni` (
  `cand_f` varchar(20) DEFAULT NULL,
  `cand_fa` varchar(20) DEFAULT NULL,
  `cand_s` varchar(20) DEFAULT NULL,
  `cand_m` varchar(20) DEFAULT NULL,
  `dob_district` varchar(20) DEFAULT NULL,
  `dob_village` varchar(20) DEFAULT NULL,
  `dob_taluka` varchar(20) DEFAULT NULL,
  `dob_state` varchar(20) DEFAULT NULL,
  `name_father` varchar(20) DEFAULT NULL,
  `occupation` varchar(20) DEFAULT NULL,
  `relation` varchar(20) DEFAULT NULL,
  `land_num` varchar(20) DEFAULT NULL,
  `father_num` varchar(20) DEFAULT NULL,
  `income` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `mob_num` varchar(20) DEFAULT NULL,
  `email_id` varchar(20) DEFAULT NULL,
  `tot_marks` varchar(20) DEFAULT NULL,
  `per_marks` varchar(20) DEFAULT NULL,
  `qual_exam` varchar(20) DEFAULT NULL,
  `vacation_sub` varchar(20) DEFAULT NULL,
  `class` varchar(10) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `formid` int(10) NOT NULL AUTO_INCREMENT,
  `cast` varchar(10) DEFAULT NULL,
  `religion` varchar(10) DEFAULT NULL,
  `rollno` varchar(10) DEFAULT NULL,
  `DOBDate` varchar(10) DEFAULT NULL,
  `ssctot` varchar(10) DEFAULT NULL,
  `sscoutof_marks` varchar(10) DEFAULT NULL,
  `sscper` varchar(10) DEFAULT NULL,
  `vocationexam` varchar(20) DEFAULT NULL,
  `qoexam` varchar(20) DEFAULT NULL,
  `qmarks` varchar(20) DEFAULT NULL,
  `qper` varchar(20) DEFAULT NULL,
  `qyear` varchar(20) DEFAULT NULL,
  `enroll` varchar(10) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `mathmarks` varchar(20) DEFAULT NULL,
  `scimarks` varchar(20) DEFAULT NULL,
  `engmarks` varchar(20) DEFAULT NULL,
  `admindate` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`formid`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uni`
--

LOCK TABLES `uni` WRITE;
/*!40000 ALTER TABLE `uni` DISABLE KEYS */;
INSERT INTO `uni` VALUES ('vinay','subhash','patil','sulbha','Thane','kalyan','Thane','Maharastra','Subhash','pharamasist','son','9967406289','9869559212','5lacs','403,Dishank Tower,Khadakpada,kalyan	','8767541708','vinayp173@gmail.com','','98','HSC','','I',0,125,'open',NULL,'0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'120112011','male',NULL,NULL,NULL,NULL),('raju','subhash','patil','sulbha','Thane','kalyan','Thane','Maharastra','Subhash','pharamasist','son','9967406289','9869559212','5lacs','403,Dishank Tower,Khadakpada,kalyan	','8767541708','vinayp173@gmail.com','','99','HSC','','C',0,126,'open',NULL,'0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'120112000','male',NULL,NULL,NULL,NULL),('ram','ramesh','patil','pri','Thane','kalyan','Thane','Maharastra','Subhash','pharamasist','son','9967406289','9869559212','5lacs','403,Dishank Tower,Khadakpada,kalyan	','8767541708','vinayp173@gmail.com','','98','HSC','','C',0,127,'open',NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'120112001','male',NULL,NULL,NULL,NULL),('sanju','ramesh','patil','pri','Thane','kalyan','Thane','Maharastra','Subhash','pharamasist','son','9967406289','9869559212','5lacs','403,Dishank Tower,Khadakpada,kalyan	','8767541708','vinayp173@gmail.com','','97','HSC','','I',0,128,'open',NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'120112012','male',NULL,NULL,NULL,NULL),('','','','','','kalyan','','','','','','','','','','','','','','HSC','','',0,129,'open','','','null','','','','','','','','null','','male',NULL,NULL,NULL,NULL),('ajay','sujay','rai','5 lacs ','thane','kalyan','thane','mahastra','rai','doctor','son','02512231153','8767541767','5 lacs ','uihgyuhbyguuhyhuuhiihiu		','9869559213','vinayp173@gmail.com','400','90','0','HSC(sci)','E',0,130,'open','INDIAN','0','null','400','500','90','0','','','','2015-03-12','120112020','male',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `uni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vinay`
--

DROP TABLE IF EXISTS `vinay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vinay` (
  `rollno` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`rollno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vinay`
--

LOCK TABLES `vinay` WRITE;
/*!40000 ALTER TABLE `vinay` DISABLE KEYS */;
/*!40000 ALTER TABLE `vinay` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-13 17:59:35
