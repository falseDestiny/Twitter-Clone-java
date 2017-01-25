package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Fileio {
    private static String fileName;
    static String[] input;
    String textStuff;
    public static String choice;
    public static String nChoice;
    public static String pChoice;
    static int listChoice;
    static int userFound=0;

    public static int getSearch() {
        Scanner decision = new Scanner(System.in);
        listChoice = Integer.parseInt(decision.nextLine());
        return listChoice;
    }
    public static void RegisterUser() {
        ArrayList<String[]> list = new ArrayList<String[]>();
        try {
            File fileName = new File("Users.txt");//Create a new file
            Scanner scan = new Scanner(fileName);       //Create a Scanner object (Throws FileNotFoundException)
            if (scan.hasNext())                         //Check to make sure that there is actually something in the file.
            {
                do {
                    String line = scan.nextLine();      //Read the line of data
                    input = line.split(" ");            //This reads each line one part at a time
                    list.add(input);                    //Each line is iterated as the list is iterated
                    if (input[0].contains(nChoice)){
                        System.out.println("Oops, "+nChoice+" is already a user:(");
                        System.out.println("");
                        userFound=1;
                    }
                } while (scan.hasNext());

                if (userFound == 0){
                    System.out.println("");
                    System.out.println("Thanks for registering!");
                    System.out.println(nChoice+" is now your username.");
                    System.out.println();

                    for(int i = 0; i<input.length; i++) {
                        try
                        {
                            PrintWriter pr = new PrintWriter("Users.txt");
                            for (int l=0; l<list.size() ; l++)
                            {
                                String[] temp = list.get(l);
                                pr.println(temp[0] + " " +temp[1]);
                            }
                            pr.println(getUserName() + " " + getPass());
                            pr.close();
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                            System.out.println("No such file exists.");
                        }
                    }
                }
            }
            FileReader fileReader =
                    new FileReader(fileName);
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
        if (userFound == 0) {
            String csvFile = "UserInformation.csv";
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ",";
            //System.out.println("");
            try {
                ArrayList<String> tempList = new ArrayList<String>();
                br = new BufferedReader(new FileReader(csvFile));
                while ((line = br.readLine()) != null) {
                    String[] inputLine = line.split(cvsSplitBy);
                    tempList.add(line);
                    //System.out.println(line);
                }
                PrintWriter pr = new PrintWriter("UserInformation.csv");
                tempList.add(nChoice+",Blank"+",Blank");

                for (int l = 0; l < tempList.size(); l++) {
                    //String[] temp = list.get(l);
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
        if (userFound == 0) {
            String csvFile = "PrivateTweets.csv";
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ",";
            //System.out.println("");
            try {
                ArrayList<String> tempList = new ArrayList<String>();
                br = new BufferedReader(new FileReader(csvFile));
                while ((line = br.readLine()) != null) {
                    String[] inputLine = line.split(cvsSplitBy);
                    tempList.add(line);
                    //System.out.println(line);
                }
                PrintWriter pr = new PrintWriter("PrivateTweets.csv");
                tempList.add(nChoice+"*"+",DoofenshmirtzF");
                tempList.add(nChoice);
                tempList.add("");
                for (int l = 0; l < tempList.size(); l++) {
                    //String[] temp = list.get(l);
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
        if (userFound == 0) {
            String csvFile = "PublicTweets.csv";
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ",";
            //System.out.println("");
            try {
                ArrayList<String> tempList = new ArrayList<String>();
                br = new BufferedReader(new FileReader(csvFile));
                while ((line = br.readLine()) != null) {
                    String[] inputLine = line.split(cvsSplitBy);
                    tempList.add(line);
                    //System.out.println(line);
                }
                PrintWriter pr = new PrintWriter("PublicTweets.csv");
                tempList.add(nChoice);

                for (int l = 0; l < tempList.size(); l++) {
                    //String[] temp = list.get(l);
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
    public void Mainmenu() {
    }
    public static void Login() {
    }
    public static void Register() {
    }
    public static String getUserName(){
        return nChoice;
    }
    public static String getPass(){
        return pChoice;
    }
}