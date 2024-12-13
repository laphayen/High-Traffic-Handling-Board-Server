USE hightrafficboard;

-- 기존 tag 테이블이 존재하면 삭제
DROP TABLE IF EXISTS `tag`;

-- tag 테이블 생성
CREATE TABLE `tag` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tagName` VARCHAR(45) NOT NULL,
  `url` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tagName` (`tagName`) -- tagName에 대해 유니크 제약 조건 추가
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
