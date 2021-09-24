import jdk.jfr.internal.tool.Main;

import java.util.Scanner;

public class MainProgram {

    boolean xValid = false;
    boolean yValid = false;
    boolean directionValid = false;

    public static void main(String[] args){
        MainProgram program = new MainProgram();
        program.start();
    }

    public void start(){


    }

    public void initialise(){
        boolean initialDataValid = false;

        String initialInput = "";

        System.out.println("Please enter the initial PLACE command.");

        while(!initialDataValid){


        }
    }

    public String input(){
        String str = "";
        Scanner reader = new Scanner(System.in);
        str = reader.next();
        reader.close();
        return str;
    }
}
