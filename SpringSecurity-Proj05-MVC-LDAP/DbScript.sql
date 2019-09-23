create table aero_users(uname varchar2(10) primary key,pwd varchar2(75),status number(1))
/


 create table aero_roles(role_id number(3) primary key,role_name varchar2(20),uname varchar2(10) references aero_users)
 /