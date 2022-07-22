# Write your MySQL query statement below
SELECT employee_id , IF(EMPLOYEE_ID % 2 = 1 AND NAME NOT LIKE 'M%', SALARY ,0) AS bonus FROM EMPLOYEES E order by employee_id