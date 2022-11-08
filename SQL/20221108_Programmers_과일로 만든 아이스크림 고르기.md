# LEVEL 1
1. 두 테이블의 연결 컬럼은 'FLAVOR'
2. 상반기 총 주문량이 3000 이상이고 주성분이 '과일' 인것으로 where 조건 추가
3. 출력시 주문량 기준 내림차순 으로 출력


```mysql
SELECT FH.FLAVOR AS FLAVOR
  FROM FIRST_HALF FH
       INNER JOIN ICECREAM_INFO INFO ON INFO.FLAVOR = FH.FLAVOR
 WHERE TOTAL_ORDER > 3000
   AND INFO.INGREDIENT_TYPE = 'fruit_based'
  ORDER BY FH.TOTAL_ORDER DESC
  ```
