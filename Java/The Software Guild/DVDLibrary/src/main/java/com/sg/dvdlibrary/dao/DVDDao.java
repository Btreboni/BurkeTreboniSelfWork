/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author admin
 */
public interface DVDDao {

   /**
    * Adds the given Student to the roster and associates it with the given 
    * student id. If there is already a student associated with the given 
    * student id it will return that student object, otherwise it will 
    * return null.
    * 
    * @param diskID
    * @param disk
    * @return the Student object previously associated with the given  
    * student id if it exists, null otherwise
    */
   public DVD addDisk(String diskID, DVD disk);

   /**
    * Returns a String array containing the student ids of all 
    * students in the roster.
    * 
    * @return String array containing the ids of all the students 
    * in the roster
    */
   public List<DVD> getAllDVDs();

   /**
    * Returns the student object associated with the given student id.
    * Returns null if no such student exists
    * 
    * @param diskId
    * @return the Student object associated with the given student id,  
    * null if no such student exists
    */
   public DVD getDiskByTitle(String diskTitle);

   /**
    * Removes from the roster the student associated with the given id. 
    * Returns the student object that is being removed or null if 
    * there is no student associated with the given id
    * 
    * @param diskId
    * @return Student object that was removed or null if no student 
    * was associated with the given student id
    */
   public void removeDisk(String diskId);

   public DVD getDiskById(String diskId);
   
   public void editDisk(DVD editDVD);
	
}
