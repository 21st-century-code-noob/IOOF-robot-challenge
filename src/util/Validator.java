package util;

public class Validator {

    //todo: replace all the if statements with RegEx.
    public static boolean placeInstructionValidator(String instruction){
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
        if (coorAndDirection[2] != "EAST" || coorAndDirection[2] != "NORTH"
                || coorAndDirection[2] != "SOUTH" ||coorAndDirection[2] != "WEST"){
            return false;
        }
        try{
            int x = Integer.valueOf(coorAndDirection[0]);
            int y = Integer.valueOf(coorAndDirection[1]);
            if ( x >= 1 && x <= 5 && y >= 1 && y <=5){
                return true;
            }
            else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public static boolean validateRobotInstruction(String instruction){
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
