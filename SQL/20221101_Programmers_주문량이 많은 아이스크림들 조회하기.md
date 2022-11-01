# LEVEL4
1. 상반기 매출 테이블 FIRST_HALF 와 7월 매출테이블 JULY를 FLAVOR 로 조인
2. PK, FK 인 SHIPMENT_ID 로 JOIN 하지 않는 이유는 7월에는 같은 FLAVOR이 다른 SHIPMENT_ID로 생산되기 때문
3. 판매량 상위 3개만 출력하기 위해 판매량으로 내림차순 정렬 후 LIMIT 3 만 출력


```mysql
SELECT FH.flavor
  FROM FIRST_HALF FH
       INNER JOIN JULY J ON J.FLAVOR = FH.FLAVOR
 GROUP BY FLAVOR
 ORDER BY SUM(fh.TOTAL_ORDER)+SUM(j.TOTAL_ORDER) DESC
 LIMIT 3
```
