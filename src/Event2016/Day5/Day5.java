package Event2016.Day5;

import Event2016.Helpers.FileReader;
import Event2016.Helpers.LogLevel;
import Event2016.Helpers.Logger;
import Event2016.Models.Day;

public class Day5 implements Day
{
    private final Logger logger;

    public Day5()
    {
        logger = new Logger(LogLevel.INFO);
    }

    @Override
    public void execute()
    {
        final String input = FileReader.readFile("C:/Developing/AdventOfCode/src/Event2016/Day5/input").get(0);

        logger.logMessage(String.format("[Part 1] The password for part 1 is: %s", part1(input)), LogLevel.VICTORY);
        logger.logMessage(String.format("[Part 2] The password for part 2 is: %s", part2(input)), LogLevel.VICTORY);
    }

    private String part1(String input)
    {
        final StringHasher stringHasher = new StringHasher();

        String password = "";
        int counter = 0;

        while(password.length() < 8) {
            final String hash = stringHasher.getMD5HashFromInput(input + counter);

            if(isValidHash(hash)) {
                password += hash.charAt(5);
                logger.logMessage(String.format("Updated the part 1 password to: %s. (iteration: %d)",
                        password, counter), LogLevel.INFO);
            }

            counter++;
        }

        return password;
    }

    private String part2(String input)
    {
        final StringHasher stringHasher = new StringHasher();

        String password = "________";
        int counter = 0;
        int passwordUpdateCounter = 0;

        while(passwordUpdateCounter < 8) {
            final String hash = stringHasher.getMD5HashFromInput(input + counter);
            final char indexChar = hash.charAt(5);

            if(isValidHash(hash) && isValidIndexLocation(indexChar)) {
                final int index = charToInteger(indexChar);
                logger.logMessage(String.format("Password %s is ready to be updated with hash %s at index %d.",
                        password, hash, index));

                password = replaceCharAtIndexInStringIfFirstTime(password, hash.charAt(6), index);

                // If the password is updated, we will update our counter as well.
                if(password.charAt(index) == hash.charAt(6)) {
                    passwordUpdateCounter++;
                    logger.logMessage(String.format("Updated the part 2 password to: %s. (iteration: %d)",
                            password, counter), LogLevel.INFO);
                }
            }

            counter++;
        }

        return password;
    }

    private int charToInteger(char character)
    {
        return Integer.valueOf(String.valueOf(character));
    }

    private boolean isValidHash(String hash)
    {
        return hash.startsWith("00000");
    }

    private boolean isValidIndexLocation(char indexChar)
    {
        if(!isNumeric(String.valueOf(indexChar))) {
            return false;
        }

        final int index = charToInteger(indexChar);

        return index >= 0 && index <= 7;
    }

    private boolean isNumeric(String string)
    {
        return string.matches("\\d+?");
    }

    private String replaceCharAtIndexInStringIfFirstTime(String string, char toReplace, int index)
    {
        if(isFirstTimeAtIndexInPasswordString(string, index)) {
            logger.logMessage(String.format("In password %s i'm setting the character %s at index %d",
                    string, toReplace, index));
            StringBuilder newString = new StringBuilder(string);
            newString.setCharAt(index, toReplace);

            return newString.toString();
        }

        return string;
    }

    private boolean isFirstTimeAtIndexInPasswordString(String passwordString, int index)
    {
        return passwordString.charAt(index) == '_';
    }
}
