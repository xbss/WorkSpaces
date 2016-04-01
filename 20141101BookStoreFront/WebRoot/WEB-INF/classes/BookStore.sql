

/*1.创建operator表*/
use bookstore;
drop table if exists operator;
create table operator(
	operatorid varchar(255) not null,
	name varchar(255) default null,
	loginname varchar(255) default null,
	password varchar(255) default null,
	permission int(1) default null,
	photo varchar(255) default null,
	primary key (operatorid),
	unique key operator_name(name)
)
engine=InnoDB default CHARSET=utf8;
/*2.创建user表*/
use bookstore;
drop table if exists user;
create table user(
	userid varchar(255) not null,
	name varchar(255) default null,
	loginname varchar(255) default null,
	password varchar(255) default null,
	sex int(1) default null,
	birth date default null,
	phone varchar(255) default null,
	email varchar(255) default null,
	address varchar(255) default null,
	mail varchar(255) default null,
	type varchar(255) default null,
	photo varchar(255) default null,
	primary key (userid),
	unique key user_loginname(loginname)
)
engine=InnoDB default CHARSET=utf8;

/*2.创建表goodType*/
use bookstore;
drop table if exists goodtype;
create table goodtype(
	goodtypeid varchar(255) not null,
	name varchar(255) default null,
	primary key goodtype_goodtypeid(goodtypeid),
	unique key goodtyepe_name(name)
)
engine=InnoDB default CHARSET=utf8;
/*3.创建good表*/
use bookstore;
drop table if exists good;
create table good(
	goodid varchar(255) not null,
	userid varchar(255) default null,
	name varchar(255) default null,
	author varchar(255) default null,
	isbn varchar(255) default null,
	pirce double default null,
	publisher varchar(255) default null,
	goodtypeid varchar(255) default null,
	description varchar(255) default null,
	mainpic varchar(255) default null,
	stock long default null,
	sales long default null,
	primary key (goodid),
	unique key good_name(name),
	key good_userid (userid),
	key good_goodtypeid (goodtypeid),
	constraint good_userid foreign key (userid) references user (userid) on delete no action on update no action,
	constraint good_goodtypeid foreign key (goodtypeid) references goodtype (goodtypeid) on delete no action on update no action
)
engine=InnoDB default CHARSET=utf8;
/*4.创建permission表*/
use bookstore;
drop table if exists permission;
create table permission(
	permissionid varchar(255) not null,
	name varchar(255) default null,
	operatorid varchar(255) default null,
	goodtypeid varchar(255) default null,
	unique key permission_name(name),
	primary key (permissionid),
	key permission_operatorid (operatorid),
	key permission_goodtypeid (goodtypeid),
	constraint permission_operatorid foreign key (operatorid) references operator (operatorid) on delete cascade on update cascade,
	constraint permission_goodtypeid foreign key (goodtypeid) references goodtype (goodtypeid) on delete cascade on update cascade
)
engine=InnoDB default CHARSET=utf8;
/*5.创建order表*/
use bookstore;
drop table if exists orderform;
create table orderform(
	orderformid varchar(255) not null,
	userid varchar(255) default null,
	goodid varchar(255) default null,
	price varchar(255) default null,
	ordertime date default null,
	paymenttime date default null,
	finishtime date default null,
	primary key orderform_orderformid (orderformid),
	key orderform_userid (userid),
	key orderform_goodid (goodid),
	constraint orderform_userid foreign key (userid) references user (userid) on delete no action on update no action,
	constraint orderform_goodid foreign key (goodid) references good (goodid) on delete no action on update no action
)
engine=InnoDB default CHARSET=utf8;

