--liquibase formatted sql
--changeset alex:29/01/2017

        set foreign_key_checks = 0;

        drop table if exists user;
        CREATE TABLE `user` (
          `id` bigint(20) NOT NULL AUTO_INCREMENT,
          `login` varchar(255) NOT NULL ,
          `password` varchar(255) NOT NULL ,
          PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
