alter table users drop column queue_level;
drop type user_queue_level;
create type user_queue_level as enum ('FIRST', 'SECOND','THIRD','REJECT');
alter table users add column queue_level user_queue_level;