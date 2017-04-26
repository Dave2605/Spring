CREATE DATABASE spring_lab;
USE spring_lab;

CREATE TABLE teacher (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(20),
  second_name VARCHAR(20),
  age INTEGER,
  email VARCHAR(40)
);

CREATE TABLE subject (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(20),
  subject_group VARCHAR(40),
  pass_score INT,
  teacher INT,
  FOREIGN KEY (teacher) REFERENCES teacher(id)
);

INSERT INTO teacher VALUES (1, 'Michael', 'Green', 35, 'Michael_Green@gmail.com');
INSERT INTO teacher VALUES (2, 'Elizabeth', 'Brown', 28, 'Elizabeth_Brown@gmail.com');

INSERT INTO subject VALUES (1, 'Math', 'Exact sciences', 75, 2);
INSERT INTO subject VALUES (2, 'English', 'Humanitarian sciences', 65, 1);
INSERT INTO subject VALUES (3, 'Informatics', 'Exact sciences', 70, 2);