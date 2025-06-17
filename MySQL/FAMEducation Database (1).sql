-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `badge`
--

DROP TABLE IF EXISTS `badge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `badge` (
  `Nome` varchar(50) NOT NULL,
  `Descrizione` varchar(150) NOT NULL,
  `Immagine` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `badge`
--

LOCK TABLES `badge` WRITE;
/*!40000 ALTER TABLE `badge` DISABLE KEYS */;
INSERT INTO `badge` VALUES ('Accumulatore','Lo studente ha ottenuto un totale di 50 punti',NULL),('Consegnatore','Lo studente ha consegnato tutti i task che sono stati assegnati alla classe a cui appartiene','consegnatore.png'),('Perfezionista','Lo studente ha ottenuto il massimo ad almeno 3 task','perfezionista.png');
/*!40000 ALTER TABLE `badge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `badgeottenuti`
--

DROP TABLE IF EXISTS `badgeottenuti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `badgeottenuti` (
  `Studenti_Email` varchar(50) NOT NULL,
  `Badge_Nome` varchar(50) NOT NULL,
  `DataOttenimento` date NOT NULL,
  PRIMARY KEY (`Studenti_Email`,`Badge_Nome`),
  KEY `fk_Studenti_has_Badge_Badge1_idx` (`Badge_Nome`),
  KEY `fk_Studenti_has_Badge_Studenti1_idx` (`Studenti_Email`),
  CONSTRAINT `fk_Studenti_has_Badge_Badge1` FOREIGN KEY (`Badge_Nome`) REFERENCES `badge` (`Nome`),
  CONSTRAINT `fk_Studenti_has_Badge_Studenti1` FOREIGN KEY (`Studenti_Email`) REFERENCES `studenti` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `badgeottenuti`
--

LOCK TABLES `badgeottenuti` WRITE;
/*!40000 ALTER TABLE `badgeottenuti` DISABLE KEYS */;
INSERT INTO `badgeottenuti` VALUES ('diegoarmando@unina.it','Consegnatore','2025-07-01'),('diegoarmando@unina.it','Perfezionista','2025-07-01'),('mariannaarfe@unina.it','Accumulatore','2025-07-28'),('mariannaarfe@unina.it','Consegnatore','2025-07-28');
/*!40000 ALTER TABLE `badgeottenuti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classivirtuali`
--

DROP TABLE IF EXISTS `classivirtuali`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classivirtuali` (
  `CodiceUnivoco` varchar(8) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Docenti_Email` varchar(50) NOT NULL,
  PRIMARY KEY (`CodiceUnivoco`),
  KEY `fk_ClassiVirtuali_Docenti_idx` (`Docenti_Email`),
  CONSTRAINT `fk_ClassiVirtuali_Docenti` FOREIGN KEY (`Docenti_Email`) REFERENCES `docenti` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classivirtuali`
--

LOCK TABLES `classivirtuali` WRITE;
/*!40000 ALTER TABLE `classivirtuali` DISABLE KEYS */;
INSERT INTO `classivirtuali` VALUES ('i8k6j5h!','Ingegneria Del Software','pablopicasso@unina.it'),('n4m3b2v!','Analisi 2','martinpalumbo@unina.it'),('o2i3k4j!','Metodi Matematici','francol@unina.it'),('op3t5p4!','Analisi 1','martinpalumbo@unina.it'),('u6j5o34!','Sistemi Operativi','antonioconte@unina.it'),('v3c4n5m!','Controlli Automatici','francol@unina.it');
/*!40000 ALTER TABLE `classivirtuali` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consegne`
--

DROP TABLE IF EXISTS `consegne`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consegne` (
  `Soluzione` varchar(50) NOT NULL,
  `Punteggio` int DEFAULT NULL,
  `Studenti_Email` varchar(50) NOT NULL,
  `Task_Titolo` varchar(50) NOT NULL,
  `Task_Docenti_Email` varchar(50) NOT NULL,
  PRIMARY KEY (`Studenti_Email`,`Task_Titolo`,`Task_Docenti_Email`),
  KEY `fk_Consegne_Studenti1_idx` (`Studenti_Email`),
  KEY `fk_Consegne_Task1_idx` (`Task_Titolo`,`Task_Docenti_Email`),
  CONSTRAINT `fk_Consegne_Studenti1` FOREIGN KEY (`Studenti_Email`) REFERENCES `studenti` (`Email`),
  CONSTRAINT `fk_Consegne_Task1` FOREIGN KEY (`Task_Titolo`, `Task_Docenti_Email`) REFERENCES `task` (`Titolo`, `Docenti_Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consegne`
--

LOCK TABLES `consegne` WRITE;
/*!40000 ALTER TABLE `consegne` DISABLE KEYS */;
INSERT INTO `consegne` VALUES ('sequence.txt',5,'antoniocol1@unina.it','Sequence Diagram','pablopicasso@unina.it'),('eq_differenziali.txt',9,'auroraramaz@unina.it','Equazioni Differenziali','martinpalumbo@unina.it'),('laplace.txt',4,'biancolino@unina.it','Prova Laplace','francol@unina.it'),('limiti.txt',NULL,'demme33@unina.it','Esercizi Limiti','martinpalumbo@unina.it'),('esonero_fourier.txt',10,'diegoarmando@unina.it','Prova Fourier','francol@unina.it'),('esonero.txt',10,'diegoarmando@unina.it','Prova Laplace','francol@unina.it'),('esonero_residui.txt',10,'diegoarmando@unina.it','Prova Residui','francol@unina.it'),('sd.txt',5,'federicanargi@unina.it','Sequence Diagram','pablopicasso@unina.it'),('sequence_diagram.txt',2,'geolier1@unina.it','Sequence Diagram','pablopicasso@unina.it'),('fourier.txt',6,'gerryscotti@unina.it','Prova Fourier','francol@unina.it'),('laplace.txt',1,'gerryscotti@unina.it','Prova Laplace','francol@unina.it'),('es_residui.txt',4,'gerryscotti@unina.it','Prova Residui','francol@unina.it'),('seq_diagr.txt',4,'gianlucagaetano@unina.it','Sequence Diagram','pablopicasso@unina.it'),('es_laplace.txt',7,'gianlucagrign@unina.it','Prova Laplace','francol@unina.it'),('equazioni_differenziali.txt',8,'giuliadelellis@unina.it','Equazioni Differenziali','martinpalumbo@unina.it'),('simulazione.txt',30,'mariannaarfe@unina.it','Simulazione Esame','antonioconte@unina.it'),('simulazione_thread.txt',30,'mariannaarfe@unina.it','Simulazione Esame 2','antonioconte@unina.it'),('es_limiti.txt',NULL,'massimoran@unina.it','Esercizi Limiti','martinpalumbo@unina.it'),('esercizi_limiti.txt',NULL,'miriamleone@unina.it','Esercizi Limiti','martinpalumbo@unina.it');
/*!40000 ALTER TABLE `consegne` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docenti`
--

DROP TABLE IF EXISTS `docenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docenti` (
  `Email` varchar(50) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Cognome` varchar(50) NOT NULL,
  `Ruolo` enum('Studente','Docente') NOT NULL,
  `Password` varchar(15) NOT NULL,
  PRIMARY KEY (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docenti`
--

LOCK TABLES `docenti` WRITE;
/*!40000 ALTER TABLE `docenti` DISABLE KEYS */;
INSERT INTO `docenti` VALUES ('antonioconte@unina.it','Antonio','Conte','Docente','kdb1!'),('francol@unina.it','Francesco','Colella','Docente','avellino2!'),('martinpalumbo@unina.it','Martin','Palumbo','Docente','avellino3#'),('pablopicasso@unina.it','Pablo','Picasso','Docente','arte5@');
/*!40000 ALTER TABLE `docenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studenti`
--

DROP TABLE IF EXISTS `studenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studenti` (
  `Email` varchar(50) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Cognome` varchar(50) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `Ruolo` enum('Studente','Docente') NOT NULL,
  `ClassiVirtuali_CodiceUnivoco` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`Email`),
  KEY `fk_Studenti_ClassiVirtuali1_idx` (`ClassiVirtuali_CodiceUnivoco`),
  CONSTRAINT `fk_Studenti_ClassiVirtuali1` FOREIGN KEY (`ClassiVirtuali_CodiceUnivoco`) REFERENCES `classivirtuali` (`CodiceUnivoco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studenti`
--

LOCK TABLES `studenti` WRITE;
/*!40000 ALTER TABLE `studenti` DISABLE KEYS */;
INSERT INTO `studenti` VALUES ('achillelauro4@unina.it','Achille','Lauro','rollsroyce46!','Studente',NULL),('angelinamango@unina.it','Angelina','Mango','lanoia1!','Studente',NULL),('antoniocol1@unina.it','Antonio','Colella','salerno2?','Studente','i8k6j5h!'),('auroraramaz@unina.it','Aurora','Ramazzotti','acqua22!','Studente','n4m3b2v!'),('biancolino@unina.it','Raffaele','Biancolino','pitone12!','Studente','o2i3k4j!'),('demme33@unina.it','Diego','Demme','forzalupi1912!','Studente','op3t5p4!'),('diegoarmando@unina.it','Diego','Maradona','forzanapol!1926','Studente','o2i3k4j!'),('federicanargi@unina.it','Federica','Nargi','modella12!','Studente','i8k6j5h!'),('geolier1@unina.it','Emanuele','Palumbo','ijpmetupte2?','Studente','i8k6j5h!'),('gerryscotti@unina.it','Gerry','Scotti','risoscotti26!','Studente','o2i3k4j!'),('gianlucagaetano@unina.it','Gianluca','Gaetano','cagliari23@','Studente','i8k6j5h!'),('gianlucagrign@unina.it','Gianluca','Grignani','paradiso2?','Studente','o2i3k4j!'),('gigidalessio@unina.it','Luigi','D\'alessio','annare1@','Studente','v3c4n5m!'),('giovannidilorenzo@unina.it','Giovanni','Di Lorenzo','azzurra1#','Studente','v3c4n5m!'),('giuliadelellis@unina.it','Giulia','De Lellis','priscilla25!','Studente','n4m3b2v!'),('marcellabella@unina.it','Marcella','Bella','fortetosta5?','Studente',NULL),('mariannaarfe@unina.it','Marianna','Arfe','scott8!','Studente','u6j5o34!'),('massimoran@unina.it','Massimo','Ranieri','roserosse1#','Studente','op3t5p4!'),('miriamleone@unina.it','Miriam','Leone','rossa1!','Studente','op3t5p4!'),('pinodaniele@unina.it','Giuseppe','Daniele','napule1926@','Studente','v3c4n5m!'),('tonyeffe4@unina.it','Antonio','Effe','romaMia2!','Studente',NULL);
/*!40000 ALTER TABLE `studenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task` (
  `Titolo` varchar(50) NOT NULL,
  `Descrizione` varchar(150) NOT NULL,
  `Scadenza` date NOT NULL,
  `MaxPuntiAssegnabili` int NOT NULL,
  `Docenti_Email` varchar(50) NOT NULL,
  `ClassiVirtuali_CodiceUnivoco` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`Titolo`,`Docenti_Email`),
  KEY `fk_Task_Docenti1_idx` (`Docenti_Email`),
  KEY `fk_Task_ClassiVirtuali1_idx` (`ClassiVirtuali_CodiceUnivoco`),
  CONSTRAINT `fk_Task_ClassiVirtuali1` FOREIGN KEY (`ClassiVirtuali_CodiceUnivoco`) REFERENCES `classivirtuali` (`CodiceUnivoco`),
  CONSTRAINT `fk_Task_Docenti1` FOREIGN KEY (`Docenti_Email`) REFERENCES `docenti` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES ('Equazioni Differenziali','Svolgere almeno due dei tre esercizi sulle equazioni differenziali','2025-09-01',9,'martinpalumbo@unina.it','op3t5p4!'),('Esercizi Limiti','Svolgere almeno due dei tre esercizi proposti per poter ottenere la sufficienza','2025-07-01',9,'martinpalumbo@unina.it','op3t5p4!'),('Matlab','Consegnare lo script di matlab degli esercizi riguardanti i controllori dinamici','2025-10-11',13,'francol@unina.it','v3c4n5m!'),('Prova Fourier','Completare la prova assegnata per essere esonerati dallo svolgimento dell\'esercizio su Fourier all\'esame','2025-06-25',10,'francol@unina.it','o2i3k4j!'),('Prova Laplace','Completare la prova assegnata per essere esonerati dallo svolgimento dell\'esercizio su Laplace all\'esame','2025-06-15',10,'francol@unina.it','o2i3k4j!'),('Prova Residui','Completare la prova assegnata per essere esonerati dallo svolgimento dell\'esercizio sui residui all\'esame','2025-06-30',10,'francol@unina.it','o2i3k4j!'),('Sequence Diagram','Sviluppare il sequence diagram del caso d\'uso allegato alla prova','2025-06-17',5,'pablopicasso@unina.it','i8k6j5h!'),('Simulazione Esame','File da completare: header.h, main.c, client.c, server.c','2025-07-12',30,'antonioconte@unina.it','u6j5o34!'),('Simulazione Esame 2','Esercitazione sui thread. Da completare: header.h, main.c, client.c, server.c','2025-08-01',30,'antonioconte@unina.it','u6j5o34!');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-17 12:34:18
