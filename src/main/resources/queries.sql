create table user (id INT PRIMARY KEY, active boolean, password varchar(10), user_name varchar(10), roles varchar(20));

insert into user values (1,true,'test','test','ROLE_USER');