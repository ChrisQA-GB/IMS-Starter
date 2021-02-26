drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`ItemID` int NOT NULL AUTO_INCREMENT,
	`order_item` varchar(30) DEFAULT NULL,
	`price` float DEFAULT NULL,
	PRIMARY KEY (`ItemID`),
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
	`OrderID` int NOT NULL AUTO_INCREMENT,
	`CustomerID` int DEFAULT NULL,
	`ItemID` int NOT NULL,
	`quantity` int DEFAULT NULL;
	PRIMARY KEY (`OrderID`),
	FOREIGN KEY (`CustomerID`) REFERENCES customers(`id`),
	FOREIGN KEY (`ItemID`) REFERENCES items(`ItemID`),
	);
	

