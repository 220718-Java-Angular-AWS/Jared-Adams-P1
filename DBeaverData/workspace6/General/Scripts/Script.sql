CREATE TABLE employees (
	employee_id SERIAL PRIMARY KEY,
	first_name VARCHAR(200),
	last_name VARCHAR(200),
	email VARCHAR(200) UNIQUE,
	username VARCHAR(200) UNIQUE,
	"password" VARCHAR(200),
	"admin" BOOL,
	CONSTRAINT chk_first_name CHECK (first_name<>N''),
	CONSTRAINT chk_last_name CHECK (last_name<>N''),
	CONSTRAINT chk_email CHECK (email<>N''),
	CONSTRAINT chk_username CHECK (username<>N''),
	CONSTRAINT chk_password CHECK (LENGTH("password") >= 8)
);

CREATE TABLE requests (
	request_id SERIAL PRIMARY KEY,
	title VARCHAR(60),
	reimbursement_amount FLOAT,
	message VARCHAR(2000),
	employee_id INT,
	"status" VARCHAR(20),
	CONSTRAINT requests_employees_fk FOREIGN KEY (employee_id) REFERENCES employees (employee_id)
);



current_date

SELECT * FROM employees e;
SELECT * FROM requests r;

DROP TABLE requests;
DROP TABLE employees;

DELETE FROM requests;
DELETE FROM employees;

INSERT INTO employees (first_name, last_name, email, username, password, admin) VALUES ('Jared', 'Adams', 'jaredmarshalladam@gmail.com', 'jaredad', 'password1', false)
SELECT * FROM employees ORDER BY employee_id

SELECT * FROM employees WHERE employee_id = 1

DELETE FROM employees AND requests WHERE employee_id = 3

ALTER TABLE requests MODIFY status VARCHAR(20)