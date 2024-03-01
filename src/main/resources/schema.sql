--USE venus_planner;

CREATE TABLE `roll`
(
    `id`   BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(10) NOT NULL COMMENT 'Leader/Member'
);

CREATE TABLE `member_study`
(
    `id`                BIGINT    NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `member_id`         BIGINT    NOT NULL,
    `study_id`          BIGINT    NOT NULL,
    `roll_id`           BIGINT    NOT NULL,
    `permission_id`     BIGINT    NOT NULL,
    `registration_time` TIMESTAMP NOT NULL
);

CREATE TABLE `member`
(
    `id`           BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `sign_type`    BIGINT       NOT NULL,
    `email`        VARCHAR(255) NOT NULL COMMENT 'OAuth 아이디 (이메일 형식)',
    `nickname`     VARCHAR(50)  NOT NULL COMMENT 'OAuth 이름(닉네임)',
    `created_time` TIMESTAMP    NOT NULL
);

CREATE TABLE `study`
(
    `id`           BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`         VARCHAR(100) NOT NULL,
    `created_time` TIMESTAMP    NOT NULL,
    `description`  VARCHAR(255) NULL
);

CREATE TABLE `sign_in_type`
(
    `id`   BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(10) NOT NULL
);

CREATE TABLE `plan`
(
    `id`                  BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `category_id`         BIGINT       NULL,
    `study_id`            BIGINT       NOT NULL,
    `recurring_option_id` BIGINT       NULL,
    `title`               VARCHAR(100) NULL,
    `description`         VARCHAR(255) NULL,
    `start_time`          TIMESTAMP    NOT NULL,
    `end_time`            TIMESTAMP    NOT NULL,
    `notification_time`   TIMESTAMP    NULL
);

CREATE TABLE `category`
(
    `id`               BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `study_id`         BIGINT      NOT NULL,
    `title`            VARCHAR(50) NOT NULL,
    `font_color`       VARCHAR(7)  NOT NULL,
    `background_color` VARCHAR(7)  NOT NULL
);

CREATE TABLE `recurring_option`
(
    `id`               BIGINT                               NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `frequency`        ENUM ("WEEKLY", "MONTHLY", "YEARLY") NOT NULL COMMENT '매주, 매달, 매년',
    `end_option`       ENUM ("DATE", "COUNT")               NOT NULL COMMENT '횟수, 특정 날짜',
    `recurrence_count` INT                                  NOT NULL,
    `end_date`         TIMESTAMP                            NOT NULL
);

CREATE TABLE `permission`
(
    `id`   BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(10) NOT NULL COMMENT 'none/edit/members'
);
