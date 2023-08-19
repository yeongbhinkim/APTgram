-- 게시판 계층 테이블 삭제
DROP TABLE IF EXISTS Board;
-- 실시간 채팅 테이블 삭제
DROP TABLE IF EXISTS Chat;
-- 인기 게시물 순위 테이블 삭제
DROP TABLE IF EXISTS PopularPost;
-- 댓글 테이블 삭제
DROP TABLE IF EXISTS COMMENT;
-- 신고 테이블 삭제
DROP TABLE IF EXISTS Report;
-- 즐겨찾기 테이블 삭제
DROP TABLE IF EXISTS Favorite;
-- 게시글 테이블 삭제
DROP TABLE IF EXISTS Post;
-- 카테고리 테이블 삭제
DROP TABLE IF EXISTS Category;
-- 회원 테이블 삭제
DROP TABLE IF EXISTS USER;
-- 실시간 검색 순위 테이블 삭제
DROP TABLE IF EXISTS SearchRank;
-- 회원 계급 테이블 삭제
DROP TABLE IF EXISTS UserRank;
-- OAuth2 인증 테이블삭제
DROP TABLE IF EXISTS OAuth2Token;mysql


-- 회원 계급 테이블
CREATE TABLE UserRank (
 rank_id INT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(50),
 min_point INT,
 max_point INT
);


-- 회원 테이블
CREATE TABLE USER (
 user_id INT AUTO_INCREMENT PRIMARY KEY,
 rank_id INT,
 username VARCHAR(50),
 PASSWORD VARCHAR(255),
 email VARCHAR(100),
 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 last_login TIMESTAMP,
  POINT INT DEFAULT 0,
  FOREIGN KEY (rank_id) REFERENCES UserRank(rank_id)
);

-- 카테고리 테이블
CREATE TABLE Category (
 category_id INT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(255)
);

-- 게시글 테이블
CREATE TABLE Post (
 post_id INT AUTO_INCREMENT PRIMARY KEY,
 user_id INT,
 category_id INT,
 title VARCHAR(255),
 content TEXT,
 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 updated_at TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES USER(user_id),
  FOREIGN KEY (category_id) REFERENCES Category(category_id)
);

-- 댓글 테이블
CREATE TABLE COMMENT (
 comment_id INT AUTO_INCREMENT PRIMARY KEY,
 post_id INT,
 user_id INT,
 content TEXT,
 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (post_id) REFERENCES Post(post_id),
   FOREIGN KEY (user_id) REFERENCES USER(user_id)
);

-- 즐겨찾기 테이블
CREATE TABLE Favorite (
 user_id INT,
 post_id INT,
  STATUS ENUM('active', 'inactive') DEFAULT 'active',
   FOREIGN KEY (user_id) REFERENCES USER(user_id),
	 FOREIGN KEY (post_id) REFERENCES Post(post_id)
);


-- 신고 테이블
CREATE TABLE Report (
 report_id INT AUTO_INCREMENT PRIMARY KEY,
 user_id INT,
 post_id INT,
 reason VARCHAR(255),
 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES USER(user_id),
   FOREIGN KEY (post_id) REFERENCES Post(post_id)
);

-- 실시간 검색 순위 테이블
CREATE TABLE SearchRank (
 keyword VARCHAR(255) PRIMARY KEY,
  COUNT INT DEFAULT 0,
   RANK INT,
 updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 인기 게시물 순위 테이블
CREATE TABLE PopularPost (
 post_id INT,
  RANK INT,
 view_count INT,
  FOREIGN KEY (post_id) REFERENCES Post(post_id)
);

-- 실시간 채팅 테이블
CREATE TABLE Chat (
 chat_id INT AUTO_INCREMENT PRIMARY KEY,
 sender_id INT,
 receiver_id INT,
 message TEXT,
 sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (sender_id) REFERENCES USER(user_id),
   FOREIGN KEY (receiver_id) REFERENCES USER(user_id)
);

-- 게시판 계층 테이블
CREATE TABLE Board (
 board_id INT AUTO_INCREMENT PRIMARY KEY,
 parent_id INT DEFAULT NULL,
 name VARCHAR(255),
 description TEXT,
 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (parent_id) REFERENCES Board(board_id) ONDELETE SET NULL
);

CREATE TABLE OAuth2Token (
    token_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    access_token VARCHAR(255),
    refresh_token VARCHAR(255),
    token_type VARCHAR(50),
    expires_in INT,
    scope VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES User(user_id)
);


DROP SEQUENCE user_id_seq;
-- NEXT VALUE FOR user_id_seq  시퀀스
CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1;

-- 함수(Function) 예제
-- DROP FUNCTION add_numbers;
-- add_numbers(5, 3)   
-- DELIMITER //
-- CREATE FUNCTION add_numbers(a INT, b INT) RETURNS INT
-- BEGIN
--   RETURN a + b;
-- END;
-- //
-- DELIMITER ;

-- 프로시저(Procedure) 예제
-- DROP PROCEDURE find_greater_numbers;
-- CALL find_greater_numbers(100);
-- DELIMITER //
-- CREATE PROCEDURE find_greater_numbers(IN threshold INT)
-- BEGIN
--   SELECT * FROM your_table WHERE your_column > threshold;
-- END;
-- //
-- DELIMITER ;




