set@myvar1 = 5;
set@myvar2 = 3;
set@myvar3 = 4.2;
set@myvar4 = 'ㅎㅇ';


select @myvar1;
select @myvar2;
select @myvar3;
select @myvar4;

select @myvar1 + @myvar2;
select @myvar2 + @myvar3;
select @myvar3 + @myvar4;

select @myvar4, Name from usertbl where height > 100;

select @myvar1 = 3;
prepare myQuery
	from 'select name, height from usertbl order by height limit ?';
execute myQuery using @myvar1;

create table employee (name varchar(255), salary int, location varchar(255));
desc employee;

insert into employee values ('Amit', 6554, 'seoul');
insert into employee values ('Sumit', 5980, 'busan');
insert into employee values ('Sudha', 7887, 'masan');

prepare prepared_stmt from 'insert into employee values (?,?,?)';

set @name = 'ruby';
set @sal = 9000;
set @loc = 'jeju';

execute prepared_stmt using @name, @sal, @loc;
select * from employee;

prepare pre_empSelect from 'select ?, ?, ? from employee where name = ?';

set @col = 'salary';
set @col2 = 'locatoin';
set @name = 'ruby';

execute pre_empSelect using @col, @name, @col2, @name;

create table student (name varchar(30), age int, score int);
insert into student values('jimi', 22, 8);
set @table = 'student';
set @statement = concat ('select * from ', @table);
prepare pre_student from @statement;
execute pre_student;


SELECT REPLACE('MYSQL HUIHUIHUI', 'HUI', 'HOI');

