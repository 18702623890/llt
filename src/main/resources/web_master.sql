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
);