declare
  errorCOde number ;
  errorMessage varchar2(200);
begin
  savepoint initial_state;
    --insert into SEAT_CATEGORY values(SEQ_SEAT_CATEGORY.nextval, 'Level 1', 25, 50, 100);
    --insert into SEAT_CATEGORY values(SEQ_SEAT_CATEGORY.nextval, 'Level 2', 20, 100, 75); 
    --insert into SEAT_CATEGORY values(SEQ_SEAT_CATEGORY.nextval, 'Level 3', 15, 100, 50); 
    --insert into SEAT_CATEGORY values(SEQ_SEAT_CATEGORY.nextval, 'Level 4', 15, 100, 40);
	
    insert into SEAT_CATEGORY values(SEQ_SEAT_CATEGORY.nextval, 'Level 1', 3, 3, 100);
    insert into SEAT_CATEGORY values(SEQ_SEAT_CATEGORY.nextval, 'Level 2', 3, 3, 75); 
    insert into SEAT_CATEGORY values(SEQ_SEAT_CATEGORY.nextval, 'Level 3', 3, 3, 50); 
    insert into SEAT_CATEGORY values(SEQ_SEAT_CATEGORY.nextval, 'Level 4', 3, 3, 40);
  savepoint loaded_seat_category;
  commit;
exception
  when others then
    DBMS_OUTPUT.PUT_LINE(errorCOde || '. ' || errorMessage);
    rollback to initial_state;  
end;
/	