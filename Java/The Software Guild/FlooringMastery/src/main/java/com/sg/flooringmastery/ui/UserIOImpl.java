/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class UserIOImpl implements UserIO {

    private Scanner scan = new Scanner(System.in);

    @Override
    public void print(String message) {

        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {

        while (true) {
            try {
                System.out.println(prompt);
                String userInput = scan.nextLine();
                double userNum = Double.parseDouble(userInput);

                return userNum;
            } catch (NumberFormatException e) {
                System.out.println("Sorry, that is not a valid option.");
            }
        }

    }

    @Override
    public double readDouble(String prompt, double min, double max) {

        double userNum;

        while (true) {
            try {
                System.out.println(prompt);
                userNum = Double.parseDouble(scan.nextLine());
                if (userNum < min || userNum > max) {
                    System.out.println("Out of bounds. Try again.");
                } else {
                    return userNum;
                }
            } catch (NumberFormatException e) {
                System.out.println("Sorry, that it not a valid selection.");
            }
        }
    }

    @Override
    public float readFloat(String prompt) {

        while (true) {
            try {
                System.out.println(prompt);
                String userInput = scan.nextLine();
                float userNum = Integer.parseInt(userInput);

                return userNum;
            } catch (NumberFormatException e) {
                System.out.println("Sorry, that it not a valid selection.");
            }

        }

    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float userNum;

        while (true) {
            try {
                System.out.println(prompt);
                String userInput = scan.nextLine();
                userNum = Float.parseFloat(userInput);

                if (userNum >= min && userNum <= max) {

                } else {
                    return userNum;
                }
            } catch (NumberFormatException e) {
                System.out.println("Sorry, that it not a valid selection.");
            }

        }

    }

    @Override
    public int readInt(String prompt) {

        while (true) {
            try {
                System.out.print(prompt);
                String userInput = scan.nextLine();
                int userNum = Integer.parseInt(userInput);
                return userNum;
            } catch (NumberFormatException e) {
                System.out.println("Sorry, that is not a valid selection.");
            }
        }
    }

    @Override
    public int readInt(String prompt, int min, int max) {

        int userNum;

        while (true) {
            try {
                System.out.println(prompt);
                String userInput = scan.nextLine();
                userNum = Integer.parseInt(userInput);

                if (userNum >= min && userNum <= max) {

                }
                return userNum;
            } catch (NumberFormatException e) {
                System.out.println("Sorry, that is not a valid selection.");
            }
        }

    }

    @Override
    public long readLong(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String userInput = scan.nextLine();
                long userNum = Long.parseLong(userInput);
                return userNum;
            } catch (NumberFormatException e) {
                System.out.println("Sorry, that is not a valid selection.");
            }
        }
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long userNum = 0;

        while (userNum < min || userNum > max) {
            try {
                System.out.println(prompt);
                String userInput = scan.nextLine();
                userNum = Long.parseLong(userInput);

            } catch (NumberFormatException e) {
                System.out.println("Sorry, that is not a valid selection.");
            }
        }
        return userNum;
    }

    @Override
    public String readString(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String userInput = scan.nextLine();

                return userInput;
            } catch (NumberFormatException e) {
                System.out.println("Sorry, that is not a valid selection.");
            }
        }

    }

    @Override
    public BigDecimal readBigDecimal(String message) {
        while (true) {
            try {
                System.out.println(message);
                String userInput = scan.nextLine();
                BigDecimal bigD = new BigDecimal(userInput);

                return bigD;
            } catch (NumberFormatException e) {
                System.out.println("Sorry, that is not a valid selection.");
            }
        }
    }

    @Override
    public LocalDate readLocalDate(String prompt) {
        String userInput;
        LocalDate ld = LocalDate.parse("01/01/2000", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        boolean keepGoing = true;
        while (keepGoing) {
            try {
                System.out.println(prompt);
                userInput = scan.nextLine();
                ld = LocalDate.parse(userInput, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                keepGoing = false;
            } catch (DateTimeParseException e) {

            }
        }
        return ld;
    }

    @Override
    public boolean getConfirmation(String prompt) {
        int userNum;
        boolean hasError = true;

        while (hasError) {
            System.out.println(prompt);
            try {
                
                String userInput = scan.nextLine();
                userNum = Integer.parseInt(userInput);

                if (userNum > 2 && userNum < 1) {
                    hasError = true;
                    System.out.println("Invalid Input. Must be 1 or 2");
                }
                if (userNum == 1) {
                    return true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Sorry, that is not a valid selection.");
            }
        }
        return false;
    }
}
