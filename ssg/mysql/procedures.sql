-- WHILE / ITERATE(continue 와 같은 역할) / LEAVE (break와 같은 역할)
-- 1. 형식: WHILE <부울 식> DO SQL 명령문들.... END WHILE;
-- 1부터 100까지 값을 모두 더하는 기능
DROP PROCEDURE IF exists whilePrc;
delimiter $$
CREATE procedure whilePrc()
BEGIN
              declare i INT;
              declare hap INT;
              SET i = 1;
              set hap = 0;
              while(i <= 100) do
                set hap = hap + i;
                set i = i + 1;
              end while;
              select hap;
           END $$
           delimiter ;
call whilePrc();


DROP PROCEDURE IF exists whilePrc1;
delimiter $$
CREATE procedure whilePrc1()
BEGIN
              declare i INT;
              declare hap INT;
              SET i = 1;
              set hap = 0;
             myWhile: while(i <= 100) do    -- 7의 배수만 제외하고 누적의 합
                  if(i%7 = 0) then
                         set i = i + 1;
				    	 iterate myWhile;
                  end if;
                 set hap = hap + i;
                 if(hap > 1000) then
                   leave myWhile;
                 end if;
                    set i = i+1;
             end while;
              select hap;
END $$
delimiter ;
call whilePrc1();

  -- 응용 : 1부터 1000까지의 숫자 중에서 3의 배수 또는 8의 배수만 더하는 procedure whileProc2 를 작성하세요   3+6+8+9+12.....
-- DROP PROCEDURE IF exists whilePrc3;
--   delimiter $$
--      create procedure whileProc3()
--      begin
--                 declare i int;
--                 declare hap int;
--                 set i = 1;
--                 set hap = 0;
--                mylabel2: while(i<=1000) do
--                   if(i % 3 = 0 or i % 8 = 0 ) then
--                      set hap = hap + i;
--                      set i = i + 1;
--                      iterate mylabel2;
--                   end if;
--                  /* if(i % 8 = 0) then
--                      set hap = hap + i;
--                      set i = i + 1;
--                   end if; */
--                   set i = i+1;
--                 end while;
--                 select hap;
--  end $$
--  delimiter ;
-- call whileProc3();


-- 오류 처리 declare action handler 오류조건 처리할 문장;
-- action : 오류 발생 시 행동을 정의. continue, exit 둘 중 하나 선택. continue 선택시 제일 뒤의 '처리할 문장' 이 처리된다.
-- 오류조건 : 어떤 오류를 처리할 것인지 지정. sqlexception, sqlwarning, not found
-- 처리할 문장 : 한문장, 처리할 문장이 여러개일 경우 begin 문장들 end 
drop procedure if exists errorProc;
delimiter $$
create procedure errorProc()
begin
	declare continue handler for 1146 select '테이블이 존재하지 않습니다.' as 'message'; -- sql state '42502'
    select * from noTable; 
end $$
delimiter ;
call errorProc();


