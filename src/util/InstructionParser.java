package util;

import throwable.InvalidInstructionException;

public class InstructionParser {
    public static int[] parsePlaceInstruction(String instruction) throws InvalidInstructionException {
        if (Validator.placeInstructionValidator(instruction)){
            String[] coorAndDirection = instruction.split(" ")[1].split(",");
            int[] parsedInstruction = new int[3];
            parsedInstruction[0] = Integer.parseInt(coorAndDirection[0]);
            parsedInstruction[1] = Integer.parseInt(coorAndDirection[1]);
            try {
                parsedInstruction[2] = Mapper.directionToIntMapper(coorAndDirection[2]);
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
