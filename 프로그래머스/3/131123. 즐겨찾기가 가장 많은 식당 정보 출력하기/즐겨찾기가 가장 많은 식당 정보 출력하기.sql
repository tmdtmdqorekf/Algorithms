-- '음식종류별' 즐겨찾기 수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기 수

SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES AS FAVORITES
FROM REST_INFO
WHERE (FOOD_TYPE, FAVORITES) IN (SELECT FOOD_TYPE, MAX(FAVORITES)
                                FROM REST_INFO
                                GROUP BY 1
                                )
ORDER BY 1 DESC