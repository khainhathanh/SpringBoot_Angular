CREATE TABLE `perfume`.`roles` (
  `id_role` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id_role`));

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
  
  CREATE TABLE `perfume`.`trademarks` (
  `id_trademark` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL ,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id_trademark`));
  
  CREATE TABLE `perfume`.`perfumes` (
  `id_perfume` INT NOT NULL AUTO_INCREMENT,
  `id_trademark` INT NULL ,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `cost` decimal(18,5) NULL,
  `gender` int NULL,
  `origin` VARCHAR(45) NULL,
  `capacity` VARCHAR(20) NULL,
  `rating_level` int null,
  `status` int NULL,
  constraint FK_trademark_perfume foreign key(`id_trademark`) references`trademarks`(`id_trademark`),
  PRIMARY KEY (`id_perfume`));
  
  CREATE TABLE `perfume`.`comments` (
  `id_comment` INT NOT NULL AUTO_INCREMENT,
  `id_perfume` INT NULL ,
  `id_personcomment` INT NULL,
  `email` VARCHAR(45) NULL,
  `name_commnet` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `create_date` datetime NULL,
  `create_update` datetime NULL,
  constraint FK_comment_perfume foreign key(`id_perfume`) references`perfumes`(`id_perfume`),
  PRIMARY KEY (`id_comment`));
  
CREATE TABLE `perfume`.`admin` (
  `id_admin` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NULL ,
  `opt` int NULL,
  constraint FK_user_admin foreign key(`id_user`) references`users`(`id_user`),
  PRIMARY KEY (`id_admin`));
  
  CREATE TABLE `perfume`.`customers` (
  `id_customer` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NULL ,
  `level_usesystem` int NULL,
  constraint FK_user_customer foreign key(`id_user`) references`users`(`id_user`),
  PRIMARY KEY (`id_customer`));
  
  CREATE TABLE `perfume`.`orders` (
  `id_order` INT NOT NULL AUTO_INCREMENT,
  `id_customer` INT NULL ,
  `cost` decimal(18,5) NULL,
  `status` int NULL,
  PRIMARY KEY (`id_order`));
  
  CREATE TABLE `perfume`.`order-details` (
  `id_order` INT NOT NULL ,
  `id_perfume` INT NOT NULL ,
  `id_customer` INT NULL,
  `name_customer` VARCHAR(45) NULL,
  `quantity` int NULL,
  `cost` decimal(18,5) NULL,
  `status` int NULL,
  constraint FK_order_perfume foreign key(`id_perfume`) references`perfumes`(`id_perfume`),
  constraint FK_perfume_order foreign key(`id_order`) references`orders`(`id_order`),
  PRIMARY KEY (`id_order`,`id_perfume`));
  
  
  CREATE TABLE `perfume`.`voschers` (
  `id_voscher` INT NOT NULL AUTO_INCREMENT,
  `type_voscher` INT NULL ,
  `name_voscher` int NULL,
  `create_date` int NULL,
  `exp_date` int NULL,
  PRIMARY KEY (`id_voscher`));
  
  CREATE TABLE `perfume`.`detail-voschers` (
  `id_voscher` INT NOT NULL,
  `id_customer` INT NOT NULL ,
  `quantity` int NULL,
  constraint FK_voscher_customer foreign key(`id_voscher`) references`voschers`(`id_voscher`),
  constraint FK_customer_voscher foreign key(`id_customer`) references`customers`(`id_customer`),
  PRIMARY KEY (`id_voscher`,`id_customer`));
  
  CREATE TABLE `perfume`.`discount` (
  `id_discount` INT NOT NULL AUTO_INCREMENT,
  `id_voscher` INT NULL ,
  `discount_value` varchar(30) NULL,
  constraint FK_voscher_discount foreign key(`id_voscher`) references`voschers`(`id_voscher`),
  PRIMARY KEY (`id_discount`));
  
  CREATE TABLE `perfume`.`voscher-orders` (
  `id_voscherorder` INT NOT NULL AUTO_INCREMENT,
  `id_order` INT NULL ,
  `id_voscher` int NULL,
  `discount` decimal(18,5) NULL,
  `gift` varchar(45) NULL,
  constraint FK_voscher_order foreign key(`id_order`) references`orders`(`id_order`),
  constraint FK_voscher_order foreign key(`id_order`) references`orders`(`id_order`),
  PRIMARY KEY (`id_voscherorder`));
  
  CREATE TABLE `perfume`.`payments` (
  `id_payment` INT NOT NULL AUTO_INCREMENT,
  `id_customer` INT NULL ,
  `id_order` INT NULL,
  `name_customer` varchar(45) NULL,
  `type_customer` varchar(45) NULL,
  `phone` varchar(45) NULL,
  `email` varchar(45) NULL,
  `address` varchar(45) NULL,
  `description` varchar(2000) NULL,
  `total_cost` decimal(18,5) NULL,
  `deduction` varchar(45) NULL,
  `gift` varchar(45) null,
  `into_money` varchar(45) NULL,
  `payment-method` varchar(45) NULL,
  PRIMARY KEY (`id_payment`));
  
  CREATE TABLE `perfume`.`gift` (
  `id_gift` INT NOT NULL AUTO_INCREMENT,
  `id_voscher` INT NULL ,
  `name-voscher` int NULL,
  `cost` decimal(18,5) NULL,
  `so-luong` varchar(45) NULL,
  constraint FK_voscher_gift foreign key(`id_voscher`) references`voschers`(`id_voscher`),
  PRIMARY KEY (`id_gift`));
  
  CREATE TABLE `perfume`.`smells` (
  `id_smell` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_smell`));
  
  CREATE TABLE `perfume`.`perfume-smells` (
  `id_perfume` INT NOT NULL ,
  `id_smell` INT NOT NULL ,
  `quantity` int NULL,
  `cost` decimal(18,5) NULL,
  constraint FK_perfume_smell foreign key(`id_perfume`) references`perfumes`(`id_perfume`),
  constraint FK_smell_perfume foreign key(`id_smell`) references`smells`(`id_smell`),
  PRIMARY KEY (`id_perfume`,`id_smell`));
  