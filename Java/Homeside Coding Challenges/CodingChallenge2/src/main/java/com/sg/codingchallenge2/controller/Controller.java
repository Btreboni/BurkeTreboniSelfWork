/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.codingchallenge2.controller;

import com.sg.codingchallenge2.view.View;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 *
 * @author admin
 */
public class Controller {

    View view;

    public Controller(View view) {
        this.view = view;
    }

    private final Scanner scan = new Scanner(System.in);

    public void runProgram() throws UnsupportedEncodingException, IOException {

        Boolean keepGoing = true;
        int menuSelection = 0;

        hello();

        while (keepGoing) {

            menuSelection = printMenu();

            switch (menuSelection) {

                case 1:
                    getUserInfo();
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

    public int printMenu() {
        return view.printMenuSelection();
    }

    private void getUserInfo() throws UnsupportedEncodingException, IOException {
        boolean keepGoing = true;

        while (keepGoing) {
            String userNumber = view.phoneNumberPrompt();
            int message = userNumber.length();

            if (message != 10) {
                view.phoneNumberErrorMessage();
                keepGoing = false;
            } else if (Pattern.matches("[a-zA-z]+", userNumber)) {
                view.textMessageErrorMessage();
                keepGoing = false;
            } else {
                String userMessage = view.messagePrompt();

                if (userMessage.length() > 20) {
                    view.textTooLong();
                    keepGoing = false;
                } else {
                    view.displayMessageAndNumber(userNumber, userMessage);

                    final NameValuePair[] data = {
                        new BasicNameValuePair("phone", userNumber),
                        new BasicNameValuePair("message", userMessage),
                        new BasicNameValuePair("key",
                        "a89f301e767cf860a7f4cd57884631293dc49575d1sAYePbqHak27IGK72XQ7TLv")
                    };

                    CloseableHttpClient httpClient = HttpClients.createMinimal();
                    HttpPost httpPost = new HttpPost("https://textbelt.com/text");
                    httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(data)));
                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    String responseString = EntityUtils.toString(httpResponse.getEntity());
                    JSONObject response = new JSONObject(responseString);
                    keepGoing = false;
                }

            }

        }
    }

    private void hello() {
        view.helloMessage();
    }

    private void unknownCommand() {
        view.unknownCommandBanner();
    }

    private void goodbyeBanner() {
        view.goodbye();
    }
}
