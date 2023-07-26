-- 7) В подключенном MySQL репозитории создать базу данных “Друзья человека”

DROP DATABASE IF exists Human_friends;
CREATE DATABASE Human_friends;
USE Human_friends;

CREATE TABLE Animals (
	Id INT AUTO_INCREMENT PRIMARY KEY, 
	Animal_type VARCHAR(20)
);

INSERT INTO Animals (Animal_type) VALUES 
('Working_animals'),
('Pet'); 

CREATE TABLE Working_animals (
 Id INT AUTO_INCREMENT PRIMARY KEY,
 WA_name VARCHAR (20),
 Group_id INT,
 FOREIGN KEY (Group_id) REFERENCES Animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Working_animals (WA_name, Group_id) VALUES 
('Horse', 1),
('Donkey', 1), 
('Camel', 1); 

CREATE TABLE Pets (
 Id INT AUTO_INCREMENT PRIMARY KEY,
 P_name VARCHAR (20),
 Group_id INT,
 FOREIGN KEY (Group_id) REFERENCES Animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Pets (P_name, Group_id) VALUES 
('Cat', 2),
('Dog', 2), 
('Hamster', 2);

-- 9) Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения 

CREATE TABLE Cats ( 
 Id INT AUTO_INCREMENT PRIMARY KEY, 
 Name VARCHAR(20), 
 Birthday DATE,
 Commands VARCHAR(50),
 Group_id int,
 Foreign KEY (Group_id) REFERENCES Pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Cats (Name, Birthday, Commands, Group_id) VALUES 
('Барсик', '2021-03-03', 'спать', 1),
('Пушок', '2022-04-02', 'есть', 1), 
('Лопушок', '2020-05-05', 'ловить мышь', 1); 

CREATE TABLE Dogs ( 
 Id INT AUTO_INCREMENT PRIMARY KEY, 
 Name VARCHAR(20), 
 Birthday DATE,
 Commands VARCHAR(50),
 Group_id int,
 Foreign KEY (Group_id) REFERENCES Pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Dogs (Name, Birthday, Commands, Group_id) VALUES 
('Полкан', '2018-02-08', 'рядом, служить, голос', 2),
('Рекс', '2019-04-12', 'рядом, лежать, служить, сидеть', 2), 
('Мухтар', '2016-01-10', 'вперед, искать, фас', 2);

CREATE TABLE Hamsters ( 
 Id INT AUTO_INCREMENT PRIMARY KEY, 
 Name VARCHAR(20), 
 Birthday DATE,
 Commands VARCHAR(50),
 Group_id int,
 Foreign KEY (Group_id) REFERENCES Pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Hamsters (Name, Birthday, Commands, Group_id) VALUES 
('Толстый', '2023-01-01', 'есть, спать', 3),
('Шустрик', '2022-02-02', 'бежать', 3), 
('Хома', '2023-03-03', 'спать', 3), 
('Фима', '2021-07-17', 'есть', 3);

CREATE TABLE Horses ( 
 Id INT AUTO_INCREMENT PRIMARY KEY, 
 Name VARCHAR(20), 
 Birthday DATE,
 Commands VARCHAR(50),
 Group_id int,
 Foreign KEY (Group_id) REFERENCES Working_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Horses (Name, Birthday, Commands, Group_id) VALUES 
('Молния', '2010-09-12', 'вперед, хоп', 1),
('Чухля', '2016-11-03', 'вперед, барьер', 1), 
('Тарантас', '2014-01-12', 'пррр', 1);

CREATE TABLE Donkeys ( 
 Id INT AUTO_INCREMENT PRIMARY KEY, 
 Name VARCHAR(20), 
 Birthday DATE,
 Commands VARCHAR(50),
Group_id int,
 Foreign KEY (Group_id) REFERENCES Working_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Donkeys (Name, Birthday, Commands, Group_id) VALUES 
('Василёк', '2017-04-10', 'иди, стой, ', 2),
('Розочка', '2019-02-11', 'иди', 2), 
('Фиалка', '2022-04-11', 'стой', 2), 
('Сорняк', '2021-10-10', 'пей', 2);

CREATE TABLE Camels ( 
 Id INT AUTO_INCREMENT PRIMARY KEY, 
 Name VARCHAR(20), 
 Birthday DATE,
 Commands VARCHAR(50),
 Group_id int,
 Foreign KEY (Group_id) REFERENCES Working_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Camels (Name, Birthday, Commands, Group_id) VALUES 
('Желтый', '2015-06-02', 'лечь', 3),
('Серый', '2013-09-02', 'встать, лечь', 3), 
('Эльбрус', '2010-12-12', 'вперед, стой, лечь', 3);

-- 10) Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. 
-- Объединить таблицы лошади, и ослы в одну таблицу.


DELETE FROM Camels;
CREATE TABLE HorseAndDonkey AS
   SELECT * from Horses
   UNION
   SELECT * from Donkeys;
   
   -- 11) Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, 
-- но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице

DROP TABLE IF exists YoungAnimals;
DROP TABLE IF exists All_animals;

CREATE TEMPORARY TABLE All_animals AS 
SELECT *, 'Horses' as Type_of_animal FROM Horses
UNION SELECT *, 'Donkeys' AS Type_of_animal FROM Donkeys
UNION SELECT *, 'Dogs' AS Type_of_animal FROM Dogs
UNION SELECT *, 'Cats' AS Type_of_animal FROM Cats
UNION SELECT *, 'Hamsters' AS Type_of_animal FROM Hamsters;

CREATE TABLE Young_animal AS
SELECT Name, Birthday, Commands, Type_of_animal, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_in_month
FROM All_animals WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);
 
-- SELECT * FROM Young_animal;

-- 12) Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую 
-- принадлежность к старым таблицам.

DROP TABLE IF exists All_animals;
CREATE TABLE All_animals (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
select  Name, 
        Birthday,
        Commands,
        'cats' as oldTable
from cats union 
select  Name, 
        Birthday,
        Commands,
        'dogs' as oldTable
from dogs union
select  Name, 
        Birthday,
        Commands, 
        'hamsters' as oldTable
from hamsters union 
select  Name, 
        Birthday,
        Commands, 
        'horses & donkey' as oldTable
from HorseAndDonkey;

SELECT * FROM All_animals;

