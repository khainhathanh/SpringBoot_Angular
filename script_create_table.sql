CREATE TABLE `perfume`.`roles` (
  `id_role` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `perfume`.`users` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `id_role` INT NULL ,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(200) NULL,
  PRIMARY KEY (`id_user`));
  
  
  CREATE TABLE `perfume`.`comments` (
  `id_comment` INT NOT NULL AUTO_INCREMENT,
  `id_perfume` INT NULL ,
  `id_personcomment` INT NULL,
  `email` VARCHAR(45) NULL,
  `name_commnet` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `create_date` datetime NULL,
  `create_update` datetime NULL,
  PRIMARY KEY (`id_comment`));
  
CREATE TABLE `perfume`.`admin` (
  `id_admin` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NULL ,
  `opt` int NULL,
  PRIMARY KEY (`id_admin`));
  
  CREATE TABLE `perfume`.`customers` (
  `id_customer` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NULL ,
  `level_usesystem` int NULL,
  PRIMARY KEY (`id_customer`));
  
  CREATE TABLE `perfume`.`perfumes` (
  `id_perfume` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NULL ,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `cost` decimal(18,5) NULL,
  `gioi-tinh` int NULL,
  `xuat-su` VARCHAR(45) NULL,
  `dung-tich` VARCHAR(20) NULL,
  `muc-do-danh-gia` int null,
  `status` int NULL,
  PRIMARY KEY (`id_perfume`));
  
  CREATE TABLE `perfume`.`thuong-hieu` (
  `id_thuong-hieu` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL ,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id_thuong-hieu`));
  
  
  CREATE TABLE `perfume`.`chi-tiet-don-hang` (
  `id_don-hang` INT NOT NULL AUTO_INCREMENT,
  `id_perfume` INT NULL ,
  `id_customer` VARCHAR(45) NULL,
  `name_customer` VARCHAR(45) NULL,
  `so-luong` int NULL,
  `cost` decimal(18,5) NULL,
  `status` int NULL,
  PRIMARY KEY (`id_don-hang`,`id_perfume`));
  
  CREATE TABLE `perfume`.`don-hang` (
  `id_don-hang` INT NOT NULL AUTO_INCREMENT,
  `id_customer` INT NULL ,
  `cost` decimal(18,5) NULL,
  `status` int NULL,
  PRIMARY KEY (`id_don-hang`,`id_perfume`));
  
  CREATE TABLE `perfume`.`voschers` (
  `id_voscher` INT NOT NULL AUTO_INCREMENT,
  `type_voscher` INT NULL ,
  `name_voscher` int NULL,
  `create_date` int NULL,
  `exp_date` int NULL,
  PRIMARY KEY (`id_don-hang`,`id_perfume`));
  
  CREATE TABLE `perfume`.`detail-voschers` (
  `id_voscher` INT NOT NULL AUTO_INCREMENT,
  `id_customer` INT NULL ,
  `so-luong` int NULL,
  PRIMARY KEY (`id_voscher`,`id_customer`));
  
  CREATE TABLE `perfume`.`giam-gia` (
  `id_decrease_cost` INT NOT NULL AUTO_INCREMENT,
  `id_voscher` INT NULL ,
  `giam-gia_value` varchar(30) NULL,
  PRIMARY KEY (`id_voscher`));
  
  CREATE TABLE `perfume`.`don-hang-voschers` (
  `id_don-hang-voscher` INT NOT NULL AUTO_INCREMENT,
  `id_don-hang` INT NULL ,
  `id_voscher` int NULL,
  `giam-gia` decimal(18,5) NULL,
  `gift` varchar(45) NULL,
  PRIMARY KEY (`id_voscher`,`id_customer`));
  
  CREATE TABLE `perfume`.`payments` (
  `id_payment` INT NOT NULL AUTO_INCREMENT,
  `id_customer` INT NULL ,
  `id_don-hang` int NULL,
  `name_customer` varchar(45) NULL,
  `type_customer` varchar(45) NULL,
  `phone` varchar(45) NULL,
  `email` varchar(45) NULL,
  `address` varchar(45) NULL,
  `description` varchar(2000) NULL,
  `total_cost` decimal(18,5) NULL,
  `khau-tru` varchar(45) NULL,
  `gift` varchar(45) null,
  `thanh-tien` varchar(45) NULL,
  `payment-method` varchar(45) NULL,
  PRIMARY KEY (`id_payment`));
  
  CREATE TABLE `perfume`.`gift` (
  `id_gift` INT NOT NULL AUTO_INCREMENT,
  `id_voscher` INT NULL ,
  `name-voscher` int NULL,
  `cost` decimal(18,5) NULL,
  `so-luong` varchar(45) NULL,
  PRIMARY KEY (`id_gift`));
  
  CREATE TABLE `perfume`.`huong` (
  `id_huong` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_huong`));
  
  CREATE TABLE `perfume`.`huong-nuoc-hoa` (
  `id_perfume` INT NOT NULL AUTO_INCREMENT,
  `id_huong` INT NULL ,
  `so-luong` int NULL,
  `cost` decimal(18,5) NULL,
  PRIMARY KEY (`id_gift`));
  