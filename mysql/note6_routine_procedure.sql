/*
 2024.01.24 수업
 저장 프로그램은 로직을 프로시저로 구현하여 객체형태로 사용한다.
 저장 프로그램은 일반 프로그래밍에서 사용하는 함수와 비슷한 개념이다.
 작업 순서가 정해진 독립된 프로그램 수행 단위이다.
 프로시저가 정의된 다음 MySQL(DBMS)에 저장되어 저장프로그램이라고 명칭한다.
 저장 프로그램은 저장 루틴(routine), 트리거(trigger), 이벤트(event)로 구성된다.
 저장 루틴은 프로시저(procedure) , 함수 (function) 분류된다.*/
 
  -- 제어문
 -- delimiter : 구문 종료 기호를 설정
 -- begin - end : 프로그램 문을 블록으로 묶음, {}, 중첩가능
 -- 조건의 검사 결과에 따라 문장을 선택적으로 수행 : IF - ELSE
 -- LEAVE문을 만나기 전까지 반복 : LOOP 라벨 : LOOP SQL문 (LEAVE) ENDLOOP;
 -- WHILE문 : 조건이 참일 경우 WHILE 문의 블록을 수행 : WHILE(조건) DO SQL문 END WHILE;
 -- REPEAT문 : 조건이 참일 경우 REPEAT의 블럭을 수행 : REPEAT SQL문 UNTIL(조건) END REPEAT;
 -- RETURN문 : PROCEDURE 를 종료할때랑, 상태값을 반환할때 사용. RETURN [식]
 
 # 실습 1.sinsaegebookdb.Book 테이블에 한개의 투플을 삽입하는 프로시저 : insertbook.sql  
 
 # 실습 2.동일한 도서가 있는지 점검한 후 삽입하는 프로시저 : bookinsertupdate.sql 

 
 # 실습 3. Book테이블에 저장된 도서의 평균 가격을 반환하는 프로시저 : averageprice.sql
 
 
 /*    커서 사용 : SQL문의 실행 결과가 다중행일 경우 프로그램에서는 한 행씩 처리한다. 
 #    커서는 실행결과 테이블을 한번에 한 행씩 처리하기 위해 테이블의 행을 순서대로 가리키는 데 사용된다.      
 
 # - 커서 생성 : CURSOR 커서이름 IS 커서 정의 , DECLARE 커서이름 CURSOR FOR 
 
 # - 커서 사용 시작: OPEN 커서이름
 
 # - 행 데이터를 가져오기 : FETCH 커서 이름 INTO 변수
 
 # -커서 사용 끝냄 : CLOSE 커서이름 
 */
 
 # 실습 4. 커서를 사용하여 Orders테이블의 판매 도서에 대한 이익금을 계산하는 프로시저 : interest.sql
 #  조건 : 도서 가격이 30,000원 이상이면 이익이 10%이고, 30,000 미만이면 5% 
 
 /*
   트리거 : 데이터의 변경(insert,delete,update) 문이 실행될때 자동으로 같이 실행되는 프로시저이다. 
   보통의 트리거는 데이터의 변경문이 처리되는 세 가지 시점, 실행전(BEFROE), 대신하여(INSTEAD OF), 실행 후(AFTER) 동작
   
   root 계정에서 트리거 작동에 필요한 문장을 실행 하여 야 한다. 
   SET global log_bin_trust_function_creators=ON;
   
   Book_log 테이블 생성
   (bookid_log integer, bookname_log varchar(40), publisher_log varchar(40),price__log integer) 
   
      
 */
 
 