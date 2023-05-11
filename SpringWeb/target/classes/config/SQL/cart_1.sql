-- 2023.05-10 이후 sql문

drop table cart;

create table cart(
    cartNum number(8) primary key,
    idx_fk number(8) references member(idx) on delete cascade,
    pnum_fk number(8) references product(pnum) on delete cascade,
    pqty number(8) not null,
    indate date default sysdate,
    constraint cart_pqty_ck check(pqty>0 and pqty<51)
);

drop sequence cart_seq;
create sequence cart_seq nocache;

desc product;
commit;



select * from product;
commit;

DELETE FROM product WHERE pnum<4;

select * from cart;

select cartNum from cart where idx_fk=1 and pnum=1;
desc cart;
select * from product;

insert into cart(cartNum,idx_fk,pnum_fk,pqty) values(cart_seq.nextval,1,4,5);

select * from cart;
select cartNum from cart where idx_fk=15 and pnum_fk=1;

-- cart와 product조인, subquery
create or replace view cartView
as
select c.*, p.pname, p.pimage1, price, saleprice,point,
		(c.pqty * p.saleprice) totalPrice,
		(c.pqty * p.point) totalPoint
		from cart c join product p
		on c.pnum_fk = p.pnum;
        
select * from cartView where idx_fk = 15;

select sum(totalPrice) cartTotalPrice, sum(totalPoint) cartTotalPrice from cartView where idx_fk=15;
commit;
select * from member order by idx;
delete from member where idx=1;
update member SET mstate=0 where idx=15;

select * from cart;



-- 2023-05-11 

insert into upCategory values(upCategory_seq.nextval,'자동차용품');
select * from upCategory;
commit;

--------------------------------------------------------------------------------
drop table spring_board;

create table spring_board(
  num number(8) primary key,--글번호
  userid varchar2(30) not null, -- 작성자 아이디
  passwd varchar2(100) not null,--글 비밀번호
  subject varchar2(300) not null, --글제목
  content varchar2(4000), -- 글내용
  wdate date default sysdate, -- 작성일
  readnum number(8) default 0,--조회수
  filename varchar2(500), -- 첨부파일명[uuid_a.txt]=>물리적 파일명
  originFilename varchar2(500),--원본파일명 [a.txt]=>논리적 파일명
  filesize number(8), --첨부파일크기

  refer number(8), --글 그룹번호 [답변형 게시판에서 필요한 컬럼] 
  lev number(8),-- 답변 레벨 [답변형 게시판에서 필요한 컬럼] 
  sunbun number(8)-- 같은 글 그룹 내에 순서 정렬시 필요한 컬럼  [답변형 게시판에서 필요한 컬럼] 
);

desc spring_board;
commit;



