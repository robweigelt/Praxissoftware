package r.w;

import java.util.concurrent.TimeUnit;

public class Controller {

    //Starter
    public static int WelcomeText() throws InterruptedException {
        Funtext();


        System.out.println("Welcome to the private practice, Please press [1] and [Enter] to continue");
         var a = GetIntOrString.GetmyInt();
         return a;


    }
 public static void Funtext()  throws InterruptedException {
        System.out.println("             ___       __   __         ___    ___  __  ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("       |  | |__  |    /  ` /  \\  |\\/| |__      |  /  \\ ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("       |/\\| |___ |___ \\__, \\__/  |  | |___     |  \\__/ ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("              ____                 _   _                                   ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("             |  _ \\ _ __ __ _  ___| |_(_) ___ ___                          ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("             | |_) | '__/ _` |/ __| __| |/ __/ _ \\                         ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("             |  __/| | | (_| | (__| |_| | (_|  __/                         ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("             |_|   |_|  \\__,_|\\___|\\__|_|\\___\\___|                         ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("  __  __                                                   _   ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println(" |  \\/  | __ _ _ __   __ _  __ _  ___ _ __ ___   ___ _ __ | |_ ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println(" | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '_ ` _ \\ / _ \\ '_ \\| __|");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println(" | |  | | (_| | | | | (_| | (_| |  __/ | | | | |  __/ | | | |_ ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println(" |_|  |_|\\__,_|_| |_|\\__,_|\\__, |\\___|_| |_| |_|\\___|_| |_|\\__|");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("          ____         __ _ |___/                               ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("         / ___|  ___  / _| |___      ____ _ _ __ ___                   ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("         \\___ \\ / _ \\| |_| __\\ \\ /\\ / / _` | '__/ _ \\                  ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("          ___) | (_) |  _| |_ \\ V  V / (_| | | |  __/                  ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("         |____/ \\___/|_|  \\__| \\_/\\_/ \\__,_|_|  \\___|                  ");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("by Tabea Böger");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.print(", Lisa Eberl");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.print(", Hannes Kukulenz");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.print(", Tobias Vogt");
        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println(" & Robert Weigelt");
        System.out.println("");
    }
    //Main Menu
    public static void Menu(){
       System.out.println("Please choose between the different menus by pressing the number [] and [Enter]:\n" +
               "Patient Record [1] \n" +
               "Medicine Glossar [2]\n" +
               "Inventory [3]\n" +
               "Calendar [4]\n" +
               "Close [5]"
      );
        InsideMenu(GetIntOrString.GetmyInt());
    }
    //Switch to Submenus
    public static void InsideMenu ( int Switcher) {
        switch (Switcher) {
            case 1:

                break;
            case 2:

                break;
            case 3:
                System.out.println("i ist drei");
                break;
            case 4:
                System.out.println("Ups");
            case 5:
            {System.exit(0);}

            //Invalid Number
            default: System.out.println("You entered an invalid number");


        }
    }
}