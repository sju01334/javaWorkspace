create table member(
	member_id int primary key auto_increment
	, user_id varchar(20)
	, password varchar(20)
	, name varchar(20)
	, regdate timestamp default now()
) default character set utf8;

