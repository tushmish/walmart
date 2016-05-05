set serveroutput on;

declare
  errorCOde number ;
  errorMessage varchar2(200);  
  rowCounter number ;
  maxRows number ;  
  rowCounter number ;
  maxColumns number ;  
  
  l_level_id number;
  
  cursor cursor_seat_category is
  select id, row_count, seat_count from SEAT_CATEGORY;
  
begin  
  savepoint initial_state;
  
  for v_seat_category in cursor_seat_category loop
    maxRows := v_seat_category.row_count; 
    l_level_id := v_seat_category.id;
    --DBMS_OUTPUT.PUT_LINE(l_level_id || '. ' || maxRows);
    select row_count into maxRows from SEAT_CATEGORY where id = l_level_id;
    select seat_count into maxColumns from SEAT_CATEGORY where id = l_level_id; 
    --DBMS_OUTPUT.PUT_LINE(maxRows || '. ' );
      for rowCounter in 1 .. maxRows loop
        for colCounter in 1 .. maxColumns loop
          insert into seat values(SEQ_SEAT.nextval, l_level_id, rowCounter, colCounter);
        end loop;  
      end loop;    
  end loop; 
  savepoint loaded_seat;
  commit;
exception
  when others then
    DBMS_OUTPUT.PUT_LINE('exception : ' || errorCOde || '. ' || errorMessage);
    rollback to initial_state;  
end;
/	