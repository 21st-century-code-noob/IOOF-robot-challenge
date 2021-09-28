package utils;

import throwables.InvalidInstructionException;

public class InstructionParser {
    public static int[] parsePlaceInstruction(String instruction) throws InvalidInstructionException {
        int[] parsedInstruction = new int[3];
        try {
            String[] coorAndDirection = instruction.split(" ")[1].split(",");
            parsedInstruction[0] = Integer.parseInt(coorAndDirection[0]);
            parsedInstruction[1] = Integer.parseInt(coorAndDirection[1]);
            parsedInstruction[2] = Mapper.directionToIntMapper(coorAndDirection[2]);
        } catch (Exception e){
                throw new InvalidInstructionException("Invalid instruction.");
        }
        return parsedInstruction;
    }
}
