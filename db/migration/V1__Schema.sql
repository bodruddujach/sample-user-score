DROP TABLE IF EXISTS `user_progress`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE IF NOT EXISTS `user` (

    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(200),
    `country` varchar(100),
    PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `user_progress` (

    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `level` int,
    `score` real,
    `user_id` bigint UNIQUE NOT NULL,
    PRIMARY KEY (`id`),
    foreign key (user_id) references user(id)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

FLUSH TABLES;
