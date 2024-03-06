 /*    커서 사용 : SQL문의 실행 결과가 다중행일 경우 프로그램에서는 한 행씩 처리한다. 
 #    커서는 실행결과 테이블을 한번에 한 행씩 처리하기 위해 테이블의 행을 순서대로 가리키는 데 사용된다.      
 
 # - 커서 생성 : CURSOR 커서이름 IS 커서 정의 , DECLARE 커서이름 CURSOR FOR 
 
 # - 커서 사용 시작: OPEN 커서이름
 
 # - 행 데이터를 가져오기 : FETCH 커서 이름 INTO 변수
 
 # -커서 사용 끝냄 : CLOSE 커서이름 
 */
 
 # 실습 4. 커서를 사용하여 Orders테이블의 판매 도서에 대한 이익금을 계산하는 프로시저 : interest.sql
 #  조건 : 도서 가격이 30,000원 이상이면 이익이 10%이고, 30,000 미만이면 5% 
 
 delimiter //
 create procedure interest()
begin
	# 변수 선언
    declare myInterest integer default 0.0;
    declare price integer;
    declare endOfRow boolean default false;

    
    # 커서 생성
    declare interestC cursor for select saleprice from orders;
	declare continue handler for not found set endOfRow = true;
        
    # 커서 오픈
    open interestC;
    
    # 커서 looping 하면서 fetch
    cursor_loop : LOOP
		FETCH interestC into price;
        if endofRow then leave cursor_loop;
        end if;
        if price >= 30000 then 
			set myInterest = myInterest + price * 0.1;
        else
			set myInterest = myInterest + price * 0.05;
		end if;
    # loop 종료
    end loop cursor_loop;
    # 커서 종료
    close interestC;
    select concat('전체 이익금액 = ', myInterest);

end;
//
delimiter ;

call interest();