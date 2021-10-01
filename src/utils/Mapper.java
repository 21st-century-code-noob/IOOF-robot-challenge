package utils;

import data.IntDirectionDataPair;
import throwables.InvalidDirectionException;

import java.util.List;


public class Mapper {

    private final static List<IntDirectionDataPair> list = List.of(
            new IntDirectionDataPair(1, "NORTH"),
            new IntDirectionDataPair(2, "EAST"),
            new IntDirectionDataPair(3, "SOUTH"),
            new IntDirectionDataPair(4, "WEST"));

    public static String findDirectionByInt (int i) throws InvalidDirectionException {
        return list.stream().filter(pair -> pair.getDirectionInt() == i).findAny().orElseThrow(() -> new InvalidDirectionException("Invalid Direction")).getDirection();
    }

    public static int findIntByDirection (String str) throws InvalidDirectionException {
        return list.stream().filter(pair -> pair.getDirection().equals(str)).findAny().orElseThrow(() -> new InvalidDirectionException("Invalid Direction")).getDirectionInt();
    }


}
