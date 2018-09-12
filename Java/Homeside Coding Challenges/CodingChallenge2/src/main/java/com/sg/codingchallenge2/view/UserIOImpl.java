/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.codingchallenge2.view;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class UserIOImpl implements UserIO {

    public final Scanner scan = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
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

}
