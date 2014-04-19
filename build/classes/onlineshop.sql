SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `c1_parknshop` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `c1_parknshop` ;

-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_customer` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `gender` TINYINT(4) NOT NULL COMMENT '男、女',
  `name` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `time_created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_seller`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_seller` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NOT NULL,
  `person_id_num` VARCHAR(45) NOT NULL COMMENT '身份证号',
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NOT NULL,
  `status` SMALLINT NULL,
  `name` VARCHAR(45) NOT NULL,
  `time_created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_administator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_administator` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_shop`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_shop` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_seller` INT UNSIGNED NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `status` SMALLINT NOT NULL,
  `introduction` VARCHAR(200) NULL,
  `time_created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`, `id_seller`),
  INDEX `fk_shop_seller_idx` (`id_seller` ASC),
  CONSTRAINT `fk_shop_seller`
    FOREIGN KEY (`id_seller`)
    REFERENCES `c1_parknshop`.`ps_seller` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_category` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_item` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_shop` INT UNSIGNED NOT NULL,
  `id_category` INT UNSIGNED NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `introduction` VARCHAR(500) NULL,
  `price` DECIMAL(9,2) NOT NULL,
  `extra_1` VARCHAR(120) NOT NULL,
  `extra_2` VARCHAR(45) NULL,
  `extra_3` VARCHAR(120) NULL,
  `time_created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_item_shop1_idx` (`id_shop` ASC),
  INDEX `fk_item_L1category1_idx` (`id_category` ASC),
  CONSTRAINT `fk_item_shop1`
    FOREIGN KEY (`id_shop`)
    REFERENCES `c1_parknshop`.`ps_shop` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_L1category1`
    FOREIGN KEY (`id_category`)
    REFERENCES `c1_parknshop`.`ps_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_order` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_customer` INT UNSIGNED NOT NULL,
  `id_shop` INT UNSIGNED NOT NULL,
  `status` TINYINT NOT NULL,
  `tracking_number` VARCHAR(45) NULL,
  `address` VARCHAR(200) NULL,
  `postal_code` VARCHAR(45) NULL,
  `name_recipient` VARCHAR(45) NULL,
  `phone_recipient` VARCHAR(45) NULL,
  `price_total` DECIMAL(15,2) NOT NULL,
  `time_created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_order_customer1_idx` (`id_customer` ASC),
  CONSTRAINT `fk_order_customer1`
    FOREIGN KEY (`id_customer`)
    REFERENCES `c1_parknshop`.`ps_customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_recipient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_recipient` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_customer` INT UNSIGNED NOT NULL,
  `name_recipient` VARCHAR(45) NOT NULL,
  `addresss` VARCHAR(100) NOT NULL,
  `postal_code` VARCHAR(20) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_receiver_customer1_idx` (`id_customer` ASC),
  CONSTRAINT `fk_receiver_customer1`
    FOREIGN KEY (`id_customer`)
    REFERENCES `c1_parknshop`.`ps_customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_tag` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`r_tag_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1_parknshop`.`r_tag_item` (
  `id_tag` INT UNSIGNED NOT NULL,
  `id_item` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_tag`, `id_item`),
  INDEX `fk_tag_has_item_item1_idx` (`id_item` ASC),
  INDEX `fk_tag_has_item_tag1_idx` (`id_tag` ASC),
  CONSTRAINT `fk_tag_has_item_tag1`
    FOREIGN KEY (`id_tag`)
    REFERENCES `c1_parknshop`.`ps_tag` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tag_has_item_item1`
    FOREIGN KEY (`id_item`)
    REFERENCES `c1_parknshop`.`ps_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`r_order_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1_parknshop`.`r_order_item` (
  `id_item` INT ZEROFILL NOT NULL,
  `id_order` INT ZEROFILL NOT NULL,
  `quantitiy` INT NOT NULL,
  `extra_1` VARCHAR(120) NULL,
  `extra_2` VARCHAR(120) NULL,
  PRIMARY KEY (`id_item`, `id_order`),
  INDEX `fk_order_has_item_item1_idx` (`id_item` ASC),
  INDEX `fk_order_has_item_order1_idx` (`id_order` ASC),
  CONSTRAINT `fk_order_has_item_item1`
    FOREIGN KEY (`id_item`)
    REFERENCES `c1_parknshop`.`ps_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_has_item_order1`
    FOREIGN KEY (`id_order`)
    REFERENCES `c1_parknshop`.`ps_order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`cart_customer_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1_parknshop`.`cart_customer_item` (
  `id_customer` INT UNSIGNED NOT NULL,
  `id_item` INT UNSIGNED NOT NULL,
  `quantity` INT NOT NULL,
  `extra_1` VARCHAR(120) NULL,
  `extra_2` VARCHAR(120) NULL COMMENT 'cart_customer_item' /* comment truncated */ /*is similar to r_order_item*/,
  PRIMARY KEY (`id_customer`, `id_item`),
  INDEX `fk_customer_has_item_item2_idx` (`id_item` ASC),
  INDEX `fk_customer_has_item_customer2_idx` (`id_customer` ASC),
  CONSTRAINT `fk_customer_has_item_customer2`
    FOREIGN KEY (`id_customer`)
    REFERENCES `c1_parknshop`.`ps_customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_has_item_item2`
    FOREIGN KEY (`id_item`)
    REFERENCES `c1_parknshop`.`ps_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`customer_favourite_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1_parknshop`.`customer_favourite_item` (
  `id_customer` INT UNSIGNED NOT NULL,
  `id_item` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_customer`, `id_item`),
  INDEX `fk_customer_has_item_item3_idx` (`id_item` ASC),
  INDEX `fk_customer_has_item_customer3_idx` (`id_customer` ASC),
  CONSTRAINT `fk_customer_has_item_customer3`
    FOREIGN KEY (`id_customer`)
    REFERENCES `c1_parknshop`.`ps_customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_has_item_item3`
    FOREIGN KEY (`id_item`)
    REFERENCES `c1_parknshop`.`ps_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_comment` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_customer` INT UNSIGNED NOT NULL,
  `id_item` INT UNSIGNED NOT NULL,
  `score` SMALLINT NULL,
  `content` VARCHAR(45) NULL,
  `time_created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  INDEX `fk_shop_has_customer_customer1_idx` (`id_customer` ASC),
  PRIMARY KEY (`id`),
  INDEX `fk_comment_has_item_idx` (`id_item` ASC),
  CONSTRAINT `fk_shop_has_customer_customer1`
    FOREIGN KEY (`id_customer`)
    REFERENCES `c1_parknshop`.`ps_customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_has_item`
    FOREIGN KEY (`id_item`)
    REFERENCES `c1_parknshop`.`ps_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_item_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_item_info` (
  `id_item` INT UNSIGNED NOT NULL,
  `description` VARCHAR(200) NULL,
  `url_pic` VARCHAR(100) NULL,
  PRIMARY KEY (`id_item`),
  CONSTRAINT `id_item`
    FOREIGN KEY (`id_item`)
    REFERENCES `c1_parknshop`.`ps_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
