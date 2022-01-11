create database drivingschool;

use drivingschool;
create table coach_table(
	coach_id int not null auto_increment,
	coach_name varchar(100) not null,
	gender varchar(1),
	coach_password varchar(100) not null,
	role varchar(50) not null default 'coach',
	constraint pk_coach primary key(coach_id,coach_name)

);
create table trainee_table(
	trainee_id int not null auto_increment,
	trainee_name varchar(100) not null,
	gender varchar(1),
	date_of_birth date,
	trainee_password varchar(100) not null,
	coach_name varchar(100) not null,
	coach_id int not null,
	role varchar(50) not null default 'trainee',
	primary key(trainee_id),
	foreign key(coach_id,coach_name) references coach_table(coach_id,coach_name)
);

create table exams_table(
	test_date date,
	trainee_id int not null,
	exam_status varchar(10),
	retakes int default 0,
	tuition int default 100,
	foreign key(trainee_id) references trainee_table(trainee_id)
);

create table admin_table(
	admin_id int not null auto_increment,
	admin_name varchar(100) not null,
	admin_password varchar(100) not null,
	role varchar(50) not null default 'admin',
	primary key(admin_id)
);

create table Users(
	username varchar(100) not null,
	password varchar(100) not null default 0000,
	role varchar(50) not null
);

use twelvedrivingschool;

CREATE TRIGGER traineeUser_insert
AFTER INSERT
ON trainee_table FOR EACH ROW
	INSERT INTO users(username,password,role)
	VALUES(new.trainee_name, new.trainee_password,new.role);



CREATE TRIGGER CoachUser_insert
AFTER INSERT
ON coach_table FOR EACH ROW
	INSERT INTO users(username,password,role)
	VALUES(new.coach_name, new.coach_password,new.role);

CREATE TRIGGER AdminUser_insert
AFTER INSERT
ON admin_table FOR EACH ROW
	INSERT INTO users(username,password,role)
	VALUES(new.admin_name, new.admin_password,new.role);

INSERT INTO admin_table(admin_name,admin_password) VALUES('Charinga Jabulani', 'jabu21');
INSERT INTO admin_table(admin_name,admin_password) VALUES('Henry Anthony', 'henry123');






