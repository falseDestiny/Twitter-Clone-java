package com.company;

import java.util.Scanner;

public class Register extends Fileio {

    public Register(){
        System.out.println("Thank you for choosing to register!");
        System.out.println("What is your desired user name?");
        Scanner nameChoice = new Scanner(System.in);
        nChoice = nameChoice.nextLine();
        System.out.println("What is your desired password?");
        Scanner passChoice = new Scanner(System.in);
        pChoice = passChoice.nextLine();
    }
}