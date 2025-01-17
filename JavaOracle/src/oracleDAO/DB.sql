CREATE TABLE account(
	id varchar2(20),
	pwd varchar2(20) not NUll,
	CONSTRAINT PK_ACCOUNT PRIMARY key(id)
);

INSERT INTO account VALUES('sahmyook', 'yukr1009');
