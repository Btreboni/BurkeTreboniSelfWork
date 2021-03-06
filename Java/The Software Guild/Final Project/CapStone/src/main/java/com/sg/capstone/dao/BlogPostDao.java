/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.dao;

import com.sg.capstone.model.BlogPost;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author admin
 */
public interface BlogPostDao {

    public void addBlogPost(BlogPost blogPost);

    public void deleteBlogPost(Long blogPostID);

    public void updateBlogPost(BlogPost blogPost);

    public BlogPost getBlogPostById(Long blogPostID);

    public BlogPost getBlogPostByBlogPostCategoryBridgeID(Long blogPostCategoryBridgeID);

    public List<BlogPost> getAllBlogPosts();

    public List<BlogPost> getAllActiveBlogPosts();

    public List<BlogPost> getAllActiveUnexpiredBlogPosts();

    public List<BlogPost> getAllBlogPostsByCategoryID(Long categoryID);

    public List<BlogPost> getAllBlogPostsByUserID(Long userID);

    public List<BlogPost> getAllBlogPostsByTagID(Long tagID);

    public List<BlogPost> getAllBlogPostsByDate(LocalDate date);

    public List<BlogPost> getAllBlogPostByActive(boolean isActive);

    public void setIsActiveToInActive(long blogPostID);

    public void setIsActiveToActive(long blogPostID);

}
