CREATE TABLE `members` (
	`member_id`	BIGINT	NOT NULL,
	`email`	VARCHAR(100)	NOT NULL,
	`password`	VARCHAR(30)	NOT NULL,
	`name`	VARCHAR(100)	NOT NULL,
	`phone`	BIGINT	NULL,
	`address`	VARCHAR(100)	NULL,
	`height`	INT	NULL,
	`weight`	INT	NULL,
	`gender`	ENUM('man','woman')	NULL,
	`birth`	INT	NULL,
	`goal`	INT	NULL,
	`nutrient`	INT	NULL,
	`exercise`	INT	NULL
);

CREATE TABLE `products` (
	`product_id`	BIGINT	NOT NULL,
	`product_name`	VARCHAR(100)	NOT NULL,
	`description`	TEXT	NOT NULL,
	`price`	INT	NOT NULL,
	`kcal`	INT	NOT NULL,
	`product_nutrient`	INT	NOT NULL
);

CREATE TABLE `diets` (
	`diet_id`	BIGINT	NOT NULL,
	`day_of_week`	INT	NOT NULL,
	`member_id`	BIGINT	NOT NULL,
	`product_id`	BIGINT	NOT NULL
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

