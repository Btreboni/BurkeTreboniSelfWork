/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dto;

/**
 *
 * @author admin
 */
public class DVD {

    private String dvdId;
    private String dvdTitle;
    private String releaseDate;
    private String rating;
    private String directorName;
    private String studio;
    private String userRatingOrNotes;

    //I won't need all of these probably.
    public DVD(String dvdId) {
        this.dvdId = dvdId;

    }
    
    public static final String DVD_SPACING_TOKEN = "||";

    public DVD() {
    }

    @Override
    public String toString() {
        //move to DAO. 
        return dvdId + DVD_SPACING_TOKEN + dvdTitle + DVD_SPACING_TOKEN + releaseDate + DVD_SPACING_TOKEN 
                + rating + DVD_SPACING_TOKEN + directorName + DVD_SPACING_TOKEN 
                + studio + DVD_SPACING_TOKEN + userRatingOrNotes;
    }

    public String getDvdId() {
        return dvdId;
    }

    public void setDvdId(String dvdId) {
        this.dvdId = dvdId;
    }

    public String getDvdTitle() {
        return dvdTitle;
    }

    public void setDvdTitle(String dvdTitle) {
        this.dvdTitle = dvdTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRatingOrNotes() {
        return userRatingOrNotes;
    }

    public void setUserRatingOrNotes(String userRatingOrNotes) {
        this.userRatingOrNotes = userRatingOrNotes;
    }

}
