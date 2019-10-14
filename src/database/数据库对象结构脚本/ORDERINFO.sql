-- Create table
create table ORDERINFO
(
    id      VARCHAR2(10) not null,
    yy_date VARCHAR2(8),
    yy_time VARCHAR2(4),
    yxbz    VARCHAR2(1)
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
comment on table ORDERINFO
    is '预约信息表';
-- Add comments to the columns
comment on column ORDERINFO.id
    is '预约号id';
comment on column ORDERINFO.yy_date
    is '预约日期';
comment on column ORDERINFO.yy_time
    is '预约时间';
comment on column ORDERINFO.yxbz
    is '有效标志';
-- Create/Recreate indexes
create index INDEX_DATE_TIME on ORDERINFO (YY_DATE, YY_TIME)
    tablespace DATA
    pctfree 10
    initrans 2
    maxtrans 255
    storage
    (
    initial 64 K
    minextents 1
    maxextents unlimited
    );
create index INDEX_YXBZ on ORDERINFO (YXBZ)
    tablespace DATA
    pctfree 10
    initrans 2
    maxtrans 255
    storage
    (
    initial 64 K
    minextents 1
    maxextents unlimited
    );
-- Create/Recreate primary, unique and foreign key constraints
alter table ORDERINFO
    add constraint PRI_ID primary key (ID)
        using index
            tablespace DATA
            pctfree 10
            initrans 2
            maxtrans 255
            storage
            (
            initial 64 K
            minextents 1
            maxextents unlimited
            );
