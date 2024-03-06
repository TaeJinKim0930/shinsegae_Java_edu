-- select

-- 평균 일일 대여 요금 구하기
-- 자동차 ID, 자동차 종류, 일일 대여 요금(원), 자동차 옵션
SELECT round(avg(daily_fee),0) as 'AVERAGE_FEE' 
from car_rental_company_car
where car_type = 'SUV'
;

-- 재구매가 일어난 상품과 회원 리스트 구하기
-- 상품 판매 ID, 회원 ID, 상품 ID, 판매량, 판매일
SELECT USER_ID, PRODUCT_ID from online_sale
group by user_id, product_id
having count(user_id) > 1
order by user_id asc, product_id desc
;

-- 조건에 맞는 도서 리스트 출력하기
SELECT BOOK_ID, date_format(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE from book
where published_date LIKE '2021%' and category = '인문'
order by published_date;

-- 12세 이하인 여자 환자 목록 출력하기
-- 각각 환자번호, 환자이름, 성별코드, 나이, 전화번호를 의미합니다.
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE') as TLNO
from patient
where age <= 12 and gend_cd = 'w'
order by age desc, pt_name asc;

-- 3월에 태어난 여성 회원 목록 출력하기
-- 회원 ID, 회원 이름, 회원 연락처, 성별, 생년월일
SELECT MEMBER_ID, MEMBER_NAME, GENDER, date_format(DATE_OF_BIRTH, '%Y-%m-%d')
from member_profile
where date_format(date_of_birth, '%m') = '03' and gender = 'W' and TLNO IS NOT NULL
order by member_id asc;

-- 인기있는 아이스크림
-- 각 아이스크림 공장에서 아이스크림 가게까지의 출하 번호, 아이스크림 맛, 상반기 아이스크림 총주문량
select FLAVOR
from first_half
order by total_order desc, shipment_id asc;

-- 흉부외과 또는 일반외과 의사 목록 출력하기
SELECT DR_NAME, DR_ID, MCDP_CD, date_format(HIRE_YMD, '%Y-%m-%d') as HIRE_YMD
from doctor
where mcdp_cd = 'CS' OR mcdp_cd = 'GS' 
order by hire_ymd desc, dr_name asc;

-- 조건에 부합하는 중고거래 댓글 조회하기
SELECT 
    B.TITLE, 
    B.BOARD_ID, 
    r.REPLY_ID, 
    r.WRITER_ID, 
    r.CONTENTS, 
    date_format(r.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
from used_goods_board b
inner join used_goods_reply r on b.board_id = r.board_id 
where date_format(b.CREATED_DATE, '%Y-%m') = '2022-10'
order by r.created_date, b.title;

-- 과일로 만든 아이스크림 고르기
SELECT f.flavor
from first_half f
left join icecream_info i on f.flavor = i.flavor 
where total_order > 3000 and ingredient_type = 'fruit_based'
order by total_order desc;

-- 서울에 위치한 식당 목록 출력하기
SELECT ri.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, Round(avg(review_SCORE),2) as SCORE
from rest_info ri
join rest_review rr on rr.rest_id = ri.rest_id
group by ri.rest_id
having address LIKE '서울%'
order by avg(review_SCORE) desc, favorites desc;


-- 강원도에 위치한 생산공장 목록 출력하기
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
from food_factory
where address LIKE '강원도%'
order by factory_id ;

-- 모든 레코드 조회하기
SELECT * from animal_ins;

-- 오프라인/온라인 판매 데이터 통합하기
SELECT date_format(SALES_DATE, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from online_sale onl
where date_format(onl.sales_date, '%Y-%m') LIKE '2022-03%'
union
select date_format(SALES_DATE, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, NULL as user_id ,SALES_AMOUNT
from offline_sale
where date_format(sales_date, '%Y-%m') LIKE '2022-03%'
order by sales_date, product_id, user_id;

-- 역순 정렬하기
SELECT NAME, DATETIME
from animal_ins 
order by animal_id desc;

-- 아픈 동물 찾기
SELECT animal_id, name
from animal_ins
where intake_condition = 'Sick'
order by animal_id;

-- 어린 동물 찾기
SELECT animal_id, name
from animal_ins
where intake_condition <> 'Aged'
order by animal_id;

-- 동물의 아이디와 이름
SELECT animal_id, name
from animal_ins
order by animal_id;

-- 여러 기준으로 정렬하기
SELECT ANIMAL_ID, NAME, DATETIME
from animal_ins 
order by name, datetime desc;

-- 상위 n개 레코드
SELECT name
from animal_ins
order by datetime limit 1;

-- 조건에 맞는 회원수 구하기
SELECT count(user_id) as users
from user_info
where age between 20 and 29 and joined LIKE '2021%';


----- sum, max, min
-- 가격이 제일 비싼 식품의 정보 출력하기
SELECT * from food_product
order by price desc limit 1;

-- 가장 비싼 상품 구하기
SELECT max(price) as  max_price from product;

-- 최댓값 구하기
SELECT datetime
from animal_ins
order by datetime desc limit 1;

-- 최솟값 구하기
SELECT datetime
from animal_ins
order by datetime asc limit 1;

-- 동물 수 구하기
select count(*)
from animal_ins;

-- 중복 제거하기
SELECT count(distinct(name))
from animal_ins
where name IS NOT NULL;


-------------- group by

-- 즐겨찾기가 가장 많은 식당 정보 출력하기
SELECT food_type, rest_id, rest_name, favorites
from rest_info
where (food_type, favorites) in ( 
	select food_type, max(favorites) from rest_info group by food_type
)
order by food_type desc;

-- 고양이와 개는 몇 마리 있을까
SELECT animal_type, count(*)
from animal_ins
group by animal_type
order by animal_type;

-- 동명 동물 수 찾기
SELECT name, count(name)
from animal_ins
group by name
having count(name) > 1 and name IS NOT NULL
order by name;

-- 년, 월, 성별 별 상품 구매 회원 수 구하기
SELECT  year(sales_date) as year, 
		month(sales_date) as month, 
        gender, 
        count(distinct(o.user_id)) as users
from user_info u
join online_sale o on u.user_id = o.user_id
where gender IS NOT NULL
group by month, gender
order by year, month, gender;

-- 입양 시각 구하기(2) 모름. 
SELECT IFNULL(hour(datetime)) as hour, count(*)
from animal_outs
group by hour
order by hour;

-- 입양 시각 구하기(1)
SELECT hour(datetime) as hour, count(*)
from animal_outs
where hour(datetime) between '9' and '20'
group by hour
order by hour;

-- 조건에 맞는 사용자와 총 거래금액 조회하기
SELECT u.user_id, nickname, sum(price) as total_sales
from used_goods_board b
join used_goods_user u on u.user_id = b.writer_id
where status = 'done'
group by writer_id
having sum(price) >= 700000
order by total_sales;

-- 가격대 별 상품 개수 구하기
SELECT floor(price/ 10000)*10000 price_group, count(*) as products
from product
group by price_group
order by price_group;

-- 식품분류별 가장 비싼 식품의 정보 조회하기
SELECT category, price max_price, product_name
from food_product
where price in (select max(price) from food_product group by category)
group by category
having category in ('과자', '국', '김치', '식용유')
order by max_price desc;

-- 성분으로 구분한 아이스크림 총 주문량
SELECT ingredient_type, sum(total_order) total_order
from icecream_info i
join first_half f on i.flavor = f.flavor
group by ingredient_type
order by total_order;


-- 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기
SELECT 
    month(start_date) as month, 
    car_id, 
    count(history_id) as records
from car_rental_company_rental_history
where car_id IN (
                    select car_id 
                    from car_rental_company_rental_history 
                    where month(start_date) 
                    between '08' and '10'
                    group by car_id
                    having count(history_id) >= 5
                )   
                and month(start_date) 
                between '08' and '10'
group by month, car_id
having count(history_id) >= 1 
order by month, car_id desc;



-- 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
SELECT car_type, count(*) cars
from car_rental_company_car
where      options LIKE '%열선시트%' 
        or options LIKE '%가죽시트%' 
        or options LIKE '%통풍시트%'
group by car_type
order by car_type;


-- 진료과별 총 예약 횟수 출력하기
SELECT mcdp_cd as '진료과코드', count(apnt_no) '5월예약건수'
from appointment
where apnt_ymd like '2022-05-%'
group by mcdp_cd
order by count(*), mcdp_cd;



-- 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기
SELECT car_id, 
        -- 모든 car group 에서 랜덤값이 아니라 최고 값(제일 최근 값) 을 얻기 위해 쓰임
        max(case
            when '2022-10-16' between start_date and end_date then '대여중'
            else '대여 가능'
        end) as availability
from car_rental_company_rental_history
group by car_id
order by car_id desc;

-- 카테고리 별 도서 판매량 집계하기
SELECT b.category, sum(sales) as total_sales
from book b
join book_sales s on b.book_id = s.book_id
where sales_date like '2022-01%'
group by category
order by category;



-- 저자 별 카테고리 별 매출액 집계하기
SELECT b.author_id, author_name, category, sum(s.sales * b.price) as total_sales
from book b
join author a on b.author_id = a.author_id
join book_sales s on s.book_id = b.book_id
where sales_date Like '2022-01%'
group by author_id, author_name, category
order by a.author_id, b.category desc
;


-- 경기도에 위치한 식품창고 목록 출력하기
SELECT warehouse_id, warehouse_name, address, IFNULL(freezer_yn, 'N') as FREEZER_YN
from food_warehouse
where address LIKE '%경기도%'
order by warehouse_id;


-- 나이 정보가 없는 회원 수 구하기
SELECT count(*) users from user_info where age is null;


-- NULL 처리하기
SELECT animal_type, ifnull(name, "No name"), sex_upon_intake
from animal_ins;


-- 이름이 있는 동물의 아이디
SELECT animal_id
from animal_ins
where name is not null;

-- 이름이 없는 동물의 아이디
SELECT animal_id
from animal_ins
where name is null;


--------------------- String, date

-- 자동차 대여 기록에서 장기/단기 대여 구분하기
SELECT history_id, car_id, 
        date_format(start_date, '%Y-%m-%d') start_date,
        date_format(end_date, '%Y-%m-%d') end_date,
        case when datediff(end_date, start_date) +1 >= 30
            then '장기 대여'
            else '단기 대여'
        end
         as rent_type
from car_rental_company_rental_history
where start_date like '%2022-09%'
order by history_id desc;


-- 특정 옵션이 포함된 자동차 리스트 구하기
SELECT car_id, car_type, daily_fee, options
from car_rental_company_car
where options like '%네비게이션%'
order by car_id desc;

-- 조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기
SELECT concat(concat_ws("/", "/home/grep/src", f.board_id, file_id), file_name, file_ext) as file_path
from used_goods_board b
join used_goods_file f on b.board_id = f.board_id
where views = (select max(views) from used_goods_board)
order by file_id desc;


-- 조건에 맞는 사용자 정보 조회하기
SELECT user_id, nickname, 
        concat(city, ' ', street_address1, ' ', street_address2) as '전체주소', 
        concat(left(tlno, 3),'-', mid(tlno,4,4),'-', right(tlno,4)) as '전화번호'
from used_goods_board b
join used_goods_user u on b.writer_id = u.user_id
group by user_id
having count(*) >= 3
order by user_id desc;


-- 자동차 대여 기록 별 대여 금액 구하기 (x)
SELECT history_id, 
        case 
            when (datediff(end_date, start_date) + 1 between 7 and 29) and duration_type = '7일 이상'
                then round((daily_fee * (100 - discount_rate) * 0.01) * datediff(end_date, start_date) +1)
            when (datediff(end_date, start_date) + 1 between 30 and 89) and duration_type = '30일 이상'
                then round((daily_fee * (100 - discount_rate) * 0.01) * datediff(end_date, start_date) +1)
            when (datediff(end_date, start_date) + 1 >= 90) and duration_type = '90일 이상'
                then round((daily_fee * (100 - discount_rate) * 0.01) * datediff(end_date, start_date) +1)
            when (datediff(end_date, start_date) + 1 < 7 )
                 then round(daily_fee * datediff(end_date, start_date)+1)
            else null
        end as fee
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_RENTAL_HISTORY h on c.car_id = h.car_id
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on c.car_type = p.car_type
where c.car_type = '트럭'
order by fee desc, history_id desc;