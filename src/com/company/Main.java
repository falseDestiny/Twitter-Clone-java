package com.company;

public class Main {

    public static void main(String[] args) {

        String choice=null;
        boolean status = false;
        boolean logout = true;
        choice ="0";
        int listChoice;
        String tempName;
        do{
            try {
                Mainmenu input = new Mainmenu();
                input.Mainmenu();
                listChoice = input.getListChoice();
                if (listChoice == 1) {
                    Login user = new Login();
                    Fileio.Login();
                    status = user.getLoginStatus();
                }
                if (listChoice == 2) {
                    Register user = new Register();
                    Fileio.Register();
                    Fileio.RegisterUser();
                }
                if (listChoice == 3) {
                    Csvio.PublicTweets();
                }
                if (listChoice == 4) {
                    Csvio.UserInformation();
                    UserInformation userInfo = new UserInformation();
                }
                if (listChoice == 5) {
                    System.out.println("Thank you for using our system!");
                    System.exit(0);
                }
                while (status) {
                    try {
                        tempName = Login.getLoginName();
                        Csvio.SubscibedTweets(tempName);
                        Mainmenu.Usermenu(tempName);
                        listChoice = input.getListChoice();
                        if (listChoice == 1) {
                            Csvio.makePublicTweets(tempName);
                        }
                        if (listChoice == 2) {
                            Csvio.makePrivateTweets(tempName);
                        }
                        if (listChoice == 3) {
                            Csvio.getTopics();
                        }
                        if (listChoice == 4) {
                            Csvio.getMessageTags(tempName);
                        }
                        if (listChoice == 5) {
                            Csvio.PublicTweets();
                        }
                        if (listChoice == 6) {
                            Csvio.FollowUser(tempName);
                        }
                        if (listChoice == 7) {
                            Csvio.UserInformation();
                            UserInformation userInfo = new UserInformation();
                        }
                        if (listChoice == 8) {
                            Csvio.editProfile();
                            EditProfile editProfile = new EditProfile(tempName);
                        }
                        if (listChoice == 9) {
                            System.out.println("You are logged out of the system.");
                            System.out.println();
                            status = false;
                        }
                        if (listChoice == 10) {
                            System.out.println("Thank you for using our system!");
                            System.exit(0);
                        }
                    } catch (final NumberFormatException ex) {
                        System.out.println();
                        System.out.println("Please make an alternate selection.");
                        System.out.println("Letters and special chars are not numbers, sadly:(");
                        System.out.println();
                    }
                }
            }
            catch (final NumberFormatException ex){
                System.out.println();
                System.out.println("Please make an alternate selection.");
                System.out.println("Letters and special chars are not numbers, sadly:(");
                System.out.println();
            }
        } while (!choice.equals("Q"));
    }
}