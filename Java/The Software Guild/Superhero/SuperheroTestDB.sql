drop database if exists superheroTest;
create database superheroTest;

use superheroTest;

create table superheroTest.`super` (
	superId int not null auto_increment,
    superName varchar(50) not null,
    superDescription varchar (500) not null,
    superPowerId int (50) not null,
    primary key (superId)
);

create table superheroTest.super_power (
	superPowerId int not null auto_increment,
    superPowerName varchar (50) not null,
    primary key (superPowerId)
);

create table superheroTest.location (
	locationId int not null auto_increment,
    locationName varchar(50) not null,
    locationDescription varchar(200) not null,
    locationAddress varchar(50) not null,
    locationLatitude double not null,
    locationLongitude double not null,
    primary key (locationId)
);

create table superheroTest.organization (
	organizationId int not null auto_increment,
    organizationName varchar (50) not null,
    organizationDescription varchar (200) not null,
    organizationAddress varchar(50) not null,
    organizationPhone varchar(10) not null,
    organizationEmail varchar(50) not null,
    primary key (organizationId)
);

create table superheroTest.super_organization (
	superOrganizationId int not null auto_increment,
	superId int not null,
    organizationId int not null,
    primary key (superOrganizationId)
);

create table superheroTest.sighting (
	sightingId int not null auto_increment,
    sightingDate date not null,
    locationId int not null,
    primary key (sightingId)
);

create table superheroTest.super_sighting (
	superSightingId int not null auto_increment,
	superId int not null,
    sightingId int not null,
    primary key (superSightingId)
);

/*Foreign Keys*/

alter table superheroTest.`super`
	add foreign key (superPowerId)
    references superheroTest.super_power(superPowerId);
    
alter table superheroTest.super_organization 
	add foreign key (superId) 
    references superheroTest.`super`(superId);
    
alter table superheroTest.super_organization 
	add foreign key (organizationId) 
	references superheroTest.organization(organizationId);
    
alter table superheroTest.sighting 
	add foreign key (locationId) 
	references superheroTest.location(locationId);
    
alter table superhero.super_sighting 
	add foreign key (superId)
    references superheroTest.`super`(superId);
    
alter table superheroTest.super_sighting
	add foreign key (sightingId)
    references superheroTest.sighting(sightingId);
