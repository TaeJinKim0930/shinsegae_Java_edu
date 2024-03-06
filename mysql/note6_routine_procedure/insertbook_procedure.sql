# from note6_routine_procedure
# 실습 1.sinsaegebookdb.Book 테이블에 한개의 투플을 삽입하는 프로시저 : insertbook.sql 
use shinsaegebookdb;
drop procedure insertbook;
delimiter //
create procedure insertbook (IN mybookid integer, IN mybookname varchar(40), IN mypublisher varchar(40), in myprice integer)
begin
	insert into book (bookid, bookname, publisher, price) values (mybookid, mybookname, mypublisher, myprice);
end;
// delimiter ;
 
 call insertbook(14, '스포츠 과학', '과학사', 25000);