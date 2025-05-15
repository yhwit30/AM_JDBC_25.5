DROP DATABASE IF EXISTS `AM_JDBC_2025_05`;
CREATE DATABASE `AM_JDBC_2025_05`;
USE `AM_JDBC_2025_05`;

CREATE TABLE `article`(
    `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `regDate` DATETIME NOT NULL,
    `updateDate` DATETIME NOT NULL,
    `title` CHAR(100) NOT NULL,
    `body` TEXT NOT NULL
);

INSERT INTO `article`
SET `regDate` = NOW(),
    `updateDate` = NOW(),
    `title` = '제목2',
    `body` = '내용2';

SELECT *
FROM `article`
ORDER BY `id` DESC;

UPDATE `article`
SET `updateDate` = NOW(),
    `title` = '제목1',
    `body` = '제목1'
WHERE `id` = 1;

INSERT INTO `article`
SET `regDate` = NOW(),
    `updateDate` = NOW(),
    `title` = '제목2',
    `body` = '내용2';

CREATE TABLE `member`(
    `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `regDate` DATETIME NOT NULL,
    `updateDate` DATETIME NOT NULL,
    `loginId` CHAR(30) NOT NULL,
    `loginPw` CHAR(100) NOT NULL,
    `name` CHAR(100) NOT NULL
);
DESC `member`;

INSERT INTO `member`
SET `regDate` = NOW(),
    `updateDate` = NOW(),
    `loginId` = 'test1',
    `loginPw` = 'test1',
    `name` = '홍길동';
INSERT INTO `member`
SET `regDate` = NOW(),
    `updateDate` = NOW(),
    `loginId` = 'test2',
    `loginPw` = 'test2',
    `name` = '김철수';
SELECT *
FROM `member`;