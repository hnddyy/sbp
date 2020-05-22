DROP TABLE IF EXISTS user;

CREATE TABLE user (
  userId VARCHAR(30) PRIMARY KEY,
  userPassword VARCHAR(100) NOT NULL,
  userName VARCHAR(50) NOT NULL
);

INSERT INTO user (
	userId
	,userPassword
	,userName
) VALUES (
	'test1'
	,'funzingogo'
	,'김일'
);

INSERT INTO user (
	userId
	,userPassword
	,userName
) VALUES (
	'test2'
	,'funzingogo'
	,'김이'
);
 