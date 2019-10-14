-- Create sequence
create sequence SEQ_ORDERID
    minvalue 1000000
    maxvalue 1000000000
    start with 1000000
    increment by 1
    cache 20;
