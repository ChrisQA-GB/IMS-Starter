DROP TABLE IF EXISTS  `orders`;
DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS  `items`;


CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`),
);
CREATE TABLE IF NOT EXISTS  `items ` (
	 `ItemID` int NOT NULL AUTO_INCREMENT,
	  `order_item` varchar(30) NOT NULL,
	  `price` float,
	  PRIMARY KEY (`ItemID`),
);
CREATE TABLE IF NOT EXISTS `orders` ( 
`OrderID` int NOT NULL AUTO_INCREMENT,
	`CustomerID` int DEFAULT NULL,
	`ItemID` int NOT NULL,
	`quantity` int DEFAULT NULL;
	PRIMARY KEY (`OrderID`),
	FOREIGN KEY (`CustomerID`) REFERENCES customers(`id`) ON DELETE CASCADE,
	FOREIGN KEY (`ItemID`) REFERENCES items(`ItemID`) ON DELETE CASCADE
);
	
