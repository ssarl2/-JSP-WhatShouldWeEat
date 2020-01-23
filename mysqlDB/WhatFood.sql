create table foods(
fname varchar(20) primary key not null comment '음식이름',
kind varchar(20) not null comment '종류',
material varchar(500) not null comment '재료'
) comment '음식기본정보';

alter table foods
add constraint pk_foods -- 음식 기본키
primary key(fname);

create table members(
id varchar(50) primary key not null comment '아이디',
pw varchar(100) not null comment '비밀번호',
age integer not null comment '나이대',
sex varchar(10) not null comment '성별',
selects varchar(500) not null default '' comment '추천한 음식'
) comment '회원정보';

alter table members
add constraint pk_members -- 회원 기본키
primary key(id);

create table board(
bno integer primary key auto_increment,
title varchar(20) not null,
contents varchar(200) not null,
id varchar(50) not null,
views integer not null default 0,
created varchar(20) not null);

select * from foods;
select * from members;
select * from board;