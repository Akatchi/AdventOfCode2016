package Event2016.Helpers.Models;

public class CharacterOccurance implements Comparable<CharacterOccurance>
{
    private char character;
    private int count;

    public CharacterOccurance(char character, int count)
    {
        setCharacter(character);
        setCount(count);
    }

    public char getCharacter()
    {
        return character;
    }

    public int getCount()
    {
        return count;
    }

    public CharacterOccurance setCharacter(char character)
    {
        this.character = character;
        return this;
    }

    public CharacterOccurance setCount(int count)
    {
        this.count = count;
        return this;
    }

    @Override
    public int compareTo(CharacterOccurance o)
    {
        if(getCount() > o.getCount()) {
            return -1;
        } else if(getCount() < o.getCount()) {
            return 1;
        } else {
            // We are equal, so we check our alphabetical index
            final String alphabet = "abcdefghijklmnopqrstuvwxyz";

            int currentAlphabeticalIndex = alphabet.indexOf(getCharacter());
            int otherAlphabeticalIndex = alphabet.indexOf(o.getCharacter());

            if(currentAlphabeticalIndex > otherAlphabeticalIndex) {
                return 1;
            } else if(currentAlphabeticalIndex < otherAlphabeticalIndex) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public String toString()
    {
        return getCharacter() + " = " + getCount();
    }
}
