
    alter table quilts_tiles
        drop
        foreign key FKAF13450CD3812D0F;

    alter table quilts_tiles
        drop
        foreign key FKAF13450C88DE17E;

    drop table if exists quilts;

    drop table if exists quilts_tiles;

    drop table if exists tiles;

    create table quilts (
        id bigint not null auto_increment,
        name varchar(255),
        rows int,
        cols int,
        primary key (id)
    );

    create table quilts_tiles (
        quilts_id bigint not null,
        tiles_id bigint not null,
        primary key (quilts_id, tiles_id),
        unique (tiles_id)
    );

    create table tiles (
        id bigint not null auto_increment,
        rotation integer not null,
        fileName varchar(255),
        primary key (id)
    );

    alter table quilts_tiles 
        add index FKAF13450CD3812D0F (quilts_id), 
        add constraint FKAF13450CD3812D0F 
        foreign key (quilts_id) 
        references quilts (id);

    alter table quilts_tiles 
        add index FKAF13450C88DE17E (tiles_id), 
        add constraint FKAF13450C88DE17E 
        foreign key (tiles_id) 
        references tiles (id);
