# LEVER 4
1. 예약테이블을 기준으로 환자 테이블과 의사 테이블을 INNER JOIN 으로 연결
2. '2022-04-13'일에 예약을 '취소 하지 않은' '흉부외과(CS)'의 예약을 찾기위해 WHERE 절에 조건을 추가
3. 예약일시 오름차순으로 정렬 후 예약일시가 동일할 경우에는 환자 번호 오름차순으로 정렬되도록 ORDER BY 조건 추가


```mysql
SELECT AP.APNT_NO, PT.PT_NAME, PT.PT_NO, DC.MCDP_CD, DC.DR_NAME, AP.APNT_YMD
  FROM APPOINTMENT AP
       INNER JOIN PATIENT PT ON PT.PT_NO = AP.PT_NO
       INNER JOIN DOCTOR  DC ON DC.DR_ID = AP.MDDR_ID
WHERE DATE_FORMAT(AP.APNT_YMD,'%Y-%m-%d') = '2022-04-13'
  AND AP.APNT_CNCL_YN = 'N'
  AND DC.MCDP_CD = 'CS'
ORDER BY AP.APNT_YMD, PT.PT_NO
```
