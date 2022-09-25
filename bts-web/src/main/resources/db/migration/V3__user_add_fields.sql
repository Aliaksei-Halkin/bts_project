alter table users add column  decision user_decision;
alter table users add column  created_at timestamp default now();
alter table users add column  updated_at timestamp default now();
alter table users add column  archived_at timestamp;