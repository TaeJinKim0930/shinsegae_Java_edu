-- emartdb 생성
-- 교안에서 제시안 usertbl, producttbl 생성 mysqlworkbench를 이용하여 2개의 테이블을 생성
--  usertbl 과 buytbl이 자료를 emartdb의 테이블에 각각 copy 해주세요

SELECT * FROM emartdb.buytbl;
select * from emartdb.usertbl;

insert into emartdb.usertbl (username, birthyear, addr, mobile) select name, birthyear, addr, concat(mobile1, mobile2) from sqldb.usertbl;
insert into emartdb.buytbl (username, prodname, price, amount) select name, prodname, price, amount from sqldb.buytbl;