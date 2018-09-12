/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.codingchallenge3.controller;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.StringUtils;
import com.sg.codingchallenge3.view.View;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Controller {

    private View view;

    public Controller(View view) {
        this.view = view;
    }

    private static final String DELIMITER = "'";
    private static final String TXT = ".txt";
    private static final String CSV = ".csv";

    public void runProgram() {
        programSwitch();
    }

    public void programSwitch() {
        Boolean keepGoing = true;
        int menuSelection = 0;

        helloMessage();

        while (keepGoing) {

            menuSelection = menuSelection();

            switch (menuSelection) {

                case 1:
                    programOnDeck();
                    spaceBreak();
                    break;

                case 2:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        goodbyeBanner();
    }

    public void programOnDeck() {

        boolean keepGoing = true;

        String fileName = view.csvTitlePrompt();
        String fileIN = fileName + CSV;
        String fileOUT = fileIN + ".out";

        while (keepGoing) {

            if (fileName.contains(".csv") || StringUtils.isNullOrEmpty(fileName)) {
                csvErrorMessage();
                keepGoing = false;
            } else {
                if (CONVERT_A_FILE(fileIN, fileOUT, true)) {
                    processSuccessBanner(fileIN);
                    spaceBreak();
                } else {
                    fileINErrorBanner(fileIN);
                }

                if (LOAD_A_FILE_TO_MYSQL(fileOUT, "|", "loan_sales_data", "homesideFinancial")) {
                    sqlConfirmationBanner(fileOUT);
                } else {
                    sqlErrorBanner(fileOUT);
                }

                String branchTotalFileName = view.newTXTDocumentNamePrompt();

                if (branchTotalFileName.contains(".txt") || 
                        StringUtils.isNullOrEmpty(branchTotalFileName)) {
                    txtErrorMessage();
                    keepGoing = false;
                }

                if (CREATE_BRANCH_TOTAL_FILE("homesideFinancial", branchTotalFileName + TXT)) {
                    successfulFileCreationBanner(branchTotalFileName);
                    keepGoing = false;
                }
            }
        }
    }

    public static Boolean CONVERT_A_FILE(String FILE_IN, String FILE_OUT,
            Boolean FIRST_RECORD_IS_COLUMN_NAMES) {

        try {

            int Writes = 0;
            int Reads = 0;
            Double Total = 0.0;
            Double d = 0.0;
            String[] Array = null;
            Scanner scan = new Scanner(new File(FILE_IN));
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_OUT));
            while (scan.hasNextLine()) {

                Reads++;
                String IN_RECORD = scan.nextLine();
                String OUT_RECORD = IN_RECORD;

                OUT_RECORD = OUT_RECORD.replaceAll(",", "\\|");
                String OUT_RECORD2 = OUT_RECORD.replace("$", "");
                Array = OUT_RECORD2.split("\\|");
                if (FIRST_RECORD_IS_COLUMN_NAMES) {
                    if (Reads != 1) {
                        d = Double.parseDouble(Array[2]);
                        Total += d;

                        writer.write(OUT_RECORD2);
                        writer.newLine();
                        Writes++;
                    }
                } else {
                    writer.write(OUT_RECORD2);
                    writer.newLine();
                    Writes++;
                }
            }/// end of while loop 

            NumberFormat currency = NumberFormat.getCurrencyInstance();
            String PriceString = currency.format(Total);
            writer.write("TOTAL " + PriceString);
            writer.newLine();
            writer.flush();
            writer.close();
            System.out.println("Reads:" + Reads);
            System.out.println("Writes:" + Writes);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        } finally {

        }
    } /// ENF OF PROCESS_A_FILE

    public Boolean LOAD_A_FILE_TO_MYSQL(String FILE_NAME,
            String FIELD_TERMINATOR, String TABLE_NAME, String DATABASE_NAME) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String url = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
        String user = "root";
        String password = "root";

        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = (Statement) connection.createStatement();

            String sSqlWindows = "load data local infile" + DELIMITER
                    + FILE_NAME + DELIMITER + " into table "
                    + TABLE_NAME + " fields terminated by "
                    + DELIMITER + FIELD_TERMINATOR + "'";
            //          +
            resultSet = statement.executeQuery(sSqlWindows);

            System.out.println("Data Loaded");

            return true;

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Controller.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            return false;

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Controller.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
                return false;
            }
        }

    } //end of load file

    public static Boolean 
        CREATE_BRANCH_TOTAL_FILE(String DATABASE_NAME, String FILE_OUT) {

        String SQL = 
                "select branchName, count(*) as units, sum(loanAmount) as branchTotal "
                + "from homesideFinancial.loan_sales_data group by branchName asc;";
        Connection con = null;

        ResultSet rs = null;

        String OUT_RECORD = null;
        String url = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
        String user = "root";
        String password = "root";

        try {
            con = DriverManager.getConnection(url, user, password);
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_OUT));
            PreparedStatement ps = con.prepareStatement(SQL);

            rs = ps.executeQuery(SQL);
            while (rs.next()) {

                NumberFormat currency = NumberFormat.getCurrencyInstance();
                String PriceString = currency.format(rs.getDouble("branchTotal"));

                OUT_RECORD = rs.getString("branchName") + " | "
                        + rs.getInt("units") + " units | "
                        + PriceString;

                writer.write(OUT_RECORD);
                writer.newLine();
            }
            writer.flush();
            writer.close();

            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Controller.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Controller.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
                return false;
            }
        }
    } //end of create branch file

    private void helloMessage() {
        view.helloMessage();
    }

    private int menuSelection() {
        return view.printMenuSelection();
    }

    private void unknownCommand() {
        view.unknownCommandBanner();
    }

    private void goodbyeBanner() {
        view.goodbye();
    }

    private void spaceBreak() {
        view.spacing();
    }

    private void csvErrorMessage() {
        view.csvError();
    }

    private void txtErrorMessage() {
        view.txtError();
    }

    private void successfulFileCreationBanner(String branchName) {
        view.succesfullCreation(branchName);
    }

    private void processSuccessBanner(String fileIN) {
        view.processSuccessMessage(fileIN);
    }

    private void fileINErrorBanner(String fileIN) {
        view.fileErrorBanner(fileIN);
    }

    private void sqlConfirmationBanner(String fileOUT) {
        view.sqlConfirmationMessage(fileOUT);
    }

    private void sqlErrorBanner(String fileOUT) {
        view.sqlErrorMessage(fileOUT);
    }

}
