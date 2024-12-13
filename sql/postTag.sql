USE hightrafficboard;

-- 기존 postTag 테이블이 존재하면 삭제
DROP TABLE IF EXISTS `postTag`;

-- postTag 테이블 생성
CREATE TABLE `postTag` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `postId` INT NOT NULL,
  `tagId` INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `postId` (`postId`),
  KEY `tagId` (`tagId`),
  CONSTRAINT `postTag_ibfk_1` FOREIGN KEY (`postId`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `postTag_ibfk_2` FOREIGN KEY (`tagId`) REFERENCES `tag` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
