USE hightrafficboard;

-- 댓글 테이블이 이미 존재하면 삭제
DROP TABLE IF EXISTS `comment`;

-- 댓글 테이블 생성
CREATE TABLE `comment` (
  `id` INT NOT NULL AUTO_INCREMENT, -- 댓글 ID
  `postId` INT NOT NULL, -- 댓글이 달린 게시글 ID
  `userId` INT NOT NULL, -- 댓글 작성자 ID
  `subCommentId` INT DEFAULT NULL, -- 부모 댓글 ID (NULL이면 최상위 댓글)
  `contents` TEXT NOT NULL, -- 댓글 내용
  `isDeleted` TINYINT DEFAULT '0', -- 댓글 삭제 여부 (1이면 삭제된 댓글)
  PRIMARY KEY (`id`),
  FOREIGN KEY (`postId`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE, -- 게시글과 연관
  FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE, -- 작성자와 연관
  FOREIGN KEY (`subCommentId`) REFERENCES `comment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE -- 부모 댓글과 연관
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 댓글 데이터 확인용 SELECT
SELECT * FROM `comment`;