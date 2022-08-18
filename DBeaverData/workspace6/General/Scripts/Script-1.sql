CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	first_name VARCHAR(200) NOT NULL,
	last_name VARCHAR(200) NOT NULL,
	email VARCHAR(200) NOT NULL UNIQUE,
	username VARCHAR(200) NOT NULL UNIQUE,
	"password" VARCHAR(200) NOT NULL
);

CREATE TABLE requests (
	request_id SERIAL PRIMARY KEY,
	title VARCHAR(60) NOT NULL,
	reimbursement_amount FLOAT NOT NULL,
	message VARCHAR(2000),
	user_id INT,
	completed BOOL,
	CONSTRAINT requests_users_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
);

current_date

SELECT * FROM users u; 
SELECT * FROM requests r 

DROP TABLE requests;
DROP TABLE users;

SELECT * FROM users ORDER BY user_id

UPDATE users SET  first_name = 'Jared', last_name = 'Adams', email = 'jaredmarshalladams2@gmail.com' , username = 'jaredmarshalladams2',  "password" = 'TempPass2' WHERE user_id = 3 

SELECT * FROM users WHERE user_id = 1