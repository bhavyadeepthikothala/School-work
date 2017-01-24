CREATE TABLE Sides
  (
     sidename CHAR(20) PRIMARY KEY,
     calories NUMBER(4),
     prices   NUMBER(5, 2)
  )
/
CREATE INDEX side$name 
  ON Sides(sidename)
/
CREATE TABLE Sandwiches
  (
     sname    CHAR(20) PRIMARY KEY,
     calories NUMBER(4),
     price    NUMBER(5, 2)
  )
/
CREATE INDEX sand$price
  ON Sandwiches(price)
/
CREATE TABLE Ingredients
  (
     ingredientid   NUMBER(5) PRIMARY KEY,
     ingredientname CHAR(20),
     instock        NUMBER(5)
  )
/
CREATE INDEX ingredient$id 
  ON Ingredients(ingredientid)
/
CREATE TABLE InSandwich
  (
     ingredientid NUMBER(5) NOT NULL,
     sname        CHAR(20) NOT NULL,
     PRIMARY KEY(ingredientid, sname),
     FOREIGN KEY(sname) REFERENCES Sandwiches
  )
/
CREATE INDEX Iingredient$id 
  ON InSandwich(ingredientid)
/
CREATE TABLE Combo
  (
     comboid   NUMBER(3) PRIMARY KEY,
     comboname CHAR(15) NOT NULL,
     sname     CHAR(20),
     sidename  CHAR(20),
     price     NUMBER(5, 2),
     FOREIGN KEY(sname) REFERENCES Sandwiches,
     FOREIGN KEY(sidename) REFERENCES Sides
  )
/
CREATE INDEX combo$name
  ON Combo(comboname)
/
INSERT INTO Sides
SELECT *
FROM   labdataf16.Sides
/
INSERT INTO Sandwiches
SELECT *
FROM   labdataf16.Sandwiches
/
INSERT INTO Ingredients
SELECT *
FROM   labdataf16.Ingredients
/
INSERT INTO InSandwich
SELECT *
FROM   labdataf16.InSandwich
/
INSERT INTO Combo
SELECT *
FROM   labdataf16.Combo
/
