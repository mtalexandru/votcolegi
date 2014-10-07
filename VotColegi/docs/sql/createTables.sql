CREATE TABLE IF NOT EXISTS `sortareColegi`.`SEQUENCE` (
	`SEQ_NAME` VARCHAR(50) NOT NULL, 
	`SEQ_COUNT` DECIMAL(38), 
	PRIMARY KEY (`SEQ_NAME`) )
		ENGINE = InnoDB
		COMMENT = 'Gestiunea secventelor pentru id-uri.' ;
		
		
		CREATE TABLE USERS
(
id int NOT NULL PRIMARY KEY,
login varchar2(20) NOT NULL,
password varchar2(20) NOT NULL
);

CREATE TABLE ROLES
(
id int NOT NULL PRIMARY KEY,
role varchar2(20) NOT NULL
);

CREATE TABLE USER_ROLES
(
user_id int NOT NULL,
role_id int NOT NULL,
CONSTRAINT pk_user_roles PRIMARY KEY (user_id, role_id),
CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES USERS(id),
CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES ROLES(id)
);