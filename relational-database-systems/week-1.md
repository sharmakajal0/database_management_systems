# Week - 1

# Components of Information Systems

## Information System

Set of elements such as people, hardware, software, procedures and data that work together to automate business or daily life processes.

### Two principal types of Information Systems:
- Online Transaction Processing, OLTP Systems
- Online Anlytical Processing Systems, OLAP Systems

### Transaction
A Set of instructions or operations that are excecuted on the database all completely or none at all.

A Transactional information system is the one that serves automate many operations of insert, delete or update data that are performed 
by many people everyday, all the time. If they are not automated, the process will be very slow.

### ACID properties
OLTP systems contains a lot of transactions.
Each transaction must obey the ACID properties.

A - Atomicity
- Every Insert, update, delete data must be currectly executed. 
- If everything was fine, then all changes are reflected to the database COMMIT. 
- In case of Any failure none of these processes are
reflected to the database, also called roll back.

C - Consistency
- Consistency is a transaction that shall start from a consistent state of the database and in most great and new and valid states of data.

I - Isolation
- A transaction in process or running and not yet committed, must remain isolated from any other transaction data.

D - Durability
- where commited data must be persistent. Those commited data are stored on physical disk thereby even in the event of a failure and the system restarts, the data will be available and consistent.

## OLAP
- The analyticals systems use information generated in the transactional systems to analyze data and make decisions.
- The OLAP systems are used by middle or senior management. The kind of database operations are complex queries of large volume of historical information.
- They can help to automate data and are called transactional systems or they can analyze data and are called analytical systems.

# Database Concepts 

## DataBase
- A database is a set of data organized in such a way that is easy to access, manage and update them.
- The data must remain safe and secure.
- Not susceptible to unauthorized access or modification.

### concurrency
- When multiple users access the database at the same time.

Concurrency Problems - If there are not appropriate controls to synchronize the processes and maintain the ACID properties of transactions that affect the database.

Data in this case may lose integrity and become inconsistent

Integrity - Integrity is when data is correct according to the domain business rules and references.Integrity control is a set of securities and rules that are used to maintain data integrity. In other words, system procedures for validating data.

Data may become incorrect due to: 
- hardware failures
- incomplete updates
- software defects
- invalid data
- human errors

## DBMS

Database Management System(DBMS) is a software package designed to store, manage and maintain database is secure, safe and consistent.

### NoSQL Database

A NoSQL database is a non-relational database that is highly scale level, fault tolerant and specifically designed to have semi-structured and unstructured data.

### NoSQL Technology
- <b>Consistency</b> - A read from any node results in the same data across multiple nodes.
- <b>Availability</b> - The extent to which the data is presented to the user when it is required.
- <b>Partition Tolerance (CAP Theorem)</b> - The db system can tolerate communication outages that split a cluster or set of computers where data is contained into multiple silos and can eventually still service some read/write requests.
- Another characteristic of NoSQL database is <b>Base</b>, is a database design principle based on the CAP and stands for Basically Available Soft-state and Eventual Consistency. That means that data will be available but not consistent all the time. Hence, result may change if same data is requested again.
