package Event2016.Day3;

import Event2016.Helpers.FileReader;
import Event2016.Models.Day;
import java.util.List;

public class Day3 implements Day
{
    public void execute()
    {
        final List<String> input = FileReader.readFile("C:/Developing/AdventOfCode/src/Event2016/Day3/input");

        System.out.println("[Part 1] Valid triangles: " + getValidTrianglesForPartOne(input));
        System.out.println("[Part 2] Valid triangles: " + getValidTrianglesForPartTwo(input));
    }

    private int getValidTrianglesForPartOne(final List<String> input)
    {
        final TriangleValidator triangleValidator = new TriangleValidator();
        int validTriangles = 0;

        for(String item : input) {
            String[] sides = item.trim().replaceAll(" +", " ").split(" ");

            if(triangleValidator.isValidTriangle(
                    Integer.valueOf(sides[0]),
                    Integer.valueOf(sides[1]),
                    Integer.valueOf(sides[2]))
            ) {
                validTriangles++;
            }
        }

        return validTriangles;
    }

    private int getValidTrianglesForPartTwo(final List<String> input)
    {
        final TriangleValidator triangleValidator = new TriangleValidator();
        int validTriangles = 0;

        for(int i = 0; i < input.size(); i += 3) {
            String[] row1 = input.get(i).trim().replaceAll(" +", " ").split(" ");
            String[] row2 = input.get(i + 1).trim().replaceAll(" +", " ").split(" ");
            String[] row3 = input.get(i + 2).trim().replaceAll(" +", " ").split(" ");

            if(triangleValidator.isValidTriangle(
                    Integer.valueOf(row1[0]),
                    Integer.valueOf(row2[0]),
                    Integer.valueOf(row3[0]))
                    ) {
                validTriangles++;
            }

            if(triangleValidator.isValidTriangle(
                    Integer.valueOf(row1[1]),
                    Integer.valueOf(row2[1]),
                    Integer.valueOf(row3[1]))
                    ) {
                validTriangles++;
            }

            if(triangleValidator.isValidTriangle(
                    Integer.valueOf(row1[2]),
                    Integer.valueOf(row2[2]),
                    Integer.valueOf(row3[2]))
                    ) {
                validTriangles++;
            }

        }

        return validTriangles;
    }
}
