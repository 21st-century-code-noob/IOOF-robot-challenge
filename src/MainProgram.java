import java.util.ArrayList;
import java.util.Scanner;

import components.Robot;
import game.Board;
import utils.InstructionParser;
import utils.Validator;
import utils.Mapper;

public class MainProgram {
    private ArrayList<Robot> robots = new ArrayList<>();
    private int activeRobot; //starts from 0
    private Board board;
    Scanner reader = new Scanner(System.in);

    public MainProgram(int width, int height){
        this.board = new Board(width, height);
    }

    public static void main(String[] args){
        MainProgram program = new MainProgram(4,4);
        program.start();
    }


    public void start(){
        boolean initialised = false;
        while(!initialised){
            initialise();
            if (this.robots.size() >= 1) {
                initialised = true;
            }
        }

        String instruction;
        boolean operating = true;
        while (operating){
            System.out.println("Number of robots: " + this.robots.size());
            System.out.println("Active robot: " + (this.activeRobot + 1));
            System.out.print("Enter your instruction here: ");
            instruction = reader.nextLine();

            if (instruction.equals("EXIT")){
                operating = false;
                System.out.println("Program will now exit.");
            }
            else if (instruction.contains("PLACE")){
                if(!handlePlaceInstruction(instruction)){
                    System.out.println("Invalid Instruction. Please retry.");
                }
                System.out.println();
            }
            else if (instruction.equals("MOVE")){
                try {
                    robots.get(activeRobot).move(board);
                    System.out.println();
                }catch (Exception e){
                    System.out.println("Can't Move. There is an error with this robot. Use LEFT or RIGHT to recalibrate direction.");
                    System.out.println();
                }
            }
            else if (instruction.equals("LEFT")){
                robots.get(activeRobot).turnLeft();
                System.out.println();
            }
            else if (instruction.equals("RIGHT")){
                robots.get(activeRobot).turnRight();
                System.out.println();
            }
            else if(instruction.equals("REPORT")){
                report();
                System.out.println();
            }
            else if (instruction.contains("ROBOT")){
                if(!handleRobotInstruction(instruction)){
                    System.out.println("No such robot.");
                }
                System.out.println();
            }
            else{
                System.out.println("Invalid instruction. Please retry");
                System.out.println();
            }
        }
    }

    //returns true if success, else returns false
    public boolean initialise(){
        System.out.print("use PLACE to add your first robot: ");
        String instruction;
        instruction = reader.nextLine();
        if (instruction.equals("EXIT")){
            System.out.println("Program will now exit.");
            System.exit(0);
        }
        if (handlePlaceInstruction(instruction)){
            this.activeRobot = 0;
            return true;
        }
        else {
            System.out.println("Invalid Instruction. Please retry.");
            return false;
        }
    }


    //returns true if success, else returns false.
    public boolean handlePlaceInstruction(String instruction) {
        if (Validator.placeInstructionValidator(instruction, board)){
            try {
                int[] coorAndDirection = InstructionParser.parsePlaceInstruction(instruction);
                Robot robot = new Robot(coorAndDirection[0], coorAndDirection[1], coorAndDirection[2]);
                this.robots.add(robot);
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

    //returns true if success, else returns false.
    public boolean handleRobotInstruction(String instruction){
        if (Validator.robotInstructionValidator(instruction)){
            try {
                int num = Integer.parseInt(instruction.split(" ")[1]);
                if (num <= this.robots.size()) {
                    this.activeRobot = num - 1;
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e){
                return false;
            }
        }
        return false;
    }

    public void report() {
        Robot robot = this.robots.get(activeRobot);
        String directionStr;
        try {
            directionStr = Mapper.intToDirectionMapper(robot.getDirection());
            System.out.println("Output: " + robot.getCoordinateXY()[0] + ", " + robot.getCoordinateXY()[1] + ", " + directionStr );
        }catch (Exception e){
            System.out.println("There is an error");
        }
    }
}


