import com.sun.tools.javah.Util;
import jdk.jfr.internal.tool.Main;

import java.util.ArrayList;
import java.util.Scanner;

import throwable.InvalidDirectionException;
import throwable.InvalidInstructionException;
import util.InstructionParser;
import util.Validator;
import util.Mapper;

public class MainProgram {
    private ArrayList<Robot> robots = new ArrayList<Robot>();
    private int activeRobot;


    public static void main(String[] args){
        MainProgram program = new MainProgram();
        program.start();
    }


    public void start(){
        boolean initialised = false;
        while(!initialised){
            if(initialise()){
                initialised = true;
            }
        }
        boolean operating = true;
        while (operating){
            System.out.println("Number of robots: " + this.robots.size());
            System.out.println("Activate robot: " + (this.activeRobot + 1));
            System.out.print("Enter your instruction here: ");
            String instruction = input();

            if (instruction.equals("EXIT")){
                operating = false;
                System.out.println("Program will now exit.");
            }
            else if (instruction.contains("PLACE")){
                handlePlaceInstruction(instruction);
            }
            else if (instruction.equals("MOVE")){
                try {
                    robots.get(activeRobot).move();
                }catch (Exception e){
                    System.out.println("Can't Move. There is an error with this robot. Use LEFT or RIGHT to calibrate direction.");
                }
            }
            else if (instruction.equals("LEFT")){
                robots.get(activeRobot).turnLeft();
            }
            else if (instruction.equals("RIGHT")){
                robots.get(activeRobot).turnRight();
            }
            else if (instruction.contains("ROBOT")){
                handleRobotInstruction(instruction);
            }
            else{
                System.out.println("Invalid instruction. Please retry");
            }
        }

    }

    //returns true if success, else returns false
    public boolean initialise(){
        System.out.println("use PLACE to add your first robot: ");
        String instruction = input();
        if (handlePlaceInstruction(instruction)){
            return true;
        }
        else {
            System.out.println("Invalid Instruction. Please retry.");
            return false;
        }
    }

    public void instructionCycle(){
        System.out.println("Number of robots: " + this.robots.size());
        System.out.println("Activate robot: " + (this.activeRobot + 1));
        System.out.print("Enter your instruction here: ");
        String instruction = input();
    }

    //returns true if success, else returns false.
    public boolean handlePlaceInstruction(String instruction) {
        if (Validator.placeInstructionValidator(instruction)){
            try {
                int[] coorAndDirection = InstructionParser.parsePlaceInstruction(instruction);
                Robot robot = new Robot(coorAndDirection[0], coorAndDirection[1], coorAndDirection[2]);
                robots.add(robot);
                this.activeRobot = 0;
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

    //returns true if success, else returns false.
    public boolean handleRobotInstruction(String instruction){

    }

    public String input(){
        String str = "";
        Scanner reader = new Scanner(System.in);
        str = reader.next();
        reader.close();
        return str;
    }
}
