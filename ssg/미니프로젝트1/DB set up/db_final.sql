DROP TABLE IF EXISTS `User`;
DROP TABLE IF EXISTS `Product`;
DROP TABLE IF EXISTS `Warehouse`;
DROP TABLE IF EXISTS `Orders`;
DROP TABLE IF EXISTS `Product_Category`;
DROP TABLE IF EXISTS `Brand`;
DROP TABLE IF EXISTS `TrackingNumber`;
DROP TABLE IF EXISTS `ShippingInfo`;
DROP TABLE IF EXISTS `CommonCode`;
DROP TABLE IF EXISTS `shoppingMall`;
DROP TABLE IF EXISTS `Courier`;
DROP TABLE IF EXISTS `order_Insert`;
DROP TABLE IF EXISTS `Stock`;
DROP TABLE IF EXISTS `order_takeout`;
DROP TABLE IF EXISTS `preOrder`;
DROP TABLE IF EXISTS `CommonCodeType`;
DROP TABLE IF EXISTS `Customer`;
DROP TABLE IF EXISTS `nonUser`;
DROP TABLE IF EXISTS `ServiceManagement`;
DROP TABLE IF EXISTS `Warehouse_Category`;
DROP TABLE IF EXISTS `Inventory_status`;
DROP TABLE IF EXISTS `order_shipping`;

CREATE TABLE `User` (
	`seller_id`	int	NOT NULL,
	`role`	ENUM('GENERAL_MANAGER', 'WAREHOUSE_MANAGER', 'DELIVERYMAN', 'USER','CUSTOMER')	NULL	DEFAULT 'USER',
	`comp_reg_num`	int	NOT NULL,
	`comp_name`	Varchar(30)	NOT NULL,
	`user_id`	Varchar(8)	NOT NULL,
	`name`	char(30)	NOT NULL,
	`phone`	varchar(15)	NOT NULL,
	`password`	varchar(64)	NOT NULL,
	`email`	varchar(255)	NOT NULL,
	`addr1`	char(255)	NOT NULL,
	`addr2`	char(255)	NULL,
	`zipcode`	int	NOT NULL,
	`sign_up_path`	char(255)	NULL,
	`text_agree`	tinyint(1)	NOT NULL,
	`email_agree`	tinyint(1)	NOT NULL,
	`ad_agree`	tinyint(1)	NOT NULL,
	`status`	ENUM('deactivate', 'activate', 'banned', 'request', 'reject')	NOT NULL	DEFAULT 'request',
	`reg_date`	datetime	NULL	DEFAULT current_timestamp
);

CREATE TABLE `Product` (
	`prodNo`	int	NOT NULL,
	`categoryNo`	int	NOT NULL,
	`brandNo`	int	NOT NULL,
	`prodName`	char(64)	NOT NULL,
	`prodCategory_main`	char(64)	NOT NULL,
	`prodCategory_middle`	char(64)	NULL,
	`prodCategory_sub`	char(64)	NULL,
	`prodBrand`	char(64)	NULL,
	`salesPrice`	int	NOT NULL,
	`prodDescription`	char(255)	NOT NULL,
	`reg_date`	datetime	NOT NULL,
	`salesState`	char(64)	NOT NULL,
	`isProdDisplay`	tinyint(1)	NOT NULL
);

CREATE TABLE `Warehouse` (
	`whCode`	int	NOT NULL,
	`topCategoryNum`	int	NOT NULL,
	`topCategoryName`	char(20)	NOT NULL,
	`whName`	char(64)	NULL,
	`whAddr`	char(255)	NOT NULL,
	`whRegistDate`	datetime	NOT NULL,
	`managerPhone`	varchar(15)	NOT NULL
);

CREATE TABLE `Orders` (
	`id`	int	NOT NULL,
	`OrderId`	VARCHAR(64)	NOT NULL,
	`customer_id`	int	NOT NULL,
	`prodNo`	int	NOT NULL,
	`shopId`	varchar(64)	NOT NULL,
	`OrderDate`	DATE	NOT NULL,
	`OrderQuantity`	INT	NOT NULL,
	`OrderStatus`	Varchar(20)	NOT NULL,
	`buyer`	char(10)	NOT NULL,
	`receiver`	char(10)	NOT NULL,
	`RecipientPhone`	VARCHAR(15)	NULL,
	`RecipientAddr`	VARCHAR(255)	NOT NULL,
	`UnitPrice`	INT	NOT NULL,
	`SalesAmount`	INT	NOT NULL,
	`Payment`	INT	NOT NULL,
	`CourierName`	CHAR(64)	NOT NULL,
	`DeliveryCategory`	CHAR(2)	NULL
);

CREATE TABLE `Product_Category` (
	`categoryNo`	int	NOT NULL,
	`parent_categoryNo`	int	NULL,
	`categoryName`	char(64)	NOT NULL,
	`category_level`	int	NOT NULL,
	`reg_date`	datetime	NOT NULL
);

CREATE TABLE `Brand` (
	`brandNo`	int	NOT NULL,
	`brandName`	char(64)	NOT NULL,
	`reg_date`	datetime	NOT NULL
);

CREATE TABLE `TrackingNumber` (
	`tracking_id`	int	NOT NULL,
	`CourierID`	INT	NOT NULL,
	`whCode`	INT	NOT NULL,
	`label_type`	char(64)	NOT NULL
);

CREATE TABLE `ShippingInfo` (
	`shipping_id`	int	NOT NULL,
	`seller_id`	int	NOT NULL,
	`deliveryStatus`	tinyint(1)	NULL	DEFAULT 0	COMMENT '0: 배송
1 : 배송없음',
	`fulfillment`	tinyint(1)	NULL	DEFAULT 0	COMMENT '0: 설정안함
1: 설정함',
	`deliveryComp`	char(64)	NOT NULL,
	`deliveryOpt`	char(64)	NULL	COMMENT '택배/소포/등기, 직접배송(화물), 방문수령(판매자주소록필요), 퀵서비스(가능지역선택)',
	`reg_date`	datetime	NULL	DEFAULT current_timestamp
);

CREATE TABLE `CommonCode` (
	`codeNo`	int	NOT NULL,
	`codeTypeNo`	int	NOT NULL,
	`codeName`	char(64)	NOT NULL
);

CREATE TABLE `shoppingMall` (
	`shopId`	varchar(64)	NOT NULL,
	`seller_id`	int	NOT NULL,
	`storeName`	char(64)	NOT NULL,
	`status`	enum('정상','사용중지')	NOT NULL	DEFAULT '정상',
	`reg_date`	datetime	NULL	DEFAULT current_timestamp
);

CREATE TABLE `Courier` (
	`CourierID`	INT	NOT NULL,
	`CourierName`	VARCHAR(255)	NOT NULL,
	`contractNumber`	long	NOT NULL	COMMENT '8 ~ 10자리 수',
	`courierCode`	varchar(64)	NOT NULL	COMMENT 'https://developers.coupangcorp.com/hc/ko/articles/360034156033-%ED%83%9D%EB%B0%B0%EC%82%AC-%EC%BD%94%EB%93%9C'
);

CREATE TABLE `order_Insert` (
	`insertCode`	varchar(20)	NOT NULL,
	`prodNo`	int	NOT NULL,
	`insertDate`	DATE	NULL,
	`insertPersonnel`	char(30)	NULL,
	`insertQuantity`	int	NULL,
	`insertUnitPrice`	int	NULL,
	`insertPrice`	int	NULL,
	`insertState`	char(64)	NULL,
	`insertconfirm`	tinyint	NULL
);

CREATE TABLE `order_shipping` (
	`CourierID`	INT	NOT NULL,
	`OrderId`	VARCHAR(50)	NOT NULL,
	`service_id`	int	NOT NULL	COMMENT '발송지정보에 발송지 전화번호는 판매자 번호를 가지고 오면 됨',
	`Key`	VARCHAR(255)	NOT NULL
);

CREATE TABLE `Stock` (
	`stockNo`	int	NOT NULL,
	`whCode`	int	NOT NULL,
	`insertCode`	varchar(20)	NOT NULL,
	`prodName`	char(64)	NOT NULL,
	`stockQuantity`	int	NOT NULL,
	`saleStatus`	tinyint(1)	NOT NULL	DEFAULT 0	COMMENT '0 : 판매
1: 판매중지'
);

CREATE TABLE `order_takeout` (
	`takeoutCode`	VARCHAR(20)	NOT NULL,
	`stockNo`	int	NOT NULL,
	`takeoutDate`	DATE	NULL,
	`takeoutState`	char(64)	NULL,
	`takeoutconfirm`	tinyint(1)	NULL,
	`takeoutpersonnel`	char(10)	NULL,
	`takeoutQuantity`	int	NULL,
	`takeoutUnitPrice`	int	NULL,
	`takeoutPrice`	int	NULL
);

CREATE TABLE `preOrder` (
	`preoCode`	varchar(20)	NOT NULL,
	`takeoutCode`	varchar(20)	NOT NULL,
	`preoDate`	datetime	NULL,
	`customer`	char(64)	NULL,
	`preoState`	char(64)	NULL,
	`preoconfirm`	tinyint	NULL,
	`preoQuantity`	int	NULL,
	`preoUnitPrice`	int	NULL,
	`preoPrice`	int	NULL
);

CREATE TABLE `CommonCodeType` (
	`codeTypeNo`	int	NOT NULL,
	`codeTypeName`	char(64)	NULL
);

CREATE TABLE `Customer` (
	`customer_id`	int	NOT NULL,
	`user_id`	Varchar(8)	NOT NULL,
	`name`	char(5)	NOT NULL,
	`phone`	varchar(15)	NOT NULL,
	`password`	varchar(64)	NOT NULL,
	`email`	varchar(255)	NOT NULL,
	`addr1`	char(255)	NOT NULL,
	`addr2`	char(255)	NULL,
	`zipcode`	int	NOT NULL,
	`sign_up_path`	char(255)	NULL,
	`text_agree`	tinyint(1)	NOT NULL,
	`email_agree`	tinyint(1)	NOT NULL,
	`ad_agree`	tinyint(1)	NOT NULL,
	`status`	enum('deactivate', 'activate', 'banned', 'request')	NOT NULL	DEFAULT 'request',
	`reg_date`	datetime	NULL	DEFAULT current_timestamp
);

CREATE TABLE `nonUser` (
	`id`	int	NOT NULL,
	`qa_ID`	int	NULL
);

CREATE TABLE `ServiceManagement` (
	`service_id`	int	NOT NULL	COMMENT '발송지정보에 발송지 전화번호는 판매자 번호를 가지고 오면 됨',
	`shipping_id`	int	NOT NULL
);

CREATE TABLE `Warehouse_Category` (
	`topCategoryNum`	int	NOT NULL,
	`whCategoryName`	char(20)	NULL
);

CREATE TABLE `Inventory_status` (
	`invenNo`	int	NOT NULL,
	`stockNo`	int	NOT NULL,
	`prodNo`	int	NOT NULL,
	`prodName`	char(64)	NOT NULL,
	`salesPrice`	int	NOT NULL,
	`curStockQuantity`	int	NOT NULL,
	`afterStockQuantity`	int	NULL,
	`invenStatus`	char(10)	NULL	COMMENT '입고됫는지 출고됫는지 대기상태인지 취소인지 등',
	`stockQuantity`	int	NULL,
	`shipQuantity`	int	NULL,
	`totalProfit`	long	NULL,
	`detail`	text	NULL,
	`reg_date`	datetime	NULL	DEFAULT current_timestamp
);

ALTER TABLE `User` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`seller_id`
);

ALTER TABLE `Product` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
	`prodNo`
);

ALTER TABLE `Warehouse` ADD CONSTRAINT `PK_WAREHOUSE` PRIMARY KEY (
	`whCode`
);

ALTER TABLE `Orders` ADD CONSTRAINT `PK_ORDERS` PRIMARY KEY (
	`id`
);

ALTER TABLE `Product_Category` ADD CONSTRAINT `PK_PRODUCT_CATEGORY` PRIMARY KEY (
	`categoryNo`
);

ALTER TABLE `Brand` ADD CONSTRAINT `PK_BRAND` PRIMARY KEY (
	`brandNo`
);

ALTER TABLE `TrackingNumber` ADD CONSTRAINT `PK_TRACKINGNUMBER` PRIMARY KEY (
	`tracking_id`
);

ALTER TABLE `ShippingInfo` ADD CONSTRAINT `PK_SHIPPINGINFO` PRIMARY KEY (
	`shipping_id`
);

ALTER TABLE `CommonCode` ADD CONSTRAINT `PK_COMMONCODE` PRIMARY KEY (
	`codeNo`,
	`codeTypeNo`
);

ALTER TABLE `shoppingMall` ADD CONSTRAINT `PK_SHOPPINGMALL` PRIMARY KEY (
	`shopId`
);

ALTER TABLE `Courier` ADD CONSTRAINT `PK_COURIER` PRIMARY KEY (
	`CourierID`
);

ALTER TABLE `order_Insert` ADD CONSTRAINT `PK_ORDER_INSERT` PRIMARY KEY (
	`insertCode`
);

ALTER TABLE `Stock` ADD CONSTRAINT `PK_STOCK` PRIMARY KEY (
	`stockNo`
);

ALTER TABLE `order_takeout` ADD CONSTRAINT `PK_ORDER_TAKEOUT` PRIMARY KEY (
	`takeoutCode`
);

ALTER TABLE `preOrder` ADD CONSTRAINT `PK_PREORDER` PRIMARY KEY (
	`preoCode`
);

ALTER TABLE `CommonCodeType` ADD CONSTRAINT `PK_COMMONCODETYPE` PRIMARY KEY (
	`codeTypeNo`
);

ALTER TABLE `Customer` ADD CONSTRAINT `PK_CUSTOMER` PRIMARY KEY (
	`customer_id`
);

ALTER TABLE `nonUser` ADD CONSTRAINT `PK_NONUSER` PRIMARY KEY (
	`id`
);

ALTER TABLE `ServiceManagement` ADD CONSTRAINT `PK_SERVICEMANAGEMENT` PRIMARY KEY (
	`service_id`
);

ALTER TABLE `Warehouse_Category` ADD CONSTRAINT `PK_WAREHOUSE_CATEGORY` PRIMARY KEY (
	`topCategoryNum`
);

ALTER TABLE `Inventory_status` ADD CONSTRAINT `PK_INVENTORY_STATUS` PRIMARY KEY (
	`invenNo`
);

ALTER TABLE `CommonCode` ADD CONSTRAINT `FK_CommonCodeType_TO_CommonCode_1` FOREIGN KEY (
	`codeTypeNo`
)
REFERENCES `CommonCodeType` (
	`codeTypeNo`
);

