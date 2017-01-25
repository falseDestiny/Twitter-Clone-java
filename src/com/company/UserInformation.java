package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserInformation {
    static int count;
    String userSearch;
    int notFound=0;

    public UserInformation() {
        System.out.println("Who's profile would you like to view?");
        String csvFile = "UserInformation.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Scanner decision = new Scanner(System.in);
        userSearch = decision.nextLine();
        try {
            System.out.println("");
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] inputLine = line.split(cvsSplitBy);

                for(int i = 0; i<inputLine.length; i++) {
                    //System.out.println(userSearch);
                    //System.out.println(inputLine[i]);
                    if (inputLine[0].equals(userSearch)){
                        System.out.println("User Name: "+inputLine[0]);
                        System.out.println("Home Town: "+inputLine[1]);
                        System.out.println("Hobbies: "+inputLine[2]);
                        i=inputLine.length;
                        System.out.println("");
                        notFound=1;
                    }
                }
            }
            if (notFound==0){
                System.out.println("The user "+userSearch+" does not exist.");
                System.out.println("");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}