package Event2016.Day1;

import Event2016.Helpers.FileReader;
import Event2016.Models.Day;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 implements Day
{
    private Orientation currentDirection;
    private List<Point> visitedLocations;
    private Point firstRevisitedLocation;

    public void execute()
    {
        visitedLocations = new ArrayList<>();
        final Point beginPoint = new Point(0, 0);
        Point currentPoint = new Point(0, 0);
        currentDirection = new Orientation();
        currentDirection.setCurrentOrientation(Orientation.Direction.NORTH);

        List<String> list = FileReader.readFile("C:/Developing/AdventOfCode/src/Event2016/Day1/input");
        list = Arrays.asList(list.get(0).split(", "));

        for(String item : list) {
            currentPoint = executeMove(currentPoint, item);
        }

        visitedLocations.add(beginPoint);

        int distance = calculateDistanceBetweenTwoPoints(beginPoint, currentPoint);
        int revisitedDistance = calculateDistanceBetweenTwoPoints(beginPoint, firstRevisitedLocation);

        System.out.println("[Part 1] Distance: " + distance);
        System.out.println("[Part 2] Revisited distance: " + revisitedDistance);
    }

    private int calculateDistanceBetweenTwoPoints(Point a, Point b)
    {
        int distance = 0;

        distance += Math.abs(Math.abs(a.getX()) - Math.abs(b.getX()));
        distance += Math.abs(Math.abs(a.getY()) - Math.abs(b.getY()));

        return distance;
    }

    private Point executeMove(Point currentPoint, String item)
    {
        int value = getValueFromItem(item);

        if(isMoveToRight(item)) {
            return moveRight(currentPoint, value);
        } else {
            return moveLeft(currentPoint, value);
        }
    }

    private boolean doesListContainPoint(List<Point> listWithPoints, Point pointToCheck)
    {
        List<Point> result = listWithPoints
                .stream()
                .filter(item -> (item.getX() == pointToCheck.getX() && item.getY() == pointToCheck.getY()))
                .collect(Collectors.toList());

        return result.size() > 0;
    }

    private boolean visitedLocationAlready(Point pointToCheck)
    {
        return doesListContainPoint(visitedLocations, pointToCheck);
    }

    private Point makeMove(double x, double y)
    {
        Point point = new Point();
        point.setLocation(x, y);

        if(visitedLocationAlready(point) && firstRevisitedLocation == null) {
            firstRevisitedLocation = point;
        }

        visitedLocations.add(point);

        return point;
    }

    private Point moveRight(Point currentPoint, int value)
    {
        switch(currentDirection.getCurrentOrientation())
        {
            case NORTH:
                for(int i = 0; i < value; i++) {
                    currentPoint = makeMove(currentPoint.getX() + 1, currentPoint.getY());
                }
                break;
            case EAST:
                for(int i = 0; i < value; i++) {
                    currentPoint = makeMove(currentPoint.getX(), currentPoint.getY() - 1);
                }
                break;
            case SOUTH:
                for(int i = 0; i < value; i++) {
                    currentPoint = makeMove(currentPoint.getX() - 1, currentPoint.getY());
                }
                break;
            case WEST:
                for(int i = 0; i < value; i++) {
                    currentPoint = makeMove(currentPoint.getX(), currentPoint.getY() + 1);
                }
                break;
        }

        currentDirection.turnCurrentOrientation90DegreesRight();

        return currentPoint;
    }

    private Point moveLeft(Point currentPoint, int value)
    {
        switch(currentDirection.getCurrentOrientation())
        {
            case NORTH:
                for(int i = 0; i < value; i++) {
                    currentPoint = makeMove(currentPoint.getX() - 1, currentPoint.getY());
                }
                break;
            case EAST:
                for(int i = 0; i < value; i++) {
                    currentPoint = makeMove(currentPoint.getX(), currentPoint.getY() + 1);
                }
                break;
            case SOUTH:
                for(int i = 0; i < value; i++) {
                    currentPoint = makeMove(currentPoint.getX() + 1, currentPoint.getY());
                }
                break;
            case WEST:
                for(int i = 0; i < value; i++) {
                    currentPoint = makeMove(currentPoint.getX(), currentPoint.getY() - 1);
                }
                break;
        }

        currentDirection.turnCurrentOrientation90DegreesLeft();

        return currentPoint;
    }

    private boolean isMoveToRight(String item)
    {
        return item.startsWith("R");
    }

    private int getValueFromItem(String item)
    {
        return Integer.valueOf(item.substring(1));
    }
}
