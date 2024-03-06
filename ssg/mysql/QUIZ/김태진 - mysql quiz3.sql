-- 전체 테이블 보기
select * from dept d
left join emp e on d.deptno = e.deptno;


-- 1) 사원의 이름과 직위를 출력하시오. 단, 사원의 이름은'사원이름', 직무는'직무'로 출력한다. 
select ename as '사원이름', job as '직무' from emp;

-- 2) 30번 부서에 근무하는 모든 사원의 이름과 급여를 출력한다. 
select ename, sal, deptno
from emp 
where deptno = 30;

-- 3) 사원번호와 이름, 현재 급여, 증가한 급여분('증가액'),10% 인상된 급여('인상된 급여＇)를사원번호순으로 출력하세요. 
select  empno, 
		ename, 
        sal, 
        (sal / 10 + sal) as '증가액', 
        (sal /10) as '인상된 급여' 
from emp
order by empno;

-- 4) 'S'로 시작하는 모든 사원과 부서번호를 출력하세요
select UPPER(ename) as ename, deptno 
from emp 
where ename LIKE 'S%';

-- 5) 모든 사원의 최대 및 최소급여, 합계 및 평균 급여를 출력하세요.열이름은 각각MAX,MIN,SUM,AVG로 한다. 단 소수점 이하는 반올림하여 정수로 출력하시오. 
select max(sal) as max, min(sal) as min, sum(sal) as sum, avg(sal) as avg from emp;

-- 6) 업무 이름과 업무별로 동일한 업무를 하는 사원의 수를 출력하세요.열이름은'업무','업무별 사원수’ 출력하세요
select job as '업무', count(job) as '업무별 사원수 일취월장 하는 정 상 수' from dept d
join emp e on e.deptno = d.deptno
group by job;

-- 7) 사원의 최대 급여와 최소 급여의 차액을 출력하세요
select (max(sal) - min(sal)) as '차액' from emp;

	-- option 2
    select max(sal) - (select min(sal) from emp) as '차액' from emp;
    
-- 8) 30번 부서의 구성원 수와 사원들의 급여의 합계와 평균을 출력하세요
select count(deptno) as '구성원 수', sum(sal) as 'sum', avg(sal) as 'avg' from emp group by deptno;

-- 9) 평균 급여가 가장 높은 부서의 번호를 출력하세요
select deptno from emp where sal = (select max(sal) from emp);

	-- option 2
	select  deptno, ranks
	from (
		select  deptno,
				rank() over (order by avg(sal) desc) as ranks
		from emp 
		group by deptno
	) ranked_result
	where ranks = 1;




-- 10) 세일즈맨(SALESMAN)을 제외하고 업무별 사원의 급여가3,000이상인 각 업무에 대해, 업무명 과 업무별 평균 급여를 출력하시오. 단 평균 급여는 내림차순으로 출력한다. 
select job, avg(e.sal) as avg
from dept d
join emp e on d.deptno = e.deptno
where job <> 'SALESMAN' and sal >= 3000
group by job
order by avg desc;

-- 11) 전체 사원 가운데 직속상관이 있는 사원의 수를 출력하시오
select non_m.dname, (non_m.jobs - m.jobs) as '사수없사원수'
from (
	select d.dname, count(e.job) as jobs 
    from emp e 
    join dept d on d.deptno = e.deptno  
    where job <> 'MANAGER' 
    group by d.dname
) as non_m
Left join (
	select d.dname, count(job) as jobs 
    from emp e 
    join dept d on d.deptno = e.deptno  
    where job = 'MANAGER' 
    group by d.dname
) as m on non_m.dname = m.dname;
-- select dname, count(job) from emp e join dept d on d.deptno = e.deptno  where job <> 'MANAGER' group by dname;
-- select dname, count(job) from emp e join dept d on d.deptno = e.deptno  where job = 'MANAGER' group by dname;

-- 12) Emp테이블에서 이름, 급여, 커미션(comm),총액(sal+comm)을 구하여 총액이 많은 순서대로출력하시오. 단, 커미션(comm)이 없는 사람은 제외한다. 
select ename, sal, comm, (sal + comm) as '총액'
from emp
where comm IS NOT NULL
order by  '총액';

-- 13) 부서별로 같은 업무를 하는 사람의 인원 수를 구하여 부서번호, 업무이름, 인원수를 출력하시오
select deptno, job, count(job) 
from emp 
group by deptno, job
order by deptno;

-- 14) 사원이 한 명도 없는 부서의 이름을 출력하시오
-- 15) 같은 업무를 하는 사람의 수가 4명 이상인 업무와 인원수를 출력하시오
-- 16) 사원번호가 7400이상 7600이하인 사원의 이름을 출력하시오
-- 17) 사원의 이름과 사원의 부서를 출력하시오
-- 18) 사원의 이름과 팀장(mgr)의 이름을 출력하시오
-- 19) 사원 SCOTT보다 급여를 많이 받는 사람의 이름을 출력하시오
-- 20) 사원 SCOTT이 일하는 부서번호 혹은 DALLAS에 있는 부서번호를 출력하시오