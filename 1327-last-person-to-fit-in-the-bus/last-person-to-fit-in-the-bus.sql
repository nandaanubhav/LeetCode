# Write your MySQL query statement below
select person_name from queue where turn in 
(select max(q1.turn) from queue q1 where (select sum(weight) from queue q2 where q2.turn <= q1.turn) <= 1000 or (select sum(weight) from queue q2 where q2.turn < q1.turn) is null order by turn);

-- select * from queue q1 where (select sum(weight) from queue q2 where q2.turn <= q1.turn) <= 1000 order by turn;