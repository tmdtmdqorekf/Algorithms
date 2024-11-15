-- 2022년 8월~10월까지 총 대여 횟수 5회 이상인 자동차들
-- 2022년 8월~10월까지 '월별' '자동차 ID별' 총 대여 횟수

SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
      AND CAR_ID IN (SELECT CAR_ID
                     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                     WHERE DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
                     GROUP BY CAR_ID
                     HAVING COUNT(CAR_ID) >= 5)
GROUP BY 1, 2
ORDER BY 1, CAR_ID DESC