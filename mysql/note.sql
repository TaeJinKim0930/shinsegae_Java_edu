-- 가격이 20,000 인 도서를 주문한 고객의 이름과 도서의 이름을 조회
select name, bookname , b.price
from customer c, orders o, book b
where c.custid = o.custid and b.bookid = o.bookid and b.price = 20000;

-- 도서를 구매하지 않은 고객을 포함하여 고객의 이름과 고객이 주문한 도서의 판매가격을 구하시오
select c.name, o.saleprice
from customer c left outer join orders o on c.custid = o.custid;

-- 출판사별로 출판사의 평균도서 가격보다 비싼 도서를 조회
select bookname, price
from book
where price > (select avg(price) from book);

--
select name, address
from customer
where address like '대한민국%'
union
select name, address from customer where custid in (select custid from orders);

-- oracle 에서는 minus, intersect 이 있지만 mysql 엔 없엉 -> 그래서 not in, in 으로 써

-- 한국에 거주하는 고객의 이름에서 도서를 주문한 고객의 이름을 빼고 조회
select name
from customer
where address like '대한민국%' and name not in (
	select name
    from customer
    where custid in (
		select custid from orders
	)
);

-- 한국에 거주하는 고객중도서를 주문한 고객의 이름을 조회
select name 
from customer
where address like '대한민국%' and name in (
	select name
    from customer
    where custid in (
		select custid from orders
	)
);

-- 주문이 있는 고객의 이름과 주소를 출력
select name, address
from customer c
where EXISTS (
	select * from orders o where c.custid = o.custid
);
