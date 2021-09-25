package util;

import throwable.InvalidInstructionException;

public class InstructionParser {
    public static int[] parsePlaceInstruction(String instruction) throws InvalidInstructionException {
        int x;
        int y;
        int direction;
        if (Validator.placeInstructionValidator(instruction)){
            String[] splitInstruction = instruction.split(" ");
            int[] parsedInstruction = new int[3];
            parsedInstruction[0] = Integer.parseInt(splitInstruction[0]);
            parsedInstruction[1] = Integer.parseInt(splitInstruction[1]);
            try {
                parsedInstruction[2] = Mapper.directionToIntMapper(splitInstruction[2]);
            } catch (Exception e){
                throw new InvalidInstructionException("Invalid instruction.");
            }
            return parsedInstruction;
         }
        else{
            throw new InvalidInstructionException("Invalid instruction.");
        }
    }
}
