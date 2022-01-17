use sqldb;
select * from usertbl;

select * from usertbl where name = '김경호';

select userid, name from usertbl where birthyear >= 1970 and height >= 182;

select userid, name from usertbl where birthyear >= 1970 or height >= 182;

select name, height from usertbl where height >= 180 and height <= 183;

select name, height from usertbl where height between 180 and 183;

select name, addr from usertbl where addr = '경남' or addr = '전남' or addr = '경북';

select name, addr from usertbl where addr in ('경남', '전남', '경북');

select name, height from usertbl where name like '김%';

select name, height from usertbl where name like '_종신';

select name, height from usertbl where height > 177;

select name, height from usertbl where height > (select height from usertbl where name = '김경호');

select name, height from usertbl where height >= all (select height from usertbl where addr = '경남');

select name, height from usertbl where height >= any (select height from usertbl where addr = '경남');

select name, mdate from usertbl order by mdate;

select name, mdate from usertbl order by mdate desc;

select name, height from usertbl order by height desc, name;

select addr from usertbl;

select addr from usertbl order by addr;

select distinct addr from usertbl;

select name, mdate from usertbl order by mdate limit 5;

select name, mdate from usertbl order by mdate limit 0, 5;

-- 강사님 테스트
select * from usertbl;
select * from usertbl where height > (select height from usertbl where name = '임재범');