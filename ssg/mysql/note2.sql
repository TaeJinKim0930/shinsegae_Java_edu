-- page9, 1번 -78 과 78 의 절댓값
select abs(-78), abs(78) from dual;
-- page9, 2번 첫째 자리까지 반올림
select round(4.85, 10);
-- page9, 3번 평균 주문금액을 백원 단위로 반올림
select custid 고객번호, round(sum(saleprice)/count(*), -2) 평균금액
from orders
group by custid;


-- page 11, 4번. 도서제목에 야구가 포함된 도서를 농구로 변경한 후 도서 목록을 보이시오
select bookid, replace(bookname, '야구', '농구') bookname, publisher from book;
select * from book;

-- page 12, 5 번 굿스포츠에서 출판한 도서의 제목과 제목의 글자 수를 확인하시오. (한글은 2바이트 혹은 UNICODE 경우는 3바이트를 차지함)
-- char_length 랑 length 사용


-- page 12, 6 서점의 고객 중에서 같은 성(姓)을 가진 사람이 몇 명이나 되는지 성별 인원수를 구하시오.
-- SUBSTR 사용
select substr(name, 1, 1) '성', count(*) 
from customer
group by substr(name, 1, 1);


select adddate('2024-01-19', interval -5 day) before5,
	adddate('2024-01-19', interval +5 day) after5;
    
    
    

-- 7 서점은 주문일로부터 10일 후 매출을 확정한다. 각 주문의 확정일자를 구하시오.
select  orderid, 
		orderdate, 
        adddate('2024-01-19', interval +10 day) after5
from orders;

-- 8 서점이 2014년 7월 7일에 주문 받은 도서의 주문번호, 주문일, 고객번호, 도서번호를 모두보이시오. 
-- 단, 주문일은 '%Y-%m-%d' 형태로 표시한다.
select  orderid, 
		date_format(orderdate, '%Y-%m-%d'), 
		custid, 
        bookid 
from orders
where orderdate = str_to_date('2024-07-07', '%Y-%m-%d');

-- 9 DBMS 서버에 설정된 현재 날짜와 시간, 요일을 확인 하시오.
select sysdate(), date_format(sysdate(), '%Y:%m:%d %a %h:%i') 'SYSDATE_1';

-- 10 이름, 전화번호가 포함된 고객목록을 보이시오. 단, 전화번호가 없는 고객은‘연락처없음’으로 표시한다.
select name, IFNULL(phone, '연락처없음') from customer;

-- 11 고객 목록에서 고객번호, 이름, 전화번호를 앞의 두 명만 보이시오. 
set @seq:= 0;
select (@seq:= @seq + 1) '순번', custid, name, phone 
from customer
where @seq < 2;


-- view
create view vwbook1 
as 
select * from book 
where bookname LIKE '%축구%';

select * from vwbook1;


-- 20 읽기전용 뷰
create view vw_order (orderid, custid, name, bookid, bookname, saleprice, orderdate)
as
select od.orderid, od.custid, cs.name, od.bookid, bk.bookname, od.saleprice, od.orderdate
from orders od, customer cs, book bk
where od.custid = cs.custid and od.bookid = bk.bookid;

select orderid, bookname, saleprice from vw_Customer where name = '김연아';

-- 수정가능한 뷰
create or replace view vw_order (orderid, custid, name, bookid, bookname, saleprice, orderdate)
as
select od.orderid, od.custid, cs.name, od.bookid, bk.bookname, od.saleprice, od.orderdate
from orders od, customer cs, book bk
where od.custid = cs.custid and od.bookid = bk.bookid;


-- 22
create or replace view vw_Customer (custid, name, address) 
as
select custid, name, address
from customer
where address LIKE '%영국%';

select * from vw_customer;




select * from information_schema.tables where table_schema LIKE 'shinsaegebookdb';

-- 연습문제 1
create or replace view highorders (bookid, bookname, name, custid, publisher, price)
as
select b.bookid, b.bookname, c.name, c.custid, b.publisher, b.price
from book b, orders o, customer c
where o.bookid = b.bookid and  c.custid = o.custid and price >= 20000;

-- 연습문제 2
select bookname, name from highorders;

-- 연습문제 3
create or replace view highorders (bookid, bookname, name, custid, publisher)
as
select b.bookid, b.bookname, c.name, c.custid, b.publisher
from book b, orders o, customer c
where o.bookid = b.bookid and  c.custid = o.custid and price >= 20000;

-- 확인
select * from highorders;

-- 데이터가 어디에 저장되어 있는지 확인
show variables like 'datadir';

--
create index ix_book on book(bookname);
create index ix_book2 on book(publisher, price);
show index from book;

select * from book where publisher = '대한미디어' and price >= 30000;
