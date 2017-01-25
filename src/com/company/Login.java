package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Login extends Fileio {
    static String userName;
    String password;
    static boolean status;
    private String fileName;

    public Login(){
        System.out.println("Please enter your user name.");
        Scanner nameDecision = new Scanner(System.in);
        userName = nameDecision.nextLine();
        System.out.println("Please enter your Password.");
        Scanner passDecision = new Scanner(System.in);
        password = passDecision.nextLine();
        ArrayList<String[]> list = new ArrayList<String[]>();
        try {
            File fileName = new File("Users.txt");      //Create a new file
            Scanner scan = new Scanner(fileName);       //Create a Scanner object (Throws FileNotFoundException)
            if (scan.hasNext())                         //Check to make sure that there is actually something in the file.
            {
                do {
                    String line = scan.nextLine();      //Read the line of data
                    input = line.split(" ");            //This reads each line one part at a time
                    list.add(input);                    //Each line is iterated as the list is iterated
                    //System.out.print(input[0]);
                    //System.out.println(input[1]);
                    if (input[0].equals(userName)&(input[1].equals(password))){
                        //System.out.println("Yay,"+userName+" is a user");
                        status = true;
                    }
                    //System.out.println(status);
                } while (scan.hasNext());
                if (status!=true){
                    System.out.println();
                    System.out.println("Sorry, the user information is incorrect. Try again:)");
                    System.out.println();
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
    }
    public boolean getLoginStatus(){
        return status;
    }
    public static String getLoginName(){
        return userName;
    }
}