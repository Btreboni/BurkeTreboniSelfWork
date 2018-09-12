/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDAuditDao;
import com.sg.dvdlibrary.dao.DVDDao;
import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author admin
 */
public class DVDLibraryServiceLayerImpl implements DVDLibraryServiceLayer {

    private final DVDDao dao;
    private final DVDAuditDao auditDao;

    public DVDLibraryServiceLayerImpl(DVDDao dao, DVDAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    /* HERE IS WHERE YOU HAVE A PROBLEM!!! OR WHERE IT STARTED!! */
    public void createDVD(DVD dvd) throws DVDLibraryDuplicateIdException,
            DVDLibraryDataValidationException, DVDLibraryPersistenceException {
        if (dao.getDiskById(dvd.getDvdId()) != null) {
            throw new DVDLibraryDuplicateIdException("Error could not create DVD. "
                    + "DVD ID " + dvd.getDvdId() + " already exists");
        }
        validateDVDData(dvd);
        dao.addDisk(dvd.getDvdId(), dvd);

        auditDao.writeAuditEntry("DVD" + dvd.getDvdId() + " : " + " CREATED. ");
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryPersistenceException {
        return dao.getAllDVDs();
    }

    @Override
    public DVD getDVD(String dvdId) throws DVDLibraryPersistenceException {
        return dao.getDiskById(dvdId);
    }

    @Override
    public void removeDVD(String diskId) throws DVDLibraryPersistenceException {
        auditDao.writeAuditEntry("DVD" + diskId + " : "  + " REMOVED. ");
        dao.removeDisk(diskId);
    }

    private void validateDVDData(DVD dvd) throws DVDLibraryDataValidationException {
        //Making sure that none of the fields are null or empty.

        if (dvd.getDvdId() == null || dvd.getDvdId().trim().length() == 0
                || dvd.getDvdTitle() == null || dvd.getDvdTitle().trim().length() == 0
                || dvd.getReleaseDate() == null || dvd.getReleaseDate().trim().length() == 0
                || dvd.getRating() == null || dvd.getRating().trim().length() == 0
                || dvd.getDirectorName() == null || dvd.getDirectorName().trim().length() == 0
                || dvd.getStudio() == null || dvd.getStudio().trim().length() == 0
                || dvd.getUserRatingOrNotes() == null || dvd.getRating().trim().length() == 0) {

            throw new DVDLibraryDataValidationException("ERROR: ALL FIELDS ARE REQUIRED");
        }

    }

    @Override
    public DVD getDVDByTitle(String dvdTitle) throws DVDLibraryPersistenceException {
        return dao.getDiskByTitle(dvdTitle);
    }

    @Override
    public void editDVD(DVD editDVD) {
        dao.editDisk(editDVD);
    }
}
