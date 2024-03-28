# Write your MySQL query statement below
-- select distinct l1.num as ConsecutiveNums from Logs l1, Logs l2, Logs l3 
-- where l1.num = l2.num
-- and l2.num = l3.num
-- and l1.id = l2.id - 1
-- and l2.id = l3.id - 1;

# Write your MySQL query statement below
with cte as (
    select num,
    lead(num,1) over() num1,
    lead(num,2) over() num2
    from logs

)
select distinct num ConsecutiveNums from cte where (num=num1) and (num=num2)