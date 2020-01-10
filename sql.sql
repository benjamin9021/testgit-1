CREATE TABLE depart(
did varchar2(4) PRIMARY KEY,
dname varchar2(32)
)

CREATE TABLE member(
id varchar2(6) PRIMARY KEY,
name varchar2(12) not null,
did varchar2(4),
birth DATE default sysdate,
constraint fk_member_did_depart_did foreign key(did) references depart(did)
)

insert into depart values('d001', '법학과');
insert into depart values('d002', '영문학과');
insert into depart values('d003', '물리학과');
insert into depart values('d004', '체육학과');

insert into member values('m001', 'sim', 'd001', '1997-11-18');
insert into member values('m002', 'kim', 'd002', '1994-11-18');
insert into member values('m003', 'ahn', 'd003', '1990-11-18');
insert into member values('m004', 'lee', 'd001', '1999-11-18');
insert into member values('m005', 'lee', 'd002', '1989-11-18');

select * from DEPART
select * from member


commit
