package Event2016.Day1;

public class Orientation
{
    public enum Direction { NORTH, EAST, SOUTH, WEST }
    private Direction currentOrientation;

    public void turnCurrentOrientation90DegreesRight()
    {
        setCurrentOrientation(getDirectionRightOf(getCurrentOrientation()));
    }

    public void turnCurrentOrientation90DegreesLeft()
    {
        setCurrentOrientation(getDirectionLeftOf(getCurrentOrientation()));
    }

    private Direction getDirectionRightOf(Direction direction)
    {
        Direction[] directions = Direction.values();
        int matchCount = 0;

        for(int i = 0; i < directions.length; i++)
        {
            if(directions[i] == direction) {
                matchCount = i;
            }
        }

        if(matchCount == 3) {
            matchCount = 0;
        } else {
            matchCount++;
        }

        return directions[matchCount];
    }

    private Direction getDirectionLeftOf(Direction direction)
    {
        Direction[] directions = Direction.values();
        int matchCount = 0;

        for(int i = 0; i < directions.length; i++)
        {
            if(directions[i] == direction) {
                matchCount = i;
            }
        }

        if(matchCount == 0) {
            matchCount = 3;
        } else {
            matchCount--;
        }

        return directions[matchCount];
    }

    public Direction getCurrentOrientation()
    {
        return currentOrientation;
    }

    public Orientation setCurrentOrientation(Direction currentOrientation)
    {
        this.currentOrientation = currentOrientation;
        return this;
    }

}
