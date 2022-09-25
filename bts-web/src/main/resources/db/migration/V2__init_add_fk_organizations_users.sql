alter table users
    add column last_organization bigint not null
        constraint last_organization_fk_organizations_id references organizations (id)
            on update restrict on delete restrict;