SELECT * FROM emartdb.학생수강;

delete from 수강;
delete from 학생수강 where 강좌이름 = '스포츠경영학';

-- 안정환 체육학과 입학. 학번, 이름, 학과, 주소 넣기
insert into 학생수강 (학생번호, 학생이름, 학과, 주소) values (502, '안정환', '체육학과', '대한민국 인천');

-- 학생수강 조회, 몇명?
select count(강좌이름) as 강좌이름 from 학생수강;

-- 수정이상
-- 박지성 학생 주소가 서울로 수정 요청
update 학생수강 set 주소 = '대한민국 서울' where 학생이름 = '박지성';




SELECT * FROM emartdb.학생수강;
insert into 학생수강 values(501, '박지성','컴퓨터학과','영국 맨체스터');
insert into 학생수강 values(402, '김연경','체육학과','대한민국 서울');
insert into 학생수강 values(502, '손흥민','체육학과','영국 토트넘');
insert into 학생수강 values(503, '박지성2','컴퓨터학과','영국 맨체스터');

SELECT * FROM emartdb.수강;
INSERT INTO 수강 (학생번호, 강좌이름, 강의실)
VALUES (
    (SELECT 학생수강.학생번호 FROM 학생수강 where 학생번호 = '501'),
    '데이터베이스',
    '공학관110'
);
INSERT INTO 수강 (학생번호, 강좌이름, 강의실)
VALUES (
    (SELECT 학생수강.학생번호 FROM 학생수강 where 학생번호 = '502'),'데이터베이스','공학관110');
INSERT INTO 수강 (학생번호, 강좌이름, 강의실)
VALUES (
    (SELECT 학생수강.학생번호 FROM 학생수강 where 학생번호 = '503'), '스포츠경영학','공학관112');
INSERT INTO 수강 (학생번호, 강좌이름, 강의실)
VALUES (
    (SELECT 학생수강.학생번호 FROM 학생수강 where 학생번호 = '402'), '스포츠교수법','공학관111');
