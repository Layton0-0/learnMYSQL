use shopdb;
create table gisaTBL(                                                                                                    
	std_no int(10) primary key,
    email varchar(10) not null,
    kor integer not null,
    eng integer not null,
    math integer not null,
    sci integer not null,
    hist integer not null,
    total integer not null,
    mgr_code char(1) not null,
    acc_code char(1) not null,
    loc_code char(1) not null
);

select * from student;

-- 1 // 180 990490
select std_no, (kor+eng) 
from gisatbl
where loc_code = 'B' order by (kor+eng) desc , std_no asc limit 5;
-- 2 // 192
select max(kor+eng) from gisatbl where loc_code = 'B';
-- 3 99754
select sum(total+
	case 
       when mgr_code = 'A' then 5
       when mgr_code = 'B' then 15
       when mgr_code = 'C' then 20
	end
    )  as '자료의 합'
from gisatbl where eng+math >= 120;
-- 4 397
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