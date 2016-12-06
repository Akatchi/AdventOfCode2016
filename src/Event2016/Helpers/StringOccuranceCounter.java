package Event2016.Helpers;

import Event2016.Helpers.Models.CharacterOccurance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringOccuranceCounter
{
    public List<CharacterOccurance> countCharacterOccurancesInString(String string)
    {
        List<CharacterOccurance> characterOccurances = new ArrayList<>();
        char[] possibleCharacters = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for(int i = 0; i < possibleCharacters.length; i++) {
            characterOccurances.add(
                    new CharacterOccurance(
                            possibleCharacters[i],
                            countCharacterOccuranceInString(string, possibleCharacters[i])
                    )
            );
        }

        // Sort the array so that the first entry is the one with the most occurances
        Collections.sort(characterOccurances);

        return characterOccurances;
    }

    private int countCharacterOccuranceInString(String string, char character)
    {
        return string.length() - string.replace(String.valueOf(character), "").length();
    }
}
