-- 식품분류별로 가격이 제일 비싼 식품
-- 식품분류 -> 과자, 국, 김치, 식용유만 출력

SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (CATEGORY, PRICE) IN (SELECT CATEGORY, MAX(PRICE)
                                  FROM FOOD_PRODUCT
                                 GROUP BY CATEGORY)
GROUP BY CATEGORY
HAVING CATEGORY IN ('과자', '국', '김치', '식용유')
ORDER BY PRICE DESC