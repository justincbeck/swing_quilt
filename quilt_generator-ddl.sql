
    alter table quilts_tiles 
        drop 
        foreign key FKAF13450CD3812D0F;

    alter table quilts_tiles 
        drop 
        foreign key FKAF13450C88DE17E;

    alter table tiles 
        drop 
        foreign key FK69403857F8328C4;

    drop table if exists images;

    drop table if exists quilts;

    drop table if exists quilts_tiles;

    drop table if exists tiles;

    create table images (
        id bigint not null auto_increment,
        name varchar(255) unique,
        image MEDIUMBLOB,
        primary key (id)
    );

    create table quilts (
        id bigint not null auto_increment,
        name varchar(255) unique,
        rows integer not null,
        cols integer not null,
        primary key (id)
    );

    create table quilts_tiles (
        quilts_id bigint not null,
        tiles_id bigint not null,
        unique (tiles_id)
    );

    create table tiles (
        id bigint not null auto_increment,
        rotation integer not null,
        image_id bigint,
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

    alter table tiles 
        add index FK69403857F8328C4 (image_id), 
        add constraint FK69403857F8328C4 
        foreign key (image_id) 
        references images (id);
