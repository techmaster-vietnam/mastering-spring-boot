CREATE SCHEMA `login` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;

use login;

CREATE TABLE IF NOT EXISTS `users` (
    `id` bigint unsigned NOT NULL AUTO_INCREMENT,
    `username` varchar(128) COLLATE utf8mb4_unicode_520_ci NOT NULL,
    `email` varchar(120) COLLATE utf8mb4_unicode_520_ci,
    `password` varchar(255) COLLATE utf8mb4_unicode_520_ci NOT NULL,
    `display_name` varchar(250) COLLATE utf8mb4_unicode_520_ci,
    `activation_token` varchar(255) COLLATE utf8mb4_unicode_520_ci,
    `status` varchar(25) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT 'INACTIVATED',
    PRIMARY KEY (`id`),
    UNIQUE KEY `key_username` (`username`),
    UNIQUE KEY `key_email` (`email`),
    UNIQUE KEY `key_activation_token` (`activation_token`),
    INDEX `index_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

CREATE TABLE IF NOT EXISTS `access_tokens` (
    `access_token` varchar(256) NOT NULL,
    `user_id` bigint NOT NULL,
    `expired_at` datetime NOT NULL,
    PRIMARY KEY (`access_token`),
    INDEX `index_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
