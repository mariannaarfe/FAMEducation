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
-- Table `mydb`.`Docente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Docente` (
  `Email` VARCHAR(50) NOT NULL,
  `Nome` VARCHAR(50) NOT NULL,
  `Cognome` VARCHAR(50) NOT NULL,
  `Ruolo` ENUM('Studente', 'Docente') NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ClasseVirtuale`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ClasseVirtuale` (
  `CodiceUnivoco` VARCHAR(15) NOT NULL,
  `Nome` VARCHAR(15) NOT NULL,
  `Docente_Email` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`CodiceUnivoco`),
  INDEX `fk_ClasseVirtuale_Docente1_idx` (`Docente_Email` ASC) VISIBLE,
  CONSTRAINT `fk_ClasseVirtuale_Docente1`
    FOREIGN KEY (`Docente_Email`)
    REFERENCES `mydb`.`Docente` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Studente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Studente` (
  `Email` VARCHAR(50) NOT NULL,
  `Nome` VARCHAR(50) NOT NULL,
  `Cognome` VARCHAR(50) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Ruolo` ENUM('Studente', 'Docente') NOT NULL,
  `ClasseVirtuale_CodiceUnivoco` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`Email`),
  INDEX `fk_Studente_ClasseVirtuale_idx` (`ClasseVirtuale_CodiceUnivoco` ASC) VISIBLE,
  CONSTRAINT `fk_Studente_ClasseVirtuale`
    FOREIGN KEY (`ClasseVirtuale_CodiceUnivoco`)
    REFERENCES `mydb`.`ClasseVirtuale` (`CodiceUnivoco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Task` (
  `Titolo` VARCHAR(45) NOT NULL,
  `Descrizione` VARCHAR(45),
  `Scadenza` DATE NOT NULL,
  `MaxPuntiAssegnabili` INT NOT NULL,
  `ClasseVirtuale_CodiceUnivoco` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`Titolo`, `ClasseVirtuale_CodiceUnivoco`),
  INDEX `fk_Task_ClasseVirtuale1_idx` (`ClasseVirtuale_CodiceUnivoco` ASC) VISIBLE,
  CONSTRAINT `fk_Task_ClasseVirtuale1`
    FOREIGN KEY (`ClasseVirtuale_CodiceUnivoco`)
    REFERENCES `mydb`.`ClasseVirtuale` (`CodiceUnivoco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Consegna`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Consegna` (
  `Soluzione` VARCHAR(45) NOT NULL,
  `Punteggio` INT NOT NULL,
  `Studente_Email` VARCHAR(50) NOT NULL,
  `Task_Titolo` VARCHAR(45) NOT NULL,
  `Task_ClasseVirtuale_CodiceUnivoco` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`Studente_Email`, `Task_Titolo`, `Task_ClasseVirtuale_CodiceUnivoco`),
  INDEX `fk_Consegna_Studente1_idx` (`Studente_Email` ASC) VISIBLE,
  INDEX `fk_Consegna_Task1_idx` (`Task_Titolo` ASC, `Task_ClasseVirtuale_CodiceUnivoco` ASC) VISIBLE,
  CONSTRAINT `fk_Consegna_Studente1`
    FOREIGN KEY (`Studente_Email`)
    REFERENCES `mydb`.`Studente` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Consegna_Task1`
    FOREIGN KEY (`Task_Titolo` , `Task_ClasseVirtuale_CodiceUnivoco`)
    REFERENCES `mydb`.`Task` (`Titolo` , `ClasseVirtuale_CodiceUnivoco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Badge`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Badge` (
  `Nome` VARCHAR(45) NOT NULL,
  `Descrizione` VARCHAR(45) NOT NULL,
  `Immagine` VARCHAR(45) NULL,
  `Traguardo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Nome`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`BadgeOttenuto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`BadgeOttenuto` (
  `Studente_Email` VARCHAR(50) NOT NULL,
  `Badge_Nome` VARCHAR(45) NOT NULL,
  `DataOttenimento` DATE NOT NULL,
  PRIMARY KEY (`Studente_Email`, `Badge_Nome`),
  INDEX `fk_Studente_has_Badge_Badge1_idx` (`Badge_Nome` ASC) VISIBLE,
  INDEX `fk_Studente_has_Badge_Studente1_idx` (`Studente_Email` ASC) VISIBLE,
  CONSTRAINT `fk_Studente_has_Badge_Studente1`
    FOREIGN KEY (`Studente_Email`)
    REFERENCES `mydb`.`Studente` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Studente_has_Badge_Badge1`
    FOREIGN KEY (`Badge_Nome`)
    REFERENCES `mydb`.`Badge` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
