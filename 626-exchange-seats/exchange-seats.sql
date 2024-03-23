# Write your MySQL query statement below
select s1.id , 
    case
        when s1.id % 2 != 0 AND s1.id = (select max(id) from seat s3) then s1.student
        when s1.id % 2 != 0 then (select student from seat s2 where s2.id = s1.id + 1)
        when s1.id % 2 = 0 then (select student from seat s2 where s2.id = s1.id - 1)
end as student from seat s1 order by id;