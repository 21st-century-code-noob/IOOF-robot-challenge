package data;

public class IntDirectionDataPair {
    private final DataPair<Integer, String> intDirectionPair;

    public IntDirectionDataPair(int directionInt, String direction){
        intDirectionPair = new DataPair<Integer, String>(directionInt, direction);
    }

    public int getDirectionInt (){
        return intDirectionPair.first;
    }

    public String getDirection(){
        return intDirectionPair.second;
    }
}
