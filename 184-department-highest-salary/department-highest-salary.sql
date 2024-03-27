# Write your MySQL query statement below
SELECT
    Department.name AS 'Department',
    Employee.name AS 'Employee',
    Salary
FROM
    Employee
        JOIN
    Department ON Employee.DepartmentId = Department.Id
WHERE
    (Salary, Employee.DepartmentId) IN
    (Select max(salary) , e.departmentId from Employee e group by e.departmentId);