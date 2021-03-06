--
--
--        Copyright 2014 BitRangers
--  
--
--

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `c1_parknshop` ;
CREATE SCHEMA IF NOT EXISTS `c1_parknshop` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `c1_parknshop` ;

-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_customer` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_customer` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nickname` TEXT NOT NULL,
  `email` TEXT NOT NULL,
  `password` TEXT NOT NULL,
  `gender` TINYINT(4) NOT NULL COMMENT '男1、女0',
  `name` TEXT NULL,
  `birthday` DATE NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_seller`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_seller` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_seller` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nickname` TEXT NOT NULL,
  `person_id_num` TEXT NULL COMMENT '身份证号',
  `email` TEXT NULL,
  `password` TEXT NOT NULL,
  `status` SMALLINT NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `balance` DECIMAL(9,2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_administrator`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_administrator` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_administrator` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `email` TEXT NOT NULL,
  `name` TEXT NOT NULL,
  `password` TEXT NOT NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `balance` DECIMAL(9,2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_shop`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_shop` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_shop` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_seller` INT UNSIGNED NOT NULL,
  `name` TEXT NOT NULL,
  `status` SMALLINT NOT NULL,
  `introduction` TEXT NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `vote` DOUBLE NULL DEFAULT 0.0,
  PRIMARY KEY (`id`),
  INDEX `fk_shop_seller_idx` (`id_seller` ASC),
  CONSTRAINT `fk_shop_seller`
    FOREIGN KEY (`id_seller`)
    REFERENCES `c1_parknshop`.`ps_seller` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_category` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_category` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` TINYTEXT NOT NULL,
  `description` TEXT NULL,
  `extral_1` TEXT NULL,
  `extral_2` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_item` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_item` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_shop` INT UNSIGNED NOT NULL,
  `id_category` INT UNSIGNED NOT NULL,
  `name` TINYTEXT NOT NULL,
  `introduction` TEXT NULL,
  `price` DECIMAL(9,2) NOT NULL,
  `url_picture` TEXT NULL,
  `extra_1` TEXT NULL,
  `extra_2` TEXT NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `count_purchase` INT NOT NULL DEFAULT 0,
  `count_favourite` INT NOT NULL DEFAULT 0,
  `count_click` INT NOT NULL DEFAULT 0,
  `vote` DOUBLE NOT NULL DEFAULT 0.0,
  PRIMARY KEY (`id`),
  INDEX `fk_item_shop1_idx` (`id_shop` ASC),
  INDEX `fk_item_L1category1_idx` (`id_category` ASC),
  FULLTEXT INDEX `idx_txt_search` (`name` ASC, `introduction` ASC),
  CONSTRAINT `fk_item_shop1`
    FOREIGN KEY (`id_shop`)
    REFERENCES `c1_parknshop`.`ps_shop` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_item_L1category1`
    FOREIGN KEY (`id_category`)
    REFERENCES `c1_parknshop`.`ps_category` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_recipient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_recipient` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_recipient` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_customer` INT UNSIGNED NOT NULL,
  `name_recipient` TEXT NOT NULL,
  `addresss` TEXT NOT NULL,
  `postal_code` TEXT NOT NULL,
  `phone_number` TEXT NOT NULL,
  `country` VARCHAR(32) NULL DEFAULT 'P.R.China',
  `province` TEXT NULL,
  `city` TEXT NOT NULL,
  `detailed_addr` TEXT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_receiver_customer1_idx` (`id_customer` ASC),
  CONSTRAINT `fk_receiver_customer1`
    FOREIGN KEY (`id_customer`)
    REFERENCES `c1_parknshop`.`ps_customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_order` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_order` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_recip_addr` INT UNSIGNED NOT NULL,
  `id_customer` INT UNSIGNED NOT NULL,
  `id_shop` INT UNSIGNED NOT NULL,
  `status` TINYINT NOT NULL DEFAULT 0,
  `tracking_number` TEXT NULL,
  `price_total` DECIMAL(15,2) NOT NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `time_paid` TIMESTAMP NULL,
  `time_shipped` TIMESTAMP NULL,
  `time_delivered` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `id_recipient_idx` (`id_recip_addr` ASC),
  INDEX `fk_order_id_customer_idx` (`id_customer` ASC),
  INDEX `fk_order_id_shop_idx` (`id_shop` ASC),
  CONSTRAINT `id_recipient`
    FOREIGN KEY (`id_recip_addr`)
    REFERENCES `c1_parknshop`.`ps_recipient` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_order_id_customer`
    FOREIGN KEY (`id_customer`)
    REFERENCES `c1_parknshop`.`ps_customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_order_id_shop`
    FOREIGN KEY (`id_shop`)
    REFERENCES `c1_parknshop`.`ps_shop` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_tag` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_tag` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` TINYTEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`r_tag_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`r_tag_item` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`r_tag_item` (
  `id_tag` INT UNSIGNED NOT NULL,
  `id_item` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_tag`, `id_item`),
  INDEX `fk_tag_has_item_item1_idx` (`id_item` ASC),
  INDEX `fk_tag_has_item_tag1_idx` (`id_tag` ASC),
  CONSTRAINT `fk_tag_has_item_tag1`
    FOREIGN KEY (`id_tag`)
    REFERENCES `c1_parknshop`.`ps_tag` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_tag_has_item_item1`
    FOREIGN KEY (`id_item`)
    REFERENCES `c1_parknshop`.`ps_item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`r_order_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`r_order_item` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`r_order_item` (
  `id_item` INT ZEROFILL NOT NULL,
  `id_order` INT ZEROFILL NOT NULL,
  `quantitiy` INT NOT NULL,
  `extra_1` TEXT NULL,
  `extra_2` VARCHAR(45) NULL,
  PRIMARY KEY (`id_item`, `id_order`),
  INDEX `fk_order_has_item_item1_idx` (`id_item` ASC),
  INDEX `fk_order_has_item_order1_idx` (`id_order` ASC),
  CONSTRAINT `fk_order_has_item_item1`
    FOREIGN KEY (`id_item`)
    REFERENCES `c1_parknshop`.`ps_item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_order_has_item_order1`
    FOREIGN KEY (`id_order`)
    REFERENCES `c1_parknshop`.`ps_order` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`cart_customer_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`cart_customer_item` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`cart_customer_item` (
  `id_customer` INT UNSIGNED NOT NULL,
  `id_item` INT UNSIGNED NOT NULL,
  `quantity` INT NOT NULL,
  `extra_1` TEXT NULL,
  `extra_2` TEXT NULL COMMENT 'cart_customer_item\nis similar to r_order_item',
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_customer`, `id_item`),
  INDEX `fk_customer_has_item_item2_idx` (`id_item` ASC),
  INDEX `fk_customer_has_item_customer2_idx` (`id_customer` ASC),
  CONSTRAINT `fk_customer_has_item_customer2`
    FOREIGN KEY (`id_customer`)
    REFERENCES `c1_parknshop`.`ps_customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_customer_has_item_item2`
    FOREIGN KEY (`id_item`)
    REFERENCES `c1_parknshop`.`ps_item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`customer_favourite_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`customer_favourite_item` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`customer_favourite_item` (
  `id_customer` INT UNSIGNED NOT NULL,
  `id_item` INT UNSIGNED NOT NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_customer`, `id_item`),
  INDEX `fk_customer_has_item_item3_idx` (`id_item` ASC),
  INDEX `fk_customer_has_item_customer3_idx` (`id_customer` ASC),
  CONSTRAINT `fk_customer_has_item_customer3`
    FOREIGN KEY (`id_customer`)
    REFERENCES `c1_parknshop`.`ps_customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_customer_has_item_item3`
    FOREIGN KEY (`id_item`)
    REFERENCES `c1_parknshop`.`ps_item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_comment` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_comment` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_customer` INT UNSIGNED NOT NULL,
  `id_item` INT UNSIGNED NOT NULL,
  `score_item` INT UNSIGNED NOT NULL DEFAULT 0,
  `score_shop` INT UNSIGNED NOT NULL DEFAULT 0,
  `content` TEXT NULL,
  `time_created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  INDEX `fk_shop_has_customer_customer1_idx` (`id_customer` ASC),
  PRIMARY KEY (`id`),
  INDEX `fk_comment_has_item_idx` (`id_item` ASC),
  CONSTRAINT `fk_shop_has_customer_customer1`
    FOREIGN KEY (`id_customer`)
    REFERENCES `c1_parknshop`.`ps_customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_comment_has_item`
    FOREIGN KEY (`id_item`)
    REFERENCES `c1_parknshop`.`ps_item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_item_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_item_info` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_item_info` (
  `id` INT UNSIGNED NOT NULL,
  `id_item` INT UNSIGNED NOT NULL,
  `description` TEXT NULL,
  `url_pic` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_item_info_item_idx` (`id_item` ASC),
  CONSTRAINT `fk_item_info_item`
    FOREIGN KEY (`id_item`)
    REFERENCES `c1_parknshop`.`ps_item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`customer_favourite_shop`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`customer_favourite_shop` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`customer_favourite_shop` (
  `id_shop` INT UNSIGNED NOT NULL,
  `id_customer` INT UNSIGNED NOT NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_shop`, `id_customer`),
  INDEX `id_customer_idx` (`id_customer` ASC),
  CONSTRAINT `id_shop`
    FOREIGN KEY (`id_shop`)
    REFERENCES `c1_parknshop`.`ps_shop` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_customer`
    FOREIGN KEY (`id_customer`)
    REFERENCES `c1_parknshop`.`ps_customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_key_value`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_key_value` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_key_value` (
  `key` VARCHAR(128) NOT NULL,
  `val` MEDIUMBLOB NOT NULL,
  PRIMARY KEY (`key`),
  UNIQUE INDEX `key_UNIQUE` (`key` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_promot_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_promot_item` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_promot_item` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_item` INT UNSIGNED NOT NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `item_info` TEXT NULL,
  `description` TEXT NULL,
  `pic_url` TINYTEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_item_idx` (`id_item` ASC),
  CONSTRAINT `id_promt_to_item`
    FOREIGN KEY (`id_item`)
    REFERENCES `c1_parknshop`.`ps_item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_ad_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_ad_item` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_ad_item` (
  `id_promot` INT UNSIGNED NOT NULL,
  `time_start` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `time_end` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `weight` DOUBLE NOT NULL DEFAULT 0.0,
  `price` DECIMAL(9,2) NOT NULL DEFAULT 0.0,
  `num_fetched` INT UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_promot`),
  CONSTRAINT `id_promt_to_ad_item`
    FOREIGN KEY (`id_promot`)
    REFERENCES `c1_parknshop`.`ps_promot_item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_item_promot_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_item_promot_info` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_item_promot_info` (
  `id` INT UNSIGNED NOT NULL,
  `id_promt` INT UNSIGNED NOT NULL,
  `key` TEXT NULL,
  `value` TEXT NULL,
  PRIMARY KEY (`id`, `id_promt`),
  CONSTRAINT `id_promt_item_info`
    FOREIGN KEY (`id_promt`)
    REFERENCES `c1_parknshop`.`ps_promot_item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_recipient_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_recipient_log` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_recipient_log` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_customer` INT UNSIGNED NOT NULL,
  `name_recipient` TEXT NOT NULL,
  `addresss` TEXT NOT NULL,
  `postal_code` TEXT NOT NULL,
  `phone_number` TEXT NOT NULL,
  `country` VARCHAR(32) NULL DEFAULT 'P.R.China',
  `province` TEXT NULL,
  `city` TEXT NOT NULL,
  `detailed_addr` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_customer_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_customer_log` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_customer_log` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nickname` TEXT NOT NULL,
  `email` TEXT NOT NULL,
  `password` TEXT NOT NULL,
  `gender` TINYINT(4) NOT NULL COMMENT '男、女',
  `name` TEXT NULL,
  `birthday` DATE NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_order_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_order_log` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_order_log` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_recip_addr` INT UNSIGNED NOT NULL,
  `str_addr` TEXT NULL,
  `id_customer` INT UNSIGNED NOT NULL,
  `id_shop` INT UNSIGNED NOT NULL,
  `status` TINYINT NOT NULL,
  `tracking_number` TEXT NULL,
  `price_total` DECIMAL(15,2) NOT NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `time_paid` TIMESTAMP NULL,
  `time_delivered` TIMESTAMP NULL,
  `name_buyer` TEXT NULL,
  `name_shop` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_log_order_recipient_idx` (`id_recip_addr` ASC),
  INDEX `fk_log_order_customer_idx` (`id_customer` ASC),
  CONSTRAINT `fk_log_order_recipient`
    FOREIGN KEY (`id_recip_addr`)
    REFERENCES `c1_parknshop`.`ps_recipient_log` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_log_order_customer`
    FOREIGN KEY (`id_customer`)
    REFERENCES `c1_parknshop`.`ps_customer_log` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_seller_acc`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_seller_acc` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_seller_acc` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_seller` INT UNSIGNED NOT NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` DECIMAL(9,2) NOT NULL DEFAULT 0.0,
  `id_order_log` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_seller_id_idx` (`id_seller` ASC),
  INDEX `fk_seller_acc_order_log_idx` (`id_order_log` ASC),
  CONSTRAINT `fk_seller_id`
    FOREIGN KEY (`id_seller`)
    REFERENCES `c1_parknshop`.`ps_seller` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_seller_acc_order_log`
    FOREIGN KEY (`id_order_log`)
    REFERENCES `c1_parknshop`.`ps_order_log` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_admin_acc`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_admin_acc` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_admin_acc` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_admin` INT UNSIGNED NOT NULL,
  `amount` DECIMAL(9,2) NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_order_log` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_admin_acc_order_log_idx` (`id_order_log` ASC),
  CONSTRAINT `fk_admin`
    FOREIGN KEY (`id_admin`)
    REFERENCES `c1_parknshop`.`ps_administrator` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_admin_acc_order_log`
    FOREIGN KEY (`id_order_log`)
    REFERENCES `c1_parknshop`.`ps_order_log` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_notice_seller`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_notice_seller` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_notice_seller` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_seller` INT UNSIGNED NOT NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `source` TINYTEXT NULL,
  `message` TEXT NULL,
  `is_valid` TINYINT UNSIGNED NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_notice_seller`
    FOREIGN KEY (`id_seller`)
    REFERENCES `c1_parknshop`.`ps_seller` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_notice_customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_notice_customer` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_notice_customer` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_customer` INT UNSIGNED NOT NULL,
  `time_created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `source` TINYTEXT NULL,
  `message` TEXT NULL,
  `is_valid` TINYINT UNSIGNED NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_notice_customer`
    FOREIGN KEY (`id_customer`)
    REFERENCES `c1_parknshop`.`ps_customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_notice_admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_notice_admin` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_notice_admin` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_admin` INT UNSIGNED NOT NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `message` TEXT NULL,
  `source` TINYTEXT NULL,
  `is_valid` TINYINT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_id_admin`
    FOREIGN KEY (`id_admin`)
    REFERENCES `c1_parknshop`.`ps_administrator` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_config_key`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_config_key` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_config_key` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_valid` TINYINT NULL DEFAULT 1,
  `name` TINYTEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_config_val`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_config_val` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_config_val` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_key` INT UNSIGNED NOT NULL,
  `val` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_config_kv_idx` (`id_key` ASC),
  CONSTRAINT `fk_config_kv`
    FOREIGN KEY (`id_key`)
    REFERENCES `c1_parknshop`.`ps_config_key` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_promot_item_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_promot_item_log` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_promot_item_log` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_item` INT UNSIGNED NOT NULL,
  `id_shop` INT UNSIGNED NOT NULL,
  `id_seller` INT UNSIGNED NOT NULL,
  `weight` VARCHAR(45) NULL,
  `item_info` TEXT NULL,
  `description` TEXT NULL,
  `pic_url` TINYTEXT NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `time_start` TIMESTAMP NULL,
  `time_end` TIMESTAMP NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_seller_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_seller_log` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_seller_log` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nickname` TEXT NOT NULL,
  `person_id_num` TEXT NULL COMMENT '身份证号',
  `email` TEXT NULL,
  `password` TEXT NOT NULL,
  `status` SMALLINT NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `balance` DECIMAL(9,2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_shop_apply`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_shop_apply` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_shop_apply` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_seller` INT UNSIGNED NOT NULL,
  `message` TEXT NOT NULL,
  `approved` TINYINT NULL DEFAULT 0,
  `is_valid` TINYINT NULL DEFAULT 1,
  `time_created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_shop_apply_seller_idx` (`id_seller` ASC),
  CONSTRAINT `fk_shop_apply_seller`
    FOREIGN KEY (`id_seller`)
    REFERENCES `c1_parknshop`.`ps_seller` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_promot_shop`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_promot_shop` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_promot_shop` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_shop` INT UNSIGNED NOT NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `item_info` TEXT NULL,
  `description` TEXT NULL,
  `pic_url` TINYTEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_promt_to_item0_idx` (`id_shop` ASC),
  CONSTRAINT `id_promt_to_item0`
    FOREIGN KEY (`id_shop`)
    REFERENCES `c1_parknshop`.`ps_shop` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_ad_shop`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_ad_shop` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_ad_shop` (
  `id_promot` INT UNSIGNED NOT NULL,
  `time_start` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `time_end` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `weight` DOUBLE NOT NULL DEFAULT 0.0,
  `price` DECIMAL(9,2) NOT NULL DEFAULT 0.0,
  `num_fetched` INT UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_promot`),
  CONSTRAINT `id_promt_to_ad_item0`
    FOREIGN KEY (`id_promot`)
    REFERENCES `c1_parknshop`.`ps_promot_shop` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1_parknshop`.`ps_shop_promot_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c1_parknshop`.`ps_shop_promot_info` ;

CREATE TABLE IF NOT EXISTS `c1_parknshop`.`ps_shop_promot_info` (
  `id` INT UNSIGNED NOT NULL,
  `id_promt` INT UNSIGNED NOT NULL,
  `key` TEXT NULL,
  `value` TEXT NULL,
  PRIMARY KEY (`id`, `id_promt`),
  INDEX `id_promt_item_info0_idx` (`id_promt` ASC),
  CONSTRAINT `id_promt_item_info0`
    FOREIGN KEY (`id_promt`)
    REFERENCES `c1_parknshop`.`ps_promot_shop` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;