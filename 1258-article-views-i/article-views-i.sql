/* Write your PL/SQL query statement below */
SELECT distinct v.author_id as id from views v
where v.author_id = v.viewer_id
order by 1;