package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EditProfile {


    public EditProfile(String tempName){
        String csvFile = "UserInformation.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            ArrayList<String> tempList = new ArrayList<String>();
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] inputLine = line.split(cvsSplitBy);
                if (inputLine[0].equals(tempName)){
                    line=tempName+",";
                    System.out.println("What is your home town?");
                    Scanner addNewTown = new Scanner(System.in);
                    line+=(addNewTown.nextLine()+",");
                    System.out.println("What are your hobbies?");
                    Scanner addNewHobbies = new Scanner(System.in);
                    line+=(addNewHobbies.nextLine()+",");
                    tempList.add(line);
                    // /line.add(pTweet);
                    //tempList.add(line+",");
                } else tempList.add(line);
            }
            PrintWriter pr = new PrintWriter("UserInformation.csv");

            for (int l = 0; l < tempList.size(); l++) {
                pr.println(tempList.get(l));
            }
            //pr.println();
            pr.close();
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