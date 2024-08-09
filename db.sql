DROP DATABASE IF EXISTS `24_08_Spring`;
CREATE DATABASE `24_08_Spring`;
USE `24_08_Spring`;

DROP TABLE article;
CREATE TABLE article(
      id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
      regDate DATETIME NOT NULL,
      updateDate DATETIME NOT NULL,
      title CHAR(100) NOT NULL,
      `body` TEXT NOT NULL
);

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = CONCAT ('제목', SUBSTRING(RAND()*1000 FROM 1 FOR 2)),
`body` = CONCAT ('내용', SUBSTRING(RAND()*1000 FROM 1 FOR 2));

SELECT *
FROM article;

DROP TABLE `member`;
CREATE TABLE `member` (
id INT PRIMARY KEY AUTO_INCREMENT,
regDate DATETIME,
loginId TEXT NOT NULL,
loginPw TEXT NOT NULL,
`name` TEXT NOT NULL
);


SELECT *
FROM `member`;

SELECT * 
FROM `member`
WHERE loginId = "asd" AND loginPw = "asd";