-- 2022년 10월 16일에 대여중인 자동차인 경우 -> '대여중' / 아닌 경우 -> '대여 가능'

-- 2022년 10월 16일에 대여가 가능한 자동차 수

SELECT CAR_ID, (CASE WHEN CAR_ID IN (SELECT CAR_ID
                                    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                    WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE) THEN '대여중'
                ELSE '대여 가능' END) AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY 1
ORDER BY 1 DESC