/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author admin
 */
public class DVDView {

    public UserIO io;
    //UserIO io = new UserIOConsoleImpl();

    public int printMenuAndSelection() {
        io.print("Welcome To My DVD Library!");
        io.print("~~~~~~~ Main Menu ~~~~~~~");
        io.print("1. Create DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD");
        io.print("4. List DVD's");
        io.print("5. Get DVD by ID Number");
        io.print("6. Get DVD by Title");
        io.print("7. EXIT");

        return io.readInt("Please select from the above choices.", 1, 7);
        //Add into loop. 
    }

    public DVD getNewDVDInfo() {

        String dvdId = io.readString("Please enter the DVD ID ");
        String dvdTitle = io.readString("Please enter the DVD Title ");
        String releaseDate = io.readString("Please enter the DVD Release Year ");
        String rating = io.readString("Please enter the MPAA Rating (G,PG,PG13,or R) ");
        String directorName = io.readString("Please enter the Director's Name ");
        String studio = io.readString("Please enter the DVD's Studio Of Origin ");
        String userRatingOrNotes = io.readString("Please enter a User Rating or Any Notes ");
        DVD currentDVD = new DVD(dvdId);
        currentDVD.setDvdTitle(dvdTitle);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setRating(rating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setRating(rating);
        currentDVD.setUserRatingOrNotes(userRatingOrNotes);
        return currentDVD;

    }

    public void displayCreateDVDBanner() {

        io.print("");
        io.print("=== Create a DVD ===");
        io.print("");

    }

    public void displayCreateSuccessBanner() {

        io.print("");
        io.print("DVD WAS SUCCESSFULLY CREATED. PLEASE HIT ENTER TO CONTINUE. ");

    }

    public void displayDVDList(List<DVD> dvdList) {

        for (DVD dvd : dvdList) {
            io.print("ID #: " + dvd.getDvdId() + " || Title: " + dvd.getDvdTitle()
                    + " ||  Release Date: " + dvd.getReleaseDate() + " || Rating: " + dvd.getRating()
                    + " || Director's Name: " + dvd.getDirectorName() + " || Production Company: "
                    + dvd.getStudio() + " || User Rating or Notes: " + dvd.getUserRatingOrNotes());
        }
        io.readString("");
        io.readString("Please hit enter to continue!");
    }

    public void displayDisplayAllBanner() {
        io.print("");
        io.print("=== Display All DVD's ===");
        io.print("");

    }

    public void displayDisplayDvdByTitleBanner() {
        io.print("");
        io.print("=== Display DVD By Title ===");
        io.print("");
    }

    public void displayDisplayDvdByIdBanner() {
        io.print("");
        io.print("=== Display DVD By ID ===");
        io.print("");
    }

    public String getDvdTitleChoice() {
        io.print("");
        return io.readString("Please enter DVD Title");

    }

    public String getDvdIdChoice() {

        return io.readString("Please enter DVD ID");

    }

    public void displayDVD(DVD dvd) {

        if (dvd != null) {
            io.print("Title: " + dvd.getDvdTitle());
            io.print("Release Date: " + dvd.getReleaseDate() + "|| MPAA Rating: " + dvd.getRating() + " || Director Name: " + dvd.getDirectorName()
                    + " || Production Company: " + dvd.getStudio() + " || User Rating/Notes: " + dvd.getUserRatingOrNotes());
        } else {
            io.print("");
            io.print("Sorry, there is no such DVD in the library.");
            io.print("");
        }
        io.print("");
        io.readString("Please hit enter to continue");
        io.print("");
    }

    public void displayRemoveDVDBanner() {
        io.print("");
        io.print("=== Remove DVD ===");
        io.print("");
    }

    public void displayRemovedDVDSuccessBanner() {
        io.print("");
        io.print("DVD successfully removed. Please hit enter to continue");
        io.print("");

    }

    public void displayExitBanner() {
        io.print("");
        io.print("THANKS FOR CHECKING OUT MY DVD LIBRARY!!!");
        io.print("GOOD BYE!!!");
        io.print("");
    }

    public void displayUnknownCommandBanner() {
        io.print("");
        io.print("UNKNOWN COMMAND!!!");
        io.print("");
    }

    public void displayEditDVDBanner() {
        io.print("");
        io.print("=== Edit DVD ===");
        io.print("");

    }

    public void displayEditDVDSuccessBanner() {
        io.print("");
        io.print("DVD successfully edited. Please hit enter to continue");
        io.print("");
    }

    public DVDView(UserIO io) {
        this.io = io;
    }
    
    public void displayErrorMessage(Exception errorMessage) {
        io.print("An Error Occured.");
        io.print(errorMessage.getMessage());
    }

}
