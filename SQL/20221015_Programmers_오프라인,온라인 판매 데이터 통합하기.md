# LEVEL 4
1. 온라인 데이터와 오프라인 데이터를 서브쿼리로 가져오기
2. 합쳐진 데이터에서 3월 데이터만 가져오도록 where 조건 준 후 SALES_DATE, PRODUCT_ID, USER_ID 순서로 오름차순 정렬하여 출력


```mysql
SELECT *
FROM
(SELECT DATE_FORMAT(SALES_DATE,'%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
  FROM ONLINE_SALE 
 UNION
SELECT DATE_FORMAT(SALES_DATE,'%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, NULL, SALES_AMOUNT
  FROM OFFLINE_SALE) SALE
 WHERE MONTH(SALES_DATE) = 3
 ORDER BY SALES_DATE, PRODUCT_ID, USER_ID
 ```
