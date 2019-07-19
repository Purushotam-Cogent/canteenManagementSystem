create database CanteenManagement;
use canteenmanagement;
create table Employee(emp_id int primary key, emp_name varchar(20), wallet_balance varchar(10), role varchar(10), contact_no varchar(13));
create table Menu(food_id int primary key, food_name varchar(20), quantity int, price int);

create table Orders(order_id int primary key, food_id int, order_time varchar(10), cancellation_time varchar(10), emp_id int,
                   final_amnt int, estimated_time varchar(10), order_status varchar(10));