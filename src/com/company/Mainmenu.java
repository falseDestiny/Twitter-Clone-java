package com.company;

public class Mainmenu extends Fileio {

    public Mainmenu() {
        System.out.println("Welcome to the Twittinator!");
        System.out.println("Please select an option from our menu.");
        //System.out.println();
        System.out.println("(1) Login.");
        System.out.println("(2) Register.");
        System.out.println("(3) View public feed.");
        System.out.println("(4) View a users profile.");
        System.out.println("(5) Quit system.");
        System.out.println("What is your choice? (1--5)");
        listChoice = Fileio.getSearch();
        while (listChoice < 1 || listChoice > 5) {
            System.out.println("Please make a valid choice.");
            listChoice = Fileio.getSearch();
        }
    }
    public static void Usermenu(String tempName) {
        System.out.println("Welcome "+tempName+"!");
        System.out.println("Please select an option from the user menu.");
        //System.out.println();
        System.out.println("(1) Make a public Tweet(about Perry).");
        System.out.println("(2) Make a private Tweet(about Perry).");
        System.out.println("(3) Search a topic(about Perry) by using a #.");
        System.out.println("(4) Check for your message tags.");
        System.out.println("(5) View public feed.");
        System.out.println("(6) Follow a user.");
        System.out.println("(7) View a users profile.");
        System.out.println("(8) Edit your profile.");
        System.out.println("(9) Logout of the system.");
        System.out.println("(10) Quit system.");
        System.out.println("What is your choice? (1--10)");
        listChoice = Fileio.getSearch();
        while (listChoice < 1 || listChoice > 10) {
            System.out.println("Please make a valid choice.");
            listChoice = Fileio.getSearch();
        }
    }
    public int getListChoice() {
        return listChoice;
    }
}