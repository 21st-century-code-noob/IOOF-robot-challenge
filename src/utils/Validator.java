package utils;

import game.Board;

public class Validator {

    //todo: replace all the if statements with RegEx.
    public static boolean placeInstructionValidator(String instruction, Board board){
        if (instruction.trim().equals("")){
            return false;
        }
        String[] splitInstruction = instruction.split(" ");
        if (splitInstruction.length != 2){
            return false;
        }
        if (!splitInstruction[0].equals("PLACE")){
            return false;
        }
        String[] coorAndDirection = splitInstruction[1].split(",");
        if (coorAndDirection.length != 3){
            return false;
        }
        if (!coorAndDirection[2].equals("EAST") && !coorAndDirection[2].equals("NORTH")
                && !coorAndDirection[2].equals("SOUTH") && !coorAndDirection[2].equals("WEST")){
            return false;
        }
        try{
            int x = Integer.parseInt(coorAndDirection[0]);
            int y = Integer.parseInt(coorAndDirection[1]);
            if ( x >= 0 && x <= board.getWidth() && y >= 0 && y <= board.getHeight()){
                return true;
            }
            else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public static boolean robotInstructionValidator(String instruction){
        if (instruction.trim().equals("")){
            return false;
        }
        String[] splitInstruction = instruction.split(" ");
        if (splitInstruction.length != 2){
            return false;
        }
        if (!splitInstruction[0].equals("ROBOT")){
            return false;
        }
        try{
            Integer.parseInt(splitInstruction[1]);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
