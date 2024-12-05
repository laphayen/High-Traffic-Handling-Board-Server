-- 기존 테이블이 존재하면 삭제
DROP TABLE IF EXISTS `user`;

-- 새 테이블 생성
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(45) NOT NULL,
  `isAdmin` tinyint DEFAULT '0',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `isWithDraw` tinyint DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userId` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 데이터 확인용 SELECT
SELECT * FROM `user`;
