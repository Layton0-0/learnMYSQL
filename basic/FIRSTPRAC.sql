SELECT *
FROM CITY
WHERE COUNTRYCODE = 'KOR'
ORDER BY POPULATION DESC;

DESC COUNTRY;

SELECT *
FROM COUNTRY
ORDER BY SURFACEAREA DESC;

SELECT distinct COUNTRYCODE
FROM CITY
order by POPULATION DESC
limit 10;

select countrycode, max(population) as average 
from city
group by countrycode;

desc city;

select countrycode, avg(population) as average
from city
group by countrycode;