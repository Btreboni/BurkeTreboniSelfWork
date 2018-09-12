use superhero;


INSERT INTO superhero.organization(organizationId, organizationName, organizationDescription,organizationAddress,
organizationPhone, organizationEmail) VALUES
	(1, 'Legion of Doom', 'These are some bad guys', '123 WrongMove Rd Los Alamos, NM', '1231231234', 'LDOOM@gmail.com'),
    (2, 'Suicide Squad', 'The Joker is nuts', '234 Squad Lane NY,NY', '1231236666', 'SS@gmail.com'),
    (3, 'Bad Guy Inc', 'Group of bad guys', '776 Bad Boy Ave NY,NY', '1231234444', 'BB@gmail.com'),
    (4, 'Bad Girl Inc', 'Group of bad girls', '123 WrongMove Rd  Columbus,OH', '1231233333', 'BG@gmail.com'),
    (5, 'Lex Luthor Corp', 'He has some money!', '123 WrongMove Rd Chicago, IL', '1231230000', 'LL@gmail.com');
    
insert into superhero.location(locationId, locationName, locationDescription, 
    locationAddress, locationLatitude, locationLongitude) values
    (1, 'Columbus, OH', 'It gets crazy', '1730 Park Village Drive', 23.453, -81.565),
    (2, 'NY,NY', 'The Big Apple, ', '123 5th Avenue', 87.09, 78.234),
    (3, 'Chicago, IL', 'The Windy City', '4323 N. Kimbal Ave',  99.0989, 12.2323),
    (4, 'Los Alamos, NM', 'Area 51 is no joke', '432 Manhattan Rd.',23.2343, 65.4543),
    (5, 'Akron, OH', 'I think Pat lives there', '31 E. Main Street',87.099889, 41.234);

insert into superhero.super_power (superPowerId, superPowerName) values
	(1, 'Flight'),
    (2, 'Uses Gadgets'),
    (3, 'Regeneration'),
    (4, 'Invincibility'),
    (5, 'Super Strong');
    
insert into superhero.sighting (sightingId, sightingDate, locationId) values
	(1, '2017/01/04', 1),
    (2, '2017/02/06', 2),
    (3, '2017/03/03', 3),
    (4, '2017/04/02', 4),
    (5, '2017/05/01', 5);
    
insert into superhero.`super`(superId, superName, superDescription, superPowerId) values 
	(1, 'Superman', 'Man of Steel', 1),
    (2, 'Batman', 'Uses gadgets to fight crime', 2),
    (3, 'Harley Quinn', 'She is known to be quite vexing', 2),
    (4, 'The Joker', 'HAHAHAHAHA', 2),
    (5, 'Lex Luthor', 'He is bald and has money', 2);

insert into superhero.super_organization(superOrganizationId, superId, organizationId) values
	(1,1, 5),
    (2, 2, 4),
    (3, 3, 3),
    (4, 4, 2),
    (5, 5, 1);
    
insert into superhero.super_sighting(superSightingId, superId, sightingId) values
	(1, 1, 5),
    (2, 2, 4),
    (3, 3, 3),
    (4, 4, 2),
    (5, 5, 1);