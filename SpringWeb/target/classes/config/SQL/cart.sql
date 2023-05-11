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