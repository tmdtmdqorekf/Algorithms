-- 평균 길이가 33cm 이상인 물고기들 (10cm이하는 10cm로 취급) / 종류별로 분류

SELECT COUNT(*) AS FISH_COUNT, MAX(IFNULL(LENGTH, 10)) AS MAX_LENGTH, FISH_TYPE
FROM FISH_INFO
GROUP BY 3
HAVING AVG(IFNULL(LENGTH, 10)) >= 33
ORDER BY 3