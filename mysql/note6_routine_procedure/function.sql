/*
	사용자 정의 함수 function
	procedure 는 call 이라는 명령에 의해 실행되는 독립적인 프로그램
    반면에 function은 select 문이나 procedure 내에서 호출되어 sql 문이나 procedure 에 값을 제공하는 용도로 사용
    
    - 스칼라 함수 : built-in 함수 (단일 값을 돌려주는 함수)
    
*/

# 1. 판매된 도서의이익을 계산을 위해서, 각 주문 건별로 실제 판매가격인 saleprice 를 입력 받아 가격에 맞는 이익
# (30,000 이상 도서는 10%, 미만은 5%) 계산해서 반환하는 함수를 만들어 보시오
delimiter //
create function fn_Interest(price integer) returns integer 
begin
	declare myInterest integer;
    if price >= 30000 then set myInterest = price * 0.1;
    else set myInterest = price * 0.05;
    end if;
	return myInterest;
end;
// delimiter ;

select custid, orderid, saleprice, fn_interest(saleprice) interest from orders;