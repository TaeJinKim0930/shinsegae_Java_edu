 # 실습 3. Book테이블에 저장된 도서의 평균 가격을 반환하는 프로시저 : averageprice.sql
 
 drop procedure AveragePrice;
 
delimiter //
create procedure AveragePrice(out AverageVal integer)
begin
	select avg(price) into AverageVal
    from book where price is not null;
end;
// delimiter ;

call AveragePrice(@myVal);
select @myVal;