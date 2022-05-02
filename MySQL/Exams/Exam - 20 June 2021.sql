CREATE DATABASE sct;
USE sct;

CREATE TABLE addresses(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100) NOT NULL);

CREATE TABLE categories(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(10) NOT NULL);

CREATE TABLE clients(
id INT PRIMARY KEY AUTO_INCREMENT,
full_name VARCHAR(50) NOT NULL,
phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE drivers(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
age INT NOT NULL,
rating FLOAT DEFAULT 5.5
);

CREATE TABLE cars(
id INT PRIMARY KEY AUTO_INCREMENT,
make VARCHAR(20) NOT NULL,
model VARCHAR(20),
year INT NOT NULL DEFAULT 0,
mileage INT DEFAULT 0,
`condition` CHAR(1) NOT NULL,
category_id INT NOT NULL,
CONSTRAINT fk_cars_categories
FOREIGN KEY (category_id)
REFERENCES categories(id)
);

CREATE TABLE courses(
id INT PRIMARY KEY AUTO_INCREMENT,
from_address_id INT NOT NULL,
start DATETIME NOT NULL,
bill DECIMAL(10,2) DEFAULT 10,
car_id INT NOT NULL,
client_id INT NOT NULL,
CONSTRAINT fk_courses_addresses
FOREIGN KEY (from_address_id)
REFERENCES addresses(id),
CONSTRAINT fk_courses_cars
FOREIGN KEY (car_id)
REFERENCES cars(id),
CONSTRAINT fk_courses_clients
FOREIGN KEY (client_id)
REFERENCES clients(id)
);

CREATE TABLE cars_drivers(
car_id INT NOT NULL,
driver_id INT NOT NULL,
PRIMARY KEY (car_id, driver_id),
CONSTRAINT fk_carsDrivers_cars
FOREIGN KEY (car_id)
REFERENCES cars(id),
CONSTRAINT fk_carsDrivers_drivers
FOREIGN KEY (driver_id)
REFERENCES drivers(id));


INSERT INTO clients (full_name, phone_number)
SELECT CONCAT(first_name, ' ', last_name),
CONCAT('(088) 9999', id * 2)
FROM drivers
WHERE id BETWEEN 10 AND 20;

UPDATE cars
SET `condition` = 'C'
WHERE (mileage >= 800000 OR mileage IS NULL) AND year < 2010 AND model != 'Mercedes-Benz';

DELETE clients
FROM clients 
LEFT JOIN courses
ON clients.id = courses.client_id
WHERE char_length(clients.full_name) > 3 AND courses.client_id IS NULL;

DELETE FROM clients
WHERE id NOT IN(SELECT client_id FROM courses) AND char_length(clients.full_name) > 3;


SELECT make, model, `condition` FROM cars
ORDER BY id;

SELECT d.first_name, d.last_name, c.make, c.model, c.mileage FROM drivers AS d
JOIN cars_drivers AS cd
ON d.id = cd.driver_id
JOIN cars AS c
ON c.id = cd.car_id
WHERE c.mileage IS NOT NULL
ORDER BY c.mileage DESC, d.first_name;

SELECT c.id, c.make, c.mileage, COUNT(co.car_id) AS count_of_courses, ROUND(AVG(bill),2) FROM cars AS c
LEFT JOIN courses AS co
ON c.id = co.car_id
GROUP BY c.id
HAVING  count_of_courses != 2
ORDER BY count_of_courses DESC, c.id;

SELECT cl.full_name, COUNT(co.client_id) AS count_of_cars, SUM(bill) FROM clients AS cl
JOIN courses AS co
ON cl.id = co.client_id
GROUP BY co.client_id
HAVING count_of_cars > 1 AND SUBSTRING(cl.full_name,2,1) = 'a'
ORDER BY cl.full_name;

SELECT a.name, (CASE
                WHEN HOUR(co.start) BETWEEN 6 AND 20 THEN 'Day'
                ELSE 'Night'
              END)  AS dayTime, bill, cl.full_name, c.make, c.model, ca.name FROM courses AS co
JOIN addresses AS a
ON co.from_address_id = a.id
JOIN cars AS c
ON co.car_id = c.id
JOIN clients AS cl
ON co.client_id = cl.id
JOIN categories AS ca
ON c.category_id = ca.id
ORDER BY co.id;


DELIMITER $$
CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(co.client_id) FROM clients AS cl
JOIN courses AS co
ON cl.id = co.client_id
WHERE cl.phone_number = phone_num);
END$$
DELIMITER ;
SELECT udf_courses_by_client ('(803) 6386812') as `count`;
SELECT udf_courses_by_client ('(831) 1391236') as `count`;
SELECT udf_courses_by_client ('(704) 2502909') as `count`;

DELIMITER $$
CREATE PROCEDURE udp_courses_by_address(address_name VARCHAR(100))
BEGIN
SELECT ad.name, cl.full_name,(CASE
                WHEN co.bill <= 20  THEN 'Low'
                WHEN co.bill > 20 AND co.bill <= 30  THEN 'Medium'
                ELSE 'High'
              END)  AS level_of_bill ,c.make, c.condition, ca.name FROM addresses AS ad
JOIN courses AS co
ON ad.id = co.from_address_id
JOIN clients AS cl
ON co.client_id = cl.id
JOIN cars AS c
ON co.car_id = c.id
JOIN categories AS ca
ON c.category_id = ca.id
WHERE ad.name = address_name
ORDER BY c.make, cl.full_name;
END$$