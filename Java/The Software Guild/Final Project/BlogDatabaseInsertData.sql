use BlogDatabase;

insert into StaticPage(StaticPageID, StaticPageName, StaticPageContent, NavIndex) values
	(1, 'Happy Holidays', 'Merry Christmas Everyone!', 1),
    (2, 'About Us', 'We are a new Blog Website, and we appreciate you choosing us. We started in 2017, and plan to be around until the year 5000A.D.!', 2),
    (3, 'Contact Us', 'You can always reach us at ptoner@gmail.com, or at 330-830-3004', 3),
    (4, 'FAQ', 'Q: Are you guys awesome? A: Of Course', 4),
    (5, 'Report A Post', 'Should you have an issue with someone elses post, please leave us a message at ptoner@gmail.com, and we will get to it as soon as possible', 5);

insert into Category(CategoryID, CategoryName) values
	(1, 'Music'),
    (2, 'Video Games'),
    (3, 'Food'),
    (4, 'Movies'),
    (5, 'Sports');
    
insert into Tag(TagID, TagName) values
	(1, '#AkronOHIO'),
    (2, '#Diablo'),
    (3, '#Italian'),
    (4, '#VinceVaughn'),
    (5, '#KingJames');
    
insert into Image(ImageID, ImageName, Image) values
	(1, 'The Black Keys', 'BlackKeys.jpeg'),
    (2, 'Diablo', 'Diablo.jpeg'),
    (3, 'Spaghetti', 'Spaghetti.jpeg'),
    (4, 'Wedding Crashers', 'WeddingCrashers.jpeg'),
    (5, 'King James', 'James.jpeg'),
    /*above are all pics for the blog. Below are people*/
    (6, 'DanAurenbachProfile', 'DanA.jpeg'),
    (7, 'ChristopherWalkenProfile', 'Walken.jpeg'),
    (8, 'WillLopezProfile', 'WillLopez.jpeg'),
    (9, 'WillFerrelProfile', 'WillFerrel.jpeg'),
    (10, 'LebronJameProfile', 'James.jpeg');
    
insert into `User`(UserID, UserName, UserPassword, ImageID, IsActive) values
	(1, 'Dan Aurenbach', 'blackKeys', 6, 0),
    (2, 'Christopher Walken', 'cowbell', 7, 0),
    (3, 'Will Lopez', 'theEarthIsFlatGuys',8, 1),
    (4, 'Will Ferrel', 'ronBerg', 9, 1),
    (5, 'Lebron James', 'king', 10, 1);
    
insert into BlogPost(BlogPostID, BlogTitle, StartDate, EndDate, BlogContent, IsActive, ImageID, UserID) values
	(1, 'The Black Keys: from Akron', 20170720, 20170920, 'The Black Keys are a band out of Akron, Ohio. It is just a shame they never stopped by the Guild!', 1, 1, 1),
    (2, 'Diablo; Game of the Year?', 20170719, 20171019, 'Everyone is raving about this Diablo game. Is it really that big of a deal in the gaming community?', 1, 2, 2),
    (3, 'Will and his Spaghetti', 20170714, null, 'I was just kidding when I said I HATE Spaghetti. It is actually quite enjoyable.', 1, 3, 3),
    (4, 'Stage 5 Clinger', 20170701, null, 'Ever wonder what to do when you have a stage 5 clinger? Well, here are the guidelines...', 1, 4, 4),
    (5, 'Championship in the Land', 20170517, 20171228, 'Even though the CAVS could not pull it out this year, is next year the year?', 0, 5, 5);    
    
insert into `Comment`(CommentID, CommentContent, CommentDate, UserID, BlogPostID) values
	(1, 'I saw these guys last year in Columbus. They were awesome!', 20170721, 2, 1),
    (2, 'DO NOT buy this game. Your life will be over once you turn it on', 20170721, 5, 2),
    (3, 'I like you man, but youre CRAZY!', 20170715, 4, 3),
    (4, 'Never leave a fellow crasher behind... Rule #7', 20170703, 1, 4),
    (5, 'I believe in you!!', 20170622, 3, 5),
    (6, 'You are crazy not to like Spaghetti!', 20170716, 2, 3),
    (7, 'This game was awesome!', 20170722, 2, 2),
    (8, 'I cannot wait untill they play in Cleveland this year', 20170723, 5, 1),
    (9, 'Cannot wait until next season. Bring home the trophy', 20170624, 4, 5),
    (10, 'CRAB CAKES AND FOOTBALL... THATS WHAT MARYLAND DOES!', 20170703, 3, 4);
    
insert into BlogPostCategoryBridge(BlogPostCategoryBridgeID, BlogPostID, CategoryID) values
	(1, 1, 1),
    (2, 2, 2),
    (3, 3, 3),
    (4, 4, 4),
    (5, 5, 5);
    
    
insert into PostTagBridge() values
	(1, 1, 1),
    (2, 2, 2),
    (3, 3, 3),
    (4, 4, 4),
    (5, 5, 5);