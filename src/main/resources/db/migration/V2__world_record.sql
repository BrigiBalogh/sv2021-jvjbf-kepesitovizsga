create table world_record (id bigint not null auto_increment,
                            description varchar(255),
                            value double precision ,
                            unit_of_measure varchar(255),
                            date_of_record date,
                            recorder_id bigint,
                            primary key (id),
                            foreign key (recorder_id) references recorder (id));


