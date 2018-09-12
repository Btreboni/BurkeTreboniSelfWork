/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDDao;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.service.DVDLibraryServiceLayer;
import com.sg.dvdlibrary.ui.DVDView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class DVDController {

    DVDLibraryServiceLayer service;
    DVDView view;

    //private final DVDView view = new DVDView();
    private final UserIO io = new UserIOConsoleImpl();
    //private final DVDDao service = new DVDDaoFileImpl();

    public DVDController(DVDLibraryServiceLayer service, DVDView view) {
        this.view = view;
        this.service = service;
    }

    public void run() {

        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {

                case 1:
                    createDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    editDVD();
                    break;
                case 4:
                    listDVDS();
                    break;
                case 5:
                    //By ID #
                    viewDVDById();
                    break;
                case 6:
                    //By title request of user.
                    viewDVDByTitle();
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndSelection();

    }

    private void createDVD() {

        try {
            view.displayCreateDVDBanner();
            DVD newDVD = view.getNewDVDInfo();
            service.createDVD(newDVD);
            view.displayCreateSuccessBanner();
        } catch (Exception e) {
            view.displayErrorMessage(e);
        }
    }

    private void listDVDS() {

        try {
            view.displayDisplayAllBanner();
            List<DVD> dvdList = service.getAllDVDs();
            view.displayDVDList(dvdList);
        } catch (Exception e) {
            view.displayErrorMessage(e);
        }

    }

    private void viewDVDByTitle() {
        try {
            view.displayDisplayDvdByTitleBanner();
            String dvdTitle = view.getDvdTitleChoice();
            DVD dvd = service.getDVDByTitle(dvdTitle);
            view.displayDVD(dvd);
        } catch (Exception e) {
            view.displayErrorMessage(e);
        }
    }

    private void viewDVDById() {
        try {
            view.displayDisplayDvdByIdBanner();
            String dvdId = view.getDvdIdChoice();
            DVD dvd = service.getDVD(dvdId);
            view.displayDVD(dvd);
        } catch (Exception e) {
            view.displayErrorMessage(e);
        }
    }

    private void removeDVD() {
        try {
            view.displayRemoveDVDBanner();
            String removeDVD = view.getDvdIdChoice();
            service.removeDVD(removeDVD);
            view.displayRemovedDVDSuccessBanner();
        } catch (Exception e) {
            view.displayErrorMessage(e);
        }

    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void editDVD() {
        try {
            view.displayEditDVDBanner();
            DVD editDVD = view.getNewDVDInfo();
            service.editDVD(editDVD);
            view.displayEditDVDSuccessBanner();
        } catch (Exception e) {
            view.displayErrorMessage(e);
        }

    }

}
