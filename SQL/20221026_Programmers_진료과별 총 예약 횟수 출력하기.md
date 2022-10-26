# LEVEL 2
1. 5월에 예약된 진료를 기준으로 진료과코드로 group by 하기
2. group by 된 진료과코드별 5월 예약건수를 count()를 이용해 구하기
3. 출력시 예약건수 오름차순, 예약건수 동일할 경우 진료과 코드 오름차순 하기


```mysql
SELECT MCDP_CD AS 진료과코드, COUNT(*) AS 5월예약건수
  FROM APPOINTMENT
 WHERE MONTH(APNT_YMD) = 5
 GROUP BY MCDP_CD
 ORDER BY 5월예약건수, 진료과코드
 ```
