package Event2016.Day4;

import Event2016.Helpers.Models.CharacterOccurance;
import Event2016.Helpers.StringOccuranceCounter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Room
{
    private String roomName;
    private int sectorId;
    private boolean isReal;
    private StringOccuranceCounter stringOccuranceCounter;

    public Room(String encryptedName)
    {
        sectorId = 0;
        isReal = false;
        stringOccuranceCounter = new StringOccuranceCounter();

        // Refactor this to a builder pattern for memory efficiency
        Pattern pattern = Pattern.compile("(\\D*)-(\\d*)\\[(\\w*)\\]");
        Matcher matcher = pattern.matcher(encryptedName);

        if(matcher.matches()) {
            List<CharacterOccurance> characterOccurrances = stringOccuranceCounter
                    .countCharacterOccurancesInString(matcher.group(1));
            setSectorId(Integer.valueOf(matcher.group(2)));
            setIsReal(isChecksumValid(matcher.group(3), characterOccurrances));
            setRoomName(decodeRoomName(matcher.group(1), getSectorId()));
        }
    }

    private boolean isChecksumValid(String checksum, List<CharacterOccurance> characterOccurances)
    {
        if(checksum.length() != 5) {
            return false;
        }

        for(int i = 0; i < 5; i++) {
            if(checksum.toCharArray()[i] != characterOccurances.get(i).getCharacter()) {
                return false;
            }
        }

        return true;
    }

    private String decodeRoomName(String encryptedRoomName, int amountOfRotations)
    {
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String decodedRoomName = "";

        for(char character : encryptedRoomName.toCharArray()) {
            // Dashes become spaces
            if(character == '-') {
                decodedRoomName += " ";
            } else {
                // Decode the character.
                int alphabetIndex = alphabet.indexOf(character);
                int decodedCharIndex = (alphabetIndex + amountOfRotations) % 26;

                decodedRoomName += alphabet.charAt(decodedCharIndex);
            }
        }

        return decodedRoomName;
    }

    public int getSectorId()
    {
        return sectorId;
    }

    public boolean isReal()
    {
        return isReal;
    }

    public String getRoomName()
    {
        return roomName;
    }

    private Room setSectorId(int sectorId)
    {
        this.sectorId = sectorId;
        return this;
    }

    private Room setIsReal(boolean isReal)
    {
        this.isReal = isReal;
        return this;
    }

    private Room setRoomName(String roomName)
    {
        this.roomName = roomName;
        return this;
    }

    @Override
    public String toString()
    {
        return String.format("[%d] %s", getSectorId(), getRoomName());
    }
}
