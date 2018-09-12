drop database if exists superhero;
create database superhero;

create table superhero.`super` (
	superId int not null auto_increment,
    superName varchar(50) not null,
    superDescription varchar (500) not null,
    superPowerId int (50) not null,
    primary key (superId)
);

create table superhero.super_power (
	superPowerId int not null auto_increment,
    superPowerName varchar (50) not null,
    primary key (superPowerId)
);

create table superhero.location (
	locationId int not null auto_increment,
    locationName varchar(50) not null,
    locationDescription varchar(200) not null,
    locationAddress varchar(50) not null,
    locationLatitude double not null,
    locationLongitude double not null,
    primary key (locationId)
);

create table superhero.organization (
	organizationId int not null auto_increment,
    organizationName varchar (50) not null,
    organizationDescription varchar (200) not null,
    organizationAddress varchar(50) not null,
    organizationPhone varchar(10) not null,
    organizationEmail varchar(50) not null,
    primary key (organizationId)
);

create table superhero.super_organization (
	superOrganizationId int not null auto_increment,
	superId int not null,
    organizationId int not null,
    primary key (superOrganizationId)
);

create table superhero.sighting (
	sightingId int not null auto_increment,
    sightingDate date not null,
    locationId int not null,
    primary key (sightingId)
);

create table superhero.super_sighting (
	superSightingId int not null auto_increment,
	superId int not null,
    sightingId int not null,
    primary key (superSightingId)
);

/*Foreign Keys*/

alter table superhero.`super`
	add foreign key (superPowerId)
    references superhero.super_power(superPowerId)
    on delete cascade;
    
alter table superhero.super_organization 
	add foreign key (superId) 
    references superhero.`super`(superId)
    on delete cascade;
    
alter table superhero.super_organization 
	add foreign key (organizationId) 
	references superhero.organization(organizationId)
    on delete cascade;
    
alter table superhero.sighting 
	add foreign key (locationId) 
	references superhero.location(locationId)
    on delete cascade;
    
alter table superhero.super_sighting 
	add foreign key (superId)
    references superhero.`super`(superId)
    on delete cascade;
    
alter table superhero.super_sighting
	add foreign key (sightingId)
    references superhero.sighting(sightingId)
    on delete cascade;

    
    
    