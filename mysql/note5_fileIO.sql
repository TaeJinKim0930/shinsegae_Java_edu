create database	moviedb;
use moviedb;

create table movietbl (
	m_id int,
    m_title varchar(30),
    m_director varchar(20),
    m_star varchar(20),
    m_script longtext,
    m_film longblob
) default charset utf8mb4;



INSERT INTO movietbl VALUES (1, '쉰들러 리스트' , '스티븐 스필버그' , '리암 니슨',
load_file('C:/datasource/Movies_add/Movies_add/schindler.TXT'), load_file('C:/datasource/Movies_add/Movies_add/schindler.mp4')
);
 -- 1
INSERT INTO movietbl VALUES (2, '쇼생크 탈출' , '프랭크 다라본트' , '팀 로빈슨',
load_file('C:/datasource/Movies_add/Movies_add/shawshank.TXT'), load_file('C:/datasource/Movies_add/Movies_add/shawshank.mp4')
);
-- 2
INSERT INTO movietbl VALUES (3, '라스트 모히칸' , '마이클 만' , '다니엘 데이 루이스',
load_file('C:/datasource/Movies_add/Movies_add/mohican.TXT'), load_file('C:/datasource/Movies_add/Movies_add/mohican.mp4')
);

select * from movietbl;

-- m_script, m_film 에 null 을 해결하기
-- 1. 최대 패킷 크기(파일크기) 확인 max_allowed_packet 값 조회
show variables like 'max_allowed_packet'; -- 67108864, 64M

-- 2. 시스템 변수에 secure_file_priv
show variables like 'secure_file_priv'; -- 'C:\ProgramData\MySQL\MySQL Server 8.0\Uploads\'


-- text file 로 받기
select m_script from movietbl where m_id = 1
into outfile 'C:/datasource/Movies_add/Movies_add/schindler_out.txt'
lines terminated by '\\n';
	-- 영화 쉰들러 리스트의 영화대본(m_script)를 schindler_out.txt 파일로 다운 받겠다.
    
    
    
-- binary file 로 영화클립 파일 다운로드
select m_film from movietbl where m_id = 3
into dumpfile 'C:/datasource/Movies_add/Movies_add/mohican_out.mp4';


-- 피봇 (pivot) : 열에 포함된 여러 갑을 출력하고 여러열로 return 하여 테이블 return 식을 회전하고 필요하면 집계까지 수행하는 작업
create table pivotTest (
	name char(3),
    season char(2),
    amount int
);

insert into pivotTest values ('ls1', '여름', 123);
insert into pivotTest values ('ls2', '봄', 124);
insert into pivotTest values ('ls3', '겨울', 125);
insert into pivotTest values ('ls4', '가을', 126);

select * from pivotTest;

select name, 
		sum(if(season = '봄', amount, 0)) as '봄',
        sum(if(season = '여름', amount, 0)) as '여름',
        sum(if(season = '가을', amount, 0)) as '가을',
        sum(if(season = '겨울', amount, 0)) as '겨울',
        sum(amount) as '합계' from pivotTest group by name;


-- json 데이터
-- 웹/앱 응용 프로그램 등과 데이터를 교환하기 위한 개방형 표준 포맷이다. 속성 : 값
select * from usertbl;
desc usertbl;
select json_object('name', name, 'height', height) as 'JSON 값' from usertbl where height > 180;


set @json = '{
	"usertbl" : [{"name" : "임재범", "height":182},{"name" : "이승기", "height":182},{"name" : "성시경", "height":186}]
}';

select json_valid(@json) as json_valid;
select json_search(@json, 'one', '성시경') as json_search;
select json_extract(@json, '$.usertbl[2].name') as json_extract;

select json_insert(@json, '$.usertbl[0].mDate', '2024-01-21') as json_insert;
select json_replace(@json, '$.usertbl[0].name', '신세계') as json_replace;
select json_remove(@json, '$.usertbl[0]') as json_remove;

