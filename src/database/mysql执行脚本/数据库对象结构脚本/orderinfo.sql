CREATE TABLE `orderinfo` (
    `name` varchar(50) NOT NULL,
    `yy_date` varchar(8) DEFAULT NULL,
    `yy_time` varchar(4) DEFAULT NULL,
    `yxbz` varchar(1) DEFAULT NULL,
    KEY `INDEX_DATE_TIME` (`yy_date`,`yy_time`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;