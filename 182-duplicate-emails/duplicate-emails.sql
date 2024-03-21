# Write your MySQL query statement below
select email from person p
group by p.email
having count(1) > 1;