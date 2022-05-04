create table tab_worker (
    wor_id uuid,
    wor_name varchar(20),
    wor_dayli_income numeric(12,2),

    constraint pk_wor_id primary key (wor_id)
);

insert into tab_worker (wor_id, wor_name, wor_dayli_income) values ('c21fad69-4258-2288-50be-a07117a269b6','Bob', 200.0);
insert into tab_worker (wor_id, wor_name, wor_dayli_income) values ('b383cd63-d9a7-ca10-b1eb-b32cb60d83b8','Maria', 300.0);
insert into tab_worker (wor_id, wor_name, wor_dayli_income) values ('3e010391-f98b-5b61-2de6-eda92cca82bd','Alex', 400.0);
