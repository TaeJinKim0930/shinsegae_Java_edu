drop procedure if exists errorProc2;
delimiter $$
create procedure errorProc2()
begin
	show errors;
    select '오류가 발생하여 작업을 취소시켰습니다.' as 'message';
    rollback;
end;
insert into usertbl values ('sym1', '신세계', 1990, '서울', null, null, 178, current_date());
end $$
	delimiter ;
call errorProc2();