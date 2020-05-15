# Week - 4

## SQL
The structured query language,(SQL) is a declarative, standard and set oriented programming language used to define, manipulate and control objects of a relational database.

<strong>SQL is composed of four programming languages:</strong>
- <b>DDL</b>(Data Definition language) - which allows us to create the structures.
- <b>DQL</b>(Data Query Language) - allows us to access the data through selection criteria, grouping, ordering, etc.
- <b>DML</b>(Data Manipulation Language) - allows us to have access to structures to delete, modify, and insert.
- <b>DCL</b>(Language of Control of access of Data) - allows us to give access to permissions to authorized users.

<b>CREATE DATABASE</b> - creates a database with given name. To use this, create privilege for CREATE.
<b>CREATE SCHEMA</b> - A synonym for create database. An error occurs if the database exists and you didn't specified the IF NOT EXISTS.

e.g., CREATE DATABASE mydatabase;

<b>DATABASE commands:</b>
CREATE DATABASE  bName - Create a new database
CREATE DATABASE IF NOT EXISTS dbName - Create only if does not exists.
SHOW DATABASES - Show all databases in this server.
USE dbName - Set the default(current) database.
SELECT Database - Select the default database.
SHOW CREATE DATABASE dbName - Show the CREATE DATABASE statement.
DROP DATABASE dbName - Delete the database(irrecoverable)
DROP DATABASE IF EXISTS dbName - Delete if it exists.
Default - CREATE TABLE myt (id int(11) NOT NULL, s char(60) DEFAULT NULL)
 
Remember the importance of primary key and foreign key to establish the entity identity and one to many and many to many relationship for referential integrity.

<b>CREATE INDEX</b>
CREATE INDEX autid ON newauthor(aut_id);
The above MySQL statement will create an INDEX on 'aut_id' column for 'newauthor' table.

CREATE UNIQUE INDEX newautid ON newauthor(aut_id):
The above MySQL statement will create an UNIQUE INDEX on 'aut_id' column for 'newauthor' table.

There are different types of Indexes:
- Unique
- Secondary
- Full-Text
- Spatially Index

<b>ALTER TABLE</b>
ALTER TABLE students;
ADD COLUMN firstYear: integer;
The schema of Students is altered by adding a new field, every tuple in the current instance is extended with a null value in the new field.
