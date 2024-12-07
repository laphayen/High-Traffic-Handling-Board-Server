use hightrafficboard;

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

select * from category;