````markdown
# PostgreSQL Notes: Data Types and Constraints

## Data Types

### What is a Data Type?
A **data type** specifies the type of data that can be stored in a column of a table. It ensures data integrity and helps PostgreSQL optimize storage.

### Most Widely Used Data Types

#### Numeric
* `INT` / `INTEGER` : Whole numbers.
* `DOUBLE PRECISION` / `FLOAT` : Floating point numbers.
* `DECIMAL(p, s)` / `NUMERIC(p, s)` : Exact numeric type with precision `p` and scale `s`.

**Example:**
```sql
price DECIMAL(5, 2); -- Total 5 digits, 2 after decimal, e.g., 123.45
quantity INT;
rating FLOAT;
````

#### String

* `VARCHAR(n)` : Variable-length string with maximum length `n`.
* `CHAR(n)` : Fixed-length string.
* `TEXT` : Unlimited length string.

**Example:**

```sql
name VARCHAR(100);
description TEXT;
code CHAR(5);
```

#### Date/Time

* `DATE` : Stores calendar dates (YYYY-MM-DD).
* `TIMESTAMP` : Stores date and time.
* `TIME` : Stores time only.

**Example:**

```sql
created_on DATE;
last_updated TIMESTAMP;
start_time TIME;
```

#### Boolean

* `BOOLEAN` : Stores `TRUE` or `FALSE`.

**Example:**

```sql
is_active BOOLEAN;
```

---

## Constraints

### What is a Constraint?

A **constraint** is a rule applied to a column to enforce data integrity.

### Primary Key

* Uniquely identifies each row in a table.
* Must be unique and not null.
* Only **one primary key** per table.

**Example:**

```sql
CREATE TABLE person(
    id INT PRIMARY KEY,
    name VARCHAR(100),
    city VARCHAR(100)
);
```

### NOT NULL

* Prevents null values in a column.

**Example:**

```sql
CREATE TABLE person(
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(100)
);
```

### DEFAULT

* Assigns a default value if none is provided during insert.

**Example:**

```sql
CREATE TABLE orders(
    order_id SERIAL PRIMARY KEY,
    status VARCHAR(20) DEFAULT 'pending',
    amount DECIMAL(8,2) DEFAULT 0.0
);
```

### AUTO_INCREMENT (SERIAL / BIGSERIAL in PostgreSQL)

* Automatically generates sequential values for a column.
* `SERIAL` → 4 bytes (integer)
* `BIGSERIAL` → 8 bytes (bigint)

**Example:**

```sql
CREATE TABLE products(
    product_id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    price DECIMAL(10,2)
);
```

### Multiple Constraints

* Multiple constraints can be applied by chaining them.

**Example:**

```sql
CREATE TABLE student(
    student_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT DEFAULT 18
);
```

---

## Notes

* Data types ensure proper storage and manipulation of values.
* Constraints enforce rules on table columns to maintain data integrity.
* `SERIAL` / `BIGSERIAL` is commonly used for ID columns to auto-generate unique keys.
* Multiple constraints can coexist on a single column to provide flexibility and robustness.

---

```
```
