-- Create table
create table ORDERTIMEPARAM
(
    "id"    VARCHAR2(2),
    yy_time VARCHAR2(4)
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
comment on table ORDERTIMEPARAM
    is '时间配置表';
-- Add comments to the columns
comment on column ORDERTIMEPARAM."id"
    is '编号';
comment on column ORDERTIMEPARAM.yy_time
    is '可预约时间';
