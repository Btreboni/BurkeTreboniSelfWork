/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DVDDaoFileImpl implements DVDDao {

    //Member Variables.
    private static final String DVD_TEXT_FILE_STRING_TEMP = ""
            + "DVDFileTemp.txt";
    private static final String DVD_TEXT_FILE_STRING = ""
            + "DVDFile.txt";

    private Logger logger = Logger.getLogger(DVDDaoFileImpl.class.getName());

    /* This is our constructor for this class. 
    // Now anytime someone does  new DVDDaoFileImpl, its going to do 
    // this.out = new PrintWriter...
    public DVDDaoFileImpl() {
         */
    @Override
    //Our DAO can give us the ability to add a disk to the file. 
    // We are trying to add this date (disk ID, disk) to the file. 

    public DVD addDisk(String diskID, DVD disk) {
        // We are going to be adding the information to the file. 

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(DVD_TEXT_FILE_STRING, true)));
            //This is calling the toString method which contains all of the data
            // from DVD in a format that we've decided, and the data string 
            // (how the data will look in the file (1||Name||ReleaseDate||rating) within the file). 
            out.println(disk.toString());
            out.close();

            //The catch is saying that we are going to catch the IO exception that
            // we previously threw, and deal with it. 
        } catch (IOException ex) {
            Logger.getLogger(DVDDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return disk;

    }

    @Override
    public List<DVD> getAllDVDs() {

        ArrayList<DVD> arrayList = new ArrayList<DVD>();

        try {
            //We are going to be reading the content of the file.
            BufferedReader br = new BufferedReader(new FileReader(DVD_TEXT_FILE_STRING));

            String line = null;
            while ((line = br.readLine()) != null) {
                //Seperation of data.
                String[] dvdData = line.split("\\|\\|");

                DVD dvd = new DVD();
                dvd.setDvdId(dvdData[0]);
                dvd.setDvdTitle(dvdData[1]);
                dvd.setReleaseDate(dvdData[2]);
                dvd.setRating(dvdData[3]);
                dvd.setDirectorName(dvdData[4]);
                dvd.setStudio(dvdData[5]);
                dvd.setUserRatingOrNotes(dvdData[6]);
                arrayList.add(dvd);
            }

            try {
                br.close();
            } catch (IOException ex) {
                //Logger is the comment structure for programmers. You can change 
                //the severe key. 
                logger.log(Level.SEVERE, "An exception occurred while attempting to close the BufferedReader in getAllDvds()", ex);
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "An exception occurred while reading the file within getAllDvds()", ex);
        }

        return arrayList;
    }

    @Override
    public DVD getDiskByTitle(String diskTitle) {
        // We are going to be reading the content of a single disk
        // within the file. 
        // 
        List<DVD> allDvds = getAllDVDs();

        for (DVD dvd : allDvds) {
            if (dvd.getDvdTitle().equals(diskTitle)) {
                return dvd;
            }
        }

        return null;
    }

    @Override
    public DVD getDiskById(String diskId) {
        // We are going to be reading the content of a single disk
        // within the file. 
        // 
        List<DVD> allDvds = getAllDVDs();

        for (DVD dvd : allDvds) {
            if (dvd.getDvdId().equals(diskId)) {
                return dvd;
            }
        }

        return null;
    }

    @Override
    public void removeDisk(String diskId) {
        // We are going to be removing the content for a disk in the file. 
        /*DVD removedDVD = dvd.remove(studentId);
        return removedStudent;*/

        try {
            File inputFile = new File(DVD_TEXT_FILE_STRING);
            File tempFile = new File(DVD_TEXT_FILE_STRING_TEMP);

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String dvdIdIndicator = diskId + DVD.DVD_SPACING_TOKEN;
                if (!currentLine.startsWith(dvdIdIndicator)) {

                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();
            boolean successful = tempFile.renameTo(inputFile);

        } catch (Exception ex) {

        }
        
    }

    @Override
    public void editDisk(DVD editDVD) {
        
            
        try {
            File inputFile = new File(DVD_TEXT_FILE_STRING);
            File tempFile = new File(DVD_TEXT_FILE_STRING_TEMP);

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String dvdIdIndicator = editDVD.getDvdId() + DVD.DVD_SPACING_TOKEN;
                if (!currentLine.startsWith(dvdIdIndicator)) {

                    writer.write(currentLine + System.getProperty("line.separator"));
                } else {
                    writer.write(editDVD.toString() + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();
            boolean successful = tempFile.renameTo(inputFile);

        } catch (Exception ex) {

        }

    }

}
