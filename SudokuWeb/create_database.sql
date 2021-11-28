CREATE USER 'mysqladmin'@'%' IDENTIFIED BY 'TitkosJelszo01';GRANT ALL PRIVILEGES ON *.* TO 'mysqladmin'@'%' REQUIRE NONE WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
-- DROP DATABASE sudoku;
CREATE DATABASE sudoku;
USE sudoku;

CREATE TABLE users (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    scoretoken VARCHAR(255) NOT NULL UNIQUE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- username: admin password(hashed): admin
INSERT INTO `users` (`id`, `username`, `password`, `scoretoken`, `created_at`) VALUES ('1', 'admin', '$2y$10$1NCHbyIJXXixl1a.Ah/Mwuv9ao5qqsMqirqB9fMA1taArgi35ebI6', 'sziauram', current_timestamp());
INSERT INTO `users` (`id`, `username`, `password`, `scoretoken`, `created_at`) VALUES ('2', 'Unregistered User', '$2y$10$2zisOxUZa3j.bX79XHATEuLogWoCh/abOnj0i7xO43GUl2i4rpXna', 'notregyet', current_timestamp());

CREATE TABLE scoreboard (
    userid INT NOT NULL,
    score VARCHAR(50) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO `scoreboard` (`userid`, `score`, `created_at`) VALUES ('1', '1337', current_timestamp());
INSERT INTO `scoreboard` (`userid`, `score`, `created_at`) VALUES ('1', '420', current_timestamp());
INSERT INTO `scoreboard` (`userid`, `score`, `created_at`) VALUES ('1', '69', current_timestamp());
INSERT INTO `scoreboard` (`userid`, `score`, `created_at`) VALUES ('1', '1848', current_timestamp());
INSERT INTO `scoreboard` (`userid`, `score`, `created_at`) VALUES ('1', '1222', current_timestamp());
INSERT INTO `scoreboard` (`userid`, `score`, `created_at`) VALUES ('1', '1964', current_timestamp());