create database web_master;
use web_master;
create  table users(
      id varchar (100) primary  key,
      username varchar (100) not null,
      password varchar (100),
      phone  varchar(100),
      email varchar(100),
      birthday DATE ,
      address varchar (100)
<<<<<<< HEAD
=======
);
create table json_task(
   id int  primary key auto_increment,
   checksum varchar(100),
   status int
>>>>>>> 第一次更新
);