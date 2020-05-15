# Week - 3

## Concepts of a logical design

The relational model was proposed by Edward Codd to implement physical independency, which means that in case of changes on the physical storage of the data, the SQL program shouldn't be affected, and to implement the logical independency, which means that changes on the logical schema, shouldn't affect programs and vice-versa.

In order to implement the logical and physical independence of data within a relational database management system, the architecture of such DBMS must comply with the three levels of abstraction of a relational database:-
1. External level - where end users have different views of the data they use, depending on the activities they carry out with data.
2. The conceptual level - where the data analysts have a different perception of data, they know the entire structure and relation, conceptual schema, logical structure of data and the entity-relational diagram we have obtained from the conceptual design.
3. Physical level, in this level, database administrators have a more physical view, in terms of file system on disk, indexes etc.

## The process to map from a conceptual model to a logical model is as follows:

1. A set of entities is transformed into a relation.(set of tuples)
2. An attribute is transformed into an attribute of the relation.
3. An identifier of the entity becomes the primary key of the relation.
4. Any N:M(many to many) relationship between entities of the diagram becomes a relation in the MR that will have as PK the two primary keys of the entities that it associates.
5. Relationship 1:M between entities will be represented as FK, where the primary key of the entity with cardinality 1 passes to the relation that represents the set of entities whose cardinality is M.

In case of 1:1 relationship the PK of one relation is stored on the second relation.

In 1:M relationship, the parent relationship will be the one on the "cardinality 1" side. The child relationship will be the one one the "many" side.

In case of "many-to-many" relationships, can be implemented by introducing a new an intermediary relation. The primary key will be composed by the primary keys of the original two relations.
