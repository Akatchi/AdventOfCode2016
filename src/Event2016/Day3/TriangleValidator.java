package Event2016.Day3;

public class TriangleValidator
{
    public boolean isValidTriangle(int sideA, int sideB, int sideC)
    {
        return sideA + sideB > sideC && sideB + sideC > sideA && sideA + sideC > sideB;
    }
}
