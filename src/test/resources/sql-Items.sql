DROP TABLE IF EXISTS  `orders `;
DROP TABLE IF EXISTS  `customers`; 
DROP TABLE IF EXISTS `items`;

CREATE TABLE IF NOT EXISTS  `items` (
	 `ItemID` int NOT NULL AUTO_INCREMENT,
	  `order_item` varchar(30) NOT NULL,
	  `price` float NOT NULL,
	  PRIMARY KEY (`ItemID`)
);