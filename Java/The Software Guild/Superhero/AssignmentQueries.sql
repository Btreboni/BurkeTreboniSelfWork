/*A user must be able to record a superhero/supervillian sighting for a particular location and date.*/
use superhero;

/*Sighting*/
/*SQL_SELECT_ALL _SIGHTINGS_BY_LOCATION*/
/*ENTERED*/
/*INSERT METHOD*/
select si.* 
from sighting si
	join location l on si.locationId = l.locationId
where l.locationId = 1;

/*Sighting*/
/*SQL_SELECT_ALL _SIGHTINGS_BY_DATE*/
/*DOESN"T WORK*/
/*ENTERED*/
select si.date, s.*, l.*
from sighting si
	join super_sighting ss on si.superId = ss.superId
    join `super` s on si.superId = s.superId
    join location l on si.locationId = l.locationId
where si.date = '07042017';


/*The system must be able to report all of the superheros sighted at a particular location.*/

/*SQL_SELECT_ALL_SUPER_BY_LOCATION*/

/*Sighting*/
/*ENTERED*/
select s.*, l.locationId, l.locationName
from `super` s
	join super_sighting ss on s.superId = ss.superId
    join sighting si on ss.sightingId = si.sightingId
    join location l on si.locationId = si.locationId
where l.locationId = 1;



/*The system must be able to report all of the locations where a particular superhero has been seen.*/

/*SQL_SELECT_ALL_LOCATIONS_BY_SUPER*/
/*Locations*/
/*ENTERED*/
select s.superId, s.superName, l.*
from location l
	join sighting si on l.locationId = si.locationId
    join super_sighting ss on si.sightingid = ss.sightingId
    join `super` s on ss.superId = s.superId
where s.superId = 1;
    


/*The system must be able to report all sightings (hero and location) for a particular date.*/

/*NOT WORKING*/
/*SQL_SELECT_ALL_SIGHTINGS_BY_DATE*/
/*Sighting*/

/*differenciate between this and first one?*/
select si.*, s.*, l.*
from sighting si
	join super_sighting ss on si.sightingId = ss.sightingId
    join `super` s on ss.superId = s.superId
    join location l on si.locationId = l.locationId
where si.sightingDate = '01010001';


/*The system must be able to report all of the members of a particular organization.*/

/*SQL_SELECT_ALL_SUPER_BY_ORGANIZATION*/
/*super_organization*/
select o.organizationId, o.organizationName, s.superId, s.superName
from `super` s
	join super_organization so on s.superId = so.superId
    join organization o on so.organizationId = o.organizationId
where so.organizationId = 1;

/*The system must be able to report all of the organizations a particular superhero/villian belongs to.*/

/*SQL_SELECT_ALL_ORGANIZATION_BY_SUPER*/
/*super_organization*/
select s.superId, s.superName, o.organizationId, o.organizationName
from organization o
	join super_organization so on o.organizationId = so.organizationId
    join `super`s on so.superId = s.superId
where so.superId = 1;

/*NEW*/




select s.superId, s.superName, superDescription, sp.superPowerName, o.organizationName 
from `super` s
	join super_power sp on s.superPowerId = sp.superpowerId
	join super_organization so on s.superId = so.superId
    join organization o on so.organizationId = o.organizationId
    limit 10;
    
 use superhero;   
    
select l.locationName, s.superName, o.organizationName, si.sightingDate
from sighting si
	inner join location l on si.locationId = l.locationId
    inner join super_sighting ss on si.sightingId = ss.sightingId
    inner join `super` s on ss.superId = s.superId
    inner join super_power sp on s.superPowerId  = sp.superPowerId 
    inner join super_organization so on s.superId= so.superId
    inner join organization o on so.organizationId = o.organizationId
where si.sightingDate = '2017-01-04';
    
    


