CREATE TABLE IF NOT EXISTS `user` (
    `userId` varchar(255) PRIMARY KEY,
    `userName` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `playCunt` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `object_oriented`.`score`  (
    `id` int(11) NOT NULL,
    `userId` varchar(255) NULL,
    `score` int(11) NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk` FOREIGN KEY (`userId`) REFERENCES `object_oriented`.`user` (`userId`)
);

CREATE TABLE IF NOT EXISTS `object_oriented`.`gameRecord` (
    `userId` varchar (255),
    `playCount` int(11),
    `digitGroup` varchar (255),
    `right` int(11),
    `semiRight` int (11),
    PRIMARY KEY (`userId`,`playCount`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;