package r.w;
public class Main {


    public static void main(String[] args) throws InterruptedException {



       int a = Controller.WelcomeText();
        if (a == 1){
            Controller.Menu();
        }
        else {System.exit(0);}

     }}
