# Write your MySQL query statement belowse

SELECT p.product_id, IFNULL(ROUND(SUM(units*price)/SUM(units),2),0) AS average_price
from Prices  p 
left join UnitsSold u
on p.product_id = u.product_id 
and u.purchase_date between p.start_date and p.end_date
group by p.product_id