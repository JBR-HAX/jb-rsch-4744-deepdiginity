CREATE TABLE if not exists `robot_movement`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `json_request_data`  JSON NOT NULL,
    `json_response_data` JSON NOT NULL,
    `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP (6),
    `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP (6) ON UPDATE CURRENT_TIMESTAMP (6),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;