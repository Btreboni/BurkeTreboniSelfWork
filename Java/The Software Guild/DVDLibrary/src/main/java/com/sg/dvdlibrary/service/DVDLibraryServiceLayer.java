/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author admin
 */
public interface DVDLibraryServiceLayer {

    /*UNIT TESTING!
    CreateDVD takes a Student objoect so it has pa
  <>** DVDLibraryDuplicateIdException =  If the id comming in on the DVD that gets
    passed to our create student method, this exception will be thrown, 
    
  <>**DVDLibraryDataValidationException = This will get thrown if the DVD that comes in
    (passed into our method here, if it comes in and has any empty fields, this e
    exception will get thrown.
    
  <>**DVDLibrary PersistanceException = This will get thrown if we have any issue with
    the underwriting of the DAO. 
    
     */
    public void createDVD(DVD dvd) throws DVDLibraryDuplicateIdException,
            DVDLibraryDataValidationException,
            DVDLibraryPersistenceException;

    public List<DVD> getAllDVDs() throws DVDLibraryPersistenceException;

    public DVD getDVD(String dvdId) throws DVDLibraryPersistenceException;
    
    public DVD getDVDByTitle(String dvdTitle) throws DVDLibraryPersistenceException;

    public void removeDVD(String dvdId) throws DVDLibraryPersistenceException;

    public void editDVD(DVD editDVD) throws DVDLibraryPersistenceException;

}
