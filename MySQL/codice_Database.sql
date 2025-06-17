-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Docenti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Docenti` (
  `Email` VARCHAR(50) NOT NULL,
  `Nome` VARCHAR(50) NOT NULL,
  `Cognome` VARCHAR(50) NOT NULL,
  `Ruolo` ENUM('Studente', 'Docente') NOT NULL,
  `Password` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`Email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ClassiVirtuali`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ClassiVirtuali` (
  `CodiceUnivoco` VARCHAR(8) NOT NULL,
  `Nome` VARCHAR(50) NOT NULL,
  `Docenti_Email` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`CodiceUnivoco`),
  INDEX `fk_ClassiVirtuali_Docenti_idx` (`Docenti_Email` ASC) VISIBLE,
  CONSTRAINT `fk_ClassiVirtuali_Docenti`
    FOREIGN KEY (`Docenti_Email`)
    REFERENCES `mydb`.`Docenti` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Studenti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Studenti` (
  `Email` VARCHAR(50) NOT NULL,
  `Nome` VARCHAR(50) NOT NULL,
  `Cognome` VARCHAR(50) NOT NULL,
  `Password` VARCHAR(15) NOT NULL,
  `Ruolo` ENUM('Studente', 'Docente') NOT NULL,
  `ClassiVirtuali_CodiceUnivoco` VARCHAR(8) NULL,
  PRIMARY KEY (`Email`),
  INDEX `fk_Studenti_ClassiVirtuali1_idx` (`ClassiVirtuali_CodiceUnivoco` ASC) VISIBLE,
  CONSTRAINT `fk_Studenti_ClassiVirtuali1`
    FOREIGN KEY (`ClassiVirtuali_CodiceUnivoco`)
    REFERENCES `mydb`.`ClassiVirtuali` (`CodiceUnivoco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Task` (
  `Titolo` VARCHAR(50) NOT NULL,
  `Descrizione` VARCHAR(150) NOT NULL,
  `Scadenza` DATE NOT NULL,
  `MaxPuntiAssegnabili` INT NOT NULL,
  `Docenti_Email` VARCHAR(50) NOT NULL,
  `ClassiVirtuali_CodiceUnivoco` VARCHAR(8) NULL,
  PRIMARY KEY (`Titolo`, `Docenti_Email`),
  INDEX `fk_Task_Docenti1_idx` (`Docenti_Email` ASC) VISIBLE,
  INDEX `fk_Task_ClassiVirtuali1_idx` (`ClassiVirtuali_CodiceUnivoco` ASC) VISIBLE,
  CONSTRAINT `fk_Task_Docenti1`
    FOREIGN KEY (`Docenti_Email`)
    REFERENCES `mydb`.`Docenti` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Task_ClassiVirtuali1`
    FOREIGN KEY (`ClassiVirtuali_CodiceUnivoco`)
    REFERENCES `mydb`.`ClassiVirtuali` (`CodiceUnivoco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Consegne`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Consegne` (
  `Soluzione` VARCHAR(50) NOT NULL,
  `Punteggio` INT NULL,
  `Studenti_Email` VARCHAR(50) NOT NULL,
  `Task_Titolo` VARCHAR(50) NOT NULL,
  `Task_Docenti_Email` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`),
  INDEX `fk_Consegne_Studenti1_idx` (`Studenti_Email` ASC) VISIBLE,
  INDEX `fk_Consegne_Task1_idx` (`Task_Titolo` ASC, `Task_Docenti_Email` ASC) VISIBLE,
  CONSTRAINT `fk_Consegne_Studenti1`
    FOREIGN KEY (`Studenti_Email`)
    REFERENCES `mydb`.`Studenti` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Consegne_Task1`
    FOREIGN KEY (`Task_Titolo` , `Task_Docenti_Email`)
    REFERENCES `mydb`.`Task` (`Titolo` , `Docenti_Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Badge`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Badge` (
  `Nome` VARCHAR(50) NOT NULL,
  `Descrizione` VARCHAR(150) NOT NULL,
  `Immagine` VARCHAR(50) NULL,
  PRIMARY KEY (`Nome`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`BadgeOttenuti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`BadgeOttenuti` (
  `Studenti_Email` VARCHAR(50) NOT NULL,
  `Badge_Nome` VARCHAR(50) NOT NULL,
  `DataOttenimento` DATE NOT NULL,
  PRIMARY KEY (`Studenti_Email`, `Badge_Nome`),
  INDEX `fk_Studenti_has_Badge_Badge1_idx` (`Badge_Nome` ASC) VISIBLE,
  INDEX `fk_Studenti_has_Badge_Studenti1_idx` (`Studenti_Email` ASC) VISIBLE,
  CONSTRAINT `fk_Studenti_has_Badge_Studenti1`
    FOREIGN KEY (`Studenti_Email`)
    REFERENCES `mydb`.`Studenti` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Studenti_has_Badge_Badge1`
    FOREIGN KEY (`Badge_Nome`)
    REFERENCES `mydb`.`Badge` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydb`.`Docenti`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Docenti` (`Email`, `Nome`, `Cognome`, `Ruolo`, `Password`) VALUES ('antonioconte@unina.it', 'Antonio', 'Conte', 'Docente', 'kdb1!');
INSERT INTO `mydb`.`Docenti` (`Email`, `Nome`, `Cognome`, `Ruolo`, `Password`) VALUES ('pablopicasso@unina.it', 'Pablo', 'Picasso', 'Docente', 'arte5@');
INSERT INTO `mydb`.`Docenti` (`Email`, `Nome`, `Cognome`, `Ruolo`, `Password`) VALUES ('martinpalumbo@unina.it', 'Martin', 'Palumbo', 'Docente', 'avellino3#');
INSERT INTO `mydb`.`Docenti` (`Email`, `Nome`, `Cognome`, `Ruolo`, `Password`) VALUES ('francol@unina.it', 'Francesco', 'Colella', 'Docente', 'avellino2!');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`ClassiVirtuali`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`ClassiVirtuali` (`CodiceUnivoco`, `Nome`, `Docenti_Email`) VALUES ('op3t5p4!', 'Analisi 1', 'martinpalumbo@unina.it');
INSERT INTO `mydb`.`ClassiVirtuali` (`CodiceUnivoco`, `Nome`, `Docenti_Email`) VALUES ('o2i3k4j!', 'Metodi Matematici', 'francol@unina.it');
INSERT INTO `mydb`.`ClassiVirtuali` (`CodiceUnivoco`, `Nome`, `Docenti_Email`) VALUES ('u6j5o34!', 'Sistemi Operativi', 'antonioconte@unina.it');
INSERT INTO `mydb`.`ClassiVirtuali` (`CodiceUnivoco`, `Nome`, `Docenti_Email`) VALUES ('i8k6j5h!', 'Ingegneria Del Software', 'pablopicasso@unina.it');
INSERT INTO `mydb`.`ClassiVirtuali` (`CodiceUnivoco`, `Nome`, `Docenti_Email`) VALUES ('n4m3b2v!', 'Analisi 2', 'martinpalumbo@unina.it');
INSERT INTO `mydb`.`ClassiVirtuali` (`CodiceUnivoco`, `Nome`, `Docenti_Email`) VALUES ('v3c4n5m!', 'Controlli Automatici', 'francol@unina.it');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Studenti`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('diegoarmando@unina.it', 'Diego', 'Maradona', 'forzanapol!1926', 'Studente', 'o2i3k4j!');
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('demme33@unina.it', 'Diego', 'Demme', 'forzalupi1912!', 'Studente', 'op3t5p4!');
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('gianlucagaetano@unina.it', 'Gianluca', 'Gaetano', 'cagliari23@', 'Studente', 'i8k6j5h!');
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('pinodaniele@unina.it', 'Giuseppe', 'Daniele', 'napule1926@', 'Studente', 'v3c4n5m!');
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('biancolino@unina.it', 'Raffaele', 'Biancolino', 'pitone12!', 'Studente', 'o2i3k4j!');
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('giovannidilorenzo@unina.it', 'Giovanni', 'Di Lorenzo', 'azzurra1#', 'Studente', 'v3c4n5m!');
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('gigidalessio@unina.it', 'Luigi', 'D\'alessio', 'annare1@', 'Studente', 'v3c4n5m!');
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('gianlucagrign@unina.it', 'Gianluca', 'Grignani', 'paradiso2?', 'Studente', 'o2i3k4j!');
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('gerryscotti@unina.it', 'Gerry', 'Scotti', 'risoscotti26!', 'Studente', 'o2i3k4j!');
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('achillelauro4@unina.it', 'Achille', 'Lauro', 'rollsroyce46!', 'Studente', NULL);
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('tonyeffe4@unina.it', 'Antonio', 'Effe', 'romaMia2!', 'Studente', NULL);
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('antoniocol1@unina.it', 'Antonio', 'Colella', 'salerno2?', 'Studente', 'i8k6j5h!');
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('mariannaarfe@unina.it', 'Marianna', 'Arfe', 'scott8!', 'Studente', 'u6j5o34!');
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('massimoran@unina.it', 'Massimo', 'Ranieri', 'roserosse1#', 'Studente', 'op3t5p4!');
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('geolier1@unina.it', 'Emanuele', 'Palumbo', 'ijpmetupte2?', 'Studente', 'i8k6j5h!');
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('angelinamango@unina.it', 'Angelina', 'Mango', 'lanoia1!', 'Studente', NULL);
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('marcellabella@unina.it', 'Marcella', 'Bella', 'fortetosta5?', 'Studente', NULL);
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('giuliadelellis@unina.it', 'Giulia', 'De Lellis', 'priscilla25!', 'Studente', 'n4m3b2v!');
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('miriamleone@unina.it', 'Miriam', 'Leone', 'rossa1!', 'Studente', 'op3t5p4!');
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('auroraramaz@unina.it', 'Aurora', 'Ramazzotti', 'acqua22!', 'Studente', 'n4m3b2v!');
INSERT INTO `mydb`.`Studenti` (`Email`, `Nome`, `Cognome`, `Password`, `Ruolo`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('federicanargi@unina.it', 'Federica', 'Nargi', 'modella12!', 'Studente', 'i8k6j5h!');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Task`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Task` (`Titolo`, `Descrizione`, `Scadenza`, `MaxPuntiAssegnabili`, `Docenti_Email`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('Esercizi Limiti', 'Svolgere almeno due dei tre esercizi proposti per poter ottenere la sufficienza', '2025-07-01', 9, 'martinpalumbo@unina.it', 'op3t5p4!');
INSERT INTO `mydb`.`Task` (`Titolo`, `Descrizione`, `Scadenza`, `MaxPuntiAssegnabili`, `Docenti_Email`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('Prova Laplace', 'Completare la prova assegnata per essere esonerati dallo svolgimento dell\'esercizio su Laplace all\'esame', '2025-06-15', 10, 'francol@unina.it', 'o2i3k4j!');
INSERT INTO `mydb`.`Task` (`Titolo`, `Descrizione`, `Scadenza`, `MaxPuntiAssegnabili`, `Docenti_Email`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('Simulazione Esame', 'File da completare: header.h, main.c, client.c, server.c', '2025-07-12', 30, 'antonioconte@unina.it', 'u6j5o34!');
INSERT INTO `mydb`.`Task` (`Titolo`, `Descrizione`, `Scadenza`, `MaxPuntiAssegnabili`, `Docenti_Email`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('Sequence Diagram', 'Sviluppare il sequence diagram del caso d\'uso allegato alla prova', '2025-06-17', 5, 'pablopicasso@unina.it', 'i8k6j5h!');
INSERT INTO `mydb`.`Task` (`Titolo`, `Descrizione`, `Scadenza`, `MaxPuntiAssegnabili`, `Docenti_Email`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('Equazioni Differenziali', 'Svolgere almeno due dei tre esercizi sulle equazioni differenziali', '2025-09-01', 9, 'martinpalumbo@unina.it', 'op3t5p4!');
INSERT INTO `mydb`.`Task` (`Titolo`, `Descrizione`, `Scadenza`, `MaxPuntiAssegnabili`, `Docenti_Email`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('Matlab', 'Consegnare lo script di matlab degli esercizi riguardanti i controllori dinamici', '2025-10-11', 13, 'francol@unina.it', 'v3c4n5m!');
INSERT INTO `mydb`.`Task` (`Titolo`, `Descrizione`, `Scadenza`, `MaxPuntiAssegnabili`, `Docenti_Email`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('Simulazione Esame 2', 'Esercitazione sui thread. Da completare: header.h, main.c, client.c, server.c', '2025-08-01', 30, 'antonioconte@unina.it', 'u6j5o34!');
INSERT INTO `mydb`.`Task` (`Titolo`, `Descrizione`, `Scadenza`, `MaxPuntiAssegnabili`, `Docenti_Email`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('Prova Fourier', 'Completare la prova assegnata per essere esonerati dallo svolgimento dell\'esercizio su Fourier all\'esame', '2025-06-25', 10, 'francol@unina.it', 'o2i3k4j!');
INSERT INTO `mydb`.`Task` (`Titolo`, `Descrizione`, `Scadenza`, `MaxPuntiAssegnabili`, `Docenti_Email`, `ClassiVirtuali_CodiceUnivoco`) VALUES ('Prova Residui', 'Completare la prova assegnata per essere esonerati dallo svolgimento dell\'esercizio sui residui all\'esame', '2025-06-30', 10, 'francol@unina.it', 'o2i3k4j!');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Consegne`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('es_limiti.txt', NULL, 'massimoran@unina.it', 'Esercizi Limiti', 'martinpalumbo@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('esercizi_limiti.txt', NULL, 'miriamleone@unina.it', 'Esercizi Limiti', 'martinpalumbo@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('limiti.txt', NULL, 'demme33@unina.it', 'Esercizi Limiti', 'martinpalumbo@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('esonero.txt', 10, 'diegoarmando@unina.it', 'Prova Laplace', 'francol@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('laplace.txt', 4, 'biancolino@unina.it', 'Prova Laplace', 'francol@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('es_laplace.txt', 7, 'gianlucagrign@unina.it', 'Prova Laplace', 'francol@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('laplace.txt', 1, 'gerryscotti@unina.it', 'Prova Laplace', 'francol@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('simulazione.txt', 30, 'mariannaarfe@unina.it', 'Simulazione Esame', 'antonioconte@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('simulazione_thread.txt', 30, 'mariannaarfe@unina.it', 'Simulazione Esame 2', 'antonioconte@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('sd.txt', 5, 'federicanargi@unina.it', 'Sequence Diagram', 'pablopicasso@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('sequence_diagram.txt', 2, 'geolier1@unina.it', 'Sequence Diagram', 'pablopicasso@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('seq_diagr.txt', 4, 'gianlucagaetano@unina.it', 'Sequence Diagram', 'pablopicasso@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('sequence.txt', 5, 'antoniocol1@unina.it', 'Sequence Diagram', 'pablopicasso@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('eq_differenziali.txt', 9, 'auroraramaz@unina.it', 'Equazioni Differenziali', 'martinpalumbo@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('equazioni_differenziali.txt', 8, 'giuliadelellis@unina.it', 'Equazioni Differenziali', 'martinpalumbo@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('esonero_fourier.txt', 10, 'diegoarmando@unina.it', 'Prova Fourier', 'francol@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('fourier.txt', 6, 'gerryscotti@unina.it', 'Prova Fourier', 'francol@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('esonero_residui.txt', 10, 'diegoarmando@unina.it', 'Prova Residui', 'francol@unina.it');
INSERT INTO `mydb`.`Consegne` (`Soluzione`, `Punteggio`, `Studenti_Email`, `Task_Titolo`, `Task_Docenti_Email`) VALUES ('es_residui.txt', 4, 'gerryscotti@unina.it', 'Prova Residui', 'francol@unina.it');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Badge`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Badge` (`Nome`, `Descrizione`, `Immagine`) VALUES ('Consegnatore', 'Lo studente ha consegnato tutti i task che sono stati assegnati alla classe a cui appartiene', 'consegnatore.png');
INSERT INTO `mydb`.`Badge` (`Nome`, `Descrizione`, `Immagine`) VALUES ('Perfezionista', 'Lo studente ha ottenuto il massimo ad almeno 3 task', 'perfezionista.png');
INSERT INTO `mydb`.`Badge` (`Nome`, `Descrizione`, `Immagine`) VALUES ('Accumulatore', 'Lo studente ha ottenuto un totale di 50 punti', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`BadgeOttenuti`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`BadgeOttenuti` (`Studenti_Email`, `Badge_Nome`, `DataOttenimento`) VALUES ('mariannaarfe@unina.it', 'Consegnatore', '2025-07-28');
INSERT INTO `mydb`.`BadgeOttenuti` (`Studenti_Email`, `Badge_Nome`, `DataOttenimento`) VALUES ('diegoarmando@unina.it', 'Consegnatore', '2025-07-01');
INSERT INTO `mydb`.`BadgeOttenuti` (`Studenti_Email`, `Badge_Nome`, `DataOttenimento`) VALUES ('diegoarmando@unina.it', 'Perfezionista', '2025-07-01');
INSERT INTO `mydb`.`BadgeOttenuti` (`Studenti_Email`, `Badge_Nome`, `DataOttenimento`) VALUES ('mariannaarfe@unina.it', 'Accumulatore', '2025-07-28');

COMMIT;

