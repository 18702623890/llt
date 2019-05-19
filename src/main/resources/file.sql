use web_master;
create  table file(
     id varchar(100) primary key,
<<<<<<< HEAD
     filename varchar(100),
     path varchar(100),
     author varchar(100),
     description varchar(200)
=======
     checksum varchar,
     filename varchar(100),
     path varchar(100),
     author varchar(100),
     description varchar(200),
     uploadTime timestamp,
     status int
>>>>>>> 第一次更新
);