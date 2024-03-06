use shinsaegebookdb;

-- 1. 모든 도서의 이름과 가격을 검색하세요
select bookname, price from book;

-- 2. 모든 도서의 도서번호, 도서이름, 출판사 , 가격을 검색하세요
select * from book;

-- 3. 도서 테이블에 있는 모든 출판사를 검색하시오.
select publisher from book;

-- 4. 가격이 20,000원 미만인 도서를 검색하시오
select * from book where price < 20000;

-- 5. 가격이 10,000원 이상 20,000원 이하인 도서를 검색하시오 
select * from book where price between 10000 and 20000;

-- 6. 출판사가 '굿스포츠' 혹은 '대한미디어'인 도서를 검색하시오
select * from book where publisher in ('굿스포츠', '대한미디어');

-- 7. '축구의 역사'를 출간한 출판사를 검색하시오
select publisher from book where bookname = '축구의 역사';

-- 8. 도서이름의 왼쪽에서 4번째 위치에 '바'라는 문자열을 갖는 도서를 검색하시오
select * from book where bookname LIKE '___바%';

-- 9. 도서 이름에 '축구'가 포함된 출판사를 검색하시오
select publisher from book where bookname LIKE '%축구%';

-- 10. 도서를 이름순으로 검색하시오
select * from book order by bookname asc;

-- 11. 도서를 가격순으로 검색하고, 가격이 같으면 이름순으로 검색하시오
select * from book order by price, bookname;

-- 12. 도서를 가격의 내림차순으로 검색하시오. 가격이 같다면 출판사를 오름차순으로 출력하시오
select * from book order by price desc, publisher asc;

-- 13. 고객이 주문한 도서의 총판매액을 구하시오.
select bookname, sum(price) as 총판매액 from book group by bookname;

-- 14. 2번 김연아 고객이 주문한 도서의 '총 판매액'을 출력하시오.(출력시 총 판매액으로 컬럼명 표시)
select customer.name, sum(orders.saleprice) as '총 판매액'
from book
Join orders on book.bookid = orders.bookid
join customer on customer.custid = orders.custid
where customer.name = '김연아';

-- 15. 고객이 주문한 도서의 총판매액, 평균값, 최저가를 구하시오. (출력시 각 필드명을 제시한 필드명으로 표시)
select sum(saleprice) as sum, avg(saleprice) as avg, min(saleprice) as min from orders group by custid;

-- 16. 서점의 도서 판매 건수를 구하시오.
select count(*) as SaleNum from orders;

-- 17. 가격이 8,000원 이상인 도서를 구매한 고객에 대하여 고객별 주문 도서의 총수량을 구하시오.
select customer.name, count(customer.name) as orders 
from orders
join customer on customer.custid = orders.custid
join book on book.bookid = orders.bookid
where book.price >= 8000
group by customer.name;

-- 단, 2권 이상일 경우만 출력하시오.
select customer.name, count(customer.name) as orders 
from orders
join customer on customer.custid = orders.custid
join book on book.bookid = orders.bookid
where book.price >= 8000
group by customer.name
having orders >= 2;

-- 18. 가장 비싼 도서의 이름을 검색하시오 
select bookname 
from book 
where price = ( 
	select max(price) from book 
);

-- 19. 도서를 구매한 적이 있는 고객의 이름을 검색하시오
select c.name 
from customer c
join orders o on c.custid = o.custid
group by o.custid
having count(o.custid) > 0;

	-- option 2 subquery
	select name from customer where custid in (select custid from orders);

-- 20. '대한 미디어'에서 출판한 도서를 구매한 고객의 이름을 나타내시오
select c.name
from customer c
join orders o on c.custid = o.custid
join book b on b.bookid = o.bookid
where b.publisher = '대한미디어';

	-- option 2 subquery
    select name
    from customer
    where custid in (
		select custid from orders where bookid in (
			select bookid from book where publisher = '대한미디어'
		)
	);
		

-- 21 . 다음과 같은 속성을 가진 NewBook 테이블을 생성하시오
--        - bookid  integer 
--        - bookname(도서이름)  varchar(20)
--        - publisher  varchar(20)
--        - price   integer 
--       제약 조건) 
--         price에 값이 입력되지 않을 경우 기본값은 10000 을 저장한다.
--          또, 가격은 최소 1,000원 이상으로 한다.
create table NewBook (
	bookid integer,
	bookname varchar(20),
	publisher varchar(20),
	price integer default 10000 check (price >= 1000)
    );
    

-- 22 . 다음과 같은 속성을 가진 NewBook1 테이블을 생성하시오
--        - bookname(도서이름)  varchar(20)
--        - publisher  varchar(20)
--        - price   integer 
--       제약 조건) 
--       1. bookname 은 null을 가질 수 없고,
--          publisher 에는 같은 값이 있으면 안된다.  
--          price에 값이 입력되지 않을 경우 기본값은 10000 을 저장한다.
--          또, 가격은 최소 1,000원 이상으로 한다.
create table NewBook1 (
	bookname  varchar(20) NOT NULL,
	publisher  varchar(20) UNIQUE,
	price   integer default 10000 check (price >= 1000)
);

-- 22.  다음과 같은 속성을 가진 NewCustomer 테이블을 생성하시오
--        - custid  integer , 기본키
--        - name  varchar(40)
--        - address  varchar(40)
--        - phone   varchar(30) 

create table NewCustomer (
	custid  integer primary key,
	name  varchar(40),
	address  varchar(40),
	phone   varchar(30)
);
      
-- 23.  다음과 같은 속성을 가진 NewOrders 테이블을 생성하시오
--        - ordertid  integer , 기본키
--        - custid  integer, not null 제약조건, 외래키 연쇄 삭제 (NewCustomer.custid)
--        - bookid  integer, not null 제약조건 
--        - saleprice  integer
--        - orderdate  date 
create table NewOrders (
	ordertid  integer primary key,
	custid  integer not null , 
	bookid  integer not null,
	saleprice  integer,
	orderdate  date,
    foreign key (custid)
		references newcustomer(custid)
        on delete cascade
);

-- 24 . NewBook 테이블에 varchar(13) 자료형의 isbn 속성을 추가하시오
alter table newbook add isbn varchar(13);

-- 25. NewBook 테이블에서 isbn 속성의 데이터 타입을 integer 형으로 변경하세요
alter table newbook 
modify column isbn VARCHAR(13);

-- 26. NewBook테이블의 inbn 속성을 삭제하세요
alter table newbook
drop isbn;

-- 27. NewBook 테이블의 bookname 속성에 not null 제약조건을 적용하세요.
alter table newbook 
modify column bookname varchar(20) not null;

-- 28. NewBook 테이블의 bookid 속성을 기본키로 변경하세요 
alter table newbook
modify column bookid int primary key;

-- 29. NewBook1 테이블을 삭제하세요 
drop table newbook1;

-- 30. NewCustomer 테이블을 삭제하세요. 
drop table newcustomer;

-- 만약 삭제가 거절된다면 원인을 쓰고, 관련된 테이블을 함께 삭제하세요 
-- foreign key 가 neworders 가 연결이 되어 있기에 삭제가 안됌
drop table neworders;
drop table newcustomer;