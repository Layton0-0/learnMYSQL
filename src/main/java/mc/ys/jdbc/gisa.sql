select * from gisatbl;
-- 1 limit 4(5번째 요소부터), 1(1개의 요소만큼 보여주시오.)
select stdNo, (kor + eng) 
from gisatbl 
where locCode = 'B' order by (kor + eng) desc, stdNo asc limit 4,1;

-- 2
select max(kor + eng) from gisatbl where locCode = 'B';

-- 3
select sum(total + 
	case
		when mgrCode = 'A' then 5
		when mgrCode = 'B' then 15
		when mgrCode = 'C' then 20
	end
	) as 'Sum'
from gisatbl where eng + math >= 120;

-- 4
select sum((kor+
	case 
       when loc_code = 'A' then 5
       when loc_code = 'B' then 10
       when loc_code = 'C' then 15
	end) >= 50 ) V
from gisatbl where (acc_code = 'A' or acc_code='B');

select count(*)
from (
select (kor+
	case 
       when loc_code = 'A' then 5
       when loc_code = 'B' then 10
       when loc_code = 'C' then 15
	end) B 
from gisatbl where acc_code = 'A' or acc_code='B') V
where V.B >= 50;
