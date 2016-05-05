declare
  errorCOde number ;
  errorMessage varchar2(200);
begin
  savepoint initial_state;
    insert into EVENT values(SEQ_EVENT.nextval, , 'opera', '' );
  savepoint loaded_events;
  commit;
exception
  when others then
    DBMS_OUTPUT.PUT_LINE(errorCOde || '. ' || errorMessage);
    rollback to initial_state;  
end;
/	