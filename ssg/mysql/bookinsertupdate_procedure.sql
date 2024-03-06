 # 실습 2.동일한 도서가 있는지 점검한 후 삽입하는 프로시저 : bookinsertupdate.sql 
use shinsaegebookdb;
 delimiter // -- procedure 가 시작되고 종료됨을 의미함
create procedure bookinsertupdate (IN mybookid integer, IN mybookname varchar(40), IN mypublisher varchar(40), in myprice integer)
begin
	# 이름으로 해당 도서가 있으면 해당 도서 업데이트
    declare myCount integer; -- mybookname 과 같은 책인 몇권이 있는지 확인하여 mycount 변수에 저장(into) 
    select count(*) into myCount from book where bookname LIKE mybookname;
    
    if myCount != 0 then
		set sql_safe_updates = 0;
        update book set price = myprice
        where bookname like mybookname;
	else 
		insert into book(bookid, bookname, publisher, price) values (mybookid, mybookname, mypublusher, myprice);
    end if;    
end;
// delimiter ;
 

-- 축구의 역사 책의 가격을 10,000 으로 변경
call bookinsertupdate(1, '축구의역사', '굿스포츠', 10000);
-- 18, 최강야구, 야구나라, 15000 책 저장
call insertbook(18, '최강야구', '야구나라', 15000);
-- book 조회

