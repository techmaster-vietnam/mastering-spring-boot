CREATE SCHEMA `mastering_spring_boot` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

CREATE TABLE IF NOT EXISTS users (
    `id` bigint unsigned NOT NULL AUTO_INCREMENT,
    `username` varchar(60) COLLATE utf8mb4_unicode_520_ci NOT NULL,
    `email` varchar(120) COLLATE utf8mb4_unicode_520_ci NOT NULL,
    `password` varchar(120) COLLATE utf8mb4_unicode_520_ci NOT NULL,
    `display_name` varchar(120) COLLATE utf8mb4_unicode_520_ci,
    `status` varchar(25) COLLATE utf8mb4_unicode_520_ci NOT NULL,
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `key_username` (`username`),
    UNIQUE KEY `key_email` (`email`),
    INDEX `index_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

CREATE TABLE IF NOT EXISTS access_tokens (
    `access_token` varchar(120) COLLATE utf8mb4_unicode_520_ci NOT NULL,
    `user_id` bigint unsigned NOT NULL,
    PRIMARY KEY (`access_token`),
    INDEX `index_user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
