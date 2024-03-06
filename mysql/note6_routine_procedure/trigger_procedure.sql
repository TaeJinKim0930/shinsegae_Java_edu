 /*
   트리거 : 데이터의 변경(insert,delete,update) 문이 실행될때 자동으로 같이 실행되는 프로시저이다. 
   보통의 트리거는 데이터의 변경문이 처리되는 세 가지 시점, 실행전(BEFROE), 대신하여(INSTEAD OF), 실행 후(AFTER) 동작
   
   root 계정에서 트리거 작동에 필요한 문장을 실행 하여 야 한다. 
   SET global log_bin_trust_function_creators=ON;
   
   Book_log 테이블 생성
   (bookid_log integer, bookname_log varchar(40), publisher_log varchar(40),price__log integer) 
   
      
 */

-- set global log_bin_trust_function_creators = on;

-- create table Book_log(bookid_log integer, bookname_log varchar(40), publisher_log varchar(40),price__log integer);

-- AfterInsertBook
delimiter //
create trigger AfterInsertBook AFTER insert on book for each row
begin
	declare average integer;
    insert into book_log values(new.bookid, new.bookname, new.publisher, new.price);
    
end;
// delimiter ;

insert into book values (20, '아시안컵 축구 우승','대한민국축구왕', 25000);
select * from book_log where bookid = 20;