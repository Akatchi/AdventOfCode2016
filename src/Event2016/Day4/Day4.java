package Event2016.Day4;

import Event2016.Helpers.FileReader;
import Event2016.Models.Day;

import java.util.ArrayList;
import java.util.List;

public class Day4 implements Day
{
    private List<Room> rooms;

    public void execute()
    {
        int combinedSectorId = 0;
        int northPoleSectorId = 0;
        rooms = new ArrayList<Room>();
        final List<String> input = FileReader.readFile("C:/Developing/AdventOfCode/src/Event2016/Day4/input");

        input.forEach(item -> rooms.add(new Room(item)));

        for(Room room : rooms) {
            if(room.isReal()) {
                combinedSectorId += room.getSectorId();

                if(room.getRoomName().contains("northpole")) {
                    northPoleSectorId = room.getSectorId();
                    System.out.println(room.toString());
                }
            }
        }

        System.out.println("[Part 1] Combined sector id: " + combinedSectorId);
        System.out.println("[Part 2] North Pole sector id: " + northPoleSectorId);
    }
}
