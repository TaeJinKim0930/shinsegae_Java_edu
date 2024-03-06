-- create table buytbl3 (select num, userID, prodName from buytbl);

-- buytbl 테이블에서 사용자id 와 재고수량을 아이디 오름정렬하여 출력
-- select userID, sum(amount) amount from buytbl group by userID order by userid asc;

-- 전체 구매자가 구매한 물품의 평균 출력 (출력컬럼명 avg)
-- select userid, avg(amount) as Average from buytbl group by userid;

-- usertbl 에서 가장 큰 키와 작은 키의 회원의 이름과 키
-- select name, height from usertbl where height = ( select max(height) from usertbl) or height = (select min(height) from usertbl);

-- 휴대폰이 있는 사용자의 수 (null 자동 제외)
-- select count(mobile1) from usertbl;

-- group by의 조건 Having

-- 사용자별 총 구매액 출력 buytbl (총 구매액이 100 이상)
-- select userid, sum(price*amount) as Total_Price from buytbl group by userid having Total_Price > 100;

-- 총합 또는 중간합계를 구하려면 group by 와 함께 rollup 을 사용 : 카테고리별 sum 해주고 전체 sum 도 해줌
-- groupName(분류) 별로 합계와 그 총합을 구하고 싶다.
-- select num, groupName, sum(price*amount) as total from buytbl group by groupName, num with rollup;

--  트렌젝션 : 테이블의 데이터를 변경 할때 실제 테이블에 완전히 적용하지 않고, 임시로 적용 시키는 것, 실수가 있을경우 취소 가능
-- select * from usertbl;
-- desc usertbl;
-- insert into usertbl values ('sym', 'yoomi', 2000, '경기', '010', '21228150', 180, '2024-01-17');
-- rollback;

-- test 테이블을 생성 하는데
-- create table testTbl1 (id int, userName char(3), age int);
-- insert into testTbl1 values (1, 'sss', 20);
-- insert into testTbl1 (id, userName) values (2, 'namess');
--  insert into testTbl1 (userName, id, age) values ('names1', 3, 17);
-- select * from testTbl1;

-- create table testTbl2 (id int auto_increment primary key, userName char(3), age int);
-- insert into testTbl2 values (null, 'sw', 26);
-- select * from testTbl2;

-- 대량의 샘플데이터 생성 방법 : inesrt into ... select
-- create table testTbl3 (id int, fname varchar(50), lname varchar(50));
-- insert into testTbl3  select emp_no, first_name, last_name from employees.employees;
-- commit;

-- testTbl4 employees.employees 테이블 속성중 emp_no, first_name, last_name
-- create table testTbl4 (select emp_no, first_name, last_name from employees.employees);
-- commit;

-- 데이터 수정 : update
-- update testtbl4 set last_name = 'none' where first_name = 'Kyoichi';

-- 데이터의 삭제 : delete from tablename where 조건 (행, row, tuple) 단위로 삭제
-- delete from testtbl4 where first_name = 'Berni' limit 5;
--  select * from testTbl4 where first_name = 'Berni';
-- rollback;

-- 대용량 테이블 3개 생성. bigtbl1, 2, 3 employees.employees 의 전체 속성을 대상으로 생성
-- create table bigTbl1 ( select * from employees.employees);
-- create table bigTbl2 ( select * from employees.employees);
-- create table bigTbl3 ( select * from employees.employees);

-- delete from bigTbl1; -- table 의 모든 data 를 날린거
-- select * from bigTbl1;

-- drop table bigTbl2; -- 테이블 없애기
-- select * from bigTbl2;

--  truncate table bigTbl3; -- 오려내기. delete 보다 수행속도가 더 빠름. 로그를 기록하지 않아서 빠름
-- select * from bigTb3l;

-- usertbl 에서 아이디 이름 주소만 가지고와서 membertbl 생성. 3개만
-- drop table membertbl;
-- create table membertbl (select userid, name, addr from usertbl) limit 3;
-- select * from membertbl;

-- alter table membertbl add constraint pk_memberTBL primary key (userID);
-- desc membertbl;

-- insert ignore into membertbl values ('bbq', '비비큐', '한쿡') on duplicate key update name = '비비큐_간장', addr = '미국';
-- insert ignore into membertbl values ('shk', '램프왕', '서울');
-- insert ignore into membertbl values ('wer', '비비켕', '일본');
-- insert ignore into membertbl values ('bdt', '안전환', '한쿡');

-- with 절 ,cte ; common table expression
/* with CTE_테이블명 (열이름 ..., )
 AS
 	(쿼리문) select 열 이름 from CTE_테이블이름;
  */  
-- buytbl 에서 사용자 아이디당 총 구매액을 출력하는 query
-- select userid, sum(price * amount) as total from buytbl group by userid;
--  WITH abc(userid, total)
-- as (select userid, sum(price * amount) from buytbl group by userid) select * from abc order by total desc;


-- usertbl 에서 각 지역별로 가장 큰 키를 가진 회원 1명을 뽑고 평균을 구해라
with tallest (addr, tallest)
as (select addr, max(height) from usertbl group by addr) select avg(tallest) as avg from tallest;



