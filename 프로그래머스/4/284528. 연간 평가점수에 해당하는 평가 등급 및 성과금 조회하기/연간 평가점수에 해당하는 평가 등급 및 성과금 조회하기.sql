-- (1분기 점수 + 2분기 점수 / 2)가 기준 점수보다 높으면 평가 등급 산정
SELECT C.EMP_NO, B.EMP_NAME, (CASE WHEN (SUM(C.SCORE)/2) >= 96 THEN 'S'
                                   WHEN (SUM(C.SCORE)/2) >= 90 THEN 'A'
                                   WHEN (SUM(C.SCORE)/2) >= 80 THEN 'B'
                                   ELSE 'C' END) AS GRADE,
                             (CASE WHEN (SUM(C.SCORE)/2) >= 96 THEN B.SAL*0.2
                                   WHEN (SUM(C.SCORE)/2) >= 90 THEN B.SAL*0.15
                                   WHEN (SUM(C.SCORE)/2) >= 80 THEN B.SAL*0.1
                                   ELSE 0 END) AS BONUS
FROM HR_DEPARTMENT AS A JOIN HR_EMPLOYEES AS B ON A.DEPT_ID = B.DEPT_ID
                        JOIN HR_GRADE AS C ON B.EMP_NO = C.EMP_NO
GROUP BY C.EMP_NO
ORDER BY B.EMP_NO