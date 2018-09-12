/*BLOG POST QUERIES*/

/*getBlogPostByCategoryID*/
use BlogDatabase;
select *
from BlogPost bp
	join BlogPostCategory pc on bp.BlogPostID = pc.BlogPostID
    join Category c on pc.CategoryID = c.CategoryID
where c.CategoryID = 1;
    

/*getBlogPostByUserID*/
use BlogDatabase;
select *
from BlogPost bp
	join `User` u on bp.UserID = u.UserID
where u.UserID = 1;


/*getBlogPostByTagID*/
use BlogDatabase;
select *
from BlogPost bp
	join PostTag pt on bp.BlogPostID = pt.BlogPostID
    join Tag t on pt.TagID = t.TagID
where t.TagID = 1;


/*getBlogPostByDate*/
use BlogDatabase;
select *
from BlogPost bp
where bp.StartDate = 20000301
ORDER BY bp.StartDate;

/*IMAGE QUIERIES*/

/*GET_TAG_BY_BLOGPOSTID*/
use BlogDatabase;
select i.*
from Image i
	join BlogPost bp on i.ImageID = bp.ImageID
    join `User` u on i.ImageID = u.ImageID
where bp.BlogPostId = 1;

/*COMMENT*/
/*SQL_SELECT_COMMENT_BY_BLOGPOST*/
use BlogDatabase;
select c.*
from `Comment` c
	join BlogPost bp on c.BlogPostID = bp.BlogPostID
    join `User` u on c.UserID = u.UserID
where bp.BlogPostID = 1;

/*SQL_SELECT_COMMENT_BY_USERID*/
select c.*
from `Comment` c
	join BlogPost bp on c.BlogPostID = bp.BlogPostID
    join `User` u on c.UserID = u.UserID
where u.UserID = 1;

/*SQL_GET_BY_BLOG_POST_AND_CATEGORYIDS*/
use BlogDatabase;
select bpc.BlogPostCategoryID
from BlogPostCategory bpc
	join BlogPost bp on bpc.BlogPostID = bp.BlogPostID
    join Category c on bpc.CategoryID = c.CategoryID
where bp.BlogPostID = 1 & c.CategoryID = 1;

/*SQL_GET_IMAGE_BY_BLOGPOSTID */
use BlogDatabase;
select i.ImageID
from Image i
	inner join BlogPost bp on i.ImageID = bp.ImageID
where bp.BlogPostID = 1;

/*SQL_SELECT_TAG_BY_BLOGPOST_ID*/
use BlogDatabase;
select t.*
from Tag t
	inner join PostTagBridge bridge on t.TagID = bridge.TagID
    inner join BlogPost bp on bridge.BlogPostID = bp.BlogPostID
where bp.BlogPostID = 1;

/*SQL_GET_BLOG_POST_BY_ACTIVE*/
use BlogDatabase;
select bp.BlogPostID
from BlogPost bp
where bp.IsActive = 1;

/*SQL_UPDATE_BLOG_POST_TO_INACTIVE*/
update BlogPost
set IsActive = 0
where BlogPostID = 2;

/*SQL_UPDATE_BLOG_POST_TO_ACTIVE*/
update BlogPost
set IsActive = 1
where BlogPostID = 2;

/*image query*/
use BlogDatabase;
select * 
from Image;

select *
from `User`;

