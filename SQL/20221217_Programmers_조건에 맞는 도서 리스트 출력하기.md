# SELECT
1. 주어진 조건인 '2021'년도와 '인문'카테고리를 WHERE 절을 통해 추가
2. 출판일 기준으로 오름차순 정렬되도록 ORDER BY 사용
3. 예시의 형식과 동일하게 날짜 출력되기 위해 DATE_FORMAT() 사용


```mysql
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE,'%Y-%m-%d') AS PUBLISHED_DATE
  FROM BOOK
 WHERE YEAR(PUBLISHED_DATE) = 2021
   AND CATEGORY = '인문'
 ORDER BY PUBLISHED_DATE
```
