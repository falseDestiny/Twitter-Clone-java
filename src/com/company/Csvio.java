package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Csvio {
    static String choice;
    static int count=0;
    String tempName;
    static String pTweet;
    static String tempLine;
    static String topic;

    public void getSearch() {
        //System.out.println("What is your user name?");
        Scanner addText = new Scanner(System.in);
        choice = (addText.nextLine());
    }
    public static void makePublicTweets(String userName) {
        System.out.println("Enter your tweet on Perry!!");
        Scanner addPublicTweet = new Scanner(System.in);
        java.sql.Date currentTimestamp = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        pTweet = (addPublicTweet.nextLine());

        pTweet = currentTimestamp+" "+pTweet;
        String csvFile = "PublicTweets.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            ArrayList<String> tempList = new ArrayList<String>();
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] inputLine = line.split(cvsSplitBy);
                if (line.contains(userName)){
                    //line.add(pTweet);
                    tempList.add(line+","+pTweet);
                } else tempList.add(line);
            }
            PrintWriter pr = new PrintWriter("PublicTweets.csv");

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
    public static void makePrivateTweets(String userName) {
        System.out.println("Enter your Secret tweet about Perry!!");
        Scanner addPublicTweet = new Scanner(System.in);
        java.sql.Date currentTimestamp = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        pTweet = (addPublicTweet.nextLine());

        pTweet = currentTimestamp+" "+pTweet;
        String csvFile = "PrivateTweets.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            ArrayList<String> tempList = new ArrayList<String>();
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] inputLine = line.split(cvsSplitBy);
                if (inputLine[0].equals(userName)){
                    //line.add(pTweet);
                    tempList.add(line+","+pTweet);
                } else tempList.add(line);
            }
            PrintWriter pr = new PrintWriter("PrivateTweets.csv");

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
    public static void getTopics() {
        String csvFile1 = "PrivateTweets.csv";
        String csvFile2 = "PublicTweets.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        System.out.println("");
        System.out.println("What topic would you like to search for? Be sure to use #");
        Scanner addPublicTweet = new Scanner(System.in);
        topic = (addPublicTweet.nextLine());
        try {
            br = new BufferedReader(new FileReader(csvFile2));
            while ((line = br.readLine()) != null) {
                String[] inputLine = line.split(cvsSplitBy);
                for(int i = 1; i<inputLine.length; i++) {
                    if(inputLine[i].contains(topic)) {
                        System.out.println(inputLine[0]);
                        System.out.println(inputLine[i]);
                        System.out.println("");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br = new BufferedReader(new FileReader(csvFile1));
            while ((line = br.readLine()) != null) {
                String[] inputLine = line.split(cvsSplitBy);
                for(int i = 1; i<inputLine.length; i++) {
                    if(inputLine[i].contains(topic)) {
                        System.out.println(inputLine[0]);
                        System.out.println(inputLine[i]);
                        System.out.println("");
                    }
                }
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
    public static void getMessageTags(String tempName) {
        String csvFile1 = "PrivateTweets.csv";
        String csvFile2 = "PublicTweets.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        System.out.println("");
        try {
            br = new BufferedReader(new FileReader(csvFile2));
            while ((line = br.readLine()) != null) {
                String[] inputLine = line.split(cvsSplitBy);
                for(int i = 1; i<inputLine.length; i++) {
                    if(inputLine[i].contains("@"+tempName)) {
                        System.out.println(inputLine[0]);
                        System.out.println(inputLine[i]);
                        System.out.println("");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br = new BufferedReader(new FileReader(csvFile1));
            while ((line = br.readLine()) != null) {
                String[] inputLine = line.split(cvsSplitBy);
                for(int i = 1; i<inputLine.length; i++) {
                    if(inputLine[i].contains("@"+tempName)) {
                        System.out.println(inputLine[0]);
                        System.out.println(inputLine[i]);
                        System.out.println("");
                    }
                }
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
    public static void PublicTweets() {
        String csvFile = "PublicTweets.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        System.out.println("");
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] inputLine = line.split(cvsSplitBy);
                for(int i = 1; i<inputLine.length; i++) {
                    System.out.println(inputLine[0]);
                    System.out.println(inputLine[i]);
                    count++;
                    System.out.println("");
                }
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
    public static void SubscibedTweets(String tempName) {
        String csvFile = "PrivateTweets.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            System.out.println("");

            br = new BufferedReader(new FileReader(csvFile));
            //System.out.println(br);

            while ((line = br.readLine()) != null) {
                String[] inputLine = line.split(cvsSplitBy);

                for(int i = 0; i<inputLine.length; i++) {
                    if (line.contains(tempName+"F")) {
                        //System.out.println(line);
                        line = br.readLine();
                        String[] newInputLine = line.split(cvsSplitBy);

                        for (int j = 1; j < newInputLine.length; j++) {
                            System.out.println(newInputLine[0]);
                            System.out.println(newInputLine[j]);
                            System.out.println(" ");
                        }
                    }
                }
            }
            System.out.println("");

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
    public static void FollowUser(String tempName) {
        System.out.println("What is the name of the user(ehem... Perry) that you would like to follow?");
        Scanner decision = new Scanner(System.in);
        String userNameToFollow = decision.nextLine();

        String csvFile = "PrivateTweets.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            ArrayList<String> tempList = new ArrayList<String>();
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] inputLine = line.split(cvsSplitBy);
                if (line.contains(userNameToFollow+"*")){
                    if (line.contains(tempName+"F")){
                        System.out.println("You are already following "+userNameToFollow+".");
                    } else  System.out.println("You are now following "+userNameToFollow+".");
                            tempList.add(line+","+tempName+"F");
                } else tempList.add(line);
            }
            PrintWriter pr = new PrintWriter("PrivateTweets.csv");

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
    public static void UnFollowUser(String tempName) {
        System.out.println("What is the name of the user(ehem... not Perry) that you would like to un follow?");
        Scanner decision = new Scanner(System.in);
        String userNameToFollow = decision.nextLine();

        String csvFile = "PrivateTweets.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            ArrayList<String> tempList = new ArrayList<String>();
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] inputLine = line.split(cvsSplitBy);
                if (line.contains(userNameToFollow+"*")){
                    if (line.contains(tempName+"F")){
                        tempList.remove(tempName+"F");
                        tempList.add(line);
                        System.out.println("You are already following "+userNameToFollow+".");
                    }  else System.out.println("You are not following that user");
                } else tempList.add(line);
            }
            PrintWriter pr = new PrintWriter("PrivateTweets.csv");

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
    public static void UserInformation() {
    }
    public static void editProfile() {
    }
}