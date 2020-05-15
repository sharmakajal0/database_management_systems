# Week - 2

The analysis and design of an OLTP system are Analysis of requirements, conceptual design, logical design and physical design.
1. During the analysis of experiments, the final user establishes requirements in terms of business rules. A User Requirement Specification is simply a statement of the 'user needs'.
2. The second step corresponds to the conceptual Design, where a data analyst should map all these real-world needs into technical requirements in this case into an entity relational model.

The output of an entity relational model should
answer: 
- What are the entities and relationships in the enterprise?
- What information about these entities and relationships should be stored in a database?
- What are the integrity constraints or business rules that hold?

The logical design is an extra step where the ER diagram obtained from the conceptual design will be mapped into a normalized relational data model.

The physical design is the final step, which consists of SQL programming in order to create, populate, and query a relational database.

###Entity-Relationship model

<b>Entity</b> - An entity represents a thing or object of the real world and is distinguished from others according to their characteristics.
<b>Entity Set</b> - An entity set is a collection of similar entities, for instance, a set of all employees, and is represented by a rectangle.

<strong>Properties of Entities</strong>
<i>Attributes</i> - Attributes are the properties of entities. These are represented by means of ellipses. Every ellipse represents one attribute and is directly connected to its entity which is a rectangle.

<i>Key</i> - Key is an attribute or collection of attributes that uniquely identifies an entity among an entity set. An attribute that is a key is underlined.

For example, the roll number of a student makes him or her identifier among students. 

<i>A Super Key</i> - A super key is a set of attributes, one or more that collectively identifies an entity in an entity set.

<i>Primary Key</i> - A primary key is one of the candidate keys chosen by the database designer to uniquely identify the entity set. It is unique and not null.

<i>Relationship</i> - A relationship is an association among two or more entities,
for example, John works in a pharmacy department.

<i>Relationship Set</i> - A relationship set is a collection of similar relationships and is represented by a rhombus.

<i>Cardinality</i> - Cardinality specifies how many instances of an entity relate to one instance of another entity.

There are four types of binary cardinality:
- one-to-one
- one-to-many
- many-to-one
- many-to-many.
For example, according to different business rules, two entities can be related in different ways.
On the one hand, an employee can work in many departments and many employees work in a department, many-to-many relationship model.
On the other hand, an employee can work in only one department, and a department is composed by many employees, many-to-one relationship.

<i>Degree of a relationship</i> - The degree of a relationship indicates a number of entities that a relationship associates. We can see on the following diagram, samples of degree one, degree two, or binary and degree three, or ternary.

<i>Entity schema</i> - An entity schema is a definition of a structure of an entity.

<i>Redundancy</i> - Redundancy corresponds to storage of the same data several times in different places.

<i>Inconsistency</i> - when redundant data are not equal to each other.

<i>Primary Keys</i> - The primary key uniquely identify each entity.

<i>Intension</i> - The intension of a database is a set of definitions of the data structures for the particular database, also called database schema.

<i>Instance</i> - An instance corresponds to the actual content of the database

<strong>Peter Chen's ER Diagram - </strong>
- Rectangles represent entity types
- ellipses represent attributes
- diamonds represents a relationship types
- lines link attributes to entity types and entity types to relationship types.
- Primary key attributes are underlying.

<b>Steps in designing an entity relationship diagram from the user's requirements -</b>
1. The first place we need to identify entity types
2. then identify relationships.
3. On the third, identify and associate attributes with entity and relationship types.
4. The fourth place, determine attribute domains.
5. Then we need to determine primary key attributes for entity types.
6. At last, associate the cardinality radius with relationship types.
