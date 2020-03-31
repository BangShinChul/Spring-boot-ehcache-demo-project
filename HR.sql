-- Create table sql
USE DATABASE test;

CREATE TABLE `human_resource` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `insert_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_time` datetime DEFAULT NULL,
  `department` varchar(10) NOT NULL,
  `rank` varchar(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `salary` bigint(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
;


-- insert dumy data
INSERT INTO `human_resource` (department, rank, name, salary)
VALUES
('Dev', 'Worker', 'John Joe', 5000)
, ('Dev', 'Worker', 'Sara Kim', 5500)
, ('Dev', 'Manager', 'David', 6000)
, ('Dev', 'DepartmentHead', 'Dev Cat', 8000)
, ('Marketing', 'Worker', 'Sally', 5000)
, ('Marketing', 'Worker', 'Tom', 4500)
, ('Marketing', 'Manager', 'Jimmy', 7000)
, ('Marketing', 'DepartmentHead', 'Michael', 7500)
, ('Sales', 'Worker', 'kain', 3000)
, ('Sales', 'Manager', 'Jerry', 3500)
, ('Sales', 'DepartmentHead', 'Dan', 6000)
, ('Manage', 'Worker', 'Jessy', 6000)
, ('Manage', 'DepartmentHead', 'Boss', 10000)
;