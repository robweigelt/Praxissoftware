package PracticeManagementSoftware;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws CloneNotSupportedException, IOException, InterruptedException {


        MainMenu.Funtext();
       int a = MainMenu.WelcomeText();
        if (a == 1){
            MainMenu.Menu();

        }
        else {System.exit(0);}

     }}
