# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table product (
  refproduct                    varchar(255) not null,
  name                          varchar(255),
  picture                       varchar(255),
  creationdate                  timestamp,
  constraint pk_product primary key (refproduct)
);

create table stock (
  refstore                      varchar(255),
  refproduct                    varchar(255),
  status                        varchar(255),
  creationdate                  timestamp,
  lastupdate                    timestamp,
  quantity                      integer,
  vat                           integer,
  priceht                       integer,
  constraint uq_stock_refstore unique (refstore),
  constraint uq_stock_refproduct unique (refproduct)
);

create table store (
  refstore                      varchar(255) not null,
  name                          varchar(255),
  picture                       varchar(255),
  vat                           integer,
  currency                      varchar(255),
  merchantkey                   varchar(255),
  constraint pk_store primary key (refstore)
);

alter table stock add constraint fk_stock_refstore foreign key (refstore) references store (refstore) on delete restrict on update restrict;

alter table stock add constraint fk_stock_refproduct foreign key (refproduct) references product (refproduct) on delete restrict on update restrict;


# --- !Downs

alter table if exists stock drop constraint if exists fk_stock_refstore;

alter table if exists stock drop constraint if exists fk_stock_refproduct;

drop table if exists product cascade;

drop table if exists stock cascade;

drop table if exists store cascade;

