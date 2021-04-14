create database if not exists DB;

use DB;

create table User (
	username varchar (200),
	password varchar (200));

insert into DB.User (`username`, `password`) values("tai", "tai");
insert into DB.User (`username`, `password`) values("clawrence", "clawrence");
insert into DB.User (`username`, `password`) values("zixin", "zixin");