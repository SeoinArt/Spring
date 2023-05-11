-- 2023.05-10 ���� sql��

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

-- cart�� product����, subquery
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

insert into upCategory values(upCategory_seq.nextval,'�ڵ�����ǰ');
select * from upCategory;
commit;

--------------------------------------------------------------------------------
drop table spring_board;

create table spring_board(
  num number(8) primary key,--�۹�ȣ
  userid varchar2(30) not null, -- �ۼ��� ���̵�
  passwd varchar2(100) not null,--�� ��й�ȣ
  subject varchar2(300) not null, --������
  content varchar2(4000), -- �۳���
  wdate date default sysdate, -- �ۼ���
  readnum number(8) default 0,--��ȸ��
  filename varchar2(500), -- ÷�����ϸ�[uuid_a.txt]=>������ ���ϸ�
  originFilename varchar2(500),--�������ϸ� [a.txt]=>���� ���ϸ�
  filesize number(8), --÷������ũ��

  refer number(8), --�� �׷��ȣ [�亯�� �Խ��ǿ��� �ʿ��� �÷�] 
  lev number(8),-- �亯 ���� [�亯�� �Խ��ǿ��� �ʿ��� �÷�] 
  sunbun number(8)-- ���� �� �׷� ���� ���� ���Ľ� �ʿ��� �÷�  [�亯�� �Խ��ǿ��� �ʿ��� �÷�] 
);

desc spring_board;
commit;



