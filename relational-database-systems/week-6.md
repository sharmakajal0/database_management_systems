# Week-6
<strong>Transaction</strong> - Transaction is a set of instructions or operations that are executed on the database all completely or none at all.

<strong>Concurrency</strong> - When many users submit transactions at the same time. Every transaction might try to update the same single data value. In order to preserve consistency, running transactions within the relation database system must preserve ACID properties.
ACID properties must be warranted during the execution of the transactions in a relational database.

Atomicity: A transaction might commit after completing all its actions, or it could abort(or be aborted by the DBMS) after executing some actions.
A very important property guaranted by the DBMS for all transactions is that they are atomic. That is, a user can think of a exact as always executing all its actions in one step, or not executing any actions at all.
The DBMS logs all actions so that it can undo the actions of aborted transactions.

Consistency: The consistency of a transaction means that the transaction must start from a original consistent state upon complication of the transaction.
It must obey the business rules and it must leave the database to a final consistent state.

Isolation: The isolation of transactions means that the running transaction must operate independently of other transactions and should never see the intermediate faces or data from another transaction.
Transactions reach the maximum isolation level when they can be serialized.

Durability: The durability of transactions says that if all operations within a transaction are succesfully secured and the transaction is committed, the database manager system must guarantee that the operations carried out in such a transaction are permanent.	
Even if the computer equipment fails immediately after commit, durability is achieved by storing committed data on physical disk.

- If a transaction is aborted or these actions have to be undone.
- In order to undo the actions of aborted transaction, the DBMS keeps login which every grade is recorded. This mechanism is also used to recover from system crash.
- All active transactions at the time of the crash are aborted when the system comes backup.
- Write-ahead logging while is used to undo the actions of a network transaction and to restore the system to a consistent state after a crash.
- The consistent state is to apply changes from committed transactions.

## InnoDB
- The engine InnoDB is a general purpose storage engine that balances high reliability and high performance.
- It is a four-storage engine of MYSQL and it controls how data is managed.
- It's DML operations follow the ACID model with transactions that include commit, rollback and recovery capabilities to protect the user's data.
- The local record level and consistent readings increase the concurrency and performance of multiple task.

1. Start transaction or begin starts a new transaction.
2. Commit compromises the current transaction, making its changes permanent.
3. Rollback reverses the current transaction, canceling your changes.
4. SET autocommit disables or enables the default automatic confirmation mode for the current session.
5. By default, mysql runs with automatic confirmation.
6. The change cannot be reversed.
7. To disable the automatic confirmation mode implicitly for a single series of declarations, use the START TRANSACTION statement.

Example of a sales order transaction:
1. Start a transaction
2. Obtain the last sales order number from the order table and use the next sales order number as the new sales order number.
3. Insert a new sales order in the order table for a specific number.
4. Insert new sales order items in the order details table.
5. Confirm changes.
6. Read the order details to verify it's permanent.

<strong>Program</strong>
-- start transaction
start transaction;
-- Obtain the last sales order number
select @orderNumber := max(orderNumber) from orders;
-- assign a new order number.
set @orderNumber = @orderNumber + 1;
-- Insert a new sales order in the order table for customer number 145.
insert into orders(orderNumber, orderDate, requiredDate, shippedDate, status, customerNumber)
values(@orderNumber, now(), date_add(now(), INTERVAL 5 DAY), date_add(now(), INTERVAL 2 DAY), 'In Process', 145);
-- Insert 2 new sales order items in the order details table.
insert into orderdetails(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber) values(@orderNumber, 'S18_1749', 30, '136', 1), (@orderNumber, 'S18_2248', 50, '55.09', 2);
-- Confirm changes with commit.
commit;
-- Read the order details to verify it's permanent.
select * from orders a inner join orderdetails b on a.ordernumber = b.ordernumber where a.ordernumber = @ordernumber;

Cluster and secondary indexes are stored in B-trees.
A B-tree index can be used for column comparison in expressions that use the =, >, >=, <, <=, or, Between Operators.
The index also can be used for LIKE comparisons if the argument to LIKE is a constant string that does not start with a wildcard character.

<strong>Clustered Vs. NonClustered Index</strong>
- Clustered Index is a special type of index that reorders the way records in the table are physically stored. Therefore, table can have only one clustered index. The leaf nodes of a cluster index contain the data pages.
- An Unclustered Index can also call secondary index in MySQL is a special type of index in which the logical order of index does not match the physical store order of the rows on disk. The leaf node of a non-clustered index does not consist of the data pages. Instead, the leaf nodes contain index rows.

In InnoDB, each record in a secondary index contains the columns of the primary key for the record as well as the columns specified for the secondary index.

<b>Example</b>:
CREATE [UNIQUE/FULLTEXT/SPATIAL] INDEX index_name [USING index_type] ON tbl_name (index_col_name,...)
index_col_name:
col_name[(length)] [ASC | DESC]
ej. CREATE INDEX part_of_name ON customer(name(10));

## Triggers
A Trigger isa stored procedure that starts automatically if specified changes occur to the DBMS.
1. Event (the event that activates the trigger, such as insert, update, or delete operations).
2. Condition (tests whether the triggers should run).
3. Action (the programming code that establishes what happens if the trigger runs).

<b>example</b>
CREATE 
	[DEFINER = {user | CURRENT_USER}]
	TRIGGER trigger_name
	trigger_name trigger_event
	ON tbl_name FOR EACH ROW
[trigger_order] trigger_body

trigger_time: {BEFORE | AFTER}
trigger_event: {INSERT | UPDATE | DELETE}
trigger_order: {FOLLOWS | PRECEDES} other_trigger_name

The definer class determines the security context to be used when checking access privilege a trigger activation time.
Trigger_time is a trigger action times. It can be before or after to indicate the a trigger activates before or after each row to be modified.
Trigger_event indicates the kind of operation that activates a trigger, these trigger event values are permitted to insert or load data, update, delete, cascade foreign keys actions do not activate triggers.
Trigger_body is a statement to execute when the trigger activates.
To execute multiple statements, use the begin and components statement construct. These also enables you to use the same statements that are permitted within store routines.


Another programming object is stored procedure which is a program that is stored on the database.

Some benefits of this stored procedures are:
- that it runs faster than the same sentence as within a SQL script,
- reduce network traffic,
- it is used to define business rules and repetitive tasks,
- provide security towards data.

## Creating a stored procedure.

DELIMITER $$
	CREATE PROCEDURE ObtenTipoTarjeta(IN p_customerNumber INT(11), OUT p_customerLevel varchar(10))
	BEGIN
		DECLARE creditlim DOUBLE;
		SELECT creditlimit INTO creditlim
		FROM customers
		WHERE customerNumber = p_customerNumber;
		SELECT TipoTarjeta(creditlim)
		INTO p_customerlevel;
	END
