# LEVEL 4
1. 카테고리로 그룹한 뒤 원하는 조건의 카테고리만 선별
2. 테이블의 카테고리별 max(price) 구하여 조건에 추가
3. 최종 데이터를 max_price 내림차순으로 출력


```mysql
SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
  FROM FOOD_PRODUCT
 WHERE CATEGORY IN('과자','국','김치','식용유')
   AND PRICE IN(SELECT MAX(PRICE) FROM FOOD_PRODUCT GROUP BY CATEGORY)
 GROUP BY CATEGORY
 ORDER BY MAX_PRICE DESC
 ```
