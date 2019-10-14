-- Create table
create table ORDERALL
(
    yy_date VARCHAR2(8),
    yy_time VARCHAR2(4),
    num     NUMBER
)
    tablespace DATA
    pctfree 10
    initrans 1
    maxtrans 255
    storage
(
    initial 64
    minextents 1
    maxextents unlimited
);
-- Add comments to the table
comment on table ORDERALL
    is '可预约时间表';
-- Add comments to the columns
comment on column ORDERALL.yy_date
    is '可预约日期';
comment on column ORDERALL.yy_time
    is '可预约时间';
comment on column ORDERALL.num
    is '预约总量';
