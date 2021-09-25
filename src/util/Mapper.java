package util;

import throwable.InvalidDirectionException;

public class Mapper {
    public static String intToDirectionMapper(int i){
        switch(i){
            case 1:
                return "NORTH";
            case 2:
                return "EAST";
            case 3:
                return "SOUTH";
            case 4:
                return "WEST";
            default:
                return "INVALID";
        }
    }

    public static int directionToIntMapper(String str) throws InvalidDirectionException {
        switch(str){
            case "NORTH":
                return 1;
            case "EAST":
                return 2;
            case "SOUTH":
                return 3;
            case "WEST":
                return 4;
            default:
                throw new InvalidDirectionException("Invalid direction.");
                //0 is invalid
        }
    }

}
