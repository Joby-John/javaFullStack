
````markdown
# PostgreSQL Notes

## Databases

### Create Database
```sql
CREATE DATABASE test;
````

* **What it does:** Creates a database named `test`.
* **Use:** To logically separate data in PostgreSQL.
* **Alternatives:** `createdb test` (command-line).
* **Advantages:** Isolation of data, easy access control.
* **Drawbacks:** Need to switch databases to access different data.

### List Databases

```sql
\l
-- or
SELECT datname FROM pg_database;
```

* **Use:** View all databases.

### Connect to Database

```sql
\c test
```

* **Use:** Switch to a database in the same `psql` session.

### Drop Database

```sql
\c postgres
DROP DATABASE test;
```

* **Use:** Delete a database permanently.
* **Note:** Cannot drop if other sessions are connected.

### Clear Terminal

```sql
\! cls
```

---

## Tables

### Create Table

```sql
CREATE TABLE person(
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(100)
);
```

* **Use:** To store structured data in rows and columns.
* **Alternatives:** Use `SERIAL` for auto-incremented IDs.
* **Advantages:** Enforces data types and structure.
* **Drawbacks:** Rigid schema, may require ALTER for changes.

### View Table Structure

```sql
\d person
```

---

## Insert Data

### Single Row

```sql
INSERT INTO person(id, name, city)
VALUES (101, 'Raju', 'Delhi');
```

### Multiple Rows

```sql
INSERT INTO person(id, name, city)
VALUES
(102, 'Sham','Mumbai'),
(103, 'Paul', 'Chennai');
```

### Insert All Columns in Order

```sql
INSERT INTO person
VALUES (104, 'Alex', 'Pune');
```

---

## Read Data

### Select All Columns

```sql
SELECT * FROM person;
```

### Select Specific Columns

```sql
SELECT name FROM person;
SELECT name, city FROM person;
```

* **Alternatives:** Add `DISTINCT`, `ORDER BY`, `LIMIT`, or `WHERE` clauses.
* **Advantages:** Retrieve only needed data.
* **Drawbacks:** Selecting * all columns may be inefficient.

---

## Update Data

```sql
UPDATE person
SET city = 'London'
WHERE id = 101;
```

* **Use:** Modify existing rows.
* **Drawback:** Without `WHERE`, all rows are updated.

---

## Delete Data

```sql
DELETE FROM person
WHERE id = 104;
```

### Delete All Rows

```sql
TRUNCATE TABLE person;
```

* **Use:** Remove unwanted data.
* **Advantages:** Clean tables quickly.
* **Drawbacks:** Permanent deletion, can’t rollback without transactions.

---

## Constraints

* `PRIMARY KEY`, `NOT NULL`, `UNIQUE`, `CHECK`, `FOREIGN KEY`, `DEFAULT`.
* Example:

```sql
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT REFERENCES person(id),
    amount DECIMAL CHECK (amount > 0)
);
```

* **Use:** Enforce data integrity.

---

## Indexes

```sql
CREATE INDEX idx_person_name
ON person(name);
```

* **Use:** Improve query performance.
* **Advantages:** Faster SELECT queries.
* **Drawbacks:** Slower INSERT/UPDATE and extra storage.

---

## Views

```sql
CREATE VIEW person_city AS
SELECT name, city
FROM person
WHERE city = 'Delhi';
```

* **Use:** Simplify complex queries, reusable abstraction.
* **Drawbacks:** May add overhead for large tables.

---

## Joins

```sql
SELECT p.name, o.amount
FROM person p
INNER JOIN orders o ON p.id = o.customer_id;
```

* **Types:** `INNER JOIN`, `LEFT JOIN`, `RIGHT JOIN`, `FULL OUTER JOIN`.
* **Use:** Combine related tables for analysis.

---

## Transactions

```sql
BEGIN;
UPDATE person SET city='Mumbai' WHERE id=101;
INSERT INTO orders(order_id, customer_id, amount) VALUES(1, 101, 500);
COMMIT; -- or ROLLBACK;
```

* **Use:** Ensure all-or-nothing execution.
* **Advantages:** Maintain data consistency.

---

## Sequences

```sql
CREATE SEQUENCE person_id_seq
START WITH 1
INCREMENT BY 1;
```

* **Use:** Generate unique IDs automatically.
* **Alternative:** `SERIAL` or `BIGSERIAL` in table creation.

---

## Useful Commands

* `\dt` : List all tables.
* `\d table_name` : Describe table structure.
* `\q` : Quit `psql`.

---

## Best Practices

* Use constraints to enforce data integrity.
* Index frequently queried columns.
* Wrap multiple operations in transactions for consistency.
* Use views for reporting and abstraction.
* Always backup before dropping/truncating tables.
* Maintain meaningful table and column names.

---

## Notes

All commands can be executed in `psql` or any PostgreSQL client.
Tables, constraints, joins, views, indexes, and transactions are fundamental for relational database development.

```
