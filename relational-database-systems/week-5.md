# Week - 5


## Adding and deleting tuples
- Can insert a single tuple using INSERT
- Can DELETE all tuples satisfying some condition.
  
## Truncate table
- Can DELETE all tuples satisfying some condition.

This removes all the rows from the table
- This operation is faster than the delete statement without the where clouse.
- Syntax:
  - truncate table table_name
    - example
      - Truncate table Sailors;
- The TRUNCATE TABLE statement does not trigger ON DELETE triggers.

## Updating Data
Syntax
UPDATE table_reference SET assignment_list [WHERE where_condition][order_by .....] [LIMIT row_count] value: {expr | DEFAULT} assignment: col_name = value

## SELECT SENTENCE
SELECT->
->FROM -> table specifications
->WHERE -> search conditions
->GROUP BY -> grouping column
->HAVING -> grouping column
->ORDER BY -> sort of specification
-> statement

## Basic SQL Query
<b>Relation-list</b>: A list of relation names.

<b>Target-list</b>: A list of attributes of relations in relation-list.

<b>Qualifications</b>: Comparisons combined using AND, OR and NOT.

<b>DISTINCT</b>: Optional keyword indicating that the answer should not contain duplicates.

<b>DEFAULT</b>: Dupticates are not eliminated.

## Nested Queries
- A subquery in SQL query within a query.
- Subqueries are the nested queries that provide data to the enclosing query.
- Subqueries can return individual values or a list of records.
- Must be enclosed within parenthesis.
- The inner subquery is completely independent of the outer query.

example: SELECT S.name FROM Sailors S WHERE EXISTS (SELECT * FROM Reserves R WHERE R.bid = 103 AND R.sid = S.sid)

A very powerful feature of SQL:
a WHERE clause can itself contain an SQL query!

<b>Correlated Nested Queries</b>
The inner query depends on the row that is currently being examined in the outer query.

<b>The conceptual strategy of a join is:</b>
1. Compute the cross-product of relation-list.
2. Discard resulting tuples if they fail qualifications by the common column(pk, fk).
3. Delete attributes that are not in the Target-list.
4. If distinct is specified, eliminate duplicate rows. It was not specified.

## LIKE
Like is used for string matching . '_' stands for any one character and '%' stands for 0 or more arbitrary characters.

## UNION
Can be used to compute the union of any two union-compatible sets of tuples.

## Aggregate Operators
COUNT([DISTINCT] A): The number of unique values in A column.
SUM([DISTINCT] A): The sum of all unique values in the A column.
AVG([DISTINCT] A): The average of all values in the A column.
MAX (A): The maximum values in the A column.
MIN (A): The minimum values in the A column.

- Count the number of sailors.
SELECT COUNT(*) FROM Sailors;

- Calculate the average age of sailors who have rating 10.
select avg(S.age) from Sailors S where S.rating = 10;

- Find the name of sailors with max rating.
select S.name from Sailors S where S.rating = (select max(S2.rating) from Sailors S2);

A group is a set of tuples that have the same value for all attributes in grouping-list.

- Find the average age of sailors for each rating level.
  SELECT S.rating, AVG(S.age) AS avg_name FROM Sailors S GROUP BY S.rating

- Find the average age of sailors for each rating level that has atleast two sailors.
  SELECT S.rating, AVG(S.age) AS avg_age FROM Sailors S GROUP BY S.rating HAVING COUNT(*) > 1

## Queries with GROUP BY and HAVING
The target-list contains 
(i) attribute name
(ii) terms with aggregate operations(e.g., MIN (S.age))

Find the age of the youngest sailor for each rating level.
SELECT [DISTINCT] select-list FROM from-list WHERE qualification GROUP BY grouping-list HAVING group-qualification

The target list contains
- attribute names
- terms with aggregate operations(e.g. MIN(S.age))

## Difference between WHERE and HAVING
- WHERE: All Sailors are at least 40 years old, then they grouped by rating
  SELECT S.rating, AVG(S.age) AS avg_age FROM Sailors S WHERE S.age >= 40 GROUP BY S.rating

- HAVING: Sailors are grouped by rating and from those obtain those sailors with 40 years or more.
 select S.rating, AVG(S.age) AS avg_age from Sailors S GROUP BY S.rating HAVING AVG(S.age) >= 40;

## NULL Values
Field Values in a tuple are sometimes unknown(e.g., a rating has not been assigned) or inapplicable(e.g., no spouse name).
SQL provides a special value, null, for such situations.
The arithmetic operation +, -, * and / all return null if one of their arguments is null.
count(*) handle null values just like other values. All the other aggregate operations (COUNT, SUM, AVG, MAX, MIN, and variations using DISTINCT) simply discard null values.

<b>Example:</b>
INSERT INTO Sailors (`sid`, `name`, `rating`, `age`) VALUES(99, 'Dan', null, 48.0);
Now we check the different outputs from each query:
select count(*) from Sailors; // returns 10
select count(rating) from Sailors; // returns 9
select count(age) from Sailors; // returns 10

## Integrity Constraints:
An integrity constant describes conditions that every reliable and consistent instance of a relation must satisfy.
Integrity Constraints can be used to ensure application semantics or preventing consistencies.
INSERT, DELETE, AND UPDATE that violate integrity constraint are not permitted.

Types of Integrity Constraints:
<b>Domain Constraints:</b> Field values must be of right type. Always enforced.
<b>Primary Key Constraints</b>
<b>Foreign Key Constraints</b>
<b>General Constraints:</b> Are useful when more specific conditions and primary or foreign key are involved such as business rules. For example, when a company can hire under-aged workers.

## Joins
- Outer Joins are special type of joins
- In the case we require, not only those records where the data value of the common attribute is the same, but also all the records of an specific table involve in the join.
- We may need a left outer join, right outer join or full outer join.
example- left outer join
select S.sid, S.name, R.bid from Sailors S left outer join Reserves R on R.sid = S.sid order by S.sid;
obtains all the rows of Sailors including those joins with reserves by sid plus the results present all Sailors, those with boat reservation, those with no reservation.

SQL was an important factor in the earlier Systems of the relational model, more natural than the early procedural query languages.
Besides, SQL allows the specification of rich integrity constraint.
User needs to be aware of how query settle demise and evaluating it for these results.

<strong>examples:</strong>
- Find Sailors who have reserved at least one boat.
 SELECT S.name, R.sid FROM Sailors S, Reserves R WHERE S.sid = R.sid;
 
- Obtain the name of the sailors that have reserved the boat 103 with original data.
 SELECT S.name FROM Sailors S, Reserves R WHERE S.sid=R.sid AND R.bid = 103;
 
- Find the names of the sailors who have reserved a red boat, and list in the order of age.
 SELECT S.name, S.age FROM Sailors S, Boats B, Reserves R WHERE S.sid=R.sid AND R.bid=B.bid AND B.color = 'red' ORDER BY S.age;

- Find the rating of Sailors who names begin and end with B and contain at least three letters.
 SELECT name, age, rating + 1 AS sth FROM Sailors S WHERE S.name LIKE 'B_%B';
 
- Find the sid's of Sailors who've reserved a red or a green boat.
with union:
SELECT R.sid
FROM Boats B, Reserves R WHERE R.bid = B.bid
AND B.color = 'red'
UNION
SELECT R2.sid
FROM Reserves R2, Boats B2
WHERE R2.bid=B2.bid
AND B2.color='green';

with or:
SELECT S.sid FROM Sailors S, Boats B, Reserves R WHERE S.sid = R.sid AND R.bid = B.bid AND (B.color = 'red' OR B.color = 'green');

with OR and Distinct:
SELECT DISTINCT S.sid FROM Sailors S, Boats B, Reserves R WHERE S.sid = R.sid AND R.bid = B.bid AND (B.color = 'red' OR B.color = 'green');

- Find names of Sailors who have reserved boat = 103 with NESTED QUERY.
 SELECT S.name FROM Sailors S WHERE S.sid IN ( SELECT R.sid FROM Reserves R WHERE R.bid = 103);

- Find names of sailors who have reserved boat = 103 with CORRELATED QUERY.
 SELECT S.name FROM Sailors S WHERE EXISTS (SELECT * FROM Reserves R WHERE R.sid = S.sid AND R.bid = 103);
 * EXISTS is another set completion operator, if unique is used and a study is replaced by r, that'd find sailors with at most one reservation for boat 103.
 
- Find sailors whose rating is greater than that of some sailor called Horatio.
 SELECT * FROM Sailors S WHERE S.rating > ANY ( SELECT S2.rating FROM Sailors S2 WHERE S2.name = 'Horatio');
 
- Find sailors who've reserved all boats with not exist.
