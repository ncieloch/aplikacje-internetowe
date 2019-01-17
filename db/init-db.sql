/*drop index FK_Pracownik_DokumentSprzedazy_;

drop index DokumentSprzedazy_PK;

drop table DokumentSprzedazy;

drop index Produkt_dostawa_FK;

drop index FK_Dostawca_Dostawa_FK;

drop index Dostawa_PK;

drop table Dostawa;

drop index Dostawca_PK;

drop table Dostawca;

drop index FK_Sklep_Dzial_FK;

drop index Dzial_PK;

drop table Dzial;

drop index FK_Sprzedaz_Produkt2_FK;

drop index FK_Sprzedaz_Produkt_FK;

drop index FK_Sprzedaz_Produkt_PK;

drop table FK_Sprzedaz_Produkt;

drop index FK_Dostawa_Magazyn_FK;

drop index Magazyn_PK;

drop table Magazyn;

drop index FK_Marka_Producent_FK;

drop index Marka_PK;

drop table Marka;

drop index Pracownik_PK;

drop table Pracownik;

drop index Producent_PK;

drop table Producent;

drop index Dzial_Produkt_FK;

drop index FK_Produkt_Marka_FK;

drop index Produkt_PK;

drop table Produkt;

drop index FK_Magazyn_Sklep_FK;

drop index Sklep_PK;

drop table Sklep;

drop index FK_DokumentSprzedazy_Sprzedaz_F;

drop index FK_Sklep_Sprzedaz_FK;

drop index Sprzedaz_PK;

drop table Sprzedaz;

drop index Magazyn_dostawa_FK;

drop index FK_Dostawca_Zamowienie_FK;

drop index Zamowienie_PK;

drop table Zamowienie;

drop index Zamowienie_Produkt2_FK;

drop index Zamowienie_Produkt_FK;

drop index Zamowienie_Produkt_PK;

drop table Zamowienie_Produkt;*/

/*==============================================================*/
/* Table: DokumentSprzedazy                                     */
/*==============================================================*/
create table DokumentSprzedazy (
  id_dokumentSprzedazy INT4                 not null,
  id_pracownik         INT4                 null,
  data_sprzedazy       Date                 null,
  constraint PK_DOKUMENTSPRZEDAZY primary key (id_dokumentSprzedazy)
);

/*==============================================================*/
/* Index: DokumentSprzedazy_PK                                  */
/*==============================================================*/
create unique index DokumentSprzedazy_PK on DokumentSprzedazy (
  id_dokumentSprzedazy
);

/*==============================================================*/
/* Index: FK_Pracownik_DokumentSprzedazy_                       */
/*==============================================================*/
create  index FK_Pracownik_DokumentSprzedazy_ on DokumentSprzedazy (
  id_pracownik
);

/*==============================================================*/
/* Table: Dostawa                                               */
/*==============================================================*/
create table Dostawa (
  id_dostawa           INT4                 not null,
  id_produkt           INT4                 null,
  id_dostawca          INT4                 null,
  Ilosc_produktu       INT4                 null,
  Data_dostawy         DATE                 null,
  Data_w_zamowienia    DATE                 null,
  id_zamowienie        INT4                 null,
  constraint PK_DOSTAWA primary key (id_dostawa)
);

/*==============================================================*/
/* Index: Dostawa_PK                                            */
/*==============================================================*/
create unique index Dostawa_PK on Dostawa (
  id_dostawa
);

create  index FK_Zamowienie_Dostawa_FK on Dostawa (
  id_zamowienie
);

/*==============================================================*/
/* Index: FK_Dostawca_Dostawa_FK                                */
/*==============================================================*/
create  index FK_Dostawca_Dostawa_FK on Dostawa (
  id_dostawca
);

/*==============================================================*/
/* Index: Produkt_dostawa_FK                                    */
/*==============================================================*/
create  index Produkt_dostawa_FK on Dostawa (
  id_produkt
);

/*==============================================================*/
/* Table: Dostawca                                              */
/*==============================================================*/
create table Dostawca (
  id_dostawca          INT4                 not null,
  Nazwa_dostawcy       CHAR(10)             null,
  constraint PK_DOSTAWCA primary key (id_dostawca)
);

/*==============================================================*/
/* Index: Dostawca_PK                                           */
/*==============================================================*/
create unique index Dostawca_PK on Dostawca (
  id_dostawca
);

/*==============================================================*/
/* Table: Dzial                                                 */
/*==============================================================*/
create table Dzial (
  id_dzial             INT4                 not null,
  nazwa_dzialu         VARCHAR(50)          null,
  constraint PK_DZIAL primary key (id_dzial)
);

/*==============================================================*/
/* Index: Dzial_PK                                              */
/*==============================================================*/
create unique index Dzial_PK on Dzial (
  id_dzial
);




/*==============================================================*/
/* Table: Magazyn                                               */
/*==============================================================*/
create table Magazyn (
  id_magazyn           INT4                 not null,
  Adres_Magazynu       VARCHAR(300)         null,
  constraint PK_MAGAZYN primary key (id_magazyn)
);

/*==============================================================*/
/* Index: Magazyn_PK                                            */
/*==============================================================*/
create unique index Magazyn_PK on Magazyn (
  id_magazyn
);


/*==============================================================*/
/* Table: Marka                                                 */
/*==============================================================*/
create table Marka (
  id_marka             INT4                 not null,
  id_producent         INT4                 null,
  Nazwa_marki          VARCHAR(50)          null,
  constraint PK_MARKA primary key (id_marka)
);

/*==============================================================*/
/* Index: Marka_PK                                              */
/*==============================================================*/
create unique index Marka_PK on Marka (
  id_marka
);

/*==============================================================*/
/* Index: FK_Marka_Producent_FK                                 */
/*==============================================================*/
create  index FK_Marka_Producent_FK on Marka (
  id_producent
);

/*==============================================================*/
/* Table: Pracownik                                             */
/*==============================================================*/
create table Pracownik (
  id_pracownik         INT4                 not null,
  Imie_pracownika      VARCHAR(50)          null,
  Nazwisko_pracownika  VARCHAR(50)          null,
  Email                VARCHAR(150)         null,
  Nr_telefonu          CHAR(12)             null,
  stanowisko           VARCHAR(100)         null,
  constraint PK_PRACOWNIK primary key (id_pracownik)
);

/*==============================================================*/
/* Index: Pracownik_PK                                          */
/*==============================================================*/
create unique index Pracownik_PK on Pracownik (
  id_pracownik
);

/*==============================================================*/
/* Table: Producent                                             */
/*==============================================================*/
create table Producent (
  id_producent         INT4                 not null,
  Nazwa_Producenta     VARCHAR(50)          null,
  constraint PK_PRODUCENT primary key (id_producent)
);

/*==============================================================*/
/* Index: Producent_PK                                          */
/*==============================================================*/
create unique index Producent_PK on Producent (
  id_producent
);

/*==============================================================*/
/* Table: Produkt                                               */
/*==============================================================*/
create table Produkt (
  id_produkt           INT4                 not null,
  id_marka             INT4                 null,
  id_dzial             INT4                 null,
  Nazwa_produktu       VARCHAR(500)          null,
  cena_produktu      DECIMAL(10,3)         null,
  constraint PK_PRODUKT primary key (id_produkt)
);

/*==============================================================*/
/* Index: Produkt_PK                                            */
/*==============================================================*/
create unique index Produkt_PK on Produkt (
  id_produkt
);

/*==============================================================*/
/* Index: FK_Produkt_Marka_FK                                   */
/*==============================================================*/
create  index FK_Produkt_Marka_FK on Produkt (
  id_marka
);

/*==============================================================*/
/* Index: Dzial_Produkt_FK                                      */
/*==============================================================*/
create  index Dzial_Produkt_FK on Produkt (
  id_dzial
);

/*==============================================================*/
/* Table: Sklep                                                 */
/*==============================================================*/
create table Sklep (
  id_sklep             INT4                 not null,
  id_magazyn           INT4                 null,
  Adres_sklepu         VARCHAR(300)         null,
  pozycja_x            DECIMAL(10,6)        null,
  pozycja_y            DECIMAL(10,6)        null,
  constraint PK_SKLEP primary key (id_sklep)
);

/*==============================================================*/
/* Index: Sklep_PK                                              */
/*==============================================================*/
create unique index Sklep_PK on Sklep (
  id_sklep
);

/*==============================================================*/
/* Index: FK_Magazyn_Sklep_FK                                   */
/*==============================================================*/
create  index FK_Magazyn_Sklep_FK on Sklep (
  id_magazyn
);

/*==============================================================*/
/* Table: Sprzedaz                                              */
/*==============================================================*/
create table Sprzedaz (
  id_sprzedaz          INT4                 not null,
  id_sklep             INT4                 null,
  id_dokumentSprzedazy INT4                 null,
  Ilosc_produktu       CHAR(10)             null,
  id_produkt           INT4                 null,
  constraint PK_SPRZEDAZ primary key (id_sprzedaz)
);

/*==============================================================*/
/* Index: Sprzedaz_PK                                           */
/*==============================================================*/
create unique index Sprzedaz_PK on Sprzedaz (
  id_sprzedaz
);

/*==============================================================*/
/* Index: FK_Sklep_Sprzedaz_FK                                  */
/*==============================================================*/
create  index FK_Sklep_Sprzedaz_FK on Sprzedaz (
  id_sklep
);

create  index FK_Produkt_Sprzedaz_FK on Sprzedaz (
  id_produkt
);
/*==============================================================*/
/* Index: FK_DokumentSprzedazy_Sprzedaz_F                       */
/*==============================================================*/
create  index FK_DokumentSprzedazy_Sprzedaz_F on Sprzedaz (
  id_dokumentSprzedazy
);

/*==============================================================*/
/* Table: Zamowienie                                            */
/*==============================================================*/
create table Zamowienie (
  id_zamowienie        INT4                 not null,
  id_dostawca          INT4                 null,
  id_magazyn           INT4                 null,
  ilosc_produktu       INT4                 null,
  Data_zamowienia      DATE                 null,
  id_produkt           INT4                 null,
  Przwidywana_data_dostarczenia DATE                 null,
  constraint PK_ZAMOWIENIE primary key (id_zamowienie)
);

/*==============================================================*/
/* Index: Zamowienie_PK                                         */
/*==============================================================*/
create unique index Zamowienie_PK on Zamowienie (
  id_zamowienie
);

/*==============================================================*/
/* Index: FK_Dostawca_Zamowienie_FK                             */
/*==============================================================*/
create  index FK_Dostawca_Zamowienie_FK on Zamowienie (
  id_dostawca
);

create  index FK_Produkt_Zamowienie_FK on Zamowienie (
  id_produkt
);

/*==============================================================*/
/* Index: Magazyn_dostawa_FK                                    */
/*==============================================================*/
create  index Magazyn_dostawa_FK on Zamowienie (
  id_magazyn
);



create table Users (
  username varchar(100) not null,
  passwd varchar(100) not null,
  constraint pk_users primary key (username)
);

alter table DokumentSprzedazy
  add constraint FK_DOKUMENT_FK_PRACOW_PRACOWNI foreign key (id_pracownik)
references Pracownik (id_pracownik)
on delete restrict on update restrict;

alter table Dostawa
  add constraint FK_DOSTAWA_FK_DOSTAW_DOSTAWCA foreign key (id_dostawca)
references Dostawca (id_dostawca)
on delete restrict on update restrict;

alter table Dostawa
  add constraint FK_DOSTAWA_ZAMOWIENIE foreign key (id_zamowienie)
  references Zamowienie (id_zamowienie)
  on delete restrict on update restrict;

alter table Dostawa
  add constraint FK_DOSTAWA_PRODUKT_D_PRODUKT foreign key (id_produkt)
references Produkt (id_produkt)
on delete restrict on update restrict;



alter table Marka
  add constraint FK_MARKA_FK_MARKA__PRODUCEN foreign key (id_producent)
references Producent (id_producent)
on delete restrict on update restrict;

alter table Produkt
  add constraint FK_PRODUKT_DZIAL_PRO_DZIAL foreign key (id_dzial)
references Dzial (id_dzial)
on delete restrict on update restrict;

alter table Produkt
  add constraint FK_PRODUKT_FK_PRODUK_MARKA foreign key (id_marka)
references Marka (id_marka)
on delete restrict on update restrict;

alter table Sklep
  add constraint FK_SKLEP_FK_MAGAZY_MAGAZYN foreign key (id_magazyn)
references Magazyn (id_magazyn)
on delete restrict on update restrict;

alter table Sprzedaz
  add constraint FK_SPRZEDAZ_FK_DOKUME_DOKUMENT foreign key (id_dokumentSprzedazy)
references DokumentSprzedazy (id_dokumentSprzedazy)
on delete restrict on update restrict;

alter table Sprzedaz
  add constraint FK_SPRZEDAZ_FK_SKLEP__SKLEP foreign key (id_sklep)
references Sklep (id_sklep)
on delete restrict on update restrict;

alter table Sprzedaz
  add constraint FK_PRODUKT_SPRZEDAZ foreign key (id_produkt)
  references Produkt (id_produkt)
  on delete restrict on update restrict;

alter table Zamowienie
  add constraint FK_ZAMOWIEN_FK_DOSTAW_DOSTAWCA foreign key (id_dostawca)
references Dostawca (id_dostawca)
on delete restrict on update restrict;

alter table Zamowienie
  add constraint FK_ZAMOWIEN_MAGAZYN_D_MAGAZYN foreign key (id_magazyn)
references Magazyn (id_magazyn)
on delete restrict on update restrict;

alter table Zamowienie
  add constraint FK_PRODUKT_ZAMOWIENIE foreign key (id_produkt)
  references Produkt (id_produkt)
  on delete restrict on update restrict;

INSERT INTO users(username, passwd)
VALUES ('test', '$2a$10$ezOOJVFQmk7hBvlqI/.htekiETWZKi.QC5.F8Ux9Yh9iVZweVs0gK');

COPY magazyn FROM '/home/csv/magazyn.csv' WITH CSV HEADER;
COPY sklep FROM '/home/csv/sklep.csv' WITH CSV HEADER;
COPY dostawca FROM '/home/csv/dostawca.csv' WITH CSV HEADER;
COPY producent FROM '/home/csv/producent.csv' WITH CSV HEADER;
COPY marka FROM '/home/csv/marka.csv' WITH CSV HEADER;
COPY dzial FROM '/home/csv/dzial.csv' WITH CSV HEADER;
COPY produkt FROM '/home/csv/produkt.csv' WITH CSV HEADER;
COPY pracownik FROM '/home/csv/pracownik.csv' WITH CSV HEADER;
COPY zamowienie FROM '/home/csv/zamowienie.csv' WITH CSV HEADER;
COPY dostawa FROM '/home/csv/dostawa.csv' WITH CSV HEADER;
COPY dokumentsprzedazy FROM '/home/csv/dokumentsprzedazy.csv' WITH CSV HEADER;
COPY sprzedaz FROM '/home/csv/sprzedaz.csv' WITH CSV HEADER;
