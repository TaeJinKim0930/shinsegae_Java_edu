-- JOIN 연습문제
use sqldb;


-- empTbl.sql 을 실행하세요. 각 튜플의 내용을 확인하고 1~5 번까지 작성하세요 


-- 1. 구매 테이블에서 아이디가 'JYP'를 가진 사람이 구매한 물건을 발송하기 위해 이름/주소/연락처를 조회하시오.
select u.userid, name, addr, mobile1, mobile2 
from usertbl u, buytbl b 
where b.userid = 'JYP' AND b.userid = u.userid;

-- 2. 전체 회원들이 구매한 목록 모두를 아이디 순으로 출력하세요
select * from buytbl 
order by userid asc;

-- 3. 전체 회원의 구매기록을 조회하시오. 단, 구매 기록이 없는 회원도 출력하세요
select * from usertbl u 
left outer join buytbl b on u.userid = b.userid;

-- 4. 한번 도 구매한 적이 없는 회원의 아이디, 이름, 주소 , 연락처를 조회하세요 (김경호 임재범 이승기)
select u.userid, u.name, u.mobile1, u.mobile2
from usertbl u 
left outer join buytbl b on u.userid = b.userid 
where NOT EXISTS (
	select amount 
    from buytbl b 
    where b.userid = u.userid 
);
-- select count(*) from usertbl u left outer join buytbl b on u.userid = b.userid  where amount IS NULL;

-- 5. 우대리 매니저의 연락처를 조회하세요 (emp table)
select emptel 
from emptbl 
where emp = (
	select manager 
    from emptbl 
    where emp = '우대리'
);
-- select * from emptbl;
-- select manager from emptbl where emp = '우대리';


-- 6. usertbl에서 사용자를 조회하되 전화번호가 없는 사람을 제외하여 조회하세요 
select * from usertbl where mobile1 IS NOT NULL;
-- select * from usertbl;

-- 7. usertbl에서 전화가 없는 사람만 조회하세요
select * from usertbl where mobile1 IS NULL;

	-- option 2
	select u1.* from usertbl u1
	join usertbl u2 on u1.userid = u2.userid
	where (u1.mobile1 is null) and u2.userid = u1.userid;
 
 
-- stdclub.sql 을 실행하고 각 튜플의 내용을 확인 하고 문제르 푸세요
-- 8.  학생 테이블, 동아리 테이블, 학생동아리 테이블을 이용해서 학생을 기준으로 학생 이름/ 지역/가입한 동아리/동아리 방 을 조회하세요
select s.stdname, s.addr, sc.clubname, c.roomNo 
from stdtbl s
left outer join stdclubtbl sc on s.stdname = sc.stdname
left outer join clubtbl c on c.clubname = sc.clubname
where sc.clubname is not null; -- left outer join 을 해서 동아리 가입을 하지 않은 학생까지 보여줌 그래서 not null 체크


-- 9.  동아리를 기준으로 가입한 학생의 목록을 조회하세요
select s.stdname 
from stdtbl s
 where stdname in (
	select sc.stdname 
    from stdclubtbl sc 
    where sc.stdname is not null
);
	-- option 2 동아리 기준 한명이 여러개의 동아리를 가입했기에 distinct
	select distinct sc.stdname
	from clubtbl c
	join stdclubtbl sc on sc.clubname = c.clubname
	where sc.stdname is not null;



-- 10. 동아리에 가입되지 않은 학생의 이름도 포함하여 학생의 이름/주소/동아리명/동아리 방 조회하세요
select s.stdname, s.addr, sc.clubname, c.roomNo 
from stdtbl s
left outer join stdclubtbl sc on s.stdname = sc.stdname
left outer join clubtbl c on c.clubname = sc.clubname;

-- 11. 동아리를 기준으로 가입된 학생을 출력하되, 가입학생이 하나도 없는 동아리도   (이름/주소/동아리명/동아리 방) 조회하세요 .
select s.stdname, s.addr, c.clubname, c.roomno 
from clubtbl c
left outer join stdclubtbl sc on sc.clubname = c.clubname
left outer join stdtbl s on sc.stdname = s.stdname;



-- 12. 동아리에 가입하지 않은 학생도 출력하고, 학생이 한 명도 없는 동아리도 조회 하세요.
select s.stdname, s.addr, c.clubname, c.roomno 
from clubtbl c
left outer join stdclubtbl sc on sc.clubname = c.clubname
left outer join stdtbl s on sc.stdname = s.stdname
union
select s.stdname, s.addr, c.clubname, c.roomno 
from clubtbl c
right outer join stdclubtbl sc on sc.clubname = c.clubname
right outer join stdtbl s on sc.stdname = s.stdname;
