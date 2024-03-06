select * from producttbl where productName = '세탁기';

create table indexTbl2(first_name varchar(14), last_name varchar(16), hire_date date);
insert into indexTbl2 select first_name, last_name, hire_date from employees.employees
	limit 1000;
select count(*) from indextbl2;
    
-- indextbl2 에 first_name = 'Mary'
-- Mary 를 찾을때 까지 찾으니 O(n) 이라 1000개면 1000번
select * from indextbl2 where first_name = 'Mary';
-- 그래서 index 를 써서 검색 엔진의 효율을 높임 
create index idx_indextbl2_firstname on indextbl2(first_name);
-- (같은 방법으로 검색을 해도 index 를 사용을 했다는 뜻으로 결과같 우측 result grid 있는곳에서 하단으로 내리면 execution plan이 있는데 그걸 보면 결과를 보여줌)
select * from indextbl2 where first_name = 'Mary';
-- 하지만 index 를 남발하면 부담이 되므로 남발은 하면 안됌 (db의 10%정도를 잡아야 됨)


create table tbl1 (a int primary key, b int, c int);
show index from tbl1;

create table tbl2 (a int primary key, b int unique, c int unique, d int);
show index from tbl2;

create table tbl3 (a int primary key, b int unique, c int unique not null, d int);
show index from tbl3;


-- 회원 usertbl에 회원 2명 정보를 입력해 주세요.
insert into usertbl2 values (20, 'genie', 1999, 'YC', '010', '21228150', 160, '1999-09-01'); 
select * from usertbl2;

-- 테이블 변경 userid 열의 pk 제거, name 열을 pk 로 지정
alter table usertbl2 drop primary key;
show index from usertbl2; -- 삭제되서 아무것도 안나옴

alter table usertbl2 add constraint pk_name primary key(name);
show index from usertbl2; -- name 이 pk 로 나옴

select * from usertbl2; -- name 별로 asc 이 됨

-- pk 지정한 열은 클러스터형 인덱스가 된다.
-- unique not null 지정한 열은 클러스터형 인덱스로 생성된다.
-- unique (unique null) 지정한 열은 보조 인덱스가 생성된다.
-- pk와 unique not null 이 지정한 열이 두 개가 있다면 pk의 열이 우선 클러스터형 인덱스가 생성된다.
-- pk로 지정한 열로 데이터가 오름차순 정렬된다.