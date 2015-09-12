-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sceweb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sceweb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sceweb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `sceweb` ;

-- -----------------------------------------------------
-- Table `sceweb`.`Empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sceweb`.`Empresa` ;

CREATE TABLE IF NOT EXISTS `sceweb`.`Empresa` (
  `cnpj` VARCHAR(15) NOT NULL COMMENT '',
  `nomeDaEmpresa` VARCHAR(45) NOT NULL COMMENT '',
  `nomeFantasia` VARCHAR(45) NOT NULL COMMENT '',
  `endereco` VARCHAR(45) NOT NULL COMMENT '',
  `telefone` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`cnpj`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sceweb`.`Responsavel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sceweb`.`Responsavel` ;

CREATE TABLE IF NOT EXISTS `sceweb`.`Responsavel` (
  `cnpj` VARCHAR(15) NOT NULL COMMENT '',
  `responsavel` VARCHAR(45) NOT NULL COMMENT '',
  `telefoneResponsavel` VARCHAR(45) NOT NULL COMMENT '',
  `setor` VARCHAR(45) NOT NULL COMMENT '',
  `email` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`cnpj`)  COMMENT '',
  CONSTRAINT `fk_Responsavel_Empresa`
    FOREIGN KEY (`cnpj`)
    REFERENCES `sceweb`.`Empresa` (`cnpj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
