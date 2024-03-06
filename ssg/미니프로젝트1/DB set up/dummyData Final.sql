-- Insert dummy data into `User` table
INSERT INTO `User` (`seller_id`, `role`, `comp_reg_num`, `comp_name`, `user_id`, `name`, `phone`, `password`, `email`, `addr1`, `addr2`, `zipcode`, `sign_up_path`, `text_agree`, `email_agree`, `ad_agree`, `status`, `reg_date`)
VALUES
(1, 'USER', 123456789, 'Company 1', 'user1', 'John', '010-2122-8150', 'password1', 'john@example.com', 'Address 1', 'apt212-5', 12345, '길거리에서', 1, 1, 1, 'request', CURRENT_TIMESTAMP),
(2, 'GENERAL_MANAGER', 987654321, 'Company 2', 'user2', 'Jane', '010-1234-5677', 'password2', 'jane@example.com', 'Address 2', '1dong 906ho', 54321, '친구가 추천', 1, 1, 0, 'deactivate', CURRENT_TIMESTAMP),
(3, 'DELIVERYMAN', 555555555, 'Company 3', 'user3', 'Alice', '010-5789-4334', 'password3', 'alice@example.com', 'Address 3', '1101dong', 67890, '네이버', 1, 0, 1, 'activate', CURRENT_TIMESTAMP),
(4, 'USER', 666666666, 'Company 4', 'user4', 'Attlice', '010-5789-4554', 'password4', 'attlice@example.com', 'Address 4', '4440dong', 44444, '몰라', 1, 0, 1, 'reject', CURRENT_TIMESTAMP),
(5, 'WAREHOUSE_MANAGER', 777777777, 'Company 5', 'user5', 'Qlice', '010-2134-2356', 'password5', 'qlice@example.com', 'Address 5', '3303dong', 07738, '인스타', 1, 1, 1, 'banned', CURRENT_TIMESTAMP);
-- Insert dummy data into `Product` table
INSERT INTO `Product` (`prodNo`, `categoryNo`, `brandNo`, `prodName`, `prodCategory_main`, `prodCategory_middle`, `prodCategory_sub`, `prodBrand`, `salesPrice`, `prodDescription`, `reg_date`, `salesState`, `isProdDisplay`)
VALUES
(1, 101, 201, 'Product 1', 'Main Category 1', 'Sub Category 1', NULL, 'Brand 1', 100, 'Description for Product 1', CURRENT_TIMESTAMP, 'Available', 1),
(2, 102, 202, 'Product 2', 'Main Category 2', 'Sub Category 2', NULL, 'Brand 2', 200, 'Description for Product 2', CURRENT_TIMESTAMP, 'Available', 1),
(3, 103, 203, 'Product 3', 'Main Category 3', 'Sub Category 3', NULL, 'Brand 3', 300, 'Description for Product 3', CURRENT_TIMESTAMP, 'Available', 1);
-- Insert dummy data into `Warehouse` table
INSERT INTO `Warehouse` (`whCode`, `topCategoryNum`, `topCategoryName`, `whName`, `whAddr`, `whRegistDate`, `managerPhone`)
VALUES
(1, 1001, 'Category 1', 'Warehouse 1', 'Warehouse Address 1', CURRENT_TIMESTAMP, '1234567890'),
(2, 1002, 'Category 2', 'Warehouse 2', 'Warehouse Address 2', CURRENT_TIMESTAMP, '9876543210'),
(3, 1003, 'Category 3', 'Warehouse 3', 'Warehouse Address 3', CURRENT_TIMESTAMP, '5555555555');
-- Insert dummy data into `Orders` table
INSERT INTO `Orders` (`id`, `OrderId`, `customer_id`, `prodNo`, `shopId`, `OrderDate`, `OrderQuantity`, `OrderStatus`, `buyer`, `receiver`, `RecipientPhone`, `RecipientAddr`, `UnitPrice`, `SalesAmount`, `Payment`, `CourierName`, `DeliveryCategory`)
VALUES
(1, 'Order1', 1, 1, 'Shop1', '2024-02-12', 2, 'Pending', 'John', 'Jane', '010-2122-3455', 'Shipping Address 1', 100, 200, 200, 'Courier A', '무료'),
(2, 'Order2', 2, 2, 'Shop2', '2024-02-12', 1, 'Completed', 'Jane', 'Alice', '010-5375-4623', 'Shipping Address 2', 200, 200, 200, 'Courier B', '착불'),
(3, 'Order3', 3, 3, 'Shop3', '2024-02-12', 3, 'Shipped', 'Alice', 'John', '010-2346-3734', 'Shipping Address 3', 300, 900, 900, 'Courier C', '선불');
-- Insert dummy data into `Product_Category` table
INSERT INTO `Product_Category` (`categoryNo`, `parent_categoryNo`, `categoryName`, `category_level`, `reg_date`)
VALUES
(101, NULL, '의류', 1, CURRENT_TIMESTAMP),
(102, NULL, '가전', 1, CURRENT_TIMESTAMP),
(103, NULL, '식품', 1, CURRENT_TIMESTAMP),
(104, 101, '상의', 2, CURRENT_TIMESTAMP),
(105, 102, '티비', 2, CURRENT_TIMESTAMP),
(106, 103, '만두', 2, CURRENT_TIMESTAMP);
-- Insert dummy data into `Brand` table
INSERT INTO `Brand` (`brandNo`, `brandName`, `reg_date`)
VALUES
(201, 'Brand 1', CURRENT_TIMESTAMP),
(202, 'Brand 2', CURRENT_TIMESTAMP),
(203, 'Brand 3', CURRENT_TIMESTAMP);
-- Insert dummy data into `TrackingNumber` table
INSERT INTO `TrackingNumber` (`tracking_id`, `CourierID`, `whCode`, `label_type`)
VALUES
(1, 101, 1, 'Label Type 1'),
(2, 102, 2, 'Label Type 2'),
(3, 103, 3, 'Label Type 3');
-- Insert dummy data into `ShippingInfo` table
INSERT INTO `ShippingInfo` (`shipping_id`, `seller_id`, `deliveryStatus`, `fulfillment`, `deliveryComp`, `deliveryOpt`, `reg_date`)
VALUES
(1, 1, 0, 0, 'Delivery Company 1', 'Option 1', CURRENT_TIMESTAMP),
(2, 2, 0, 0, 'Delivery Company 2', 'Option 2', CURRENT_TIMESTAMP),
(3, 3, 0, 0, 'Delivery Company 3', 'Option 3', CURRENT_TIMESTAMP);
-- Insert dummy data into `shoppingMall` table
INSERT INTO `shoppingMall` (`shopId`, `seller_id`, `storeName`, `status`, `reg_date`)
VALUES
('Shop1', 1, 'Store 1', '정상', CURRENT_TIMESTAMP),
('Shop2', 2, 'Store 2', '사용중지', CURRENT_TIMESTAMP),
('Shop3', 3, 'Store 3', '정상', CURRENT_TIMESTAMP);
-- Insert dummy data into `Courier` table
INSERT INTO `Courier` (`CourierID`, `CourierName`, `contractNumber`, `courierCode`)
VALUES
(101, 'Courier A', 12345678, 'Courier Code 1'),
(102, 'Courier B', 87654321, 'Courier Code 2'),
(103, 'Courier C', 98765432, 'Courier Code 3');
-- Insert dummy data into `order_Insert` table
INSERT INTO `order_Insert` (`insertCode`, `prodNo`, `insertDate`, `insertPersonnel`, `insertQuantity`, `insertUnitPrice`, `insertPrice`, `insertState`, `insertconfirm`)
VALUES
('Insert1', 1, '2024-02-12', 'Person 1', 1, 100, 100, 'State 1', 1),
('Insert2', 2, '2024-02-12', 'Person 2', 2, 200, 400, 'State 2', 1),
('Insert3', 3, '2024-02-12', 'Person 3', 3, 300, 900, 'State 3', 1);
-- Insert dummy data into `Stock` table
INSERT INTO `Stock` (`stockNo`, `whCode`, `insertCode`, `prodName`, `stockQuantity`, `saleStatus`)
VALUES
(1, 1,  'Insert1', 'Product 1', 10, 0),
(2, 2,  'Insert2', 'Product 2', 20, 0),
(3, 3,  'Insert3', 'Product 3', 30, 0);
-- Insert dummy data into `order_takeout` table
INSERT INTO `order_takeout` (`takeoutCode`, `stockNo`, `takeoutDate`, `takeoutState`, `takeoutconfirm`, `takeoutpersonnel`, `takeoutQuantity`, `takeoutUnitPrice`, `takeoutPrice`)
VALUES
('Takeout1', 1, '2024-02-12', 'State 1', 1, 'Person 1', 1, 100, 100),
('Takeout2', 2, '2024-02-12', 'State 2', 1, 'Person 2', 2, 200, 400),
('Takeout3', 3, '2024-02-12', 'State 3', 1, 'Person 3', 3, 300, 900);
-- Insert dummy data into `preOrder` table
INSERT INTO `preOrder` (`preoCode`, `takeoutCode`, `preoDate`, `customer`, `preoState`, `preoconfirm`, `preoQuantity`, `preoUnitPrice`, `preoPrice`)
VALUES
('Preorder1', 'Takeout1', NULL, 'Customer 1', 'State 1', 1, 1, 100, 100),
('Preorder2', 'Takeout2', NULL, 'Customer 2', 'State 2', 1, 2, 200, 400),
('Preorder3', 'Takeout3', NULL, 'Customer 3', 'State 3', 1, 3, 300, 900);
-- Insert dummy data into `Customer` table
INSERT INTO `Customer` (`customer_id`, `user_id`, `name`, `phone`, `password`, `email`, `addr1`, `addr2`, `zipcode`, `sign_up_path`, `text_agree`, `email_agree`, `ad_agree`, `status`, `reg_date`)
VALUES
(1, 'user1', 'John', '1234567890', 'password1', 'john@example.com', 'Address 1', NULL, 12345, 'signup_path_1', 1, 1, 1, 'request', CURRENT_TIMESTAMP),
(2, 'user2', 'Jane', '9876543210', 'password2', 'jane@example.com', 'Address 2', NULL, 54321, 'signup_path_2', 1, 1, 1, 'request', CURRENT_TIMESTAMP),
(3, 'user3', 'Alice', '5555555555', 'password3', 'alice@example.com', 'Address 3', NULL, 67890, 'signup_path_3', 1, 1, 1, 'request', CURRENT_TIMESTAMP);
-- Insert dummy data into `nonUser` table
INSERT INTO `nonUser` (`id`, `qa_ID`)
VALUES
(1, 12),
(2, 15),
(3, 20);
-- Insert dummy data into `ServiceManagement` table
INSERT INTO `ServiceManagement` (`service_id`, `shipping_id`)
VALUES
(1, 1),
(2, 2),
(3, 3);
-- Insert dummy data into `Warehouse_Category` table
INSERT INTO `Warehouse_Category` (`topCategoryNum`, `whCategoryName`)
VALUES
(1001, '의류'),
(1002, '식품'),
(1003, '가전');
-- Insert dummy data into `Inventory_status` table
INSERT INTO `Inventory_status` (`invenNo`, `stockNo`, `prodNo`, `prodName`, `salesPrice`, `curStockQuantity`, `afterStockQuantity`, `invenStatus`, `stockQuantity`, `shipQuantity`, `totalProfit`, `detail`, `reg_date`)
VALUES
(1, 1, 1, 'Product 1', 100, 10, 9, 'Available', NULL, NULL, 100, '팔림', CURRENT_TIMESTAMP),
(2, 2, 2, 'Product 2', 200, 20, 8, 'Available', NULL, NULL, 2400, '안팔림', CURRENT_TIMESTAMP),
(3, 3, 3, 'Product 3', 300, 30, 7, 'Available', NULL, NULL, 6900, '굿', CURRENT_TIMESTAMP);