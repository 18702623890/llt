use web_master;
create  table file(
     id varchar(100) primary key,
     filename varchar(100),
     path varchar(100),
     author varchar(100),
     description varchar(200)
);