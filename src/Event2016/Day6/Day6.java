package Event2016.Day6;

import Event2016.Helpers.FileReader;
import Event2016.Helpers.LogLevel;
import Event2016.Helpers.Logger;
import Event2016.Helpers.Models.CharacterOccurance;
import Event2016.Helpers.StringOccuranceCounter;
import Event2016.Models.Day;

import java.util.*;

public class Day6 implements Day
{
    private final Logger logger;
    private final StringOccuranceCounter stringOccuranceCounter;
    private final InputSwapper inputSwapper;

    public Day6()
    {
        logger = new Logger(LogLevel.DEBUG);
        stringOccuranceCounter = new StringOccuranceCounter();
        inputSwapper = new InputSwapper();
    }

    @Override
    public void execute()
    {
        final List<String> input = FileReader.readFile("C:/Developing/AdventOfCode/src/Event2016/Day6/input");
        final List<String> swappedInput = inputSwapper.swapListOfStrings(input);

        String errorCorrectedMessage = "";
        String originalMessage = "";

        for(String item : swappedInput) {
            List<CharacterOccurance> characterOccurances = stringOccuranceCounter.countCharacterOccurancesInString(item);

            errorCorrectedMessage += characterOccurances.get(0).getCharacter();
            originalMessage += characterOccurances.get(characterOccurances.size() - 1).getCharacter();
        }

        logger.logMessage("[Part 1] Error corrected version of the message: " + errorCorrectedMessage, LogLevel.VICTORY);
        logger.logMessage("[Part 2] Original message: " + originalMessage, LogLevel.VICTORY);
    }
}
