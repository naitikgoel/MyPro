create database Database_Naitik;
use Database_Naitik;
create table Employee(Name varchar(23),Address varchar(25),Age int);


DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  address VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  age INT NOT NULL,
  experience INT NOT NULL,
  PRIMARY KEY (id));


INSERT INTO Employee(name,address,email,age,experience)VALUES('Naitik ','Banglore','naitik@gmail','28','5');
INSERT INTO Employee(name,address,email,age,experience)VALUES('Mukesh ','Kol','Mukesh@gmail','24','5');
INSERT INTO Employee(name,address,email,age,experience)VALUES('Suresh ','Banglore','Suresh@gmail','25','5');
INSERT INTO Employee(name,address,email,age,experience)VALUES('Prabhu ','Pune','Prabhu@gmail','29','6');
INSERT INTO Employee(name,address,email,age,experience)VALUES('Abhi ','Banglore','Abhi@gmail','27','7');
INSERT INTO Employee(name,address,email,age,experience)VALUES('Nitin ','Jammu','Nitin@gmail','22','4');
INSERT INTO Employee(name,address,email,age,experience)VALUES('Rajesh ','Banglore','Rajesh@gmail','30','8');
INSERT INTO Employee(name,address,email,age,experience)VALUES('Anu ','Delhi','Anu@gmail','34','5');

INSERT INTO Employee(name,address,email,age,experience)VALUES('Naitik111 ','Banglore','naitik@gmail','30','5');
INSERT INTO Employee(name,address,email,age,experience)VALUES('Mukesh111 ','Kol','Mukesh@gmail','30','5');
INSERT INTO Employee(name,address,email,age,experience)VALUES('Suresh111','Banglore','Suresh@gmail','30','5');

UPDATE `database_naitik`.`Employee` SET `name`='Rajesh ' WHERE `id`='18';
UPDATE `database_naitik`.`Employee` SET `name`='Rajesh ' WHERE `id`='19';
UPDATE `database_naitik`.`Employee` SET `name`='Rajesh' WHERE `id`='20';

select * from Employee

