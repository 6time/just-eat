CREATE TABLE `members` (
	`member_id`	BIGINT	NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`email`	VARCHAR(100)	NOT NULL,
	`password`	VARCHAR(30)	NOT NULL,
	`name`	VARCHAR(100)	NOT NULL,
	`phone`	VARCHAR(100)	NULL,
	`address`	VARCHAR(100)	NULL,
	`gender`	ENUM('man','woman')	NULL,
  	`birth`	INT	NULL
);

CREATE TABLE `health` (
	`member_id`	BIGINT	NOT NULL PRIMARY KEY,
	`health_flag` BOOLEAN NOT NULL DEFAULT 0,
	`height` DOUBLE	NULL,
	`weight` DOUBLE	NULL,
	`goal` DOUBLE NULL,
	`compare_weight` VARCHAR(20)	NOT NULL,
	`goal_week` INT NULL,
	`kcal` INT NULL,
	`protein` INT NULL,
	`carb` INT NULL,
	`fat` INT NULL
);

CREATE TABLE `diets` (
	`diet_id`	BIGINT	NOT NULL,
	`member_id`	BIGINT	NOT NULL,
	`product_id` BIGINT	NOT NULL,
	`day_of_week`	INT	NOT NULL
);

CREATE TABLE `products` (
	`product_id`	BIGINT	NOT NULL,
	`product_name`	VARCHAR(100) NOT NULL,
	`description`	TEXT	NOT NULL,
	`price`	INT	NOT NULL,
	`kcal`	INT	NOT NULL,
	`protein` INT NULL,
   	`carb` INT NULL,
    `fat` INT NULL
);

CREATE TABLE `information` (
	`info_id`	BIGINT	NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`writer`	VARCHAR(100)	NOT NULL,
	`title`	VARCHAR(100)	NOT NULL,
	`content`	TEXT	NOT NULL,
	`reg_date`	DATE	NOT NULL	DEFAULT now(),
	`up_date`	DATE	NOT NULL	DEFAULT now(),
	`view_cnt`	BIGINT	NOT NULL	DEFAULT 0,
	`comment_cnt`	BIGINT	NOT NULL	DEFAULT 0,
	`member_id`	BIGINT	NOT NULL
);

CREATE TABLE `reviews` (
	`review_id`	BIGINT	NOT NULL,
	`rate`	INT	NOT NULL	DEFAULT 0,
	`review_text`	TEXT	NULL,
	`product_id`	BIGINT	NOT NULL,
	`member_id`	BIGINT	NOT NULL
);

CREATE TABLE `carts` (
	`member_id`	BIGINT	NOT NULL,
	`product_id`	BIGINT	NOT NULL,
	`quantity`	INT	NOT NULL	DEFAULT 1
);

CREATE TABLE `articles` (
	`article_id`	BIGINT	NOT NULL,
	`article_title`	VARCHAR(100)	NOT NULL,
	`article_text`	TEXT	NOT NULL,
	`member_id`	BIGINT	NOT NULL
);

CREATE TABLE `comments` (
	`comment_id`	BIGINT	NOT NULL,
	`comment_text`	TEXT	NOT NULL,
	`member_id`	BIGINT	NOT NULL,
	`article_id`	BIGINT	NOT NULL
);

CREATE TABLE `orders` (
	`order_id`	BIGINT	NOT NULL,
	`total_price`	BIGINT	NOT NULL,
	`status`	ENUM('ready','move','arrive')	NOT NULL	DEFAULT 'ready',
	`member_id`	BIGINT	NOT NULL
);

ALTER TABLE `members` ADD CONSTRAINT `PK_MEMBERS` PRIMARY KEY (
	`member_id`
);


ALTER TABLE `products` ADD CONSTRAINT `PK_PRODUCTS` PRIMARY KEY (
	`product_id`
);

ALTER TABLE `diets` ADD CONSTRAINT `PK_DIETS` PRIMARY KEY (
	`diet_id`
);

ALTER TABLE `reviews` ADD CONSTRAINT `PK_REVIEWS` PRIMARY KEY (
	`review_id`
);

ALTER TABLE `carts` ADD CONSTRAINT `PK_CARTS` PRIMARY KEY (
	`member_id`
);

ALTER TABLE `articles` ADD CONSTRAINT `PK_ARTICLES` PRIMARY KEY (
	`article_id`
);

ALTER TABLE `comments` ADD CONSTRAINT `PK_COMMENTS` PRIMARY KEY (
	`comment_id`
);

ALTER TABLE `orders` ADD CONSTRAINT `PK_ORDERS` PRIMARY KEY (
	`order_id`
);

ALTER TABLE `carts` ADD CONSTRAINT `FK_members_TO_carts_1` FOREIGN KEY (
	`member_id`
)
REFERENCES `members` (
	`member_id`
);

ALTER TABLE `members` CHANGE member_id member_id BIGINT AUTO_INCREMENT PRIMARY KEY;

