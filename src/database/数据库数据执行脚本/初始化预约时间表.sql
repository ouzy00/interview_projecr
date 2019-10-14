declare
  begin_date varchar2(8);
begin
  begin_date := '20191013';
  while begin_date <= ((to_char(sysdate, 'yyyy') + 100) || substr(begin_date,5,4)) loop
      insert into ORDERALL
        select begin_date, '0900', 6 FROM dual
        union all
        select begin_date, '1000', 6 FROM dual
        union all
        select begin_date, '1100', 6 FROM dual
        union all
        select begin_date, '1200', 6 FROM dual
        union all
        select begin_date, '1300', 6 FROM dual
        union all
        select begin_date, '1400', 6 FROM dual
        union all
        select begin_date, '1500', 6 FROM dual;
    begin_date := to_char((to_date(begin_date,'yyyymmdd')+1),'yyyymmdd');
  end loop;
end;
