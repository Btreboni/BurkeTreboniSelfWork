set SQL_SAFE_UPDATES = 0;
drop database if exists BlogDatabase_Test;
create database BlogDatabase_Test;
use BlogDatabase_Test;

create table if not exists Tag (
TagID bigint not null auto_increment,
TagName varchar(50) not null,
primary key (TagID)
)engine=innodb default charset=LATIN1 auto_increment=1; 

create table if not exists StaticPage (
StaticPageID bigint not null auto_increment,
StaticPageName varchar(30) not null,
StaticPageContent longtext not null,
NavIndex int not null,
primary key(StaticPageID)
)engine=innodb default charset=LATIN1 auto_increment=1; 

create table if not exists Category (
CategoryID bigint not null auto_increment,
CategoryName varchar(30) not null,
primary key (CategoryID)
)engine=innodb default charset=LATIN1 auto_increment=1; 

create table if not exists Image (
ImageID bigint not null auto_increment,
ImageName varchar(30) not null,
Image longblob not null,
primary key (ImageID)
)engine=innodb default charset=LATIN1 auto_increment=1; 

create table if not exists `User` (
UserID bigint not null auto_increment,
UserName varchar (30) not null unique,
UserPassword varchar(100) not null,
ImageID bigint null,
IsActive bool default 1 not null,
primary key(UserID)
)engine=innodb default charset=LATIN1 auto_increment=1; 

CREATE TABLE IF NOT EXISTS Authority (
AuthorityID bigint not null auto_increment,
UserID bigint NOT NULL,
Authority varchar(20) NOT NULL,
primary key (AuthorityID)
) engine=innodb default charset=LATIN1 auto_increment=1; 

create table if not exists BlogPost (
BlogPostID bigint not null auto_increment,
BlogTitle varchar(50) not null,
StartDate date not null,
EndDate date null,
BlogContent longtext not null,
IsActive bool default 0 not null,
ImageID bigint null,
UserID bigint null, -- NULL FOR NOW
primary key (BlogPostID)
)engine=innodb default charset=LATIN1 auto_increment=1; 

create table if not exists `Comment` (
CommentID bigint not null auto_increment,
CommentContent longtext not null,
CommentDate date not null,
UserID bigint not null,
BlogPostID bigint not null,
primary key (CommentID)
)engine=innodb default charset=LATIN1 auto_increment=1; 

create table if not exists PostTagBridge (
PostTagBridgeID bigint not null auto_increment,
BlogPostID bigint not null,
TagID bigint not null,
primary key (PostTagBridgeID)
)engine=innodb default charset=LATIN1 auto_increment=1; 

create table if not exists BlogPostCategoryBridge (
BlogPostCategoryBridgeID bigint not null auto_increment,
BlogPostID bigint not null,
CategoryID bigint not null,
primary key (BlogPostCategoryBridgeID)
)engine=innodb default charset=LATIN1 auto_increment=1; 


  -- add foreign keys

alter table BlogPost 
add constraint BlogPostImageID foreign key (ImageID) references Image (ImageID),
add constraint BlogPostUserID foreign key (UserID) references `User` (UserID);

alter table `User`
add constraint UserImageID foreign key (ImageID) references Image (ImageID);

alter table Authority
add constraint AuthorityUserID foreign key (UserID) references `User` (UserID);

alter table `Comment`
add constraint CommentUserID foreign key (UserID) references `User` (UserID),
add constraint CommentBlogPostID foreign key (BlogPostID) references BlogPost (BlogPostID);

alter table PostTagBridge
add constraint PostTagBlogPostID foreign key (BlogPostID) references BlogPost (BlogPostID),
add constraint PostTagTagID foreign key (TagID) references Tag (TagID);

alter table BlogPostCategoryBridge 
add constraint BlogPostCategoryBridgeBlogPostID foreign key (BlogPostID) references BlogPost (BlogPostID),
add constraint BlogPostCategoryBridgeCategoryID foreign key (CategoryID) references Category (CategoryID);