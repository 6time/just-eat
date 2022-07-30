CREATE TABLE `members` (
	`member_id`	BIGINT	NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`email`	VARCHAR(100)	NOT NULL,
	`password`	VARCHAR(500)	NOT NULL,
	`name`	VARCHAR(100)	NOT NULL,
	`phone`	VARCHAR(100)	NULL,
	`address`	VARCHAR(100)	NULL,
	`gender`	ENUM('male','female')	NULL,
  	`birth`	INT	NULL
);

CREATE TABLE `health` (
	`member_id`	BIGINT	NOT NULL PRIMARY KEY,
	`height` DOUBLE	NULL,
	`weight` DOUBLE	NULL,
	`goal` DOUBLE NULL,
	`compare_weight` VARCHAR(20) NOT NULL,
	`goal_week` INT NULL,
	`kcal_max` INT NULL,
    `kcal_min` INT NULL,
	`protein_max` INT NULL,
    `protein_min` INT NULL,
	`carb_max` INT NULL,
    `carb_min` INT NULL,
	`fat_max` INT NULL,
    `fat_min` INT NULL
);

CREATE TABLE `diets` (
	`diet_id`	BIGINT	NOT NULL PRIMARY KEY,
	`monday`	BIGINT	NULL,
	`tuesday`	BIGINT	NULL,
	`wednesday`	BIGINT	NULL,
	`thursday`	BIGINT	NULL,
	`friday`	BIGINT	NULL
);

CREATE TABLE `products` (
	`product_id` BIGINT	NOT NULL,
	`product_name`	VARCHAR(100) NOT NULL,
	`product_size` INT NOT NULL,
	`kcal`	INT	NOT NULL,
	`protein` INT NOT NULL,
   	`carb` INT NOT NULL,
    `fat` INT NOT NULL,
    `sugars` INT NOT NULL,
    `sodium` INT NOT NULL,
    `price`	INT	NOT NULL
);

CREATE TABLE `information` (
	`info_id`	BIGINT	NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`writer`	VARCHAR(100)	NOT NULL,
	`title`	VARCHAR(100)	NOT NULL,
	`content`	TEXT	NOT NULL,
	`reg_date`	DATETIME	NOT NULL	DEFAULT now(),
	`up_date`	DATETIME	NOT NULL	DEFAULT now(),
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
  `article_id` int NOT NULL AUTO_INCREMENT,
  `article_title` varchar(100) NOT NULL,
  `article_text` varchar(500) NOT NULL,
  `member_id` int DEFAULT NULL,
  `article_writer` varchar(45) DEFAULT NULL,
  `article_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `reNum` bigint DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `comments` (
  `comment_id` bigint NOT NULL AUTO_INCREMENT,
  `comment_text` varchar(100) DEFAULT NULL,
  `comment_writer` varchar(45) DEFAULT NULL,
  `member_id` bigint DEFAULT NULL,
  `article_id` bigint DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orders` (
	`order_id`	BIGINT	NOT NULL,
	`total_price`	BIGINT	NOT NULL,
	`status`	ENUM('ready','move','arrive')	NOT NULL	DEFAULT 'ready',
	`member_id`	BIGINT	NOT NULL
);

CREATE TABLE `selftest` (
  `daykcal` int DEFAULT NULL,
  `dayweight` int DEFAULT NULL,
  `dayexercise` int DEFAULT NULL,
  `member_id` bigint DEFAULT NULL,
  `regDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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

INSERT INTO products VALUES (1, '[맛있찬]닭가슴살스틱코코넛까스', 100, 1700, 130, 700, 45, 2, 232, 2100);
INSERT INTO products VALUES (2, '[샐러드판다]오리엔탈드레싱 두부면샐러드', 200, 1700, 130, 700, 45, 10, 474, 5900);
INSERT INTO products VALUES (3, '[브랜드닭]닭가슴살버섯불고기볶음밥', 250, 1700, 130, 700, 45, 0, 265, 2900);
INSERT INTO products VALUES (4, '[브랜드닭]닭가슴살핫바야채깻잎', 70, 1700, 130, 700, 45, 0, 105, 1100);
INSERT INTO products VALUES (5, '[잇메이트]닭가슴살소떡소떡-매콤', 160, 1700, 130, 700, 45, 4, 615, 2090);
INSERT INTO products VALUES (6, '[샐러드판다]리코타샐러드', 250, 1700, 130, 700, 45, 20, 400, 6200);
INSERT INTO products VALUES (7, '[샐러드판다]레몬드레싱유러피안샐러드', 170, 1700, 130, 700, 45, 7, 312, 3900);
INSERT INTO products VALUES (8, '[수비드림]수비드닭가슴살어니언소스', 140, 1700, 130, 700, 45, 4, 196, 1800);
INSERT INTO products VALUES (9, '[브랜드닭]닭가슴살양파송송볶음밥', 250, 1700, 130, 700, 45, 5, 750, 2900);
INSERT INTO products VALUES (10, '[밀스원]병아리콩잡곡밥&칠리닭가슴살슬라이스', 210, 1700, 130, 700, 45, 6, 290, 3900);
INSERT INTO products VALUES (11, '[베러미]아이스군고구마', 120, 1700, 130, 700, 45, 7, 25, 1900);
INSERT INTO products VALUES (12, '[브랜드닭]닭가슴살쏘스볼스위트칠리', 100, 1700, 130, 700, 45, 9, 390, 1700);
INSERT INTO products VALUES (13, '[세끼판다]비엘티파스타샐러드', 150, 1700, 130, 700, 45, 3, 379, 4900);
INSERT INTO products VALUES (14, '[안스키친]모듬버섯샐러드', 380, 1700, 130, 700, 45, 13, 337, 6900);
INSERT INTO products VALUES (15, '[잇메이트]소프트안심-카레맛', 100, 1700, 130, 700, 45, 5, 340, 1490);
INSERT INTO products VALUES (16, '[준청과]바나나', 170, 1700, 130, 700, 45, 21, 0, 1300);
INSERT INTO products VALUES (17, '[포켓도시락]비건버거-치폴레맛', 150, 1700, 130, 700, 45, 4, 530, 4900);
INSERT INTO products VALUES (18, '[닥다마켓]고품닭-청양고추맛', 200, 1700, 130, 700, 45, 20, 265, 3990);
INSERT INTO products VALUES (19, '[랭킹수산]렌지에구워먹는삼치구이', 60, 1700, 130, 700, 45, 0, 180, 3480);
INSERT INTO products VALUES (20, '[잇메이트]닭가슴살스테이크-고추맛', 100, 1700, 130, 700, 45, 4, 360, 1420);
INSERT INTO products VALUES (21, '[포켓도시락]흑현미작곡밥&청양고추스테이크', 145, 1700, 130, 700, 45, 4, 233, 3500);
INSERT INTO products VALUES (22, '[세끼판다]보리샐러드', 185, 1700, 130, 700, 45, 10, 567, 4900);
INSERT INTO products VALUES (23, '[밀앤데일리]멕시칸치킨샐러드(미디움)', 270, 1700, 130, 700, 45, 3, 442, 6600);
INSERT INTO products VALUES (24, '[마이비밀]귀리채소밥과 파프리카불고기스크램블', 240, 1700, 130, 700, 45, 2, 583, 3590);
INSERT INTO products VALUES (25, '[맛있찬]야채치즈무뼈닭발', 130, 1700, 130, 700, 45, 8, 370, 4280);
INSERT INTO products VALUES (26, '[맛있닭]닭가슴살소시지한끼브리또갈릭', 200, 1700, 130, 700, 45, 4, 812, 4980);
INSERT INTO products VALUES (27, '[샐러드판다]비빔소스두부면샐러드', 200, 1700, 130, 700, 45, 8, 814, 5900);
INSERT INTO products VALUES (28, '[밀스원]퀴노아렌틸콩잡곡밥&매콤닭갈비', 210, 1700, 130, 700, 45, 9, 480, 3900);
INSERT INTO products VALUES (29, '[잇메이트]더블덮밥베지볶음밥&닭가슴살볼카레', 210, 1700, 130, 700, 45, 6, 174, 3600);
INSERT INTO products VALUES (30, '[잇메이트]닭가슴살어묵볼-매콤', 100, 1700, 130, 700, 45, 2, 410, 2090);