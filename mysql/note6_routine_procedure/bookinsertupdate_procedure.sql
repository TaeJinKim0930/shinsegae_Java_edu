# 실습 2.동일한 도서가 있는지 점검한 후 삽입하는 프로시저 :bookInsertUpdate
 use shinsaegebookdb;
  DROP procedure  BookinsertUpdate;
  DELIMITER //
  CREATE PROCEDURE BookinsertUpdate (mybookid INTEGER, IN mybookname VARCHAR(40), IN mypublisher VARCHAR(40), IN myprice INTEGER)
  BEGIN
  # 이름으로 해당 도서가 존재하는지 검사  [ 변수선언 : DECLARE ]
   DECLARE mycount INTEGER;  -- mybookname 과 같은 책이 몇권이 있는지 확인하여 mycount 변수에 저장 (into)
   select count(*) into mycount from book where bookname like mybookname;
   if mycount != 0 THEN
		SET @sql_safe_updates = 0;
			update book set price = myprice
            where bookname like mybookname;
	ELSE
		INSERT INTO book(bookid , bookname, publisher, price ) VALUES (mybookid , mybookname, mypublisher, myprice );
	END IF;
  END;
   // DELIMITER ;
  

-- 축구의 역사 책의 가격을 10,000 으로 변경
 CALL BookinsertUpdate(1,'축구의 역사', '과학서적' ,10000 );
-- 18, 최강야구, 야구나라, 15000 책 저장
call insertbook(18, '최강야구', '야구나라', 15000);
-- book 조회